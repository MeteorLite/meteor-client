/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
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
package meteor.plugins.agility

import com.google.common.collect.ImmutableList
import com.google.common.collect.ImmutableMultimap
import com.google.common.collect.ImmutableSet
import com.google.common.collect.Multimap
import net.runelite.api.NullObjectID
import net.runelite.api.ObjectID

internal object Obstacles {
    val OBSTACLE_IDS: Set<Int> = ImmutableSet.of( // Gnome
        ObjectID.OBSTACLE_NET_23134,
        ObjectID.TREE_BRANCH_23559,
        ObjectID.TREE_BRANCH_23560,
        ObjectID.OBSTACLE_NET_23135,
        ObjectID.OBSTACLE_PIPE_23138,
        ObjectID.OBSTACLE_PIPE_23139,
        ObjectID.LOG_BALANCE_23145,
        ObjectID.BALANCING_ROPE_23557,  // Brimhaven
        ObjectID.PLANK_3572,
        ObjectID.PLANK_3571,
        ObjectID.PLANK_3570,
        ObjectID.ROPE_SWING,
        ObjectID.PILLAR_3578,
        ObjectID.LOW_WALL,
        ObjectID.LOG_BALANCE,
        ObjectID.LOG_BALANCE_3557,
        ObjectID.BALANCING_LEDGE_3561,
        ObjectID.BALANCING_LEDGE,
        ObjectID.MONKEY_BARS_3564,
        ObjectID.BALANCING_ROPE,
        ObjectID.HAND_HOLDS_3583,  // Draynor
        ObjectID.ROUGH_WALL,
        ObjectID.TIGHTROPE,
        ObjectID.TIGHTROPE_11406,
        ObjectID.NARROW_WALL,
        ObjectID.WALL_11630,
        ObjectID.GAP_11631,
        ObjectID.CRATE_11632,
        ObjectID.STILE_7527,  // Al-Kharid
        ObjectID.ROUGH_WALL_11633,
        ObjectID.TIGHTROPE_14398,
        ObjectID.CABLE,
        ObjectID.ZIP_LINE_14403,
        ObjectID.TROPICAL_TREE_14404,
        ObjectID.ROOF_TOP_BEAMS,
        ObjectID.TIGHTROPE_14409,
        ObjectID.GAP_14399,  // Pyramid
        ObjectID.STAIRS_10857,
        ObjectID.LOW_WALL_10865,
        ObjectID.LEDGE_10860,
        ObjectID.PLANK_10868,
        ObjectID.GAP_10882,
        ObjectID.LEDGE_10886,
        ObjectID.STAIRS_10857,
        ObjectID.GAP_10884,
        ObjectID.GAP_10859,
        ObjectID.GAP_10861,
        ObjectID.LOW_WALL_10865,
        ObjectID.GAP_10859,
        ObjectID.LEDGE_10888,
        ObjectID.PLANK_10868,
        ObjectID.CLIMBING_ROCKS_10851,
        ObjectID.DOORWAY_10855,  // Varrock
        ObjectID.ROUGH_WALL_14412,
        ObjectID.CLOTHES_LINE,
        ObjectID.GAP_14414,
        ObjectID.WALL_14832,
        ObjectID.GAP_14833,
        ObjectID.GAP_14834,
        ObjectID.GAP_14835,
        ObjectID.LEDGE_14836,
        ObjectID.EDGE,  // Penguin
        ObjectID.STEPPING_STONE_21120,
        ObjectID.STEPPING_STONE_21126,
        ObjectID.STEPPING_STONE_21128,
        ObjectID.STEPPING_STONE_21129,
        ObjectID.STEPPING_STONE_21130,
        ObjectID.STEPPING_STONE_21131,
        ObjectID.STEPPING_STONE_21132,
        ObjectID.STEPPING_STONE_21133,
        ObjectID.ICICLES,
        ObjectID.ICE,
        ObjectID.ICE_21149,
        ObjectID.ICE_21150,
        ObjectID.ICE_21151,
        ObjectID.ICE_21152,
        ObjectID.ICE_21153,
        ObjectID.ICE_21154,
        ObjectID.ICE_21155,
        ObjectID.ICE_21156,
        ObjectID.GATE_21172,  // Barbarian
        ObjectID.ROPESWING_23131,
        ObjectID.LOG_BALANCE_23144,
        ObjectID.OBSTACLE_NET_20211,
        ObjectID.BALANCING_LEDGE_23547,
        ObjectID.LADDER_16682,
        ObjectID.CRUMBLING_WALL_1948,  // Canifis
        ObjectID.TALL_TREE_14843,
        ObjectID.GAP_14844,
        ObjectID.GAP_14845,
        ObjectID.GAP_14848,
        ObjectID.GAP_14846,
        ObjectID.POLEVAULT,
        ObjectID.GAP_14847,
        ObjectID.GAP_14897,  // Ape atoll
        ObjectID.STEPPING_STONE_15412,
        ObjectID.TROPICAL_TREE_15414,
        ObjectID.MONKEYBARS_15417,
        ObjectID.SKULL_SLOPE_15483,
        ObjectID.ROPE_15487,
        ObjectID.TROPICAL_TREE_16062,  // Falador
        ObjectID.ROUGH_WALL_14898,
        ObjectID.TIGHTROPE_14899,
        ObjectID.HAND_HOLDS_14901,
        ObjectID.GAP_14903,
        ObjectID.GAP_14904,
        ObjectID.TIGHTROPE_14905,
        ObjectID.TIGHTROPE_14911,
        ObjectID.GAP_14919,
        ObjectID.LEDGE_14920,
        ObjectID.LEDGE_14921,
        ObjectID.LEDGE_14922,
        ObjectID.LEDGE_14923,
        ObjectID.LEDGE_14924,
        ObjectID.EDGE_14925,  // Wilderness
        ObjectID.OBSTACLE_PIPE_23137,
        ObjectID.ROPESWING_23132,
        ObjectID.STEPPING_STONE_23556,
        ObjectID.LOG_BALANCE_23542,
        ObjectID.ROCKS_23640,  // Seers
        ObjectID.WALL_14927,
        ObjectID.GAP_14928,
        ObjectID.TIGHTROPE_14932,
        ObjectID.GAP_14929,
        ObjectID.GAP_14930,
        ObjectID.EDGE_14931,  // Dorgesh-Kaan
        ObjectID.CABLE_22569,
        ObjectID.CABLE_22572,
        ObjectID.LADDER_22564,
        ObjectID.JUTTING_WALL_22552,
        ObjectID.TUNNEL_22557,
        ObjectID.PYLON_22664,
        ObjectID.CONSOLE,
        ObjectID.BOILER_22635,
        ObjectID.STAIRS_22650,
        ObjectID.STAIRS_22651,
        ObjectID.STAIRS_22609,
        ObjectID.STAIRS_22608,  // Pollniveach
        ObjectID.BASKET_14935,
        ObjectID.MARKET_STALL_14936,
        ObjectID.BANNER_14937,
        ObjectID.GAP_14938,
        ObjectID.TREE_14939,
        ObjectID.ROUGH_WALL_14940,
        ObjectID.MONKEYBARS,
        ObjectID.TREE_14944,
        ObjectID.DRYING_LINE,  // Rellaka
        ObjectID.ROUGH_WALL_14946,
        ObjectID.GAP_14947,
        ObjectID.TIGHTROPE_14987,
        ObjectID.GAP_14990,
        ObjectID.GAP_14991,
        ObjectID.TIGHTROPE_14992,
        ObjectID.PILE_OF_FISH,  // Ardougne
        ObjectID.WOODEN_BEAMS,
        ObjectID.GAP_15609,
        ObjectID.PLANK_26635,
        ObjectID.GAP_15610,
        ObjectID.GAP_15611,
        ObjectID.STEEP_ROOF,
        ObjectID.GAP_15612,  // Meiyerditch
        NullObjectID.NULL_12945,
        ObjectID.ROCK_17958,
        ObjectID.ROCK_17959,
        ObjectID.ROCK_17960,
        ObjectID.BOAT_17961,
        NullObjectID.NULL_18122,
        NullObjectID.NULL_18124,
        ObjectID.WALL_RUBBLE,
        ObjectID.WALL_RUBBLE_18038,
        ObjectID.FLOORBOARDS,
        ObjectID.FLOORBOARDS_18071,
        ObjectID.FLOORBOARDS_18072,
        ObjectID.FLOORBOARDS_18073,
        NullObjectID.NULL_18129,
        NullObjectID.NULL_18130,
        ObjectID.WALL_18078,
        NullObjectID.NULL_18132,
        NullObjectID.NULL_18133,
        NullObjectID.NULL_18083,
        ObjectID.TUNNEL_18085,
        ObjectID.SHELF_18086,
        ObjectID.SHELF_18087,
        ObjectID.WALL_18088,
        ObjectID.FLOORBOARDS_18089,
        ObjectID.FLOORBOARDS_18090,
        ObjectID.DOOR_18091,
        ObjectID.FLOORBOARDS_18093,
        ObjectID.FLOORBOARDS_18094,
        ObjectID.SHELF_18095,
        ObjectID.SHELF_18096,
        ObjectID.FLOORBOARDS_18097,
        ObjectID.FLOORBOARDS_18098,
        ObjectID.WASHING_LINE_18099,
        ObjectID.WASHING_LINE_18100,
        NullObjectID.NULL_18135,
        NullObjectID.NULL_18136,
        ObjectID.SHELF_18105,
        ObjectID.SHELF_18106,
        ObjectID.SHELF_18107,
        ObjectID.SHELF_18108,
        ObjectID.FLOORBOARDS_18109,
        ObjectID.FLOORBOARDS_18110,
        ObjectID.FLOORBOARDS_18112,
        ObjectID.FLOORBOARDS_18111,
        ObjectID.FLOORBOARDS_18114,
        ObjectID.FLOORBOARDS_18113,
        NullObjectID.NULL_18116,
        ObjectID.FLOORBOARDS_18117,
        ObjectID.FLOORBOARDS_18118,
        ObjectID.STAIRS_DOWN,
        ObjectID.WALL_17980,
        ObjectID.BARRICADE_18054,
        ObjectID.LADDER_17999,
        ObjectID.LADDER_18000,
        ObjectID.LADDER_18001,
        ObjectID.LADDER_18002,
        ObjectID.ROCKY_SURFACE,
        ObjectID.WALL_39172,
        ObjectID.WALL_39173,  // Werewolf
        ObjectID.STEPPING_STONE_11643,
        ObjectID.HURDLE,
        ObjectID.HURDLE_11639,
        ObjectID.HURDLE_11640,
        ObjectID.PIPE_11657,
        ObjectID.SKULL_SLOPE,
        ObjectID.ZIP_LINE,
        ObjectID.ZIP_LINE_11645,
        ObjectID.ZIP_LINE_11646,  // Prifddinas
        ObjectID.LADDER_36221,
        ObjectID.TIGHTROPE_36225,
        ObjectID.CHIMNEY_36227,
        ObjectID.ROOF_EDGE,
        ObjectID.DARK_HOLE_36229,
        ObjectID.LADDER_36231,
        ObjectID.LADDER_36232,
        ObjectID.ROPE_BRIDGE_36233,
        ObjectID.TIGHTROPE_36234,
        ObjectID.ROPE_BRIDGE_36235,
        ObjectID.TIGHTROPE_36236,
        ObjectID.TIGHTROPE_36237,
        ObjectID.DARK_HOLE_36238,  // Rellekka Lighthouse
        ObjectID.BASALT_ROCK,
        ObjectID.BASALT_ROCK_4553,
        ObjectID.BASALT_ROCK_4554,
        ObjectID.BASALT_ROCK_4556,
        ObjectID.BASALT_ROCK_4558,
        ObjectID.ROCKY_SHORE,
        ObjectID.BASALT_ROCK_4557,
        ObjectID.BASALT_ROCK_4555,
        ObjectID.BASALT_ROCK_4552,
        ObjectID.BEACH,  // Shayzien
        ObjectID.LADDER_42209,
        ObjectID.MONKEYBARS_42211,
        ObjectID.TIGHTROPE_42212,  // Shayzien basic
        ObjectID.BAR_42213,
        ObjectID.TIGHTROPE_42214,
        ObjectID.TIGHTROPE_42215,
        ObjectID.GAP_42216,  // Shayzien hard
        ObjectID.BEAM,
        ObjectID.EDGE_42218,
        ObjectID.EDGE_42219,
        ObjectID.BEAM_42220,
        ObjectID.ZIPLINE
    )
    val PORTAL_OBSTACLE_IDS: Set<Int> = ImmutableSet.of( // Prifddinas portals
        NullObjectID.NULL_36241,
        NullObjectID.NULL_36242,
        NullObjectID.NULL_36243,
        NullObjectID.NULL_36244,
        NullObjectID.NULL_36245,
        NullObjectID.NULL_36246
    )
    var SHORTCUT_OBSTACLE_IDS: Multimap<Int?, AgilityShortcut?>? = null
    val TRAP_OBSTACLE_IDS: Set<Int> = ImmutableSet.of( // Agility pyramid
        NullObjectID.NULL_3550, NullObjectID.NULL_10872, NullObjectID.NULL_10873
    )
    val TRAP_OBSTACLE_REGIONS: List<Int> = ImmutableList.of(12105, 13356)
    val SEPULCHRE_OBSTACLE_IDS: Set<Int> = ImmutableSet.of( // Stairs and Platforms (and one Gate)
        ObjectID.GATE_38460,
        ObjectID.PLATFORM_38455,
        ObjectID.PLATFORM_38456,
        ObjectID.PLATFORM_38457,
        ObjectID.PLATFORM_38458,
        ObjectID.PLATFORM_38459,
        ObjectID.PLATFORM_38470,
        ObjectID.PLATFORM_38477,
        ObjectID.STAIRS_38462,
        ObjectID.STAIRS_38463,
        ObjectID.STAIRS_38464,
        ObjectID.STAIRS_38465,
        ObjectID.STAIRS_38466,
        ObjectID.STAIRS_38467,
        ObjectID.STAIRS_38468,
        ObjectID.STAIRS_38469,
        ObjectID.STAIRS_38471,
        ObjectID.STAIRS_38472,
        ObjectID.STAIRS_38473,
        ObjectID.STAIRS_38474,
        ObjectID.STAIRS_38475,
        ObjectID.STAIRS_38476
    )
    val SEPULCHRE_SKILL_OBSTACLE_IDS: Set<Int> = ImmutableSet.of( // Grapple, Portal, and Bridge skill obstacles
        // They are multilocs, thus we use the NullObjectID
        NullObjectID.NULL_39524,
        NullObjectID.NULL_39525,
        NullObjectID.NULL_39526,
        NullObjectID.NULL_39527,
        NullObjectID.NULL_39528,
        NullObjectID.NULL_39533
    )

    init {
        val builder = ImmutableMultimap.builder<Int, AgilityShortcut>()
        for (item in AgilityShortcut.values()) {
            for (obstacle in item.obstacleIds) {
               builder.put(obstacle,item)
            }
        }
        SHORTCUT_OBSTACLE_IDS = builder.build()
    }
}