/*
 * Copyright (c) 2020, Brooklyn <https://github.com/Broooklyn>
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


internal enum class KourendTaskLocation(val tooltip: String, val location: WorldPoint) {
    ARCEUUS_LIBRARY_SOUTH(
        "Arceuus Task (0%) - Library Assistance",
        WorldPoint(1622, 3801, 0)
    ),
    ARCEUUS_LIBRARY_NORTH(
        "Arceuus Task (0%) - Library Assistance",
        WorldPoint(1638, 3817, 0)
    ),
    ARCEUUS_DENSE_ESSENCE(
        "Arceuus Task (25%) - Dense Essence Mining",
        WorldPoint(1757, 3852, 0)
    ),
    ARCEUUS_REANIMATE_CREATURES(
        "Arceuus Task (60%) - Creature Reanimation",
        WorldPoint(1714, 3883, 0)
    ),
    ARCEUUS_BLOOD_ALTAR(
        "Arceuus Unlock (100%) - Blood Rune Crafting",
        WorldPoint(1716, 3829, 0)
    ),
    ARCEUUS_SOUL_ALTAR(
        "Arceuus Unlock (100%) - Soul Rune Crafting",
        WorldPoint(1814, 3854, 0)
    ),
    HOSIDIUS_PLOUGH_NORTH(
        "Hosidius Task (0%) - Ploughs",
        WorldPoint(1770, 3550, 0)
    ),
    HOSIDIUS_PLOUGH_SOUTH(
        "Hosidius Task (0%) - Ploughs",
        WorldPoint(1769, 3528, 0)
    ),
    HOSIDUIS_FERTILISER(
        "Hosidius Task (5%) - Making Fertilizer",
        WorldPoint(1701, 3527, 0)
    ),
    HOSIDIUS_SPIRIT_TREE(
        "Hosidius Unlock (35%) - Spirit Tree Patch",
        WorldPoint(1695, 3545, 0)
    ),
    HOSIDIUS_MESS("Hosidius Task (45%) - Mess", WorldPoint(1639, 3629, 0)), HOSIDIUS_FARMING_PATCH(
        "Hosidius Unlock (50%) - Disease Protection",
        WorldPoint(1740, 3552, 0)
    ),
    HOSIDIUS_VINERY(
        "Hosidius Task (65%) - Grape Planting",
        WorldPoint(1804, 3564, 0)
    ),
    HOSIDIUS_TITHE_FARM(
        "Hosidius Unlock (100%) - Tithe Farm",
        WorldPoint(1802, 3499, 0)
    ),
    HOSIDIUS_KITCHEN("Hosidius Unlock (100%) - Kitchen", WorldPoint(1678, 3618, 0)), LOVAKENGJ_DYNAMITE(
        "Lovakengj Task (0%) - Making Juniper Charcoal",
        WorldPoint(1718, 3472, 0)
    ),
    LOVAKENGJ_SULFUR("Lovakengj Task (0%) - Mining Volcanic Sulphur", WorldPoint(1437, 3861, 0)), LOVAKENGJ_ARMOURER_T1(
        "Lovakengj Task (30%) - Armourer (Tier 1)",
        WorldPoint(1453, 3750, 0)
    ),
    LOVAKENGJ_ARMOURER_T2("Lovakengj Task (40%) - Armourer (Tier 2)", WorldPoint(1436, 3784, 0)), LOVAKENGJ_ARMOURER_T3(
        "Lovakengj Task (50%) - Armourer (Tier 3)",
        WorldPoint(1430, 3797, 0)
    ),
    LOVAKENGJ_ARMOURER_T4("Lovakengj Task (60%) - Armourer (Tier 4)", WorldPoint(1460, 3763, 0)), LOVAKENGJ_ARMOURER_T5(
        "Lovakengj Task (70%) - Armourer (Tier 5)",
        WorldPoint(1524, 3755, 0)
    ),
    LOVAKENGJ_BLAST_MINE("Lovakengj Unlock (100%) - Blast Mine", WorldPoint(1488, 3865, 0)), PISCARILIUS_CRANE_REPAIR(
        "Piscarilius Task (0%) - Fishing Crane Repair",
        WorldPoint(1820, 3742, 0)
    ),
    PISCARILIUS_FRESH_FISH("Piscarilius Task (15%) - Fish Delivery", WorldPoint(1831, 3716, 0)), PISCARILIUS_SANDWORMS(
        "Piscarilius Task (30%) - Hunting Sandworms",
        WorldPoint(1841, 3789, 0)
    ),
    PISCARILIUS_STEALING_ARTEFACTS(
        "Piscarilius Task (75%) - Stealing Artefacts",
        WorldPoint(1849, 3753, 0)
    ),
    SHAYZIEN_HEALING_SOLDIERS(
        "Shayzien Task (0%) - Healing Wounded Soldiers",
        WorldPoint(1528, 3627, 0)
    ),
    SHAYZIEN_LIZARDMEN_EAST(
        "Shayzien Task (5%) - Killing Lizardmen",
        WorldPoint(1570, 3668, 0)
    ),
    SHAYZIEN_LIZARDMEN_WEST(
        "Shayzien Task (5%) - Killing Lizardmen",
        WorldPoint(1471, 3686, 0)
    ),
    SHAYZIEN_ORGANIZED_CRIME(
        "Shayzien Task (40%) - Organized Crime",
        WorldPoint(1504, 3635, 0)
    ),
    SHAYZIEN_COMBAT_RING("Shayzien Task (60%) - Combat Ring", WorldPoint(1541, 3628, 0)), SHAYZIEN_LIZARDMAN_SHAMANS(
        "Shayzien Unlock (100%) - Lizardman Shamans",
        WorldPoint(1455, 3693, 0)
    );
}