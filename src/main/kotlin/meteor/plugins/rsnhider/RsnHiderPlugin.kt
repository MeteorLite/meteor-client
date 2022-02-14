/*
 * Copyright (c) 2020, ThatGamerBlue <thatgamerblue@gmail.com>
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
package meteor.plugins.rsnhider

import eventbus.events.BeforeRender
import eventbus.events.ChatMessage
import eventbus.events.ConfigChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.GameState
import net.runelite.api.ScriptID
import net.runelite.api.events.OverheadTextChanged
import net.runelite.api.util.Text
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import org.rationalityfrontline.kevent.Event
import java.util.*


@PluginDescriptor(name = "RSN Hider", description = "Hides your rsn for streamers.", enabledByDefault = false)
class RsnHiderPlugin : Plugin() {


    private val clientThread = ClientThread
    override val config = configuration<RsnHiderConfig>()


    override fun onStart() {
        setFakeRsn()
    }

    override fun onStop() {
        clientThread.invokeLater { client.runScript(ScriptID.CHAT_PROMPT_INIT) }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (!it.group.equals("rsnhider")) {
            setFakeRsn()
        }
    }
    private fun beforeRender(){
        if (client.gameState != GameState.LOGGED_IN) {
            return
        }
        if (config.hideWidgets()) {
            // do every widget
            for (widgetRoot in client.widgetRoots) {
                processWidget(widgetRoot)
            }
        } else {
            // just do the chatbox
            updateChatbox()
        }
    }
    override fun onBeforeRender(it: BeforeRender) {
      beforeRender()
    }


    private fun setFakeRsn() {
        fakeRsn = if (config.customRsn() == "") randomAlphaNumeric(12) else config.customRsn()
    }

    /**
     * Recursively traverses widgets looking for text containing the players name, replacing it if necessary
     * @param widget The root widget to process
     */
    private fun processWidget(widget: Widget?) {
        if (widget == null) {
            return
        }
        if (widget.text != null) {
            widget.text = replaceRsn(widget.text)
        }
        for (child in widget.staticChildren) {
            processWidget(child)
        }
        for (dynamicChild in widget.dynamicChildren) {
            processWidget(dynamicChild)
        }
        for (nestedChild in widget.nestedChildren) {
            processWidget(nestedChild)
        }
    }

    private fun updateChatbox() {
        val chatboxTypedText = client.getWidget(WidgetInfo.CHATBOX_INPUT)
        if (chatboxTypedText == null || chatboxTypedText.isHidden) {
            return
        }
        val chatbox: Array<String?> = chatboxTypedText.text.split(":".toRegex(), 2).toTypedArray()
        val playerRsn: String = Text.toJagexName(client.localPlayer!!.name)
        if (Text.standardize(chatbox[0]).contains(Text.standardize(playerRsn))) {
            chatbox[0] = fakeRsn
        }
        chatboxTypedText.text = chatbox[0] + ":" + chatbox[1]
    }

    override fun onChatMessage(it: ChatMessage) {
        if (client.localPlayer!!.name == null) {

            val replaced = replaceRsn(it.message)
            it.message = replaced
            it.messageNode.value = replaced


            val isLocalPlayer: Boolean = Text.standardize(it.name).equals(
                Text.standardize(
                    client.localPlayer!!.name
                ).toString().lowercase()
            )
            if (isLocalPlayer) {
                it.name = fakeRsn!!
                it.messageNode.name = fakeRsn
            }
        }

    }

    override fun onOverheadTextChanged(it: OverheadTextChanged) {
        it.actor.overheadText = replaceRsn(it.overheadText)
    }
    private fun replaceRsn(textIn: String): String {
        var textIn = textIn
        val playerRsn: String = Text.toJagexName(client.localPlayer!!.name)
        val standardized: String = Text.standardize(playerRsn)
        while (Text.standardize(textIn).contains(standardized)) {
            val idx = textIn.replace("\u00A0", " ").lowercase(Locale.getDefault())
                .indexOf(playerRsn.lowercase(Locale.getDefault()))
            val length = playerRsn.length
            val partOne = textIn.substring(0, idx)
            val partTwo = textIn.substring(idx + length)
            textIn = partOne + fakeRsn + partTwo
        }
        return textIn
    }

    companion object {
        private var fakeRsn: String? = null
        private const val ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
        private fun randomAlphaNumeric(count: Int): String {
            val builder = StringBuilder()
            var i = count
            while (i-- != 0) {
                val character = (Math.random() * ALPHA_NUMERIC_STRING.length).toInt()
                builder.append(ALPHA_NUMERIC_STRING[character])
            }
            return builder.toString()
        }
    }
}