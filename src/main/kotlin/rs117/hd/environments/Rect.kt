/*
 * Copyright (c) 2021, 117 <https://twitter.com/117scape>
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
package rs117.hd.environments

class Rect {
    val minX: Int
    val minY: Int
    val maxX: Int
    val maxY: Int
    private val plane: Int

    internal constructor(pointAX: Int, pointAY: Int, pointBX: Int, pointBY: Int) {
        minX = Math.min(pointAX, pointBX)
        minY = Math.min(pointAY, pointBY)
        maxX = Math.max(pointAX, pointBX)
        maxY = Math.max(pointAY, pointBY)
        plane = -1
    }

    internal constructor(pointAX: Int, pointAY: Int, pointBX: Int, pointBY: Int, plane: Int) {
        minX = Math.min(pointAX, pointBX)
        minY = Math.min(pointAY, pointBY)
        maxX = Math.max(pointAX, pointBX)
        maxY = Math.max(pointAY, pointBY)
        this.plane = plane
    }

    fun containsPoint(pointX: Int, pointY: Int, pointZ: Int): Boolean {
        return pointX <= maxX && pointX >= minX && pointY <= maxY && pointY >= minY && (plane == -1 || plane == pointZ)
    }
}