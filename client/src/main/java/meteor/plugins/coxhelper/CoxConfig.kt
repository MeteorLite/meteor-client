/*
 * Copyright (c) 2019, xzact <https://github.com/xzact>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
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
package meteor.plugins.coxhelper

import lombok.AllArgsConstructor
import lombok.Getter
import meteor.config.legacy.*
import java.awt.Color
import java.awt.Font

@ConfigGroup("Cox")
interface CoxConfig : Config {
    @ConfigItem(
        position = 2,
        keyName = "Muttadile",
        name = "Muttadile Marker",
        description = "Places an overlay around muttadiles showing their melee range.",
        section = "Muttadile"
    )
    fun muttadile(): Boolean {
        return true
    }

    @ConfigItem(
        position = 4,
        keyName = "Tekton",
        name = "Tekton Marker",
        description = "Places an overlay around Tekton showing his melee range.",
        section = "Tekton"
    )
    fun tekton(): Boolean {
        return true
    }

    @ConfigItem(
        position = 4,
        keyName = "tektonTickCounter",
        name = "Tekton Tick Counters",
        description = "Counts down current phase timer, and attack ticks.",
        section = "Tekton"
    )
    fun tektonTickCounter(): Boolean {
        return true
    }

    @ConfigItem(
        position = 6,
        keyName = "Guardians",
        name = "Guardians Overlay",
        description = "Places an overlay near Guardians showing safespot.",
        section = "Guardians"
    )
    fun guardians(): Boolean {
        return true
    }

    @ConfigItem(
        position = 6,
        keyName = "guardinTickCounter",
        name = "Guardians Tick Timing",
        description = "Places an overlay on Guardians showing attack tick timers.",
        section = "Guardians"
    )
    fun guardinTickCounter(): Boolean {
        return true
    }

    @ConfigItem(
        position = 8,
        keyName = "vangHighlight",
        name = "Highlight Vanguards",
        description = "Color is based on their attack style.",
        section = "Vanguards"
    )
    fun vangHighlight(): Boolean {
        return true
    }

    @ConfigItem(
        position = 9,
        keyName = "vangHealth",
        name = "Show Vanguards Current HP",
        description = "This will create an infobox with vanguards current hp.",
        section = "Vanguards"
    )
    fun vangHealth(): Boolean {
        return true
    }

    @ConfigItem(
        position = 11,
        keyName = "prayAgainstOlm",
        name = "Olm Show Prayer",
        description = "Shows what prayer to use during olm.",
        section = "Olm"
    )
    fun prayAgainstOlm(): Boolean {
        return true
    }

    @Range(min = 40, max = 100)
    @ConfigItem(
        position = 11,
        keyName = "prayAgainstOlmSize",
        name = "Olm Prayer Size",
        description = "Change the Size of the Olm Infobox.",
        section = "Olm"
    )
    @Units(Units.PIXELS)
    fun prayAgainstOlmSize(): Int {
        return 40
    }

    @ConfigItem(
        position = 12,
        keyName = "timers",
        name = "Olm Show Burn/Acid Timers",
        description = "Shows tick timers for burns/acids.",
        section = "Olm"
    )
    fun timers(): Boolean {
        return true
    }

    @ConfigItem(
        position = 13,
        keyName = "tpOverlay",
        name = "Olm Show Teleport Overlays",
        description = "Shows Overlays for targeted teleports.",
        section = "Olm"
    )
    fun tpOverlay(): Boolean {
        return true
    }

    @ConfigItem(
        position = 14,
        keyName = "olmTick",
        name = "Olm Tick Counter",
        description = "Show Tick Counter on Olm",
        section = "Olm"
    )
    fun olmTick(): Boolean {
        return true
    }

    @ConfigItem(
        position = 15,
        keyName = "olmDebug",
        name = "Olm Debug Info",
        description = "Dev tool to show info about olm",
        section = "Olm"
    )
    fun olmDebug(): Boolean {
        return false
    }

    @ConfigItem(
        position = 16,
        keyName = "olmPShowPhase",
        name = "Olm Phase Type",
        description = "Will highlight olm depending on which phase type is active. Red=Flame Green=Acid Purple=Crystal",
        section = "Olm"
    )
    fun olmPShowPhase(): Boolean {
        return false
    }

    @ConfigItem(
        position = 18,
        keyName = "muttaColor",
        name = "Muttadile Tile Color",
        description = "Change hit area tile color for muttadiles",
        section = "Colors",


    )
    fun muttaColor(): Color? {
        return Color(0, 255, 99)
    }

    @ConfigItem(
        position = 19,
        keyName = "guardColor",
        name = "Guardians Tile Color",
        description = "Change safespot area tile color for Guardians",
        section = "Colors",

    )
    fun guardColor(): Color? {
        return Color(0, 255, 99)
    }

    @ConfigItem(
        position = 20,
        keyName = "tektonColor",
        name = "Tekton Tile Color",
        description = "Change hit area tile color for Tekton",
        section = "Colors",

    )
    fun tektonColor(): Color? {
        return Color(193, 255, 245)
    }

    @ConfigItem(
        position = 21,
        keyName = "burnColor",
        name = "Burn Victim Color",
        description = "Changes tile color for burn victim.",
        section = "Colors",

    )
    fun burnColor(): Color? {
        return Color(255, 100, 0)
    }

    @ConfigItem(
        position = 22,
        keyName = "acidColor",
        name = "Acid Victim Color",
        description = "Changes tile color for acid victim.",
        section = "Colors",

    )
    fun acidColor(): Color? {
        return Color(69, 241, 44)
    }

    @ConfigItem(
        position = 23,
        keyName = "tpColor",
        name = "Teleport Target Color",
        description = "Changes tile color for teleport target.",
        section = "Colors",

    )
    fun tpColor(): Color? {
        return Color(193, 255, 245)
    }

    @ConfigItem(
        position = 24,
        keyName = "olmSpecialColor",
        name = "Olm Special Color",
        description = "Changes color of a special on Olm's tick counter",

        unhide = "olmTick"
    )
    fun olmSpecialColor(): Color? {
        return Color(89, 255, 0)
    }

    @ConfigItem(
        position = 26,
        keyName = "fontStyle",
        name = "Font Style",
        description = "Bold/Italics/Plain",
        section = "Text"
    )
    fun fontStyle(): FontStyle {
        return FontStyle.BOLD
    }

    @Range(min = 9, max = 20)
    @ConfigItem(
        position = 27,
        keyName = "textSize",
        name = "Text Size",
        description = "Text Size for Timers.",
        section = "Text"
    )
    @Units(Units.POINTS)
    fun textSize(): Int {
        return 14
    }

    @ConfigItem(
        position = 28,
        keyName = "shadows",
        name = "Shadows",
        description = "Adds Shadows to text.",
        section = "Text"
    )
    fun shadows(): Boolean {
        return true
    }

    @Getter
    @AllArgsConstructor
    enum class FontStyle(private val fontName: String? = null, val font: Int = 0) {
        BOLD("Bold", Font.BOLD), ITALIC("Italic", Font.ITALIC), PLAIN("Plain", Font.PLAIN);

        override fun toString(): String {
            return this.fontName!!
        }
    }
        @ConfigSection(keyName = "Tekton", position = 3, name = "Tekton", description = "")
        val tekton:String
        @ConfigSection(keyName = "Muttadile", position = 1, name = "Muttadile", description = "")
        val muttadile:String
        @ConfigSection(keyName = "Guardians", position = 5, name = "Guardians", description = "")
        val guardians:String

        @ConfigSection(keyName = "Olm", position = 10, name = "Olm", description = "")
        val olm:String
        @ConfigSection(keyName = "Colors", position = 17, name = "Colors", description = "")
        val colors:String
        @ConfigSection(keyName = "Text", position = 25, name = "Text", description = "")
        val text:String
        @ConfigSection(keyName = "Vanguards", position = 7, name = "Vanguards", description = "")
        val vanguards:String

}