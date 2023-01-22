/*
 * Copyright (c) 2019, Kyle Sergio <https://github.com/ksergio39>
 * Copyright (c) 2019, Bryce Altomare <https://github.com/Twinkiel0ver>
 * Copyright (c) 2019, Kyle Stead <http://github.com/kyle1elyk>
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

internal enum class TransportationPointLocation(tooltip: String, worldPoint: WorldPoint, worldPoint1: WorldPoint) {
    //Ships
    ARDOUGNE_TO_BRIMHAVEN(
        "Ship to Brimhaven / Rimmington",
        WorldPoint(2675, 3275, 0),
        WorldPoint(2909, 3227, 0)
    ),
    ARDOUGNE_TO_FISHINGPLAT(
        "Ship to Fishing Platform", WorldPoint(2722, 3304, 0),
        WorldPoint(2779, 3271, 0)
    ),
    BRIMHAVEN_TO_ARDOUGNE(
        "Ship to Ardougne / Rimmington",
        WorldPoint(2772, 3234, 0),
        WorldPoint(2909, 3227, 0)
    ),
    RIMMINGTON_TO_ARDOUGNE(
        "Ship to Ardougne / Brimhaven",
        WorldPoint(2915, 3224, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CATHERBY_TO_KEEP_LE_FAYE(
        "Ship to Keep Le Faye", WorldPoint(2804, 3421, 0),
        WorldPoint(2769, 3402, 0)
    ),
    CORSAIR_TO_RIMMINGTON(
        "Ship to Rimmington", WorldPoint(2577, 2839, 0),
        WorldPoint(2909, 3227, 0)
    ),
    DRAGONTOOTH_TO_PHASMATYS(
        "Ship to Port Phasmatys", WorldPoint(3791, 3561, 0),
        WorldPoint(3703, 3487, 0)
    ),
    DIGSITE_TO_FOSSIL(
        "Ship to Fossil Island", WorldPoint(3361, 3448, 0),
        WorldPoint(3723, 3807, 0)
    ),
    ENTRANA_TO_PORTSARIM(
        "Ship to Port Sarim", WorldPoint(2833, 3334, 0),
        WorldPoint(3046, 3233, 0)
    ),
    FISHINGPLAT_TO_ARDOUGNE(
        "Ship to Ardougne", WorldPoint(2779, 3271, 0),
        WorldPoint(2722, 3304, 0)
    ),
    HARMLESS_TO_PORT_PHASMATYS(
        "Ship to Port Phasmatys", WorldPoint(3682, 2951, 0),
        WorldPoint(3709, 3497, 0)
    ),
    ICEBERG_TO_RELLEKKA(
        "Ship to Rellekka", WorldPoint(2657, 3988, 0),
        WorldPoint(2707, 3735, 0)
    ),
    ISLAND_OF_STONE_TO_RELLEKKA(
        "Ship to Rellekka", WorldPoint(2470, 3994, 0),
        WorldPoint(2621, 3692, 0)
    ),
    ISLAND_TO_APE_ATOLL(
        "Ship to Ape Atoll", WorldPoint(2891, 2726, 0),
        WorldPoint(2802, 2706, 0)
    ),
    JATIZSO_TO_RELLEKKA(
        "Ship to Rellekka", WorldPoint(2420, 3780, 0),
        WorldPoint(2639, 3710, 0)
    ),
    KARAMJA_TO_PORT_SARIM(
        "Ship to Port Sarim", WorldPoint(2955, 3145, 0),
        WorldPoint(3029, 3218, 0)
    ),
    KARAMJA_TO_PORT_KHAZARD(
        "Ship to Port Khazard", WorldPoint(2763, 2957, 0),
        WorldPoint(2653, 3166, 0)
    ),
    LANDSEND_TO_PORTSARIM_PORTPISCARILIUS(
        "Ship to Port Sarim/Port Piscarilius",
        WorldPoint(1503, 3398, 0),
        WorldPoint(2909, 3227, 0)
    ),
    LUNAR_ISLE_TO_PIRATES_COVE(
        "Ship to Pirates' Cove", WorldPoint(2137, 3899, 0),
        WorldPoint(2223, 3796, 0)
    ),
    MISCELLANIA_TO_RELLEKKA(
        "Ship to Rellekka", WorldPoint(2579, 3846, 0),
        WorldPoint(2627, 3692, 0)
    ),
    NEITIZNOT_TO_RELLEKKA(
        "Ship to Rellekka", WorldPoint(2310, 3779, 0),
        WorldPoint(2639, 3710, 0)
    ),
    PESTCONTROL_TO_PORTSARIM(
        "Ship to Port Sarim", WorldPoint(2659, 2675, 0),
        WorldPoint(3039, 3201, 0)
    ),
    PIRATES_COVE_TO_LUNAR_ISLE(
        "Ship to Lunar Isle", WorldPoint(2223, 3796, 0),
        WorldPoint(2137, 3899, 0)
    ),
    PIRATES_COVE_TO_RELLEKKA(
        "Ship to Rellekka", WorldPoint(2212, 3794, 0),
        WorldPoint(2620, 3695, 0)
    ),
    PORT_PHASMATYS_TO_DRAGONTOOTH(
        "Ship to Dragontooth Island", WorldPoint(3703, 3487, 0),
        WorldPoint(3791, 3561, 0)
    ),
    PORT_PHASMATYS_TO_HARMLESS(
        "Ship to Mos Le'Harmless", WorldPoint(3709, 3497, 0),
        WorldPoint(3682, 2951, 0)
    ),
    PORT_PISCARILIUS_TO_PORTSARIM_LANDSEND(
        "Ship to Port Sarim/Land's End",
        WorldPoint(1823, 3692, 0),
        WorldPoint(2909, 3227, 0)
    ),
    PORTSARIM_TO_GREAT_KOUREND(
        "Ship to Great Kourend", WorldPoint(3054, 3244, 0),
        WorldPoint(1823, 3692, 0)
    ),
    PORTSARIM_TO_ENTRANA(
        "Ship to Entrana", WorldPoint(3046, 3233, 0),
        WorldPoint(2833, 3334, 0)
    ),
    PORTSARIM_TO_KARAMJA(
        "Ship to Karamja", WorldPoint(3029, 3218, 0),
        WorldPoint(2955, 3144, 0)
    ),
    PORTSARIM_TO_CRANDOR(
        "Ship to Crandor", WorldPoint(3045, 3205, 0),
        WorldPoint(2839, 3261, 0)
    ),
    PORTSARIM_TO_PEST_CONTROL(
        "Ship to Pest Control", WorldPoint(3039, 3201, 0),
        WorldPoint(2659, 2675, 0)
    ),
    RELLEKKA_TO_JATIZSO_NEITIZNOT(
        "Ship to Jatizso/Neitiznot",
        WorldPoint(2639, 3710, 0),
        WorldPoint(2909, 3227, 0)
    ),
    RELLEKKA_TO_MISCELLANIA(
        "Ship to Miscellania", WorldPoint(2627, 3692, 0),
        WorldPoint(2579, 3846, 0)
    ),
    RELLEKKA_TO_PIRATES_COVE(
        "Ship to Pirates' Cove", WorldPoint(2620, 3695, 0),
        WorldPoint(2212, 3794, 0)
    ),
    RELLEKKA_TO_WATERBIRTH(
        "Ship to Waterbirth", WorldPoint(2618, 3685, 0),
        WorldPoint(2549, 3758, 0)
    ),
    RELLEKKA_TO_WEISS_ICEBERG(
        "Ship to Weiss/Iceberg",
        WorldPoint(2707, 3735, 0),
        WorldPoint(2909, 3227, 0)
    ),
    RELLEKKA_TO_UNGAEL(
        "Ship to Ungael", WorldPoint(2638, 3698, 0),
        WorldPoint(2276, 4034, 0)
    ),
    RIMMINGTON_TO_CORSAIR_COVE(
        "Ship to Corsair Cove", WorldPoint(2909, 3227, 0),
        WorldPoint(2577, 2839, 0)
    ),
    WATERBIRTH_TO_RELLEKKA(
        "Ship to Rellekka", WorldPoint(2549, 3758, 0),
        WorldPoint(2618, 3685, 0)
    ),
    WEISS_TO_RELLEKKA(
        "Ship to Rellekka", WorldPoint(2847, 3967, 0),
        WorldPoint(2707, 3735, 0)
    ),
    UNGAEL_TO_RELLEKKA(
        "Ship to Rellekka", WorldPoint(2276, 4034, 0),
        WorldPoint(2638, 3698, 0)
    ),  //Row Boats
    ROW_BOAT_BATTLEFRONT(
        "Rowboat to Molch/Molch Island/Shayzien",
        WorldPoint(1383, 3663, 0),
        WorldPoint(2909, 3227, 0)
    ),
    ROW_BOAT_BRAIN_DEATH(
        "Rowboat to Port Phasmatys", WorldPoint(2161, 5117, 0),
        WorldPoint(3680, 3538, 0)
    ),
    ROW_BOAT_BURGH_DE_ROTT(
        "Rowboat to Meiyerditch", WorldPoint(3522, 3168, 0),
        WorldPoint(3589, 3172, 0)
    ),
    ROW_BOAT_CRABCLAW(
        "Rowboat to Hosidius", WorldPoint(1780, 3417, 0),
        WorldPoint(1779, 3457, 0)
    ),
    ROW_BOAT_DIVING_ISLAND(
        "Rowboat to Barge/Camp/North of Island",
        WorldPoint(3764, 3901, 0),
        WorldPoint(2909, 3227, 0)
    ),
    ROW_BOAT_FISHING_GUILD(
        "Rowboat to Hemenster", WorldPoint(2598, 3426, 0),
        WorldPoint(2613, 3439, 0)
    ),
    ROW_BOAT_GNOME_STRONGHOLD(
        "Rowboat to Fishing Colony", WorldPoint(2368, 3487, 0),
        WorldPoint(2356, 3641, 0)
    ),
    ROW_BOAT_FISHING_COLONY(
        "Rowboat to Gnome Stronghold", WorldPoint(2356, 3641, 0),
        WorldPoint(2368, 3487, 0)
    ),
    ROW_BOAT_HEMENSTER(
        "Rowboat to Fishing Guild", WorldPoint(2613, 3439, 0),
        WorldPoint(2598, 3426, 0)
    ),
    ROW_BOAT_HOSIDIUS(
        "Rowboat to Crabclaw Isle", WorldPoint(1779, 3457, 0),
        WorldPoint(1780, 3417, 0)
    ),
    ROW_BOAT_LITHKREN(
        "Rowboat to Mushroom Forest", WorldPoint(3582, 3973, 0),
        WorldPoint(3659, 3849, 0)
    ),
    ROW_BOAT_LUMBRIDGE(
        "Rowboat to Misthalin Mystery",
        WorldPoint(3238, 3141, 0),
        WorldPoint(2909, 3227, 0)
    ),
    ROW_BOAT_MOLCH(
        "Rowboat to Molch Island/Shayzien/Battlefront",
        WorldPoint(1343, 3646, 0),
        WorldPoint(2909, 3227, 0)
    ),
    ROW_BOAT_MOLCH_ISLAND(
        "Rowboat to Molch/Shayzien/Battlefront",
        WorldPoint(1368, 3641, 0),
        WorldPoint(2909, 3227, 0)
    ),
    ROW_BOAT_MORT(
        "Rowboat to Mort Myre", WorldPoint(3518, 3284, 0),
        WorldPoint(3498, 3380, 0)
    ),
    ROW_BOAT_MORT_SWAMP(
        "Rowboat to Mort'ton", WorldPoint(3498, 3380, 0),
        WorldPoint(3518, 3284, 0)
    ),
    ROW_BOAT_MUSEUM_CAMP(
        "Rowboat to Barge/Digsite/North of Island",
        WorldPoint(3723, 3807, 0),
        WorldPoint(2909, 3227, 0)
    ),
    ROW_BOAT_MUSHROOM_FOREST_WEST(
        "Rowboat to Lithkren", WorldPoint(3659, 3849, 0),
        WorldPoint(3582, 3973, 0)
    ),
    ROW_BOAT_MUSHROOM_FOREST_NE(
        "Rowboat to Barge/Camp/Sea",
        WorldPoint(3733, 3894, 0),
        WorldPoint(2909, 3227, 0)
    ),
    ROW_BOAT_PORT_PHASMATYS_NORTH(
        "Rowboat to Slepe", WorldPoint(3670, 3545, 0),
        WorldPoint(3661, 3279, 0)
    ),
    ROW_BOAT_PORT_PHASMATYS_EAST(
        "Rowboat to Braindeath Island", WorldPoint(3680, 3538, 0),
        WorldPoint(2161, 5117, 0)
    ),
    ROW_BOAT_SHAYZIEN(
        "Rowboat to Molch/Molch Island/Battlefront",
        WorldPoint(1405, 3612, 0),
        WorldPoint(2909, 3227, 0)
    ),
    ROW_BOAT_SLEPE(
        "Rowboat to Port Phasmatys", WorldPoint(3661, 3279, 0),
        WorldPoint(3670, 3545, 0)
    ),
    OGRE_BOAT_FELDIP(
        "Ogre Boat to Karamja", WorldPoint(2653, 2964, 0),
        WorldPoint(2757, 3085, 0)
    ),
    OGRE_BOAT_KARAMJA(
        "Ogre Boat to Feldip", WorldPoint(2757, 3085, 0),
        WorldPoint(2653, 2964, 0)
    ),  //Charter ships
    CHARTER_BRIMHAVEN("Charter Ship", WorldPoint(2760, 3238, 0), WorldPoint(2909, 3227, 0)), CHARTER_CATHERBY(
        "Charter Ship",
        WorldPoint(2791, 3415, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CHARTER_CORSAIR_("Charter Ship", WorldPoint(2589, 2851, 0), WorldPoint(2909, 3227, 0)), CHARTER_KARAMJA_NORTH(
        "Charter Ship",
        WorldPoint(2954, 3158, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CHARTER_KARAMJA_EAST("Charter Ship", WorldPoint(2999, 3032, 0), WorldPoint(2909, 3227, 0)), CHARTER_KHAZARD(
        "Charter Ship",
        WorldPoint(2673, 3143, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CHARTER_MOSLE_HARMLESS(
        "Charter Ship",
        WorldPoint(3669, 2931, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CHARTER_PORT_PHASMATYS(
        "Charter Ship",
        WorldPoint(3702, 3503, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CHARTER_PORTSARIM("Charter Ship", WorldPoint(3037, 3191, 0), WorldPoint(2909, 3227, 0)), CHARTER_TYRAS(
        "Charter Ship",
        WorldPoint(2141, 3123, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CHARTER_PRIFDDINAS(
        "Charter Ship",
        WorldPoint(2156, 3331, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CHARTER_PRIFDDINAS_INSTANCE(
        "Charter Ship",
        WorldPoint(3180, 6083, 0),
        WorldPoint(2909, 3227, 0)
    ),  //Ferries
    FERRY_AL_KHARID(
        "Ferry to Ruins of Unkah", WorldPoint(3269, 3142, 0),
        WorldPoint(3145, 2843, 0)
    ),
    FERRY_RUINS_OF_UNKAH(
        "Ferry to Al Kharid", WorldPoint(3145, 2843, 0),
        WorldPoint(3269, 3142, 0)
    ),  //Minecarts/Carts
    MINE_CART_ARCEUUS(
        "Lovakengj Minecart Network",
        WorldPoint(1673, 3832, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MINE_CART_GRANDEXCHANGE(
        "Minecart to Keldagrim",
        WorldPoint(3139, 3504, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MINE_CART_HOSIDIUS(
        "Lovakengj Minecart Network",
        WorldPoint(1656, 3542, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MINE_CART_ICE_MOUNTAIN(
        "Minecart to Keldagrim",
        WorldPoint(2995, 9836, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MINE_CART_KELDAGRIM(
        "Keldagrim Minecart System",
        WorldPoint(2908, 10170, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MINE_CART_LOVAKENGJ(
        "Lovakengj Minecart Network",
        WorldPoint(1524, 3721, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MINE_CART_PORT_PISCARILIUS(
        "Lovakengj Minecart Network",
        WorldPoint(1760, 3708, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MINE_CART_QUIDAMORTEM(
        "Lovakengj Minecart Network",
        WorldPoint(1253, 3550, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MINE_CART_SHAYZIEN(
        "Lovakengj Minecart Network",
        WorldPoint(1586, 3622, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MINE_CART_WHITE_WOLF_MOUNTAIN(
        "Minecart to Keldagrim",
        WorldPoint(2874, 9870, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CART_TO_BRIMHAVEN(
        "Cart to Brimhaven", WorldPoint(2833, 2958, 0),
        WorldPoint(2780, 3214, 0)
    ),
    CART_TO_SHILO(
        "Cart to Shilo Village", WorldPoint(2780, 3214, 0),
        WorldPoint(2833, 2958, 0)
    ),  //Canoes
    CANOE_BARBVILLAGE("Canoe", WorldPoint(3111, 3409, 0), WorldPoint(2909, 3227, 0)), CANOE_CHAMPIONSGUILD(
        "Canoe",
        WorldPoint(3202, 3344, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CANOE_EDGEVILLE("Canoe", WorldPoint(3130, 3509, 0), WorldPoint(2909, 3227, 0)), CANOE_LUMBRIDGE(
        "Canoe",
        WorldPoint(3241, 3238, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CANOE_FEROXENCLAVE("Canoe", WorldPoint(3155, 3630, 0), WorldPoint(2909, 3227, 0)),  //Gnome Gliders
    GNOME_GLIDER_KHARID("Gnome Glider", WorldPoint(3278, 3213, 0), WorldPoint(2909, 3227, 0)), GNOME_GLIDER_APE_ATOLL(
        "Gnome Glider",
        WorldPoint(2712, 2804, 0),
        WorldPoint(2909, 3227, 0)
    ),
    GNOME_GLIDER_KARAMJA("Gnome Glider", WorldPoint(2971, 2974, 0), WorldPoint(2909, 3227, 0)), GNOME_GLIDER_FELDIP(
        "Gnome Glider",
        WorldPoint(2540, 2969, 0),
        WorldPoint(2909, 3227, 0)
    ),
    GNOME_GLIDER_GNOMESTRONGHOLD(
        "Gnome Glider",
        WorldPoint(2460, 3502, 0),
        WorldPoint(2909, 3227, 0)
    ),
    GNOME_GLIDER_WHITEWOLF(
        "Gnome Glider",
        WorldPoint(2845, 3501, 0),
        WorldPoint(2909, 3227, 0)
    ),  //Balloons
    BALLOON_VARROCK("Hot Air Balloon", WorldPoint(3298, 3480, 0), WorldPoint(2909, 3227, 0)), BALLOON_YANILLE(
        "Hot Air Balloon",
        WorldPoint(2458, 3108, 0),
        WorldPoint(2909, 3227, 0)
    ),
    BALLOON_GNOMESTRONGHOLD("Hot Air Balloon", WorldPoint(2478, 3459, 0), WorldPoint(2909, 3227, 0)), BALLOON_TAVERLEY(
        "Hot Air Balloon",
        WorldPoint(2936, 3422, 0),
        WorldPoint(2909, 3227, 0)
    ),
    BALLOON_FALADOR("Hot Air Balloon", WorldPoint(2921, 3301, 0), WorldPoint(2909, 3227, 0)),  //Spirit Tree
    SPIRITTREE_ARDOUGNE("Spirit Tree", WorldPoint(2554, 3259, 0), WorldPoint(2909, 3227, 0)), SPIRITTREE_CORSAIR(
        "Spirit Tree",
        WorldPoint(2485, 2850, 0),
        WorldPoint(2909, 3227, 0)
    ),
    SPIRITTREE_GNOMESTRONGHOLD(
        "Spirit Tree",
        WorldPoint(2459, 3446, 0),
        WorldPoint(2909, 3227, 0)
    ),
    SPIRITTREE_GNOMEVILLAGE(
        "Spirit Tree",
        WorldPoint(2538, 3166, 0),
        WorldPoint(2909, 3227, 0)
    ),
    SPIRITTREE_GRANDEXCHANGE(
        "Spirit Tree",
        WorldPoint(3184, 3510, 0),
        WorldPoint(2909, 3227, 0)
    ),
    SPIRITTREE_PRIFDDINAS(
        "Spirit Tree",
        WorldPoint(3274, 6124, 0),
        WorldPoint(2909, 3227, 0)
    ),  //Carpets
    CARPET_KHARID(
        "Carpet to Bedabin/Pollnivneach/Uzer",
        WorldPoint(3311, 3107, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CARPET_BEDABIN(
        "Carpet to Shantay Pass", WorldPoint(3183, 3042, 0),
        WorldPoint(3311, 3107, 0)
    ),
    CARPET_POLLNIVNEACH_NORTH(
        "Carpet to Shantay Pass", WorldPoint(3351, 3001, 0),
        WorldPoint(3311, 3107, 0)
    ),
    CARPET_POLLNIVNEACH_SOUTH(
        "Carpet to Nardah/Sophanem/Menaphos",
        WorldPoint(3345, 2943, 0),
        WorldPoint(2909, 3227, 0)
    ),
    CARPET_NARDAH(
        "Carpet to Pollnivneach", WorldPoint(3399, 2916, 0),
        WorldPoint(3345, 2943, 0)
    ),
    CARPET_SOPHANEM(
        "Carpet to Pollnivneach", WorldPoint(3288, 2814, 0),
        WorldPoint(3345, 2943, 0)
    ),
    CARPET_MENAPHOS(
        "Carpet to Pollnivneach", WorldPoint(3244, 2812, 0),
        WorldPoint(3345, 2943, 0)
    ),
    CARPET_UZER(
        "Carpet to Shantay Pass", WorldPoint(3468, 3111, 0),
        WorldPoint(3311, 3107, 0)
    ),  //Teleports
    TELEPORT_ARCHIVE_FROM_ARCEUUS(
        "Teleport to Library Archive",
        WorldPoint(1623, 3808, 0),
        WorldPoint(2909, 3227, 0)
    ),
    TELEPORT_HARMLESS_FROM_HARMONY(
        "Teleport to Mos Le'Harmless",
        WorldPoint(3784, 2828, 0),
        WorldPoint(2909, 3227, 0)
    ),
    TELEPORT_RUNE_ARDOUGNE(
        "Teleport to Rune Essence",
        WorldPoint(2681, 3325, 0),
        WorldPoint(2909, 3227, 0)
    ),
    TELEPORT_RUNE_YANILLE(
        "Teleport to Rune Essence",
        WorldPoint(2592, 3089, 0),
        WorldPoint(2909, 3227, 0)
    ),
    TELEPORT_SORCERESS_GARDEN(
        "Teleport to Sorceress's Garden",
        WorldPoint(3320, 3141, 0),
        WorldPoint(2909, 3227, 0)
    ),
    TELEPORT_PRIFDDINAS_LIBRARY(
        "Teleport to Prifddinas Library",
        WorldPoint(3254, 6082, 2),
        WorldPoint(2909, 3227, 0)
    ),  //Other
    ALTER_KOUREND_UNDERGROUND(
        "Altar to Skotizo",
        WorldPoint(1662, 10047, 0),
        WorldPoint(2909, 3227, 0)
    ),
    FAIRY_RING_ZANARIS_TO_KHARID(
        "Fairy Ring to Al Kharid",
        WorldPoint(2483, 4471, 0),
        WorldPoint(2909, 3227, 0)
    ),
    FAIRY_RING_ZANARIS_TO_SHACK(
        "Fairy Ring to Shack",
        WorldPoint(2451, 4471, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MOUNTAIN_GUIDE_QUIDAMORTEM(
        "Mountain Guide",
        WorldPoint(1275, 3559, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MOUNTAIN_GUIDE_WALL(
        "Mountain Guide",
        WorldPoint(1400, 3538, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MUSHTREE_MUSHROOM_FOREST("Mushtree", WorldPoint(3674, 3871, 0), WorldPoint(2909, 3227, 0)), MUSHTREE_TAR_SWAMP(
        "Mushtree",
        WorldPoint(3676, 3755, 0),
        WorldPoint(2909, 3227, 0)
    ),
    MUSHTREE_VERDANT_VALLEY("Mushtree", WorldPoint(3757, 3756, 0), WorldPoint(2909, 3227, 0)), MYTHS_GUILD_PORTAL(
        "Portal to Guilds",
        WorldPoint(2456, 2856, 0),
        WorldPoint(2909, 3227, 0)
    ),
    SOUL_WARS_PORTAL(
        "Portal to Edgeville/Ferox Enclave",
        WorldPoint(2204, 2858, 0),
        WorldPoint(2909, 3227, 0)
    ),
    TRAIN_KELDAGRIM(
        "Railway Station",
        WorldPoint(2941, 10179, 0),
        WorldPoint(2909, 3227, 0)
    ),
    WILDERNESS_LEVER_ARDOUGNE(
        "Wilderness Lever to Deserted Keep", WorldPoint(2559, 3309, 0),
        WorldPoint(3154, 3924, 0)
    ),
    WILDERNESS_LEVER_EDGEVILLE(
        "Wilderness Lever to Deserted Keep", WorldPoint(3088, 3474, 0),
        WorldPoint(3154, 3924, 0)
    ),
    WILDERNESS_LEVER_WILDERNESS(
        "Wilderness Lever to Ardougne/Edgeville",
        WorldPoint(3154, 3924, 0),
        WorldPoint(2909, 3227, 0)
    );

    internal var tooltip: String? = tooltip
    internal var location: WorldPoint? = worldPoint
    internal var target: WorldPoint? = worldPoint1

}