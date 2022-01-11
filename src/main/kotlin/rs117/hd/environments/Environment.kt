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
package rs117.hd.environments

import rs117.hd.HDUtils.gammaToLinear
import rs117.hd.RGB.rgb
import java.awt.Color

enum class Environment(val area: Area, properties: Properties) {
    FROZEN_WASTE_PLATEAU(
        Area.FROZEN_WASTE_PLATEAU, Properties()
            .setFogColor("#252C37")
            .setFogDepth(80)
            .setAmbientStrength(0.4f)
            .setAmbientColor("#3B87E4")
            .setDirectionalStrength(2.5f)
            .setDirectionalColor("#8A9EB6")
    ),
    WILDERNESS_HIGH(
        Area.WILDERNESS_HIGH, Properties()
            .setFogColor("#464449")
            .setFogDepth(30)
            .setAmbientStrength(0.5f)
            .setAmbientColor(215, 210, 210)
            .setDirectionalStrength(2.0f)
            .setDirectionalColor("#C5B8B6")
            .enableLightning()
            .setGroundFog(-0, -250, 0.3f)
    ),
    WILDERNESS_LOW(
        Area.WILDERNESS_LOW, Properties()
            .setFogColor("#A9A2B0")
            .setFogDepth(20)
            .setAmbientStrength(0.6f)
            .setAmbientColor(215, 210, 210)
            .setDirectionalStrength(2.5f)
            .setDirectionalColor(138, 158, 182)
    ),
    WILDERNESS(
        Area.WILDERNESS, Properties()
            .setFogColor("#695B6B")
            .setFogDepth(30)
            .setAmbientStrength(0.6f)
            .setAmbientColor(215, 210, 210)
            .setDirectionalStrength(2.5f)
            .setDirectionalColor("#C5B8B6")
            .setGroundFog(-0, -250, 0.3f)
    ),  // Varrock
    VARROCK_MUSEUM_BASEMENT(
        Area.VARROCK_MUSEUM_BASEMENT, Properties()
            .setFogColor("#131B26")
            .setFogDepth(20)
            .setAmbientColor("#CBC2B2")
            .setAmbientStrength(1.0f)
            .setDirectionalColor("#4C78B6")
            .setDirectionalStrength(1.0f)
    ),  // A Soul's Bane
    TOLNA_DUNGEON_ANGER(
        Area.TOLNA_DUNGEON_ANGER, Properties()
            .setFogColor("#290000")
            .setFogDepth(40)
            .setAmbientColor("#AE7D46")
            .setAmbientStrength(1.3f)
            .setDirectionalColor("#CB4848")
            .setDirectionalStrength(1.8f)
    ),
    TOLNA_DUNGEON_FEAR(
        Area.TOLNA_DUNGEON_FEAR, Properties()
            .setFogColor("#000B0F")
            .setFogDepth(40)
            .setAmbientColor("#77A0FF")
            .setAmbientStrength(1.3f)
            .setDirectionalColor("#4C78B6")
            .setDirectionalStrength(1.5f)
    ),
    TOLNA_DUNGEON_CONFUSION(
        Area.TOLNA_DUNGEON_CONFUSION, Properties()
            .setFogColor("#2E0C23")
            .setFogDepth(40)
            .setAmbientColor("#77A0FF")
            .setAmbientStrength(1.3f)
            .setDirectionalColor("#4E9DD0")
            .setDirectionalStrength(1.5f)
    ),  // Dorgesh-Kaan
    DORGESHKAAN(
        Area.DORGESHKAAN, Properties()
            .setFogColor("#190D02")
            .setFogDepth(40)
            .setAmbientColor("#FFFFFF")
            .setAmbientStrength(1.0f)
            .setDirectionalColor("#A29B71")
            .setDirectionalStrength(1.5f)
    ),
    THE_INFERNO(
        Area.THE_INFERNO, Properties()
            .setUnderglowColor(255, 0, 0)
            .setUnderglowStrength(2f)
            .setFogColor(23, 11, 7)
            .setFogDepth(20)
            .setAmbientColor(240, 184, 184)
            .setAmbientStrength(1.7f)
            .setDirectionalColor(255, 246, 202)
            .setDirectionalStrength(0f)
    ),
    TZHAAR(
        Area.TZHAAR, Properties()
            .setFogColor("#1A0808")
            .setFogDepth(15)
            .setAmbientColor("#FFEACC")
            .setAmbientStrength(0.8f)
            .setDirectionalColor("#FFA400")
            .setDirectionalStrength(1.8f)
    ),  // Morytania

    // Hallowed Sepulchre
    HALLOWED_SEPULCHRE_LOBBY(
        Area.HALLOWED_SEPULCHRE_LOBBY, Properties()
            .setFogColor("#0D1012")
            .setFogDepth(50)
            .setAmbientStrength(0.7f)
            .setAmbientColor("#C4D5EA")
            .setDirectionalStrength(1.0f)
            .setDirectionalColor("#A0BBE2")
    ),
    HALLOWED_SEPULCHRE_FLOOR_1(
        Area.HALLOWED_SEPULCHRE_FLOOR_1, Properties()
            .setFogColor(17, 28, 26)
            .setFogDepth(50)
            .setAmbientStrength(0.9f)
            .setAmbientColor(155, 187, 177)
            .setDirectionalStrength(1.8f)
            .setDirectionalColor(117, 231, 255)
    ),
    HALLOWED_SEPULCHRE_FLOOR_2(
        Area.HALLOWED_SEPULCHRE_FLOOR_2, Properties()
            .setFogColor(17, 28, 27)
            .setFogDepth(50)
            .setAmbientStrength(0.875f)
            .setAmbientColor(160, 191, 191)
            .setDirectionalStrength(1.5f)
            .setDirectionalColor(116, 214, 247)
    ),
    HALLOWED_SEPULCHRE_FLOOR_3(
        Area.HALLOWED_SEPULCHRE_FLOOR_3, Properties()
            .setFogColor(18, 28, 29)
            .setFogDepth(50)
            .setAmbientStrength(0.85f)
            .setAmbientColor(165, 195, 205)
            .setDirectionalStrength(1.5f)
            .setDirectionalColor(115, 196, 240)
    ),
    HALLOWED_SEPULCHRE_FLOOR_4(
        Area.HALLOWED_SEPULCHRE_FLOOR_4, Properties()
            .setFogColor(18, 27, 31)
            .setFogDepth(50)
            .setAmbientStrength(0.825f)
            .setAmbientColor(170, 199, 220)
            .setDirectionalStrength(1.5f)
            .setDirectionalColor(114, 178, 233)
    ),
    HALLOWED_SEPULCHRE_FLOOR_5(
        Area.HALLOWED_SEPULCHRE_FLOOR_5, Properties()
            .setFogColor(19, 27, 33)
            .setFogDepth(50)
            .setAmbientStrength(0.8f)
            .setAmbientColor(175, 202, 234)
            .setDirectionalStrength(1.5f)
            .setDirectionalColor(113, 160, 226)
    ),
    VER_SINHAZA(
        Area.VER_SINHAZA, Properties()
            .setFogColor("#1E314B")
            .setFogDepth(40)
            .setAmbientColor("#5A8CC0")
            .setAmbientStrength(1.5f)
            .setDirectionalColor("#67A8F8")
            .setDirectionalStrength(5.0f)
            .setGroundFog(-150, -350, 0.5f)
    ),
    TOB_ROOM_VAULT(
        Area.TOB_ROOM_VAULT, Properties()
            .setFogColor("#0E081A")
            .setFogDepth(40)
            .setAmbientStrength(3.0f)
            .setAmbientColor("#7575EA")
            .setDirectionalStrength(1.0f)
            .setDirectionalColor("#DDA6A6")
    ),
    THEATRE_OF_BLOOD(
        Area.THEATRE_OF_BLOOD, Properties()
            .setFogColor("#0E0C2C")
            .setFogDepth(40)
            .setAmbientStrength(3.0f)
            .setAmbientColor("#8282B0")
            .setDirectionalStrength(5.0f)
            .setDirectionalColor("#DFC0C0")
    ),
    BARROWS_CRYPTS(
        Area.BARROWS_CRYPTS, Properties()
            .setFogColor(0, 0, 0)
            .setFogDepth(20)
            .setAmbientColor(181, 143, 124)
            .setAmbientStrength(2.0f)
            .setDirectionalColor(255, 200, 117)
            .setDirectionalStrength(0.25f)
    ),
    BARROWS_TUNNELS(
        Area.BARROWS_TUNNELS, Properties()
            .setFogColor(0, 0, 0)
            .setFogDepth(20)
            .setAmbientColor(181, 143, 124)
            .setAmbientStrength(3.0f)
            .setDirectionalColor(255, 200, 117)
            .setDirectionalStrength(0.5f)
    ),
    BARROWS(
        Area.BARROWS, Properties()
            .setFogColor("#242D3A")
            .setFogDepth(50)
            .setAmbientColor("#5B83B3")
            .setAmbientStrength(2.0f)
            .setDirectionalColor("#526E8B")
            .setDirectionalStrength(8.0f)
            .enableLightning()
            .setGroundFog(-300, -500, 0.5f)
    ),
    DARKMEYER(
        Area.DARKMEYER, Properties()
            .setFogColor("#1E314B")
            .setFogDepth(40)
            .setAmbientColor("#8AABD5")
            .setAmbientStrength(1.0f)
            .setDirectionalColor("#62A3FF")
            .setDirectionalStrength(4.0f)
            .setGroundFog(-150, -350, 0.5f)
    ),
    MORYTANIA(
        Area.MORYTANIA, Properties()
            .setFogColor("#1E314B")
            .setFogDepth(40)
            .setAmbientColor("#5A8CC0")
            .setAmbientStrength(2.0f)
            .setDirectionalColor("#F8BF68")
            .setDirectionalStrength(2.0f)
            .setGroundFog(-150, -350, 0.5f)
    ),
    LUMBRIDGE(Area.LUMBRIDGE, Properties()), DRAYNOR_MANOR(
        Area.DRAYNOR_MANOR, Properties()
            .setFogColor(15, 14, 13)
            .setFogDepth(30)
            .setAmbientColor("#615C57")
            .setAmbientStrength(0.5f)
            .setDirectionalColor("#FFBCB7")
            .setDirectionalStrength(1.5f)
            .enableLightning()
    ),
    DRAYNOR_MANOR_BASEMENT(
        Area.DRAYNOR_MANOR_BASEMENT, Properties()
            .setFogColor("#190D02")
            .setFogDepth(40)
            .setAmbientColor("#7891B5")
            .setAmbientStrength(1.0f)
            .setDirectionalColor(76, 120, 182)
            .setDirectionalStrength(0.0f)
    ),
    DRAYNOR(Area.DRAYNOR, Properties()), MOTHERLODE_MINE(
        Area.MOTHERLODE_MINE, Properties()
            .setFogColor("#241809")
            .setFogDepth(40)
            .setAmbientColor("#AAAFB6")
            .setAmbientStrength(4.0f)
            .setDirectionalColor("#FFFFFF")
            .setDirectionalStrength(0.0f)
    ),
    FALADOR(Area.FALADOR, Properties()), GAMES_ROOM(
        Area.GAMES_ROOM, Properties()
            .setFogColor("#190D02")
            .setFogDepth(20)
            .setAmbientColor(162, 151, 148)
            .setAmbientStrength(1.2f)
            .setDirectionalColor(138, 158, 182)
            .setDirectionalStrength(0.25f)
    ),
    SOUL_WARS_RED_TEAM(
        Area.SOUL_WARS_RED_BASE, Properties()
            .setFogColor(28, 21, 13)
    ),
    TUTORIAL_SOUL_WARS_RED_TEAM(
        Area.SOUL_WARS_RED_BASE_TUTORIAL, Properties()
            .setFogColor(28, 21, 13)
    ),
    TUTORIAL_ISLE_OF_SOULS(Area.ISLE_OF_SOULS_TUTORIAL, Properties()), SMOKE_DUNGEON(
        Area.SMOKE_DUNGEON, Properties()
            .setFogColor(0, 0, 0)
            .setFogDepth(80)
            .setAmbientColor(171, 171, 171)
            .setAmbientStrength(1.0f)
            .setDirectionalColor(86, 86, 86)
            .setDirectionalStrength(1.0f)
    ),
    KHARIDIAN_DESERT_DEEP(
        Area.KHARIDIAN_DESERT_DEEP, Properties()
            .setFogColor("#CDAF7A")
            .setFogDepth(70)
            .setAmbientColor("#C0AE94")
            .setAmbientStrength(3.0f)
            .setDirectionalColor("#F5BC67")
            .setDirectionalStrength(1.0f)
    ),
    KHARIDIAN_DESERT_MID(
        Area.KHARIDIAN_DESERT_MID, Properties()
            .setFogColor("#C8B085")
            .setFogDepth(50)
            .setAmbientColor("#C0AE94")
            .setAmbientStrength(3.0f)
            .setDirectionalColor("#F5BC67")
            .setDirectionalStrength(1.0f)
    ),
    KHARIDIAN_DESERT(
        Area.KHARIDIAN_DESERT, Properties()
            .setFogColor("#C7B79B")
            .setFogDepth(25)
            .setAmbientColor("#A6AFC2")
            .setAmbientStrength(2.5f)
            .setDirectionalColor("#EDCFA3")
            .setDirectionalStrength(2.5f)
    ),
    DESERT_TREASURE_PYRAMID(
        Area.DESERT_TREASURE_PYRAMID, Properties()
            .setFogColor(39, 23, 4)
            .setFogDepth(40)
            .setAmbientColor(192, 159, 110)
            .setAmbientStrength(1.0f)
            .setDirectionalColor(138, 158, 182)
            .setDirectionalStrength(0.25f)
    ),
    PYRAMID_PLUNDER(
        Area.PYRAMID_PLUNDER, Properties()
            .setFogColor("#190D02")
            .setFogDepth(40)
            .setAmbientColor(181, 155, 121)
            .setAmbientStrength(0.6f)
            .setDirectionalColor(138, 158, 182)
            .setDirectionalStrength(0.25f)
    ),
    GIELINOR_SNOWY_NORTHERN_REGION(
        Area.GIELINOR_SNOWY_NORTHERN_REGION, Properties()
            .setFogColor("#AEBDE0")
            .setFogDepth(70)
            .setAmbientColor("#6FB0FF")
            .setAmbientStrength(1.5f)
            .setDirectionalColor("#F4E5C9")
            .setDirectionalStrength(2.5f)
    ),
    WHITE_WOLF_MOUNTAIN(Area.WHITE_WOLF_MOUNTAIN, Properties()), KEEP_LE_FAYE(
        Area.KEEP_LE_FAYE,
        Properties()
    ),
    MOUNTAIN_CAMP_ENTRY_PATH(
        Area.MOUNTAIN_CAMP_ENTRY_PATH, Properties()
            .setFogColor(178, 187, 197)
            .setFogDepth(50)
            .setAmbientStrength(0.9f)
            .setDirectionalStrength(1.0f)
            .setGroundFog(-600, -900, 0.4f)
    ),
    MOUNTAIN_CAMP(
        Area.MOUNTAIN_CAMP, Properties()
            .setFogColor(178, 187, 197)
            .setFogDepth(50)
            .setAmbientStrength(0.9f)
            .setDirectionalStrength(1.0f)
            .setGroundFog(-1200, -1600, 0.5f)
            .setGroundFog(-1200, -1600, 0.5f)
    ),
    FREMENNIK_PROVINCE(
        Area.FREMENNIK_PROVINCE, Properties()
            .setFogColor("#969CA2")
            .setFogDepth(40)
            .setAmbientStrength(0.9f)
            .setAmbientColor("#96A3CB")
            .setDirectionalStrength(2.0f)
            .setDirectionalColor("#ABC2D3")
            .setGroundFog(-200, -400, 0.3f)
    ),  // Karamja
    KARAMJA_VOLCANO_DUNGEON(
        Area.KARAMJA_VOLCANO_DUNGEON, Properties()
            .setFogColor("#190D02")
            .setFogDepth(40)
            .setAmbientColor("#7891B5")
            .setAmbientStrength(0.9f)
            .setDirectionalColor(76, 120, 182)
            .setDirectionalStrength(0.0f)
    ),
    KARAMJA(Area.KARAMJA, Properties()), UNGAEL(
        Area.UNGAEL, Properties()
            .setFogColor(226, 230, 237)
            .setFogDepth(40)
            .setAmbientColor(234, 226, 205)
            .setAmbientStrength(0.6f)
            .setDirectionalColor(130, 172, 224)
            .setDirectionalStrength(1.5f)
    ),
    FROZEN_DOOR(
        Area.FROZEN_DOOR, Properties()
            .setFogColor(3, 16, 25)
            .setFogDepth(30)
            .setAmbientColor(200, 228, 247)
            .setAmbientStrength(0.3f)
            .setDirectionalColor(146, 209, 250)
            .setDirectionalStrength(1.0f)
            .enableLightning()
    ),
    GOD_WARS_DUNGEON(
        Area.GOD_WARS_DUNGEON, Properties()
            .setFogColor(14, 59, 89)
            .setFogDepth(30)
            .setAmbientColor("#68ACFF")
            .setAmbientStrength(0.5f)
            .setDirectionalColor(146, 209, 250)
            .setDirectionalStrength(1.8f)
    ),
    TAR_SWAMP(
        Area.TAR_SWAMP, Properties()
            .setFogColor(42, 49, 36)
            .setFogDepth(50)
            .setAmbientColor(248, 224, 172)
            .setAmbientStrength(0.8f)
            .setDirectionalColor(168, 171, 144)
            .setDirectionalStrength(1.25f)
    ),
    SOTE_LLETYA_SMALL_FIRES(
        Area.SOTE_LLETYA_SMALL_FIRES, Properties()
            .setFogColor(91, 139, 120)
            .setFogDepth(30)
            .setAmbientStrength(1.0f)
            .setDirectionalStrength(0.0f)
    ),
    SOTE_LLETYA_ON_FIRE(
        Area.SOTE_LLETYA_ON_FIRE, Properties()
            .setFogColor(91, 139, 120)
            .setFogDepth(50)
            .setAmbientStrength(0.9f)
            .setDirectionalStrength(0.0f)
    ),
    POSION_WASTE(
        Area.POISON_WASTE, Properties()
            .setFogColor(50, 55, 47)
            .setFogDepth(50)
            .setAmbientColor(192, 219, 173)
            .setAmbientStrength(1.5f)
            .setDirectionalColor(173, 176, 139)
            .setDirectionalStrength(1.0f)
    ),
    TIRANNWN(
        Area.TIRANNWN, Properties()
            .setFogColor("#99D8C8")
            .setFogDepth(15)
    ),
    PRIFDDINAS(
        Area.PRIFDDINAS, Properties()
            .setFogColor("#99D8C8")
            .setFogDepth(15)
    ),
    SOTE_GRAND_LIBRARY(
        Area.SOTE_GRAND_LIBRARY, Properties()
            .setFogColor(18, 64, 83)
            .setAmbientStrength(0.3f)
            .setDirectionalStrength(1.0f)
    ),
    SOTE_FRAGMENT_OF_SEREN_ARENA(
        Area.SOTE_FRAGMENT_OF_SEREN_ARENA, Properties()
            .setFogColor(0, 0, 0)
    ),  // Yanille
    YANILLE(Area.YANILLE, Properties()),  // Nightmare Zone
    NIGHTMARE_ZONE(
        Area.NIGHTMARE_ZONE, Properties()
            .setFogColor("#190D02")
            .setFogDepth(40)
            .setAmbientColor("#F2B979")
            .setAmbientStrength(0.9f)
            .setDirectionalColor("#97DDFF")
            .setDirectionalStrength(1.0f)
    ),  // Tree Gnome Stronghold
    TREE_GNOME_STRONGHOLD(Area.TREE_GNOME_STRONGHOLD, Properties()),  // Castle Wars
    CASTLE_WARS_UNDERGROUND(
        Area.CASTLE_WARS_UNDERGROUND, Properties()
            .setFogColor("#190D02")
            .setFogDepth(40)
            .setAmbientColor("#FFD79C")
            .setAmbientStrength(1.3f)
            .setDirectionalColor("#4C78B6")
            .setDirectionalStrength(0.0f)
    ),  // Last Man Standing
    LMS_ARENA_WILD_VARROCK(
        Area.LMS_ARENA_WILD_VARROCK, Properties()
            .setFogColor("#695B6B")
            .setFogDepth(30)
            .setAmbientStrength(0.6f)
            .setAmbientColor(215, 210, 210)
            .setDirectionalStrength(2.5f)
            .setDirectionalColor("#C5B8B6")
            .setGroundFog(-0, -250, 0.3f)
    ),
    LMS_ARENA_DESERTED_ISLAND(Area.LMS_ARENA_DESERTED_ISLAND, Properties()),  // Zeah
    KARUULM_SLAYER_DUNGEON(
        Area.KARUULM_SLAYER_DUNGEON, Properties()
            .setFogColor("#051E22")
            .setFogDepth(40)
            .setAmbientColor("#A4D2E5")
            .setAmbientStrength(3.0f)
            .setDirectionalColor("#9AEAFF")
            .setDirectionalStrength(1.0f)
    ),
    KOUREND_CATACOMBS(
        Area.KOUREND_CATACOMBS, Properties()
            .setFogColor("#0E0022")
            .setFogDepth(40)
            .setAmbientColor("#8B7DDB")
            .setAmbientStrength(3.5f)
            .setDirectionalColor("#FFFFFF")
            .setDirectionalStrength(1.0f)
    ),
    MOUNT_QUIDAMORTEM(Area.MOUNT_QUIDAMORTEM, Properties()), KEBOS_LOWLANDS(
        Area.KEBOS_LOWLANDS, Properties()
            .setFogColor(41, 44, 16)
            .setFogDepth(50)
            .setAmbientColor(255, 215, 133)
            .setAmbientStrength(0.8f)
            .setDirectionalColor(207, 229, 181)
            .setDirectionalStrength(1.0f)
    ),
    BLOOD_ALTAR(
        Area.BLOOD_ALTAR, Properties()
            .setFogColor(79, 19, 37)
            .setFogDepth(30)
            .setAmbientColor(190, 72, 174)
            .setAmbientStrength(1.0f)
            .setDirectionalColor(78, 238, 255)
            .setDirectionalStrength(2.5f)
    ),
    ZEAH_SNOWY_NORTHERN_REGION(
        Area.ZEAH_SNOWY_NORTHERN_REGION, Properties()
            .setFogColor("#AEBDE0")
            .setFogDepth(70)
            .setAmbientColor("#6FB0FF")
            .setAmbientStrength(1.5f)
            .setDirectionalColor("#F4E5C9")
            .setDirectionalStrength(2.5f)
    ),
    ARCEUUS(
        Area.ARCEUUS, Properties()
            .setFogColor(19, 24, 79)
            .setFogDepth(30)
            .setAmbientColor(99, 105, 255)
            .setAmbientStrength(1.0f)
            .setDirectionalColor(78, 238, 255)
            .setDirectionalStrength(3.5f)
    ),
    LOVAKENGJ(
        Area.LOVAKENGJ, Properties()
            .setFogColor(21, 10, 5)
            .setFogDepth(40)
            .setAmbientColor(255, 215, 133)
            .setAmbientStrength(1.0f)
            .setDirectionalColor(125, 141, 179)
            .setDirectionalStrength(4.0f)
    ),  // Zanaris
    COSMIC_ENTITYS_PLANE(
        Area.COSMIC_ENTITYS_PLANE, Properties()
            .setFogColor("#000000")
            .setAmbientStrength(1.5f)
            .setAmbientColor("#DB6FFF")
            .setDirectionalStrength(3.0f)
            .setDirectionalColor("#57FF00")
    ),
    ZANARIS(
        Area.ZANARIS, Properties()
            .setFogColor(22, 63, 71)
            .setFogDepth(30)
            .setAmbientColor(115, 181, 195)
            .setAmbientStrength(0.5f)
            .setDirectionalColor(245, 214, 122)
            .setDirectionalStrength(1.3f)
    ),  // Dragon Slayer II
    DS2_FLASHBACK_PLATFORM(
        Area.DS2_FLASHBACK_PLATFORM, Properties()
            .setFogColor(0, 0, 0)
            .setFogDepth(20)
            .setAmbientStrength(1.2f)
            .setAmbientColor(255, 255, 255)
            .setDirectionalStrength(0.0f)
    ),
    DS2_FLEET_ATTACKED(
        Area.DS2_FLEET_ATTACKED, Properties()
            .setFogColor("#FFD3C7")
            .setFogDepth(20)
            .setAmbientColor("#68ACFF")
            .setAmbientStrength(0.8f)
            .setDirectionalColor("#FF8700")
            .setDirectionalStrength(4.0f)
    ),
    DS2_SHIPS(
        Area.DS2_SHIPS, Properties()
            .setFogColor("#FFD3C7")
            .setFogDepth(20)
            .setAmbientColor("#68ACFF")
            .setAmbientStrength(0.8f)
            .setDirectionalColor("#FF8700")
            .setDirectionalStrength(4.0f)
    ),  // The Gauntlet
    THE_GAUNTLET(
        Area.THE_GAUNTLET, Properties()
            .setFogColor("#090606")
            .setFogDepth(20)
            .setAmbientColor("#D2C0B7")
            .setAmbientStrength(1.5f)
            .setDirectionalColor("#78FFE3")
            .setDirectionalStrength(3.0f)
    ),
    THE_GAUNTLET_CORRUPTED(
        Area.THE_GAUNTLET_CORRUPTED, Properties()
            .setFogColor("#090606")
            .setFogDepth(20)
            .setAmbientColor("#95B6F7")
            .setAmbientStrength(1.5f)
            .setDirectionalColor("#FF7878")
            .setDirectionalStrength(3.0f)
    ),
    THE_GAUNTLET_LOBBY(
        Area.THE_GAUNTLET_LOBBY, Properties()
            .setFogColor("#090606")
            .setFogDepth(20)
            .setAmbientColor("#D2C0B7")
            .setAmbientStrength(1.5f)
            .setDirectionalColor("#78FFE3")
            .setDirectionalStrength(3.0f)
    ),  // Islands
    BRAINDEATH_ISLAND(Area.BRAINDEATH_ISLAND, Properties()),  // Ape Atoll

    // Monkey Madness 2
    MM2_AIRSHIP_PLATFORM(Area.MM2_AIRSHIP_PLATFORM, Properties()),  // POHs
    PLAYER_OWNED_HOUSE_SNOWY(
        Area.PLAYER_OWNED_HOUSE_SNOWY, Properties()
            .setFogColor("#AEBDE0")
            .setFogDepth(50)
            .setAmbientColor("#6FB0FF")
            .setAmbientStrength(1.5f)
            .setDirectionalColor("#F4E5C9")
            .setDirectionalStrength(2.5f)
    ),
    PLAYER_OWNED_HOUSE(Area.PLAYER_OWNED_HOUSE, Properties()),  // Blackhole
    BLACKHOLE(
        Area.BLACKHOLE, Properties()
            .setFogColor(0, 0, 0)
            .setFogDepth(20)
            .setAmbientStrength(1.2f)
            .setAmbientColor(255, 255, 255)
            .setDirectionalStrength(0.0f)
    ),  // Fishing Trawler
    FISHING_TRAWLER(Area.FISHING_TRAWLER, Properties()),  // Camdozaal (Below Ice Mountain)
    CAMDOZAAL(
        Area.CAMDOZAAL, Properties()
            .setFogColor("#080012")
            .setFogDepth(40)
            .setAmbientStrength(1.5f)
            .setAmbientColor("#C9B9F7")
            .setDirectionalStrength(0.0f)
            .setDirectionalColor("#6DC5FF")
    ),  // Tempoross
    TEMPOROSS_COVE(
        Area.TEMPOROSS_COVE, Properties()
            .setFogColor("#45474B")
            .setFogDepth(60)
            .setAmbientStrength(2.0f)
            .setAmbientColor("#A5ACBD")
            .setDirectionalStrength(1.0f)
            .setDirectionalColor("#707070")
            .enableLightning()
    ),  // Chambers of Xeric
    CHAMBERS_OF_XERIC(
        Area.CHAMBERS_OF_XERIC, Properties()
            .setFogColor("#122717")
            .setFogDepth(35)
            .setAmbientStrength(3.0f)
            .setAmbientColor("#7897C3")
            .setDirectionalStrength(1.0f)
            .setDirectionalColor("#ACFF68")
    ),  // Nightmare of Ashihama
    NIGHTMARE_OF_ASHIHAMA_ARENA(
        Area.NIGHTMARE_OF_ASHIHAMA_ARENA, Properties()
            .setFogColor("#000000")
            .setFogDepth(30)
            .setAmbientStrength(3.5f)
            .setAmbientColor("#9A5DFD")
            .setDirectionalStrength(2.0f)
            .setDirectionalColor("#00FF60")
    ),  // Underwater areas
    MOGRE_CAMP_CUTSCENE(Area.MOGRE_CAMP_CUTSCENE, Properties()), MOGRE_CAMP(
        Area.MOGRE_CAMP, Properties()
            .setFogColor("#133156")
            .setFogDepth(60)
            .setAmbientStrength(0.5f)
            .setAmbientColor("#255590")
            .setDirectionalStrength(5.0f)
            .setDirectionalColor("#71A3D0")
            .setGroundFog(0, -500, 0.5f)
    ),
    HARMONY_ISLAND_UNDERWATER_TUNNEL(
        Area.HARMONY_ISLAND_UNDERWATER_TUNNEL, Properties()
            .setFogColor("#133156")
            .setFogDepth(80)
            .setAmbientStrength(2.0f)
            .setAmbientColor("#255590")
            .setDirectionalStrength(2.5f)
            .setDirectionalColor("#71A3D0")
            .setGroundFog(-800, -1100, 0.5f)
    ),
    FOSSIL_ISLAND_UNDERWATER_AREA(
        Area.FOSSIL_ISLAND_UNDERWATER_AREA, Properties()
            .setFogColor("#133156")
            .setFogDepth(60)
            .setAmbientStrength(0.5f)
            .setAmbientColor("#255590")
            .setDirectionalStrength(5.0f)
            .setDirectionalColor("#71A3D0")
            .setGroundFog(-400, -750, 0.5f)
    ),  // Lunar Isle
    LUNAR_DIPLOMACY_DREAM_WORLD(
        Area.LUNAR_DIPLOMACY_DREAM_WORLD, Properties()
            .setFogColor("#000000")
            .setFogDepth(40)
            .setAmbientColor("#77A0FF")
            .setAmbientStrength(3.0f)
            .setDirectionalColor("#CAB6CD")
            .setDirectionalStrength(0.7f)
    ),  // Runecrafting altars
    NATURE_ALTAR(Area.NATURE_ALTAR, Properties()), WATER_ALTAR(
        Area.WATER_ALTAR,
        Properties()
    ),
    AIR_ALTAR(Area.AIR_ALTAR, Properties()), COSMIC_ALTAR(
        Area.COSMIC_ALTAR, Properties()
            .setFogColor("#000000")
            .setFogDepth(40)
            .setAmbientColor("#FFFFFF")
            .setAmbientStrength(0.2f)
            .setDirectionalColor("#FFFFFF")
            .setDirectionalStrength(3.0f)
    ),  // Random events
    CLASSROOM(Area.RANDOM_EVENT_CLASSROOM, Properties()), FREAKY_FORESTER(
        Area.RANDOM_EVENT_FREAKY_FORESTER,
        Properties()
    ),
    GRAVEDIGGER(
        Area.RANDOM_EVENT_GRAVEDIGGER, Properties()
    ),
    DRILL_DEMON(
        Area.RANDOM_EVENT_DRILL_DEMON, Properties()
            .setFogColor("#696559")
    ),  // Clan halls
    CLAN_HALL(Area.CLAN_HALL, Properties()),  // Standalone and miscellaneous areas
    LIGHTHOUSE(Area.LIGHTHOUSE, Properties()), SORCERESSS_GARDEN(
        Area.SORCERESSS_GARDEN,
        Properties()
    ),
    PURO_PURO(Area.PURO_PURO, Properties()), RATCATCHERS_HOUSE(
        Area.RATCATCHERS_HOUSE, Properties()
    ),
    CANOE_CUTSCENE(Area.CANOE_CUTSCENE, Properties()), FISHER_KINGS_REALM(
        Area.FISHER_KINGS_REALM,
        Properties()
    ),
    ENCHANTED_VALLEY(
        Area.ENCHANTED_VALLEY, Properties()
    ),
    UNKNOWN_OVERWORLD_SNOWY(
        Area.UNKNOWN_OVERWORLD_SNOWY, Properties()
            .setFogColor("#AEBDE0")
            .setFogDepth(70)
            .setAmbientColor("#6FB0FF")
            .setAmbientStrength(1.5f)
            .setDirectionalColor("#F4E5C9")
            .setDirectionalStrength(2.5f)
    ),
    UNKNOWN_OVERWORLD(
        Area.UNKNOWN_OVERWORLD,
        Properties()
    ),  // overrides 'ALL' to provide default daylight conditions for the overworld area
    OVERWORLD(Area.OVERWORLD, Properties()),  // used for underground, instances, etc.
    ALL(
        Area.ALL, Properties()
            .setFogColor("#241809")
            .setFogDepth(40)
            .setAmbientColor("#AAAFB6")
            .setAmbientStrength(3.0f)
            .setDirectionalColor("#FFFFFF")
            .setDirectionalStrength(0.0f)
    );

    val fogDepth: Int
    val customFogDepth: Boolean
    val fogColor: FloatArray
    val customFogColor: Boolean
    val ambientStrength: Float
    val customAmbientStrength: Boolean
    val ambientColor: FloatArray
    val customAmbientColor: Boolean
    val directionalStrength: Float
    val customDirectionalStrength: Boolean
    val directionalColor: FloatArray
    val customDirectionalColor: Boolean
    val underglowStrength: Float
    val underglowColor: FloatArray
    val lightningEnabled: Boolean
    val groundFogStart: Int
    val groundFogEnd: Int
    val groundFogOpacity: Float

    private class Properties {
        var fogDepth = 65
        var customFogDepth = false
        var fogColor = rgb(185, 214, 255)
        var customFogColor = false
        var ambientStrength = 1.0f
        var customAmbientStrength = false
        var ambientColor = rgb(151, 186, 255)
        var customAmbientColor = false
        var directionalStrength = 4.0f
        var customDirectionalStrength = false
        var directionalColor = rgb(255, 255, 255)
        var customDirectionalColor = false
        var underglowStrength = 0.0f
        var underglowColor = rgb(0, 0, 0)
        var lightningEnabled = false
        var groundFogStart = -200
        var groundFogEnd = -500
        var groundFogOpacity = 0f
        fun setFogDepth(depth: Int): Properties {
            fogDepth = depth * 10
            customFogDepth = true
            return this
        }

        fun setFogColor(r: Int, g: Int, b: Int): Properties {
            fogColor = rgb(r, g, b)
            customFogColor = true
            return this
        }

        fun setFogColor(hex: String?): Properties {
            val color = Color.decode(hex)
            fogColor = rgb(color.red, color.green, color.blue)
            customFogColor = true
            return this
        }

        fun setAmbientStrength(str: Float): Properties {
            ambientStrength = str
            customAmbientStrength = true
            return this
        }

        fun setAmbientColor(r: Int, g: Int, b: Int): Properties {
            ambientColor = rgb(r, g, b)
            customAmbientColor = true
            return this
        }

        fun setAmbientColor(hex: String?): Properties {
            val color = Color.decode(hex)
            ambientColor = rgb(color.red, color.green, color.blue)
            customAmbientColor = true
            return this
        }

        fun setDirectionalStrength(str: Float): Properties {
            directionalStrength = str
            customDirectionalStrength = true
            return this
        }

        fun setDirectionalColor(r: Int, g: Int, b: Int): Properties {
            directionalColor = rgb(r, g, b)
            customDirectionalColor = true
            return this
        }

        fun setDirectionalColor(hex: String?): Properties {
            val color = Color.decode(hex)
            directionalColor = rgb(color.red, color.green, color.blue)
            customDirectionalColor = true
            return this
        }

        fun setUnderglowStrength(str: Float): Properties {
            underglowStrength = str
            return this
        }

        fun setUnderglowColor(r: Int, g: Int, b: Int): Properties {
            underglowColor = rgb(r, g, b)
            return this
        }

        fun setUnderglowColor(hex: String?): Properties {
            val color = Color.decode(hex)
            underglowColor = rgb(color.red, color.green, color.blue)
            return this
        }

        fun setGroundFog(start: Int, end: Int, maxOpacity: Float): Properties {
            groundFogStart = start
            groundFogEnd = end
            groundFogOpacity = maxOpacity
            return this
        }

        fun enableLightning(): Properties {
            lightningEnabled = true
            return this
        }
    }

    init {
        fogDepth = properties.fogDepth
        customFogDepth = properties.customFogDepth
        fogColor = properties.fogColor
        customFogColor = properties.customFogColor
        ambientStrength = properties.ambientStrength
        customAmbientStrength = properties.customAmbientStrength
        ambientColor = properties.ambientColor
        customAmbientColor = properties.customAmbientColor
        directionalStrength = properties.directionalStrength
        customDirectionalStrength = properties.customDirectionalStrength
        directionalColor = properties.directionalColor
        customDirectionalColor = properties.customDirectionalColor
        underglowColor = properties.underglowColor
        underglowStrength = properties.underglowStrength
        lightningEnabled = properties.lightningEnabled
        groundFogStart = properties.groundFogStart
        groundFogEnd = properties.groundFogEnd
        groundFogOpacity = properties.groundFogOpacity
    }
}