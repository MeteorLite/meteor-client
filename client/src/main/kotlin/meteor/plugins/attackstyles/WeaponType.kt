/*
 * Copyright (c) 2017, honeyhoney <https://github.com/honeyhoney>
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
package meteor.plugins.attackstyles

import com.google.common.collect.ImmutableMap
import lombok.Getter
import meteor.rs.ClientThread.invoke

enum class WeaponType(vararg attackStyles: AttackStyle?) {
    TYPE_0(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, null, AttackStyle.DEFENSIVE), TYPE_1(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.AGGRESSIVE, AttackStyle.DEFENSIVE), TYPE_2(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, null, AttackStyle.DEFENSIVE), TYPE_3(AttackStyle.RANGING, AttackStyle.RANGING, null, AttackStyle.LONGRANGE), TYPE_4(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.CONTROLLED, AttackStyle.DEFENSIVE), TYPE_5(AttackStyle.RANGING, AttackStyle.RANGING, null, AttackStyle.LONGRANGE), TYPE_6(AttackStyle.AGGRESSIVE, AttackStyle.RANGING, AttackStyle.CASTING, null), TYPE_7(AttackStyle.RANGING, AttackStyle.RANGING, null, AttackStyle.LONGRANGE), TYPE_8(AttackStyle.OTHER, AttackStyle.AGGRESSIVE, null, null), TYPE_9(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.CONTROLLED, AttackStyle.DEFENSIVE), TYPE_10(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.AGGRESSIVE, AttackStyle.DEFENSIVE), TYPE_11(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.AGGRESSIVE, AttackStyle.DEFENSIVE), TYPE_12(AttackStyle.CONTROLLED, AttackStyle.AGGRESSIVE, null, AttackStyle.DEFENSIVE), TYPE_13(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, null, AttackStyle.DEFENSIVE), TYPE_14(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.AGGRESSIVE, AttackStyle.DEFENSIVE), TYPE_15(AttackStyle.CONTROLLED, AttackStyle.CONTROLLED, AttackStyle.CONTROLLED, AttackStyle.DEFENSIVE), TYPE_16(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.CONTROLLED, AttackStyle.DEFENSIVE), TYPE_17(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.AGGRESSIVE, AttackStyle.DEFENSIVE), TYPE_18(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, null, AttackStyle.DEFENSIVE, AttackStyle.CASTING, AttackStyle.DEFENSIVE_CASTING), TYPE_19(AttackStyle.RANGING, AttackStyle.RANGING, null, AttackStyle.LONGRANGE), TYPE_20(AttackStyle.ACCURATE, AttackStyle.CONTROLLED, null, AttackStyle.DEFENSIVE), TYPE_21(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, null, AttackStyle.DEFENSIVE, AttackStyle.CASTING, AttackStyle.DEFENSIVE_CASTING), TYPE_22(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.AGGRESSIVE, AttackStyle.DEFENSIVE), TYPE_23(AttackStyle.CASTING, AttackStyle.CASTING, null, AttackStyle.DEFENSIVE_CASTING), TYPE_24(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.CONTROLLED, AttackStyle.DEFENSIVE), TYPE_25(AttackStyle.CONTROLLED, AttackStyle.AGGRESSIVE, null, AttackStyle.DEFENSIVE), TYPE_26(AttackStyle.AGGRESSIVE, AttackStyle.AGGRESSIVE, null, AttackStyle.AGGRESSIVE), TYPE_27(AttackStyle.ACCURATE, null, null, AttackStyle.OTHER), TYPE_28(AttackStyle.ACCURATE, AttackStyle.ACCURATE, AttackStyle.LONGRANGE), TYPE_29(AttackStyle.ACCURATE, AttackStyle.AGGRESSIVE, AttackStyle.AGGRESSIVE, AttackStyle.DEFENSIVE);

    @Getter
    val attackStyles: Array<AttackStyle>

    init {
        this.attackStyles = attackStyles as Array<AttackStyle>
    }

    companion object {
        private var weaponTypes: Map<Int, WeaponType>? = null

        init {
            val builder = ImmutableMap.Builder<Int, WeaponType>()
            for (weaponType in values()) {
                builder.put(weaponType.ordinal, weaponType)
            }
            weaponTypes = builder.build()
        }

        fun getWeaponType(id: Int): WeaponType? {
            return weaponTypes!![id]
        }
    }
}