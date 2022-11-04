/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package meteor.plugins.cooking

import meteor.plugins.Plugin
import meteor.ui.overlay.infobox.InfoBox
import java.awt.Color
import java.awt.image.BufferedImage
import java.time.Duration
import java.time.Instant

internal class FermentTimer(image: BufferedImage?, plugin: Plugin?) : InfoBox(image, plugin!!) {
    private var fermentTime: Instant? = null

    init {
        reset()
    }

    override val text: String
        get() {
            val seconds = timeUntilFerment()
            return Integer.toString(seconds)
        }
    override val textColor: Color
        get() {
            val seconds = timeUntilFerment()
            return if (seconds <= 3) Color.RED else Color.WHITE
        }

    override fun cull(): Boolean {
        val seconds = timeUntilFerment()
        return seconds <= 0
    }

    fun reset() {
        fermentTime = Instant.now().plus(FERMENT_TIME)
    }

    private fun timeUntilFerment(): Int {
        return Duration.between(Instant.now(), fermentTime).seconds.toInt()
    }

    companion object {
        private val FERMENT_TIME = Duration.ofMillis(13800)
    }
}