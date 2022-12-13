/*
 * Copyright (c) 2019, jkybtw <https://github.com/jkybtw>
 * Copyright (c) 2019, openosrs <https://openosrs.com>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
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
package meteor.plugins.oneclicksandstone

import eventbus.events.ClientTick
import eventbus.events.MenuOptionClicked
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.coords.WorldArea
import net.runelite.api.coords.WorldPoint
import net.runelite.api.queries.GameObjectQuery
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo

@PluginDescriptor(
    name = "One Click Sandstone",
    enabledByDefault = false,
    description = "Mines Sand, deposits into grinder and casts humidify if needed. Hardcoded to consume clicks with rune pickaxe or dragon pickaxe. credit TP"
)
class OneClickSandstonePlugin : Plugin() {

    private val config = configuration<OneClickSandstoneConfig>()


    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuOption().equals("<col=00ff00>One Click Sandstone")) handleClick(it)
    }


    override  fun onClientTick(it: ClientTick) {
        if (client.localPlayer == null || client.gameState != GameState.LOGGED_IN) return
        val text = "<col=00ff00>One Click Sandstone"
        client.insertMenuItem(
            text, "", MenuAction.UNKNOWN
                .id, 0, 0, 0, true
        )
    }

    private fun handleClick(event: MenuOptionClicked) {
        if ((client.localPlayer!!.isMoving
                    || (client.localPlayer!!.poseAnimation
                    != client.localPlayer!!.idlePoseAnimation) || client.localPlayer!!.animation == AnimationID.MINING_RUNE_PICKAXE) || client.localPlayer!!.animation == AnimationID.MINING_DRAGON_PICKAXE
        ) {
            event.consume()
        }
        if (emptySlots == 0) {
            event.menuEntry = depositGrinderMenuEntry()
            return
        }
        if (shouldCastHumidify()) {
            event.menuEntry = createHumidifyMenuEntry()
            return
        }
        event.menuEntry = mineSandStone()
    }

    private fun getLocation(gameObject: GameObject): Point {
        return Point(
            gameObject.localLocation.sceneX,
            gameObject.localLocation.sceneY
        )
    }

    private fun checkforGameObject(): GameObject? {
        val SW = WorldPoint(3164, 2913, 0)
        val NE = WorldPoint(3168, 2916, 0)
        val AREA = WorldArea(SW, NE)
        if (config.forceMineNorth()) {
            val list: ArrayList<GameObject> = GameObjectQuery()
                .idEquals(11386)
                .result(client).list
            for (item in list) {
                if (item.worldLocation.isInArea(AREA)) {
                    return item
                }
            }
        }
        return GameObjectQuery()
            .idEquals(11386)
            .result(client)
            .nearestTo(client.localPlayer)
    }

    private fun checkForDepositGrinder(): GameObject? {
        return GameObjectQuery()
            .idEquals(26199)
            .result(client)
            .nearestTo(client.localPlayer)
    }

    private val emptySlots: Int
            get() {
            val inventory: Widget? = client.getWidget(WidgetInfo.INVENTORY.id)
            val bankInventory: Widget? = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.id)
            if (inventory != null && !inventory.isHidden && inventory.dynamicChildren != null) {
                val inventoryItems =
                    client.getWidget(WidgetInfo.INVENTORY.id)?.let { listOf<Widget>(*it.dynamicChildren) }
                if (inventoryItems != null) {
                    return inventoryItems.count { item: Widget -> item.itemId == 6512 }
                }
            }
            if (bankInventory != null && !bankInventory.isHidden && bankInventory.dynamicChildren != null) {
                val inventoryItems = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER.id)?.let {
                    listOf<Widget>(
                        *it.dynamicChildren
                    )
                }
                if (inventoryItems != null) {
                    return inventoryItems.count { item: Widget -> item.itemId == 6512 }
                }
            }
            return -1
        }

    private fun mineSandStone(): MenuEntry {
        val customGameObject = checkforGameObject()
        return createMenuEntry(
            11386,
            MenuAction.GAME_OBJECT_FIRST_OPTION,
            getLocation(customGameObject!!).x,
            getLocation(customGameObject).y,
            true
        )
    }

    private fun createHumidifyMenuEntry(): MenuEntry {
        return createMenuEntry(
            1,
            MenuAction.CC_OP,
            -1,
            WidgetInfo.SPELL_HUMIDIFY.id,
            true
        )
    }

    private fun depositGrinderMenuEntry(): MenuEntry {
        return createMenuEntry(
            26199,
            MenuAction.GAME_OBJECT_FIRST_OPTION,
            checkForDepositGrinder()!!.sceneMinLocation.x,
            checkForDepositGrinder()!!.sceneMinLocation.y, true
        )
    }

    private fun shouldCastHumidify(): Boolean {
        if (!config.humidify()) return false
        val waterskins = setOf<Int>(ItemID.WATERSKIN4, ItemID.WATERSKIN3, ItemID.WATERSKIN2, ItemID.WATERSKIN1)
        for (waterskin in waterskins) {
            if (getInventoryItem(waterskin) != null) {
                return false
            }
        }
        return true
    }

    private fun getInventoryItem(id: Int): Widget? {
        val inventoryWidget: Widget? = client.getWidget(WidgetInfo.INVENTORY)
        val bankInventoryWidget: Widget? = client.getWidget(WidgetInfo.BANK_INVENTORY_ITEMS_CONTAINER)
        if (inventoryWidget != null && !inventoryWidget.isHidden) {
            return getWidgetItem(inventoryWidget, id)
        }
        return if (bankInventoryWidget != null && !bankInventoryWidget.isHidden) {
            getWidgetItem(bankInventoryWidget, id)
        } else null
    }

    private fun getWidgetItem(widget: Widget, id: Int): Widget? {
        for (item in widget.dynamicChildren) {
            if (item.itemId == id) {
                return item
            }
        }
        return null
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
}