/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2020, Anthony Alves
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
package meteor.plugins.gauntletextended.resource

import net.runelite.api.ItemID
import lombok.AccessLevel
import java.util.Collections
import java.util.regex.Pattern

internal enum class Resource(
    private val res: String,
    val itemId: Int,
    pattern: String?,
    private val corrupted: Boolean
) {
    TELEPORT_CRYSTAL(
        "Teleport crystal",
        ItemID.TELEPORT_CRYSTAL,
        null,
        false
    ),
    CORRUPTED_TELEPORT_CRYSTAL(
        "Corrupted teleport crystal",
        ItemID.CORRUPTED_TELEPORT_CRYSTAL,
        null,
        true
    ),
    WEAPON_FRAME("Weapon frame", ItemID.WEAPON_FRAME_23871, null, false), CORRUPTED_WEAPON_FRAME(
        "Weapon frame",
        ItemID.WEAPON_FRAME,
        null,
        true
    ),
    CRYSTALLINE_BOWSTRING(
        "Crystalline bowstring",
        ItemID.CRYSTALLINE_BOWSTRING,
        null,
        false
    ),
    CORRUPTED_BOWSTRING("Corrupted bowstring", ItemID.CORRUPTED_BOWSTRING, null, true), CRYSTAL_SPIKE(
        "Crystal spike",
        ItemID.CRYSTAL_SPIKE,
        null,
        false
    ),
    CORRUPTED_SPIKE("Corrupted spike", ItemID.CORRUPTED_SPIKE, null, true), CRYSTAL_ORB(
        "Crystal orb",
        ItemID.CRYSTAL_ORB,
        null,
        false
    ),
    CORRUPTED_ORB("Corrupted orb", ItemID.CORRUPTED_ORB, null, true), RAW_PADDLEFISH(
        "Raw paddlefish",
        ItemID.RAW_PADDLEFISH,
        "You manage to catch a fish\\.",
        false
    ),
    CRYSTAL_SHARDS(
        "Crystal shards",
        ItemID.CRYSTAL_SHARDS,
        "You find (\\d+) crystal shards\\.",
        false
    ),
    CORRUPTED_SHARDS(
        "Corrupted shards",
        ItemID.CORRUPTED_SHARDS,
        "You find (\\d+) corrupted shards\\.",
        true
    ),
    CRYSTAL_ORE(
        "Crystal ore",
        ItemID.CRYSTAL_ORE,
        "You manage to mine some ore\\.",
        false
    ),
    CORRUPTED_ORE(
        "Corrupted ore",
        ItemID.CORRUPTED_ORE,
        "You manage to mine some ore\\.",
        true
    ),
    PHREN_BARK("Phren bark", ItemID.PHREN_BARK_23878, "You get some bark\\.", false), CORRUPTED_PHREN_BARK(
        "Phren bark",
        ItemID.PHREN_BARK,
        "You get some bark\\.",
        true
    ),
    LINUM_TIRINUM(
        "Linum tirinum",
        ItemID.LINUM_TIRINUM_23876,
        "You pick some fibre from the plant\\.",
        false
    ),
    CORRUPTED_LINUM_TIRINUM(
        "Linum tirinum",
        ItemID.LINUM_TIRINUM,
        "You pick some fibre from the plant\\.",
        true
    ),
    GRYM_LEAF(
        "Grym leaf",
        ItemID.GRYM_LEAF_23875,
        "You pick a herb from the roots\\.",
        false
    ),
    CORRUPTED_GRYM_LEAF("Grym leaf", ItemID.GRYM_LEAF, "You pick a herb from the roots\\.", true);

    private val pattern: Pattern?

    init {
        this.pattern = if (pattern != null) Pattern.compile(pattern) else null
    }

    companion object {
        fun fromName(name: String, corrupted: Boolean): Resource? {
            for (resource in values()) {
                if (resource.res == name && (corrupted == resource.corrupted || resource == RAW_PADDLEFISH)) {
                    return resource
                }
            }
            return null
        }

        fun fromPattern(pattern: String?, corrupted: Boolean): Map<Resource, Int>? {
            for (resource in values()) {
                if (resource.pattern == null ||
                    corrupted != resource.corrupted && resource != RAW_PADDLEFISH
                ) {
                    continue
                }
                val matcher = resource.pattern.matcher(pattern)
                if (!matcher.matches()) {
                    continue
                }
                val itemCount = if (matcher.groupCount() == 1) matcher.group(1).toInt() else 1
                return Collections.singletonMap(resource, itemCount)
            }
            return null
        }
    }
}