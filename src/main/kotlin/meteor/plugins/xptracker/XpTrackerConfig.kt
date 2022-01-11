/*
 * Copyright (c) 2018, Levi <me@levischuck.com>
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

import meteor.config.legacy.*

@ConfigGroup("xpTracker")
interface XpTrackerConfig : Config {
    @ConfigItem(
        position = 0,
        keyName = "hideMaxed",
        name = "Hide maxed skills",
        description = "Stop globes from showing up for level 99 skills "
    )
    fun hideMaxed(): Boolean {
        return false
    }

    @ConfigItem(
        position = 1,
        keyName = "logoutPausing",
        name = "Pause on Logout",
        description = "Configures whether skills should pause on logout"
    )
    fun pauseOnLogout(): Boolean {
        return true
    }

    @ConfigItem(
        position = 2,
        keyName = "intermediateLevelMarkers",
        name = "Show intermediate level markers",
        description = "Marks intermediate levels on the progressbar"
    )
    fun showIntermediateLevels(): Boolean {
        return false
    }

    @ConfigItem(
        position = 3,
        keyName = "pauseSkillAfter",
        name = "Auto pause after",
        description = "Configures how many minutes passes before pausing a skill while in game and there's no XP, 0 means disabled"
    )
    @Units(
        Units.MINUTES
    )
    fun pauseSkillAfter(): Int {
        return 0
    }

    @ConfigItem(
        position = 4,
        keyName = "resetSkillRateAfter",
        name = "Auto reset after",
        description = "Configures how many minutes passes before resetting a skill's per hour rates while in game and there's no XP, 0 means disabled"
    )
    @Units(
        Units.MINUTES
    )
    fun resetSkillRateAfter(): Int {
        return 0
    }

    @ConfigItem(
        position = 5,
        keyName = "skillTabOverlayMenuOptions",
        name = "Add skill tab canvas menu option",
        description = "Configures whether a menu option to show/hide canvas XP trackers will be added to skills on the skill tab",
        section = overlaySection
    )
    fun skillTabOverlayMenuOptions(): Boolean {
        return true
    }

    @ConfigItem(
        position = 6,
        keyName = "onScreenDisplayMode",
        name = "On-screen tracker display mode (top)",
        description = "Configures the information displayed in the first line of on-screen XP overlays",
        section = overlaySection
    )
    fun onScreenDisplayMode(): XpPanelLabel? {
        return XpPanelLabel.XP_GAINED
    }

    @ConfigItem(
        position = 7,
        keyName = "onScreenDisplayModeBottom",
        name = "On-screen tracker display mode (bottom)",
        description = "Configures the information displayed in the second line of on-screen XP overlays",
        section = overlaySection
    )
    fun onScreenDisplayModeBottom(): XpPanelLabel? {
        return XpPanelLabel.XP_HOUR
    }

    @ConfigItem(
        position = 8,
        keyName = "xpPanelLabel1",
        name = "Top-left XP info label",
        description = "Configures the information displayed in the top-left of XP info box"
    )
    fun xpPanelLabel1(): XpPanelLabel? {
        return XpPanelLabel.XP_GAINED
    }

    @ConfigItem(
        position = 9,
        keyName = "xpPanelLabel2",
        name = "Top-right XP info label",
        description = "Configures the information displayed in the top-right of XP info box"
    )
    fun xpPanelLabel2(): XpPanelLabel? {
        return XpPanelLabel.XP_LEFT
    }

    @ConfigItem(
        position = 10,
        keyName = "xpPanelLabel3",
        name = "Bottom-left XP info label",
        description = "Configures the information displayed in the bottom-left of XP info box"
    )
    fun xpPanelLabel3(): XpPanelLabel? {
        return XpPanelLabel.XP_HOUR
    }

    @ConfigItem(
        position = 11,
        keyName = "xpPanelLabel4",
        name = "Bottom-right XP info label",
        description = "Configures the information displayed in the bottom-right of XP info box"
    )
    fun xpPanelLabel4(): XpPanelLabel? {
        return XpPanelLabel.ACTIONS_LEFT
    }

    @ConfigItem(
        position = 12,
        keyName = "progressBarLabel",
        name = "Progress bar label",
        description = "Configures the info box progress bar to show Time to goal or percentage complete"
    )
    fun progressBarLabel(): XpProgressBarLabel? {
        return XpProgressBarLabel.PERCENTAGE
    }

    @ConfigItem(
        position = 13,
        keyName = "progressBarTooltipLabel",
        name = "Tooltip label",
        description = "Configures the info box progress bar tooltip to show Time to goal or percentage complete"
    )
    fun progressBarTooltipLabel(): XpProgressBarLabel? {
        return XpProgressBarLabel.TIME_TO_LEVEL
    }

    @ConfigItem(
        position = 14,
        keyName = "prioritizeRecentXpSkills",
        name = "Move recently trained skills to top",
        description = "Configures whether skills should be organized by most recently gained xp"
    )
    fun prioritizeRecentXpSkills(): Boolean {
        return false
    }

    @ConfigItem(
        position = 15,
        keyName = "addToCanvasOnUpdate",
        name = "Add to canvas on skill update",
        description = "Automatically adds skill info box to canvas when a skill changes"
    )
    fun addToCanvasOnUpdate(): Boolean {
        return true
    }

    @ConfigItem(
        position = 15,
        keyName = "infoboxCooldown",
        name = "Infobox cooldown",
        description = "Time until an infobox is automatically cleared from the canvas in minutes"
    )
    @Range(max = 15, min = 1)
    fun infoboxCooldown(): Int {
        return 3
    }

    companion object {
        @ConfigSection(name = "Overlay", description = "Canvas overlay options", position = 99)
        const val overlaySection = "Overlay"
    }
}