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

import eventbus.events.ConfigChanged
import eventbus.events.FocusChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.DrawManager

/**
 * FPS Control has two primary areas, this plugin class just keeps those areas up to date and handles setup / teardown.
 *
 *
 * Overlay paints the current FPS, the color depends on whether or not FPS is being enforced.
 * The overlay is lightweight and is merely and indicator.
 *
 *
 * Draw Listener, sleeps a calculated amount after each canvas paint operation.
 * This is the heart of the plugin, the amount of sleep taken is regularly adjusted to account varying
 * game and system load, it usually finds the sweet spot in about two seconds.
 */
@PluginDescriptor(
    name = "FPS Control",
    description = "Show current FPS and/or set an FPS limit",
    tags = ["frames", "framerate", "limit", "overlay"],
    enabledByDefault = false
)
class FpsPlugin : Plugin() {
    private val config = configuration<FpsConfig>()

    private val overlay = FpsOverlay(this, config)
    private val drawListener = FpsDrawListener(config)
    private val drawManager = DrawManager
    override fun onConfigChanged(event: ConfigChanged) {
        if (event.group == CONFIG_GROUP_KEY) {
            drawListener.reloadConfig()
        }
    }

    override fun onFocusChanged(event: FocusChanged) {
        drawListener.onFocusChanged(event)
        overlay.onFocusChanged(event)
    }

    override fun onStart() {
        drawListener.subscribe()
        overlayManager.add(overlay)
        drawManager.registerEveryFrameListener(drawListener)
        drawListener.reloadConfig()
    }

    override fun onStop() {
        drawListener.unsubscribe()
        overlayManager.remove(overlay)
        drawManager.unregisterEveryFrameListener(drawListener)
    }

    companion object {
        const val CONFIG_GROUP_KEY = "fpscontrol"
    }
}