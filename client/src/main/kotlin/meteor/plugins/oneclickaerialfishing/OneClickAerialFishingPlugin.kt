package meteor.plugins.oneclickaerialfishing

import eventbus.events.ClientTick
import eventbus.events.MenuOptionClicked
import meteor.api.items.Items
import meteor.api.npcs.NPCs
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.widgets.WidgetInfo

@PluginDescriptor(
    name = "One Click Aerial Fishing",
    description = "Ensure some form of bait is in invent, either worms or fish chunks and a knife. If there's no knife it will just drop the fish.",
    tags = ["one", "click", "tench", "fishing", "aerial", "arial"],
    enabledByDefault = false
)
class OneClickAerialFishingPlugin : Plugin() {

    private val fishIds = mutableListOf(22826, 22829, 22832, 22835)
    private var shouldCut = false

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
            text,
            "" ,
            MenuAction.UNKNOWN.id,
            0,
            0,
            0,
            true
        )
    }

    private fun handleClick(it: MenuOptionClicked) {
        if( Items.inventoryContains(ItemID.KING_WORM)  || Items.inventoryContains(ItemID.FISH_CHUNKS) //if bait exists

        ) {
            it.menuEntry = (catchFishMenuEntry())
            return
        }

        fishIds.forEach { fish ->
            if (Items.inventoryContains(fish)) {
                if (!Items.inventoryContains("Knife")) {
                    it.menuEntry = (dropFishMenuEntry(Items.getFirst(fish)))
                    return
                }
                client.selectedSpellWidget = WidgetInfo.INVENTORY.id
                client.selectedSpellChildIndex = Items.getFirst(ItemID.KNIFE)!!.slot
                client.selectedSpellItemId = ItemID.KNIFE
                it.menuEntry = (useKnifeOnFishMenuEntry(Items.getFirst(fish)))
                return
            }
        }
        shouldCut = false
    }

    private fun useKnifeOnFishMenuEntry(it: Item?): MenuEntry {
        return createMenuEntry(
            0,
            MenuAction.WIDGET_TARGET_ON_WIDGET,
            it!!.slot,
            9764864,
            false
        )
    }

    private fun dropFishMenuEntry(it: Item?): MenuEntry {
        return createMenuEntry(
            7,
            MenuAction.CC_OP_LOW_PRIORITY,
            it!!.slot,
            9764864,
            false
        )
    }

    private fun catchFishMenuEntry(): MenuEntry {
        val fishingSpot = NPCs.getFirst(NpcID.FISHING_SPOT_8523)
        return createMenuEntry(
            fishingSpot!!.index,
            MenuAction.NPC_FIRST_OPTION,
            fishingSpot.worldLocation.x,
            fishingSpot.worldLocation.y,
            true
        )
    }

    fun createMenuEntry(
        identifier: Int,
        type: MenuAction?,
        param0: Int,
        param1: Int,
        forceLeftClick: Boolean
    ): MenuEntry {
        return client.createMenuEntry(0)
            .setOption("")
            .setTarget("")
            .setIdentifier(identifier)
            .setType(type)
            .setParam0(param0)
            .setParam1(param1)
            .setForceLeftClick(forceLeftClick)
    }

}