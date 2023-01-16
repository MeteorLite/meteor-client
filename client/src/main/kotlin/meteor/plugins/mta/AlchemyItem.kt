/*
 * Copyright (c) 2018, Jasper Ketelaar <Jasper0781@gmail.com>
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
package meteor.plugins.mta

import lombok.Getter
import net.runelite.api.ItemID
import java.util.*

enum class AlchemyItem(@field:Getter val itemName: String, @field:Getter val id: Int) {
    LEATHER_BOOTS("Leather Boots", ItemID.LEATHER_BOOTS_6893), ADAMANT_KITESHIELD(
        "Adamant Kiteshield",
        ItemID.ADAMANT_KITESHIELD_6894
    ),
    ADAMANT_MED_HELM("Helm", ItemID.ADAMANT_MED_HELM_6895), EMERALD(
        "Emerald",
        ItemID.EMERALD_6896
    ),
    RUNE_LONGSWORD("Rune Longsword", ItemID.RUNE_LONGSWORD_6897), EMPTY("", -1), POSSIBLY_EMPTY(
        "",
        ItemID.CAKE_OF_GUIDANCE
    ),
    UNKNOWN("Unknown", ItemID.CAKE_OF_GUIDANCE);

    companion object {
        fun find(item: String): AlchemyItem? {
            for (alchemyItem in values()) {
                if (item.lowercase(Locale.getDefault()).contains(alchemyItem.name.lowercase(Locale.getDefault()))) {
                    return alchemyItem
                }
            }
            return null
        }
    }
}