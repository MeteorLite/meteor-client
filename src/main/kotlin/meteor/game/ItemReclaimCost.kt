/*
 * Copyright (c) 2018, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package meteor.game

import com.google.common.collect.ImmutableMap
import net.runelite.api.ItemID

/**
 * Some non tradeable items are kept on death inside low level wilderness (1-20) but are turned into
 * a broken variant.
 *
 *
 * The non-broken variant will be shown inside the interface.
 */
enum class ItemReclaimCost(
    val itemID: Int,
    val value: Int
) {
    // Capes
    FIRE_CAPE(ItemID.FIRE_CAPE, 50000), FIRE_MAX_CAPE(ItemID.FIRE_MAX_CAPE, 99000), INFERNAL_CAPE(
        ItemID.INFERNAL_CAPE,
        50000
    ),
    INFERNAL_MAX_CAPE(ItemID.INFERNAL_MAX_CAPE, 99000), AVAS_ASSEMBLER(
        ItemID.AVAS_ASSEMBLER,
        75000
    ),
    ASSEMBLER_MAX_CAPE(ItemID.ASSEMBLER_MAX_CAPE, 99000), IMBUED_GUTHIX_CAPE(
        ItemID.IMBUED_GUTHIX_CAPE,
        75000
    ),
    IMBUED_GUTHIX_MAX_CAPE(ItemID.GUTHIX_MAX_CAPE, 99000), IMBUED_SARADOMIN_CAPE(
        ItemID.IMBUED_SARADOMIN_CAPE,
        75000
    ),
    IMBUED_SARADOMIN_MAX_CAPE(ItemID.SARADOMIN_MAX_CAPE, 99000), IMBUED_ZAMORAK_CAPE(
        ItemID.IMBUED_ZAMORAK_CAPE,
        75000
    ),
    IMBUED_ZAMORAK_MAX_CAPE(ItemID.ZAMORAK_MAX_CAPE, 99000),  // Defenders
    BRONZE_DEFENDER(ItemID.BRONZE_DEFENDER, 1000), IRON_DEFENDER(
        ItemID.IRON_DEFENDER,
        2000
    ),
    STEEL_DEFENDER(ItemID.STEEL_DEFENDER, 2500), BLACK_DEFENDER(
        ItemID.BLACK_DEFENDER,
        5000
    ),
    MITHRIL_DEFENDER(ItemID.MITHRIL_DEFENDER, 15000), ADAMANT_DEFENDER(ItemID.ADAMANT_DEFENDER, 25000), RUNE_DEFENDER(
        ItemID.RUNE_DEFENDER,
        35000
    ),
    DRAGON_DEFENDER(ItemID.DRAGON_DEFENDER, 40000), AVERNIC_DEFENDER(ItemID.AVERNIC_DEFENDER, 1000000),  // Void
    VOID_MAGE_HELM(ItemID.VOID_MAGE_HELM, 40000), VOID_RANGER_HELM(ItemID.VOID_RANGER_HELM, 40000), VOID_MELEE_HELM(
        ItemID.VOID_MELEE_HELM,
        40000
    ),
    VOID_KNIGHT_TOP(ItemID.VOID_KNIGHT_TOP, 45000), VOID_KNIGHT_ROBE(
        ItemID.VOID_KNIGHT_ROBE,
        45000
    ),
    VOID_KNIGHT_GLOVES(ItemID.VOID_KNIGHT_GLOVES, 30000), ELITE_VOID_TOP(ItemID.ELITE_VOID_TOP, 50000), ELITE_VOID_ROBE(
        ItemID.ELITE_VOID_ROBE,
        50000
    ),  // Barb Assault
    FIGHTER_HAT(ItemID.FIGHTER_HAT, 45000), RANGER_HAT(ItemID.RANGER_HAT, 45000), HEALER_HAT(
        ItemID.HEALER_HAT,
        45000
    ),
    FIGHTER_TORSO(ItemID.FIGHTER_TORSO, 50000), PENANCE_SKIRT(ItemID.PENANCE_SKIRT, 20000),  // Castle Wars
    SARADOMIN_HALO(ItemID.SARADOMIN_HALO, 25000), ZAMORAK_HALO(
        ItemID.ZAMORAK_HALO,
        25000
    ),
    GUTHIX_HALO(ItemID.GUTHIX_HALO, 25000), DECORATIVE_MAGIC_HAT(
        ItemID.DECORATIVE_ARMOUR_11898,
        5000
    ),
    DECORATIVE_MAGIC_ROBE_TOP(
        ItemID.DECORATIVE_ARMOUR_11896,
        5000
    ),
    DECORATIVE_MAGIC_ROBE_LEGS(
        ItemID.DECORATIVE_ARMOUR_11897,
        5000
    ),
    DECORATIVE_RANGE_TOP(ItemID.DECORATIVE_ARMOUR_11899, 5000), DECORATIVE_RANGE_BOTTOM(
        ItemID.DECORATIVE_ARMOUR_11900,
        5000
    ),
    DECORATIVE_RANGE_QUIVER(ItemID.DECORATIVE_ARMOUR_11901, 5000), GOLD_DECORATIVE_HELM(
        ItemID.DECORATIVE_HELM_4511,
        5000
    ),
    GOLD_DECORATIVE_BODY(ItemID.DECORATIVE_ARMOUR_4509, 5000), GOLD_DECORATIVE_LEGS(
        ItemID.DECORATIVE_ARMOUR_4510,
        5000
    ),
    GOLD_DECORATIVE_SKIRT(ItemID.DECORATIVE_ARMOUR_11895, 5000), GOLD_DECORATIVE_SHIELD(
        ItemID.DECORATIVE_SHIELD_4512,
        5000
    ),
    GOLD_DECORATIVE_SWORD(ItemID.DECORATIVE_SWORD_4508, 5000),  // Granite Maul
    GRANITE_MAUL(ItemID.GRANITE_MAUL_24225, 375000), GRANITE_MAUL_OR(ItemID.GRANITE_MAUL_24227, 375000);

    companion object {
        private var idMap: ImmutableMap<Int, ItemReclaimCost>? = null

        init {
            val builder = ImmutableMap.builder<Int, ItemReclaimCost>()
            for (items in values()) {
                builder.put(items.itemID, items)
            }
            idMap = builder.build()
        }

        fun of(itemId: Int): ItemReclaimCost? {
            return idMap!![itemId]
        }

        fun breaksOnDeath(itemId: Int): Boolean {
            return idMap!!.containsKey(itemId)
        }
    }
}