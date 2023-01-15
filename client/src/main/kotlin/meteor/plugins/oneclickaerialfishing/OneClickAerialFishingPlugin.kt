package meteor.plugins.oneclickaerialfishing

import eventbus.events.ClientTick
import eventbus.events.MenuOptionClicked
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.queries.NPCQuery
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.util.*

@PluginDescriptor(
    name = "One Click Aerial Fishing",
    description = "Ensure some form of bait is in invent, either worms or fish chunks and a knife. If there's no knife it will just drop the fish.",
    tags = ["one", "click", "tench", "fishing", "aerial", "arial"],
    enabledByDefault = false
)
class OneClickAerialFishingPlugin : Plugin() {
    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuOption().equals("<col=00ff00>One Click Aerial Fishing")) {
            handleClick(it)
        }
    }
    override fun onClientTick(it: ClientTick) {
        if (client.localPlayer == null || client.gameState != GameState.LOGGED_IN) {
            return
        }
        val text = "<col=00ff00>One Click Aerial Fishing"
        client.insertMenuItem(
            text, "", MenuAction.UNKNOWN
                .id, 0, 0, 0, true
        )
    }

    private fun handleClick(it: MenuOptionClicked) {
        if (emptySlots > 0 && (getLastInventoryItem(ItemID.KING_WORM) != null || getLastInventoryItem(ItemID.FISH_CHUNKS) != null) //if bait exists
            && !shouldCut
        ) {
            it.menuEntry = (catchFishMenuEntry())
            return
        } else {
            shouldCut = true
        }
        //if space in inventory then fish, else cut // add check for bait!
        for (fish in LIST_OF_FISH_IDS) {
            if (getLastInventoryItem(fish) != null) {
                if (getLastInventoryItem(ItemID.KNIFE) == null) {
                    it.menuEntry = (dropFishMenuEntry(getLastInventoryItem(fish)))
                    return
                }
                client.selectedSpellWidget = WidgetInfo.INVENTORY.id
                client.selectedSpellChildIndex = getLastInventoryItem(ItemID.KNIFE)!!.index
                client.selectedSpellItemId = ItemID.KNIFE
                it.menuEntry = (useKnifeOnFishMenuEntry(getLastInventoryItem(fish)))
                return
            }
        }
        shouldCut = false
    }

    private fun getLastInventoryItem(it: Int): Widget? {
        val inventoryWidget: Widget? = client.getWidget(WidgetInfo.INVENTORY)
        return if (inventoryWidget != null && !inventoryWidget.isHidden) {
            getLastWidgetItem(inventoryWidget, it)
        } else null
    }

    private fun getLastWidgetItem(it: Widget, id: Int): Widget? {
        return Arrays.stream(it.dynamicChildren)
            .filter { item: Widget? -> item!!.itemId == id }
            .reduce { first: Widget?, second: Widget? -> second }
            .orElse(null)
    }

    private val emptySlots: Int
        get() {
            val inventory: Widget? = client.getWidget(WidgetInfo.INVENTORY.id)
            val bankInventory: Widget? = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.id)
            if (inventory != null && !inventory.isHidden && inventory.dynamicChildren != null) {
                val inventoryItems =
                    Arrays.asList<Widget>(*client.getWidget(WidgetInfo.INVENTORY.id)?.dynamicChildren)
                return inventoryItems.stream().filter { item: Widget -> item.itemId == 6512 }.count().toInt()
            }
            if (bankInventory != null && !bankInventory.isHidden && bankInventory.dynamicChildren != null) {
                val inventoryItems = Arrays.asList<Widget>(
                    *client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.id)?.dynamicChildren
                )
                return inventoryItems.stream().filter { item: Widget -> item.itemId == 6512 }.count().toInt()
            }
            return -1
        }

    private fun useKnifeOnFishMenuEntry(it: Widget?): MenuEntry {
        return createMenuEntry(
            0,
            MenuAction.WIDGET_TARGET_ON_WIDGET,
            it!!.index,
            9764864,
            false
        )
    }

    private fun dropFishMenuEntry(it: Widget?): MenuEntry {
        return createMenuEntry(
            7,
            MenuAction.CC_OP_LOW_PRIORITY,
            it!!.index,
            9764864,
            false
        )
    }

    private fun catchFishMenuEntry(): MenuEntry {
        val FishingSpot = fishingSpot
        return createMenuEntry(
            FishingSpot!!.index,
            MenuAction.NPC_FIRST_OPTION,
            getNPCLocation(FishingSpot).x,
            getNPCLocation(FishingSpot).y,
            true
        )
    }

    private val fishingSpot: NPC?
        get() = NPCQuery()
            .idEquals(TENCH_FISHING_SPOT_NPC_ID)
            .result(client)
            .nearestTo(client.localPlayer)

    private fun getNPCLocation(npc: NPC): Point {
        return Point(npc.localLocation.sceneX, npc.localLocation.sceneY)
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

    private fun printLineNumber() {
        println("LINE - " + Thread.currentThread().stackTrace[2].lineNumber)
    }

    companion object {
        private const val TENCH_FISHING_SPOT_NPC_ID = 8523
        private val LIST_OF_FISH_IDS: List<Int> = mutableListOf(22826, 22829, 22832, 22835)
        private var shouldCut = false
    }
}