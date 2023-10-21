package openrsc.constants

// Normally you should just do ItemDefinition.getAppearanceId(), but not all animations have items associated with them.
enum class AppearanceId
/**
 * @param appearanceId The ID of the animation.
 */(private val appearanceId: Int, val suggestedWieldPosition: Int) {
    NOTHING(0, AppearanceSlots.ANY),
    SHORT_HAIR(1, AppearanceSlots.HEAD),
    MALE_BODY(2, AppearanceSlots.SHIRT),
    COLOURED_PANTS(3, AppearanceSlots.PANTS),
    LONG_HAIR(4, AppearanceSlots.HEAD),
    FEMALE_BODY(5, AppearanceSlots.SHIRT),
    SHORT_HAIR_2(6, AppearanceSlots.HEAD),
    LONG_BEARDED_HEAD(7, AppearanceSlots.HEAD),
    BALD_HEAD(8, AppearanceSlots.HEAD),
    CHEFS_HAT(9, AppearanceSlots.HAT),
    WHITE_APRON(10, AppearanceSlots.AMULET),
    BROWN_APRON(11, AppearanceSlots.AMULET),
    LEATHER_BOOTS(12, AppearanceSlots.BOOTS),
    LARGE_BRONZE_HELMET(13, AppearanceSlots.HAT),
    LARGE_IRON_HELMET(14, AppearanceSlots.HAT),
    LARGE_STEEL_HELMET(15, AppearanceSlots.HAT),
    LARGE_MITHRIL_HELMET(16, AppearanceSlots.HAT),
    LARGE_ADAMANTITE_HELMET(17, AppearanceSlots.HAT),
    LARGE_RUNE_HELMET(18, AppearanceSlots.HAT),
    LARGE_BLACK_HELMET(19, AppearanceSlots.HAT),
    LARGE_WHITE_HELMET(20, AppearanceSlots.HAT),  // NO ITEM
    BRONZE_CHAIN_MAIL_BODY(21, AppearanceSlots.BODY),
    IRON_CHAIN_MAIL_BODY(22, AppearanceSlots.BODY),
    STEEL_CHAIN_MAIL_BODY(23, AppearanceSlots.BODY),
    MITHRIL_CHAIN_MAIL_BODY(24, AppearanceSlots.BODY),
    ADAMANTITE_CHAIN_MAIL_BODY(25, AppearanceSlots.BODY),
    RUNE_CHAIN_MAIL_BODY(26, AppearanceSlots.BODY),
    BLACK_CHAIN_MAIL_BODY(27, AppearanceSlots.BODY),
    BRONZE_PLATE_MAIL_BODY(28, AppearanceSlots.BODY),
    IRON_PLATE_MAIL_BODY(29, AppearanceSlots.BODY),
    STEEL_PLATE_MAIL_BODY(30, AppearanceSlots.BODY),
    MITHRIL_PLATE_MAIL_BODY(31, AppearanceSlots.BODY),
    ADAMANTITE_PLATE_MAIL_BODY(32, AppearanceSlots.BODY),
    BLACK_PLATE_MAIL_BODY(33, AppearanceSlots.BODY),
    RUNE_PLATE_MAIL_BODY(34, AppearanceSlots.BODY),
    WHITE_PLATE_MAIL_BODY(35, AppearanceSlots.BODY),  // NO ITEM
    UNUSED_PLATE_MAIL_BODY(36, AppearanceSlots.BODY),  // NO ITEM (colour is between mithril & rune)
    BRONZE_PLATE_MAIL_LEGS(37, AppearanceSlots.LEGS),
    IRON_PLATE_MAIL_LEGS(38, AppearanceSlots.LEGS),
    STEEL_PLATE_MAIL_LEGS(39, AppearanceSlots.LEGS),
    MITHRIL_PLATE_MAIL_LEGS(40, AppearanceSlots.LEGS),
    ADAMANTITE_PLATE_MAIL_LEGS(41, AppearanceSlots.LEGS),
    RUNE_PLATE_MAIL_LEGS(42, AppearanceSlots.LEGS),
    BLACK_PLATE_MAIL_LEGS(43, AppearanceSlots.LEGS),
    WHITE_PLATE_MAIL_LEGS(44, AppearanceSlots.LEGS),  // NO ITEM
    UNUSED_PLATE_MAIL_LEGS(45, AppearanceSlots.LEGS),  // NO ITEM (colour is between mithril & rune)
    LEATHER_ARMOUR(46, AppearanceSlots.BODY),
    LEATHER_GLOVES(47, AppearanceSlots.GLOVES),
    BRONZE_SWORD(48, AppearanceSlots.WEAPON),
    IRON_SWORD(49, AppearanceSlots.WEAPON),
    STEEL_SWORD(50, AppearanceSlots.WEAPON),
    MITHRIL_SWORD(51, AppearanceSlots.WEAPON),
    ADAMANTITE_SWORD(52, AppearanceSlots.WEAPON),
    RUNE_SWORD(53, AppearanceSlots.WEAPON),
    BLACK_SWORD(54, AppearanceSlots.WEAPON),
    FEMALE_BRONZE_PLATE_MAIL_TOP(55, AppearanceSlots.BODY),
    FEMALE_IRON_PLATE_MAIL_TOP(56, AppearanceSlots.BODY),
    FEMALE_STEEL_PLATE_MAIL_TOP(57, AppearanceSlots.BODY),
    FEMALE_MITHRIL_PLATE_MAIL_TOP(58, AppearanceSlots.BODY),
    FEMALE_ADAMANTITE_PLATE_MAIL_TOP(59, AppearanceSlots.BODY),
    FEMALE_RUNE_PLATE_MAIL_TOP(60, AppearanceSlots.BODY),
    FEMALE_BLACK_PLATE_MAIL_TOP(61, AppearanceSlots.BODY),
    WHITE_APRON_2(62, AppearanceSlots.AMULET),  // TODO: why?
    RED_CAPE(63, AppearanceSlots.CAPE),
    BLACK_CAPE(64, AppearanceSlots.CAPE),
    BLUE_CAPE(65, AppearanceSlots.CAPE),
    GREEN_CAPE(66, AppearanceSlots.CAPE),
    YELLOW_CAPE(67, AppearanceSlots.CAPE),
    ORANGE_CAPE(68, AppearanceSlots.CAPE),
    PURPLE_CAPE(69, AppearanceSlots.CAPE),
    MEDIUM_BRONZE_HELMET(70, AppearanceSlots.HAT),
    MEDIUM_IRON_HELMET(71, AppearanceSlots.HAT),
    MEDIUM_STEEL_HELMET(72, AppearanceSlots.HAT),
    MEDIUM_MITHRIL_HELMET(73, AppearanceSlots.HAT),
    MEDIUM_ADAMANTITE_HELMET(74, AppearanceSlots.HAT),
    MEDIUM_RUNE_HELMET(75, AppearanceSlots.HAT),
    MEDIUM_BLACK_HELMET(76, AppearanceSlots.HAT),
    WIZARDS_ROBE(77, AppearanceSlots.BODY),
    WIZARDSHAT(78, AppearanceSlots.HAT),
    DARKWIZARDSHAT(79, AppearanceSlots.HAT),
    SILVER_NECKLACE(80, AppearanceSlots.AMULET),
    GOLD_NECKLACE(81, AppearanceSlots.AMULET),
    BLUE_SKIRT(82, AppearanceSlots.LEGS),
    DARKWIZARDS_ROBE(83, AppearanceSlots.BODY),
    SARADOMIN_MONK_ROBE(84, AppearanceSlots.BODY),
    ZAMORAK_MONK_ROBE(85, AppearanceSlots.BODY),
    DRUID_ROBE(86, AppearanceSlots.BODY),
    DRUID_SKIRT(87, AppearanceSlots.LEGS),
    SARADOMIN_MONK_SKIRT(88, AppearanceSlots.LEGS),
    BLACK_SKIRT(89, AppearanceSlots.LEGS),
    PINK_SKIRT(90, AppearanceSlots.LEGS),
    ZAMORAK_MONK_SKIRT(91, AppearanceSlots.LEGS),
    BRONZE_PLATED_SKIRT(92, AppearanceSlots.LEGS),
    IRON_PLATED_SKIRT(93, AppearanceSlots.LEGS),
    STEEL_PLATED_SKIRT(94, AppearanceSlots.LEGS),
    MITHRIL_PLATED_SKIRT(95, AppearanceSlots.LEGS),
    ADAMANTITE_PLATED_SKIRT(96, AppearanceSlots.LEGS),
    RUNE_PLATED_SKIRT(97, AppearanceSlots.LEGS),
    BRONZE_SQUARE_SHIELD(98, AppearanceSlots.SHIELD),
    IRON_SQUARE_SHIELD(99, AppearanceSlots.SHIELD),
    STEEL_SQUARE_SHIELD(100, AppearanceSlots.SHIELD),
    MITHRIL_SQUARE_SHIELD(101, AppearanceSlots.SHIELD),
    ADAMANTITE_SQUARE_SHIELD(102, AppearanceSlots.SHIELD),
    RUNE_SQUARE_SHIELD(103, AppearanceSlots.SHIELD),
    BLACK_SQUARE_SHIELD(104, AppearanceSlots.SHIELD),
    ANTI_DRAGON_BREATH_SHIELD(105, AppearanceSlots.SHIELD),
    WOODEN_SHIELD(106, AppearanceSlots.SHIELD),
    CROSSBOW(107, AppearanceSlots.WEAPON),
    LONGBOW(108, AppearanceSlots.WEAPON),
    BRONZE_BATTLEAXE(109, AppearanceSlots.WEAPON),
    IRON_BATTLEAXE(110, AppearanceSlots.WEAPON),
    STEEL_BATTLEAXE(111, AppearanceSlots.WEAPON),
    MITHRIL_BATTLEAXE(112, AppearanceSlots.WEAPON),
    ADAMANTITE_BATTLEAXE(113, AppearanceSlots.WEAPON),
    RUNE_BATTLEAXE(114, AppearanceSlots.WEAPON),
    BLACK_BATTLEAXE(115, AppearanceSlots.WEAPON),
    BRONZE_MACE(116, AppearanceSlots.WEAPON),
    IRON_MACE(117, AppearanceSlots.WEAPON),
    STEEL_MACE(118, AppearanceSlots.WEAPON),
    MITHRIL_MACE(119, AppearanceSlots.WEAPON),
    ADAMANTITE_MACE(120, AppearanceSlots.WEAPON),
    RUNE_MACE(121, AppearanceSlots.WEAPON),
    BLACK_MACE(122, AppearanceSlots.WEAPON),
    STAFF(123, AppearanceSlots.WEAPON),
    RAT(124, AppearanceSlots.NPC),
    DEMON(125, AppearanceSlots.NPC),
    SPIDER(126, AppearanceSlots.NPC),
    RED_SPIDER(127, AppearanceSlots.NPC),
    CAMEL(128, AppearanceSlots.NPC),
    COW(129, AppearanceSlots.NPC),
    SHEEP(130, AppearanceSlots.NPC),
    UNICORN(131, AppearanceSlots.NPC),
    BEAR(132, AppearanceSlots.NPC),
    CHICKEN(133, AppearanceSlots.NPC),
    SKELETON(134, AppearanceSlots.NPC),
    SKELETON_SCIMITAR_AND_SHIELD(135, AppearanceSlots.WEAPON),  // NO ITEM
    ZOMBIE(136, AppearanceSlots.NPC),
    ZOMBIE_AXE(137, AppearanceSlots.WEAPON),  // NO ITEM
    GHOST(138, AppearanceSlots.NPC),
    BAT(139, AppearanceSlots.NPC),
    GOBLIN(140, AppearanceSlots.NPC),
    GOBLIN_WITH_RED_ARMOUR(141, AppearanceSlots.NPC),
    GOBLIN_WITH_GREEN_ARMOUR(142, AppearanceSlots.NPC),
    GOBLIN_SPEAR(143, AppearanceSlots.WEAPON),  // NO ITEM
    SCORPION(144, AppearanceSlots.NPC),
    ELVARG(145, AppearanceSlots.NPC),
    RED_DRAGON(146, AppearanceSlots.NPC),
    BLUE_DRAGON(147, AppearanceSlots.NPC),
    WHITE_WOLF(148, AppearanceSlots.NPC),
    GREY_WOLF(149, AppearanceSlots.NPC),
    RED_PARTY_HAT(150, AppearanceSlots.HAT),
    YELLOW_PARTY_HAT(151, AppearanceSlots.HAT),
    BLUE_PARTY_HAT(152, AppearanceSlots.HAT),
    GREEN_PARTY_HAT(153, AppearanceSlots.HAT),
    PINK_PARTY_HAT(154, AppearanceSlots.HAT),
    WHITE_PARTY_HAT(155, AppearanceSlots.HAT),
    ICE_GLOVES(156, AppearanceSlots.GLOVES),  // very slightly darker than regular gloves
    FIREBIRD(157, AppearanceSlots.NPC),
    UNUSED_PLATE_MAIL_TOP(158, AppearanceSlots.BODY),  // NO ITEM (COLOUR_BETWEEN_MITHRIL_&_RUNE)
    SHADOW_WARRIOR_SKIRT(159, AppearanceSlots.LEGS),  // TODO: not sure this is actually shadow warrior
    GUARD_DOG(160, AppearanceSlots.NPC),
    ICE_SPIDER(161, AppearanceSlots.NPC),
    DRAGON_BATTLEAXE(162, AppearanceSlots.WEAPON),
    DRAGON_SWORD(163, AppearanceSlots.WEAPON),
    RIGHT_EYEPATCH(164, AppearanceSlots.HAT),
    BLACK_DEMON(165, AppearanceSlots.NPC),
    BLACK_DRAGON(166, AppearanceSlots.NPC),
    POISON_SPIDER(167, AppearanceSlots.NPC),
    HELLHOUND(168, AppearanceSlots.NPC),
    BLACK_UNICORN(169, AppearanceSlots.NPC),
    CHRONOZON(170, AppearanceSlots.NPC),
    SHADOW_SPIDER(171, AppearanceSlots.NPC),
    PENDANT_OF_LUCIEN(172, AppearanceSlots.AMULET),
    DUNGEON_RAT(173, AppearanceSlots.NPC),
    KHAZARD_HELMET(174, AppearanceSlots.HAT),
    KHAZARD_CHAINMAIL(175, AppearanceSlots.BODY),
    ZAMORAK_WIZARDSHAT(176, AppearanceSlots.HAT),  // NO ITEM, Used on some gnomes
    MOURNER_LEGS(177, AppearanceSlots.PANTS),
    GAS_MASK(178, AppearanceSlots.HAT),
    DRAGON_MEDIUM_HELMET(179, AppearanceSlots.HAT),
    JUNGLE_SPIDER(180, AppearanceSlots.NPC),
    SPEAR(181, AppearanceSlots.WEAPON),
    GREEN_HALLOWEEN_MASK(182, AppearanceSlots.HAT),
    PRIEST_ROBE(183, AppearanceSlots.BODY),
    PRIEST_GOWN(184, AppearanceSlots.LEGS),
    RED_HALLOWEEN_MASK(185, AppearanceSlots.HAT),
    BLUE_HALLOWEEN_MASK(186, AppearanceSlots.HAT),
    PASTEL_PINK_GNOME_SKIRT(187, AppearanceSlots.LEGS),
    PASTEL_GREEN_GNOME_SKIRT(188, AppearanceSlots.LEGS),
    PASTEL_BLUE_GNOME_SKIRT(189, AppearanceSlots.LEGS),
    PASTEL_YELLOW_GNOME_SKIRT(190, AppearanceSlots.LEGS),
    PASTEL_CYAN_GNOME_SKIRT(191, AppearanceSlots.LEGS),
    PASTEL_PINK_GNOMESHAT(192, AppearanceSlots.HAT),
    PASTEL_GREEN_GNOMESHAT(193, AppearanceSlots.HAT),
    PASTEL_BLUE_GNOMESHAT(194, AppearanceSlots.HAT),
    PASTEL_YELLOW_GNOMESHAT(195, AppearanceSlots.HAT),
    PASTEL_CYAN_GNOMESHAT(196, AppearanceSlots.HAT),
    PASTEL_PINK_GNOME_TOP(197, AppearanceSlots.BODY),
    PASTEL_GREEN_GNOME_TOP(198, AppearanceSlots.BODY),
    PASTEL_BLUE_GNOME_TOP(199, AppearanceSlots.BODY),
    PASTEL_YELLOW_GNOME_TOP(200, AppearanceSlots.BODY),
    PASTEL_CYAN_GNOME_TOP(201, AppearanceSlots.BODY),
    GREEN_ROBE(202, AppearanceSlots.BODY),  // NO ITEM (Used for Rashiliyia)
    GREEN_SKIRT(203, AppearanceSlots.LEGS),  // NO ITEM (Used for Rashiliyia)
    PASTEL_PINK_GNOME_BOOTS(204, AppearanceSlots.BOOTS),
    PASTEL_GREEN_GNOME_BOOTS(205, AppearanceSlots.BOOTS),
    PASTEL_BLUE_GNOME_BOOTS(206, AppearanceSlots.BOOTS),
    PASTEL_YELLOW_GNOME_BOOTS(207, AppearanceSlots.BOOTS),
    PASTEL_CYAN_GNOME_BOOTS(208, AppearanceSlots.BOOTS),
    SANTA_HAT(209, AppearanceSlots.HAT),
    STAFF_OF_IBAN(210, AppearanceSlots.WEAPON),
    SOULESS(211, AppearanceSlots.NPC),
    DESERT_BOOTS(212, AppearanceSlots.BOOTS),
    WHITE_PANTS(213, AppearanceSlots.PANTS),
    SLAVES_ROBE_TOP(214, AppearanceSlots.BODY),
    SLAVES_ROBE_BOTTOM(215, AppearanceSlots.LEGS),
    AL_SHABIM_CAPE(216, AppearanceSlots.CAPE),  // Think this is identical in appearance to a Cape of Legends
    DESERT_WOLF(217, AppearanceSlots.NPC),
    BUNNY_EARS(218, AppearanceSlots.HAT),
    STAFF_OF_SARADOMIN(219, AppearanceSlots.WEAPON),
    GUJOU_RUNE_SPEAR(220, AppearanceSlots.WEAPON),  // NO ITEM (no, not even rune spear)
    GUJUO_SKIRT(221, AppearanceSlots.LEGS),
    GUJUO_ROBE_TOP(222, AppearanceSlots.BODY),
    KARAMJA_WOLF(223, AppearanceSlots.NPC),
    OOMLIE_BIRD(224, AppearanceSlots.NPC),
    DRAGON_SQUARE_SHIELD(225, AppearanceSlots.SHIELD),
    CAPE_OF_LEGENDS(226, AppearanceSlots.CAPE),
    SHADOW_WARRIOR_BOOTS(227, AppearanceSlots.BOOTS),
    SHADOW_WARRIOR_ROBE(228, AppearanceSlots.BODY),
    SCYTHE(229, AppearanceSlots.WEAPON),  // End of authentic animation sprites
    BUNNY(473, AppearanceSlots.NPC),
    DUCK(474, AppearanceSlots.NPC),
    BUNNY_MORPH(475, AppearanceSlots.MORPHING_RING),
    EGG_MORPH(476, AppearanceSlots.MORPHING_RING),

    DEATH_MASK(484, AppearanceSlots.HAT),
    YOYO_IN_HAND(485, AppearanceSlots.WEAPON),
    YOYO_UP_DOWN_ANIM1(486, AppearanceSlots.WEAPON),
    YOYO_UP_DOWN_ANIM2(487, AppearanceSlots.WEAPON),
    YOYO_UP_DOWN_ANIM3(488, AppearanceSlots.WEAPON),
    YOYO_UP_DOWN_ANIM4(489, AppearanceSlots.WEAPON),
    YOYO_CRAZY_1_OCLOCK(490, AppearanceSlots.WEAPON),
    YOYO_CRAZY_2_OCLOCK(491, AppearanceSlots.WEAPON),
    YOYO_CRAZY_3_OCLOCK(492, AppearanceSlots.WEAPON),
    YOYO_CRAZY_4_OCLOCK(493, AppearanceSlots.WEAPON),
    YOYO_CRAZY_5_OCLOCK(494, AppearanceSlots.WEAPON),
    YOYO_CRAZY_7_OCLOCK(495, AppearanceSlots.WEAPON),
    YOYO_CRAZY_8_OCLOCK(496, AppearanceSlots.WEAPON),
    YOYO_CRAZY_9_OCLOCK(497, AppearanceSlots.WEAPON),
    YOYO_CRAZY_10_OCLOCK(498, AppearanceSlots.WEAPON),
    YOYO_CRAZY_11_OCLOCK(499, AppearanceSlots.WEAPON),
    YOYO_CRAZY_12_OCLOCK(500, AppearanceSlots.WEAPON),

    OGRE_EARS(501, AppearanceSlots.HAT),
    LEATHER_VEST(502, AppearanceSlots.BODY),

    AGILITY_CAPE(512, AppearanceSlots.CAPE),
    DEFENSE_CAPE(513, AppearanceSlots.CAPE),
    FIREMAKING_CAPE(514, AppearanceSlots.CAPE),
    HERBLAW_CAPE(515, AppearanceSlots.CAPE),
    HITS_CAPE(516, AppearanceSlots.CAPE),
    PRAYER_CAPE(517, AppearanceSlots.CAPE),
    RANGED_CAPE(518, AppearanceSlots.CAPE),
    WOODCUTTING_CAPE(519, AppearanceSlots.CAPE),
    HARVESTING_CAPE(520, AppearanceSlots.CAPE),
    RUNECRAFT_CAPE(521, AppearanceSlots.CAPE),
    QUEST_CAPE(522, AppearanceSlots.CAPE),
    MAX_CAPE(523, AppearanceSlots.CAPE),
    BRONZE_CHAIN_MAIL_TOP(524, AppearanceSlots.BODY),
    IRON_CHAIN_MAIL_TOP(525, AppearanceSlots.BODY),
    STEEL_CHAIN_MAIL_TOP(526, AppearanceSlots.BODY),
    MITHRIL_CHAIN_MAIL_TOP(527, AppearanceSlots.BODY),
    ADAMANTITE_CHAIN_MAIL_TOP(528, AppearanceSlots.BODY),
    RUNE_CHAIN_MAIL_TOP(529, AppearanceSlots.BODY),
    BLACK_CHAIN_MAIL_TOP(530, AppearanceSlots.BODY),
    DRAGON_SCALE_MAIL_TOP(531, AppearanceSlots.BODY);


    /**
     * @return The animations ID
     */
    fun id(): Int {
        return appearanceId
    }

    internal object AppearanceSlots {
        const val NPC: Int = -2
        const val ANY: Int = -1
        const val HEAD: Int = 0
        const val SHIRT: Int = 1
        const val PANTS: Int = 2
        const val SHIELD: Int = 3
        const val WEAPON: Int = 4
        const val HAT: Int = 5
        const val BODY: Int = 6
        const val LEGS: Int = 7
        const val GLOVES: Int = 8
        const val BOOTS: Int = 9
        const val AMULET: Int = 10
        const val CAPE: Int = 11
        const val ARROW: Int = 12
        const val MORPHING_RING: Int = 13
    }

    companion object {
        private val byId: MutableMap<Int, AppearanceId?> = HashMap()

        init {
            for (appearance in entries) {
                require(byId.put(appearance.id(), appearance) == null) { "duplicate id: " + appearance.id() }
            }
        }

        fun getById(id: Int): AppearanceId? {
            return byId.getOrDefault(id, NOTHING)
        }

        fun maximumAnimationSprite(clientVersion: Int): Int {
            return when (clientVersion) {
                38 -> SCORPION.id()
                140 -> KHAZARD_CHAINMAIL.id()
                177, 235 -> SCYTHE.id()
                else -> Int.MAX_VALUE
            }
        }

        const val SLOT_NPC: Int = -2
        const val SLOT_ANY: Int = -1
        const val SLOT_HEAD: Int = 0
        const val SLOT_SHIRT: Int = 1
        const val SLOT_PANTS: Int = 2
        const val SLOT_SHIELD: Int = 3
        const val SLOT_WEAPON: Int = 4
        const val SLOT_HAT: Int = 5
        const val SLOT_BODY: Int = 6
        const val SLOT_LEGS: Int = 7
        const val SLOT_GLOVES: Int = 8
        const val SLOT_BOOTS: Int = 9
        const val SLOT_AMULET: Int = 10
        const val SLOT_CAPE: Int = 11
        const val SLOT_ARROW: Int = 12
        const val SLOT_MORPHING_RING: Int = 13
    }
}
