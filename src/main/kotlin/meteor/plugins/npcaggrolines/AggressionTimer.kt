/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package meteor.plugins.npcaggrolines

import meteor.plugins.Plugin
import meteor.ui.overlay.infobox.Timer
import java.awt.Color
import java.awt.image.BufferedImage
import java.time.Duration
import java.time.Instant
import java.time.temporal.ChronoUnit

internal class AggressionTimer(duration: Duration, image: BufferedImage, plugin: Plugin, visible: Boolean) :
    Timer(duration.toMillis(), ChronoUnit.MILLIS, image, plugin) {
    var visible: Boolean

    init {
        tooltip = "Time until NPCs become unaggressive"
        this.visible = visible
    }

    //check if timer has 10% of time left
    override val textColor: Color
        get() {
            val timeLeft = Duration.between(Instant.now(), endTime)
            return if (timeLeft.seconds < 60) {
                Color.RED.brighter()
            } else Color.WHITE
        }

    override fun render(): Boolean {
        return visible && super.render()
    }
}