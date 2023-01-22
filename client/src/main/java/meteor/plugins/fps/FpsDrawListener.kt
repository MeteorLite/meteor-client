/*
 * Copyright (c) 2017, Levi <me@levischuck.com>
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
package meteor.plugins.fps

import eventbus.events.FocusChanged
import meteor.plugins.EventSubscriber

/**
 * FPS Draw Listener runs after the canvas has been painted with the buffered image (unused in this plugin)
 * It specifically is designed only to pause when RS decides to paint the canvas, after the canvas has been painted.
 * The RS client operates at 50 cycles happen per second in the RS Client with higher priority than draws per second.
 * For high powered computers, drawing is limited by client cycles, so 50 is the max FPS observed.
 * After running a game cycle and a draw operation, the RS client burns the rest of the time with a nano timer.
 * For low powered computers, the RS client is often throttled by the hardware or OS and draws at 25-30 fps.
 * The nano timer is not used in this scenario.
 * Instead to catch up the RS client runs several cycles before drawing, thus maintaining 50 cycles / second.
 *
 *
 * Enforcing FPS in the draw code does not impact the client engine's ability to run including its audio,
 * even when forced to 1 FPS with this plugin.
 */
class FpsDrawListener internal constructor(private val config: FpsConfig) : EventSubscriber(), Runnable {
    private var targetDelay: Long = 0

    // Often changing values
    private var isFocused = true

    // Working set
    private var lastMillis: Long = 0
    private val lastDelays = LongArray(SAMPLE_SIZE)
    private var lastDelayIndex = 0
    private var sleepDelay: Long = 0

    init {
        reloadConfig()
    }

    fun reloadConfig() {
        lastMillis = System.currentTimeMillis()
        val fps = if (config.limitFpsUnfocused() && !isFocused) config.maxFpsUnfocused() else config.maxFps()
        targetDelay = (1000 / Math.max(1, fps)).toLong()
        sleepDelay = targetDelay
        for (i in 0 until SAMPLE_SIZE) {
            lastDelays[i] = targetDelay
        }
    }

    override fun onFocusChanged(it: FocusChanged) {
        isFocused = it.focused
        reloadConfig() // load new delay
    }

    override fun run() {
        // We can't trust client.getFPS to get frame-perfect FPS knowledge
        // If we do try to use client.getFPS, we will end up oscillating
        // So we rely on currentTimeMillis which is occasionally cached by the JVM unlike nanotime
        // Its caching will not cause oscillation as it is granular enough for our uses here
        val before = lastMillis
        val now = System.currentTimeMillis()
        lastMillis = now
        lastDelayIndex = (lastDelayIndex + 1) % SAMPLE_SIZE
        lastDelays[lastDelayIndex] = now - before

        // We take a sampling approach because sometimes the game client seems to repaint
        // after only running 1 game cycle, and then runs repaint again after running 30 cycles
        var averageDelay: Long = 0
        for (i in 0 until SAMPLE_SIZE) {
            averageDelay += lastDelays[i]
        }
        averageDelay /= lastDelays.size.toLong()

        // Sleep delay is a moving target due to the nature of how and when the engine
        // decides to run cycles.
        // This will also keep us safe from time spent in plugins conditionally
        // as some plugins and overlays are only appropriate in some game areas
        if (averageDelay > targetDelay) {
            sleepDelay--
        } else if (averageDelay < targetDelay) {
            sleepDelay++
        }
        if (sleepDelay > 0) {
            try {
                Thread.sleep(sleepDelay)
            } catch (e: InterruptedException) {
                // Can happen on shutdown
            }
        }
    }

    companion object {
        private const val SAMPLE_SIZE = 4
    }
}