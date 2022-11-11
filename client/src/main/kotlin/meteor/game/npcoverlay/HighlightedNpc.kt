/*
 * Copyright (c) 2021, Adam <Adam@sigterm.info>
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
package meteor.game.npcoverlay

import net.runelite.api.NPC
import java.awt.Color
import java.util.function.Predicate

class HighlightedNpc {
    var npc: NPC? = null
    var highlightColor: Color? = null

    var fillColor = Color(0, 0, 0, 50)
    var hull = false
    var tile = false
    var trueTile = false
    var swTile = false
    var swTrueTile = false
    var outline = false
    var name = false
    var nameOnMinimap = false

    var borderWidth = 2.0f
    var outlineFeather = 0
    var render: Predicate<NPC>? = null

    fun npc(n: NPC) : HighlightedNpc {
        npc = n
        return this
    }

    fun tile(b: Boolean) : HighlightedNpc {
        tile = b
        return this
    }

    fun fillColor(c: Color) : HighlightedNpc {
        fillColor = c
        return this
    }

    fun hull(b: Boolean) : HighlightedNpc {
        hull = b
        return this
    }

    fun trueTile(b: Boolean) : HighlightedNpc {
        hull = b
        return this
    }

    fun swTile(b: Boolean) : HighlightedNpc {
        hull = b
        return this
    }

    fun name(b: Boolean) : HighlightedNpc {
        name = b
        return this
    }

    fun nameOnMinimap(b: Boolean) : HighlightedNpc {
        nameOnMinimap = b
        return this
    }

    fun outlineFeather(i: Int) : HighlightedNpc {
        outlineFeather = i
        return this
    }

    fun borderWidth(f: Float) : HighlightedNpc {
        borderWidth = f
        return this
    }

    fun swTrueTile(b: Boolean) : HighlightedNpc {
        hull = b
        return this
    }

    fun outline(b: Boolean) : HighlightedNpc {
        hull = b
        return this
    }

    fun highlightColor(c: Color) : HighlightedNpc {
        highlightColor = c
        return this
    }

    fun render(r: Predicate<NPC>?) : HighlightedNpc {
        render = r
        return this
    }

    companion object {
        fun builder() : HighlightedNpc {
            return HighlightedNpc()
        }
    }
}