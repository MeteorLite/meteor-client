package meteor.plugins.oneclick3tfish

import eventbus.events.ClientTick
import eventbus.events.GameTick
import eventbus.events.MenuEntryAdded
import eventbus.events.MenuOptionClicked
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.ItemID
import net.runelite.api.MenuAction
import net.runelite.api.MenuEntry
import net.runelite.api.NPC
import net.runelite.api.queries.NPCQuery
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo

@PluginDescriptor(
    name = "One Click 3T Fish",
    description = "3 tick fishing made easy",
    tags = ["sundar", "pajeet"],
    enabledByDefault = false
)
class OneClick3TFishPlugin : Plugin() {

    private val config = configuration<OneClick3TFishConfig>()

    override fun onStart() {
        tick = 0
    }

    override fun onStop() {}
    var tick = 0
    var cooldown = false
    var drop = false
    var fishID = setOf(
        ItemID.LEAPING_TROUT,
        ItemID.LEAPING_SALMON,
        ItemID.LEAPING_STURGEON,
        ItemID.RAW_SALMON,
        ItemID.RAW_TROUT
    )
    var herbID = setOf(ItemID.GUAM_LEAF, ItemID.MARRENTILL, ItemID.TARROMIN, ItemID.HARRALANDER)
    var tarID = setOf(ItemID.SWAMP_TAR)
    var logID = setOf(ItemID.MAHOGANY_LOGS, ItemID.TEAK_LOGS)
    var knifeID = setOf(ItemID.KNIFE)
    var vambID = setOf(
        ItemID.LEATHER_VAMBRACES,
        ItemID.GREEN_DHIDE_VAMBRACES,
        ItemID.BLUE_DHIDE_VAMBRACES,
        ItemID.RED_DHIDE_VAMBRACES,
        ItemID.BLACK_DHIDE_VAMBRACES
    )
    var clawID = setOf(ItemID.KEBBIT_CLAWS)

    override fun onClientTick(it: ClientTick) {
        if (config.clickAnywhere()) {
            client.insertMenuItem("One Click 3t Fish", "", MenuAction.UNKNOWN.id, 0, 0, 0, false)
        }
    }
    override fun onGameTick(it: GameTick) {
        tickCooldown()
        cooldown = false
        drop = false
    }

    override fun onMenuEntryAdded(it: MenuEntryAdded) {
        if (tick < 2 || !config.flavorText() || it.target?.contains("Fishing spot") == true) {
            return
        } else if (tick == 2) {
            it.option = "Wait"
        } else if (tick == 3) {
            it.option = "Tick/Drop"
        }
        it.setModified()
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuOption()?.contains("One Click 3t Fish") == true) {
            val fishingSpot: NPC? = NPCQuery()
                .nameContains("Fishing spot")
                .result(client)
                .nearestTo(client.localPlayer)
            if (fishingSpot != null) {
                setMenuEntry(it, createFishMenuEntry(fishingSpot))
            } else {
                it.consume()
                return
            }
        }
        if (it.getMenuTarget()?.contains("Fishing spot") == true) return
        if (cooldown) {
            it.consume()
            return
        }
        if (tick == 0) tick = 1
        when (tick) {
            1 -> {
                //click on spot
                cooldown = true
                return
            }

            2 -> {
                //wait
                cooldown = true
                it.consume()
                return
            }

            3 -> {
                //tick manip
                if (drop && config.dropFish()) {
                    val dropItem = getItem(fishID)
                    if (dropItem != null) {
                        setMenuEntry(it, itemEntry(dropItem, 7))
                    } else {
                        it.consume()
                    }
                    cooldown = true
                } else {
                    tickManip(it)
                    val dropItem = getItem(fishID)
                    if (dropItem != null) {
                        drop = true
                    } else {
                        cooldown = true
                    }
                }
                return
            }
        }
    }

    private fun tickManip(it: MenuOptionClicked) {
        val highlightedItem: Widget?
        val usedItem: Widget?
        val highlightedItemID: Collection<Int>
        val usedItemID: Collection<Int>
        when (config.manipType()) {
            TickMethod.HERB_TAR -> {
                highlightedItemID = tarID
                usedItemID = herbID
            }

            TickMethod.KNIFE_LOG -> {
                highlightedItemID = knifeID
                usedItemID = logID
            }

            TickMethod.CLAW_VAMB -> {
                highlightedItemID = clawID
                usedItemID = vambID
            }

            else -> throw IllegalStateException("Unexpected value: " + config.manipType())
        }
        highlightedItem = getItem(highlightedItemID)
        usedItem = getItem(usedItemID)
        if (highlightedItem == null || usedItem == null) {
            it.consume()
            return
        }
        client.selectedSpellWidget = highlightedItem.id
        client.selectedSpellChildIndex = highlightedItem.index
        client.selectedSpellItemId = highlightedItem.itemId
        setMenuEntry(
            it, client.createMenuEntry(
                "Use",
                "Item -> Item",
                0,
                MenuAction.WIDGET_TARGET_ON_WIDGET.id,
                usedItem.index,
                WidgetInfo.INVENTORY.id,
                false
            )
        )
    }

    private fun tickCooldown() {
        if (tick == 0) return else if (tick == 3) tick = 0 else tick++
    }

    fun getItem(ids: Collection<Int>): Widget? {
        val matches: List<Widget> = getItems(ids)
        return if (matches.isNotEmpty()) matches[0] else null
    }

    fun getItems(ids: Collection<Int>): ArrayList<Widget> {
        client.runScript(6009, 9764864, 28, 1, -1)
        val inventoryWidget: Widget? = client.getWidget(WidgetInfo.INVENTORY)
        val matchedItems = ArrayList<Widget>()
        if (inventoryWidget != null && inventoryWidget.dynamicChildren != null) {
            val items = inventoryWidget.dynamicChildren
            for (item in items) {
                if (ids.contains(item.itemId)) {
                    matchedItems.add(item)
                }
            }
        }
        return matchedItems
    }

    fun itemEntry(item: Widget?, action: Int): MenuEntry? {
        return if (item == null) null else client.createMenuEntry(
            "",
            "",
            action,
            if (action < 6) MenuAction.CC_OP.id else MenuAction.CC_OP_LOW_PRIORITY.id,
            item.index,
            WidgetInfo.INVENTORY.id,
            false
        )
    }


    private fun createFishMenuEntry(fish: NPC): MenuEntry {
        return client.createMenuEntry(
            "Cast",
            "Fishing spot",
            fish.index,
            MenuAction.NPC_FIRST_OPTION.id,
            0,
            0,
            false
        )
    }

    fun createMenuEntry(
        identifier: Int,
        type: MenuAction?,
        param0: Int,
        param1: Int,
        forceLeftClick: Boolean
    ): MenuEntry {
        return client.createMenuEntry(0).setOption("").setTarget("").setIdentifier(identifier).setType(type)
            .setParam0(param0).setParam1(param1).setForceLeftClick(forceLeftClick)
    }

    private fun setMenuEntry(it: MenuOptionClicked, menuEntry: MenuEntry?) {
        it.menuEntry.identifier = menuEntry?.identifier!!
        it.menuEntry.type = menuEntry.type
        it.menuEntry.param0 = menuEntry.param0
        it.menuEntry.param1 = menuEntry.param1
    }
}
