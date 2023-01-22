/*
 * Copyright (c) 2018, Magic fTail
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

internal enum class MinigameLocation(val tooltip: String, val location: WorldPoint) {
    BARBARIAN_ASSAULT("Barbarian Assault", WorldPoint(2531, 3569, 0)), BURGH_DE_ROTT_RAMBLE(
        "Burgh de Rott Ramble",
        WorldPoint(3434, 3487, 0)
    ),
    CASTLE_WARS("Castle Wars", WorldPoint(2439, 3092, 0)), CASTLE_WARS_PORTAL(
        "Castle Wars Portal",
        WorldPoint(3140, 3626, 0)
    ),
    DUEL_ARENA("Duel Arena", WorldPoint(3313, 3238, 0)), MAGE_ARENA(
        "Mage Arena",
        WorldPoint(3095, 3957, 0)
    ),
    NIGHTMARE_ZONE("Nightmare Zone", WorldPoint(2606, 3115, 0)), PEST_CONTROL_NOVICE(
        "Pest Control Novice",
        WorldPoint(2660, 2637, 0)
    ),
    PEST_CONTROL_INTERMEDIATE(
        "Pest Control Intermediate",
        WorldPoint(2638, 2641, 0)
    ),
    PEST_CONTROL_VETERAN("Pest Control Veteran", WorldPoint(2632, 2648, 0)), TEMPLE_TREKKING(
        "Temple Trekking",
        WorldPoint(3479, 3240, 0)
    ),
    TZHAAR_FIGHT_CAVE("TzHaar Fight Cave", WorldPoint(2437, 5168, 0)), TZHAAR_FIGHT_PIT(
        "TzHaar Fight Pit",
        WorldPoint(2398, 5177, 0)
    ),
    LAST_MAN_STANDING("Last Man Standing", WorldPoint(3138, 3635, 0)), INFERNO(
        "Inferno",
        WorldPoint(2495, 5118, 0)
    ),
    BRIMHAVEN_AGILITY_ARENA("Brimhaven Agility Arena", WorldPoint(2809, 3191, 0)), FISHING_TRAWLER(
        "Fishing Trawler",
        WorldPoint(2667, 3163, 0)
    ),
    GNOME_BALL("Gnome Ball", WorldPoint(2381, 3488, 0)), GNOME_RESTAURANT(
        "Gnome Restaurant",
        WorldPoint(2436, 3502, 0)
    ),
    IMPETUOUS_IMPULSES("Impetuous Impulses", WorldPoint(2425, 4445, 0)), MAGE_TRAINING_ARENA(
        "Mage Training Arena",
        WorldPoint(3362, 3318, 0)
    ),
    PYRAMID_PLUNDER("Pyramid Plunder", WorldPoint(3288, 2787, 0)), RANGING_GUILD(
        "Ranging Guild",
        WorldPoint(2671, 3419, 0)
    ),
    ROGUES_DEN("Rogues' Den", WorldPoint(2905, 3537, 0)), SHADES_OF_MORTTON(
        "Shades of Mort'ton",
        WorldPoint(3505, 3315, 0)
    ),
    SORCERESSS_GARDEN("Sorceress's Garden", WorldPoint(3285, 3180, 0)), TROUBLE_BREWING(
        "Trouble Brewing",
        WorldPoint(3811, 3021, 0)
    ),
    VOLCANIC_MINE("Volcanic Mine", WorldPoint(3812, 3810, 0)), TAI_BWO_WANNAI_CLEANUP(
        "Tai Bwo Wannai Cleanup",
        WorldPoint(2795, 3066, 0)
    ),
    BURTHORPE_GAMES_ROOM("Burthorpe Games Room", WorldPoint(2900, 3565, 0)), RAT_PITS_PORT_SARIM(
        "Rat Pits",
        WorldPoint(3015, 3232, 0)
    ),
    RAT_PITS_VARROCK("Rat Pits", WorldPoint(3266, 3400, 0)), RAT_PITS_ARDOUGNE(
        "Rat Pits",
        WorldPoint(2561, 3318, 0)
    ),
    RAT_PITS_KELDAGRIM("Rat Pits", WorldPoint(2913, 10188, 0)), TEARS_OF_GUTHIX(
        "Tears of Guthix",
        WorldPoint(3257, 9517, 0)
    ),
    CLAN_WARS("Clan Wars", WorldPoint(3133, 3621, 0)), ANIMATION_ROOM(
        "Animation Room",
        WorldPoint(2853, 3537, 0)
    ),
    DUMMY_ROOM("Dummy Room", WorldPoint(2857, 3551, 0)), CATAPULT_ROOM(
        "Catapult Room",
        WorldPoint(2842, 3545, 0)
    ),
    SHOT_PUT_ROOM("Shot Put Room", WorldPoint(2863, 3550, 0)), HALLOWED_SEPULCHRE(
        "Hallowed Sepulchre",
        WorldPoint(3653, 3386, 1)
    ),
    THE_GAUNTLET("The Gauntlet", WorldPoint(3223, 12505, 1)), MAHOGANY_HOMES_ARDOUGNE(
        "Mahogany Homes",
        WorldPoint(2634, 3295, 0)
    ),
    MAHOGANY_HOMES_FALADOR("Mahogany Homes", WorldPoint(2989, 3363, 0)), MAHOGANY_HOMES_HOSIDIUS(
        "Mahogany Homes",
        WorldPoint(1780, 3623, 0)
    ),
    MAHOGANY_HOMES_VARROCK("Mahogany Homes", WorldPoint(3240, 3471, 0)), SOUL_WARS(
        "Soul Wars",
        WorldPoint(2209, 2855, 0)
    ),
    SOUL_WARS_EDGEVILLE_PORTAL(
        "Soul Wars",
        WorldPoint(3082, 3474, 0)
    ),
    TZHAAR_KET_RAKS_CHALLENGES("TzHaar-Ket-Rak's Challenges", WorldPoint(2544, 5111, 0));
}