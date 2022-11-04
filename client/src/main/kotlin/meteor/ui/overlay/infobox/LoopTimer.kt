/*
 * Copyright (c) 2019, Tomas Slusny <slusnucky@gmail.com>
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

class LoopTimer @JvmOverloads constructor(period: Long, unit: ChronoUnit?, image: BufferedImage?, plugin: Plugin?, reverse: Boolean = false) : InfoBox(image, plugin!!) {
    private val startTime: Instant
    private val duration: Duration
    private val reverse: Boolean

    init {
        Preconditions.checkArgument(period > 0, "negative period!")
        startTime = Instant.now()
        duration = Duration.of(period, unit)
        this.reverse = reverse
    }

    override val text: String
        get() {
            val progress = progress
            val seconds = (progress.toMillis() / 1000L).toInt()
            val minutes = seconds % 3600 / 60
            val secs = seconds % 60
            return String.format("%d:%02d", minutes, secs)
        }

    // check if timer has 10% of time left
    override val textColor: Color
        get() {
            val progress = progress

            // check if timer has 10% of time left
            return if (progress.seconds < duration.seconds * .10) {
                Color.RED.brighter()
            } else Color.WHITE
        }
    private val progress: Duration
        private get() {
            val passed = Duration.between(startTime, Instant.now())
            val passedMillis = passed.toMillis()
            val durationMillis = duration.toMillis()
            val progress = passedMillis % durationMillis
            return Duration.ofMillis(if (reverse) durationMillis - progress else progress)
        }
}