/*
 * Copyright (c) 2018, Dreyri <https://github.com/Dreyri>
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
package meteor.plugins.minimap

import eventbus.events.ConfigChanged
import eventbus.events.GameStateChanged
import eventbus.events.ScriptPostFired
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.GameState
import net.runelite.api.ScriptID
import net.runelite.api.SpritePixels
import net.runelite.api.widgets.WidgetInfo
import org.rationalityfrontline.kevent.Event
import java.awt.Color
import java.util.*

@PluginDescriptor(
    name = "Minimap",
    description = "Customize the color of minimap dots, and hide the minimap",
    tags = ["items", "npcs", "players"]
)
class MinimapPlugin : Plugin() {
override val config = configuration<MinimapConfig>()
    private var originalDotSprites: Array<SpritePixels>? = null


    override fun onStart() {
        updateMinimapWidgetVisibility(config.hideMinimap())
        storeOriginalDots()
        replaceMapDots()
    }

    override fun onStop() {
        updateMinimapWidgetVisibility(false)
        restoreOriginalDots()
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (it.gamestate == GameState.LOGIN_SCREEN && originalDotSprites == null) {
            storeOriginalDots()
            replaceMapDots()
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (!it.group.equals(MinimapConfig.GROUP)) {


            if (it.key.equals("hideMinimap")) {
                updateMinimapWidgetVisibility(config.hideMinimap())
                replaceMapDots()
            }
        }

    }

    override fun onScriptPostFired(it: ScriptPostFired) {
        if (it.scriptId == ScriptID.TOPLEVEL_REDRAW) {
            updateMinimapWidgetVisibility(config.hideMinimap())
        }
    }


    private fun updateMinimapWidgetVisibility(enable: Boolean) {
        val resizableStonesWidget = client.getWidget(WidgetInfo.RESIZABLE_MINIMAP_STONES_WIDGET)
        if (resizableStonesWidget != null) {
            resizableStonesWidget.isHidden = enable
        }
        val resizableNormalWidget = client.getWidget(WidgetInfo.RESIZABLE_MINIMAP_WIDGET)
        if (resizableNormalWidget != null && !resizableNormalWidget.isSelfHidden) {
            for (widget in resizableNormalWidget.staticChildren) {
                if (widget.id != WidgetInfo.RESIZABLE_VIEWPORT_BOTTOM_LINE_LOGOUT_BUTTON.packedId &&
                    widget.id != WidgetInfo.RESIZABLE_MINIMAP_LOGOUT_BUTTON.packedId
                ) {
                    widget.isHidden = enable
                }
            }
        }
    }

    private fun replaceMapDots() {
        val mapDots = client.mapDots ?: return
        applyDot(mapDots, DOT_ITEM, config.itemColor())
        applyDot(mapDots, DOT_NPC, config.npcColor())
        applyDot(mapDots, DOT_PLAYER, config.playerColor())
        applyDot(mapDots, DOT_FRIEND, config.friendColor())
        applyDot(mapDots, DOT_TEAM, config.teamColor())
        applyDot(mapDots, DOT_FRIENDSCHAT, config.friendsChatColor())
        applyDot(mapDots, DOT_CLAN, config.clanChatColor())
    }

    private fun applyDot(mapDots: Array<SpritePixels?>, id: Int, color: Color?) {
        if (id < mapDots.size && color != null) {
            mapDots[id] = MinimapDot.create(client, color)
        }
    }

    private fun storeOriginalDots() {
        val originalDots = client.mapDots ?: return
        originalDotSprites = Arrays.copyOf(originalDots, originalDots.size)
    }

    private fun restoreOriginalDots() {
        val mapDots = client.mapDots
        if (originalDotSprites == null || mapDots == null) {
            return
        }
        System.arraycopy(originalDotSprites, 0, mapDots, 0, mapDots.size)
    }

    companion object {
        private const val DOT_ITEM = 0
        private const val DOT_NPC = 1
        private const val DOT_PLAYER = 2
        private const val DOT_FRIEND = 3
        private const val DOT_TEAM = 4
        private const val DOT_FRIENDSCHAT = 5
        private const val DOT_CLAN = 6
    }
}