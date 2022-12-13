/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, kThisIsCvpv <https://github.com/kThisIsCvpv>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package meteor.plugins.gauntletextended

import meteor.config.legacy.*
import net.runelite.api.Prayer
import java.awt.Color
import java.awt.Font
import java.awt.event.KeyEvent

@ConfigGroup("gauntlet")
interface GauntletExtendedConfig : Config {
    @ConfigItem(
        keyName = "autoPrayer",
        name = "Auto Prayer",
        description = "Automatically switches your prayers because why not",
        position = 0,
        section = "Hunllef"
    )
    fun autoPray(): Boolean {
        return false
    }

    @ConfigItem(
        position = 1,
        keyName = "eat",
        name = "Eat hotkey",
        description = "Eat hotkey.",
        section = "Hunllef"
    )
    fun eat(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_1, 0)
    }

    @ConfigItem(
        position = 1,
        keyName = "drink",
        name = "Drink hotkey",
        description = "Drink hotkey.",
        section = "Hunllef"
    )
    fun drink(): ModifierlessKeybind {
        return ModifierlessKeybind(KeyEvent.VK_2, 0)
    }

    @ConfigItem(
        keyName = "drinkPotions",
        name = "Auto Potion",
        description = "Automatically drinks potion when under 10 prayer",
        position = 1,
        section = "Hunllef"
    )
    fun potionToggle(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "tickFoodToggle",
        name = "Auto Eat",
        description = "Auto eats when hp is below 20",
        position = 1,
        section = "Hunllef"
    )
    fun autoTickEatToggle(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "offensivePrayerToggle",
        name = "Offensive Prayer Toggle",
        description = "Toggles the option to use offensive prayers with Auto Prayer",
        position = 1,
        section = "Hunllef"
    )
    fun offensivePrayerToggle(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "meleeoffensivePrayer",
        name = "Melee Offensive Prayer",
        description = "Choose which offensive prayer to use with Auto Prayer",
        position = 2,
        section = "Hunllef"
    )
    fun meleeoffensivePrayer(): MeleeOffensivePrayers {
        return MeleeOffensivePrayers.PIETY
    }

    @ConfigItem(
        keyName = "magicoffensivePrayer",
        name = "Magic Offensive Prayer",
        description = "Choose which offensive prayer to use with Auto Prayer",
        position = 3,
        section = "Hunllef"
    )
    fun magicoffensivePrayer(): MagicOffensivePrayers {
        return MagicOffensivePrayers.AUGURY
    }

    @ConfigItem(
        keyName = "rangeoffensivePrayer",
        name = "Range Offensive Prayer",
        description = "Choose which offensive prayer to use with Auto Prayer",
        position = 4,
        section = "Hunllef"
    )
    fun rangeoffensivePrayer(): RangeOffensivePrayers {
        return RangeOffensivePrayers.RIGOUR
    }

    @Units(Units.POINTS)
    fun autoWeaponSwap(): Boolean {
        return false
    }

    // Resources Section
    @ConfigItem(
        name = "Overlay resource icon and tile",
        description = "Overlay resources with a respective icon and tile outline.",
        position = 0,
        keyName = "resourceOverlay",
        section = "Resources"
    )
    fun resourceOverlay(): Boolean {
        return false
    }

    @Range(min = 12, max = 64)
    @ConfigItem(
        name = "Icon size",
        description = "Change the size of the resource icons.",
        position = 1,
        keyName = "resourceIconSize",
        section = "Resources",
        hidden = true,
        unhide = "resourceOverlay"
    )
    @Units(
        Units.POINTS
    )
    fun resourceIconSize(): Int {
        return 18
    }

    @Range(min = 1, max = 8)
    @ConfigItem(
        name = "Tile outline width",
        description = "Change the width of the resource tile outline.",
        position = 2,
        keyName = "resourceTileOutlineWidth",
        section = "Resources",
        hidden = true,
        unhide = "resourceOverlay"
    )
    @Units(
        Units.POINTS
    )
    fun resourceTileOutlineWidth(): Int {
        return 1
    }

    @Alpha
    @ConfigItem(
        name = "Tile outline color",
        description = "Change the tile outline color of resources.",
        position = 3,
        keyName = "resourceTileOutlineColor",
        section = "Resources",
        hidden = true,
        unhide = "resourceOverlay"
    )
    fun resourceTileOutlineColor(): Color? {
        return Color.YELLOW
    }

    @Alpha
    @ConfigItem(
        name = "Tile fill color",
        description = "Change the tile fill color of resources.",
        position = 4,
        keyName = "resourceTileFillColor",
        section = "Resources",
        hidden = true,
        unhide = "resourceOverlay"
    )
    fun resourceTileFillColor(): Color? {
        return Color(255, 255, 255, 50)
    }

    @ConfigItem(
        name = "Outline resources",
        description = "Outline resources with a colored outline.",
        position = 5,
        keyName = "resourceOutline",
        section = "Resources"
    )
    fun resourceOutline(): Boolean {
        return false
    }

    @Range(min = 1, max = 8)
    @ConfigItem(
        name = "Outline width",
        description = "Change the width of the resource outline.",
        position = 6,
        keyName = "resourceOutlineWidth",
        section = "Resources",
        hidden = true,
        unhide = "resourceOutline"
    )
    @Units(
        Units.POINTS
    )
    fun resourceOutlineWidth(): Int {
        return 1
    }

    @Alpha
    @ConfigItem(
        name = "Outline color",
        description = "Change the outline color of resources.",
        position = 7,
        keyName = "resourceOutlineColor",
        section = "Resources",
        hidden = true,
        unhide = "resourceOutline"
    )
    fun resourceOutlineColor(): Color? {
        return Color.YELLOW
    }

    @ConfigItem(
        name = "Track resources",
        description = "Track resources in counter infoboxes.",
        position = 8,
        keyName = "resourceTracker",
        section = "Resources",
        unhideKey = "resourceTracker"
    )
    fun resourceTracker(): ResourceFilter {
        return ResourceFilter.OFF
    }

    @ConfigItem(
        name = "Ore",
        description = "The desired number of ores to acquire.",
        position = 9,
        keyName = "resourceOre",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourceOre(): Int {
        return 3
    }

    @ConfigItem(
        name = "Phren bark",
        description = "The desired number of phren barks to acquire.",
        position = 10,
        keyName = "resourceBark",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourceBark(): Int {
        return 3
    }

    @ConfigItem(
        name = "Linum tirinum",
        description = "The desired number of linum tirinums to acquire.",
        position = 11,
        keyName = "resourceTirinum",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourceTirinum(): Int {
        return 3
    }

    @ConfigItem(
        name = "Grym leaf",
        description = "The desired number of grym leaves to acquire.",
        position = 12,
        keyName = "resourceGrym",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourceGrym(): Int {
        return 2
    }

    @ConfigItem(
        name = "Weapon frames",
        description = "The desired number of weapon frames to acquire.",
        position = 13,
        keyName = "resourceFrame",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourceFrame(): Int {
        return 2
    }

    @ConfigItem(
        name = "Paddlefish",
        description = "The desired number of paddlefish to acquire.",
        position = 14,
        keyName = "resourcePaddlefish",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourcePaddlefish(): Int {
        return 20
    }

    @ConfigItem(
        name = "Crystal shards",
        description = "The desired number of crystal shards to acquire.",
        position = 15,
        keyName = "resourceShard",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourceShard(): Int {
        return 320
    }

    @ConfigItem(
        name = "Bowstring",
        description = "Whether or not to acquire the crystalline or corrupted bowstring.",
        position = 16,
        keyName = "resourceBowstring",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourceBowstring(): Boolean {
        return false
    }

    @ConfigItem(
        name = "Spike",
        description = "Whether or not to acquire the crystal or corrupted spike.",
        position = 17,
        keyName = "resourceSpike",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourceSpike(): Boolean {
        return false
    }

    @ConfigItem(
        name = "Orb",
        description = "Whether or not to acquire the crystal or corrupted orb.",
        position = 18,
        keyName = "resourceOrb",
        section = "Resources",
        hidden = true,
        unhide = "resourceTracker",
        unhideValue = "CUSTOM"
    )
    fun resourceOrb(): Boolean {
        return false
    }

    // Utilities Section
    @ConfigItem(
        name = "Outline starting room utilities",
        description = "Outline various utilities in the starting room.",
        position = 0,
        keyName = "utilitiesOutline",
        section = "Utilities"
    )
    fun utilitiesOutline(): Boolean {
        return false
    }

    @Range(min = 2, max = 12)
    @ConfigItem(
        name = "Outline width",
        description = "Change the width of the utilities outline.",
        position = 1,
        keyName = "utilitiesOutlineWidth",
        section = "Utilities",
        hidden = true,
        unhide = "utilitiesOutline"
    )
    @Units(
        Units.POINTS
    )
    fun utilitiesOutlineWidth(): Int {
        return 4
    }

    @Alpha
    @ConfigItem(
        name = "Outline color",
        description = "Change the color of the utilities outline.",
        position = 2,
        keyName = "utilitiesOutlineColor",
        section = "Utilities",
        hidden = true,
        unhide = "utilitiesOutline"
    )
    fun utilitiesOutlineColor(): Color? {
        return Color.MAGENTA
    }

    // Other Npcs Section
    @ConfigItem(
        name = "Outline demi-bosses",
        description = "Overlay demi-bosses with a colored outline.",
        position = 0,
        keyName = "demibossOutline",
        section = "Npcs"
    )
    fun demibossOutline(): Boolean {
        return false
    }

    @Range(min = 2, max = 12)
    @ConfigItem(
        name = "Outline width",
        description = "Change the width of the demi-boss outline.",
        position = 1,
        keyName = "demibossOutlineWidth",
        section = "Npcs",
        hidden = true,
        unhide = "demibossOutline"
    )
    @Units(
        Units.POINTS
    )
    fun demibossOutlineWidth(): Int {
        return 4
    }

    @ConfigItem(
        name = "Outline strong npcs",
        description = "Overlay strong npcs with a colored outline.",
        position = 2,
        keyName = "strongNpcOutline",
        section = "Npcs"
    )
    fun strongNpcOutline(): Boolean {
        return false
    }

    @Range(min = 2, max = 12)
    @ConfigItem(
        name = "Outline width",
        description = "Change the width of the strong npcs outline.",
        position = 3,
        keyName = "strongNpcOutlineWidth",
        section = "Npcs",
        hidden = true,
        unhide = "strongNpcOutline"
    )
    @Units(
        Units.POINTS
    )
    fun strongNpcOutlineWidth(): Int {
        return 2
    }

    @Alpha
    @ConfigItem(
        name = "Outline color",
        description = "Change the outline color of strong npcs.",
        position = 4,
        keyName = "strongNpcOutlineColor",
        section = "Npcs",
        hidden = true,
        unhide = "strongNpcOutline"
    )
    fun strongNpcOutlineColor(): Color? {
        return Color.CYAN
    }

    @ConfigItem(
        name = "Outline weak npcs",
        description = "Overlay weak npcs with a colored outline.",
        position = 5,
        keyName = "weakNpcOutline",
        section = "Npcs"
    )
    fun weakNpcOutline(): Boolean {
        return false
    }

    @Range(min = 2, max = 12)
    @ConfigItem(
        name = "Outline width",
        description = "Change the width of the weak npcs outline.",
        position = 6,
        keyName = "weakNpcOutlineWidth",
        section = "Npcs",
        hidden = true,
        unhide = "weakNpcOutline"
    )
    @Units(
        Units.POINTS
    )
    fun weakNpcOutlineWidth(): Int {
        return 2
    }

    @Alpha
    @ConfigItem(
        name = "Outline color",
        description = "Change the outline color of weak npcs.",
        position = 7,
        keyName = "weakNpcOutlineColor",
        section = "Npcs",
        hidden = true,
        unhide = "weakNpcOutline"
    )
    fun weakNpcOutlineColor(): Color? {
        return Color.CYAN
    }

    // Hunllef Section
    @ConfigItem(
        name = "Display counter on Hunllef",
        description = "Overlay the Hunllef with an attack and prayer counter.",
        position = 0,
        keyName = "hunllefOverlayAttackCounter",
        section = "Hunllef"
    )
    fun hunllefOverlayAttackCounter(): Boolean {
        return false
    }

    @ConfigItem(
        name = "Counter font style",
        description = "Change the font style of the attack and prayer counter.",
        position = 1,
        keyName = "hunllefAttackCounterFontStyle",
        section = "Hunllef",
        hidden = true,
        unhide = "hunllefOverlayAttackCounter"
    )
    fun hunllefAttackCounterFontStyle(): FontStyle {
        return FontStyle.BOLD
    }

    @Range(min = 12, max = 64)
    @ConfigItem(
        name = "Counter font size",
        description = "Adjust the font size of the attack and prayer counter.",
        position = 2,
        keyName = "hunllefAttackCounterFontSize",
        section = "Hunllef",
        hidden = true,
        unhide = "hunllefOverlayAttackCounter"
    )
    @Units(
        Units.POINTS
    )
    fun hunllefAttackCounterFontSize(): Int {
        return 22
    }

    @ConfigItem(
        name = "Outline Hunllef on wrong prayer",
        description = "Outline the Hunllef when incorrectly praying against its current attack style.",
        position = 3,
        keyName = "hunllefOverlayWrongPrayerOutline",
        section = "Hunllef"
    )
    fun hunllefOverlayWrongPrayerOutline(): Boolean {
        return false
    }

    @Range(min = 2, max = 12)
    @ConfigItem(
        name = "Outline width",
        description = "Change the width of the wrong prayer outline.",
        position = 4,
        keyName = "hunllefWrongPrayerOutlineWidth",
        section = "Hunllef",
        hidden = true,
        unhide = "hunllefOverlayWrongPrayerOutline"
    )
    @Units(
        Units.POINTS
    )
    fun hunllefWrongPrayerOutlineWidth(): Int {
        return 4
    }

    @ConfigItem(
        name = "Outline Hunllef tile",
        description = "Outline the Hunllef's tile.",
        position = 5,
        keyName = "hunllefOutlineTile",
        section = "Hunllef"
    )
    fun hunllefOutlineTile(): Boolean {
        return false
    }

    @Range(min = 1, max = 8)
    @ConfigItem(
        name = "Tile outline width",
        description = "Change the width of the Hunllef's tile outline.",
        position = 6,
        keyName = "hunllefTileOutlineWidth",
        section = "Hunllef",
        hidden = true,
        unhide = "hunllefOutlineTile"
    )
    @Units(
        Units.POINTS
    )
    fun hunllefTileOutlineWidth(): Int {
        return 1
    }

    @Alpha
    @ConfigItem(
        name = "Tile outline color",
        description = "Change the outline color of the Hunllef's tile.",
        position = 7,
        keyName = "hunllefOutlineColor",
        section = "Hunllef",
        hidden = true,
        unhide = "hunllefOutlineTile"
    )
    fun hunllefOutlineColor(): Color? {
        return Color.WHITE
    }

    @Alpha
    @ConfigItem(
        name = "Tile fill color",
        description = "Change the fill color of the Hunllef's tile.",
        position = 8,
        keyName = "hunllefFillColor",
        section = "Hunllef",
        hidden = true,
        unhide = "hunllefOutlineTile"
    )
    fun hunllefFillColor(): Color? {
        return Color(255, 255, 255, 0)
    }

    @ConfigItem(
        name = "Overlay style icon on Hunllef",
        description = "Overlay a current attack style icon on the Hunllef.",
        position = 9,
        keyName = "hunllefOverlayAttackStyleIcon",
        section = "Hunllef"
    )
    fun hunllefOverlayAttackStyleIcon(): Boolean {
        return false
    }

    @Range(min = 12, max = 64)
    @ConfigItem(
        name = "Icon size",
        description = "Change the size of the attack style icon.",
        position = 10,
        keyName = "hunllefAttackStyleIconSize",
        section = "Hunllef",
        hidden = true,
        unhide = "hunllefOverlayAttackStyleIcon"
    )
    @Units(
        Units.POINTS
    )
    fun hunllefAttackStyleIconSize(): Int {
        return 18
    }

    @ConfigItem(
        name = "Play audio on prayer attack",
        description = "Play an in-game sound when the Hunllef is about to use its prayer attack.",
        position = 11,
        keyName = "hunllefPrayerAudio",
        section = "Hunllef"
    )
    fun hunllefPrayerAudio(): Boolean {
        return false
    }

    // Projectiles Section
    @ConfigItem(
        name = "Outline projectiles",
        description = "Outline projectiles with a blue (magic) or green (range) color.",
        position = 0,
        keyName = "outlineProjectile",
        section = "Projectiles"
    )
    fun outlineProjectile(): Boolean {
        return false
    }

    @ConfigItem(
        name = "Overlay projectile icons",
        description = "Overlay projectiles with their respective icon.",
        position = 1,
        keyName = "overlayProjectileIcon",
        section = "Projectiles"
    )
    fun overlayProjectileIcon(): Boolean {
        return false
    }

    @Range(min = 12, max = 64)
    @ConfigItem(
        name = "Icon size",
        description = "Change the size of the projectile icons.",
        position = 2,
        keyName = "projectileIconSize",
        section = "Projectiles",
        hidden = true,
        unhide = "overlayProjectileIcon"
    )
    @Units(
        Units.POINTS
    )
    fun projectileIconSize(): Int {
        return 18
    }

    // Tornadoes Section
    @ConfigItem(
        name = "Overlay tornado tick counter",
        description = "Overlay tornadoes with a tick counter.",
        position = 0,
        keyName = "tornadoTickCounter",
        section = "Tornadoes"
    )
    fun tornadoTickCounter(): Boolean {
        return false
    }

    @ConfigItem(
        name = "Font style",
        description = "Bold/Italics/Plain",
        position = 1,
        keyName = "tornadoFontStyle",
        section = "Tornadoes",
        hidden = true,
        unhide = "tornadoTickCounter"
    )
    fun tornadoFontStyle(): FontStyle {
        return FontStyle.BOLD
    }

    @ConfigItem(
        name = "Font shadow",
        description = "Toggle font shadow of the tornado tick counter.",
        position = 2,
        keyName = "tornadoFontShadow",
        section = "Tornadoes",
        hidden = true,
        unhide = "tornadoTickCounter"
    )
    fun tornadoFontShadow(): Boolean {
        return true
    }

    @Range(min = 12, max = 64)
    @ConfigItem(
        name = "Font size",
        description = "Adjust the font size of the tornado tick counter.",
        position = 3,
        keyName = "tornadoFontSize",
        section = "Tornadoes",
        hidden = true,
        unhide = "tornadoTickCounter"
    )
    @Units(
        Units.POINTS
    )
    fun tornadoFontSize(): Int {
        return 16
    }

    @Alpha
    @ConfigItem(
        name = "Font color",
        description = "Color of the tornado tick counter font.",
        position = 4,
        keyName = "tornadoFontColor",
        section = "Tornadoes",
        hidden = true,
        unhide = "tornadoTickCounter"
    )
    fun tornadoFontColor(): Color? {
        return Color.WHITE
    }

    @ConfigItem(
        name = "Outline tornado tile",
        description = "Outline the tiles of tornadoes.",
        position = 5,
        keyName = "tornadoTileOutline",
        section = "Tornadoes"
    )
    fun tornadoTileOutline(): Boolean {
        return false
    }

    @Range(min = 1, max = 8)
    @ConfigItem(
        name = "Tile outline width",
        description = "Change tile outline width of tornadoes.",
        position = 6,
        keyName = "tornadoTileOutlineWidth",
        section = "Tornadoes",
        hidden = true,
        unhide = "tornadoTileOutline"
    )
    @Units(
        Units.POINTS
    )
    fun tornadoTileOutlineWidth(): Int {
        return 1
    }

    @Alpha
    @ConfigItem(
        name = "Tile outline color",
        description = "Color to outline the tile of a tornado.",
        position = 7,
        keyName = "tornadoOutlineColor",
        section = "Tornadoes",
        hidden = true,
        unhide = "tornadoTileOutline"
    )
    fun tornadoOutlineColor(): Color? {
        return Color.YELLOW
    }

    @Alpha
    @ConfigItem(
        name = "Tile fill color",
        description = "Color to fill the tile of a tornado.",
        position = 8,
        keyName = "tornadoFillColor",
        section = "Tornadoes",
        hidden = true,
        unhide = "tornadoTileOutline"
    )
    fun tornadoFillColor(): Color? {
        return Color(255, 255, 0, 50)
    }

    // Player Section
    @ConfigItem(
        name = "Overlay prayer",
        description = "Overlay the correct prayer to use against the Hunllef's current attack style.",
        position = 0,
        keyName = "prayerOverlay",
        section = "Player"
    )
    fun prayerOverlay(): PrayerHighlightMode? {
        return PrayerHighlightMode.NONE
    }

    @ConfigItem(
        name = "Flash on wrong attack style",
        description = "Flash the screen if you use the wrong attack style.",
        position = 1,
        keyName = "flashOnWrongAttack",
        section = "Player"
    )
    fun flashOnWrongAttack(): Boolean {
        return false
    }

    @Range(min = 10, max = 50)
    @ConfigItem(
        name = "Flash duration",
        description = "Change the duration of the flash.",
        position = 2,
        keyName = "flashOnWrongAttackDuration",
        section = "Player",
        hidden = true,
        unhide = "flashOnWrongAttack"
    )
    fun flashOnWrongAttackDuration(): Int {
        return 25
    }

    @Alpha
    @ConfigItem(
        name = "Flash color",
        description = "Color of the flash notification.",
        position = 3,
        keyName = "flashOnWrongAttackColor",
        section = "Player",
        hidden = true,
        unhide = "flashOnWrongAttack"
    )
    fun flashOnWrongAttackColor(): Color? {
        return Color(255, 0, 0, 70)
    }

    @ConfigItem(
        name = "Flash on 5:1 method",
        description = "Flash the screen to weapon switch when using 5:1 method.",
        position = 4,
        keyName = "flashOn51Method",
        section = "Player"
    )
    fun flashOn51Method(): Boolean {
        return false
    }

    @Range(min = 10, max = 50)
    @ConfigItem(
        name = "Flash duration",
        description = "Change the duration of the flash.",
        position = 5,
        keyName = "flashOn51MethodDuration",
        section = "Player",
        hidden = true,
        unhide = "flashOn51Method"
    )
    fun flashOn51MethodDuration(): Int {
        return 25
    }

    @Alpha
    @ConfigItem(
        name = "Flash color",
        description = "Color of the flash notification.",
        position = 6,
        keyName = "flashOn51MethodColor",
        section = "Player",
        hidden = true,
        unhide = "flashOn51Method"
    )
    fun flashOn51MethodColor(): Color? {
        return Color(255, 190, 0, 50)
    }

    // Timer Section
    @ConfigItem(
        position = 0,
        keyName = "timerOverlay",
        name = "Overlay timer",
        description = "Display an overlay that tracks your gauntlet time.",
        section = "Timer"
    )
    fun timerOverlay(): Boolean {
        return false
    }

    @ConfigItem(
        position = 1,
        keyName = "timerChatMessage",
        name = "Chat timer",
        description = "Display a chat message on death with your gauntlet time.",
        section = "Timer"
    )
    fun timerChatMessage(): Boolean {
        return false
    }

    // Other Section
    @ConfigItem(
        name = "Render distance",
        description = "Set render distance of various overlays.",
        position = 0,
        keyName = "resourceRenderDistance",
        section = "Other"
    )
    fun resourceRenderDistance(): RenderDistance {
        return RenderDistance.FAR
    }

    @ConfigItem(
        name = "Disco mode",
        description = "Kill the Hunllef.",
        position = 1,
        keyName = "discoMode",
        section = "Other"
    )
    fun discoMode(): Boolean {
        return false
    }

    // Constants
    enum class RenderDistance(private val rd: String? = null, val distance: Int = 0) {
        SHORT("Short", 2350), MEDIUM("Medium", 3525), FAR("Far", 4700), UNCAPPED("Uncapped", 0);

        override fun toString(): String {
            return rd!!
        }
    }

    enum class FontStyle(private val fs: String? = null, val font: Int = 0) {
        BOLD("Bold", Font.BOLD), ITALIC("Italic", Font.ITALIC), PLAIN("Plain", Font.PLAIN);

        override fun toString(): String {
            return fs!!
        }
    }

    enum class PrayerHighlightMode(private val ph: String? = null) {
        WIDGET("Widget"), BOX("Box"), BOTH("Both"), NONE("None");

        override fun toString(): String {
            return ph!!
        }
    }

    enum class ResourceFilter {
        ALL, BASIC, CUSTOM, OFF
    }

    enum class MeleeOffensivePrayers(val prayer: Prayer) {
        INCREDIBLE_REFLEXES(Prayer.INCREDIBLE_REFLEXES), CHIVALRY(Prayer.CHIVALRY), PIETY(Prayer.PIETY);

    }

    enum class MagicOffensivePrayers(val prayer: Prayer) {
        MYSTIC_MIGHT(Prayer.MYSTIC_MIGHT), AUGURY(Prayer.AUGURY);

    }

    enum class RangeOffensivePrayers(val prayer: Prayer) {
        EAGLE_EYE(Prayer.EAGLE_EYE), RIGOUR(Prayer.RIGOUR);

    }
        @ConfigSection(
            name = "Resources",
            description = "Resources section.",
            position = 0,
            keyName = "resourcesSection"
        )
        val resourcesSection : String

        @ConfigSection(
            name = "Utilities",
            description = "Utilities section.",
            position = 1,
            keyName = "utilitiesSection"
        )
        val utilitiesSection : String

        @ConfigSection(
            name = "Npcs",
            description = "Other npcs section.",
            position = 2,
            keyName = "npcSection"
        )
        val npcSection : String

        @ConfigSection(
            name = "Hunllef",
            description = "Hunllef section.",
            position = 3,
            keyName = "hunllefSection"
        )
        val hunllefSection : String

        @ConfigSection(
            name = "Projectiles",
            description = "Projectiles section.",
            position = 4,
            keyName = "projectilesSection"
        )
        val projectilesSection : String

        @ConfigSection(
            name = "Tornadoes",
            description = "Tornadoes section.",
            position = 5,
            keyName = "tornadoesSection"
        )
        val tornadoesSection : String

        @ConfigSection(
            name = "Player",
            description = "Player section.",
            position = 6,
            keyName = "playerSection"
        )
        val playerSection : String

        @ConfigSection(
            name = "Timer",
            description = "Timer section.",
            position = 7,
            keyName = "timerSection"
        )
        val timerSection : String

        @ConfigSection(
            name = "Other",
            description = "Other section.",
            position = 8,
            keyName = "otherSection"
        )
        val otherSection : String
}