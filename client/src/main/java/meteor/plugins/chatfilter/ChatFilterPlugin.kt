/*
 * Copyright (c) 2018, Magic fTail
 * Copyright (c) 2019, osrs-music-map <osrs-music-map@users.noreply.github.com>
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
package meteor.plugins.chatfilter

import com.google.common.annotations.VisibleForTesting
import com.google.common.base.Splitter
import com.google.common.collect.ImmutableSet
import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.ChatMessageType
import net.runelite.api.GameState
import net.runelite.api.Player
import net.runelite.api.util.Text
import org.apache.commons.lang3.StringUtils
import java.util.*
import java.util.function.Consumer
import java.util.regex.Pattern
import java.util.regex.PatternSyntaxException

@PluginDescriptor(
    name = "Chat Filter",
    description = "Censor user configurable words or patterns from chat",
    enabledByDefault = false
)
class ChatFilterPlugin : Plugin() {
    private val jagexPrintableCharMatcher = Text.JAGEX_PRINTABLE_CHAR_MATCHER
    private val filteredPatterns: MutableList<Pattern?> = ArrayList()
    private val filteredNamePatterns: MutableList<Pattern?> = ArrayList()

    private class Duplicate {
        var messageId = 0
        var count = 0
    }

    private val duplicateChatCache: LinkedHashMap<String?, Duplicate?> = object : LinkedHashMap<String?, Duplicate?>() {

        val MAX_ENTRIES = 100
        override fun removeEldestEntry(eldest: Map.Entry<String?, Duplicate?>): Boolean {
            return size > MAX_ENTRIES
        }
    }
    val config = configuration<ChatFilterConfig>()
    override fun onStart() {
        updateFilteredPatterns()
        client.refreshChat()
    }

    override fun onStop() {
        filteredPatterns.clear()
        duplicateChatCache.clear()
        client.refreshChat()
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.gameState) {
            GameState.HOPPING, GameState.LOGGING_IN -> duplicateChatCache.values.forEach(
                Consumer { d: Duplicate -> d.messageId = -1 } as (Duplicate?) -> Unit)
            else -> {}
        }
    }

    private fun chatFilter() {

        val intStack = client.intStack
        val intStackSize = client.intStackSize
        val stringStack = client.stringStack
        val stringStackSize = client.stringStackSize

        val messageType = intStack[intStackSize - 2]
        val messageId = intStack[intStackSize - 1]
        var message = stringStack[stringStackSize - 1]

        val chatMessageType = ChatMessageType.of(messageType)
        val messageNode = client.messages.get(messageId.toLong())
        val name = messageNode.name
        var duplicateCount = 0
        var blockMessage = false

        // Only filter public chat and private messages
        when (chatMessageType) {
            ChatMessageType.PUBLICCHAT, ChatMessageType.MODCHAT, ChatMessageType.AUTOTYPER, ChatMessageType.PRIVATECHAT, ChatMessageType.MODPRIVATECHAT, ChatMessageType.FRIENDSCHAT, ChatMessageType.CLAN_CHAT, ChatMessageType.CLAN_GUEST_CHAT -> if (shouldFilterPlayerMessage(
                    Text.removeTags(name)
                )
            ) {
                message = censorMessage(name, message)
                blockMessage = message == null
            }
            ChatMessageType.GAMEMESSAGE, ChatMessageType.ENGINE, ChatMessageType.ITEM_EXAMINE, ChatMessageType.NPC_EXAMINE, ChatMessageType.OBJECT_EXAMINE, ChatMessageType.SPAM -> if (config.filterGameChat()) {
                message = censorMessage(null, message)
                blockMessage = message == null
            }
            else -> {}
        }

        val shouldCollapse =
            if (chatMessageType == ChatMessageType.PUBLICCHAT || chatMessageType == ChatMessageType.MODCHAT) config.collapsePlayerChat() else COLLAPSIBLE_MESSAGETYPES.contains(
                chatMessageType
            ) && config.collapseGameChat()
        if (!blockMessage && shouldCollapse) {
            val duplicateCacheEntry = duplicateChatCache["$name:$message"]
            // If messageId is -1 then this is a replayed message, which we can't easily collapse since we don't know
            // the most recent message. This is only for public chat since it is the only thing both replayed and also
            // collapsed. Just allow uncollapsed playback.
            if (duplicateCacheEntry != null && duplicateCacheEntry.messageId != -1) {
                blockMessage = duplicateCacheEntry.messageId != messageId ||
                        (chatMessageType == ChatMessageType.PUBLICCHAT || chatMessageType == ChatMessageType.MODCHAT) && config.maxRepeatedPublicChats() > 0 && duplicateCacheEntry.count > config.maxRepeatedPublicChats()
                duplicateCount = duplicateCacheEntry.count
            }
        }

        if (blockMessage) {
            // Block the message
            intStack[intStackSize - 3] = 0
        } else {
            // Replace the message
            if (duplicateCount > 1) {
                message += " ($duplicateCount)"
            }
            stringStack[stringStackSize - 1] = message
        }
    }

    override fun onScriptCallbackEvent(it: ScriptCallbackEvent) {
        if ("chatFilterCheck" != it.eventName) {
            chatFilter()
        }


    }

    override fun onOverheadTextChanged(it: OverheadTextChanged) {
        if (it.actor !is Player || !shouldFilterPlayerMessage(it.actor.name)) {

            var message = censorMessage(it.actor.name, it.overheadText)
            if (message == null) {
                message = " "
            }
            it.actor.overheadText = message
        }
    }


    override fun onChatMessage(it: ChatMessage) {
        if (COLLAPSIBLE_MESSAGETYPES.contains(it.type)) {
            val messageNode = it.messageNode
            // remove and re-insert into map to move to end of list
            val key = messageNode.name + ":" + messageNode.value
            var duplicate = duplicateChatCache.remove(key)
            if (duplicate == null) {
                duplicate = Duplicate()
            }
            duplicate.count++
            duplicate.messageId = messageNode.id
            duplicateChatCache[key] = duplicate
        }
    }


    fun shouldFilterPlayerMessage(playerName: String?): Boolean {
        val isMessageFromSelf = playerName == client.localPlayer!!.name
        return !isMessageFromSelf &&
                (config.filterFriends() || !client.isFriended(playerName, false)) &&
                (config.filterFriendsChat() || !isFriendsChatMember(playerName)) &&
                (config.filterClanChat() || !isClanChatMember(playerName))
    }

    private fun isFriendsChatMember(name: String?): Boolean {
        val friendsChatManager = client.friendsChatManager
        return friendsChatManager != null && friendsChatManager.findByName(name) != null
    }

    private fun isClanChatMember(name: String?): Boolean {
        var clanChannel = client.clanChannel
        if (clanChannel?.findMember(name) != null) {
            return true
        }
        clanChannel = client.guestClanChannel
        return clanChannel?.findMember(name) != null
    }

    fun censorMessage(username: String?, message: String?): String? {
        var strippedMessage = jagexPrintableCharMatcher.retainFrom(message)
            .replace('\u00A0', ' ')
        if (username != null && shouldFilterByName(username)) {
            when (config.filterType()) {
                ChatFilterType.CENSOR_WORDS -> return StringUtils.repeat('*', strippedMessage.length)
                ChatFilterType.CENSOR_MESSAGE -> return CENSOR_MESSAGE
                ChatFilterType.REMOVE_MESSAGE -> return null
                else -> {}
            }
        }
        var filtered = false
        for (pattern in filteredPatterns) {
            val m = pattern!!.matcher(strippedMessage)
            val sb = StringBuffer()
            while (m.find()) {
                when (config.filterType()) {
                    ChatFilterType.CENSOR_WORDS -> {
                        m.appendReplacement(sb, StringUtils.repeat('*', m.group(0).length))
                        filtered = true
                    }
                    ChatFilterType.CENSOR_MESSAGE -> return CENSOR_MESSAGE
                    ChatFilterType.REMOVE_MESSAGE -> return null
                    else -> {}
                }
            }
            m.appendTail(sb)
            strippedMessage = sb.toString()
        }
        return if (filtered) strippedMessage else message
    }

    fun updateFilteredPatterns() {
        filteredPatterns.clear()
        filteredNamePatterns.clear()
        Text.fromCSV(config.filteredWords()).stream()
            .map { s: String? -> Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE) }
            .forEach { e: Pattern? -> filteredPatterns.add(e) }
        NEWLINE_SPLITTER.splitToList(config.filteredRegex()).stream()
            .map { pattern: String -> compilePattern(pattern) }
            .filter { obj: Pattern? -> Objects.nonNull(obj) }
            .forEach { e: Pattern? -> filteredPatterns.add(e) }
        NEWLINE_SPLITTER.splitToList(config.filteredNames()).stream()
            .map { pattern: String -> compilePattern(pattern) }
            .filter { obj: Pattern? -> Objects.nonNull(obj) }
            .forEach { e: Pattern? -> filteredNamePatterns.add(e) }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if ("chatfilter" != it.group) {


            updateFilteredPatterns()

            //Refresh chat after config change to reflect current rules
            client.refreshChat()
        }
    }

    @VisibleForTesting
    fun shouldFilterByName(playerName: String?): Boolean {
        val sanitizedName = Text.standardize(playerName)
        for (pattern in filteredNamePatterns) {
            val m = pattern!!.matcher(sanitizedName)
            if (m.find()) {
                return true
            }
        }
        return false
    }

    companion object {
        private val NEWLINE_SPLITTER = Splitter
            .on("\n")
            .omitEmptyStrings()
            .trimResults()

        @VisibleForTesting
        val CENSOR_MESSAGE = "Hey, everyone, I just tried to say something very silly!"
        private val COLLAPSIBLE_MESSAGETYPES: Set<ChatMessageType> = ImmutableSet.of(
            ChatMessageType.ENGINE,
            ChatMessageType.GAMEMESSAGE,
            ChatMessageType.ITEM_EXAMINE,
            ChatMessageType.NPC_EXAMINE,
            ChatMessageType.OBJECT_EXAMINE,
            ChatMessageType.SPAM,
            ChatMessageType.PUBLICCHAT,
            ChatMessageType.MODCHAT
        )

        private fun compilePattern(pattern: String): Pattern? {
            return try {
                Pattern.compile(pattern, Pattern.CASE_INSENSITIVE)
            } catch (ex: PatternSyntaxException) {
                null
            }
        }
    }
}