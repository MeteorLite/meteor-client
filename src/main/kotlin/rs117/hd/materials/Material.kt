/*
 * Copyright (c) 2021, 117 <https://twitter.com/117scape>
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
package rs117.hd.materials

import java.util.HashMap

enum class Material {
    // default
    NONE(-1),  // reserve first 128 materials for vanilla OSRS texture ids
    TRAPDOOR(0), WATER_FLAT(1), BRICK(2), WOOD_PLANKS_1(
        3,
        Properties().setSpecular(0.35f, 30f)
    ),
    DOOR(4), DARK_WOOD(5), ROOF_SHINGLES_1(6, Properties().setSpecular(0.5f, 30f)), TEXTURE_7(7), LEAVES_1(
        8,
        Properties().setTextureScale(1.3f, 1.0f)
    ),
    TEXTURE_9(9), TEXTURE_10(10), CONCRETE(11), IRON_FENCE(12), PAINTING_LANDSCAPE(13), PAINTING_KING(14), MARBLE_DARK(
        15,
        Properties().setSpecular(1.1f, 380f)
    ),
    TEXTURE_16(16), TEXTURE_17(17), STRAW(18), NET(19), BOOKCASE(20), TEXTURE_21(21), WOOD_PLANKS_2(
        22,
        Properties().setSpecular(0.35f, 30f)
    ),
    BRICK_BROWN(23), WATER_FLAT_2(24), SWAMP_WATER_FLAT(25), SPIDER_WEB(26), TEXTURE_27(27), MOSS(28), PALM_LEAF(29), WILLOW_LEAVES(
        30,
        Properties().setTextureScale(1.025f, 1.0f)
    ),
    LAVA(
        31,
        Properties().setEmissive(1f).setDisplacement(235, 0.05f, 36f, 22f).setScroll(0f, 3f)
    ),
    TEXTURE_32(32), MAPLE_LEAVES(33, Properties().setTextureScale(1.3f, 1.0f)), MAGIC_STARS(
        34,
        Properties().setEmissive(1.0f)
    ),
    SAND_BRICK(35), TEXTURE_36(36), CHAIN(37), TEXTURE_38(38), PAINTING_ELF(39), FIRE_CAPE(
        40,
        Properties().setEmissive(1f).setDisplacement(235, 0.05f, 12f, 4f).setScroll(0f, -3f)
    ),
    LEAVES_2(41, Properties().setTextureScale(1.1f, 1.1f)), MARBLE(42, Properties().setSpecular(1.0f, 400f)), TILE_DARK(
        43
    ),
    TEXTURE_44(44), TEXTURE_45(45), STONE_PATTERN(46), TEXTURE_47(47), HIEROGLYPHICS(48), TEXTURE_49(49), TEXTURE_50(50), TEXTURE_51(
        51
    ),
    SNOW_FLAKES(52), TEXTURE_53(53), TEXTURE_54(54), TEXTURE_55(55), TEXTURE_56(56), TEXTURE_57(57), TEXTURE_58(58), INFERNAL_CAPE(
        59,
        Properties().setEmissive(1f).setDisplacement(235, 0.02f, 12f, 4f).setScroll(0f, 0f)
    ),
    TEXTURE_60(60), TEXTURE_61(61), TEXTURE_62(62), TEXTURE_63(63), TEXTURE_64(64), TEXTURE_65(65), TEXTURE_66(66), TEXTURE_67(
        67
    ),
    TEXTURE_68(68), TEXTURE_69(69), TEXTURE_70(70), TEXTURE_71(71), TEXTURE_72(72), TEXTURE_73(73), TEXTURE_74(74), TEXTURE_75(
        75
    ),
    TEXTURE_76(76), TEXTURE_77(77), TEXTURE_78(78), TEXTURE_79(79), TEXTURE_80(80), TEXTURE_81(81), TEXTURE_82(82), TEXTURE_83(
        83
    ),
    TEXTURE_84(84), TEXTURE_85(85), TEXTURE_86(86), TEXTURE_87(87), TEXTURE_88(88), SHAYZIEN_LEAVES_1(89), SHAYZIEN_LEAVES_2(
        90,
        Properties().setTextureScale(1.1f, 1.1f)
    ),
    TEXTURE_91(91), TEXTURE_92(92), TEXTURE_93(93), TEXTURE_94(94), TEXTURE_95(95), TEXTURE_96(96), TEXTURE_97(97), TEXTURE_98(
        98
    ),
    TEXTURE_99(99), TEXTURE_100(100), TEXTURE_101(101), TEXTURE_102(102), TEXTURE_103(103), TEXTURE_104(104), TEXTURE_105(
        105
    ),
    TEXTURE_106(106), TEXTURE_107(107), TEXTURE_108(108), TEXTURE_109(109), TEXTURE_110(110), TEXTURE_111(111), TEXTURE_112(
        112
    ),
    TEXTURE_113(113), TEXTURE_114(114), TEXTURE_115(115), TEXTURE_116(116), TEXTURE_117(117), TEXTURE_118(118), TEXTURE_119(
        119
    ),
    TEXTURE_120(120), TEXTURE_121(121), TEXTURE_122(122), TEXTURE_123(123), TEXTURE_124(124), TEXTURE_125(125), TEXTURE_126(
        126
    ),
    TEXTURE_127(127), WHITE(200), GRAY_25(201), GRAY_50(202), GRAY_75(203), BLACK(204), BLANK_GLOSS(
        200,
        Properties().setSpecular(0.9f, 280f)
    ),
    BLANK_SEMIGLOSS(
        200,
        Properties().setSpecular(0.35f, 80f)
    ),
    SNOW_1(205), SNOW_2(206), SNOW_3(207), SNOW_4(208), GRASS_1(209), GRASS_2(210), GRASS_3(211), GRASS_SCROLLING(
        209,
        Properties().setScroll(0f, 0.7f)
    ),
    DIRT_1(213), DIRT_2(214), GRAVEL(215), DIRT_SHINY_1(213, Properties().setSpecular(1.1f, 380f)), DIRT_SHINY_2(
        214,
        Properties().setSpecular(1.1f, 380f)
    ),
    GRAVEL_SHINY(
        215,
        Properties().setSpecular(1.1f, 380f)
    ),
    SAND_1(218), SAND_2(219), SAND_3(220), GRUNGE_1(221), GRUNGE_2(222), ROCK_1(223), CARPET(225), FALADOR_PATH_BRICK(
        226,
        Properties().setSpecular(0.3f, 30f)
    ),
    JAGGED_STONE_TILE(227), TILE_SMALL_1(228, Properties().setSpecular(0.8f, 70f)), TILES_1_2x2(
        229,
        Properties()
    ),
    TILES_2_2x2(230, Properties()), TILES_2x2_1_GLOSS(229, Properties().setSpecular(1.0f, 70f)), TILES_2x2_2_GLOSS(
        230,
        Properties().setSpecular(1.0f, 70f)
    ),
    TILES_2x2_1_SEMIGLOSS(229, Properties().setSpecular(0.5f, 300f)), TILES_2x2_2_SEMIGLOSS(
        230,
        Properties().setSpecular(0.5f, 300f)
    ),
    MARBLE_1(231), MARBLE_2(232), MARBLE_3(234), MARBLE_1_GLOSS(
        231,
        Properties().setSpecular(0.9f, 280f)
    ),
    MARBLE_2_GLOSS(232, Properties().setSpecular(0.8f, 300f)), MARBLE_3_GLOSS(
        234,
        Properties().setSpecular(0.7f, 320f)
    ),
    MARBLE_1_SEMIGLOSS(231, Properties().setSpecular(0.35f, 80f)), MARBLE_2_SEMIGLOSS(
        232,
        Properties().setSpecular(0.3f, 100f)
    ),
    MARBLE_3_SEMIGLOSS(234, Properties().setSpecular(0.4f, 120f)), HD_LAVA_1(
        241,
        Properties().setEmissive(1.0f).setDisplacement(235, 0.04f, 36f, 12f)
    ),
    HD_LAVA_2(242, Properties().setEmissive(1.0f).setDisplacement(235, 0.04f, 36f, 12f)), HD_MAGMA_1(
        243,
        Properties().setEmissive(1.0f).setDisplacement(235, 0.04f, 36f, 12f)
    ),
    HD_MAGMA_2(
        244,
        Properties().setEmissive(1.0f).setDisplacement(235, 0.04f, 36f, 12f)
    ),
    BARK(245), WOOD_GRAIN(247),  // water/fluid variants
    WATER(7001), SWAMP_WATER(7025), POISON_WASTE(7998), POISON_WASTE_FLAT(998), BLOOD(7999), BLOOD_FLAT(999), ICE(7997), ICE_FLAT(
        997
    );

    val diffuseMapId: Int
    val specularStrength: Float
    val specularGloss: Float
    val emissiveStrength: Float
    val displacementMapId: Int
    val displacementStrength: Float
    val displacementDurationX: Float
    val displacementDurationY: Float
    val scrollDurationX: Float
    val scrollDurationY: Float
    val textureScaleX: Float
    val textureScaleY: Float

    private class Properties {
        var specularStrength = 0f
        var specularGloss = 0f
        var emissiveStrength = 0f
        var displacementMapId = 304
        var displacementStrength = 0f
        var displacementDurationX = 0f
        var displacementDurationY = 0f
        var scrollDurationX = 0f
        var scrollDurationY = 0f
        var textureScaleX = 1.0f
        var textureScaleY = 1.0f
        fun setSpecular(specularStrength: Float, specularGloss: Float): Properties {
            this.specularStrength = specularStrength
            this.specularGloss = specularGloss
            return this
        }

        fun setEmissive(emissiveStrength: Float): Properties {
            this.emissiveStrength = emissiveStrength
            return this
        }

        fun setDisplacement(
            displacementMapId: Int,
            displacementStrength: Float,
            displacementDurationX: Float,
            displacementDurationY: Float
        ): Properties {
            this.displacementMapId = displacementMapId
            this.displacementStrength = displacementStrength
            this.displacementDurationX = displacementDurationX
            this.displacementDurationY = displacementDurationY
            return this
        }

        fun setScroll(scrollDurationX: Float, scrollDurationY: Float): Properties {
            this.scrollDurationX = scrollDurationX
            this.scrollDurationY = scrollDurationY
            return this
        }

        fun setTextureScale(textureScaleX: Float, textureScaleY: Float): Properties {
            this.textureScaleX = textureScaleX
            this.textureScaleY = textureScaleY
            return this
        }
    }

    constructor(diffuseMapId: Int) {
        this.diffuseMapId = diffuseMapId
        emissiveStrength = 0f
        specularStrength = 0f
        specularGloss = 0f
        displacementMapId = 304
        displacementStrength = 0f
        displacementDurationX = 0f
        displacementDurationY = 0f
        scrollDurationX = 0f
        scrollDurationY = 0f
        textureScaleX = 1.0f
        textureScaleY = 1.0f
    }

    constructor(diffuseMapId: Int, properties: Properties) {
        this.diffuseMapId = diffuseMapId
        emissiveStrength = properties.emissiveStrength
        specularStrength = properties.specularStrength
        specularGloss = properties.specularGloss
        displacementMapId = properties.displacementMapId
        displacementStrength = properties.displacementStrength
        displacementDurationX = properties.displacementDurationX
        displacementDurationY = properties.displacementDurationY
        scrollDurationX = properties.scrollDurationX
        scrollDurationY = properties.scrollDurationY
        textureScaleX = properties.textureScaleX
        textureScaleY = properties.textureScaleY
    }

    companion object {
        private var DIFFUSE_ID_MATERIAL_MAP: HashMap<Int, Material>? = null
        fun getTexture(diffuseMapId: Int): Material {
            return DIFFUSE_ID_MATERIAL_MAP!!.getOrDefault(diffuseMapId, NONE)
        }

        private var MATERIAL_INDEX_MAP: HashMap<Material, Int>? = null
        fun getIndex(material: Material): Int {
            return MATERIAL_INDEX_MAP!!.getOrDefault(material, 0)
        }

        val allTextures: Array<Material>
            get() = values()

        init {
            DIFFUSE_ID_MATERIAL_MAP = HashMap()
            for (material in values()) {
                if (!DIFFUSE_ID_MATERIAL_MAP!!.containsKey(material.diffuseMapId)) {
                    DIFFUSE_ID_MATERIAL_MAP!![material.diffuseMapId] = material
                }
            }
        }

        init {
            MATERIAL_INDEX_MAP = HashMap()
            for ((index, material) in values().withIndex()) {
                MATERIAL_INDEX_MAP!![material] = index
            }
        }
    }
}