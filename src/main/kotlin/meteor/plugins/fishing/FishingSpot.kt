/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package meteor.plugins.fishing

import com.google.common.collect.ImmutableMap
import net.runelite.api.ItemID
import net.runelite.api.NpcID

enum class FishingSpot(val spotName: String, val worldMapTooltip: String, val fishSpriteId: Int, private vararg val ids: Int) {
    SHRIMP("Shrimp, Anchovies", "Anchovies", ItemID.RAW_SHRIMPS,
            NpcID.FISHING_SPOT_1514, NpcID.FISHING_SPOT_1517, NpcID.FISHING_SPOT_1518,
            NpcID.FISHING_SPOT_1521, NpcID.FISHING_SPOT_1523, NpcID.FISHING_SPOT_1524,
            NpcID.FISHING_SPOT_1525, NpcID.FISHING_SPOT_1528, NpcID.FISHING_SPOT_1530,
            NpcID.FISHING_SPOT_1544, NpcID.FISHING_SPOT_3913, NpcID.FISHING_SPOT_7155,
            NpcID.FISHING_SPOT_7459, NpcID.FISHING_SPOT_7462, NpcID.FISHING_SPOT_7467,
            NpcID.FISHING_SPOT_7469, NpcID.FISHING_SPOT_7947, NpcID.FISHING_SPOT_10513
    ),
    LOBSTER("Lobster, Swordfish, Tuna", "Lobster", ItemID.RAW_LOBSTER,
            NpcID.FISHING_SPOT_1510, NpcID.FISHING_SPOT_1519, NpcID.FISHING_SPOT_1522,
            NpcID.FISHING_SPOT_3914, NpcID.FISHING_SPOT_5820, NpcID.FISHING_SPOT_7199,
            NpcID.FISHING_SPOT_7460, NpcID.FISHING_SPOT_7465, NpcID.FISHING_SPOT_7470,
            NpcID.FISHING_SPOT_7946, NpcID.FISHING_SPOT_9173, NpcID.FISHING_SPOT_9174,
            NpcID.FISHING_SPOT_10515, NpcID.FISHING_SPOT_10635
    ),
    SHARK("Shark, Bass", "Shark", ItemID.RAW_SHARK,
            NpcID.FISHING_SPOT_1511, NpcID.FISHING_SPOT_1520, NpcID.FISHING_SPOT_3419,
            NpcID.FISHING_SPOT_3915, NpcID.FISHING_SPOT_4476, NpcID.FISHING_SPOT_4477,
            NpcID.FISHING_SPOT_5233, NpcID.FISHING_SPOT_5234, NpcID.FISHING_SPOT_5821,
            NpcID.FISHING_SPOT_7200, NpcID.FISHING_SPOT_7461, NpcID.FISHING_SPOT_7466,
            NpcID.FISHING_SPOT_8525, NpcID.FISHING_SPOT_8526, NpcID.FISHING_SPOT_8527,
            NpcID.FISHING_SPOT_9171, NpcID.FISHING_SPOT_9172, NpcID.FISHING_SPOT_10514
    ),
    MONKFISH("Monkfish", ItemID.RAW_MONKFISH,
            NpcID.FISHING_SPOT_4316
    ),
    SALMON("Salmon, Trout", "Salmon", ItemID.RAW_SALMON,
            NpcID.ROD_FISHING_SPOT, NpcID.ROD_FISHING_SPOT_1506, NpcID.ROD_FISHING_SPOT_1507,
            NpcID.ROD_FISHING_SPOT_1508, NpcID.ROD_FISHING_SPOT_1509, NpcID.ROD_FISHING_SPOT_1513,
            NpcID.ROD_FISHING_SPOT_1515, NpcID.ROD_FISHING_SPOT_1516, NpcID.ROD_FISHING_SPOT_1526,
            NpcID.ROD_FISHING_SPOT_1527, NpcID.ROD_FISHING_SPOT_3417, NpcID.ROD_FISHING_SPOT_3418,
            NpcID.ROD_FISHING_SPOT_7463, NpcID.ROD_FISHING_SPOT_7464, NpcID.ROD_FISHING_SPOT_7468,
            NpcID.ROD_FISHING_SPOT_8524
    ),
    LAVA_EEL("Lava eel", ItemID.LAVA_EEL,
            NpcID.FISHING_SPOT_4928, NpcID.FISHING_SPOT_6784
    ),
    BARB_FISH("Sturgeon, Salmon, Trout", ItemID.LEAPING_STURGEON,
            NpcID.FISHING_SPOT_1542, NpcID.FISHING_SPOT_7323
    ),
    ANGLERFISH("Anglerfish", ItemID.RAW_ANGLERFISH,
            NpcID.ROD_FISHING_SPOT_6825
    ),
    MINNOW("Minnow", ItemID.MINNOW,
            NpcID.FISHING_SPOT_7730, NpcID.FISHING_SPOT_7731, NpcID.FISHING_SPOT_7732, NpcID.FISHING_SPOT_7733
    ),
    HARPOONFISH("Harpoonfish", ItemID.RAW_HARPOONFISH,
            NpcID.FISHING_SPOT_10565, NpcID.FISHING_SPOT_10568, NpcID.FISHING_SPOT_10569
    ),
    INFERNAL_EEL("Infernal Eel", ItemID.INFERNAL_EEL,
            NpcID.ROD_FISHING_SPOT_7676
    ),
    KARAMBWAN("Karambwan", ItemID.RAW_KARAMBWAN,
            NpcID.FISHING_SPOT_4712, NpcID.FISHING_SPOT_4713
    ),
    KARAMBWANJI("Karambwanji, Shrimp", "Karambwanji", ItemID.KARAMBWANJI,
            NpcID.FISHING_SPOT_4710
    ),
    SACRED_EEL("Sacred eel", ItemID.SACRED_EEL,
            NpcID.FISHING_SPOT_6488
    ),
    CAVE_EEL("Cave eel", ItemID.RAW_CAVE_EEL,
            NpcID.FISHING_SPOT_1497, NpcID.FISHING_SPOT_1498, NpcID.FISHING_SPOT_1499
    ),
    SLIMY_EEL("Slimy eel", ItemID.RAW_SLIMY_EEL,
            NpcID.FISHING_SPOT_2653, NpcID.FISHING_SPOT_2654, NpcID.FISHING_SPOT_2655
    ),
    DARK_CRAB("Dark Crab", ItemID.RAW_DARK_CRAB,
            NpcID.FISHING_SPOT_1535, NpcID.FISHING_SPOT_1536
    ),
    COMMON_TENCH("Common tench, Bluegill, Greater siren, Mottled eel", "Greater siren",
            ItemID.COMMON_TENCH,
            NpcID.FISHING_SPOT_8523
    ),
    TUTORIAL_SHRIMP("Shrimp", ItemID.RAW_SHRIMPS,
            NpcID.FISHING_SPOT_3317
    ),
    ETCETERIA_LOBSTER("Lobster", "Lobster (Approval only)", ItemID.RAW_LOBSTER,
            NpcID.FISHING_SPOT_3657
    ),
    QUEST_RUM_DEAL("Sluglings", "Rum deal (Quest)", ItemID.SLUGLINGS,
            NpcID.FISHING_SPOT
    ),
    QUEST_TAI_BWO_WANNAI_TRIO("Karambwan", "Tai Bwo Wannai Trio (Quest)", ItemID.RAW_KARAMBWAN,
            NpcID.FISHING_SPOT_4714
    ),
    QUEST_FISHING_CONTEST("Giant carp", "Fishing Contest (Quest)", ItemID.GIANT_CARP,
            NpcID.FISHING_SPOT_4079, NpcID.FISHING_SPOT_4080, NpcID.FISHING_SPOT_4081, NpcID.FISHING_SPOT_4082
    );

    constructor(spot: String, fishSpriteId: Int, vararg ids: Int) : this(spot, spot, fishSpriteId, *ids)

    companion object {
        private var SPOTS: Map<Int, FishingSpot>? = null

        init {
            val builder = ImmutableMap.Builder<Int, FishingSpot>()
            for (spot in values()) {
                for (spotId in spot.ids) {
                    builder.put(spotId, spot)
                }
            }
            SPOTS = builder.build()
        }

        fun findSpot(id: Int): FishingSpot? {
            return SPOTS!![id]
        }
    }
}