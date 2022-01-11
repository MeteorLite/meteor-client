/*
 * Copyright (c) 2019, MrGroggle
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.agility

import net.runelite.api.Tile

class Obstacle(val tile: Tile, val shortcut: AgilityShortcut?) {

    override fun equals(o: Any?): Boolean {
        if (o === this) return true
        if (o !is Obstacle) return false
        val thisTile: Any = tile
        val otherTile: Any = o.tile
        if (thisTile != otherTile) return false
        val thisShortcut = shortcut
        val otherShortcut = o.shortcut
        return !if (thisShortcut == null) otherShortcut != null else thisShortcut != otherShortcut
    }

    override fun hashCode(): Int {
        val prime = 59
        var result = 1
        val thisTile: Any = tile
        result = result * prime + thisTile.hashCode()
        val thisShortcut: Any? = shortcut
        result = result * prime + (thisShortcut?.hashCode() ?: 43)
        return result
    }

    override fun toString(): String {
        return "Obstacle(tile=$tile, shortcut=$shortcut)"
    }
}