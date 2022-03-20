package meteor.api.quest

/**
 * Server controlled "content-developer" integers.
 *
 * VarPlayers are stored per RuneScape player save, and synchronized
 * from the server to the client. The client can change them preemptively
 * if it thinks they will change the next tick as a lag-hiding measure.
 * The client CANNOT directly make the server change a varbit.
 */
enum class QuestVarP(val varp: Int) {
    /**
     * f2p Quest varbits, these don't hold the completion value.
     */
    BLACK_KNIGHTS_FORTRESS(130),
    COOKS_ASSISTANT(29),
    DORICS_QUEST(31),
    DRAGON_SLAYER_I(176),
    ERNEST_THE_CHICKEN(32),
    IMP_CATCHER(160),
    THE_KNIGHTS_SWORD(122),
    PIRATES_TREASURE(71),
    PRINCE_ALI_RESCUE(273),
    THE_RESTLESS_GHOST(107),
    ROMEO_AND_JULIET(144),
    RUNE_MYSTERIES(63),
    SHEEP_SHEARER(179),
    SHIELD_OF_ARRAV(145),
    SHIELD_OF_ARRAV_STATE_146(146),
    VAMPYRE_SLAYER(178),
    WITCHS_POTION(67),

    /**
     * member Quest varbits, these don't hold the completion value.
     */
    BIG_CHOMPY_BIRD_HUNTING(293),
    BIOHAZARD(68),
    CABIN_FEVER(655),
    CLOCK_TOWER(10),
    CREATURE_OF_FENKENSTRAIN(399),
    DEATH_PLATEAU(314),
    THE_DIG_SITE(131),
    DRUIDIC_RITUAL(80),
    DWARF_CANNON(0),
    EADGARS_RUSE(335),
    ELEMENTAL_WORKSHOP_I(299),
    FAMILY_CREST(148),
    FIGHT_ARENA(17),
    FISHING_CONTEST(11),
    THE_FREMENNIK_TRIALS(347),
    WATERFALL_QUEST(65),
    GERTRUDES_CAT(180),
    THE_GRAND_TREE(150),
    HAUNTED_MINE(382),
    HAZEEL_CULT(223),
    HEROES_QUEST(188),
    HOLY_GRAIL(5),
    IN_SEARCH_OF_THE_MYREQUE(387),
    JUNGLE_POTION(175),
    LEGENDS_QUEST(139),
    LOST_CITY(147),
    MERLINS_CRYSTAL(14),
    MONKEY_MADNESS_I(365),
    MONKS_FRIEND(30),
    MOURNINGS_END_PART_I(517),
    MURDER_MYSTERY(192),
    NATURE_SPIRIT(307),
    OBSERVATORY_QUEST(112),
    ONE_SMALL_FAVOUR(416),
    PLAGUE_CITY(165),
    PRIEST_IN_PERIL(302),
    RAG_AND_BONE_MAN_I(714),
    REGICIDE(328),
    ROVING_ELVES(402),
    RUM_DEAL(600),
    SCORPION_CATCHER(76),
    SEA_SLUG(159),
    SHADES_OF_MORTTON(339),
    SHEEP_HERDER(60),
    SHILO_VILLAGE(116),
    TAI_BWO_WANNAI_TRIO(320),
    TEMPLE_OF_IKOV(26),
    THRONE_OF_MISCELLANIA(359),
    THE_TOURIST_TRAP(197),
    WITCHS_HOUSE(226),
    TREE_GNOME_VILLAGE(111),
    TRIBAL_TOTEM(200),
    TROLL_ROMANCE(385),
    TROLL_STRONGHOLD(317),
    UNDERGROUND_PASS(161),
    UNDERGROUND_PASS_STATE_162(162),
    WATCHTOWER(212),
    THE_GREAT_BRAIN_ROBBERY(980),
    RAG_AND_BONE_MAN_II(714),

    /**
     * mini-quest varbits, these don't hold the completion value.
     */
    ENTER_THE_ABYSS(492),
    ALFRED_GRIMHANDS_BARCRAWL(77),
    ALFRED_GRIMHANDS_BARCRAWL_STATE_76(76),
    THE_MAGE_ARENA(267);
}