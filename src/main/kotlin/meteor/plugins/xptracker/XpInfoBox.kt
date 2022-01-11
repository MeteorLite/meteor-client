/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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

import meteor.FontManager
import meteor.game.SkillIconManager
import meteor.ui.ColorScheme
import meteor.ui.components.DynamicGridLayout
import meteor.ui.components.MouseDragEventForwarder
import meteor.ui.components.ProgressBar
import meteor.util.ColorUtil
import meteor.util.QuantityFormatter
import meteor.util.SkillColor
import net.runelite.api.Client
import net.runelite.api.Experience
import net.runelite.api.Skill
import java.awt.BorderLayout
import java.awt.Color
import java.awt.Dimension
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.math.RoundingMode
import java.text.DecimalFormat
import java.util.ArrayList
import javax.swing.*
import javax.swing.border.EmptyBorder
import javax.swing.event.PopupMenuEvent
import javax.swing.event.PopupMenuListener

internal class XpInfoBox(
    xpTrackerPlugin: XpTrackerPlugin,
    private val xpTrackerConfig: XpTrackerConfig,
    client: Client?,
    panel: JComponent,
    skill: Skill,
    iconManager: SkillIconManager
) : JPanel() {
    companion object {
        val TWO_DECIMAL_FORMAT: DecimalFormat = DecimalFormat("0.00")

        // Templates
        private const val HTML_TOOL_TIP_TEMPLATE = ("<html>%s %s done<br/>"
                + "%s %s/hr<br/>"
                + "%s %s</html>")
        private const val HTML_LABEL_TEMPLATE =
            "<html><body style='color:%s'>%s<span style='color:white'>%s</span></body></html>"
        private const val REMOVE_STATE = "Remove from canvas"
        private const val ADD_STATE = "Add to canvas"
        fun htmlLabel(panelLabel: XpPanelLabel, xpSnapshotSingle: XpSnapshotSingle?): String {
            val key = panelLabel.getActionKey(xpSnapshotSingle!!) + ": "
            val value = panelLabel.valueFunc!!.apply(xpSnapshotSingle)
            return htmlLabel(key, value)
        }

        fun htmlLabel(key: String?, value: Int): String {
            val valueStr = QuantityFormatter.quantityToRSDecimalStack(value, true)
            return htmlLabel(key, valueStr)
        }

        fun htmlLabel(key: String?, valueStr: String?): String {
            return String.format(HTML_LABEL_TEMPLATE, ColorUtil.toHexColor(ColorScheme.LIGHT_GRAY_COLOR), key, valueStr)
        }

        init {
            TWO_DECIMAL_FORMAT.setRoundingMode(RoundingMode.DOWN)
        }
    }

    // Instance members
    private val panel: JComponent

    private val skill: Skill

    /* The tracker's wrapping container */
    private val container: JPanel = JPanel()

    /* Contains the skill icon and the stats panel */
    private val headerPanel: JPanel = JPanel()

    /* Contains all the skill information (exp gained, per hour, etc) */
    private val statsPanel: JPanel = JPanel()
    private val progressBar = ProgressBar()
    private val topLeftStat: JLabel = JLabel()
    private val bottomLeftStat: JLabel = JLabel()
    private val topRightStat: JLabel = JLabel()
    private val bottomRightStat: JLabel = JLabel()
    private val pauseSkill: JMenuItem = JMenuItem("Pause")
    private val canvasItem: JMenuItem = JMenuItem(ADD_STATE)
    private var paused = false
    fun reset() {
        canvasItem.setText(ADD_STATE)
        panel.remove(this)
        panel.revalidate()
    }

    fun update(updated: Boolean, paused: Boolean, xpSnapshotSingle: XpSnapshotSingle) {
        SwingUtilities.invokeLater(Runnable { rebuildAsync(updated, paused, xpSnapshotSingle) })
    }

    private fun rebuildAsync(updated: Boolean, skillPaused: Boolean, xpSnapshotSingle: XpSnapshotSingle) {
        if (updated) {
            if (getParent() !== panel) {
                panel.add(this)
                panel.revalidate()
            }
            if (xpTrackerConfig.prioritizeRecentXpSkills()) {
                panel.setComponentZOrder(this, 0)
            }
            paused = skillPaused

            // Update progress bar
            progressBar.setValue(xpSnapshotSingle.skillProgressToGoal.toInt())
            progressBar.setCenterLabel(xpTrackerConfig.progressBarLabel()!!.valueFunc.apply(xpSnapshotSingle))
            progressBar.setLeftLabel("Lvl. " + xpSnapshotSingle.startLevel)
            progressBar.setRightLabel(if (xpSnapshotSingle.endGoalXp == Experience.MAX_SKILL_XP) "200M" else "Lvl. " + xpSnapshotSingle.endLevel)

            // Add intermediate level positions to progressBar
            if (xpTrackerConfig.showIntermediateLevels() && xpSnapshotSingle.endLevel - xpSnapshotSingle.startLevel > 1) {
                val positions: MutableList<Int> = ArrayList()
                for (level in xpSnapshotSingle.startLevel + 1..xpSnapshotSingle.endLevel) {
                    val relativeStartExperience: Double =
                        (Experience.getXpForLevel(level) - xpSnapshotSingle.startGoalXp).toDouble()
                    val relativeEndExperience =
                        (xpSnapshotSingle.endGoalXp - xpSnapshotSingle.startGoalXp).toDouble()
                    positions.add((relativeStartExperience / relativeEndExperience * 100).toInt())
                }
                progressBar.setPositions(positions)
            } else {
                progressBar.setPositions(emptyList())
            }
            val tooltipLabel = xpTrackerConfig.progressBarTooltipLabel()
            progressBar.toolTipText = String.format(
                HTML_TOOL_TIP_TEMPLATE,
                xpSnapshotSingle.actionsInSession,
                xpSnapshotSingle.actionType!!.type,
                xpSnapshotSingle.actionsPerHour,
                xpSnapshotSingle.actionType!!.type,
                tooltipLabel!!.valueFunc.apply(xpSnapshotSingle),
                if (tooltipLabel == XpProgressBarLabel.PERCENTAGE) "of goal" else "till goal lvl"
            )
            progressBar.dimmed = skillPaused
        } else if (!paused && skillPaused) {
            // React to the skill state now being paused
            progressBar.dimmed = true
            paused = true
            pauseSkill.setText("Unpause")
        } else if (paused && !skillPaused) {
            // React to the skill being unpaused (without update)
            progressBar.dimmed = false
            paused = false
            pauseSkill.setText("Pause")
        }

        // Update information labels
        // Update exp per hour separately, every time (not only when there's an update)
        topLeftStat.setText(htmlLabel(xpTrackerConfig.xpPanelLabel1()!!, xpSnapshotSingle))
        topRightStat.setText(htmlLabel(xpTrackerConfig.xpPanelLabel2()!!, xpSnapshotSingle))
        bottomLeftStat.setText(htmlLabel(xpTrackerConfig.xpPanelLabel3()!!, xpSnapshotSingle))
        bottomRightStat.setText(htmlLabel(xpTrackerConfig.xpPanelLabel4()!!, xpSnapshotSingle))
    }

    init {
        this.panel = panel
        this.skill = skill
        setLayout(BorderLayout())
        setBorder(EmptyBorder(5, 0, 0, 0))
        container.setLayout(BorderLayout())
        container.setBackground(ColorScheme.DARKER_GRAY_COLOR)

        // Create reset menu
        val reset = JMenuItem("Reset")
        reset.addActionListener(ActionListener { e: ActionEvent? -> xpTrackerPlugin.resetSkillState(skill) })

        // Create reset others menu
        val resetOthers = JMenuItem("Reset others")
        resetOthers.addActionListener(ActionListener { e: ActionEvent? -> xpTrackerPlugin.resetOtherSkillState(skill) })

        // Create reset per hour menu
        val resetPerHour = JMenuItem("Reset/hr")
        resetPerHour.addActionListener(ActionListener { e: ActionEvent? -> xpTrackerPlugin.resetSkillPerHourState(skill) })

        // Create reset others menu
        pauseSkill.addActionListener(ActionListener { e: ActionEvent? -> xpTrackerPlugin.pauseSkill(skill, !paused) })

        // Create popup menu
        val popupMenu = JPopupMenu()
        popupMenu.setBorder(EmptyBorder(5, 5, 5, 5))
        popupMenu.add(reset)
        popupMenu.add(resetOthers)
        popupMenu.add(resetPerHour)
        popupMenu.add(pauseSkill)
        popupMenu.add(canvasItem)
        popupMenu.addPopupMenuListener(object : PopupMenuListener {
            override fun popupMenuWillBecomeVisible(popupMenuEvent: PopupMenuEvent) {
                canvasItem.setText(if (xpTrackerPlugin.hasOverlay(skill)) REMOVE_STATE else ADD_STATE)
            }

            override fun popupMenuWillBecomeInvisible(popupMenuEvent: PopupMenuEvent) {}
            override fun popupMenuCanceled(popupMenuEvent: PopupMenuEvent) {}
        })
        canvasItem.addActionListener(ActionListener { e: ActionEvent? ->
            if (canvasItem.getText() == REMOVE_STATE) {
                xpTrackerPlugin.removeOverlay(skill)
            } else {
                xpTrackerPlugin.addOverlay(skill)
            }
        })
        val skillIcon = JLabel(ImageIcon(iconManager.getSkillImage(skill)))
        skillIcon.setHorizontalAlignment(SwingConstants.CENTER)
        skillIcon.setVerticalAlignment(SwingConstants.CENTER)
        skillIcon.setPreferredSize(Dimension(35, 35))
        headerPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR)
        headerPanel.setLayout(BorderLayout())
        statsPanel.setLayout(DynamicGridLayout(2, 2))
        statsPanel.setBackground(ColorScheme.DARKER_GRAY_COLOR)
        statsPanel.setBorder(EmptyBorder(9, 2, 9, 2))
        topLeftStat.setFont(FontManager.runescapeSmallFont)
        bottomLeftStat.setFont(FontManager.runescapeSmallFont)
        topRightStat.setFont(FontManager.runescapeSmallFont)
        bottomRightStat.setFont(FontManager.runescapeSmallFont)
        statsPanel.add(topLeftStat) // top left
        statsPanel.add(topRightStat) // top right
        statsPanel.add(bottomLeftStat) // bottom left
        statsPanel.add(bottomRightStat) // bottom right
        headerPanel.add(skillIcon, BorderLayout.WEST)
        headerPanel.add(statsPanel, BorderLayout.CENTER)
        val progressWrapper = JPanel()
        progressWrapper.setBackground(ColorScheme.DARKER_GRAY_COLOR)
        progressWrapper.setLayout(BorderLayout())
        progressWrapper.setBorder(EmptyBorder(0, 7, 7, 7))
        progressBar.setMaximumValue(100)
        progressBar.background = Color(61, 56, 49)
        progressBar.foreground = SkillColor.find(skill).color
        progressBar.setDimmedText("Paused")
        progressWrapper.add(progressBar, BorderLayout.NORTH)
        container.add(headerPanel, BorderLayout.NORTH)
        container.add(progressWrapper, BorderLayout.SOUTH)
        container.setComponentPopupMenu(popupMenu)
        progressBar.componentPopupMenu = popupMenu

        // forward mouse drag events to parent panel for drag and drop reordering
        val mouseDragEventForwarder = MouseDragEventForwarder(panel)
        container.addMouseListener(mouseDragEventForwarder)
        container.addMouseMotionListener(mouseDragEventForwarder)
        progressBar.addMouseListener(mouseDragEventForwarder)
        progressBar.addMouseMotionListener(mouseDragEventForwarder)
        add(container, BorderLayout.NORTH)
    }
}