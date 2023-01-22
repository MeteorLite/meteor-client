/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package meteor.plugins.lowdetail

import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.GameState


@PluginDescriptor(
    name = "Low Detail",
    description = "Turn off ground decorations and certain textures, reducing memory usage",
    tags = ["memory", "usage", "ground", "decorations"],
    enabledByDefault = false
)
class LowDetailPlugin : Plugin() {


    private val clientThread = ClientThread
    private val config = configuration<LowDetailConfig>()
    override fun onStart() {
        clientThread.invoke {

            // When the client starts it initializes the texture size based on the memory mode setting.
            // Don't set low memory before the login screen is ready to prevent loading the low detail textures,
            // which breaks the gpu plugin due to it requiring the 128x128px textures
            if (client.gameState.state >= GameState.LOGIN_SCREEN.state) {
                client.changeMemoryMode(config.lowDetail())
            }
        }
    }

    override fun onStop() {
        clientThread.invoke { client.changeMemoryMode(false) }
    }

    override fun onChatMessage(it: ChatMessage) {
        if (it.message == "Welcome to Old School RuneScape."){
            client.changeMemoryMode(config.lowDetail())
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group.equals(LowDetailConfig.Companion.GROUP)) {
            clientThread.invoke {
                if (client.gameState.state >= GameState.LOGIN_SCREEN.state) {
                    client.changeMemoryMode(config.lowDetail())
                }
            }
        }
    }

    override fun onBeforeRender(it: BeforeRender) {
        // This needs to be set to the current plane, but there is no event for plane change, so
        // just set it each render.
        client.scene.minLevel = if (config.hideLowerPlanes()) client.plane else 0
    }
}