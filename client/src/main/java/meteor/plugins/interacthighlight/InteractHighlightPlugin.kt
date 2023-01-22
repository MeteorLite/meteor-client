/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package meteor.plugins.interacthighlight

import eventbus.events.*
import lombok.AccessLevel
import lombok.Getter
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo

@Suppress("DEPRECATION")
@PluginDescriptor(
    name = "Interact Highlight",
    description = "Outlines npcs and objects you interact with or hover over",
    enabledByDefault = false
)
class InteractHighlightPlugin : Plugin() {
    val config: InteractHighlightConfig = configuration()
    private val interactHighlightOverlay = overlay(InteractHighlightOverlay(this))

    @Getter(AccessLevel.PACKAGE)
    var interactedObject: TileObject? = null
    private var interactedNpc: NPC? = null

    @Getter(AccessLevel.PACKAGE)
    var attacked = false
    private var clickTick = 0

    @Getter(AccessLevel.PACKAGE)
    var gameCycle = 0
    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gameState == GameState.LOADING) {
            interactedObject = null
        }
    }

    override fun onNpcDespawned(it: NpcDespawned) {
        if (it.npc === interactedNpc) {
            interactedNpc = null
        }
    }

    override fun onGameTick(it: GameTick) {
        if (client.tickCount > clickTick && client.localDestinationLocation == null) {
            // when the destination is reached, clear the interacting object
            interactedObject = null
            interactedNpc = null
        }
    }

    override fun onInteractingChanged(it: InteractingChanged) {
        if (it.source === client.localPlayer && client.tickCount > clickTick && it.target !== interactedNpc) {
            interactedNpc = null
            attacked = it.target != null && it.target!!.combatLevel > 0
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        when (it.getMenuAction()) {
            MenuAction.ITEM_USE_ON_GAME_OBJECT, MenuAction.WIDGET_TARGET_ON_GAME_OBJECT, MenuAction.GAME_OBJECT_FIRST_OPTION, MenuAction.GAME_OBJECT_SECOND_OPTION, MenuAction.GAME_OBJECT_THIRD_OPTION, MenuAction.GAME_OBJECT_FOURTH_OPTION, MenuAction.GAME_OBJECT_FIFTH_OPTION -> {
                val x = it.getParam0()
                val y = it.getParam1()
                val id = it.getId()
                interactedObject = findTileObject(x, y, id)
                interactedNpc = null
                clickTick = client.tickCount
                gameCycle = client.gameCycle
            }
            MenuAction.ITEM_USE_ON_NPC, MenuAction.WIDGET_TARGET_ON_NPC, MenuAction.NPC_FIRST_OPTION, MenuAction.NPC_SECOND_OPTION, MenuAction.NPC_THIRD_OPTION, MenuAction.NPC_FOURTH_OPTION, MenuAction.NPC_FIFTH_OPTION -> {
                val id = it.getId()
                interactedObject = null
                interactedNpc = findNpc(id)
                attacked = it.getMenuAction() == MenuAction.NPC_SECOND_OPTION ||
                        it.getMenuAction() == MenuAction.WIDGET_TARGET_ON_NPC && WidgetInfo.TO_GROUP(
                    client.selectedWidget!!.id
                ) == WidgetID.SPELLBOOK_GROUP_ID
                clickTick = client.tickCount
                gameCycle = client.gameCycle
            }
            MenuAction.WALK, MenuAction.ITEM_USE, MenuAction.WIDGET_TARGET_ON_WIDGET, MenuAction.ITEM_USE_ON_GROUND_ITEM, MenuAction.WIDGET_TARGET_ON_GROUND_ITEM, MenuAction.ITEM_USE_ON_PLAYER, MenuAction.WIDGET_TARGET_ON_PLAYER, MenuAction.ITEM_FIRST_OPTION, MenuAction.ITEM_SECOND_OPTION, MenuAction.ITEM_THIRD_OPTION, MenuAction.ITEM_FOURTH_OPTION, MenuAction.ITEM_FIFTH_OPTION, MenuAction.GROUND_ITEM_FIRST_OPTION, MenuAction.GROUND_ITEM_SECOND_OPTION, MenuAction.GROUND_ITEM_THIRD_OPTION, MenuAction.GROUND_ITEM_FOURTH_OPTION, MenuAction.GROUND_ITEM_FIFTH_OPTION -> {
                interactedObject = null
                interactedNpc = null
            }
            else -> if (it.isItemOp()) {
                interactedObject = null
                interactedNpc = null
            }
        }
    }

    fun findTileObject(x: Int, y: Int, id: Int): TileObject? {
        val scene = client.scene
        val tiles = scene.tiles
        val tile = tiles[client.plane][x][y]
        if (tile != null) {
            for (gameObject in tile.gameObjects) {
                if (gameObject != null && gameObject.id == id) {
                    return gameObject
                }
            }
            val wallObject = tile.wallObject
            if (wallObject != null && wallObject.id == id) {
                return wallObject
            }
            val decorativeObject = tile.decorativeObject
            if (decorativeObject != null && decorativeObject.id == id) {
                return decorativeObject
            }
            val groundObject = tile.groundObject
            if (groundObject != null && groundObject.id == id) {
                return groundObject
            }
        }
        return null
    }

    fun findNpc(id: Int): NPC? {

        return client.cachedNPCs[id]
    }

    val interactedTarget: Actor?
        get() = if (interactedNpc != null) interactedNpc else client.localPlayer!!.interacting
}