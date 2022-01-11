/*
 * Copyright (c) 2018, Spedwards <https://github.com/Spedwards>
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


internal enum class RareTreeLocation(description: String, level: Int, vararg locations: WorldPoint) {
    WILLOW(
        "Willow tree", 30,  // Kandarin
        WorldPoint(2710, 3510, 0)
    ),
    TEAK(
        "Teak tree", 35,  // Ape Atoll
        WorldPoint(2774, 2697, 0),  // Desert
        WorldPoint(3510, 3073, 0),  // Mos Le'Harmless
        WorldPoint(3832, 3067, 0),  // Karamja
        WorldPoint(2837, 2907, 0),
        WorldPoint(2899, 2897, 0),  // Feldip Hills
        WorldPoint(2333, 3049, 0),  // Prifddinas
        WorldPoint(3309, 6123, 0)
    ),
    SWAYING(
        "Swaying tree", 40,  // The Fremennik Trials
        WorldPoint(2738, 3639, 0)
    ),
    MATURE_JUNIPER(
        "Mature juniper tree", 42,  // Zeah
        WorldPoint(1690, 3524, 0)
    ),
    MAPLE(
        "Maple tree", 45,  // Zeah
        WorldPoint(1231, 3704, 0),
        WorldPoint(1293, 3756, 0),
        WorldPoint(1640, 3496, 0),
        WorldPoint(1613, 3494, 0),
        WorldPoint(1560, 3636, 0),
        WorldPoint(1646, 3590, 0),  // Miscellania
        WorldPoint(2550, 3869, 0),  // Kandarin
        WorldPoint(2712, 3382, 0),
        WorldPoint(2720, 3465, 0),
        WorldPoint(2726, 3501, 0),
        WorldPoint(2728, 3481, 0),
        WorldPoint(2748, 3466, 0),
        WorldPoint(2710, 3570, 0),  // Isle of Souls
        WorldPoint(2254, 2808, 0),  // Prifddinas
        WorldPoint(2209, 3427, 0),
        WorldPoint(3233, 6179, 0)
    ),
    MAHOGANY(
        "Mahogany tree", 50,  // Zeah
        WorldPoint(1237, 3770, 0),  // Ape Atoll
        WorldPoint(2716, 2710, 0),
        WorldPoint(2725, 2735, 0),  // Mos Le'Harmless
        WorldPoint(3824, 3053, 0),  // Karamja
        WorldPoint(2946, 2908, 0),  // Prifddinas
        WorldPoint(3301, 6129, 0)
    ),
    TEAK_MAHOGANY(
        "Teak/Mahogany trees", 50,  // Miscellania
        WorldPoint(2602, 3895, 0),  // Mos Le'Harmless
        WorldPoint(3810, 3058, 0),  // Isle of Souls
        WorldPoint(2194, 2991, 0),  // Karamja
        WorldPoint(2821, 3084, 0)
    ),
    YEW(
        "Yew tree", 60,  // Zeah
        WorldPoint(1217, 3688, 0),
        WorldPoint(1353, 3731, 0),
        WorldPoint(1529, 3452, 0),
        WorldPoint(1591, 3421, 0),
        WorldPoint(1647, 3508, 0),
        WorldPoint(1621, 3512, 0),
        WorldPoint(1593, 3491, 0),
        WorldPoint(1583, 3499, 0),
        WorldPoint(1696, 3554, 0),
        WorldPoint(1625, 3677, 0),
        WorldPoint(1625, 3669, 0),
        WorldPoint(1642, 3683, 0),
        WorldPoint(1642, 3663, 0),
        WorldPoint(1642, 3533, 0),
        WorldPoint(1671, 3657, 0),
        WorldPoint(1680, 3657, 0),
        WorldPoint(1572, 3618, 0),
        WorldPoint(1553, 3551, 0),
        WorldPoint(1496, 3582, 0),  // Tirannwn
        WorldPoint(2217, 3141, 0),  // Prifddinas
        WorldPoint(3288, 6066, 0),
        WorldPoint(3305, 6032, 0),  // Kandarin
        WorldPoint(2315, 3610, 0),
        WorldPoint(2331, 3514, 0),
        WorldPoint(2358, 3510, 0),
        WorldPoint(2360, 3471, 0),
        WorldPoint(2434, 3432, 0),
        WorldPoint(2493, 3396, 0),
        WorldPoint(2495, 3490, 0),
        WorldPoint(2733, 3334, 0),
        WorldPoint(2757, 3431, 0),
        WorldPoint(2714, 3460, 0),  // Asgarnia
        WorldPoint(2995, 3312, 0),
        WorldPoint(3018, 3316, 0),
        WorldPoint(3041, 3320, 0),
        WorldPoint(3052, 3272, 0),
        WorldPoint(2931, 3231, 0),  // Misthalin
        WorldPoint(3085, 3481, 0),
        WorldPoint(3085, 3469, 0),
        WorldPoint(3146, 3255, 0),
        WorldPoint(3151, 3231, 0),
        WorldPoint(3165, 3220, 0),
        WorldPoint(3184, 3227, 0),
        WorldPoint(3251, 3364, 0),
        WorldPoint(3204, 3504, 0),
        WorldPoint(3208, 3500, 0),
        WorldPoint(3221, 3503, 0),
        WorldPoint(3248, 3473, 0),
        WorldPoint(3266, 3494, 0),
        WorldPoint(3270, 3471, 0),
        WorldPoint(3304, 3470, 0),
        WorldPoint(3249, 3202, 0),  // Morytania
        WorldPoint(3674, 3447, 0),
        WorldPoint(3684, 3385, 0),  // Isle of Souls
        WorldPoint(2147, 2972, 0),
        WorldPoint(2165, 2863, 0),  // Zanaris
        WorldPoint(2412, 4464, 0),
        WorldPoint(2465, 4427, 0),
        WorldPoint(2491, 4426, 0)
    ),
    MAPLE_YEW(
        "Maple/Yew trees", 60,  // Feldip Hills
        WorldPoint(2476, 2893, 0)
    ),
    BLISTERWOOD(
        "Blisterwood tree", 62,  // Darkmeyer
        WorldPoint(3631, 3362, 0)
    ),
    SULLIUSCEP(
        "Sulliuscep", 65,  // Fossil Island
        WorldPoint(3662, 3802, 0),
        WorldPoint(3662, 3781, 0),
        WorldPoint(3677, 3806, 0),
        WorldPoint(3677, 3733, 0),
        WorldPoint(3682, 3775, 0),
        WorldPoint(3682, 3758, 0)
    ),
    MAGIC(
        "Magic tree", 75,  // Zeah
        WorldPoint(1373, 3821, 0),
        WorldPoint(1389, 3821, 0),
        WorldPoint(1610, 3443, 0),
        WorldPoint(1578, 3488, 0),
        WorldPoint(1685, 3740, 0),
        WorldPoint(1681, 3689, 0),
        WorldPoint(1751, 3564, 0),
        WorldPoint(1796, 3600, 0),  // Misthalin
        WorldPoint(3355, 3312, 0),
        WorldPoint(3368, 3312, 0),  // Tirannwn
        WorldPoint(2284, 3141, 0),  // Prifddinas
        WorldPoint(3229, 6101, 0),  // Kandarin
        WorldPoint(2371, 3427, 0),
        WorldPoint(2432, 3411, 0),
        WorldPoint(2490, 3414, 0),
        WorldPoint(2704, 3397, 0),
        WorldPoint(2695, 3423, 0),  // Feldip Hills
        WorldPoint(2443, 2845, 0),  // Wilderness
        WorldPoint(3175, 3931, 0)
    ),
    REDWOOD(
        "Redwood tree", 90,  // Zeah
        WorldPoint(1569, 3493, 0),
        WorldPoint(1569, 3483, 0)
    );

    val tooltip: String
    val locations: Array<WorldPoint>
    val levelReq: Int

    init {
        tooltip = "$description - Level $level"
        this.locations = locations as Array<WorldPoint>
        levelReq = level
    }
}