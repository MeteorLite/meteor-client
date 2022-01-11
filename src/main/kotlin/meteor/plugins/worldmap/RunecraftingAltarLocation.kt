/*
 * Copyright (c) 2019, Dava96 <https://github.com/Dava96>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.worldmap


import net.runelite.api.coords.WorldPoint


internal enum class RunecraftingAltarLocation(description: String, level: Int, location: WorldPoint, iconPath: String) {
    AIR_ALTAR("Air Altar", 1, WorldPoint(2985, 3293, 0), "air_altar_icon.png"), MIND_ALTAR(
        "Mind Altar",
        2,
        WorldPoint(2982, 3514, 0),
        "mind_altar_icon.png"
    ),
    WATER_ALTAR("Water Altar", 5, WorldPoint(3185, 3165, 0), "water_altar_icon.png"), EARTH_ALTAR(
        "Earth Altar",
        9,
        WorldPoint(3306, 3474, 0),
        "earth_altar_icon.png"
    ),
    FIRE_ALTAR("Fire Altar", 14, WorldPoint(3313, 3255, 0), "fire_altar_icon.png"), BODY_ALTAR(
        "Body Altar",
        20,
        WorldPoint(3053, 3445, 0),
        "body_altar_icon.png"
    ),
    COSMIC_ALTAR("Cosmic Altar", 27, WorldPoint(2408, 4377, 0), "cosmic_altar_icon.png"), CHAOS_ALTAR(
        "Chaos Altar",
        35,
        WorldPoint(3060, 3591, 0),
        "chaos_altar_icon.png"
    ),
    ASTRAL_ALTAR("Astral Altar", 40, WorldPoint(2158, 3864, 0), "astral_altar_icon.png"), NATURE_ALTAR(
        "Nature Altar",
        44,
        WorldPoint(2869, 3019, 0),
        "nature_altar_icon.png"
    ),
    LAW_ALTAR("Law Altar", 54, WorldPoint(2858, 3381, 0), "law_altar_icon.png"), DEATH_ALTAR(
        "Death Altar",
        65,
        WorldPoint(1860, 4639, 0),
        "death_altar_icon.png"
    ),
    BLOOD_ALTAR("Blood Altar", 77, WorldPoint(1716, 3827, 0), "blood_altar_icon.png"), SOUL_ALTAR(
        "Soul Altar",
        90,
        WorldPoint(1814, 3856, 0),
        "soul_altar_icon.png"
    ),
    WRATH_ALTAR("Wrath Altar", 95, WorldPoint(2446, 2825, 0), "wrath_altar_icon.png");

    internal val tooltip: String
    internal val location: WorldPoint
    private val levelReq: Int
    internal val iconPath: String

    init {
        tooltip = "$description - Level $level"
        this.location = location
        levelReq = level
        this.iconPath = iconPath
    }
}