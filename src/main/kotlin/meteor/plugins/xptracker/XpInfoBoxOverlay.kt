/*
 * Copyright (c) 2018, Jasper Ketelaar <Jasper0781@gmail.com>
 * Copyright (c) 2020, Anthony <https://github.com/while-loop>
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
package meteor.plugins.xptracker

import meteor.FontManager.runescapeSmallFont
import meteor.ui.components.ImageComponent
import meteor.ui.components.LineComponent
import meteor.ui.components.ProgressBarComponent
import meteor.ui.components.SplitComponent
import meteor.ui.overlay.*
import meteor.ui.overlay.ComponentOrientation
import meteor.util.SkillColor.Companion.find
import net.runelite.api.Experience
import net.runelite.api.MenuAction
import net.runelite.api.Skill
import java.awt.*
import java.awt.image.BufferedImage

internal class XpInfoBoxOverlay(
    private val plugin: XpTrackerPlugin,
    private val config: XpTrackerConfig,
    val skill: Skill,
    private val icon: BufferedImage
) : OverlayPanel() {
    private val iconXpSplitPanel = PanelComponent()
    override fun render(graphics: Graphics2D): Dimension? {
        iconXpSplitPanel.children.clear()

        //Setting the font to rs small font so that the overlay isn't huge
        graphics.font = runescapeSmallFont
        val snapshot = plugin.getSkillSnapshot(skill)
        val leftStr = config.onScreenDisplayMode()!!.getActionKey(snapshot)
        val rightNum = config.onScreenDisplayMode()!!.valueFunc!!.apply(snapshot)
        val xpLine = LineComponent.Builder()
            .left("$leftStr:")
            .right(rightNum)
            .build()
        val bottomLeftStr = config.onScreenDisplayModeBottom()!!.getActionKey(snapshot)
        val bottomRightNum = config.onScreenDisplayModeBottom()!!.valueFunc!!.apply(snapshot)
        val xpLineBottom = LineComponent.Builder()
            .left("$bottomLeftStr:")
            .right(bottomRightNum)
            .build()
        val xpSplit = SplitComponent.Builder()
            .first(xpLine)
            .second(xpLineBottom)
            .orientation(ComponentOrientation.VERTICAL)
            .build()
        val imageComponent = ImageComponent(icon)
        val iconXpSplit = SplitComponent.Builder()
            .first(imageComponent)
            .second(xpSplit)
            .orientation(ComponentOrientation.HORIZONTAL)
            .gap(Point(XP_AND_ICON_GAP, 0))
            .build()
        iconXpSplitPanel.children.add(iconXpSplit)
        val progressBarComponent = ProgressBarComponent()
        progressBarComponent.backgroundColor = Color(61, 56, 49)
        progressBarComponent.foregroundColor = find(skill).color
        progressBarComponent.leftLabel = snapshot.startLevel.toString()
        progressBarComponent.rightLabel =
            if (snapshot.endGoalXp == Experience.MAX_SKILL_XP) "200M" else snapshot.endLevel.toString()
        progressBarComponent.value = snapshot.skillProgressToGoal
        panelComponent.children.add(iconXpSplitPanel)
        panelComponent.children.add(progressBarComponent)
        return super.render(graphics)
    }

    override val name: String
        get() = super.name + skill.getName()

    companion object {
        private const val BORDER_SIZE = 2
        private const val XP_AND_PROGRESS_BAR_GAP = 2
        private const val XP_AND_ICON_GAP = 4
        private val XP_AND_ICON_COMPONENT_BORDER = Rectangle(2, 1, 4, 0)
        const val OPTION_CONFIGURE = "Configure"
    }

    init {
        position = OverlayPosition.TOP_LEFT
        resizable = false
        panelComponent.border = Rectangle(BORDER_SIZE, BORDER_SIZE, BORDER_SIZE, BORDER_SIZE)
        panelComponent.gap = Point(0, XP_AND_PROGRESS_BAR_GAP)
        iconXpSplitPanel.border = XP_AND_ICON_COMPONENT_BORDER
        menuEntries.add(OverlayMenuEntry(MenuAction.RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "XP Tracker overlay"))
    }
}