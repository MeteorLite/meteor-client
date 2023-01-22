/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package meteor.plugins.animsmoothing

import eventbus.events.ConfigChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor

@PluginDescriptor(name = "Animation Smoothing", description = "Show smoother player, NPC, and object animations", tags = ["npcs", "objects", "players"], enabledByDefault = false)
class AnimationSmoothingPlugin : Plugin() {
    private val config = configuration<AnimationSmoothingConfig>()
    override fun onStart() {
        update()
    }

    override fun onStop() {
        client.isInterpolatePlayerAnimations = false
        client.isInterpolateNpcAnimations = false
        client.isInterpolateObjectAnimations = false
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == CONFIG_GROUP) {
            update()
        }
    }

    private fun update() {
        client.isInterpolatePlayerAnimations = config.smoothPlayerAnimations()
        client.isInterpolateNpcAnimations = config.smoothNpcAnimations()
        client.isInterpolateObjectAnimations = config.smoothObjectAnimations()
    }

    companion object {
        const val CONFIG_GROUP = "animationSmoothing"
    }
}