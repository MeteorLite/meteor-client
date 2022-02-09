/*
 * Copyright (c) 2018, Mantautas Jurksa <https://github.com/Juzzed>
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
package meteor.plugins.woodcutting

import com.google.common.collect.ImmutableMap
import net.runelite.api.AnimationID
import net.runelite.api.ItemID
import net.runelite.api.Player


enum class Axe(val animId: Int, val itemId: Int) {
    BRONZE(AnimationID.WOODCUTTING_BRONZE, ItemID.BRONZE_AXE), IRON(
        AnimationID.WOODCUTTING_IRON,
        ItemID.IRON_AXE
    ),
    STEEL(
        AnimationID.WOODCUTTING_STEEL, ItemID.STEEL_AXE
    ),
    BLACK(AnimationID.WOODCUTTING_BLACK, ItemID.BLACK_AXE), MITHRIL(
        AnimationID.WOODCUTTING_MITHRIL, ItemID.MITHRIL_AXE
    ),
    ADAMANT(AnimationID.WOODCUTTING_ADAMANT, ItemID.ADAMANT_AXE), RUNE(
        AnimationID.WOODCUTTING_RUNE, ItemID.RUNE_AXE
    ),
    GILDED(AnimationID.WOODCUTTING_GILDED, ItemID.GILDED_AXE), DRAGON(
        AnimationID.WOODCUTTING_DRAGON, ItemID.DRAGON_AXE
    ),
    DRAGON_OR(AnimationID.WOODCUTTING_DRAGON_OR, ItemID.DRAGON_AXE_OR), INFERNAL(
        AnimationID.WOODCUTTING_INFERNAL, ItemID.INFERNAL_AXE
    ),
    THIRDAGE(AnimationID.WOODCUTTING_3A_AXE, ItemID._3RD_AGE_AXE), CRYSTAL(
        AnimationID.WOODCUTTING_CRYSTAL, ItemID.CRYSTAL_AXE
    ),
    TRAILBLAZER(AnimationID.WOODCUTTING_TRAILBLAZER, ItemID.INFERNAL_AXE_OR);

    fun matchesChoppingAnimation(player: Player?): Boolean {
        return player != null && animId == player.animation
    }

    companion object {
        private var AXE_ANIM_IDS: Map<Int, Axe>

        init {
            val builder = ImmutableMap.Builder<Int, Axe>()
            for (axe in values()) {
                builder.put(
                    axe.animId,
                    axe
                )
            }
            AXE_ANIM_IDS = builder.build()
        }

        fun findAxeByAnimId(animId: Int): Axe? {
            return AXE_ANIM_IDS[animId]
        }
    }
}