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

import meteor.ui.overlay.Overlay
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.util.ColorUtil
import net.runelite.api.MenuAction
import net.runelite.api.MenuEntry
import net.runelite.api.NPC
import net.runelite.api.TileObject
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import ui.overlay.outline.ModelOutlineRenderer
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

internal class InteractHighlightOverlay(

    private val plugin: InteractHighlightPlugin,

    ) : Overlay() {

    private var config = plugin.configuration<InteractHighlightConfig>()

    private val modelOutlineRenderer = ModelOutlineRenderer()

    init {

        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_SCENE
        priority = OverlayPriority.HIGH
    }

    override fun render(graphics: Graphics2D): Dimension? {
        try {
            renderMouseover()
            renderTarget()
        } catch (_: Exception) {}
        return null
    }

    private fun renderMouseover() {
        val menuEntries: Array<MenuEntry> = client.menuEntries
        if (menuEntries.size == 0) {
            return
        }
        val entry: MenuEntry =
            if (client.isMenuOpen) hoveredMenuEntry(menuEntries) else menuEntries[menuEntries.size - 1]
        val menuAction: MenuAction = entry.type
        when (menuAction) {
            MenuAction.ITEM_USE_ON_GAME_OBJECT, MenuAction.WIDGET_TARGET_ON_GAME_OBJECT, MenuAction.GAME_OBJECT_FIRST_OPTION, MenuAction.GAME_OBJECT_SECOND_OPTION, MenuAction.GAME_OBJECT_THIRD_OPTION, MenuAction.GAME_OBJECT_FOURTH_OPTION, MenuAction.GAME_OBJECT_FIFTH_OPTION, MenuAction.EXAMINE_OBJECT -> {
                val x: Int = entry.param0
                val y: Int = entry.param1
                val id: Int = entry.identifier
                val tileObject: TileObject? = plugin.findTileObject(x, y, id)
                if (tileObject != null && config.objectShowHover() && (tileObject !== plugin.interactedObject || !config.objectShowInteract())) {
                    modelOutlineRenderer.drawOutline(
                        tileObject,
                        config.borderWidth(),
                        config.objectHoverHighlightColor(),
                        config.outlineFeather()
                    )
                }
            }
            MenuAction.ITEM_USE_ON_NPC, MenuAction.WIDGET_TARGET_ON_NPC, MenuAction.NPC_FIRST_OPTION, MenuAction.NPC_SECOND_OPTION, MenuAction.NPC_THIRD_OPTION, MenuAction.NPC_FOURTH_OPTION, MenuAction.NPC_FIFTH_OPTION, MenuAction.EXAMINE_NPC -> {
                val id: Int = entry.identifier
                val npc = plugin.findNpc(id)
                if (npc != null && config.npcShowHover() && (npc !== plugin.interactedTarget || !config.npcShowInteract())) {
                    val highlightColor = if (menuAction == MenuAction.NPC_SECOND_OPTION
                        || menuAction == MenuAction.WIDGET_TARGET_ON_NPC && WidgetInfo.TO_GROUP(
                            client.selectedWidget!!.id
                        ) == WidgetID.SPELLBOOK_GROUP_ID
                    ) config.npcAttackHoverHighlightColor() else config.npcHoverHighlightColor()
                    modelOutlineRenderer.drawOutline(npc, config.borderWidth(), highlightColor, config.outlineFeather())
                }
            }
            else -> {}
        }
    }

    private fun renderTarget() {
        val interactedObject: TileObject? = plugin.interactedObject
        if (interactedObject != null && config.objectShowInteract()) {
            val clickColor = getClickColor(
                config.objectHoverHighlightColor(), config.objectInteractHighlightColor(),
                (
                        client.gameCycle - plugin.gameCycle).toLong()
            )
            modelOutlineRenderer.drawOutline(
                interactedObject,
                config.borderWidth(),
                clickColor,
                config.outlineFeather()
            )
        }
        val target = plugin.interactedTarget
        if (target is NPC && config.npcShowInteract()) {
            val startColor =
                if (plugin.attacked) config.npcAttackHoverHighlightColor() else config.npcHoverHighlightColor()
            val endColor =
                if (plugin.attacked) config.npcAttackHighlightColor() else config.npcInteractHighlightColor()
            val clickColor = getClickColor(
                startColor, endColor,
                (
                        client.gameCycle - plugin.gameCycle).toLong()
            )
            modelOutlineRenderer.drawOutline(target as NPC?, config.borderWidth(), clickColor, config.outlineFeather())
        }
    }

    private fun getClickColor(start: Color?, end: Color?, time: Long): Color? {
        if (time < 5) {
            return ColorUtil.colorLerp(start!!, INTERACT_CLICK_COLOR, (time / 5f).toDouble())
        } else if (time < 10) {
            return ColorUtil.colorLerp(INTERACT_CLICK_COLOR, end!!, ((time - 5) / 5f).toDouble())
        }
        return end
    }

    private fun hoveredMenuEntry(menuEntries: Array<MenuEntry>): MenuEntry {
        val menuX = client.menuX
        val menuY = client.menuY
        val menuWidth = client.menuWidth
        val mousePosition = client.mouseCanvasPosition
        var dy = mousePosition.y - menuY
        dy -= 19 // Height of Choose Option
        if (dy < 0) {
            return menuEntries[menuEntries.size - 1]
        }
        var idx = dy / 15 // Height of each menu option
        idx = menuEntries.size - 1 - idx
        return if (mousePosition.x > menuX && mousePosition.x < menuX + menuWidth && idx >= 0 && idx < menuEntries.size) {
            menuEntries[idx]
        } else menuEntries[menuEntries.size - 1]
    }

    companion object {
        private val INTERACT_CLICK_COLOR = Color(-0x6f000001)
    }
}