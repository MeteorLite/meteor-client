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

import com.google.common.collect.ArrayListMultimap
import com.google.common.collect.ListMultimap
import net.runelite.api.Client
import net.runelite.api.Tile
import net.runelite.api.coords.WorldPoint
import net.runelite.api.coords.LocalPoint
import rs117.hd.WaterType
import rs117.hd.environments.Area

enum class Underlay {
    // Lumbridge
    LUMBRIDGE_CASTLE_TILE(
        56,
        Area.LUMBRIDGE_CASTLE_BASEMENT,
        GroundMaterial.MARBLE_2_SEMIGLOSS,
        Properties().setBlended(false)
    ),  // Edgeville
    EDGEVILLE_PATH_OVERLAY_48(
        48,
        Area.EDGEVILLE_PATH_OVERLAY,
        GroundMaterial.VARROCK_PATHS_LIGHT,
        Properties().setBlendedAsOverlay(true).setHue(0).setShiftLightness(8).setSaturation(0)
    ),
    EDGEVILLE_PATH_OVERLAY_50(
        50,
        Area.EDGEVILLE_PATH_OVERLAY,
        GroundMaterial.VARROCK_PATHS_LIGHT,
        Properties().setBlendedAsOverlay(true).setHue(0).setShiftLightness(8).setSaturation(0)
    ),
    EDGEVILLE_PATH_OVERLAY_64(
        64,
        Area.EDGEVILLE_PATH_OVERLAY,
        GroundMaterial.VARROCK_PATHS_LIGHT,
        Properties().setBlendedAsOverlay(true).setHue(0).setShiftLightness(8).setSaturation(0)
    ),  // Varrock
    VARROCK_JULIETS_HOUSE_UPSTAIRS(
        8,
        Area.VARROCK_JULIETS_HOUSE,
        GroundMaterial.NONE,
        Properties().setBlended(false)
    ),  // A Soul's Bane
    TOLNA_DUNGEON_ANGER_FLOOR(58, Area.TOLNA_DUNGEON_ANGER, GroundMaterial.DIRT), TOLNA_DUNGEON_FEAR_FLOOR(
        58,
        Area.TOLNA_DUNGEON_FEAR,
        GroundMaterial.DIRT
    ),  // Burthorpe
    WARRIORS_GUILD_FLOOR_1(55, Area.WARRIORS_GUILD, GroundMaterial.VARROCK_PATHS), WARRIORS_GUILD_FLOOR_2(
        56,
        Area.WARRIORS_GUILD,
        GroundMaterial.VARROCK_PATHS
    ),  // Catherby
    CATHERBY_BEACH_SAND(62, Area.CATHERBY, GroundMaterial.SAND),  // Al Kharid
    MAGE_TRAINING_ARENA_FLOOR_PATTERN(
        56,
        Area.MAGE_TRAINING_ARENA,
        GroundMaterial.TILES_2x2_2_GLOSS,
        Properties().setBlended(false)
    ),
    KHARID_SAND_1(
        61,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),
    KHARID_SAND_2(
        62,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),
    KHARID_SAND_3(
        67,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),
    KHARID_SAND_4(
        68,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),
    KHARID_SAND_5(
        -127,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),
    KHARID_SAND_6(
        126,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),
    KHARID_SAND_7(
        49,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),
    KHARID_SAND_8(
        58,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),
    KHARID_SAND_9(
        63,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),
    KHARID_SAND_10(
        64,
        Area.KHARID_DESERT_REGION,
        GroundMaterial.SAND,
        Properties().setSaturation(3).setHue(6)
    ),  // Burthorpe games room
    GAMES_ROOM_INNER_FLOOR(
        64,
        Area.GAMES_ROOM_INNER,
        GroundMaterial.CARPET,
        Properties().setBlended(false)
    ),
    GAMES_ROOM_FLOOR(64, Area.GAMES_ROOM, GroundMaterial.WOOD_PLANKS_1, Properties().setBlended(false)),  // Crandor
    CRANDOR_SAND(-110, GroundMaterial.SAND, Properties().setSaturation(3).setHue(6)),  // God Wars Dungeon (GWD)
    GOD_WARS_DUNGEON_SNOW_1(58, Area.GOD_WARS_DUNGEON, GroundMaterial.SNOW_1), GOD_WARS_DUNGEON_SNOW_2(
        59,
        Area.GOD_WARS_DUNGEON,
        GroundMaterial.SNOW_1
    ),  // TzHaar
    INFERNO_1(-118, Area.THE_INFERNO, GroundMaterial.VARIED_DIRT), INFERNO_2(
        -115,
        Area.THE_INFERNO,
        GroundMaterial.VARIED_DIRT
    ),
    INFERNO_3(-111, Area.THE_INFERNO, GroundMaterial.VARIED_DIRT), INFERNO_4(
        -110,
        Area.THE_INFERNO,
        GroundMaterial.VARIED_DIRT
    ),
    INFERNO_5(1, Area.THE_INFERNO, GroundMaterial.VARIED_DIRT), INFERNO_6(
        61,
        Area.THE_INFERNO,
        GroundMaterial.VARIED_DIRT
    ),
    INFERNO_7(62, Area.THE_INFERNO, GroundMaterial.VARIED_DIRT), INFERNO_8(
        72,
        Area.THE_INFERNO,
        GroundMaterial.VARIED_DIRT
    ),
    INFERNO_9(118, Area.THE_INFERNO, GroundMaterial.VARIED_DIRT), INFERNO_10(
        122,
        Area.THE_INFERNO,
        GroundMaterial.VARIED_DIRT
    ),
    TZHAAR(72, Area.TZHAAR, GroundMaterial.VARIED_DIRT_SHINY, Properties().setShiftLightness(2)),  // Morytania
    VER_SINHAZA_WATER_FIX(54, Area.VER_SINHAZA_WATER_FIX, WaterType.WATER),  // Castle Wars
    CENTER_SARADOMIN_SIDE_DIRT_1(
        98,
        Area.CASTLE_WARS_ARENA_SARADOMIN_SIDE,
        GroundMaterial.DIRT,
        Properties().setHue(7).setSaturation(4)
    ),
    CENTER_SARADOMIN_SIDE_DIRT_2(
        56,
        Area.CASTLE_WARS_ARENA_SARADOMIN_SIDE,
        GroundMaterial.DIRT,
        Properties().setHue(7).setSaturation(4).setShiftLightness(3)
    ),  // Zanaris
    COSMIC_ENTITYS_PLANE_ABYSS_1(
        72,
        Area.COSMIC_ENTITYS_PLANE,
        GroundMaterial.NONE,
        Properties().setLightness(0).setBlended(false)
    ),
    COSMIC_ENTITYS_PLANE_ABYSS_2(
        2,
        Area.COSMIC_ENTITYS_PLANE,
        GroundMaterial.NONE,
        Properties().setLightness(0).setBlended(false)
    ),  // Chambers of Xeric
    COX_SNOW_1(16, Area.COX_SNOW, GroundMaterial.SNOW_1), COX_SNOW_2(
        59,
        Area.COX_SNOW,
        GroundMaterial.SNOW_2
    ),  // Mind Altar
    MIND_ALTAR_TILE(
        55,
        Area.MIND_ALTAR,
        GroundMaterial.MARBLE_1_SEMIGLOSS,
        Properties().setBlended(false)
    ),  // Cutscenes
    CANOE_CUTSCENE_GRASS_1(48, Area.CANOE_CUTSCENE, GroundMaterial.GRASS_SCROLLING), CANOE_CUTSCENE_GRASS_2(
        50,
        Area.CANOE_CUTSCENE,
        GroundMaterial.GRASS_SCROLLING
    ),
    CANOE_CUTSCENE_GRASS_3(63, Area.CANOE_CUTSCENE, GroundMaterial.GRASS_SCROLLING),  // default underlays
    UNDERLAY_N127(-127, GroundMaterial.SAND), UNDERLAY_N118(-118, GroundMaterial.SAND), UNDERLAY_N111(
        -111,
        GroundMaterial.DIRT
    ),
    UNDERLAY_N110(-110, GroundMaterial.DIRT), UNDERLAY_10(10, GroundMaterial.GRASS_1), UNDERLAY_25(
        25,
        GroundMaterial.GRASS_1
    ),
    UNDERLAY_48(48, GroundMaterial.GRASS_1), UNDERLAY_49(49, GroundMaterial.GRASS_1), UNDERLAY_50(
        50,
        GroundMaterial.GRASS_1
    ),
    UNDERLAY_51(51, GroundMaterial.GRASS_1), UNDERLAY_52(52, GroundMaterial.GRASS_1), UNDERLAY_53(
        53,
        GroundMaterial.GRASS_1
    ),
    UNDERLAY_54(54, GroundMaterial.GRASS_1), UNDERLAY_55(55, GroundMaterial.GRASS_1), UNDERLAY_56(
        56,
        GroundMaterial.GRASS_1
    ),
    UNDERLAY_57(57, GroundMaterial.GRASS_1), UNDERLAY_58(58, GroundMaterial.SNOW_1), UNDERLAY_61(
        61,
        GroundMaterial.SAND
    ),  // used in desert dungeons
    UNDERLAY_62(62, GroundMaterial.GRASS_1), UNDERLAY_63(63, GroundMaterial.GRASS_1), UNDERLAY_64(
        64,
        GroundMaterial.DIRT
    ),  //	UNDERLAY_65(65, GroundMaterial.SAND, new Properties().setSaturation(3).setHue(6)), // used in desert dungeons
    UNDERLAY_66(66, GroundMaterial.DIRT), UNDERLAY_67(67, GroundMaterial.GRASS_1), UNDERLAY_68(
        68,
        GroundMaterial.SAND
    ),  // crandor
    UNDERLAY_70(70, GroundMaterial.GRASS_1), UNDERLAY_72(72, GroundMaterial.VARIED_DIRT), UNDERLAY_75(
        75,
        GroundMaterial.GRASS_1
    ),
    UNDERLAY_80(80, GroundMaterial.DIRT), UNDERLAY_92(92, GroundMaterial.DIRT), UNDERLAY_93(
        93,
        GroundMaterial.GRASS_1
    ),
    UNDERLAY_94(94, GroundMaterial.DIRT), UNDERLAY_96(96, GroundMaterial.GRASS_1), UNDERLAY_97(
        97,
        GroundMaterial.GRASS_1
    ),
    UNDERLAY_103(103, GroundMaterial.GRASS_1), UNDERLAY_114(114, GroundMaterial.GRASS_1), UNDERLAY_115(
        115,
        GroundMaterial.GRASS_1
    ),
    UNDERLAY_126(126, GroundMaterial.GRASS_1), CORPOREAL_CAVE(98, GroundMaterial.VARIED_DIRT), NONE(
        -1,
        GroundMaterial.DIRT
    );

    val id: Int
    val area: Area
    val groundMaterial: GroundMaterial
    val waterType: WaterType
    val blended: Boolean
    val blendedAsOverlay: Boolean
    val hue: Int
    val shiftHue: Int
    val saturation: Int
    val shiftSaturation: Int
    val lightness: Int
    val shiftLightness: Int

    private class Properties {
        var blended = true
        var blendedAsOverlay = false
        var hue = -1
        var shiftHue = 0
        var saturation = -1
        var shiftSaturation = 0
        var lightness = -1
        var shiftLightness = 0
        fun setBlended(blended: Boolean): Properties {
            this.blended = blended
            return this
        }

        fun setBlendedAsOverlay(blendedAsOverlay: Boolean): Properties {
            this.blendedAsOverlay = blendedAsOverlay
            return this
        }

        fun setHue(hue: Int): Properties {
            this.hue = hue
            return this
        }

        fun setShiftHue(shiftHue: Int): Properties {
            this.shiftHue = shiftHue
            return this
        }

        fun setSaturation(saturation: Int): Properties {
            this.saturation = saturation
            return this
        }

        fun setShiftSaturation(shiftSaturation: Int): Properties {
            this.shiftSaturation = shiftSaturation
            return this
        }

        fun setLightness(lightness: Int): Properties {
            this.lightness = lightness
            return this
        }

        fun setShiftLightness(shiftLightness: Int): Properties {
            this.shiftLightness = shiftLightness
            return this
        }
    }

    constructor(id: Int, waterType: WaterType) {
        this.id = id
        area = Area.ALL
        groundMaterial = waterType.groundMaterial
        this.waterType = waterType
        blended = false
        blendedAsOverlay = false
        hue = -1
        shiftHue = 0
        saturation = -1
        shiftSaturation = 0
        lightness = -1
        shiftLightness = 0
    }

    constructor(id: Int, area: Area, waterType: WaterType) {
        this.id = id
        this.area = area
        groundMaterial = waterType.groundMaterial
        this.waterType = waterType
        blended = false
        blendedAsOverlay = false
        hue = -1
        shiftHue = 0
        saturation = -1
        shiftSaturation = 0
        lightness = -1
        shiftLightness = 0
    }

    constructor(id: Int, area: Area, groundMaterial: GroundMaterial, properties: Properties) {
        this.id = id
        this.area = area
        this.groundMaterial = groundMaterial
        waterType = WaterType.NONE
        blended = properties.blended
        blendedAsOverlay = properties.blendedAsOverlay
        hue = properties.hue
        shiftHue = properties.shiftHue
        saturation = properties.saturation
        shiftSaturation = properties.shiftSaturation
        lightness = properties.lightness
        shiftLightness = properties.shiftLightness
    }

    constructor(id: Int, area: Area, groundMaterial: GroundMaterial) {
        this.id = id
        this.area = area
        this.groundMaterial = groundMaterial
        waterType = WaterType.NONE
        blended = true
        blendedAsOverlay = false
        hue = -1
        shiftHue = 0
        saturation = -1
        shiftSaturation = 0
        lightness = -1
        shiftLightness = 0
    }

    constructor(id: Int, groundMaterial: GroundMaterial, properties: Properties) {
        this.id = id
        area = Area.ALL
        this.groundMaterial = groundMaterial
        waterType = WaterType.NONE
        blended = properties.blended
        blendedAsOverlay = properties.blendedAsOverlay
        hue = properties.hue
        shiftHue = properties.shiftHue
        saturation = properties.saturation
        shiftSaturation = properties.shiftSaturation
        lightness = properties.lightness
        shiftLightness = properties.shiftLightness
    }

    constructor(id: Int, groundMaterial: GroundMaterial) {
        this.id = id
        area = Area.ALL
        this.groundMaterial = groundMaterial
        waterType = WaterType.NONE
        blended = true
        blendedAsOverlay = false
        hue = -1
        shiftHue = 0
        saturation = -1
        shiftSaturation = 0
        lightness = -1
        shiftLightness = 0
    }

    companion object {
        private var GROUND_MATERIAL_MAP: ListMultimap<Int, Underlay>? = null
        fun getUnderlay(underlayId: Int, tile: Tile, client: Client): Underlay {
            var worldPoint = tile.worldLocation
            if (client.isInInstancedRegion) {
                val localPoint = tile.localLocation
                worldPoint = WorldPoint.fromLocalInstance(client, localPoint)
            }
            val worldX = worldPoint.x
            val worldY = worldPoint.y
            val worldZ = worldPoint.plane
            val underlays = GROUND_MATERIAL_MAP!![underlayId]
            for (underlay in underlays) {
                if (underlay.area.containsPoint(worldX, worldY, worldZ)) {
                    return underlay
                }
            }
            return NONE
        }

        init {
            GROUND_MATERIAL_MAP = ArrayListMultimap.create()
            for (underlay in values()) {
                GROUND_MATERIAL_MAP!!.put(underlay.id, underlay)
            }
        }
    }
}