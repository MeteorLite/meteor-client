/*
 * Copyright (c) 2020, melky <https://github.com/melkypie>
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

internal enum class AgilityCourseLocation(val tooltip: String, val location: WorldPoint) {
    AGILITY_PYRAMID("Agility Pyramid", WorldPoint(3347, 2827, 0)), AL_KHARID_ROOFTOP_COURSE(
        "Al Kharid Rooftop Course",
        WorldPoint(3272, 3195, 0)
    ),
    APE_ATOLL_AGILITY_COURSE(
        "Ape Atoll Agility Course",
        WorldPoint(2752, 2742, 0)
    ),
    ARDOUGNE_ROOFTOP_COURSE("Ardougne Rooftop Course", WorldPoint(2673, 3298, 0)), BARBARIAN_OUTPOST_AGILITY_COURSE(
        "Barbarian Outpost Agility Course",
        WorldPoint(2544, 3569, 0)
    ),
    BRIMHAVEN_AGILITY_ARENA(
        "Brimhaven Agility Arena",
        WorldPoint(2806, 3193, 0)
    ),
    CANIFIS_ROOFTOP_COURSE(
        "Canifis Rooftop Course",
        WorldPoint(3506, 3490, 0)
    ),
    DRAYNOR_VILLAGE_ROOFTOP_COURSE("Draynor Village Rooftop Course", WorldPoint(3103, 3279, 0)), FALADOR_ROOFTOP_COURSE(
        "Falador Rooftop Course",
        WorldPoint(3035, 3342, 0)
    ),
    GNOME_STRONGHOLD_AGILITY_COURSE(
        "Gnome Stronghold Agility Course",
        WorldPoint(2474, 3436, 0)
    ),
    PENGUIN_AGILITY_COURSE(
        "Penguin Agility Course",
        WorldPoint(2638, 4041, 0)
    ),
    POLLNIVNEACH_ROOFTOP_COURSE(
        "Pollnivneach Rooftop Course",
        WorldPoint(3350, 2963, 0)
    ),
    PRIFDDINAS_AGILITY_COURSE(
        "Prifddinas Agility Course",
        WorldPoint(3253, 6109, 0)
    ),
    RELLEKKA_ROOFTOP_COURSE(
        "Rellekka Rooftop Course",
        WorldPoint(2624, 3677, 0)
    ),
    SEERS_VILLAGE_ROOFTOP_COURSE(
        "Seers' Village Rooftop Course",
        WorldPoint(2728, 3488, 0)
    ),
    SHAYZIEN_COURSE(
        "Shayzien Agility Course",
        WorldPoint(1551, 3632, 0)
    ),
    VARROCK_ROOFTOP_COURSE(
        "Varrock Rooftop Course",
        WorldPoint(3219, 3414, 0)
    ),
    WEREWOLF_AGILITY_COURSE(
        "Werewolf Agility Course",
        WorldPoint(3542, 3463, 0)
    ),
    WILDERNESS_AGILITY_COURSE("Wilderness Agility Course", WorldPoint(2997, 3916, 0));

    val rooftopCourse: Boolean = name.contains("ROOFTOP_COURSE")

}