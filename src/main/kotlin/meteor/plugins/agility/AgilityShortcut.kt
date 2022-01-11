/*
 * Copyright (c) 2018, SomeoneWithAnInternetConnection
 * Copyright (c) 2019, MrGroggle
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

import net.runelite.api.coords.WorldPoint
import net.runelite.api.ObjectID
import net.runelite.api.NullObjectID
import net.runelite.api.TileObject

enum class AgilityShortcut(
    /**
     * The agility level required to pass the shortcut
     */
    val level: Int,
    /**
     * Brief description of the shortcut. (e.g. 'Rocks', 'Stepping Stones', 'Jump')
     */
    val description: String,
    /**
     * The location of the Shortcut icon on the world map (null if there is no icon)
     */
    val worldMapLocation: WorldPoint?,
    /**
     * An optional location in case the location of the shortcut icon is either null or isn't close
     * enough to the obstacle
     */
     val worldLocation: WorldPoint?,
    /**
     * Array of obstacles, null objects, decorations etc. that this shortcut uses. Typically an
     * ObjectID/NullObjectID
     */
     vararg val obstacleIds: Int
) {
    GENERIC_SHORTCUT(
        1,
        "Shortcut",
        null,  // Trollheim
        ObjectID.ROCKS_3790,
        ObjectID.ROCKS_3791,  // Fremennik Slayer Cave
        ObjectID.STEPS_29993,  // Fossil Island
        ObjectID.LADDER_30938,
        ObjectID.LADDER_30939,
        ObjectID.LADDER_30940,
        ObjectID.LADDER_30941,
        ObjectID.RUBBER_CAP_MUSHROOM,  // Brimhaven dungeon
        ObjectID.CREVICE_30198,  // Lumbridge
        ObjectID.STILE_12982,  // Gu'Tanoth Bridge
        ObjectID.GAP,
        ObjectID.GAP_2831,  // Lumbridge Swamp Caves
        ObjectID.STEPPING_STONE_5948,
        ObjectID.STEPPING_STONE_5949,
        ObjectID.ROCKS_6673,  // Morytania Pirate Ship
        ObjectID.ROCK_16115,  // Lumber Yard
        ObjectID.BROKEN_FENCE_2618,  // McGrubor's Wood
        ObjectID.LOOSE_RAILING,  // Underwater Area Fossil Island
        ObjectID.TUNNEL_30959,
        ObjectID.HOLE_30966,
        ObjectID.OBSTACLE,
        ObjectID.OBSTACLE_30767,
        ObjectID.OBSTACLE_30964,
        ObjectID.OBSTACLE_30962,
        ObjectID.PLANT_DOOR_30961,  // Tree Gnome Village
        ObjectID.LOOSE_RAILING_2186,  // Burgh de Rott
        ObjectID.LOW_FENCE,  // Taverley
        ObjectID.STILE,  // Asgarnian Ice Dungeon
        ObjectID.STEPS,  // Fossil Island Wyvern Cave
        ObjectID.STAIRS_31485,  // Trollweiss Mountain Cave
        ObjectID.ROCKY_HANDHOLDS,
        ObjectID.ROCKY_HANDHOLDS_19847,  // Witchaven Dungeon
        ObjectID.SHORTCUT
    ),
    BRIMHAVEN_DUNGEON_MEDIUM_PIPE_RETURN(
        1, "Pipe Squeeze", null, WorldPoint(2698, 9491, 0),
        ObjectID.PIPE_21727
    ),
    BRIMHAVEN_DUNGEON_PIPE_RETURN(
        1,
        "Pipe Squeeze",
        null,
        WorldPoint(2655, 9573, 0),
        ObjectID.PIPE_21728
    ),
    BRIMHAVEN_DUNGEON_STEPPING_STONES_RETURN(
        1,
        "Pipe Squeeze",
        null,
        ObjectID.STEPPING_STONE_21739
    ),
    BRIMHAVEN_DUNGEON_LOG_BALANCE_RETURN(
        1,
        "Log Balance",
        null,
        ObjectID.LOG_BALANCE_20884
    ),
    AGILITY_PYRAMID_ROCKS_WEST(1, "Rocks", null, ObjectID.CLIMBING_ROCKS_11948), CAIRN_ISLE_CLIMBING_ROCKS(
        1,
        "Rocks",
        null,
        ObjectID.CLIMBING_ROCKS
    ),
    KARAMJA_GLIDER_LOG(1, "Log Balance", WorldPoint(2906, 3050, 0), ObjectID.A_WOODEN_LOG), FALADOR_CRUMBLING_WALL(
        5,
        "Crumbling Wall",
        WorldPoint(2936, 3357, 0),
        ObjectID.CRUMBLING_WALL_24222
    ),
    RIVER_LUM_GRAPPLE_WEST(
        8,
        "Grapple Broken Raft",
        WorldPoint(3245, 3179, 0),
        ObjectID.BROKEN_RAFT
    ),
    RIVER_LUM_GRAPPLE_EAST(
        8,
        "Grapple Broken Raft",
        WorldPoint(3258, 3179, 0),
        ObjectID.BROKEN_RAFT
    ),
    CORSAIR_COVE_ROCKS(10, "Rocks", WorldPoint(2545, 2871, 0), ObjectID.ROCKS_31757), KARAMJA_MOSS_GIANT_SWING(
        10,
        "Rope",
        null,
        ObjectID.ROPESWING_23568,
        ObjectID.ROPESWING_23569
    ),
    FALADOR_GRAPPLE_WALL(
        11,
        "Grapple Wall",
        WorldPoint(3031, 3391, 0),
        ObjectID.WALL_17049,
        ObjectID.WALL_17050
    ),
    BRIMHAVEN_DUNGEON_STEPPING_STONES(12, "Stepping Stones", null, ObjectID.STEPPING_STONE_21738), VARROCK_SOUTH_FENCE(
        13,
        "Fence",
        WorldPoint(3239, 3334, 0),
        ObjectID.FENCE_16518
    ),
    GOBLIN_VILLAGE_WALL(14, "Wall", WorldPoint(2925, 3523, 0), ObjectID.TIGHTGAP), CORSAIR_COVE_DUNGEON_PILLAR(
        15,
        "Pillar Jump",
        WorldPoint(1980, 8996, 0),
        ObjectID.PILLAR_31809
    ),
    EDGEVILLE_DUNGEON_MONKEYBARS(15, "Monkey Bars", null, ObjectID.MONKEYBARS_23566), TROLLHEIM_ROCKS(
        15, "Rocks", null, WorldPoint(2838, 3614, 0),
        ObjectID.ROCKS_3748
    ),  // No fixed world map location, but rocks near death plateau have a requirement of 15
    YANILLE_UNDERWALL_TUNNEL(
        16, "Underwall Tunnel", WorldPoint(2574, 3109, 0), ObjectID.HOLE_16520,
        ObjectID.CASTLE_WALL
    ),
    KOUREND_CATACOMBS_SOUTH_WEST_CREVICE_NORTH(
        17, "Crevice", WorldPoint(1647, 10008, 0),
        ObjectID.CRACK_28892
    ),
    KOUREND_CATACOMBS_SOUTH_WEST_CREVICE_SOUTH(
        17, "Crevice", WorldPoint(1645, 10001, 0),
        ObjectID.CRACK_28892
    ),
    CRABCLAW_CAVES_CREVICE(
        18, "Crevice", WorldPoint(1710, 9822, 0), ObjectID.CREVICE_31695,
        ObjectID.CREVICE_31696
    ),
    CRABCLAW_CAVES_ROCKS(18, "Rocks", WorldPoint(1687, 9802, 0), ObjectID.ROCKS_31697), CRABCLAW_CAVES_STEPPING_STONES(
        18, "Stepping Stones", WorldPoint(1704, 9800, 0),
        ObjectID.STEPPING_STONE_31699
    ),
    YANILLE_WATCHTOWER_TRELLIS(18, "Trellis", null, ObjectID.TRELLIS_20056), COAL_TRUCKS_LOG_BALANCE(
        20,
        "Log Balance",
        WorldPoint(2598, 3475, 0),
        ObjectID.LOG_BALANCE_23274
    ),
    GRAND_EXCHANGE_UNDERWALL_TUNNEL(
        21, "Underwall Tunnel", WorldPoint(3139, 3515, 0),
        ObjectID.UNDERWALL_TUNNEL_16529, ObjectID.UNDERWALL_TUNNEL_16530
    ),
    BRIMHAVEN_DUNGEON_PIPE(22, "Pipe Squeeze", WorldPoint(2654, 9569, 0), ObjectID.PIPE_21728), OBSERVATORY_SCALE_CLIFF(
        23,
        "Grapple Rocks",
        WorldPoint(2447, 3155, 0),
        NullObjectID.NULL_31849,
        NullObjectID.NULL_31852
    ),
    EAGLES_PEAK_ROCK_CLIMB(25, "Rock Climb", WorldPoint(2320, 3499, 0), ObjectID.ROCKS_19849), FALADOR_UNDERWALL_TUNNEL(
        26, "Underwall Tunnel", WorldPoint(2947, 3313, 0), ObjectID.UNDERWALL_TUNNEL,
        ObjectID.UNDERWALL_TUNNEL_16528
    ),
    KOUREND_CATACOMBS_PILLAR_JUMP_NORTH(
        28,
        "Pillar Jump",
        WorldPoint(1613, 10071, 0)
    ),
    KOUREND_CATACOMBS_PILLAR_JUMP_SOUTH(28, "Pillar Jump", WorldPoint(1609, 10060, 0)), MOUNT_KARUULM_LOWER(
        29,
        "Rocks",
        WorldPoint(1324, 3782, 0),
        ObjectID.ROCKS_34397
    ),
    CORSAIR_COVE_RESOURCE_ROCKS(
        30,
        "Rocks",
        WorldPoint(2486, 2898, 0),
        ObjectID.ROCKS_31758,
        ObjectID.ROCKS_31759
    ),
    SOUTHEAST_KARAJMA_STEPPING_STONES(
        30, "Stepping Stones", WorldPoint(2924, 2946, 0),
        ObjectID.STEPPING_STONES, ObjectID.STEPPING_STONES_23646, ObjectID.STEPPING_STONES_23647
    ),
    BRIMHAVEN_DUNGEON_LOG_BALANCE(30, "Log Balance", null, ObjectID.LOG_BALANCE_20882), AGILITY_PYRAMID_ROCKS_EAST(
        30,
        "Rocks",
        null,
        ObjectID.CLIMBING_ROCKS_11949
    ),
    DRAYNOR_MANOR_STEPPING_STONES(
        31, "Stepping Stones", WorldPoint(3150, 3362, 0),
        ObjectID.STEPPING_STONE_16533
    ),
    CATHERBY_CLIFFSIDE_GRAPPLE(
        32,
        "Grapple Rock",
        WorldPoint(2868, 3429, 0),
        ObjectID.ROCKS_17042
    ),
    CAIRN_ISLE_ROCKS(32, "Rocks", null, ObjectID.ROCKS_2231), ARDOUGNE_LOG_BALANCE(
        33, "Log Balance", WorldPoint(2602, 3336, 0), ObjectID.LOG_BALANCE_16546,
        ObjectID.LOG_BALANCE_16547, ObjectID.LOG_BALANCE_16548
    ),
    BRIMHAVEN_DUNGEON_MEDIUM_PIPE(
        34, "Pipe Squeeze", null, WorldPoint(2698, 9501, 0),
        ObjectID.PIPE_21727
    ),
    KOUREND_CATACOMBS_NORTH_EAST_CREVICE_NORTH(
        34, "Crevice", WorldPoint(1715, 10057, 0),
        ObjectID.CRACK_28892
    ),
    KOUREND_CATACOMBS_NORTH_EAST_CREVICE_SOUTH(
        34, "Crevice", WorldPoint(1705, 10077, 0),
        ObjectID.CRACK_28892
    ),
    CATHERBY_OBELISK_GRAPPLE(36, "Grapple Rock", null, ObjectID.CROSSBOW_TREE_17062), GNOME_STRONGHOLD_ROCKS(
        37,
        "Rocks",
        WorldPoint(2485, 3515, 0),
        ObjectID.ROCKS_16534,
        ObjectID.ROCKS_16535
    ),
    AL_KHARID_MINING_PITCLIFF_SCRAMBLE(
        38, "Rocks", WorldPoint(3305, 3315, 0), ObjectID.ROCKS_16549,
        ObjectID.ROCKS_16550
    ),
    YANILLE_WALL_GRAPPLE(39, "Grapple Wall", WorldPoint(2552, 3072, 0), ObjectID.WALL_17047), NEITIZNOT_BRIDGE_REPAIR(
        0, "Bridge Repair - Quest", WorldPoint(2315, 3828, 0),
        ObjectID.ROPE_BRIDGE_21306, ObjectID.ROPE_BRIDGE_21307
    ),
    NEITIZNOT_BRIDGE_SOUTHEAST(
        0,
        "Rope Bridge",
        null,
        ObjectID.ROPE_BRIDGE_21308,
        ObjectID.ROPE_BRIDGE_21309
    ),
    NEITIZNOT_BRIDGE_NORTHWEST(
        0,
        "Rope Bridge",
        null,
        ObjectID.ROPE_BRIDGE_21310,
        ObjectID.ROPE_BRIDGE_21311
    ),
    NEITIZNOT_BRIDGE_NORTH(
        0,
        "Rope Bridge",
        null,
        ObjectID.ROPE_BRIDGE_21312,
        ObjectID.ROPE_BRIDGE_21313
    ),
    NEITIZNOT_BRIDGE_NORTHEAST(
        40,
        "Broken Rope bridge",
        null,
        ObjectID.ROPE_BRIDGE_21314,
        ObjectID.ROPE_BRIDGE_21315
    ),
    KOUREND_LAKE_JUMP_EAST(
        40, "Stepping Stones", WorldPoint(1612, 3570, 0), ObjectID.STEPPING_STONE_29729,
        ObjectID.STEPPING_STONE_29730
    ),
    KOUREND_LAKE_JUMP_WEST(
        40, "Stepping Stones", WorldPoint(1604, 3572, 0), ObjectID.STEPPING_STONE_29729,
        ObjectID.STEPPING_STONE_29730
    ),
    YANILLE_DUNGEON_BALANCE(40, "Balancing Ledge", null, ObjectID.BALANCING_LEDGE_23548), TROLLHEIM_EASY_CLIFF_SCRAMBLE(
        41,
        "Rocks",
        WorldPoint(2869, 3670, 0),
        ObjectID.ROCKS_16521
    ),
    DWARVEN_MINE_NARROW_CREVICE(
        42,
        "Narrow Crevice",
        WorldPoint(3034, 9806, 0),
        ObjectID.CREVICE_16543
    ),
    DRAYNOR_UNDERWALL_TUNNEL(
        42, "Underwall Tunnel", WorldPoint(3068, 3261, 0),
        ObjectID.UNDERWALL_TUNNEL_19032, ObjectID.UNDERWALL_TUNNEL_19036
    ),
    TROLLHEIM_MEDIUM_CLIFF_SCRAMBLE_NORTH(
        43, "Rocks", WorldPoint(2886, 3684, 0), ObjectID.ROCKS_3803,
        ObjectID.ROCKS_3804, ObjectID.ROCKS_16522
    ),
    TROLLHEIM_MEDIUM_CLIFF_SCRAMBLE_SOUTH(
        43, "Rocks", WorldPoint(2876, 3666, 0), ObjectID.ROCKS_3803,
        ObjectID.ROCKS_3804, ObjectID.ROCKS_16522
    ),
    TROLLHEIM_ADVANCED_CLIFF_SCRAMBLE(
        44, "Rocks", WorldPoint(2907, 3686, 0), ObjectID.ROCKS_16523,
        ObjectID.ROCKS_3748
    ),
    KOUREND_RIVER_STEPPING_STONES(
        45, "Stepping Stones", WorldPoint(1720, 3551, 0),
        ObjectID.STEPPING_STONE_29728
    ),
    TIRANNWN_LOG_BALANCE(
        45, "Log Balance", null, ObjectID.LOG_BALANCE_3933, ObjectID.LOG_BALANCE_3931,
        ObjectID.LOG_BALANCE_3930, ObjectID.LOG_BALANCE_3929, ObjectID.LOG_BALANCE_3932
    ),
    COSMIC_ALTAR_MEDIUM_WALKWAY(
        46, "Narrow Walkway", WorldPoint(2399, 4403, 0),
        ObjectID.JUTTING_WALL_17002
    ),
    DEEP_WILDERNESS_DUNGEON_CREVICE_NORTH(
        46, "Narrow Crevice", WorldPoint(3047, 10335, 0),
        ObjectID.CREVICE_19043
    ),
    DEEP_WILDERNESS_DUNGEON_CREVICE_SOUTH(
        46, "Narrow Crevice", WorldPoint(3045, 10327, 0),
        ObjectID.CREVICE_19043
    ),
    TROLLHEIM_HARD_CLIFF_SCRAMBLE(47, "Rocks", WorldPoint(2902, 3680, 0), ObjectID.ROCKS_16524), FREMENNIK_LOG_BALANCE(
        48, "Log Balance", WorldPoint(2721, 3591, 0), ObjectID.LOG_BALANCE_16540,
        ObjectID.LOG_BALANCE_16541, ObjectID.LOG_BALANCE_16542
    ),
    YANILLE_DUNGEON_PIPE_SQUEEZE(49, "Pipe Squeeze", null, ObjectID.OBSTACLE_PIPE_23140), ARCEUUS_ESSENCE_MINE_BOULDER(
        49,
        "Boulder",
        WorldPoint(1774, 3888, 0),
        ObjectID.BOULDER_27990
    ),
    MORYTANIA_STEPPING_STONE(
        50, "Stepping Stone", WorldPoint(3418, 3326, 0),
        ObjectID.STEPPING_STONE_13504
    ),
    VARROCK_SEWERS_PIPE_SQUEEZE(
        51, "Pipe Squeeze", WorldPoint(3152, 9905, 0),
        ObjectID.OBSTACLE_PIPE_16511
    ),
    ARCEUUS_ESSENCE_MINE_EAST_SCRAMBLE(
        52, "Rock Climb", WorldPoint(1770, 3851, 0), ObjectID.ROCKS_27987,
        ObjectID.ROCKS_27988
    ),
    KARAMJA_VOLCANO_GRAPPLE_NORTH(
        53, "Grapple Rock", WorldPoint(2873, 3143, 0),
        ObjectID.STRONG_TREE_17074
    ),
    KARAMJA_VOLCANO_GRAPPLE_SOUTH(
        53, "Grapple Rock", WorldPoint(2874, 3128, 0),
        ObjectID.STRONG_TREE_17074
    ),
    MOTHERLODE_MINE_WALL_EAST(
        54,
        "Wall",
        WorldPoint(3124, 9703, 0),
        ObjectID.DARK_TUNNEL_10047
    ),
    MOTHERLODE_MINE_WALL_WEST(
        54,
        "Wall",
        WorldPoint(3118, 9702, 0),
        ObjectID.DARK_TUNNEL_10047
    ),
    MISCELLANIA_DOCK_STEPPING_STONE(
        55, "Stepping Stone", WorldPoint(2572, 3862, 0),
        ObjectID.STEPPING_STONE_11768
    ),
    ISAFDAR_FOREST_OBSTACLES(
        56,
        "Trap",
        null,
        ObjectID.DENSE_FOREST_3938,
        ObjectID.DENSE_FOREST_3939,
        ObjectID.DENSE_FOREST_3998,
        ObjectID.DENSE_FOREST_3999,
        ObjectID.DENSE_FOREST,
        ObjectID.LEAVES,
        ObjectID.LEAVES_3924,
        ObjectID.LEAVES_3925,
        ObjectID.STICKS,
        ObjectID.TRIPWIRE,
        ObjectID.TRIPWIRE_3921
    ),
    RELEKKA_EAST_FENCE(57, "Fence", WorldPoint(2688, 3697, 0), ObjectID.BROKEN_FENCE), YANILLE_DUNGEON_MONKEY_BARS(
        57,
        "Monkey Bars",
        null,
        ObjectID.MONKEYBARS_23567
    ),
    PHASMATYS_ECTOPOOL_SHORTCUT(
        58,
        "Weathered Wall",
        null,
        ObjectID.WEATHERED_WALL,
        ObjectID.WEATHERED_WALL_16526
    ),
    ELVEN_OVERPASS_CLIFF_SCRAMBLE(
        59, "Rocks", WorldPoint(2345, 3300, 0), ObjectID.ROCKS_16514,
        ObjectID.ROCKS_16515
    ),
    ELVEN_OVERPASS_CLIFF_SCRAMBLE_PRIFDDINAS(
        59, "Rocks", WorldPoint(3369, 6052, 0), ObjectID.ROCKS_16514,
        ObjectID.ROCKS_16515
    ),
    WILDERNESS_GWD_CLIMB_EAST(
        60,
        "Rocks",
        WorldPoint(2943, 3770, 0),
        ObjectID.ROCKY_HANDHOLDS_26400,
        ObjectID.ROCKY_HANDHOLDS_26401,
        ObjectID.ROCKY_HANDHOLDS_26402,
        ObjectID.ROCKY_HANDHOLDS_26404,
        ObjectID.ROCKY_HANDHOLDS_26405,
        ObjectID.ROCKY_HANDHOLDS_26406
    ),
    WILDERNESS_GWD_CLIMB_WEST(
        60,
        "Rocks",
        WorldPoint(2928, 3760, 0),
        ObjectID.ROCKY_HANDHOLDS_26400,
        ObjectID.ROCKY_HANDHOLDS_26401,
        ObjectID.ROCKY_HANDHOLDS_26402,
        ObjectID.ROCKY_HANDHOLDS_26404,
        ObjectID.ROCKY_HANDHOLDS_26405,
        ObjectID.ROCKY_HANDHOLDS_26406
    ),
    MOS_LEHARMLESS_STEPPING_STONE(
        60, "Stepping Stone", WorldPoint(3710, 2970, 0),
        ObjectID.STEPPING_STONE_19042
    ),
    WINTERTODT_GAP(60, "Gap", WorldPoint(1629, 4023, 0), ObjectID.GAP_29326), UNGAEL_ICE(
        60,
        "Ice Chunks",
        null,
        NullObjectID.NULL_25337,
        NullObjectID.NULL_29868,
        NullObjectID.NULL_29869,
        NullObjectID.NULL_29870,
        ObjectID.ICE_CHUNKS_31822,
        NullObjectID.NULL_31823,
        ObjectID.ICE_CHUNKS_31990
    ),
    GWD_LITTLE_CRACK(
        60,
        "Little Crack",
        WorldPoint(2900, 3712, 0),
        ObjectID.LITTLE_CRACK
    ),
    SLAYER_TOWER_MEDIUM_CHAIN_FIRST(
        61, "Spiked Chain (Floor 1)", WorldPoint(3421, 3550, 0),
        ObjectID.SPIKEY_CHAIN
    ),
    SLAYER_TOWER_MEDIUM_CHAIN_SECOND(
        61, "Spiked Chain (Floor 2)", WorldPoint(3420, 3551, 0),
        ObjectID.SPIKEY_CHAIN_16538
    ),
    SLAYER_DUNGEON_CREVICE(
        62,
        "Narrow Crevice",
        WorldPoint(2729, 10008, 0),
        ObjectID.CREVICE_16539
    ),
    MOUNT_KARUULM_UPPER(62, "Rocks", WorldPoint(1322, 3791, 0), ObjectID.ROCKS_34396), TAVERLEY_DUNGEON_RAILING(
        63,
        "Loose Railing",
        WorldPoint(2935, 9811, 0),
        ObjectID.LOOSE_RAILING_28849
    ),
    DARKMEYER_WALL(
        63,
        "Wall (Long rope)",
        WorldPoint(3669, 3375, 0),
        NullObjectID.NULL_39541,
        NullObjectID.NULL_39542
    ),
    TROLLHEIM_WILDERNESS_ROCKS_EAST(
        64,
        "Rocks",
        WorldPoint(2945, 3678, 0),
        ObjectID.ROCKS_16545
    ),
    TROLLHEIM_WILDERNESS_ROCKS_WEST(
        64,
        "Rocks",
        WorldPoint(2917, 3672, 0),
        ObjectID.ROCKS_16545
    ),
    FOSSIL_ISLAND_VOLCANO(
        64,
        "Rope",
        WorldPoint(3780, 3822, 0),
        ObjectID.ROPE_ANCHOR,
        ObjectID.ROPE_ANCHOR_30917
    ),
    MORYTANIA_TEMPLE(
        65, "Loose Railing", WorldPoint(3422, 3476, 0), ObjectID.ROCKS_16998, ObjectID.ROCKS_16999,
        ObjectID.ORNATE_RAILING, ObjectID.ORNATE_RAILING_17000
    ),
    REVENANT_CAVES_GREEN_DRAGONS(
        65,
        "Jump",
        WorldPoint(3220, 10086, 0),
        ObjectID.PILLAR_31561
    ),
    COSMIC_ALTAR_ADVANCED_WALKWAY(
        66, "Narrow Walkway", WorldPoint(2408, 4401, 0),
        ObjectID.JUTTING_WALL_17002
    ),
    LUMBRIDGE_DESERT_STEPPING_STONE(
        66, "Stepping Stone", WorldPoint(3210, 3135, 0),
        ObjectID.STEPPING_STONE_16513
    ),
    HEROES_GUILD_TUNNEL_EAST(
        67, "Crevice", WorldPoint(2898, 9901, 0), ObjectID.CREVICE_9739,
        ObjectID.CREVICE_9740
    ),
    HEROES_GUILD_TUNNEL_WEST(
        67, "Crevice", WorldPoint(2913, 9895, 0), ObjectID.CREVICE_9739,
        ObjectID.CREVICE_9740
    ),
    YANILLE_DUNGEON_RUBBLE_CLIMB(
        67, "Pile of Rubble", null, ObjectID.PILE_OF_RUBBLE_23563,
        ObjectID.PILE_OF_RUBBLE_23564
    ),
    ELVEN_OVERPASS_MEDIUM_CLIFF(
        68,
        "Rocks",
        WorldPoint(2337, 3288, 0),
        ObjectID.ROCKS_16514,
        ObjectID.ROCKS_16515
    ),
    ELVEN_OVERPASS_MEDIUM_CLIFF_PRIFDDINAS(
        68, "Rocks", WorldPoint(3361, 6040, 0), ObjectID.ROCKS_16514,
        ObjectID.ROCKS_16515
    ),
    WEISS_OBSTACLES(
        68,
        "Shortcut",
        null,
        ObjectID.LITTLE_BOULDER,
        ObjectID.ROCKSLIDE_33184,
        ObjectID.ROCKSLIDE_33185,
        NullObjectID.NULL_33327,
        NullObjectID.NULL_33328,
        ObjectID.LEDGE_33190,
        ObjectID.ROCKSLIDE_33191,
        ObjectID.FALLEN_TREE_33192
    ),
    ARCEUUS_ESSENSE_NORTH(
        69,
        "Rock Climb",
        WorldPoint(1759, 3873, 0),
        ObjectID.ROCKS_34741
    ),
    TAVERLEY_DUNGEON_PIPE_BLUE_DRAGON(
        70, "Pipe Squeeze", WorldPoint(2886, 9798, 0),
        ObjectID.OBSTACLE_PIPE_16509
    ),
    TAVERLEY_DUNGEON_ROCKS_NORTH(
        70,
        "Rocks",
        WorldPoint(2887, 9823, 0),
        ObjectID.ROCKS,
        ObjectID.ROCKS_14106
    ),
    TAVERLEY_DUNGEON_ROCKS_SOUTH(
        70,
        "Rocks",
        WorldPoint(2887, 9631, 0),
        ObjectID.ROCKS,
        ObjectID.ROCKS_14106
    ),
    FOSSIL_ISLAND_HARDWOOD_NORTH(
        70,
        "Hole",
        WorldPoint(3712, 3828, 0),
        ObjectID.HOLE_31481,
        ObjectID.HOLE_31482
    ),
    FOSSIL_ISLAND_HARDWOOD_SOUTH(
        70,
        "Hole",
        WorldPoint(3714, 3816, 0),
        ObjectID.HOLE_31481,
        ObjectID.HOLE_31482
    ),
    AL_KHARID_WINDOW(70, "Window", WorldPoint(3293, 3158, 0), ObjectID.BROKEN_WALL_33344, ObjectID.BIG_WINDOW) {
        override fun matches(`object`: TileObject): Boolean {
            // there are two BIG_WINDOW objects right next to each other here, but only this one is valid
            return `object`.id != ObjectID.BIG_WINDOW || (`object`.worldLocation
                    == WorldPoint(3295, 3158, 0))
        }
    },
    GWD_SARADOMIN_ROPE_NORTH(
        70, "Rope Descent", WorldPoint(2912, 5300, 0), NullObjectID.NULL_26371,
        NullObjectID.NULL_26561
    ),
    GWD_SARADOMIN_ROPE_SOUTH(
        70, "Rope Descent", WorldPoint(2951, 5267, 0), NullObjectID.NULL_26375,
        NullObjectID.NULL_26562
    ),
    GU_TANOTH_CRUMBLING_WALL(
        71, "Rocks", WorldPoint(2545, 3032, 0), ObjectID.CRUMBLING_WALL_40355,
        ObjectID.ROCKS_40356
    ),
    SLAYER_TOWER_ADVANCED_CHAIN_FIRST(
        71, "Spiked Chain (Floor 2)", WorldPoint(3447, 3578, 0),
        ObjectID.SPIKEY_CHAIN
    ),
    SLAYER_TOWER_ADVANCED_CHAIN_SECOND(
        71, "Spiked Chain (Floor 3)", WorldPoint(3446, 3576, 0),
        ObjectID.SPIKEY_CHAIN_16538
    ),
    STRONGHOLD_SLAYER_CAVE_TUNNEL(
        72, "Tunnel", WorldPoint(2431, 9806, 0), ObjectID.TUNNEL_30174,
        ObjectID.TUNNEL_30175
    ),
    TROLL_STRONGHOLD_WALL_CLIMB(
        73,
        "Rocks",
        WorldPoint(2841, 3694, 0),
        ObjectID.ROCKS_16464
    ),
    ARCEUUS_ESSENSE_MINE_WEST(
        73, "Rock Climb", WorldPoint(1742, 3853, 0), ObjectID.ROCKS_27984,
        ObjectID.ROCKS_27985
    ),
    LAVA_DRAGON_ISLE_JUMP(
        74,
        "Stepping Stone",
        WorldPoint(3200, 3807, 0),
        ObjectID.STEPPING_STONE_14918
    ),
    FORTHOS_DUNGEON_SPIKED_BLADES(
        75, "Spiked Blades", WorldPoint(1819, 9946, 0),
        ObjectID.STRANGE_FLOOR_34834
    ),
    REVENANT_CAVES_DEMONS_JUMP(
        75,
        "Jump",
        WorldPoint(3199, 10135, 0),
        ObjectID.PILLAR_31561
    ),
    REVENANT_CAVES_ANKOU_EAST(
        75,
        "Jump",
        WorldPoint(3201, 10195, 0),
        ObjectID.PILLAR_31561
    ),
    REVENANT_CAVES_ANKOU_NORTH(
        75,
        "Jump",
        WorldPoint(3180, 10209, 0),
        ObjectID.PILLAR_31561
    ),
    ZUL_ANDRA_ISLAND_CROSSING(
        76, "Stepping Stone", WorldPoint(2156, 3073, 0),
        ObjectID.STEPPING_STONE_10663
    ),
    SHILO_VILLAGE_STEPPING_STONES(
        77, "Stepping Stones", WorldPoint(2863, 2974, 0),
        ObjectID.STEPPING_STONE_16466
    ),
    IORWERTHS_DUNGEON_NORTHERN_SHORTCUT_EAST(
        78, "Tight Gap", WorldPoint(3221, 12441, 0),
        ObjectID.TIGHT_GAP
    ),
    IORWERTHS_DUNGEON_NORTHERN_SHORTCUT_WEST(
        78, "Tight Gap", WorldPoint(3215, 12441, 0),
        ObjectID.TIGHT_GAP_36693
    ),
    KHARAZI_JUNGLE_VINE_CLIMB(
        79,
        "Vine",
        WorldPoint(2897, 2939, 0),
        NullObjectID.NULL_26884,
        NullObjectID.NULL_26886
    ),
    TAVERLEY_DUNGEON_SPIKED_BLADES(
        80,
        "Strange Floor",
        WorldPoint(2877, 9813, 0),
        ObjectID.STRANGE_FLOOR
    ),
    SLAYER_DUNGEON_CHASM_JUMP(
        81, "Spiked Blades", WorldPoint(2770, 10003, 0),
        ObjectID.STRANGE_FLOOR_16544
    ),
    LAVA_MAZE_NORTH_JUMP(
        82,
        "Stepping Stone",
        WorldPoint(3092, 3880, 0),
        ObjectID.STEPPING_STONE_14917
    ),
    BRIMHAVEN_DUNGEON_EAST_STEPPING_STONES_NORTH(
        83, "Stepping Stones", WorldPoint(2685, 9547, 0),
        ObjectID.STEPPING_STONE_19040
    ),
    BRIMHAVEN_DUNGEON_EAST_STEPPING_STONES_SOUTH(
        83, "Stepping Stones", WorldPoint(2693, 9529, 0),
        ObjectID.STEPPING_STONE_19040
    ),
    IORWERTHS_DUNGEON_SOUTHERN_SHORTCUT_EAST(
        84, "Tight Gap", WorldPoint(3241, 12420, 0),
        ObjectID.TIGHT_GAP_36694
    ),
    IORWERTHS_DUNGEON_SOUTHERN_SHORTCUT_WEST(
        84, "Tight Gap", WorldPoint(3231, 12420, 0),
        ObjectID.TIGHT_GAP_36695
    ),
    ELVEN_ADVANCED_CLIFF_SCRAMBLE(
        85, "Rocks", WorldPoint(2337, 3253, 0), ObjectID.ROCKS_16514,
        ObjectID.ROCKS_16515
    ),
    ELVEN_ADVANCED_CLIFF_SCRAMBLE_PRIFDDINAS(
        85, "Rocks", WorldPoint(3361, 6005, 0), ObjectID.ROCKS_16514,
        ObjectID.ROCKS_16515
    ),
    KALPHITE_WALL(86, "Crevice", WorldPoint(3214, 9508, 0), ObjectID.CREVICE_16465), BRIMHAVEN_DUNGEON_VINE_EAST(
        87,
        "Vine",
        WorldPoint(2672, 9582, 0),
        ObjectID.VINE_26880,
        ObjectID.VINE_26882
    ),
    BRIMHAVEN_DUNGEON_VINE_WEST(
        87,
        "Vine",
        WorldPoint(2606, 9584, 0),
        ObjectID.VINE_26880,
        ObjectID.VINE_26882
    ),
    MOUNT_KARUULM_PIPE_SOUTH(
        88,
        "Pipe",
        WorldPoint(1316, 10214, 0),
        ObjectID.MYSTERIOUS_PIPE
    ),
    MOUNT_KARUULM_PIPE_NORTH(
        88,
        "Pipe",
        WorldPoint(1345, 10230, 0),
        ObjectID.MYSTERIOUS_PIPE
    ),
    REVENANT_CAVES_CHAMBER_JUMP(89, "Jump", WorldPoint(3240, 10144, 0), ObjectID.PILLAR_31561);

    constructor(level: Int, description: String, location: WorldPoint?, vararg obstacleIds: Int) : this(
        level,
        description,
        location,
        location,
        *obstacleIds
    )

    val tooltip: String
        get() = "$description - Level $level"

    open fun matches(`object`: TileObject): Boolean {
        return true
    }
}