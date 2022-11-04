/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
 * Copyright (c) 2020, Anthony <https://github.com/while-loop>
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
package meteor.plugins.chathistory

import com.google.common.collect.EvictingQueue
import eventbus.events.ChatMessage
import eventbus.events.MenuEntryAdded
import eventbus.events.MenuOptionClicked
import meteor.input.KeyListener
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.events.MenuOpened
import net.runelite.api.util.Text
import net.runelite.api.vars.InputType
import net.runelite.api.widgets.WidgetInfo
import org.apache.commons.lang3.ArrayUtils
import org.apache.commons.lang3.StringUtils
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.awt.event.KeyEvent
import java.util.*
import java.util.Deque

@PluginDescriptor(name = "Chat History", description = "Retain your chat history when logging in/out or world hopping", tags = ["chat", "history", "retain", "cycle", "pm"])
class ChatHistoryPlugin : Plugin(), KeyListener {
    private var messageQueue: Queue<MessageNode>? = null
    private var friends: Deque<String>? = null
    private val clientThread = ClientThread
    private val config = configuration<ChatHistoryConfig>()
    private val keyManager = KeyManager
    override fun onStart() {
        // The client reuses MessageNodes after 100 chat messages of
        // the same type, so this must be 100 (or maybe a map of
        // size 100 evicting queues)
        messageQueue = EvictingQueue.create(100)
        friends = ArrayDeque(FRIENDS_MAX_SIZE + 1)
        keyManager.registerKeyListener(this, ChatHistoryPlugin::class.java)
    }

    override fun onStop() {
        messageQueue?.clear()
        messageQueue = null
        friends?.clear()
        friends = null
        keyManager.unregisterKeyListener(this)
    }

    override fun onChatMessage(chatMessage: ChatMessage) {
        // Start sending old messages right after the welcome message, as that is most reliable source
        // of information that chat history was reset
        val chatMessageType = chatMessage.type
        if (chatMessageType == ChatMessageType.WELCOME && StringUtils.startsWithIgnoreCase(chatMessage.message, WELCOME_MESSAGE)) {
            if (!config.retainChatHistory()) {
                return
            }
            for (queuedMessage in messageQueue!!) {
                val node = client.addChatMessage(
                        queuedMessage.type,
                        queuedMessage.name,
                        queuedMessage.value,
                        queuedMessage.sender,
                        false)
                node.runeLiteFormatMessage = queuedMessage.runeLiteFormatMessage
                node.timestamp = queuedMessage.timestamp
            }
            return
        }
        when (chatMessageType) {
            ChatMessageType.PRIVATECHATOUT, ChatMessageType.PRIVATECHAT, ChatMessageType.MODPRIVATECHAT -> {
                val name = Text.removeTags(chatMessage.name)
                // Remove to ensure uniqueness & its place in history
                if (!friends!!.remove(name)) {
                    // If the friend didn't previously exist ensure deque capacity doesn't increase by adding them
                    if (friends!!.size >= FRIENDS_MAX_SIZE) {
                        friends!!.remove()
                    }
                }
                friends!!.add(name)
                messageQueue!!.offer(chatMessage.messageNode)
            }

            ChatMessageType.PUBLICCHAT, ChatMessageType.MODCHAT, ChatMessageType.FRIENDSCHAT, ChatMessageType.CLAN_GUEST_CHAT, ChatMessageType.CLAN_GUEST_MESSAGE, ChatMessageType.CLAN_CHAT, ChatMessageType.CLAN_MESSAGE, ChatMessageType.CLAN_GIM_CHAT, ChatMessageType.CLAN_GIM_MESSAGE, ChatMessageType.CONSOLE -> messageQueue!!.offer(chatMessage.messageNode)
            else -> {}
        }
    }

    override fun onMenuOpened(event: MenuOpened) {
        if (event.menuEntries.size < 2 || !config.copyToClipboard()) {
            return
        }

        // Use second entry as first one can be walk here with transparent chatbox
        val entry = event.menuEntries[event.menuEntries.size - 2]
        if (entry.type != MenuAction.CC_OP_LOW_PRIORITY && entry.type != MenuAction.RUNELITE) {
            return
        }
        val groupId = WidgetInfo.TO_GROUP(entry.param1)
        val childId = WidgetInfo.TO_CHILD(entry.param1)
        if (groupId != WidgetInfo.CHATBOX.groupId) {
            return
        }
        val widget = client.getWidget(groupId, childId)
        val parent = widget!!.parent
        if (WidgetInfo.CHATBOX_MESSAGE_LINES.id != parent.id) {
            return
        }

        // Get child id of first chat message static child so we can substract this offset to link to dynamic child
        // later
        val first = WidgetInfo.CHATBOX_FIRST_MESSAGE.childId

        // Convert current message static widget id to dynamic widget id of message node with message contents
        // When message is right clicked, we are actually right clicking static widget that contains only sender.
        // The actual message contents are stored in dynamic widgets that follow same order as static widgets.
        // Every first dynamic widget is message sender, every second one is message contents,
        // every third one is clan name and every fourth one is clan rank icon.
        // The last two are hidden when the message is not from a clan chat or guest clan chat.
        val dynamicChildId = (childId - first) * 4 + 1

        // Extract and store message contents when menu is opened because dynamic children can change while right click
        // menu is open and dynamicChildId will be outdated
        val messageContents = parent.getChild(dynamicChildId) ?: return
        val currentMessage = messageContents.text
        client.createMenuEntry(1)
                .setOption(COPY_TO_CLIPBOARD)
                .setTarget(entry.target)
                .setType(MenuAction.RUNELITE)
                .onClick { e: MenuEntry? ->
                    val stringSelection = StringSelection(Text.removeTags(currentMessage))
                    Toolkit.getDefaultToolkit().systemClipboard.setContents(stringSelection, null)
                }
    }

    override fun onMenuOptionClicked(event: MenuOptionClicked) {
        val menuOption = event.getMenuOption()

        // The menu option for clear history is "<col=ffff00>Public:</col> Clear history"
        if (menuOption!!.endsWith(CLEAR_HISTORY)) {
            clearChatboxHistory(ChatboxTab.of(event.getParam1()))
        }
    }

    override fun onMenuEntryAdded(entry: MenuEntryAdded) {
        if (entry.identifier != MenuAction.CC_OP.id) {
            return
        }
        val tab: ChatboxTab? = ChatboxTab.of(entry.param1)
        if (tab?.after == null || !config.clearHistory() || !entry.option!!.endsWith(tab.after)) {
            return
        }
        val clearEntry = client.createMenuEntry(-2)
                .setType(MenuAction.RUNELITE_HIGH_PRIORITY)
        clearEntry.param1 = entry.param1
        val optionBuilder = StringBuilder()
        if (tab != ChatboxTab.ALL) {
            // Pull tab name from menu since Trade/Group is variable
            val option = entry.option
            val idx = option!!.indexOf(':')
            if (idx != -1) {
                optionBuilder.append(option, 0, idx).append(":</col> ")
            }
        }
        optionBuilder.append(CLEAR_HISTORY)
        clearEntry.option = optionBuilder.toString()
    }

    private fun clearMessageQueue(tab: ChatboxTab) {
        if (tab == ChatboxTab.ALL || tab == ChatboxTab.PRIVATE) {
            friends!!.clear()
        }
        messageQueue!!.removeIf { e: MessageNode -> ArrayUtils.contains(tab.messageTypes, e.type) }
    }

    private fun clearChatboxHistory(tab: ChatboxTab?) {
        if (tab == null) {
            return
        }
        clearMessageQueue(tab)
        if (tab.after == null) {
            // if the tab has a vanilla Clear option, it isn't necessary to delete the messages ourselves.
            return
        }
        var removed = false
        for (msgType in tab.messageTypes) {
            val lineBuffer = client.chatLineMap[msgType.type] ?: continue
            val lines = lineBuffer.lines.clone()
            for (line in lines) {
                if (line != null) {
                    lineBuffer.removeMessageNode(line)
                    removed = true
                }
            }
        }
        if (removed) {
            // this rebuilds both the chatbox and the pmbox
            clientThread.invoke { client.runScript(ScriptID.SPLITPM_CHANGED) }
        }
    }

    override fun keyPressed(e: KeyEvent) {
        if (e.keyCode != CYCLE_HOTKEY || !config.pmTargetCycling()) {
            return
        }
        if (client.getVarcIntValue(VarClientInt.INPUT_TYPE.index) != InputType.PRIVATE_MESSAGE.type) {
            return
        }
        clientThread.invoke {
            val target = findPreviousFriend() ?: return@invoke
            val currentMessage = client.getVarcStrValue(VarClientStr.INPUT_TEXT.index)
            client.runScript(ScriptID.OPEN_PRIVATE_MESSAGE_INTERFACE, target)
            client.setVarcStrValue(VarClientStr.INPUT_TEXT.index, currentMessage)
            client.runScript(ScriptID.CHAT_TEXT_INPUT_REBUILD, "")
        }
    }

    override fun keyTyped(e: KeyEvent) {}
    override fun keyReleased(e: KeyEvent) {}
    private fun findPreviousFriend(): String? {
        val currentTarget = client.getVarcStrValue(VarClientStr.PRIVATE_MESSAGE_TARGET.index)
        if (currentTarget == null || friends!!.isEmpty()) {
            return null
        }
        val it = friends!!.descendingIterator()
        while (it.hasNext()) {
            val friend = it.next()
            if (friend == currentTarget) {
                return if (it.hasNext()) it.next() else friends!!.last
            }
        }
        return friends!!.last
    }

    companion object {
        private const val WELCOME_MESSAGE = "Welcome to Old School RuneScape"
        private const val CLEAR_HISTORY = "Clear history"
        private const val COPY_TO_CLIPBOARD = "Copy to clipboard"
        private const val CYCLE_HOTKEY = KeyEvent.VK_TAB
        private const val FRIENDS_MAX_SIZE = 5
    }
}