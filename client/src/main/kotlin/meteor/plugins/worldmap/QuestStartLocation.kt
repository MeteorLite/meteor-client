/*
 * Copyright (c) 2018, John James Hamilton <https://github.com/johnhamilto>
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


import net.runelite.api.Quest
import net.runelite.api.coords.WorldPoint

// Some quests are in the same spot, but they are done in order. If multiple
// quests start in the same location, an array of quests is expected.
internal enum class QuestStartLocation {
    //Free Quests
    BELOW_ICE_MOUNTAIN(Quest.BELOW_ICE_MOUNTAIN, WorldPoint(3001, 3436, 0)), COOKS_ASSISTANT_RFD(
        Quest.COOKS_ASSISTANT,
        WorldPoint(3211, 3216, 0)
    ),
    THE_CORSAIR_CURSE(
        Quest.THE_CORSAIR_CURSE, WorldPoint(3029, 3273, 0)
    ),
    DEMON_SLAYER(Quest.DEMON_SLAYER, WorldPoint(3204, 3424, 0)), DORICS_QUEST(
        Quest.DORICS_QUEST, WorldPoint(2952, 3450, 0)
    ),
    DRAGON_SLAYER_I(Quest.DRAGON_SLAYER_I, WorldPoint(3190, 3362, 0)), ERNEST_THE_CHICKEN(
        Quest.ERNEST_THE_CHICKEN, WorldPoint(3109, 3330, 0)
    ),
    GOBLIN_DIPLOMACY(Quest.GOBLIN_DIPLOMACY, WorldPoint(2957, 3509, 0)), IMP_CATCHER(
        Quest.IMP_CATCHER, WorldPoint(3108, 3160, 0)
    ),
    THE_KNIGHTS_SWORD(Quest.THE_KNIGHTS_SWORD, WorldPoint(2976, 3342, 0)), MISTHALIN_MYSTERY(
        Quest.MISTHALIN_MYSTERY, WorldPoint(3235, 3155, 0)
    ),
    PIRATES_TREASURE(Quest.PIRATES_TREASURE, WorldPoint(3051, 3252, 0)), PRINCE_ALI_RESCUE(
        Quest.PRINCE_ALI_RESCUE, WorldPoint(3301, 3163, 0)
    ),
    THE_RESTLESS_GHOST(Quest.THE_RESTLESS_GHOST, WorldPoint(3240, 3210, 0)), RUNE_MYSTERIES(
        Quest.RUNE_MYSTERIES, WorldPoint(3210, 3220, 0)
    ),
    SHEEP_SHEARER(Quest.SHEEP_SHEARER, WorldPoint(3190, 3272, 0)), SHIELD_OF_ARRAV_PHOENIX_GANG(
        Quest.SHIELD_OF_ARRAV, WorldPoint(3208, 3495, 0)
    ),
    SHIELD_OF_ARRAV_BLACK_ARM_GANG(Quest.SHIELD_OF_ARRAV, WorldPoint(3208, 3392, 0)), VAMPYRE_SLAYER(
        Quest.VAMPYRE_SLAYER, WorldPoint(3096, 3266, 0)
    ),
    WITCHS_POTION(Quest.WITCHS_POTION, WorldPoint(2967, 3203, 0)), X_MARKS_THE_SPOT(
        Quest.X_MARKS_THE_SPOT, WorldPoint(3227, 3242, 0)
    ),  //Members' Quests
    ANIMAL_MAGNETISM(
        Quest.ANIMAL_MAGNETISM,
        WorldPoint(3094, 3360, 0)
    ),
    ANOTHER_SLICE_OF_HAM(Quest.ANOTHER_SLICE_OF_HAM, WorldPoint(2799, 5428, 0)), THE_ASCENT_OF_ARCEUUS(
        Quest.THE_ASCENT_OF_ARCEUUS, WorldPoint(1699, 3742, 0)
    ),
    BETWEEN_A_ROCK(Quest.BETWEEN_A_ROCK, WorldPoint(2823, 10168, 0)), BIG_CHOMPY_BIRD_HUNTING(
        Quest.BIG_CHOMPY_BIRD_HUNTING, WorldPoint(2629, 2981, 0)
    ),
    BIOHAZARD(Quest.BIOHAZARD, WorldPoint(2591, 3335, 0)), BONE_VOYAGE(
        Quest.BONE_VOYAGE, WorldPoint(3259, 3450, 0)
    ),
    CABIN_FEVER(Quest.CABIN_FEVER, WorldPoint(3674, 3496, 0)), CLIENT_OF_KOUREND(
        Quest.CLIENT_OF_KOUREND, WorldPoint(1823, 3690, 0)
    ),
    CLOCK_TOWER(Quest.CLOCK_TOWER, WorldPoint(2568, 3249, 0)), COLD_WAR(
        Quest.COLD_WAR, WorldPoint(2593, 3265, 0)
    ),
    CONTACT(Quest.CONTACT, WorldPoint(3280, 2770, 0)), CREATURE_OF_FENKENSTRAIN(
        Quest.CREATURE_OF_FENKENSTRAIN, WorldPoint(3487, 3485, 0)
    ),
    DARKNESS_OF_HALLOWVALE(Quest.DARKNESS_OF_HALLOWVALE, WorldPoint(3494, 9628, 0)), DEATH_PLATEAU_TROLL_STRONGHOLD(
        arrayOf(
            Quest.DEATH_PLATEAU, Quest.TROLL_STRONGHOLD
        ),
        WorldPoint(2895, 3528, 0)
    ),
    DEATH_TO_THE_DORGESHUUN(Quest.DEATH_TO_THE_DORGESHUUN, WorldPoint(3316, 9613, 0)), THE_DEPTHS_OF_DESPAIR(
        Quest.THE_DEPTHS_OF_DESPAIR, WorldPoint(1781, 3570, 0)
    ),
    DESERT_TREASURE(Quest.DESERT_TREASURE, WorldPoint(3177, 3043, 0)), DEVIOUS_MINDS(
        Quest.DEVIOUS_MINDS, WorldPoint(3405, 3492, 0)
    ),
    THE_DIG_SITE(Quest.THE_DIG_SITE, WorldPoint(3363, 3337, 0)), DRAGON_SLAYER_II(
        Quest.DRAGON_SLAYER_II, WorldPoint(2456, 2868, 0)
    ),
    DREAM_MENTOR(Quest.DREAM_MENTOR, WorldPoint(2144, 10346, 0)), DRUIDIC_RITUAL(
        Quest.DRUIDIC_RITUAL, WorldPoint(2916, 3484, 0)
    ),
    DWARF_CANNON(Quest.DWARF_CANNON, WorldPoint(2566, 3461, 0)), EADGARS_RUSE(
        Quest.EADGARS_RUSE, WorldPoint(2896, 3426, 0)
    ),
    EAGLES_PEAK(Quest.EAGLES_PEAK, WorldPoint(2605, 3264, 0)), ELEMENTAL_WORKSHOP(
        arrayOf(
            Quest.ELEMENTAL_WORKSHOP_I, Quest.ELEMENTAL_WORKSHOP_II
        ),
        WorldPoint(2714, 3482, 0)
    ),
    ENAKHRAS_LAMENT(Quest.ENAKHRAS_LAMENT, WorldPoint(3190, 2926, 0)), ENLIGHTENED_JOURNEY(
        Quest.ENLIGHTENED_JOURNEY, WorldPoint(2809, 3356, 0)
    ),
    THE_EYES_OF_GLOUPHRIE(Quest.THE_EYES_OF_GLOUPHRIE, WorldPoint(2400, 3419, 0)), FAIRYTALE(
        arrayOf(
            Quest.FAIRYTALE_I__GROWING_PAINS, Quest.FAIRYTALE_II__CURE_A_QUEEN
        ),
        WorldPoint(3077, 3258, 0)
    ),
    FAMILY_CREST(Quest.FAMILY_CREST, WorldPoint(3278, 3404, 0)), THE_FEUD(
        Quest.THE_FEUD,
        WorldPoint(3301, 3211, 0)
    ),
    FIGHT_ARENA(
        Quest.FIGHT_ARENA, WorldPoint(2565, 3199, 0)
    ),
    FISHING_CONTEST_1(Quest.FISHING_CONTEST, WorldPoint(2875, 3483, 0)), FISHING_CONTEST_2(
        Quest.FISHING_CONTEST, WorldPoint(2820, 3487, 0)
    ),
    FORGETTABLE_TALE(Quest.FORGETTABLE_TALE, WorldPoint(2826, 10215, 0)), THE_FORSAKEN_TOWER(
        Quest.THE_FORSAKEN_TOWER, WorldPoint(1482, 3748, 0)
    ),
    THE_FREMENNIK_ISLES(Quest.THE_FREMENNIK_ISLES, WorldPoint(2645, 3711, 0)), THE_FREMENNIK_TRIALS(
        Quest.THE_FREMENNIK_TRIALS, WorldPoint(2657, 3669, 0)
    ),
    THE_FREMENNIK_EXILES(Quest.THE_FREMENNIK_EXILES, WorldPoint(2658, 3669, 0)), GARDEN_OF_TRANQUILLITY(
        Quest.GARDEN_OF_TRANQUILLITY, WorldPoint(3227, 3477, 0)
    ),
    GERTRUDES_CAT_RATCATCHERS(Quest.GERTRUDES_CAT, WorldPoint(3150, 3411, 0)), GETTING_AHEAD(
        Quest.GETTING_AHEAD, WorldPoint(1247, 3686, 0)
    ),
    GHOSTS_AHOY(Quest.GHOSTS_AHOY, WorldPoint(3677, 3510, 0)), THE_GIANT_DWARF(
        Quest.THE_GIANT_DWARF, WorldPoint(2841, 10129, 0)
    ),
    THE_GOLEM(Quest.THE_GOLEM, WorldPoint(3487, 3089, 0)), THE_GRAND_TREE_MONKEY_MADNESS(
        arrayOf(
            Quest.THE_GRAND_TREE, Quest.MONKEY_MADNESS_I, Quest.MONKEY_MADNESS_II
        ),
        WorldPoint(2466, 3497, 0)
    ),
    THE_GREAT_BRAIN_ROBBERY(Quest.THE_GREAT_BRAIN_ROBBERY, WorldPoint(3681, 2963, 0)), GRIM_TALES(
        Quest.GRIM_TALES, WorldPoint(2890, 3454, 0)
    ),
    THE_HAND_IN_THE_SAND(Quest.THE_HAND_IN_THE_SAND, WorldPoint(2552, 3101, 0)), HAUNTED_MINE(
        Quest.HAUNTED_MINE, WorldPoint(3443, 3258, 0)
    ),
    HAZEEL_CULT(Quest.HAZEEL_CULT, WorldPoint(2565, 3271, 0)), HEROES_QUEST(
        Quest.HEROES_QUEST, WorldPoint(2903, 3511, 0)
    ),
    HOLY_GRAIL(arrayOf(Quest.MERLINS_CRYSTAL, Quest.HOLY_GRAIL), WorldPoint(2763, 3515, 0)), HORROR_FROM_THE_DEEP(
        Quest.HORROR_FROM_THE_DEEP, WorldPoint(2507, 3635, 0)
    ),
    ICTHLARINS_LITTLE_HELPER(Quest.ICTHLARINS_LITTLE_HELPER, WorldPoint(3314, 2849, 0)), IN_SEARCH_OF_THE_MYREQUE(
        Quest.IN_SEARCH_OF_THE_MYREQUE, WorldPoint(3502, 3477, 0)
    ),
    JUNGLE_POTION(Quest.JUNGLE_POTION, WorldPoint(2809, 3086, 0)), A_KINGDOM_DIVIDED(
        Quest.A_KINGDOM_DIVIDED, WorldPoint(1663, 3672, 0)
    ),
    KINGS_RANSOM(Quest.KINGS_RANSOM, WorldPoint(2741, 3554, 0)), LEGENDS_QUEST(
        Quest.LEGENDS_QUEST, WorldPoint(2725, 3367, 0)
    ),
    LOST_CITY(Quest.LOST_CITY, WorldPoint(3149, 3205, 0)), THE_LOST_TRIBE(
        Quest.THE_LOST_TRIBE, WorldPoint(3211, 3224, 0)
    ),
    LUNAR_DIPLOMACY(Quest.LUNAR_DIPLOMACY, WorldPoint(2618, 3691, 0)), MAKING_FRIENDS_WITH_MY_ARM(
        Quest.MAKING_FRIENDS_WITH_MY_ARM, WorldPoint(2904, 10092, 0)
    ),
    MAKING_HISTORY(Quest.MAKING_HISTORY, WorldPoint(2435, 3346, 0)), MONKS_FRIEND(
        Quest.MONKS_FRIEND, WorldPoint(2605, 3209, 0)
    ),
    MOUNTAIN_DAUGHTER(Quest.MOUNTAIN_DAUGHTER, WorldPoint(2810, 3672, 0)), MOURNINGS_ENDS_PART_I(
        Quest.MOURNINGS_END_PART_I, WorldPoint(2289, 3149, 0)
    ),
    MOURNINGS_ENDS_PART_II(Quest.MOURNINGS_END_PART_II, WorldPoint(2352, 3172, 0)), MURDER_MYSTERY(
        Quest.MURDER_MYSTERY, WorldPoint(2740, 3562, 0)
    ),
    MY_ARMS_BIG_ADVENTURE(Quest.MY_ARMS_BIG_ADVENTURE, WorldPoint(2908, 10088, 0)), NATURE_SPIRIT(
        Quest.NATURE_SPIRIT, WorldPoint(3440, 9894, 0)
    ),
    A_NIGHT_AT_THE_THEATRE(Quest.A_NIGHT_AT_THE_THEATRE, WorldPoint(3672, 3224, 0)), OBSERVATORY_QUEST(
        Quest.OBSERVATORY_QUEST, WorldPoint(2438, 3185, 0)
    ),
    OLAFS_QUEST(Quest.OLAFS_QUEST, WorldPoint(2723, 3729, 0)), ONE_SMALL_FAVOUR(
        Quest.ONE_SMALL_FAVOUR, WorldPoint(2834, 2985, 0)
    ),
    PLAGUE_CITY_SONG_OF_THE_ELVES(
        arrayOf(Quest.PLAGUE_CITY, Quest.SONG_OF_THE_ELVES),
        WorldPoint(2567, 3334, 0)
    ),
    A_PORCINE_OF_INTEREST(Quest.A_PORCINE_OF_INTEREST, WorldPoint(3085, 3251, 0)), PRIEST_IN_PERIL(
        Quest.PRIEST_IN_PERIL, WorldPoint(3219, 3473, 0)
    ),
    THE_QUEEN_OF_THIEVES(Quest.THE_QUEEN_OF_THIEVES, WorldPoint(1795, 3782, 0)), RAG_AND_BONE_MAN_I(
        arrayOf(
            Quest.RAG_AND_BONE_MAN_I, Quest.RAG_AND_BONE_MAN_II
        ),
        WorldPoint(3359, 3504, 0)
    ),
    RECRUITMENT_DRIVE_BLACK_KNIGHTS_FORTRESS(
        arrayOf(Quest.BLACK_KNIGHTS_FORTRESS, Quest.RECRUITMENT_DRIVE),
        WorldPoint(2959, 3336, 0)
    ),
    ROVING_ELVES(Quest.ROVING_ELVES, WorldPoint(2288, 3146, 0)), RUM_DEAL(
        Quest.RUM_DEAL,
        WorldPoint(3679, 3535, 0)
    ),
    SCORPION_CATCHER(
        Quest.SCORPION_CATCHER, WorldPoint(2701, 3399, 0)
    ),
    SEA_SLUG(Quest.SEA_SLUG, WorldPoint(2715, 3302, 0)), SHADES_OF_MORTTON(
        Quest.SHADES_OF_MORTTON, WorldPoint(3463, 3308, 0)
    ),
    SHADOW_OF_THE_STORM(Quest.SHADOW_OF_THE_STORM, WorldPoint(3270, 3159, 0)), SHEEP_HERDER(
        Quest.SHEEP_HERDER, WorldPoint(2616, 3299, 0)
    ),
    SHILO_VILLAGE(Quest.SHILO_VILLAGE, WorldPoint(2882, 2951, 0)), SINS_OF_THE_FATHER(
        Quest.SINS_OF_THE_FATHER, WorldPoint(3728, 3319, 0)
    ),
    A_SOULS_BANE(Quest.A_SOULS_BANE, WorldPoint(3307, 3454, 0)), SPIRITS_OF_THE_ELID(
        Quest.SPIRITS_OF_THE_ELID, WorldPoint(3441, 2911, 0)
    ),
    SWAN_SONG(Quest.SWAN_SONG, WorldPoint(2345, 3652, 0)), TAI_BWO_WANNAI_TRIO(
        Quest.TAI_BWO_WANNAI_TRIO, WorldPoint(2779, 3087, 0)
    ),
    A_TAIL_OF_TWO_CATS(Quest.A_TAIL_OF_TWO_CATS, WorldPoint(2917, 3557, 0)), TALE_OF_THE_RIGHTEOUS(
        Quest.TALE_OF_THE_RIGHTEOUS, WorldPoint(1541, 3570, 0)
    ),
    A_TASTE_OF_HOPE(Quest.A_TASTE_OF_HOPE, WorldPoint(3668, 3216, 0)), TEARS_OF_GUTHIX(
        Quest.TEARS_OF_GUTHIX, WorldPoint(3251, 9517, 0)
    ),
    TEMPLE_OF_IKOV(Quest.TEMPLE_OF_IKOV, WorldPoint(2574, 3320, 0)), THRONE_OF_MISCELLANIA_ROYAL_TROUBLE(
        arrayOf(
            Quest.THRONE_OF_MISCELLANIA, Quest.ROYAL_TROUBLE
        ),
        WorldPoint(2497, 3859, 0)
    ),
    THE_TOURIST_TRAP(Quest.THE_TOURIST_TRAP, WorldPoint(3302, 3113, 0)), TOWER_OF_LIFE(
        Quest.TOWER_OF_LIFE,
        WorldPoint(2640, 3218, 0)
    ),
    TREE_GNOME_VILLAGE(
        Quest.TREE_GNOME_VILLAGE, WorldPoint(2541, 3169, 0)
    ),
    TRIBAL_TOTEM(Quest.TRIBAL_TOTEM, WorldPoint(2790, 3182, 0)), TROLL_ROMANCE(
        Quest.TROLL_ROMANCE, WorldPoint(2890, 10097, 0)
    ),
    UNDERGROUND_PASS_REGICIDE(
        arrayOf(Quest.REGICIDE, Quest.UNDERGROUND_PASS),
        WorldPoint(2575, 3293, 0)
    ),
    WANTED_SLUG_MENACE(
        arrayOf(Quest.WANTED, Quest.THE_SLUG_MENACE),
        WorldPoint(2996, 3373, 0)
    ),
    WATCHTOWER(Quest.WATCHTOWER, WorldPoint(2545, 3112, 0)), WATERFALL_QUEST(
        Quest.WATERFALL_QUEST,
        WorldPoint(2521, 3498, 0)
    ),
    WHAT_LIES_BELOW(
        Quest.WHAT_LIES_BELOW, WorldPoint(3265, 3333, 0)
    ),
    WITCHS_HOUSE(Quest.WITCHS_HOUSE, WorldPoint(2927, 3456, 0)), ZOGRE_FLESH_EATERS(
        Quest.ZOGRE_FLESH_EATERS, WorldPoint(2442, 3051, 0)
    );


    val location: WorldPoint


    val quests: Array<Quest?>

    constructor(quests: Array<Quest?>, location: WorldPoint) {
        this.location = location
        this.quests = quests
    }

    constructor(quest: Quest, location: WorldPoint) {
        this.location = location
        quests = arrayOf(quest)
    }
}