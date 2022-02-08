/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package meteor.plugins.bank


class ContainerPrices(val gePrice: Long, val highAlchPrice: Long) {

    override fun equals(o: Any?): Boolean {
        if (o === this) return true
        if (o !is ContainerPrices) return false
        val other = o
        if (gePrice != other.gePrice) return false
        return if (highAlchPrice != other.highAlchPrice) false else true
    }

    override fun hashCode(): Int {
        val PRIME = 59
        var result = 1
        val `$gePrice` = gePrice
        result = result * PRIME + (`$gePrice` ushr 32 xor `$gePrice`).toInt()
        val `$highAlchPrice` = highAlchPrice
        result = result * PRIME + (`$highAlchPrice` ushr 32 xor `$highAlchPrice`).toInt()
        return result
    }

    override fun toString(): String {
        return "ContainerPrices(gePrice=$gePrice, highAlchPrice=$highAlchPrice)"
    }
}
