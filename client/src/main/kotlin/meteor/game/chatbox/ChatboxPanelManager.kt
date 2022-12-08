/*
 * Copyright (c) 2018 Abex
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
package meteor.game.chatbox

import eventbus.events.GameStateChanged
import eventbus.events.ScriptPreFired
import meteor.Main.client
import meteor.input.*
import meteor.plugins.EventSubscriber
import meteor.rs.ClientThread
import net.runelite.api.GameState
import net.runelite.api.ScriptID
import net.runelite.api.VarClientInt
import net.runelite.api.vars.InputType
import net.runelite.api.widgets.JavaScriptCallback
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo


object ChatboxPanelManager : EventSubscriber() {
    private val clientThread = ClientThread
    private val keyManager =  KeyManager
    private val mouseManager =  MouseManager
    private val chatboxTextMenuInputProvider = ChatboxTextMenuInput
    private val chatboxTextInputProvider = ChatboxTextInput()

    var currentInput: ChatboxInput? = null
    init{
        subscribeEvents()
    }

    fun close() {
        clientThread.invokeLater { unsafeCloseInput() }
    }

    private fun unsafeCloseInput() {
        client.runScript(
            ScriptID.MESSAGE_LAYER_CLOSE,
            0,
            1,
            0
        )
        if (currentInput != null) {
            killCurrentPanel()
        }
    }

    private fun unsafeOpenInput(input: ChatboxInput) {
        client.runScript(ScriptID.MESSAGE_LAYER_OPEN, 0)

        if (input is KeyListener) {
            keyManager.registerKeyListener((input as KeyListener), this.javaClass)
        }
        if (input is MouseListener) {
            mouseManager.registerMouseListener(input as MouseListener)
        }
        if (input is MouseWheelListener) {
            mouseManager.registerMouseWheelListener(input as MouseWheelListener)
        }
        if (currentInput != null) {
            killCurrentPanel()
        }
        currentInput = input
        client.setVarcIntValue(VarClientInt.INPUT_TYPE.index, InputType.RUNELITE_CHATBOX_PANEL.type)
        client.getWidget(WidgetInfo.CHATBOX_TITLE)?.isHidden = true
        client.getWidget(WidgetInfo.CHATBOX_FULL_INPUT)?.isHidden = true
        val c = containerWidget
        c?.deleteAllChildren()
        c?.setOnDialogAbortListener(JavaScriptCallback { unsafeCloseInput() } as JavaScriptCallback?)
        input.open()
    }

    fun openInput(input: ChatboxInput) {
        clientThread.invokeLater { unsafeOpenInput(input) }
    }

    fun openTextMenuInput(title: String?): ChatboxTextMenuInput {
        return chatboxTextMenuInputProvider
            .title(title)
    }

    fun openTextInput(prompt: String?): ChatboxTextInput {
        return chatboxTextInputProvider
            .prompt(prompt)
    }

    override fun onScriptPreFired(it: ScriptPreFired) {
        if (currentInput != null && it.scriptId == ScriptID.MESSAGE_LAYER_CLOSE) {
            killCurrentPanel()
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        if (currentInput != null && it.gameState == GameState.LOGIN_SCREEN) {
            killCurrentPanel()
        }
    }

    private fun killCurrentPanel() {
        try {
            currentInput!!.close()
        } catch (e: Exception) {
          //  ChatboxPanelManager.log.warn("Exception closing {}", currentInput!!.javaClass, e)
        }

        if (currentInput is KeyListener) {
            keyManager.unregisterKeyListener((currentInput as KeyListener?)!!)
        }
        if (currentInput is MouseListener) {
            mouseManager.unregisterMouseListener(currentInput as MouseListener)
        }
        if (currentInput is MouseWheelListener) {
            mouseManager.unregisterMouseWheelListener(currentInput as MouseWheelListener)
        }
        currentInput = null
    }

    val containerWidget: Widget?
        get() = client.getWidget(WidgetInfo.CHATBOX_CONTAINER)

    fun shouldTakeInput(): Boolean {
        // the search box on the world map can be focused, and chat input goes there, even
        // though the chatbox still has its key listener.
        val worldMapSearch: Widget? = client.getWidget(WidgetInfo.WORLD_MAP_SEARCH)
        return worldMapSearch == null || client.getVarcIntValue(VarClientInt.WORLD_MAP_SEARCH_FOCUSED.index) != 1
    }
}