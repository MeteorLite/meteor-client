/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
package meteor.plugins.pestcontrol

import meteor.plugins.pestcontrol.Portal.*

internal enum class Rotation(first: Portal, second: Portal, third: Portal, fourth: Portal) {
    PBYR(PURPLE, BLUE, YELLOW, RED), PYBR(PURPLE, YELLOW, BLUE, RED), BRYP(BLUE, RED, YELLOW, PURPLE), BPRY(
        BLUE,
        PURPLE,
        RED,
        YELLOW
    ),
    YRPB(YELLOW, RED, PURPLE, BLUE), YPRB(YELLOW, PURPLE, RED, BLUE);

    private val portals: Array<Portal>

    init {
        portals = arrayOf(
            first, second, third, fourth
        )
    }

    fun getPortal(index: Int): Portal? {
        return if (index < 0 || index >= portals.size) {
            null
        } else portals[index]
    }
}