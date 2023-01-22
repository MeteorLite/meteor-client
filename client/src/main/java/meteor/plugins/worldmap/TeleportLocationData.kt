/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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

internal enum class TeleportLocationData {
    VARROCK(
        TeleportType.NORMAL_MAGIC, "Varrock", 25, WorldPoint(3213, 3424, 0),
        "varrock_teleport_icon.png"
    ),
    VARROCK_GE(
        TeleportType.NORMAL_MAGIC, "Varrock GE", 25, WorldPoint(3164, 3478, 0),
        "varrock_teleport_icon.png"
    ),
    LUMBRIDGE(
        TeleportType.NORMAL_MAGIC, "Lumbridge", 31, WorldPoint(3222, 3218, 0),
        "lumbridge_teleport_icon.png"
    ),
    FALADOR(
        TeleportType.NORMAL_MAGIC, "Falador", 37, WorldPoint(2965, 3381, 0),
        "falador_teleport_icon.png"
    ),
    CAMELOT(
        TeleportType.NORMAL_MAGIC, "Camelot", 45, WorldPoint(2757, 3477, 0),
        "camelot_teleport_icon.png"
    ),
    CAMELOT_BANK(
        TeleportType.NORMAL_MAGIC, "Camelot Bank", 45, WorldPoint(2726, 3485, 0),
        "camelot_teleport_icon.png"
    ),
    ARDOUGNE(
        TeleportType.NORMAL_MAGIC, "Ardougne", 51, WorldPoint(2664, 3306, 0),
        "ardougne_teleport_icon.png"
    ),
    WATCHTOWER(
        TeleportType.NORMAL_MAGIC, "Watchtower", 58, WorldPoint(2547, 3114, 0),
        "watchtower_teleport_icon.png"
    ),
    WATCHTOWER_YANILLE(
        TeleportType.NORMAL_MAGIC, "Watchtower Yanille", 58,
        WorldPoint(2584, 3097, 0), "watchtower_teleport_icon.png"
    ),
    TROLLHEIM(
        TeleportType.NORMAL_MAGIC, "Trollheim", 61, WorldPoint(2891, 3678, 0),
        "trollheim_teleport_icon.png"
    ),
    APE_ATOLL(
        TeleportType.NORMAL_MAGIC, "Ape Atoll", 64, WorldPoint(2796, 2791, 0),
        "ape_atoll_teleport_icon.png"
    ),
    KOUREND(
        TeleportType.NORMAL_MAGIC, "Kourend", 69, WorldPoint(1643, 3672, 0),
        "kourend_teleport_icon.png"
    ),
    PADDEWWA(
        TeleportType.ANCIENT_MAGICKS, "Paddewwa", 54, WorldPoint(3097, 9880, 0),
        "paddewwa_teleport_icon.png"
    ),
    SENNTISTEN(
        TeleportType.ANCIENT_MAGICKS, "Senntisten", 60, WorldPoint(3319, 3336, 0),
        "senntisten_teleport_icon.png"
    ),
    KHARYRLL(
        TeleportType.ANCIENT_MAGICKS, "Kharyrll", 66, WorldPoint(3494, 3473, 0),
        "kharyrll_teleport_icon.png"
    ),
    LASSAR(
        TeleportType.ANCIENT_MAGICKS, "Lassar", 72, WorldPoint(3002, 3472, 0),
        "lassar_teleport_icon.png"
    ),
    DAREEYAK(
        TeleportType.ANCIENT_MAGICKS, "Dareeyak", 78, WorldPoint(2969, 3695, 0),
        "dareeyak_teleport_icon.png"
    ),
    CARRALLANGAR(
        TeleportType.ANCIENT_MAGICKS, "Carrallangar", 84, WorldPoint(3157, 3667, 0),
        "carrallangar_teleport_icon.png"
    ),
    ANNAKARL(
        TeleportType.ANCIENT_MAGICKS, "Annakarl", 90, WorldPoint(3288, 3888, 0),
        "annakarl_teleport_icon.png"
    ),
    GHORROCK(
        TeleportType.ANCIENT_MAGICKS, "Ghorrock", 96, WorldPoint(2977, 3872, 0),
        "ghorrock_teleport_icon.png"
    ),
    MOONCLAN(
        TeleportType.LUNAR_MAGIC, "Moonclan", 69, WorldPoint(2113, 3915, 0),
        "moonclan_teleport_icon.png"
    ),
    OURANIA(
        TeleportType.LUNAR_MAGIC, "Ourania", 71, WorldPoint(2468, 3246, 0),
        "ourania_teleport_icon.png"
    ),
    WATERBIRTH(
        TeleportType.LUNAR_MAGIC, "Waterbirth", 72, WorldPoint(2546, 3755, 0),
        "waterbirth_teleport_icon.png"
    ),
    BARBARIAN(
        TeleportType.LUNAR_MAGIC, "Barbarian", 75, WorldPoint(2543, 3568, 0),
        "barbarian_teleport_icon.png"
    ),
    KHAZARD(
        TeleportType.LUNAR_MAGIC, "Khazard", 78, WorldPoint(2636, 3167, 0),
        "khazard_teleport_icon.png"
    ),
    FISHING_GUILD(
        TeleportType.LUNAR_MAGIC, "Fishing Guild", 85, WorldPoint(2612, 3391, 0),
        "fishing_guild_teleport_icon.png"
    ),
    CATHERBY(
        TeleportType.LUNAR_MAGIC, "Catherby", 87, WorldPoint(2802, 3449, 0),
        "catherby_teleport_icon.png"
    ),
    ICE_PLATEAU(
        TeleportType.LUNAR_MAGIC, "Ice Plateau", 89, WorldPoint(2973, 3939, 0),
        "ice_plateau_teleport_icon.png"
    ),
    ARCEUUS_LIBRARY(
        TeleportType.ARCEUUS_MAGIC, "Arceuus Library", 6, WorldPoint(1632, 3838, 0),
        "arceuus_library_teleport_icon_arceuus.png"
    ),
    DRAYNOR_MANOR(
        TeleportType.ARCEUUS_MAGIC, "Draynor Manor", 17, WorldPoint(3108, 3352, 0),
        "draynor_manor_teleport_icon.png"
    ),
    BATTLEFRONT(
        TeleportType.ARCEUUS_MAGIC, "Battlefront", 23, WorldPoint(1349, 3739, 0),
        "battlefront_teleport_icon.png"
    ),
    MIND_ALTAR(
        TeleportType.ARCEUUS_MAGIC, "Mind Altar", 28, WorldPoint(2979, 3509, 0),
        "mind_altar_teleport_icon.png"
    ),
    SALVE_GRAVEYARD(
        TeleportType.ARCEUUS_MAGIC, "Salve Graveyard", 40, WorldPoint(3433, 3461, 0),
        "salve_graveyard_teleport_icon.png"
    ),
    FENKENSTRAINS_CASTLE(
        TeleportType.ARCEUUS_MAGIC, "Fenkenstrain's Castle", 48,
        WorldPoint(3548, 3528, 0), "fenkenstrains_castle_teleport_icon.png"
    ),
    WEST_ARDOUGNE(
        TeleportType.ARCEUUS_MAGIC, "West Ardougne", 61, WorldPoint(2500, 3291, 0),
        "west_ardougne_teleport_icon.png"
    ),
    HARMONY_ISLAND(
        TeleportType.ARCEUUS_MAGIC, "Harmony Island", 65, WorldPoint(3797, 2866, 0),
        "harmony_island_teleport_icon.png"
    ),
    CEMETERY(
        TeleportType.ARCEUUS_MAGIC, "Cemetery", 71, WorldPoint(2978, 3763, 0),
        "cemetery_teleport_icon.png"
    ),
    BARROWS(
        TeleportType.ARCEUUS_MAGIC, "Barrows", 83, WorldPoint(3565, 3315, 0),
        "barrows_teleport_icon.png"
    ),
    APE_ATOLL_ARCEUUS(
        TeleportType.ARCEUUS_MAGIC, "Ape Atoll", 90, WorldPoint(2770, 2703, 0),
        "ape_atoll_teleport_icon_arceuus.png"
    ),  // Jewellery
    BARBARIAN_ASSAULT(
        TeleportType.JEWELLERY, "Games Necklace", "Barbarian Assault",
        WorldPoint(2520, 3571, 0), "games_necklace_teleport_icon.png"
    ),
    BURTHORPE_GAMES_ROOM(
        TeleportType.JEWELLERY, "Games Necklace", "Burthorpe Games Room",
        WorldPoint(2898, 3554, 0), "games_necklace_teleport_icon.png"
    ),
    TEARS_OF_GUTHIX(
        TeleportType.JEWELLERY, "Games Necklace", "Tears of Guthix",
        WorldPoint(3245, 9500, 0), "games_necklace_teleport_icon.png"
    ),
    CORPOREAL_BEAST(
        TeleportType.JEWELLERY, "Games Necklace", "Corporeal Beast",
        WorldPoint(2967, 4384, 0), "games_necklace_teleport_icon.png"
    ),
    WINTERTODT_CAMP(
        TeleportType.JEWELLERY, "Games Necklace", "Wintertodt Camp",
        WorldPoint(1624, 3938, 0), "games_necklace_teleport_icon.png"
    ),
    DUEL_ARENA(
        TeleportType.JEWELLERY, "Ring of Dueling", "Duel Arena", WorldPoint(3315, 3235, 0),
        "ring_of_dueling_teleport_icon.png"
    ),
    FEROX_ENCLAVE(
        TeleportType.JEWELLERY, "Ring of Dueling", "Ferox Enclave",
        WorldPoint(3151, 3636, 0), "ring_of_dueling_teleport_icon.png"
    ),
    CASTLE_WARS(
        TeleportType.JEWELLERY, "Ring of Dueling", "Castle Wars",
        WorldPoint(2441, 3091, 0), "ring_of_dueling_teleport_icon.png"
    ),
    WARRIORS_GUILD(
        TeleportType.JEWELLERY, "Combat Bracelet", "Warriors' Guild",
        WorldPoint(2883, 3549, 0), "combat_bracelet_teleport_icon.png"
    ),
    CHAMPIONS_GUILD(
        TeleportType.JEWELLERY, "Combat Bracelet", "Champions' Guild",
        WorldPoint(3189, 3368, 0), "combat_bracelet_teleport_icon.png"
    ),
    EDGEVILLE_MONASTERY(
        TeleportType.JEWELLERY, "Combat Bracelet", "Edgeville Monastery",
        WorldPoint(3053, 3487, 0), "combat_bracelet_teleport_icon.png"
    ),
    RANGING_GUILD(
        TeleportType.JEWELLERY, "Combat Bracelet", "Ranging Guild",
        WorldPoint(2654, 3441, 0), "combat_bracelet_teleport_icon.png"
    ),
    FISHING_GUILD_NECK(
        TeleportType.JEWELLERY, "Skills Necklace", "Fishing Guild",
        WorldPoint(2613, 3390, 0), "skills_necklace_teleport_icon.png"
    ),
    MINING_GUILD(
        TeleportType.JEWELLERY, "Skills Necklace", "Mining Guild",
        WorldPoint(3049, 9762, 0), "skills_necklace_teleport_icon.png"
    ),
    CRAFTING_GUILD(
        TeleportType.JEWELLERY, "Skills Necklace", "Crafting Guild",
        WorldPoint(2934, 3294, 0), "skills_necklace_teleport_icon.png"
    ),
    COOKING_GUILD(
        TeleportType.JEWELLERY, "Skills Necklace", "Cooking Guild",
        WorldPoint(3145, 3438, 0), "skills_necklace_teleport_icon.png"
    ),
    WOODCUTTING_GUILD(
        TeleportType.JEWELLERY, "Skills Necklace", "Woodcutting Guild",
        WorldPoint(1662, 3505, 0), "skills_necklace_teleport_icon.png"
    ),
    FARMING_GUILD(
        TeleportType.JEWELLERY, "Skills Necklace", "Farming Guild",
        WorldPoint(1249, 3717, 0), "skills_necklace_teleport_icon.png"
    ),
    EDGEVILLE(
        TeleportType.JEWELLERY, "Amulet of Glory", "Edgeville", WorldPoint(3087, 3496, 0),
        "amulet_of_glory_teleport_icon.png"
    ),
    KARAMJA(
        TeleportType.JEWELLERY, "Amulet of Glory", "Karamja", WorldPoint(2918, 3176, 0),
        "amulet_of_glory_teleport_icon.png"
    ),
    DRAYNOR_VILLAGE(
        TeleportType.JEWELLERY, "Amulet of Glory", "Draynor Village",
        WorldPoint(3105, 3251, 0), "amulet_of_glory_teleport_icon.png"
    ),
    AL_KHARID(
        TeleportType.JEWELLERY, "Amulet of Glory", "Al-Kharid", WorldPoint(3293, 3163, 0),
        "amulet_of_glory_teleport_icon.png"
    ),
    MISCELLANIA(
        TeleportType.JEWELLERY, "Ring of Wealth", "Miscellania",
        WorldPoint(2535, 3862, 0), "ring_of_wealth_teleport_icon.png"
    ),
    GRAND_EXCHANGE(
        TeleportType.JEWELLERY, "Ring of Wealth", "Grand Exchange",
        WorldPoint(3162, 3480, 0), "ring_of_wealth_teleport_icon.png"
    ),
    FALADOR_PARK(
        TeleportType.JEWELLERY, "Ring of Wealth", "Falador Park",
        WorldPoint(2995, 3375, 0), "ring_of_wealth_teleport_icon.png"
    ),
    DONDAKAN(
        TeleportType.JEWELLERY, "Ring of Wealth", "Dondakan", WorldPoint(2831, 10165, 0),
        "ring_of_wealth_teleport_icon.png"
    ),
    SLAYER_TOWER(
        TeleportType.JEWELLERY, "Slayer Ring", "Slayer Tower", WorldPoint(3423, 3536, 0),
        "slayer_ring_teleport_icon.png"
    ),
    FREMENNIK_SLAYER_DUNGEON(
        TeleportType.JEWELLERY, "Slayer Ring", "Fremennik Slayer Dungeon",
        WorldPoint(2800, 9998, 0), "slayer_ring_teleport_icon.png"
    ),
    FREMENNIK_SLAYER_DUNGEON_OUTSIDE(
        TeleportType.JEWELLERY, "Slayer Ring",
        "Fremennik Slayer Dungeon (inside)", WorldPoint(2800, 3615, 0),
        "slayer_ring_teleport_icon.png"
    ),
    TARNS_LAIR(
        TeleportType.JEWELLERY, "Slayer Ring", "Tarn's Lair", WorldPoint(3187, 4601, 0),
        "slayer_ring_teleport_icon.png"
    ),
    STRONGHOLD_SLAYER_CAVE(
        TeleportType.JEWELLERY, "Slayer Ring", "Stronghold Slayer Cave",
        WorldPoint(2433, 3421, 0), "slayer_ring_teleport_icon.png"
    ),
    DARK_BEASTS(
        TeleportType.JEWELLERY, "Slayer Ring", "Dark Beasts", WorldPoint(2028, 4638, 0),
        "slayer_ring_teleport_icon.png"
    ),
    DIGSITE(
        TeleportType.JEWELLERY, "Digsite Pendant", "Digsite", WorldPoint(3339, 3445, 0),
        "digsite_pendant_teleport_icon.png"
    ),
    HOUSE_ON_THE_HILL(
        TeleportType.JEWELLERY, "Digsite Pendant", "House on the Hill",
        WorldPoint(3763, 3869, 0), "digsite_pendant_teleport_icon.png"
    ),
    LITHKREN(
        TeleportType.JEWELLERY, "Digsite Pendant", "Lithkren", WorldPoint(3547, 10456, 0),
        "digsite_pendant_teleport_icon.png"
    ),
    WIZARDS_TOWER(
        TeleportType.JEWELLERY, "Necklace of Passage", "Wizards' Tower",
        WorldPoint(3114, 3181, 0), "necklace_of_passage_teleport_icon.png"
    ),
    JORRALS_OUTPOST(
        TeleportType.JEWELLERY, "Necklace of Passage", "Jorral's Outpost",
        WorldPoint(2431, 3348, 0), "necklace_of_passage_teleport_icon.png"
    ),
    DESERT_EAGLE_STATION(
        TeleportType.JEWELLERY, "Necklace of Passage",
        "Desert eagle station of the eagle transport system", WorldPoint(3406, 3157, 0),
        "necklace_of_passage_teleport_icon.png"
    ),
    CHAOS_TEMPLE(
        TeleportType.JEWELLERY, "Burning Amulet", "Chaos Temple (lvl 15)",
        WorldPoint(3234, 3637, 0), "burning_amulet_teleport_icon.png"
    ),
    BANDIT_CAMP(
        TeleportType.JEWELLERY, "Burning Amulet", "Bandit Camp (lvl 17)",
        WorldPoint(3038, 3651, 0), "burning_amulet_teleport_icon.png"
    ),
    LAVA_MAZE(
        TeleportType.JEWELLERY, "Burning Amulet", "Lava Maze (lvl 41)",
        WorldPoint(3028, 3840, 0), "burning_amulet_teleport_icon.png"
    ),  // Misc
    XERICS_LOOKOUT(
        TeleportType.OTHER, "Xeric's Talisman", "Xeric's Lookout",
        WorldPoint(1576, 3528, 0), "xerics_talisman_teleport_icon.png"
    ),
    XERICS_GLADE(
        TeleportType.OTHER, "Xeric's Talisman", "Xeric's Glade",
        WorldPoint(1754, 3564, 0), "xerics_talisman_teleport_icon.png"
    ),
    XERICS_INFERNO(
        TeleportType.OTHER, "Xeric's Talisman", "Xeric's Inferno",
        WorldPoint(1504, 3819, 0), "xerics_talisman_teleport_icon.png"
    ),
    XERICS_HEART(
        TeleportType.OTHER, "Xeric's Talisman", "Xeric's Heart",
        WorldPoint(1641, 3670, 0), "xerics_talisman_teleport_icon.png"
    ),
    XERICS_HONOUR(
        TeleportType.OTHER, "Xeric's Talisman", "Xeric's Honour",
        WorldPoint(1254, 3559, 0), "xerics_talisman_teleport_icon.png"
    ),
    STRONGHOLD_OF_SECURITY(
        TeleportType.OTHER, "Skull Sceptre", "Stronghold of Security",
        WorldPoint(3081, 3421, 0), "skull_sceptre_teleport_icon.png"
    ),
    MYTHS_GUILD(
        TeleportType.OTHER, "Mythical Cape", "Myth's Guild", WorldPoint(2458, 2851, 0),
        "mythical_cape_teleport_icon.png"
    ),
    ECTOFUNTUS(
        TeleportType.OTHER, "Ectophial", "Ectofuntus", WorldPoint(3660, 3522, 0),
        "ectophial_teleport_icon.png"
    ),
    CHAMPIONS_GUILD_CHRONICLE(
        TeleportType.OTHER, "Chronicle", "Champions' Guild",
        WorldPoint(3202, 3357, 0), "chronicle_teleport_icon.png"
    ),
    GRAND_TREE(
        TeleportType.OTHER, "Royal Seed Pod", "Grand Tree", WorldPoint(2465, 3495, 0),
        "royal_seed_pod_teleport_icon.png"
    ),
    RELLEKKKA_LYRE(
        TeleportType.OTHER, "Enchanted Lyre", "Rellekka", WorldPoint(2664, 3643, 0),
        "enchanted_lyre_teleport_icon.png"
    ),
    WATERBIRTH_ISLAND_LYRE(
        TeleportType.OTHER, "Enchanted Lyre", "Waterbirth Island",
        WorldPoint(2550, 3756, 0), "enchanted_lyre_teleport_icon.png"
    ),
    NEITIZNOT_LYRE(
        TeleportType.OTHER, "Enchanted Lyre", "Neitiznot", WorldPoint(2336, 3801, 0),
        "enchanted_lyre_teleport_icon.png"
    ),
    JATIZSO_LYRE(
        TeleportType.OTHER, "Enchanted Lyre", "Jatizso", WorldPoint(2409, 3809, 0),
        "enchanted_lyre_teleport_icon.png"
    ),
    WEISS_ICY_BASALT(
        TeleportType.OTHER, "Icy Basalt", "Weiss", WorldPoint(2846, 3940, 0),
        "icy_basalt_teleport_icon.png"
    ),
    TROLL_STRONGHOLD_STONY_BASALT(
        TeleportType.OTHER, "Stony Basalt",
        "Troll Stronghold (with 73 Agility)", WorldPoint(2838, 3693, 0),
        "stony_basalt_teleport_icon.png"
    ),
    TROLL_STRONGHOLD_STONY_BASALT_OUTSIDE(
        TeleportType.OTHER, "Stony Basalt", "Troll Stronghold",
        WorldPoint(2844, 3693, 0), "stony_basalt_teleport_icon.png"
    ),
    KHAREDSTS_MEMOIRS_HOSIDIUS(
        TeleportType.OTHER, "Kharedst's Memoirs",
        "Lunch by the Lancalliums (Hosidius)", WorldPoint(1713, 3612, 0),
        "kharedsts_memoirs_teleport_icon.png"
    ),
    KHAREDSTS_MEMOIRS_PISCARILIUS(
        TeleportType.OTHER, "Kharedst's Memoirs",
        "The Fisher's Flute (Piscarilius)", WorldPoint(1802, 3748, 0),
        "kharedsts_memoirs_teleport_icon.png"
    ),
    KHAREDSTS_MEMOIRS_SHAYZIEN(
        TeleportType.OTHER, "Kharedst's Memoirs",
        "History and Hearsay (Shayzien)", WorldPoint(1478, 3576, 0),
        "kharedsts_memoirs_teleport_icon.png"
    ),
    KHAREDSTS_MEMOIRS_LOVAKENGJ(
        TeleportType.OTHER, "Kharedst's Memoirs",
        "Jewelry of Jubilation (Lovakengj)", WorldPoint(1544, 3762, 0),
        "kharedsts_memoirs_teleport_icon.png"
    ),
    KHAREDSTS_MEMOIRS_ARCEUUS(
        TeleportType.OTHER, "Kharedst's Memoirs",
        "A Dark Disposition (Arceuus)", WorldPoint(1680, 3746, 0),
        "kharedsts_memoirs_teleport_icon.png"
    ),
    PHARAOHS_SCEPTRE_JALSAVRAH(
        TeleportType.OTHER, "Pharaoh's Sceptre", "Jalsavrah (Pyramid Plunder)",
        WorldPoint(3288, 2795, 0), "pharaohs_sceptre_teleport_icon.png"
    ),
    PHARAOHS_SCEPTRE_JALEUSTROPHOS(
        TeleportType.OTHER, "Pharaoh's Sceptre",
        "Jaleustrophos (Agility Pyramid)", WorldPoint(3341, 2827, 0),
        "pharaohs_sceptre_teleport_icon.png"
    ),
    PHARAOHS_SCEPTRE_JALDRAOCHT(
        TeleportType.OTHER, "Pharaoh's Sceptre",
        "Jaldraocht (Desert Treasure Pyramid)", WorldPoint(3232, 2897, 0),
        "pharaohs_sceptre_teleport_icon.png"
    ),
    CAMULET_TEMPLE(
        TeleportType.OTHER, "Camulet", "Enakhra's Temple", WorldPoint(3190, 2923, 0),
        "camulet_teleport_icon.png"
    ),
    TELEPORT_CRYSTAL_LLETYA(
        TeleportType.OTHER, "Teleport crystal", "Lletya",
        WorldPoint(2330, 3172, 0), "teleport_crystal_icon.png"
    ),
    TELEPORT_CRYSTAL_PRIFDDINAS(
        TeleportType.OTHER, "Teleport crystal", "Prifddinas",
        WorldPoint(3264, 6065, 0), "teleport_crystal_icon.png"
    ),
    DRAKANS_MEDALLION_VER_SINHAZA(
        TeleportType.OTHER, "Drakan's medallion", "Ver Sinhaza",
        WorldPoint(3649, 3230, 0), "drakans_medallion_teleport_icon.png"
    ),
    DRAKANS_MEDALLION_DARKMEYER(
        TeleportType.OTHER, "Drakan's medallion", "Darkmeyer",
        WorldPoint(3592, 3337, 0), "drakans_medallion_teleport_icon.png"
    ),  // Wilderness
    OBELISK_13(
        TeleportType.OTHER, "Obelisk", "13", WorldPoint(3156, 3620, 0),
        "obelisk_icon.png"
    ),
    OBELISK_19(
        TeleportType.OTHER, "Obelisk", "19", WorldPoint(3227, 3667, 0),
        "obelisk_icon.png"
    ),
    OBELISK_27(
        TeleportType.OTHER, "Obelisk", "27", WorldPoint(3035, 3732, 0),
        "obelisk_icon.png"
    ),
    OBELISK_35(
        TeleportType.OTHER, "Obelisk", "35", WorldPoint(3106, 3794, 0),
        "obelisk_icon.png"
    ),
    OBELISK_44(
        TeleportType.OTHER, "Obelisk", "44", WorldPoint(2980, 3866, 0),
        "obelisk_icon.png"
    ),
    OBELISK_50(
        TeleportType.OTHER, "Obelisk", "50", WorldPoint(3307, 3916, 0),
        "obelisk_icon.png"
    ),
    WILDERNESS_CRABS_TELEPORT(
        TeleportType.OTHER, "Wilderness crabs teleport",
        WorldPoint(3348, 3783, 0), "wilderness_crabs_teleport_icon.png"
    ),
    CANOE_WILDERNESS(
        TeleportType.OTHER, "Canoe (No departure)", "35", WorldPoint(3141, 3796, 0),
        "transportation_icon.png"
    ),  // Achievement Diary
    ARDOUGNE_CLOAK_MONASTERY(
        TeleportType.OTHER, "Ardougne Cloak", "Monastery",
        WorldPoint(2606, 3222, 0), "ardougne_cloak_icon.png"
    ),
    ARDOUGNE_CLOAK_FARM(
        TeleportType.OTHER, "Ardougne Cloak", "Farm", WorldPoint(2673, 3375, 0),
        "ardougne_cloak_icon.png"
    ),
    EXPLORERS_RING(
        TeleportType.OTHER, "Explorer's Ring", WorldPoint(3052, 3292, 0),
        "explorers_ring_icon.png"
    ),
    KARAMJA_GLOVES_GEM_MINE(
        TeleportType.OTHER, "Karamja Gloves", "Gem Mine (Underground)",
        WorldPoint(2827, 2997, 0), "karamja_gloves_icon.png"
    ),
    KARAMJA_GLOVES_DURADEL(
        TeleportType.OTHER, "Karamja Gloves", "Duradel",
        WorldPoint(2870, 2981, 0), "karamja_gloves_icon.png"
    ),
    DESERT_AMULET_NARDAH(
        TeleportType.OTHER, "Desert Amulet", "Nardah", WorldPoint(3425, 2928, 0),
        "desert_amulet_icon.png"
    ),
    DESERT_AMULKT_KALPHITE_CAVE(
        TeleportType.OTHER, "Desert Amulet", "Kalphite Cave",
        WorldPoint(3322, 3122, 0), "desert_amulet_icon.png"
    ),
    MORYTANIA_LEGS_SLIME_PIT(
        TeleportType.OTHER, "Morytania Legs", "Slime Pit (Underground)",
        WorldPoint(3654, 3516, 0), "morytania_legs_icon.png"
    ),
    MORYTANIA_LEGS_BURGH_DE_ROTT(
        TeleportType.OTHER, "Morytania Legs", "Burgh de Rott",
        WorldPoint(3482, 3231, 0), "morytania_legs_icon.png"
    ),
    FREMENNIK_SEA_BOOTS(
        TeleportType.OTHER, "Fremennik Sea Boots", WorldPoint(2640, 3675, 0),
        "fremennik_boots_icon.png"
    ),
    KANDARIN_HEADGEAR(
        TeleportType.OTHER, "Kandarin Headgear", WorldPoint(2729, 3411, 0),
        "kandarin_headgear_icon.png"
    ),
    WILDERNESS_SWORD(
        TeleportType.OTHER, "Wilderness Sword", WorldPoint(3377, 3891, 0),
        "wilderness_sword_icon.png"
    ),
    WESTERN_BANNER(
        TeleportType.OTHER, "Western Banner", WorldPoint(2329, 3685, 0),
        "western_banner_icon.png"
    ),
    RADAS_BLESSING_MOUNT_KARUULM(
        TeleportType.OTHER, "Rada's Blessing", WorldPoint(1311, 3795, 0),
        "radas_blessing_icon.png"
    ),
    RADAS_BLESSING_WOODLANG(
        TeleportType.OTHER, "Rada's Blessing", WorldPoint(1553, 3454, 0),
        "radas_blessing_icon.png"
    ),  // Scrolls
    DIGSITE_SCROLL(
        TeleportType.SCROLL, "Digsite Teleport", WorldPoint(3324, 3412, 0),
        "scroll_teleport_icon.png"
    ),
    IORWERTH_CAMP_SCROLL(
        TeleportType.SCROLL, "Iorwerth Camp Teleport", WorldPoint(2193, 3257, 0),
        "scroll_teleport_icon.png"
    ),
    FELDIP_HILLS_SCROLL(
        TeleportType.SCROLL, "Feldip Hills Teleport", WorldPoint(2542, 2925, 0),
        "scroll_teleport_icon.png"
    ),
    LUMBERYARD_SCROLL(
        TeleportType.SCROLL, "Lumberyard Teleport", WorldPoint(3303, 3487, 0),
        "scroll_teleport_icon.png"
    ),
    LUNAR_ISLE_SCROLL(
        TeleportType.SCROLL, "Lunar Isle Teleport", WorldPoint(2093, 3912, 0),
        "scroll_teleport_icon.png"
    ),
    MORTTON_SCROLL(
        TeleportType.SCROLL, "Mort'ton", WorldPoint(3489, 3288, 0),
        "scroll_teleport_icon.png"
    ),
    MOS_LEHARMLESS_SCROLL(
        TeleportType.SCROLL, "Mos Le'Harmless Teleport",
        WorldPoint(3701, 2996, 0), "scroll_teleport_icon.png"
    ),
    NARDAH_SCROLL(
        TeleportType.SCROLL, "Nardah Teleport", WorldPoint(3421, 2917, 0),
        "scroll_teleport_icon.png"
    ),
    PEST_CONTROL_SCROLL(
        TeleportType.SCROLL, "Pest Control Teleport", WorldPoint(2657, 2660, 0),
        "scroll_teleport_icon.png"
    ),
    PISCATORIS_SCROLL(
        TeleportType.SCROLL, "Piscatoris Teleport", WorldPoint(2339, 3648, 0),
        "scroll_teleport_icon.png"
    ),
    TAI_BWO_WANNAI_SCROLL(
        TeleportType.SCROLL, "Tai Bwo Wannai Teleport",
        WorldPoint(2788, 3066, 0), "scroll_teleport_icon.png"
    ),
    ZULANDRA_SCROLL(
        TeleportType.SCROLL, "Zul-Andra Teleport", WorldPoint(2197, 3056, 0),
        "scroll_teleport_icon.png"
    ),
    KEY_MASTER_SCROLL(
        TeleportType.SCROLL, "Key Master Teleport", WorldPoint(2686, 9882, 0),
        "scroll_teleport_icon.png"
    ),
    REVENANT_CAVE_SCROLL(
        TeleportType.SCROLL, "Revenant Cave Teleport", WorldPoint(3127, 3833, 0),
        "scroll_teleport_icon.png"
    ),
    WATSON_SCROLL(
        TeleportType.SCROLL, "Watson Teleport", WorldPoint(1645, 3579, 0),
        "scroll_teleport_icon.png"
    );

    val type: TeleportType
    val tooltip: String
    val location: WorldPoint
    val iconPath: String

    constructor(
        type: TeleportType, destination: String, magicLevel: Int, location: WorldPoint,
        iconPath: String
    ) {
        this.type = type
        tooltip = type.prefix + " " + destination + " - lvl " + magicLevel
        this.location = location
        this.iconPath = iconPath
    }

    constructor(
        type: TeleportType, item: String, destination: String, location: WorldPoint,
        iconPath: String
    ) {
        this.type = type
        tooltip = "$item - $destination"
        this.location = location
        this.iconPath = iconPath
    }

    constructor(type: TeleportType, item: String, location: WorldPoint, iconPath: String) {
        this.type = type
        tooltip = item
        this.location = location
        this.iconPath = iconPath
    }
}