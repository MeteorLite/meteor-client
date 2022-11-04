/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package meteor.plugins.attackstyles

import meteor.plugins.xptracker.XpInfoBoxOverlay
import meteor.ui.overlay.OverlayMenuEntry
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import net.runelite.api.MenuAction
import meteor.ui.table.TitleComponent
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

internal class AttackStylesOverlay constructor(plugin: AttackStylesPlugin, config: AttackStylesConfig) : OverlayPanel() {
    private val plugin: AttackStylesPlugin
    private val config: AttackStylesConfig

    init {
        position = OverlayPosition.ABOVE_CHATBOX_RIGHT
        this.plugin = plugin
        this.config = config
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, XpInfoBoxOverlay.OPTION_CONFIGURE, "Attack style overlay"))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val warnedSkillSelected = plugin.isWarnedSkillSelected
        if (warnedSkillSelected || config.alwaysShowStyle()) {
            val attackStyle = plugin.attackStyle ?: return null
            val attackStyleString = attackStyle.styleName
            panelComponent.children.add(TitleComponent.builder()
                    .text(attackStyleString)
                    .color(if (warnedSkillSelected) Color.RED else Color.WHITE))
            panelComponent.setPreferredSize(Dimension(
                    graphics.fontMetrics.stringWidth(attackStyleString) + 10,
                    0))
            return super.render(graphics)
        }
        return null
    }
}