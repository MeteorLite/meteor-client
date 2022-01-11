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

import meteor.plugins.fishing.FishingSpot
import net.runelite.api.coords.WorldPoint
import java.util.*
import java.util.stream.Collectors

enum class FishingSpotLocation {
    AL_KHARID(
        FishingSpot.SHRIMP,
        WorldPoint(3274, 3140, 0), WorldPoint(3266, 3148, 0)
    ),
    APE_ATOLL_SOUTH_WEST(FishingSpot.SHARK, WorldPoint(2698, 2703, 0)), BARBARIAN_OUTPOST(
        FishingSpot.SHRIMP,
        WorldPoint(2497, 3548, 0), WorldPoint(2509, 3562, 0),
        WorldPoint(2514, 3575, 0)
    ),
    BARBARIAN_VILLAGE(
        FishingSpot.SALMON,
        WorldPoint(3103, 3424, 0), WorldPoint(3109, 3433, 0)
    ),
    BRAINDEATH_ISLAND(
        FishingSpot.QUEST_RUM_DEAL,
        WorldPoint(2112, 5074, 0), WorldPoint(2161, 5061, 0),
        WorldPoint(2172, 5074, 0)
    ),
    BRIMHAVEN_QUEST(FishingSpot.QUEST_TAI_BWO_WANNAI_TRIO, WorldPoint(2767, 3165, 0)), BURGH_DE_ROTT_SOUTH(
        FishingSpot.SHARK,
        WorldPoint(3472, 3192, 0), WorldPoint(3486, 3182, 0),
        WorldPoint(3497, 3174, 0), WorldPoint(3513, 3177, 0),
        WorldPoint(3528, 3164, 0), WorldPoint(3537, 3177, 0),
        WorldPoint(3545, 3179, 0), WorldPoint(3553, 3177, 0),
        WorldPoint(3559, 3173, 0), WorldPoint(3564, 3174, 0)
    ),
    CATHERBY(
        arrayOf<FishingSpot>(FishingSpot.SHARK, FishingSpot.LOBSTER, FishingSpot.SHRIMP),
        WorldPoint(2836, 3431, 0), WorldPoint(2844, 3429, 0),
        WorldPoint(2853, 3423, 0), WorldPoint(2859, 3426, 0)
    ),
    DRAYNOR_VILLAGE(FishingSpot.SHRIMP, WorldPoint(3084, 3228, 0)), ENTRANA_CENTER(
        FishingSpot.SALMON,
        WorldPoint(2841, 3356, 0), WorldPoint(2842, 3359, 0),
        WorldPoint(2847, 3361, 0)
    ),
    ENTRANA_DOCK(
        FishingSpot.SHRIMP,
        WorldPoint(2875, 3331, 0), WorldPoint(2878, 3334, 0),
        WorldPoint(2878, 3339, 0), WorldPoint(2875, 3342, 0)
    ),
    ETCETERIA_DOCK(FishingSpot.ETCETERIA_LOBSTER, WorldPoint(2577, 3854, 0)), FAIRY_RING_CKR(
        FishingSpot.KARAMBWANJI,
        WorldPoint(2806, 3014, 0)
    ),
    FAIRY_RING_DKP(
        FishingSpot.KARAMBWAN,
        WorldPoint(2898, 3119, 0), WorldPoint(2911, 3119, 0)
    ),
    FARMING_GUILD_SOUTH_EAST(
        FishingSpot.SALMON,
        WorldPoint(1269, 3707, 0)
    ),
    FARMING_GUILD_SOUTH_WEST1(
        FishingSpot.SHARK,
        WorldPoint(1209, 3687, 0)
    ),
    FARMING_GUILD_SOUTH_WEST2(FishingSpot.SHARK, WorldPoint(1221, 3714, 0)), FARMING_GUILD_WEST(
        FishingSpot.SHARK,
        WorldPoint(1199, 3736, 0), WorldPoint(1208, 3749, 0)
    ),
    FELDIP_HILLS_SOUTH(FishingSpot.SHRIMP, WorldPoint(2511, 2838, 0)), FISHING_CONTEST(
        FishingSpot.QUEST_FISHING_CONTEST,
        WorldPoint(2626, 3415, 0), WorldPoint(2631, 3425, 0),
        WorldPoint(2629, 3435, 0), WorldPoint(2636, 3444, 0)
    ),
    FISHING_GUILD(
        arrayOf<FishingSpot>(FishingSpot.SHARK, FishingSpot.LOBSTER),
        WorldPoint(2604, 3423, 0), WorldPoint(2605, 3417, 0),
        WorldPoint(2611, 3413, 0)
    ),
    FISHING_GUILD_PLATFORM(
        FishingSpot.MINNOW,
        WorldPoint(2609, 3444, 0), WorldPoint(2617, 3444, 0)
    ),
    FISHING_PLATFORM(
        FishingSpot.SHRIMP,
        WorldPoint(2788, 3273, 0), WorldPoint(2794, 3279, 0),
        WorldPoint(2793, 3283, 0)
    ),
    HOSIDIUS_CENTER(FishingSpot.SALMON, WorldPoint(1715, 3612, 0)), HOSIDIUS_EAST(
        arrayOf<FishingSpot>(FishingSpot.SHARK, FishingSpot.LOBSTER, FishingSpot.SHRIMP),
        WorldPoint(1817, 3603, 0), WorldPoint(1827, 3605, 0),
        WorldPoint(1828, 3614, 0), WorldPoint(1840, 3619, 0),
        WorldPoint(1838, 3595, 0)
    ),
    INFIRMARY_SOUTH(FishingSpot.SALMON, WorldPoint(1584, 3566, 0)), IORWERTH_CAMP_INSIDE(
        FishingSpot.SALMON,
        WorldPoint(3239, 5997, 0)
    ),
    IORWERTH_CAMP_NORTH_INSIDE(
        FishingSpot.SHARK,
        WorldPoint(3185, 6027, 0)
    ),
    IORWERTH_CAMP_NORTH_OUTSIDE(FishingSpot.SHARK, WorldPoint(2161, 3275, 0)), IORWERTH_CAMP_OUTSIDE(
        FishingSpot.SALMON,
        WorldPoint(2215, 3245, 0)
    ),
    ISAFDAR_NORTH_EAST_INSIDE(
        FishingSpot.SALMON,
        WorldPoint(3293, 6005, 0)
    ),
    ISAFDAR_NORTH_EAST_OUTSIDE(FishingSpot.SALMON, WorldPoint(2269, 3253, 0)), ISLE_OF_SOULS_EAST(
        FishingSpot.SHARK,
        WorldPoint(2281, 2841, 0)
    ),
    ISLE_OF_SOULS_NORTH(FishingSpot.LOBSTER, WorldPoint(2280, 2975, 0)), ISLE_OF_SOULS_SOUTH_WEST(
        FishingSpot.SHRIMP,
        WorldPoint(2162, 2782, 0)
    ),
    JATISZO(
        arrayOf<FishingSpot>(FishingSpot.SHARK, FishingSpot.LOBSTER),
        WorldPoint(2400, 3780, 0), WorldPoint(2412, 3780, 0),
        WorldPoint(2419, 3789, 0)
    ),
    KHARIDIAN_DESERT_SOUTH_WEST(
        FishingSpot.LOBSTER,
        WorldPoint(3139, 2800, 0)
    ),
    KINGSTOWN_EAST(FishingSpot.SALMON, WorldPoint(1723, 3685, 0)), LANDS_END_EAST(
        FishingSpot.SHRIMP,
        WorldPoint(1534, 3414, 0)
    ),
    LANDS_END_WEST(
        arrayOf<FishingSpot>(FishingSpot.SHARK, FishingSpot.LOBSTER, FishingSpot.SHRIMP),
        WorldPoint(1484, 3432, 0)
    ),
    LUMBRIDGE_RIVER(
        FishingSpot.SALMON,
        WorldPoint(3238, 3241, 0), WorldPoint(3237, 3253, 0)
    ),
    LUMBRIDGE_SWAMP_CAVE_EAST(
        FishingSpot.CAVE_EEL,
        WorldPoint(3244, 9570, 0)
    ),
    LUMBRIDGE_SWAMP_CAVE_WEST(
        FishingSpot.CAVE_EEL,
        WorldPoint(3153, 9544, 0)
    ),
    LUMBRIDGE_SWAMP_SOUTH_EAST(FishingSpot.SHRIMP, WorldPoint(3244, 3153, 0)), MARIM(
        FishingSpot.SHARK,
        WorldPoint(2774, 2740, 0)
    ),
    MOLCH_ISLAND(FishingSpot.COMMON_TENCH, WorldPoint(1370, 3632, 0)), MORTTON(
        FishingSpot.SLIMY_EEL,
        WorldPoint(3439, 3273, 0)
    ),
    MORT_MYRE_SWAMP_NORTH(
        FishingSpot.SLIMY_EEL,
        WorldPoint(3480, 3433, 0), WorldPoint(3485, 3448, 0)
    ),
    MORT_MYRE_SWAMP_WEST(
        FishingSpot.SLIMY_EEL,
        WorldPoint(3425, 3409, 0), WorldPoint(3432, 3415, 0)
    ),
    MOR_UL_REK(
        FishingSpot.INFERNAL_EEL,
        WorldPoint(2443, 5104, 0), WorldPoint(2476, 5077, 0),
        WorldPoint(2537, 5086, 0)
    ),
    MOUNT_QUIDAMORTEM(
        FishingSpot.BARB_FISH,
        WorldPoint(1271, 3546, 0), WorldPoint(1265, 3541, 0),
        WorldPoint(1253, 3542, 0)
    ),
    MUDSKIPPER_POINT(
        FishingSpot.SHRIMP,
        WorldPoint(2995, 3158, 0), WorldPoint(2985, 3176, 0)
    ),
    MUSA_POINT(
        arrayOf<FishingSpot>(FishingSpot.LOBSTER, FishingSpot.SHRIMP),
        WorldPoint(2925, 3179, 0)
    ),
    MYTHS_GUILD_NORTH(FishingSpot.LOBSTER, WorldPoint(2456, 2893, 0)), OBSERVATORY_EAST(
        FishingSpot.SALMON,
        WorldPoint(2466, 3151, 0)
    ),
    OTTOS_GROTTO(
        FishingSpot.BARB_FISH,
        WorldPoint(2500, 3509, 0), WorldPoint(2504, 3495, 0),
        WorldPoint(2505, 3515, 0), WorldPoint(2520, 3518, 0)
    ),
    PISCATORIS(FishingSpot.MONKFISH, WorldPoint(2308, 3700, 0)), PORT_PISCARILIUS_EAST(
        FishingSpot.ANGLERFISH,
        WorldPoint(1831, 3773, 0)
    ),
    PORT_PISCARILIUS_WEST(
        arrayOf<FishingSpot>(FishingSpot.LOBSTER, FishingSpot.SHRIMP),
        WorldPoint(1762, 3796, 0), WorldPoint(1745, 3802, 0)
    ),
    PRIFFDINAS_INSIDE_EAST(
        arrayOf<FishingSpot>(FishingSpot.SHARK, FishingSpot.LOBSTER),
        WorldPoint(3186, 6102, 0), WorldPoint(3187, 6123, 0)
    ),
    PRIFFDINAS_INSIDE_NORTH(
        arrayOf<FishingSpot>(FishingSpot.SHARK, FishingSpot.LOBSTER),
        WorldPoint(3250, 6182, 0), WorldPoint(3258, 6180, 0),
        WorldPoint(3258, 6197, 0)
    ),
    PRIFFDINAS_OUTSIDE_EAST(
        arrayOf<FishingSpot>(FishingSpot.SHARK, FishingSpot.LOBSTER),
        WorldPoint(2162, 3350, 0), WorldPoint(2163, 3371, 0)
    ),
    PRIFFDINAS_OUTSIDE_NORTH(
        arrayOf<FishingSpot>(FishingSpot.SHARK, FishingSpot.LOBSTER),
        WorldPoint(2226, 3430, 0), WorldPoint(2234, 3428, 0),
        WorldPoint(2234, 3445, 0)
    ),
    RELLEKKA_CENTER(FishingSpot.LOBSTER, WorldPoint(2641, 3696, 0)), RELLEKKA_NORTH_EAST(
        FishingSpot.SHARK,
        WorldPoint(2649, 3708, 0)
    ),
    RELLEKKA_WEST(FishingSpot.SHRIMP, WorldPoint(2632, 3694, 0)), RIVER_ARDOUGNE(
        FishingSpot.SALMON,
        WorldPoint(2560, 3374, 0), WorldPoint(2565, 3370, 0),
        WorldPoint(2526, 3412, 0), WorldPoint(2536, 3405, 0),
        WorldPoint(2507, 3420, 0)
    ),
    SAND_CRAB_PENINSULA_NORTH(
        FishingSpot.SHARK,
        WorldPoint(1675, 3490, 0)
    ),
    SAND_CRAB_PENINSULA_SOUTH(
        FishingSpot.SHRIMP,
        WorldPoint(1676, 3469, 0)
    ),
    SAND_CRAB_PENINSULA_WEST(FishingSpot.LOBSTER, WorldPoint(1668, 3479, 0)), SEERS_VILLAGE(
        FishingSpot.SALMON,
        WorldPoint(2725, 3524, 0), WorldPoint(2714, 3531, 0)
    ),
    SHILO_VILLAGE(
        FishingSpot.SALMON,
        WorldPoint(2854, 2977, 0), WorldPoint(2858, 2973, 0)
    ),
    TAVERLEY_DUNGEON(
        FishingSpot.LAVA_EEL,
        WorldPoint(2893, 9764, 0), WorldPoint(2889, 9766, 0),
        WorldPoint(2883, 9765, 0)
    ),
    TEMPOROSS(
        FishingSpot.HARPOONFISH,
        WorldPoint(3047, 3002, 0), WorldPoint(3050, 2995, 0),
        WorldPoint(3036, 2996, 0), WorldPoint(3035, 2962, 0),
        WorldPoint(3047, 2957, 0), WorldPoint(3045, 2954, 0)
    ),
    TREE_GNOME_STRONGHOLD(
        FishingSpot.SALMON,
        WorldPoint(2389, 3422, 0), WorldPoint(2382, 3415, 0)
    ),
    TUTORIAL_ISLAND(FishingSpot.TUTORIAL_SHRIMP, WorldPoint(3100, 3091, 0)), WATSON_HOUSE_SOUTH(
        FishingSpot.SALMON,
        WorldPoint(1646, 3558, 0)
    ),
    WILDERNESS_BANDIT_CAMP(FishingSpot.SHRIMP, WorldPoint(3049, 3704, 0)), WILDERNESS_DARK_CRABS(
        FishingSpot.DARK_CRAB,
        WorldPoint(3362, 3802, 0), WorldPoint(3347, 3813, 0)
    ),
    WILDERNESS_LAVA_MAZE(
        FishingSpot.LAVA_EEL,
        WorldPoint(3071, 3840, 0)
    ),
    WILDERNESS_RESOURCE_AREA(FishingSpot.DARK_CRAB, WorldPoint(3186, 3925, 0)), ZUL_ANDRA(
        FishingSpot.SACRED_EEL,
        WorldPoint(2183, 3068, 0), WorldPoint(2195, 3067, 0)
    );


    val tooltip: String

    constructor(fishingSpot: FishingSpot, vararg locations: WorldPoint) {
        tooltip = fishingSpot.worldMapTooltip

    }

    constructor(fishingSpot: Array<FishingSpot>, vararg locations: WorldPoint?) {
        tooltip = Arrays.stream(fishingSpot).map(FishingSpot::worldMapTooltip)
            .collect(Collectors.joining(" / "))

    }
}