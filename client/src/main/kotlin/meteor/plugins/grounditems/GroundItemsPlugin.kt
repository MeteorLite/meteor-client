/*
 * Copyright (c) 2017, Aria <aria@ar1as.space>
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.grounditems

import com.google.common.cache.CacheBuilder
import com.google.common.cache.LoadingCache
import com.google.common.collect.EvictingQueue
import com.google.common.collect.HashBasedTable
import com.google.common.collect.ImmutableList
import com.google.common.collect.Table
import eventbus.events.*
import meteor.Main
import meteor.game.ItemManager
import meteor.game.ItemStack
import meteor.input.KeyManager
import meteor.input.MouseManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.grounditems.GroundItem.GroundItemBuilder
import meteor.plugins.grounditems.config.HighlightTier
import meteor.plugins.grounditems.config.ItemHighlightMode
import meteor.plugins.grounditems.config.MenuHighlightMode
import meteor.plugins.grounditems.config.ValueCalculationMode
import meteor.rs.ClientThread
import meteor.util.ColorUtil.prependColorTag
import meteor.util.ColorUtil.wrapWithColorTag
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import net.runelite.api.util.Text
import net.runelite.client.plugins.grounditems.Lootbeam
import java.awt.Color
import java.awt.Rectangle
import java.time.Instant
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit


@PluginDescriptor(
    name = "Ground Items",
    description = "Highlight ground items and/or show price information",
    tags = ["grand", "exchange", "high", "alchemy", "prices", "highlight", "overlay"],
    configGroup = "grounditems"
)
class GroundItemsPlugin : Plugin() {
    internal class PriceHighlight(val price: Int, val color: Color)

    val config = configuration<GroundItemsConfig>()
    var textBoxBounds: Map.Entry<Rectangle, GroundItem>? = null
    var hiddenBoxBounds: Map.Entry<Rectangle, GroundItem>? = null
    var highlightBoxBounds: Map.Entry<Rectangle, GroundItem>? = null
    var hotKeyPressed = false
    var hideAll = false
    private var hiddenItemList: List<String?>? = CopyOnWriteArrayList()
    var highlightedItemsList: List<String?>? = CopyOnWriteArrayList()

    private val inputListener: GroundItemInputListener = GroundItemInputListener(this, config)
    private val mouseManager: MouseManager = MouseManager
    private val keyManager: KeyManager = KeyManager
    private val clientThread: ClientThread = ClientThread
    private val itemManager: ItemManager = ItemManager
    private val overlay = overlay(GroundItemsOverlay(this, config))
    private val executor: ScheduledExecutorService = Main.executor
    private var priceChecks: List<PriceHighlight> = ImmutableList.of()
    private var highlightedItems: LoadingCache<NamedQuantity, Boolean>? = null
    private var hiddenItems: LoadingCache<NamedQuantity, Boolean>? = null
    private val droppedItemQueue: Queue<Int> = EvictingQueue.create(16) // recently dropped items
    private var lastUsedItem = 0
    private val lootbeams: MutableMap<WorldPoint, Lootbeam> = HashMap()

    override fun onStart() {
        mouseManager.registerMouseListener(inputListener)
        keyManager.registerKeyListener(inputListener, javaClass)
        executor.execute { reset() }
        lastUsedItem = -1
    }

    override fun onStop() {
        mouseManager.unregisterMouseListener(inputListener)
        keyManager.unregisterKeyListener(inputListener)
        highlightedItems?.invalidateAll()
        highlightedItems = null
        hiddenItems?.invalidateAll()
        hiddenItems = null
        hiddenItemList = null
        highlightedItemsList = null
        collectedGroundItems.clear()
        clientThread.invokeLater { removeAllLootbeams() }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == "grounditems") {
            executor.execute { reset() }
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOADING) {
            collectedGroundItems.clear()
            lootbeams.clear()
        }
    }

    override fun onItemSpawned(it: ItemSpawned) {
        val item = it.item
        val tile = it.tile
        val groundItem = buildGroundItem(tile, item)
        val existing = collectedGroundItems[tile.worldLocation, item.id]
        if (existing != null) {
            existing.quantity = existing.quantity + groundItem.quantity
            // The spawn time remains set at the oldest spawn
        } else {
            collectedGroundItems.put(tile.worldLocation, item.id, groundItem)
        }
        handleLootbeam(tile.worldLocation)
    }

    override fun onItemDespawned(it: ItemDespawned) {
        val item = it.item
        val tile = it.tile
        val groundItem = collectedGroundItems[tile.worldLocation, item.id]
        if (groundItem != null) {
            if (groundItem.quantity <= item.quantity) {
                collectedGroundItems.remove(tile.worldLocation, item.id)
            } else {
                groundItem.quantity = groundItem.quantity - item.quantity
                // When picking up an item when multiple stacks appear on the ground,
                // it is not known which item is picked up, so we invalidate the spawn
                // time
                groundItem.spawnTime = null
            }
            handleLootbeam(tile.worldLocation)
        }
    }

    override fun onItemQuantityChanged(it: ItemQuantityChanged) {
        val item = it.item
        val tile = it.tile
        val oldQuantity = it.oldQuantity
        val newQuantity = it.newQuantity
        val diff = newQuantity - oldQuantity
        val groundItem = collectedGroundItems[tile.worldLocation, item.id]
        if (groundItem != null) {
            groundItem.quantity = groundItem.quantity + diff
        }
        handleLootbeam(tile.worldLocation)
    }

/*    @Subscribe
    fun onNpcLootReceived(npcLootReceived: NpcLootReceived) {
        val items: Collection<ItemStack> = npcLootReceived.getItems()
        lootReceived(items, LootType.PVM)
    }

    @Subscribe
    fun onPlayerLootReceived(playerLootReceived: PlayerLootReceived) {
        val items: Collection<ItemStack> = playerLootReceived.getItems()
        lootReceived(items, LootType.PVP)
    }*/

    override fun onClientTick(it: ClientTick) {
        if (config.collapseEntries()) {
            val menuEntries = client.menuEntries
            val sizeFilteredEntries: MutableList<MenuEntryWithCount?> = ArrayList(menuEntries.size)
            outer@ for (i in menuEntries.indices.reversed()) {
                val menuEntry = menuEntries[i]
                val menuType = menuEntry.type
                if (menuType.id == FIRST_OPTION || menuType.id == SECOND_OPTION || menuType.id == THIRD_OPTION || menuType.id == FOURTH_OPTION || menuType.id == FIFTH_OPTION || menuType.id == EXAMINE_ITEM) {
                    for (entryWCount in sizeFilteredEntries) {
                        if (entryWCount!!.entry == menuEntry) {
                            entryWCount.increment()
                            continue@outer
                        }
                    }
                }
                sizeFilteredEntries.add(MenuEntryWithCount(menuEntry))
            }
            sizeFilteredEntries.reverse()
            val newEntries = ArrayList<MenuEntry>()
            sizeFilteredEntries.forEach {
                val entry = it!!.entry
                val count = it.count
                if (count > 1) {
                    entry.target = entry.target + " x " + count
                }
                newEntries.add(entry)
            }
            client.menuEntries = newEntries.toArray(emptyArray())
        }
    }

    private fun lootReceived(items: Collection<ItemStack>, lootType: LootType) {
        for (itemStack in items) {
            val location = WorldPoint.fromLocal(client, itemStack.location)
            val groundItem = collectedGroundItems[location, itemStack.id]
            if (groundItem != null) {
                groundItem.lootType = lootType
            }
        }

        // Since the loot can potentially be over multiple tiles, make sure to process lootbeams on all those tiles
        items.stream()
            .map<LocalPoint>(ItemStack::location)
            .map { l: LocalPoint? -> WorldPoint.fromLocal(client, l) }
            .distinct()
            .forEach { worldPoint: WorldPoint -> handleLootbeam(worldPoint) }
    }

    private fun buildGroundItem(tile: Tile, item: TileItem): GroundItem {
        // Collect the data for the item
        val itemId = item.id
        val itemComposition = itemManager.getItemComposition(itemId)
        val realItemId = if (itemComposition!!.note != -1) itemComposition.linkedNoteId else itemId
        val alchPrice = itemComposition.haPrice
        val dropped = tile.worldLocation == client.localPlayer!!.worldLocation && droppedItemQueue.remove(itemId)
        val table = itemId == lastUsedItem && tile.itemLayer.height > 0
        val groundItem = GroundItemBuilder().builder()
            .id(itemId)
            .location(tile.worldLocation)
            .itemId(realItemId)
            .quantity(item.quantity)
            .name(itemComposition.name)
            .haPrice(alchPrice)
            .height(tile.itemLayer.height)
            .tradeable(itemComposition.isTradeable)
            .lootType(if (dropped) LootType.DROPPED else if (table) LootType.TABLE else LootType.UNKNOWN)
            .spawnTime(Instant.now())
            .stackable(itemComposition.isStackable)
            .build()

        // Update item price in case it is coins
        if (realItemId == COINS) {
            groundItem.haPrice = 1
            groundItem.gePrice = 1
        } else {
            groundItem.gePrice = itemManager.getItemPrice(realItemId)
        }
        return groundItem
    }

    private fun reset() {
        // gets the hidden items from the text box in the config
        hiddenItemList = Text.fromCSV(config.hiddenItems())

        // gets the highlighted items from the text box in the config
        highlightedItemsList = Text.fromCSV(config.highlightedItems())
        highlightedItems = CacheBuilder.newBuilder()
            .maximumSize(512L)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .build(WildcardMatchLoader(highlightedItemsList!!))
        hiddenItems = CacheBuilder.newBuilder()
            .maximumSize(512L)
            .expireAfterAccess(10, TimeUnit.MINUTES)
            .build(WildcardMatchLoader(hiddenItemList!!))

        // Cache colors
        val priceCheckBuilder = ImmutableList.builder<PriceHighlight>()
        if (config.insaneValuePrice() > 0) {
            priceCheckBuilder.add(PriceHighlight(config.insaneValuePrice(), config.insaneValueColor()!!))
        }
        if (config.highValuePrice() > 0) {
            priceCheckBuilder.add(PriceHighlight(config.highValuePrice(), config.highValueColor()!!))
        }
        if (config.mediumValuePrice() > 0) {
            priceCheckBuilder.add(PriceHighlight(config.mediumValuePrice(), config.mediumValueColor()!!))
        }
        if (config.lowValuePrice() > 0) {
            priceCheckBuilder.add(PriceHighlight(config.lowValuePrice(), config.lowValueColor()!!))
        }
        priceChecks = priceCheckBuilder.build()
        clientThread.invokeLater { handleLootbeams() }
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        if (config.itemHighlightMode() == ItemHighlightMode.MENU || config.itemHighlightMode() == ItemHighlightMode.BOTH) {
            val telegrabEntry =
                it.option == "Cast" && it.target!!.startsWith(TELEGRAB_TEXT) && it.opcode == CAST_ON_ITEM
            if ((it.option == "Take" && it.opcode == THIRD_OPTION) || telegrabEntry) {
                val itemId = it.identifier
                val sceneX = it.param0
                val sceneY = it.param1
                val menuEntries = client.menuEntries
                val lastEntry = menuEntries[menuEntries.size - 1]
                val worldPoint = WorldPoint.fromScene(client, sceneX, sceneY, client.plane)
                val groundItem: GroundItem? = collectedGroundItems[worldPoint, itemId]
                groundItem?.let {
                    val quantity = groundItem.quantity
                    val gePrice = groundItem.gePrice
                    val haPrice = groundItem.haPrice
                    val hidden =
                        getHidden(NamedQuantity(groundItem.name!!, quantity), gePrice, haPrice, groundItem.tradeable)
                    val highlighted = getHighlighted(NamedQuantity(groundItem.name!!, quantity), gePrice, haPrice)
                    val color = getItemColor(highlighted, hidden)
                    val canBeRecolored = highlighted != null || hidden != null && config.recolorMenuHiddenItems()
                    if (color != null && canBeRecolored && color != config.defaultColor()) {
                        val mode = config.menuHighlightMode()
                        if (mode == MenuHighlightMode.BOTH || mode == MenuHighlightMode.OPTION) {
                            val optionText = if (telegrabEntry) "Cast" else "Take"
                            lastEntry.option = prependColorTag(optionText, color)
                        }
                        if (mode == MenuHighlightMode.BOTH || mode == MenuHighlightMode.NAME) {
                            var target = lastEntry.target
                            if (telegrabEntry) {
                                target = target.substring(TELEGRAB_TEXT.length)
                            }
                            target = prependColorTag(target.substring(target.indexOf('>') + 1), color)
                            if (telegrabEntry) {
                                target = TELEGRAB_TEXT + target
                            }
                            lastEntry.target = target
                        }
                    }
                    if (config.showMenuItemQuantities() && groundItem.stackable && quantity > 1) {
                        lastEntry.target = lastEntry.target + " (" + quantity + ")"
                    }
                    client.menuEntries = menuEntries
                }
            }
        }
    }

    fun updateList(item: String, hiddenList: Boolean) {
        val hiddenItemSet: MutableList<String?> = ArrayList(hiddenItemList)
        val highlightedItemSet: MutableList<String?> = ArrayList(highlightedItemsList)
        if (hiddenList) {
            highlightedItemSet.removeIf { anotherString: String? -> item.equals(anotherString, ignoreCase = true) }
        } else {
            hiddenItemSet.removeIf { anotherString: String? -> item.equals(anotherString, ignoreCase = true) }
        }
        val items = if (hiddenList) hiddenItemSet else highlightedItemSet
        if (!items.removeIf { anotherString: String? -> item.equals(anotherString, ignoreCase = true) }) {
            items.add(item)
        }
        config.setHiddenItems(Text.toCSV(hiddenItemSet))
        config.setHighlightedItem(Text.toCSV(highlightedItemSet))
    }

    fun getHighlighted(item: NamedQuantity, gePrice: Int, haPrice: Int): Color? {
        if (true == highlightedItems!!.getUnchecked(item)) {
            return config.highlightedColor()
        }

        // Explicit hide takes priority over implicit highlight
        if (true == hiddenItems!!.getUnchecked(item)) {
            return null
        }
        val price = getValueByMode(gePrice, haPrice)
        for (highlight in priceChecks) {
            if (price > highlight.price) {
                return highlight.color
            }
        }
        return null
    }

    fun getHidden(item: NamedQuantity, gePrice: Int, haPrice: Int, isTradeable: Boolean): Color? {
        val isExplicitHidden = true == hiddenItems!!.getUnchecked(item)
        val isExplicitHighlight = true == highlightedItems!!.getUnchecked(item)
        val canBeHidden = gePrice > 0 || isTradeable || !config.dontHideUntradeables()
        val underGe = gePrice < config.hideUnderValue
        val underHa = haPrice < config.hideUnderValue

        // Explicit highlight takes priority over implicit hide
        return if (isExplicitHidden || !isExplicitHighlight && canBeHidden && underGe && underHa) config.hiddenColor() else null
    }

    fun getItemColor(highlighted: Color?, hidden: Color?): Color? {
        return highlighted ?: (hidden ?: config.defaultColor())
    }


    override fun onFocusChanged(it: FocusChanged) {
        if (!it.focused) {
            hotKeyPressed = (false)
        }
    }

    private fun getValueByMode(gePrice: Int, haPrice: Int): Int {
        return when (config.valueCalculationMode()) {
            ValueCalculationMode.GE -> gePrice
            ValueCalculationMode.HA -> haPrice
            else -> Math.max(gePrice, haPrice)
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuAction() == MenuAction.ITEM_FIFTH_OPTION) {
            val itemId = it.getId()
            // Keep a queue of recently dropped items to better detect
            // item spawns that are drops
            droppedItemQueue.add(itemId)
        } else if (it.getMenuAction() == MenuAction.ITEM_USE_ON_GAME_OBJECT) {
            val i = client.getItemContainer(InventoryID.INVENTORY)?.getItem(it.selectedItemIndex)
            if (i != null)
                lastUsedItem = i.id
        }
    }

    private fun handleLootbeam(worldPoint: WorldPoint) {
        /*
		 * Return and remove the lootbeam from this location if lootbeam are disabled
		 * Lootbeam can be at this location if the config was just changed
		 */
        if (!(config.showLootbeamForHighlighted() || config.showLootbeamTier() != HighlightTier.OFF)) {
            removeLootbeam(worldPoint)
            return
        }
        var price = -1
        val groundItems: Collection<GroundItem> = collectedGroundItems.row(worldPoint).values
        for (groundItem in groundItems) {
            if (config.onlyShowLoot() && !groundItem.isMine) {
                continue
            }

            /*
			 * highlighted items have the highest priority so if an item is highlighted at this location
			 * we can early return
			 */
            val item = NamedQuantity(groundItem.name!!)
            if (config.showLootbeamForHighlighted()
                && true == highlightedItems!!.getUnchecked(item)
            ) {
                addLootbeam(worldPoint, config.highlightedColor()!!)
                return
            }

            // Explicit hide takes priority over implicit highlight
            if (true == hiddenItems!!.getUnchecked(item)) {
                continue
            }
            val itemPrice = getValueByMode(groundItem.gePrice, groundItem.haPrice)
            price = Math.max(itemPrice, price)
        }
        if (config.showLootbeamTier() != HighlightTier.OFF) {
            for (highlight in priceChecks) {
                if (price > highlight.price && price > config.showLootbeamTier().getValueFromTier(config)) {
                    addLootbeam(worldPoint, highlight.color)
                    return
                }
            }
        }
        removeLootbeam(worldPoint)
    }

    private fun handleLootbeams() {
        for (worldPoint in collectedGroundItems.rowKeySet()) {
            handleLootbeam(worldPoint)
        }
    }

    private fun removeAllLootbeams() {
        for (lootbeam in lootbeams.values) {
            lootbeam.remove()
        }
        lootbeams.clear()
    }

    private fun addLootbeam(worldPoint: WorldPoint, color: Color) {
        var lootbeam = lootbeams[worldPoint]
        if (lootbeam == null) {
            lootbeam = Lootbeam(client, clientThread, worldPoint, color, config.lootbeamStyle())
            lootbeams[worldPoint] = lootbeam
        } else {
            lootbeam.setColor(color)
            lootbeam.setStyle(config.lootbeamStyle())
        }
    }

    private fun removeLootbeam(worldPoint: WorldPoint) {
        val lootbeam = lootbeams.remove(worldPoint)
        lootbeam?.remove()
    }

    companion object {
        // The game won't send anything higher than this value to the plugin -
        // so we replace any item quantity higher with "Lots" instead.
        const val MAX_QUANTITY = 65535

        // ItemID for coins
        private const val COINS = ItemID.COINS_995

        // Ground item menu options
        private val FIRST_OPTION = MenuAction.GROUND_ITEM_FIRST_OPTION.id
        private val SECOND_OPTION = MenuAction.GROUND_ITEM_SECOND_OPTION.id
        private val THIRD_OPTION = MenuAction.GROUND_ITEM_THIRD_OPTION.id // this is Take
        private val FOURTH_OPTION = MenuAction.GROUND_ITEM_FOURTH_OPTION.id
        private val FIFTH_OPTION = MenuAction.GROUND_ITEM_FIFTH_OPTION.id
        private val EXAMINE_ITEM = MenuAction.EXAMINE_ITEM_GROUND.id
        private val CAST_ON_ITEM = MenuAction.WIDGET_TARGET_ON_GROUND_ITEM.id
        private val TELEGRAB_TEXT =
            wrapWithColorTag("Telekinetic Grab", Color.GREEN) + prependColorTag(" -> ", Color.WHITE)

        val collectedGroundItems: Table<WorldPoint, Int, GroundItem> = HashBasedTable.create()
    }
}