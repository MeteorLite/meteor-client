/*
 * Copyright (c) 2018, Psikoi <https://github.com/psikoi>
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
package meteor.util

import net.runelite.api.Skill
import java.awt.Color

enum class SkillColor(red: Int, green: Int, blue: Int) {
    ATTACK(155, 32, 7), DEFENCE(98, 119, 190), STRENGTH(4, 149, 90), HITPOINTS(131, 126, 126), RANGED(
        109,
        144,
        23
    ),
    PRAYER(159, 147, 35), MAGIC(50, 80, 193), COOKING(112, 35, 134), WOODCUT(52, 140, 37), FLETCHING(
        3,
        141,
        125
    ),
    FISHING(106, 132, 164), FIREMAKING(189, 120, 25), CRAFTING(151, 110, 77), SMITHING(108, 107, 82), MINING(
        93,
        143,
        167
    ),
    HERBLAW(7, 133, 9), AGILITY(58, 60, 137), THIEVING(108, 52, 87);

    val color: Color

    companion object {
        /**
         * Finds the corresponding SkillColor for a given Skill.
         */
        fun find(skill: Skill): SkillColor {
            return values()[skill.ordinal]
        }
    }

    init {
        color = Color(red, green, blue)
    }
}