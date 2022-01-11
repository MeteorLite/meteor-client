/*
 * Copyright (c) 2018, Torkel Velure <https://github.com/TorkelV>
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

internal enum class FarmingPatchLocation(description: String, vararg locations: WorldPoint) {
    ALLOTMENT(
        "Allotment",
        WorldPoint(3793, 2836, 0),
        WorldPoint(1269, 3730, 0)
    ),
    ALLOTMENT_FLOWER("Allotment/Flower", WorldPoint(3289, 6100, 0)), ALLOTMENT_HERB_FLOWER(
        "Allotment/Herb/Flower",
        WorldPoint(1729, 3558, 0),
        WorldPoint(3598, 3524, 0),
        WorldPoint(3052, 3309, 0),
        WorldPoint(2810, 3462, 0),
        WorldPoint(2663, 3375, 0)
    ),
    ANIMA_HERB("Anima/Herb", WorldPoint(1235, 3724, 0)), BELLADONNA("Belladonna", WorldPoint(3084, 3356, 0)), BUSH(
        "Bush",
        WorldPoint(2938, 3223, 0),
        WorldPoint(2589, 3862, 0),
        WorldPoint(3182, 3356, 0),
        WorldPoint(2615, 3224, 0)
    ),
    BUSH_FLOWER("Bush/Flower", WorldPoint(1259, 3729, 0)), CACTUS(
        "Cactus",
        WorldPoint(3313, 3201, 0),
        WorldPoint(1264, 3745, 0)
    ),
    CALQUAT("Calquat", WorldPoint(2793, 3099, 0)), CELASTRUS_FRUIT_TREE(
        "Celastrus/Fruit Tree",
        WorldPoint(1242, 3755, 0)
    ),
    CRYSTAL_TREE(
        "Crystal Tree",
        WorldPoint(3292, 6120, 0)
    ),
    FRUIT_TREE(
        "Fruit Tree",
        WorldPoint(2487, 3181, 0),
        WorldPoint(2343, 3160, 0),
        WorldPoint(2472, 3445, 0),
        WorldPoint(2858, 3432, 0),
        WorldPoint(2765, 3211, 0)
    ),
    GRAPES("Grapes", WorldPoint(1807, 3555, 0)), HARDWOOD(
        "Hardwood",
        WorldPoint(3707, 3838, 0)
    ),
    HERB(
        "Herb",
        WorldPoint(3789, 2840, 0),
        WorldPoint(2847, 3933, 0),
        WorldPoint(2828, 3696, 0)
    ),
    HESPORI("Hespori", WorldPoint(1182, 10068, 0)), HOPS(
        "Hops",
        WorldPoint(2572, 3102, 0),
        WorldPoint(2661, 3523, 0),
        WorldPoint(3224, 3313, 0),
        WorldPoint(3812, 3334, 0)
    ),
    MUSHROOM("Mushroom", WorldPoint(3449, 3471, 0)), REDWOOD("Redwood", WorldPoint(1233, 3754, 0)), SEAWEED(
        "Seaweed",
        WorldPoint(3730, 10271, 0)
    ),
    SPIRIT_TREE(
        "Spirit Tree",
        WorldPoint(3056, 3259, 0),
        WorldPoint(1690, 3540, 0),
        WorldPoint(3614, 3856, 0),
        WorldPoint(2799, 3205, 0),
        WorldPoint(1254, 3753, 0)
    ),
    TREE(
        "Tree",
        WorldPoint(3226, 3457, 0),
        WorldPoint(2933, 3436, 0),
        WorldPoint(3189, 3233, 0),
        WorldPoint(2434, 3418, 0),
        WorldPoint(3005, 3375, 0),
        WorldPoint(1234, 3736, 0)
    );

    val tooltip: String
    internal val locations: Array<WorldPoint>

    init {
        tooltip = "Farming patch - $description"
        this.locations = locations as Array<WorldPoint>
    }
}