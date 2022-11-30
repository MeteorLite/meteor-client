/*
 * Copyright (c) 2019, Lotto <https://github.com/devLotto>
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
package meteor.plugins.emojis

import eventbus.events.ChatMessage
import eventbus.events.GameStateChanged
import eventbus.events.OverheadTextChanged
import lombok.extern.slf4j.Slf4j
import meteor.Logger
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.ImageUtil
import net.runelite.api.*
import net.runelite.api.ChatMessageType.*
import net.runelite.api.util.Text
import java.awt.image.BufferedImage
import java.util.regex.Pattern


@PluginDescriptor(
    name = "Emojis",
    description = "Replaces common emoticons such as :) with their corresponding emoji in the chat",
    enabledByDefault = false
)
@Slf4j
class EmojiPlugin : Plugin() {

    private val log = Logger("emojiplugin")
    private val clientThread = ClientThread
    private var modIconsStart = -1


    override fun onGameStateChanged(it: GameStateChanged) {
       if(it.gameState == GameState.LOGGED_IN){
           clientThread.invoke {
               loadEmojiIcons()
               true
           }
       }
    }

    private fun loadEmojiIcons() {
        if (modIconsStart != -1) {
            return
        }
        val emojis = Emoji.values()
        val modIcons = client.modIcons!!
        val newModIcons = modIcons.copyOf(modIcons.size + emojis.size)
        modIconsStart = modIcons.size
        for (i in emojis.indices) {
            val emoji = emojis[i]
            try {
                val image: BufferedImage = emoji.loadImage()
                val sprite: IndexedSprite? = ImageUtil.getImageIndexedSprite(image!!, client)
                newModIcons[modIconsStart + i] = sprite
            } catch (ex: Exception) {
                log.warn("Failed to load the sprite for emoji $emoji", ex)
            }
        }
        log.debug("Adding emoji icons")
        client.modIcons = newModIcons
    }

    override fun onChatMessage(it: ChatMessage) {
        if (client.gameState != GameState.LOGGED_IN || modIconsStart == -1) {
            return
        }
        when (it.type) {
            PUBLICCHAT, MODCHAT, FRIENDSCHAT, CLAN_CHAT, CLAN_GUEST_CHAT, CLAN_GIM_CHAT, PRIVATECHAT, PRIVATECHATOUT, MODPRIVATECHAT -> {}
            else -> return
        }
        val messageNode: MessageNode = it.messageNode
        val message: String = messageNode.value
        val updatedMessage = updateMessage(message) ?: return
        messageNode.value = updatedMessage
    }

    override fun onOverheadTextChanged(it: OverheadTextChanged) {
        if (it.actor !is Player) {
            return
        }
        val message: String = it.overheadText
        val updatedMessage = updateMessage(message) ?: return
        it.actor.overheadText = updatedMessage
    }

    fun updateMessage(message: String?): String? {
        val messageWords = WHITESPACE_REGEXP.split(message)
        var editedMessage = false
        for (i in messageWords.indices) {
            // Remove tags except for <lt> and <gt>
            val trigger: String = Text.removeFormattingTags(messageWords[i])
            val emoji: Emoji = Emoji.Companion.getEmoji(trigger) ?: continue
            val emojiId = modIconsStart + emoji.ordinal
            messageWords[i] = messageWords[i].replace(trigger, "<img=$emojiId>")
            editedMessage = true
        }

        // If we haven't edited the message any, don't update it.
        return if (!editedMessage) {
            null
        } else messageWords.joinToString ( separator = " " )
    }
    companion object {
        private val WHITESPACE_REGEXP = Pattern.compile("[\\s\\u00A0]")
    }
}