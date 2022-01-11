/*
 * Copyright (c) 2020, dekvall <https://github.com/dekvall>
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

import com.google.common.base.Joiner
import net.runelite.api.coords.WorldPoint


internal enum class MiningSiteLocation(
    val location: WorldPoint,
    val iconRequired: Boolean,
    vararg rocks: Rock
) {
    AGILITY_PYRAMID(WorldPoint(3322, 2875, 0), Rock(5, Ore.GOLD)),  // ABANDONED_MINE -- NOT AVAILABLE ON WORLDMAP
    AL_KHARID_MINE_NORTH(
        WorldPoint(3298, 3312, 0),
        Rock(3, Ore.COPPER), Rock(1, Ore.TIN), Rock(7, Ore.IRON), Rock(5, Ore.SILVER),
        Rock(3, Ore.COAL), Rock(3, Ore.MITHRIL), Rock(2, Ore.ADAMANTITE)
    ),
    AL_KHARID_MINE_SOUTH(WorldPoint(3298, 3282, 0), Rock(2, Ore.IRON), Rock(2, Ore.GOLD)), ANCIENT_CAVERN_NORTH(
        WorldPoint(1847, 5414, 0),
        Rock(4, Ore.MITHRIL)
    ),
    ANCIENT_CAVERN_SOUTH(WorldPoint(1826, 5392, 0), Rock(2, Ore.MITHRIL)), ANCIENT_CAVERN_MIDDLE(
        WorldPoint(
            1840,
            5397,
            0
        ), Rock(8, Ore.MITHRIL)
    ),
    ARANDAR(WorldPoint(2322, 3269, 0), Rock(8, Ore.LIMESTONE)), ARANDAR_PRIFDDINAS_MAP(
        WorldPoint(3346, 6021, 0),
        Rock(8, Ore.LIMESTONE)
    ),
    ARCEUUS_NORTH(WorldPoint(1763, 3860, 0), Rock(1, Ore.DENSE_ESSENCE)), ARCEUUS_SOUTH(
        WorldPoint(1763, 3844, 0),
        Rock(1, Ore.DENSE_ESSENCE)
    ),
    ARDOUGNE_SEWERS(WorldPoint(2670, 9680, 0), Rock(5, Ore.IRON), Rock(5, Ore.COAL)), ARDOUGNE_SOUTH_EAST(
        WorldPoint(
            2599,
            3232,
            0
        ), Rock(6, Ore.IRON), Rock(4, Ore.COAL)
    ),  // ARZINIAN_MINE -- NOT AVAILABLE ON WORLD MAP
    ASGARNIA_ICE_DUNGEON_EAST(WorldPoint(3063, 9582, 0), Rock(2, Ore.BLURITE)), ASGARNIA_ICE_DUNGEON_WEST(
        WorldPoint(
            3049,
            9568,
            0
        ), Rock(2, Ore.BLURITE)
    ),
    BANDIT_CAMP_MINE(
        WorldPoint(3086, 3763, 0), Rock(16, Ore.IRON), Rock(20, Ore.COAL),
        Rock(22, Ore.MITHRIL), Rock(8, Ore.ADAMANTITE)
    ),
    BANDIT_CAMP_QUARRY(
        WorldPoint(3171, 2912, 0), Rock(4, Ore.CLAY), Rock(2, Ore.COAL),
        Rock(32, Ore.SANDSTONE), Rock(28, Ore.GRANITE)
    ),
    BARBARIAN_VILLAGE(WorldPoint(3078, 3421, 0), Rock(5, Ore.TIN), Rock(4, Ore.COAL)), BATTLEFIELD(
        WorldPoint(
            2471,
            3255,
            0
        ), Rock(3, Ore.COPPER), Rock(1, Ore.TIN)
    ),
    BLAST_MINE_EAST(WorldPoint(1502, 3869, 0), Rock(20, Ore.HARD_ROCK)), BLAST_MINE_NORTH(
        WorldPoint(1485, 3882, 0),
        Rock(17, Ore.HARD_ROCK)
    ),
    BLAST_MINE_WEST(WorldPoint(1471, 3865, 0), Rock(22, Ore.HARD_ROCK)), BRIMHAVEN_NORTH(
        WorldPoint(2732, 3225, 0),
        Rock(10, Ore.GOLD)
    ),
    BRIMHAVEN_SOUTH_(WorldPoint(2743, 3150, 0), Rock(6, Ore.GOLD)), CENTRAL_FREMENIK_ISLES(
        WorldPoint(2374, 3850, 0), Rock(7, Ore.COAL),
        Rock(1, Ore.RUNITE)
    ),
    CITHAREDE_ABBEY(WorldPoint(3400, 3170, 0), Rock(3, Ore.IRON), Rock(3, Ore.COAL)), COAL_TRUCKS(
        WorldPoint(
            2580,
            3484,
            0
        ), Rock(18, Ore.COAL)
    ),
    CRAFTING_GUILD(
        WorldPoint(2939, 3283, 0), Rock(6, Ore.CLAY), Rock(6, Ore.SILVER),
        Rock(7, Ore.GOLD)
    ),
    CRANDOR_NORTH_EAST(WorldPoint(2860, 3287, 0), Rock(3, Ore.GOLD)), CRANDOR_NORTH_WEST(
        WorldPoint(2831, 3296, 0), Rock(7, Ore.COAL),
        Rock(1, Ore.MITHRIL)
    ),
    CRANDOR_SOUTH_EAST(
        WorldPoint(2835, 3245, 0), Rock(3, Ore.COAL),
        Rock(3, Ore.ADAMANTITE)
    ),
    CRANDOR_SOUTH_WEST(WorldPoint(2819, 3247, 0), Rock(7, Ore.MITHRIL)), DAEYALT_ESSENCE_MINE(
        WorldPoint(3631, 3340, 0),
        Rock(3, Ore.DAEYALT_ESSENCE)
    ),
    DESERT_MINING_CAMP_SURFACE(
        WorldPoint(3299, 3021, 0), true, Rock(4, Ore.COPPER),
        Rock(4, Ore.TIN), Rock(3, Ore.IRON), Rock(4, Ore.COAL)
    ),  // DESERT_MINING_CAMP_UNDERGROUND -- NOT AVAILABLE ON WORLDMAP
    DORGESH_KAAN_NORTH(WorldPoint(3309, 9645, 0), Rock(1, Ore.IRON), Rock(9, Ore.SILVER)), DORGESH_KAAN_SOUTH_EAST(
        WorldPoint(3322, 9616, 0),
        Rock(3, Ore.IRON)
    ),
    DORGESH_KAAN_SOUTH_WEST(WorldPoint(3312, 9621, 0), Rock(3, Ore.IRON)), DORGESH_KAAN_WEST(
        WorldPoint(3311, 9628, 0),
        Rock(3, Ore.IRON),
        Rock(2, Ore.SILVER)
    ),
    DWARVEN_EAST_BOTTOM(
        WorldPoint(3039, 9763, 0),
        Rock(5, Ore.TIN), Rock(2, Ore.IRON), Rock(8, Ore.COAL), Rock(2, Ore.GOLD),
        Rock(1, Ore.ADAMANTITE)
    ),
    DWARVEN_EAST_MIDDLE(
        WorldPoint(3037, 9775, 0),
        Rock(4, Ore.COPPER), Rock(3, Ore.IRON), Rock(3, Ore.COAL),
        Rock(2, Ore.MITHRIL), Rock(2, Ore.ADAMANTITE)
    ),
    DWARVEN_EAST_TOP(
        WorldPoint(3051, 9820, 0), Rock(2, Ore.CLAY), Rock(3, Ore.TIN),
        Rock(2, Ore.IRON)
    ),
    DWARVEN_WEST_BOTTOM(
        WorldPoint(3028, 9809, 0), Rock(3, Ore.CLAY),
        Rock(4, Ore.COPPER)
    ),
    DWARVEN_WEST_TOP(
        WorldPoint(3031, 9828, 0), Rock(3, Ore.COPPER), Rock(2, Ore.TIN),
        Rock(2, Ore.IRON)
    ),
    FREMENIK_ISLES_EAST(
        WorldPoint(2405, 3867, 0), Rock(3, Ore.COPPER), Rock(3, Ore.TIN),
        Rock(4, Ore.COAL)
    ),
    EAGLES_OUTPOST(WorldPoint(3424, 3164, 0), Rock(7, Ore.CLAY)), EDGEVILLE_DUNGEON(
        WorldPoint(3138, 9874, 0),
        Rock(2, Ore.COPPER), Rock(2, Ore.TIN), Rock(3, Ore.IRON), Rock(3, Ore.SILVER),
        Rock(6, Ore.COAL), Rock(1, Ore.MITHRIL), Rock(2, Ore.ADAMANTITE)
    ),  // EVIL_CHICKEN_LAIR  -- NOT AVAILABLE ON WORLD MAP
    FALADOR_WEST(
        WorldPoint(2907, 3362, 0),
        Rock(2, Ore.COPPER), Rock(6, Ore.TIN), Rock(3, Ore.IRON), Rock(2, Ore.COAL)
    ),
    FELDIP_HILLS_EAST(WorldPoint(2638, 2996, 0), Rock(3, Ore.ROCK)), FELDIP_HILLS_MIDDLE(
        WorldPoint(2579, 2998, 0),
        Rock(4, Ore.ROCK)
    ),
    FELDIP_HILLS_WEST(WorldPoint(2567, 2961, 0), Rock(3, Ore.ROCK)), FIGHT_ARENA(
        WorldPoint(2630, 3142, 0),
        Rock(4, Ore.CLAY), Rock(2, Ore.COPPER), Rock(7, Ore.TIN), Rock(9, Ore.IRON),
        Rock(1, Ore.COAL), Rock(2, Ore.MITHRIL)
    ),
    FOSSIL_ISLAND(
        WorldPoint(3770, 3815, 0),
        Rock(7, Ore.IRON), Rock(20, Ore.COAL), Rock(3, Ore.MITHRIL),
        Rock(5, Ore.ADAMANTITE),
        Rock(2, Ore.RUNITE)
    ),
    FREMENNIK_ISLES_WEST(WorldPoint(2310, 3853, 0), Rock(3, Ore.COPPER)), FROZEN_WASTE_PLATEU_CENTER(
        WorldPoint(
            2963,
            3933,
            0
        ), Rock(1, Ore.RUNITE)
    ),
    FROZEN_WASTE_PLATEU_NORTH(
        WorldPoint(2975, 3937, 0),
        Rock(1, Ore.RUNITE)
    ),
    FROZEN_WASTE_PLATEU_SOUTH(WorldPoint(2947, 3914, 0), Rock(1, Ore.RUNITE)), GRAND_TREE(
        WorldPoint(2489, 9916, 0),
        Rock(9, Ore.CLAY), Rock(8, Ore.IRON), Rock(4, Ore.SILVER), Rock(11, Ore.COAL),
        Rock(4, Ore.GOLD), Rock(4, Ore.MITHRIL), Rock(3, Ore.ADAMANTITE)
    ),
    GWENITH(WorldPoint(2163, 3415, 0), Rock(10, Ore.GOLD)), GWENITH_PRIFDDINAS_MAP(
        WorldPoint(3187, 6167, 0),
        Rock(10, Ore.GOLD)
    ),
    HEROES_GUILD_EAST_BOTTOM(
        WorldPoint(2939, 9898, 0), Rock(3, Ore.COAL),
        Rock(2, Ore.RUNITE)
    ),
    HEROES_GUILD_EAST_TOP(WorldPoint(2940, 9884, 0), Rock(5, Ore.COAL)), HEROES_GUILD_WEST_BOTTOM(
        WorldPoint(
            2921,
            9904,
            0
        ), Rock(3, Ore.COAL)
    ),
    HEROES_GUILD_WEST_TOP(
        WorldPoint(2914, 9916, 0), Rock(2, Ore.MITHRIL),
        Rock(2, Ore.ADAMANTITE)
    ),
    HOSIDIUS_MINE(
        WorldPoint(1777, 3489, 0),
        Rock(10, Ore.CLAY), Rock(11, Ore.COPPER), Rock(4, Ore.TIN), Rock(9, Ore.IRON),
        Rock(2, Ore.SILVER)
    ),
    ISAFDAR(WorldPoint(2277, 3159, 0), Rock(4, Ore.ADAMANTITE), Rock(2, Ore.RUNITE)), ISLE_OF_SOULS_DUNGEON_EAST(
        WorldPoint(1831, 9109, 0),
        Rock(1, Ore.RUNITE)
    ),
    ISLE_OF_SOULS_DUNGEON_WEST(WorldPoint(1814, 9116, 0), Rock(2, Ore.ADAMANTITE)), ISLE_OF_SOULS_SOUTH(
        WorldPoint(2195, 2793, 0),
        Rock(3, Ore.CLAY), Rock(3, Ore.TIN), Rock(3, Ore.COPPER), Rock(10, Ore.IRON),
        Rock(3, Ore.SILVER), Rock(6, Ore.COAL), Rock(4, Ore.GOLD),
        Rock(2, Ore.MITHRIL)
    ),
    JATIZSO(
        WorldPoint(2396, 3812, 0),
        Rock(11, Ore.TIN), Rock(7, Ore.IRON), Rock(8, Ore.COAL),
        Rock(15, Ore.MITHRIL),
        Rock(11, Ore.ADAMANTITE)
    ),
    KARAMJA_JUNGLE(
        WorldPoint(2848, 3033, 0),
        Rock(1, Ore.IRON), Rock(1, Ore.SILVER), Rock(1, Ore.COAL),
        Rock(2, Ore.MITHRIL),
        Rock(2, Ore.ADAMANTITE)
    ),
    KARAMJA_VOLCANO(WorldPoint(2856, 9579, 0), Rock(4, Ore.GOLD)), KEBOS_LOWLANDS(
        WorldPoint(1211, 3657, 0), Rock(4, Ore.ADAMANTITE),
        Rock(5, Ore.MITHRIL)
    ),
    KELDAGRIM_ENTRANCE(
        WorldPoint(2724, 3693, 0), Rock(9, Ore.IRON),
        Rock(2, Ore.MITHRIL)
    ),
    KELDAGRIM_NORTH_EAST(WorldPoint(2937, 10232, 0), Rock(9, Ore.COAL)), KELDAGRIM_SOUTH_WEST_BOTTOM(
        WorldPoint(2872, 10119, 0), Rock(2, Ore.COPPER),
        Rock(5, Ore.COAL)
    ),
    KELDAGRIM_SOUTH_WEST_MIDDLE(
        WorldPoint(2818, 10156, 0), Rock(4, Ore.IRON),
        Rock(1, Ore.GOLD)
    ),
    KELDAGRIM_SOUTH_WEST_TOP(WorldPoint(2864, 10170, 0), Rock(5, Ore.TIN)), LAVA_MAZE_DUNGEON(
        WorldPoint(
            3045,
            10263,
            0
        ), true, Rock(1, Ore.RUNITE)
    ),
    LAVA_MAZE_NORTH(WorldPoint(3059, 3884, 0), Rock(2, Ore.RUNITE)), LEGENDS_GUILD_EAST(
        WorldPoint(2709, 3331, 0),
        Rock(6, Ore.IRON),
        Rock(8, Ore.COAL)
    ),
    LEGENDS_GUILD_WEST(WorldPoint(2694, 3332, 0), Rock(5, Ore.IRON), Rock(5, Ore.COAL)), LOVAKENGJ_SOUTH(
        WorldPoint(1476, 3779, 0), Rock(4, Ore.IRON), Rock(6, Ore.COAL),
        Rock(1, Ore.MITHRIL)
    ),
    LOVAKENGJ_SULPHUR_EAST(WorldPoint(1445, 3870, 0), Rock(3, Ore.VOLCANIC_SULPHUR)), LOVAKENGJ_SULPHUR_WEST(
        WorldPoint(
            1427,
            3870,
            0
        ), Rock(2, Ore.VOLCANIC_SULPHUR)
    ),
    LOVAKENGJ_WEST(
        WorldPoint(1432, 3845, 0), true, Rock(45, Ore.COAL),
        Rock(80, Ore.LOVAKITE)
    ),
    LUMBRIDGE_SWAMP_EAST(
        WorldPoint(3226, 3146, 0), Rock(5, Ore.COPPER),
        Rock(5, Ore.TIN)
    ),
    LUMBRIDGE_SWAMP_WEST(
        WorldPoint(3148, 3149, 0),
        Rock(7, Ore.COAL), Rock(5, Ore.MITHRIL), Rock(2, Ore.ADAMANTITE)
    ),  // Lunar Isle Dungeon: Starting north-east and going clockwise
    LUNAR_ISLE_1(
        WorldPoint(2163, 10347, 0),
        Rock(2, Ore.SILVER), Rock(1, Ore.GOLD), Rock(1, Ore.GEM_ROCK),
        Rock(6, Ore.LUNAR)
    ),
    LUNAR_ISLE_2(WorldPoint(2165, 10325, 0), Rock(3, Ore.GEM_ROCK), Rock(4, Ore.LUNAR)), LUNAR_ISLE_3(
        WorldPoint(
            2140,
            10318,
            0
        ), Rock(3, Ore.SILVER), Rock(3, Ore.LUNAR)
    ),
    LUNAR_ISLE_4(WorldPoint(2125, 10327, 0), Rock(4, Ore.GOLD), Rock(1, Ore.LUNAR)), LUNAR_ISLE_5(
        WorldPoint(
            2124,
            10342,
            0
        ), Rock(2, Ore.GOLD), Rock(5, Ore.LUNAR)
    ),
    MINING_GUILD_AMETHYST(WorldPoint(3022, 9704, 0), Rock(26, Ore.AMETHYST)), MINING_GUILD_NORTH(
        WorldPoint(3040, 9740, 0),
        Rock(4, Ore.IRON), Rock(37, Ore.COAL), Rock(5, Ore.MITHRIL),
        Rock(2, Ore.ADAMANTITE)
    ),
    MINING_GUILD_SOUTH(
        WorldPoint(3032, 9720, 0),
        Rock(8, Ore.IRON), Rock(20, Ore.COAL), Rock(10, Ore.MITHRIL),
        Rock(8, Ore.ADAMANTITE),
        Rock(2, Ore.RUNITE)
    ),
    MISCELLANIA(WorldPoint(2526, 3891, 0), Rock(9, Ore.COAL)), MISCELLANIA_DUNGEON(
        WorldPoint(2504, 10287, 0),
        Rock(4, Ore.COAL)
    ),
    MOR_UL_REK_NORTH(WorldPoint(2458, 5167, 0), Rock(3, Ore.SILVER), Rock(3, Ore.GOLD)), MOR_UL_REK_SOUTH_EAST(
        WorldPoint(2513, 5074, 0), Rock(6, Ore.SILVER),
        Rock(7, Ore.GOLD)
    ),
    MOR_UL_REK_SOUTH_WEST(
        WorldPoint(2499, 5062, 0),
        Rock(3, Ore.IRON), Rock(4, Ore.COAL), Rock(2, Ore.ADAMANTITE),
        Rock(3, Ore.RUNITE)
    ),
    MOUNT_KARUULM(
        WorldPoint(1278, 3814, 0),
        Rock(6, Ore.IRON),
        Rock(5, Ore.COAL)
    ),  // MOURNER_TUNNELS -- NOT AVAILABLE ON WORLD MAP
    MYTHS_GUILD(WorldPoint(1936, 9020, 0), Rock(4, Ore.ADAMANTITE), Rock(2, Ore.RUNITE)), OGRESS_SETTLEMENT(
        WorldPoint(1977, 9041, 0),
        Rock(5, Ore.COAL), Rock(2, Ore.MITHRIL), Rock(1, Ore.ADAMANTITE)
    ),
    PIRATES_HIDEOUT(
        WorldPoint(3056, 3945, 0),
        Rock(1, Ore.IRON), Rock(4, Ore.COAL), Rock(4, Ore.MITHRIL),
        Rock(1, Ore.ADAMANTITE)
    ),
    PISCARILLIUS(
        WorldPoint(1759, 3718, 0),
        Rock(5, Ore.COPPER), Rock(6, Ore.TIN), Rock(5, Ore.IRON), Rock(2, Ore.SILVER),
        Rock(1, Ore.MITHRIL)
    ),
    PISCATORIS(
        WorldPoint(2337, 3640, 0),
        Rock(2, Ore.CLAY), Rock(2, Ore.COPPER), Rock(2, Ore.TIN), Rock(3, Ore.IRON)
    ),
    PORT_KHAZARD(
        WorldPoint(2651, 3172, 0),
        Rock(2, Ore.COPPER), Rock(2, Ore.TIN), Rock(2, Ore.MITHRIL)
    ),
    RELLEKKA(
        WorldPoint(2682, 3704, 0), Rock(4, Ore.CLAY), Rock(3, Ore.SILVER),
        Rock(7, Ore.COAL)
    ),
    RIMMINGTON(
        WorldPoint(2977, 3240, 0),
        Rock(2, Ore.CLAY), Rock(5, Ore.COPPER), Rock(2, Ore.TIN), Rock(6, Ore.IRON),
        Rock(2, Ore.GOLD)
    ),
    RUINS_OF_UNKAH(
        WorldPoint(3172, 2871, 0),
        Rock(1, Ore.COPPER), Rock(1, Ore.TIN), Rock(5, Ore.IRON), Rock(2, Ore.SILVER),
        Rock(1, Ore.COAL)
    ),
    SALT_MINE(
        WorldPoint(2835, 10334, 0),
        Rock(7, Ore.BASALT), Rock(15, Ore.TE_SALT), Rock(12, Ore.EFH_SALT),
        Rock(12, Ore.URT_SALT)
    ),
    SHAYZIEN(
        WorldPoint(1601, 3645, 0),
        Rock(3, Ore.CLAY), Rock(3, Ore.IRON), Rock(4, Ore.COAL), Rock(2, Ore.MITHRIL),
        Rock(2, Ore.ADAMANTITE)
    ),
    SHILO_VILLAGE_SURFACE(WorldPoint(2822, 3001, 0), Rock(7, Ore.GEM_ROCK)), SILVAREA(
        WorldPoint(3371, 3498, 0),
        Rock(7, Ore.LIMESTONE)
    ),
    SLEPE_UNDERGROUND(WorldPoint(3888, 9749, 0), Rock(6, Ore.IRON), Rock(14, Ore.COAL)), TRAHEARN(
        WorldPoint(3295, 12387, 0),
        Rock(26, Ore.IRON), Rock(8, Ore.SILVER), Rock(19, Ore.COAL),
        Rock(14, Ore.GOLD),
        Rock(7, Ore.MITHRIL), Rock(10, Ore.SOFT_CLAY), Rock(7, Ore.ADAMANTITE),
        Rock(4, Ore.RUNITE)
    ),  // TUTORIAL ISLAND -- NOT AVAILABLE ON WORLD MAP
    UZER(WorldPoint(3415, 3160, 0), Rock(10, Ore.CLAY)), VARROCK_SOUTH_EAST(
        WorldPoint(3286, 3365, 0),
        Rock(9, Ore.COPPER), Rock(6, Ore.TIN), Rock(4, Ore.IRON)
    ),
    VARROCK_SOUTH_WEST(
        WorldPoint(3176, 3370, 0),
        Rock(3, Ore.CLAY), Rock(8, Ore.TIN), Rock(3, Ore.IRON), Rock(3, Ore.SILVER)
    ),
    VERDANT_VALLEY(WorldPoint(3766, 3757, 0), true, Rock(3, Ore.IRON)), WILDERNESS_RESOURCE_AREA(
        WorldPoint(3192, 3930, 0),
        Rock(6, Ore.IRON), Rock(11, Ore.COAL), Rock(4, Ore.GOLD),
        Rock(1, Ore.MITHRIL), Rock(6, Ore.ADAMANTITE)
    ),
    WILDERNESS_SOUTH(WorldPoint(3104, 3569, 0), Rock(2, Ore.IRON), Rock(3, Ore.COAL)), WILDERNESS_SOUTH_WEST(
        WorldPoint(
            3013,
            3589,
            0
        ), Rock(34, Ore.COAL)
    );

    val tooltip: String

    constructor(location: WorldPoint, vararg rocks: Rock) : this(location, false, *rocks) {}

    init {
        tooltip = createTooltip(rocks as Array<Rock>)
    }

    private fun createTooltip(rocks: Array<Rock>): String {
        return Joiner.on("<br>").join(rocks)
    }

    private enum class Ore(s: String) {
        ROCK("Rock"), CLAY("Clay"), COPPER("Copper"), TIN("Tin"), LIMESTONE("Limestone"), BLURITE("Blurite"), IRON("Iron"), ELEMENTAL(
            "Elemental"
        ),
        SILVER("Silver"), COAL("Coal"), SANDSTONE("Sandstone"), DENSE_ESSENCE("Dense essence"), DAEYALT_ESSENCE("Daeyalt essence"), GOLD(
            "Gold"
        ),
        GEM_ROCK("Gem rock"), HARD_ROCK("Hard rock"), VOLCANIC_SULPHUR("Volcanic sulphur"), GRANITE("Granite"), MITHRIL(
            "Mithril"
        ),
        LUNAR("Lunar"), LOVAKITE("Lovakite"), ADAMANTITE("Adamantite"), SOFT_CLAY("Soft clay"), BASALT("Basalt"), TE_SALT(
            "Te salt"
        ),
        EFH_SALT("Efh salt"), URT_SALT("Urt salt"), RUNITE("Runite"), AMETHYST("Amethyst");

        override fun toString(): String {
            return name!!
        }
    }

    private class Rock(i: Int, silver: Ore) {
        private val count = 0
        private val ore: Ore? = null
        override fun toString(): String {
            return "$count $ore"
        }
    }
}