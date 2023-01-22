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
package meteor.ui.overlay.infobox

import com.google.common.base.Preconditions
import meteor.plugins.Plugin
import java.awt.Color
import java.awt.image.BufferedImage
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit

open class Timer(
    period: Long,
    unit: ChronoUnit,
    image: BufferedImage?,
    plugin: Plugin,
    override val textColor: Color? = null
) : InfoBox(image, plugin) {
    private val startTime: Instant
    var endTime: Instant
    private var duration: Duration

    init {
        Preconditions.checkArgument(period > 0, "negative period!")
        startTime = Instant.now()
        duration = Duration.of(period, unit)
        endTime = startTime.plus(duration)
    }

    override val text: String
        get() {
            val timeLeft = Duration.between(Instant.now(), endTime)
            val seconds = (timeLeft.toMillis() / 1000L).toInt()
            val minutes = seconds % 3600 / 60
            val secs = seconds % 60
            return String.format("%d:%02d", minutes, secs)
        }

    override fun render(): Boolean {
        val timeLeft = Duration.between(Instant.now(), endTime)
        return !timeLeft.isNegative
    }

    override fun cull(): Boolean {
        val timeLeft = Duration.between(Instant.now(), endTime)
        return timeLeft.isZero || timeLeft.isNegative
    }

    fun setDuration(duration: Duration) {
        this.duration = duration
        endTime = startTime.plus(duration)
    }
}