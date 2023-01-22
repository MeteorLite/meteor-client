/*
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

import com.google.common.collect.ImmutableMap
import lombok.Getter
import meteor.rs.ClientThread.invoke
import net.runelite.api.ChatMessageType
import net.runelite.api.widgets.WidgetInfo

@Getter
internal enum class ChatboxTab(val after: String?, widgetId: WidgetInfo, vararg messageTypes: ChatMessageType) {
    ALL("Switch tab", WidgetInfo.CHATBOX_TAB_ALL,
            *ChatMessageType.values()),  // null 'after' var since we're not adding to menu
    PRIVATE(null, WidgetInfo.CHATBOX_TAB_PRIVATE,
            ChatMessageType.PRIVATECHAT, ChatMessageType.PRIVATECHATOUT, ChatMessageType.MODPRIVATECHAT,
            ChatMessageType.LOGINLOGOUTNOTIFICATION),  // null 'after' var since we're not adding to menu
    PUBLIC(null, WidgetInfo.CHATBOX_TAB_PUBLIC,
            ChatMessageType.PUBLICCHAT, ChatMessageType.AUTOTYPER, ChatMessageType.MODCHAT, ChatMessageType.MODAUTOTYPER),
    GAME("Filter", WidgetInfo.CHATBOX_TAB_GAME,
            ChatMessageType.GAMEMESSAGE, ChatMessageType.ENGINE, ChatMessageType.BROADCAST,
            ChatMessageType.SNAPSHOTFEEDBACK, ChatMessageType.ITEM_EXAMINE, ChatMessageType.NPC_EXAMINE,
            ChatMessageType.OBJECT_EXAMINE, ChatMessageType.FRIENDNOTIFICATION, ChatMessageType.IGNORENOTIFICATION,
            ChatMessageType.CONSOLE, ChatMessageType.SPAM, ChatMessageType.PLAYERRELATED, ChatMessageType.TENSECTIMEOUT,
            ChatMessageType.WELCOME, ChatMessageType.UNKNOWN),
    CHANNEL(null, WidgetInfo.CHATBOX_TAB_CHANNEL,
            ChatMessageType.FRIENDSCHATNOTIFICATION, ChatMessageType.FRIENDSCHAT, ChatMessageType.CHALREQ_FRIENDSCHAT),
    CLAN(null, WidgetInfo.CHATBOX_TAB_CLAN,
            ChatMessageType.CLAN_CHAT, ChatMessageType.CLAN_MESSAGE,
            ChatMessageType.CLAN_GUEST_CHAT, ChatMessageType.CLAN_GUEST_MESSAGE),  // Group has its own Clear option, but Trade does not
    TRADE_GROUP("Trade:</col> Show none", WidgetInfo.CHATBOX_TAB_TRADE,
            ChatMessageType.TRADE_SENT, ChatMessageType.TRADEREQ, ChatMessageType.TRADE, ChatMessageType.CHALREQ_TRADE,
            ChatMessageType.CLAN_GIM_CHAT, ChatMessageType.CLAN_GIM_MESSAGE);

    private val widgetId: Int
    val messageTypes: Array<ChatMessageType>

    init {
        this.widgetId = widgetId.id
        this.messageTypes = messageTypes as Array<ChatMessageType>
    }

    companion object {
        private var TAB_MESSAGE_TYPES: Map<Int, ChatboxTab>? = null

        init {
            val builder = ImmutableMap.builder<Int, ChatboxTab>()
            for (t in values()) {
                builder.put(t.widgetId, t)
            }
            TAB_MESSAGE_TYPES = builder.build()
        }

        fun of(widgetId: Int): ChatboxTab? {
            return TAB_MESSAGE_TYPES!![widgetId]
        }
    }
}