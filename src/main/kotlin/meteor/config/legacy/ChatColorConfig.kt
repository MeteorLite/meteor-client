package meteor.config.legacy


import java.awt.Color

@ConfigGroup("textrecolor")
interface ChatColorConfig : Config {
    @ConfigItem(position = 1,
            keyName = "opaquePublicChat",
            name = "Public chat",
            description = "Color of Public chat",
            section = opaqueSection)
    fun opaquePublicChat(): Color?

    @ConfigItem(position = 2,
            keyName = "opaquePublicChatHighlight",
            name = "Public chat highlight",
            description = "Color of highlights in Public chat",
            section = opaqueSection)
    fun opaquePublicChatHighlight(): Color? {
        return Color.decode("#000000")
    }

    @ConfigItem(position = 3,
            keyName = "opaquePrivateMessageSent",
            name = "Sent private messages",
            description = "Color of Private messages you've sent",
            section = opaqueSection)
    fun opaquePrivateMessageSent(): Color?

    @ConfigItem(position = 4,
            keyName = "opaquePrivateMessageSentHighlight",
            name = "Sent private messages highlight",
            description = "Color of highlights in Private messages you've sent",
            section = opaqueSection)
    fun opaquePrivateMessageSentHighlight(): Color? {
        return Color.decode("#002783")
    }

    @ConfigItem(position = 5,
            keyName = "opaquePrivateMessageReceived",
            name = "Received private messages",
            description = "Color of Private messages you've received",
            section = opaqueSection)
    fun opaquePrivateMessageReceived(): Color?

    @ConfigItem(position = 6,
            keyName = "opaquePrivateMessageReceivedHighlight",
            name = "Received private messages highlight",
            description = "Color of highlights in Private messages you've received",
            section = opaqueSection)
    fun opaquePrivateMessageReceivedHighlight(): Color? {
        return Color.decode("#002783")
    }

    //region opaque friends chat
    @ConfigItem(position = 7,
            keyName = "opaqueFriendsChatInfo",
            name = "Friends chat info",
            description = "Friends Chat Information (eg. when joining a channel)",
            section = opaqueSection)
    fun opaqueFriendsChatInfo(): Color?

    @ConfigItem(position = 8,
            keyName = "opaqueClanChatInfoHighlight",
            name = "Friends chat info highlight",
            description = "Friends Chat Information highlight (used for the Raids plugin)",
            section = opaqueSection)
    fun opaqueFriendsChatInfoHighlight(): Color? {
        return Color.RED
    }

    @ConfigItem(position = 9,
            keyName = "opaqueClanChatMessage",
            name = "Friends chat message",
            description = "Color of Friends chat messages",
            section = opaqueSection)
    fun opaqueFriendsChatMessage(): Color?

    @ConfigItem(position = 10,
            keyName = "opaqueClanChatMessageHighlight",
            name = "Friends chat message highlight",
            description = "Color of highlights in Friends Chat messages",
            section = opaqueSection)
    fun opaqueFriendsChatMessageHighlight(): Color? {
        return Color.decode("#000000")
    }

    //endregion
    //region opaque clan chat
    @ConfigItem(position = 11,
            keyName = "opaqueClanInfo",
            name = "Clan chat info",
            description = "Clan Chat Information (eg. when joining a channel)",
            section = opaqueSection)
    fun opaqueClanChatInfo(): Color?

    @ConfigItem(position = 12,
            keyName = "opaqueClanInfoHighlight",
            name = "Clan chat info highlight",
            description = "Clan Chat Information highlight",
            section = opaqueSection)
    fun opaqueClanChatInfoHighlight(): Color? {
        return Color.RED
    }

    @ConfigItem(position = 13,
            keyName = "opaqueClanMessage",
            name = "Clan chat message",
            description = "Color of Clan chat messages",
            section = opaqueSection)
    fun opaqueClanChatMessage(): Color?

    @ConfigItem(position = 14,
            keyName = "opaqueClanMessageHighlight",
            name = "Clan chat message highlight",
            description = "Color of highlights in Clan Chat messages",
            section = opaqueSection)
    fun opaqueClanChatMessageHighlight(): Color? {
        return Color.decode("#000000")
    }

    @ConfigItem(position = 15,
            keyName = "opaqueClanGuestInfo",
            name = "Guest Clan chat info",
            description = "Guest Clan Chat Information (eg. when joining a channel)",
            section = opaqueSection)
    fun opaqueClanChatGuestInfo(): Color?

    @ConfigItem(position = 16,
            keyName = "opaqueClanGuestInfoHighlight",
            name = "Guest Clan chat info highlight",
            description = "Guest Clan Chat Information highlight",
            section = opaqueSection)
    fun opaqueClanChatGuestInfoHighlight(): Color? {
        return Color.RED
    }

    @ConfigItem(position = 17,
            keyName = "opaqueClanGuestMessage",
            name = "Guest Clan chat message",
            description = "Color of Guest Clan chat messages",
            section = opaqueSection)
    fun opaqueClanChatGuestMessage(): Color?

    @ConfigItem(position = 18,
            keyName = "opaqueClanChatGuestMessageHighlight",
            name = "Guest Clan chat message highlight",
            description = "Color of highlights in Guest Clan Chat messages",
            section = opaqueSection)
    fun opaqueClanChatGuestMessageHighlight(): Color? {
        return Color.decode("#000000")
    }

    //endregion
    @ConfigItem(position = 19,
            keyName = "opaqueAutochatMessage",
            name = "Autochat",
            description = "Color of Autochat messages",
            section = opaqueSection)
    fun opaqueAutochatMessage(): Color?

    @ConfigItem(position = 20,
            keyName = "opaqueAutochatMessageHighlight",
            name = "Autochat highlight",
            description = "Color of highlights in Autochat messages",
            section = opaqueSection)
    fun opaqueAutochatMessageHighlight(): Color?

    @ConfigItem(position = 21,
            keyName = "opaqueTradeChatMessage",
            name = "Trade chat",
            description = "Color of Trade Chat Messages",
            section = opaqueSection)
    fun opaqueTradeChatMessage(): Color?

    @ConfigItem(position = 22,
            keyName = "opaqueTradeChatMessageHighlight",
            name = "Trade chat highlight",
            description = "Color of highlights in Trade Chat Messages",
            section = opaqueSection)
    fun opaqueTradeChatMessageHighlight(): Color?

    @ConfigItem(position = 23,
            keyName = "opaqueServerMessage",
            name = "Server message",
            description = "Color of Server Messages (eg. 'Welcome to RuneScape')",
            section = opaqueSection)
    fun opaqueServerMessage(): Color?

    @ConfigItem(position = 24,
            keyName = "opaqueServerMessageHighlight",
            name = "Server message highlight",
            description = "Color of highlights in Server Messages",
            section = opaqueSection)
    fun opaqueServerMessageHighlight(): Color?

    @ConfigItem(position = 25,
            keyName = "opaqueGameMessage",
            name = "Game message",
            description = "Color of Game Messages",
            section = opaqueSection)
    fun opaqueGameMessage(): Color?

    @ConfigItem(position = 26,
            keyName = "opaqueGameMessageHighlight",
            name = "Game message highlight",
            description = "Color of highlights in Game Messages",
            section = opaqueSection)
    fun opaqueGameMessageHighlight(): Color? {
        return Color.decode("#EF1020")
    }

    @ConfigItem(position = 27,
            keyName = "opaqueExamine",
            name = "Examine",
            description = "Color of Examine Text",
            section = opaqueSection)
    fun opaqueExamine(): Color?

    @ConfigItem(position = 28,
            keyName = "opaqueExamineHighlight",
            name = "Examine highlight",
            description = "Color of highlights in Examine Text",
            section = opaqueSection)
    fun opaqueExamineHighlight(): Color? {
        return Color.decode("#0000FF")
    }

    @ConfigItem(position = 29,
            keyName = "opaqueFiltered",
            name = "Filtered",
            description = "Color of Filtered Text (messages that aren't shown when Game messages are filtered)",
            section = opaqueSection)
    fun opaqueFiltered(): Color?

    @ConfigItem(position = 30,
            keyName = "opaqueFilteredHighlight",
            name = "Filtered highlight",
            description = "Color of highlights in Filtered Text",
            section = opaqueSection)
    fun opaqueFilteredHighlight(): Color?

    @ConfigItem(position = 31,
            keyName = "opaqueUsername",
            name = "Usernames",
            description = "Color of Usernames",
            section = opaqueSection)
    fun opaqueUsername(): Color?

    @ConfigItem(position = 32,
            keyName = "opaquePrivateUsernames",
            name = "Private chat usernames",
            description = "Color of Usernames in Private Chat",
            section = opaqueSection)
    fun opaquePrivateUsernames(): Color?

    @ConfigItem(position = 33,
            keyName = "opaqueClanChannelName",
            name = "Friends Chat channel name",
            description = "Color of Friends chat channel name",
            section = opaqueSection)
    fun opaqueFriendsChatChannelName(): Color?

    @ConfigItem(position = 34,
            keyName = "opaqueClanChatChannelName",
            name = "Clan Chat channel name",
            description = "Color of Clan chat channel name",
            section = opaqueSection)
    fun opaqueClanChannelName(): Color?

    @ConfigItem(position = 35,
            keyName = "opaqueClanChatGuestChannelName",
            name = "Guest Clan Chat channel name",
            description = "Color of Guest clan chat channel name",
            section = opaqueSection)
    fun opaqueClanGuestChatChannelName(): Color?

    @ConfigItem(position = 36,
            keyName = "opaqueClanUsernames",
            name = "Friends chat usernames",
            description = "Color of usernames in Friends chat",
            section = opaqueSection)
    fun opaqueFriendsChatUsernames(): Color?

    @ConfigItem(position = 37,
            keyName = "opaqueClanChatUsernames",
            name = "Clan chat usernames",
            description = "Color of usernames in Clan chat",
            section = opaqueSection)
    fun opaqueClanChatUsernames(): Color?

    @ConfigItem(position = 38,
            keyName = "opaqueClanChatGuestUsernames",
            name = "Guest Clan chat usernames",
            description = "Color of usernames in Guest Clan chat",
            section = opaqueSection)
    fun opaqueClanChatGuestUsernames(): Color?

    @ConfigItem(position = 39,
            keyName = "opaquePublicFriendUsernames",
            name = "Public friend usernames",
            description = "Color of Friend Usernames in Public Chat",
            section = opaqueSection)
    fun opaquePublicFriendUsernames(): Color?

    @ConfigItem(position = 40,
            keyName = "opaquePlayerUsername",
            name = "Your username",
            description = "Color of your username",
            section = opaqueSection)
    fun opaquePlayerUsername(): Color?

    @ConfigItem(position = 51,
            keyName = "transparentPublicChat",
            name = "Public chat (transparent)",
            description = "Color of Public chat (transparent)",
            section = transparentSection)
    fun transparentPublicChat(): Color?

    @ConfigItem(position = 52,
            keyName = "transparentPublicChatHighlight",
            name = "Public chat highlight (transparent)",
            description = "Color of highlights in Public chat (transparent)",
            section = transparentSection)
    fun transparentPublicChatHighlight(): Color? {
        return Color.decode("#FFFFFF")
    }

    @ConfigItem(position = 53,
            keyName = "transparentPrivateMessageSent",
            name = "Sent private messages (transparent)",
            description = "Color of Private messages you've sent (transparent)",
            section = transparentSection)
    fun transparentPrivateMessageSent(): Color?

    @ConfigItem(position = 54,
            keyName = "transparentPrivateMessageSentHighlight",
            name = "Sent private messages highlight (transparent)",
            description = "Color of highlights in Private messages you've sent (transparent)",
            section = transparentSection)
    fun transparentPrivateMessageSentHighlight(): Color? {
        return Color.decode("#FFFFFF")
    }

    @ConfigItem(position = 55,
            keyName = "transparentPrivateMessageReceived",
            name = "Received private messages (transparent)",
            description = "Color of Private messages you've received (transparent)",
            section = transparentSection)
    fun transparentPrivateMessageReceived(): Color?

    @ConfigItem(position = 56,
            keyName = "transparentPrivateMessageReceivedHighlight",
            name = "Received private messages highlight (transparent)",
            description = "Color of highlights in Private messages you've received (transparent)",
            section = transparentSection)
    fun transparentPrivateMessageReceivedHighlight(): Color? {
        return Color.decode("#FFFFFF")
    }

    //region transparent friends chat
    @ConfigItem(position = 57,
            keyName = "transparentFriendsChatInfo",
            name = "Friends chat info (transparent)",
            description = "Friends chat information (eg. when joining a channel) (transparent)",
            section = transparentSection)
    fun transparentFriendsChatInfo(): Color?

    @ConfigItem(position = 58,
            keyName = "transparentClanChatInfoHighlight",
            name = "Friends chat info highlight (transparent)",
            description = "Friends chat information highlight (used for the Raids plugin) (transparent)",
            section = transparentSection)
    fun transparentFriendsChatInfoHighlight(): Color? {
        return Color.RED
    }

    @ConfigItem(position = 59,
            keyName = "transparentClanChatMessage",
            name = "Friends chat message (transparent)",
            description = "Color of Friends chat messages (transparent)",
            section = transparentSection)
    fun transparentFriendsChatMessage(): Color?

    @ConfigItem(position = 60,
            keyName = "transparentClanChatMessageHighlight",
            name = "Friends chat message highlight (transparent)",
            description = "Color of highlights in Friends chat messages (transparent)",
            section = transparentSection)
    fun transparentFriendsChatMessageHighlight(): Color? {
        return Color.decode("#FFFFFF")
    }

    //endregion
    //region transparent clan chat
    @ConfigItem(position = 61,
            keyName = "transparentClanInfo",
            name = "Clan chat info (transparent)",
            description = "Clan Chat Information (eg. when joining a channel) (transparent)",
            section = transparentSection)
    fun transparentClanChatInfo(): Color?

    @ConfigItem(position = 62,
            keyName = "transparentClanInfoHighlight",
            name = "Clan chat info highlight (transparent)",
            description = "Clan Chat Information highlight (transparent)",
            section = transparentSection)
    fun transparentClanChatInfoHighlight(): Color? {
        return Color.RED
    }

    @ConfigItem(position = 63,
            keyName = "transparentClanMessage",
            name = "Clan chat message (transparent)",
            description = "Color of Clan chat messages (transparent)",
            section = transparentSection)
    fun transparentClanChatMessage(): Color?

    @ConfigItem(position = 64,
            keyName = "transparentClanMessageHighlight",
            name = "Clan chat message highlight (transparent)",
            description = "Color of highlights in Clan Chat messages (transparent)",
            section = transparentSection)
    fun transparentClanChatMessageHighlight(): Color? {
        return Color.decode("#FFFFFF")
    }

    @ConfigItem(position = 65,
            keyName = "transparentClanGuestInfo",
            name = "Guest Clan chat info (transparent)",
            description = "Guest Clan Chat Information (eg. when joining a channel) (transparent)",
            section = transparentSection)
    fun transparentClanChatGuestInfo(): Color?

    @ConfigItem(position = 66,
            keyName = "transparentClanGuestInfoHighlight",
            name = "Guest Clan chat info highlight (transparent)",
            description = "Guest Clan Chat Information highlight (transparent)",
            section = transparentSection)
    fun transparentClanChatGuestInfoHighlight(): Color? {
        return Color.RED
    }

    @ConfigItem(position = 67,
            keyName = "transparentClanGuestMessage",
            name = "Guest Clan chat message (transparent)",
            description = "Color of Guest Clan chat messages (transparent)",
            section = transparentSection)
    fun transparentClanChatGuestMessage(): Color?

    @ConfigItem(position = 68,
            keyName = "transparentClanChatGuestMessageHighlight",
            name = "Guest Clan chat message highlight (transparent)",
            description = "Color of highlights in Guest Clan Chat messages (transparent)",
            section = transparentSection)
    fun transparentClanChatGuestMessageHighlight(): Color? {
        return Color.decode("#FFFFFF")
    }

    //endregion
    @ConfigItem(position = 69,
            keyName = "transparentAutochatMessage",
            name = "Autochat (transparent)",
            description = "Color of Autochat messages (transparent)",
            section = transparentSection)
    fun transparentAutochatMessage(): Color?

    @ConfigItem(position = 70,
            keyName = "transparentAutochatMessageHighlight",
            name = "Autochat highlight (transparent)",
            description = "Color of highlights in Autochat messages (transparent)",
            section = transparentSection)
    fun transparentAutochatMessageHighlight(): Color?

    @ConfigItem(position = 71,
            keyName = "transparentTradeChatMessage",
            name = "Trade chat (transparent)",
            description = "Color of Trade Chat Messages (transparent)",
            section = transparentSection)
    fun transparentTradeChatMessage(): Color?

    @ConfigItem(position = 72,
            keyName = "transparentTradeChatMessageHighlight",
            name = "Trade chat highlight (transparent)",
            description = "Color of highlights in Trade Chat Messages (transparent)",
            section = transparentSection)
    fun transparentTradeChatMessageHighlight(): Color?

    @ConfigItem(position = 73,
            keyName = "transparentServerMessage",
            name = "Server message (transparent)",
            description = "Color of Server Messages (eg. 'Welcome to RuneScape') (transparent)",
            section = transparentSection)
    fun transparentServerMessage(): Color?

    @ConfigItem(position = 74,
            keyName = "transparentServerMessageHighlight",
            name = "Server message highlight (transparent)",
            description = "Color of highlights in Server Messages (transparent)",
            section = transparentSection)
    fun transparentServerMessageHighlight(): Color?

    @ConfigItem(position = 75,
            keyName = "transparentGameMessage",
            name = "Game message (transparent)",
            description = "Color of Game Messages (transparent)",
            section = transparentSection)
    fun transparentGameMessage(): Color?

    @ConfigItem(position = 76,
            keyName = "transparentGameMessageHighlight",
            name = "Game message highlight (transparent)",
            description = "Color of highlights in Game Messages (transparent)",
            section = transparentSection)
    fun transparentGameMessageHighlight(): Color? {
        return Color.decode("#EF1020")
    }

    @ConfigItem(position = 77,
            keyName = "transparentExamine",
            name = "Examine (transparent)",
            description = "Color of Examine Text (transparent)",
            section = transparentSection)
    fun transparentExamine(): Color?

    @ConfigItem(position = 78,
            keyName = "transparentExamineHighlight",
            name = "Examine highlight (transparent)",
            description = "Color of highlights in Examine Text (transparent)",
            section = transparentSection)
    fun transparentExamineHighlight(): Color? {
        return Color.GREEN
    }

    @ConfigItem(position = 79,
            keyName = "transparentFiltered",
            name = "Filtered (transparent)",
            description = "Color of Filtered Text (messages that aren't shown when Game messages are filtered) (transparent)",
            section = transparentSection)
    fun transparentFiltered(): Color?

    @ConfigItem(position = 80,
            keyName = "transparentFilteredHighlight",
            name = "Filtered highlight (transparent)",
            description = "Color of highlights in Filtered Text (transparent)",
            section = transparentSection)
    fun transparentFilteredHighlight(): Color?

    @ConfigItem(position = 81,
            keyName = "transparentUsername",
            name = "Usernames (transparent)",
            description = "Color of Usernames (transparent)",
            section = transparentSection)
    fun transparentUsername(): Color?

    @ConfigItem(position = 82,
            keyName = "transparentPrivateUsernames",
            name = "Private chat usernames (transparent)",
            description = "Color of Usernames in Private Chat (transparent)",
            section = transparentSection)
    fun transparentPrivateUsernames(): Color?

    @ConfigItem(position = 83,
            keyName = "transparentClanChannelName",
            name = "Friends Chat channel name (transparent)",
            description = "Color of Friends chat channel name (transparent)",
            section = transparentSection)
    fun transparentFriendsChatChannelName(): Color?

    @ConfigItem(position = 84,
            keyName = "transparentClanChatChannelName",
            name = "Clan Chat channel name (transparent)",
            description = "Color of Clan chat channel name (transparent)",
            section = transparentSection)
    fun transparentClanChannelName(): Color?

    @ConfigItem(position = 85,
            keyName = "transparentClanChatGuestChannelName",
            name = "Guest Clan Chat channel name (transparent)",
            description = "Color of Guest clan chat channel name (transparent)",
            section = transparentSection)
    fun transparentClanChannelGuestName(): Color?

    @ConfigItem(position = 86,
            keyName = "transparentClanUsernames",
            name = "Friends chat usernames (transparent)",
            description = "Color of usernames in Friends chat (transparent)",
            section = transparentSection)
    fun transparentFriendsChatUsernames(): Color?

    @ConfigItem(position = 87,
            keyName = "transparentClanClanUsernames",
            name = "Clan chat usernames (transparent)",
            description = "Color of usernames in Clan chat (transparent)",
            section = transparentSection)
    fun transparentClanChatUsernames(): Color?

    @ConfigItem(position = 88,
            keyName = "transparentClanClanGuestUsernames",
            name = "Guest Clan chat usernames (transparent)",
            description = "Color of usernames in Guest Clan chat (transparent)",
            section = transparentSection)
    fun transparentClanChatGuestUsernames(): Color?

    @ConfigItem(position = 89,
            keyName = "transparentPublicFriendUsernames",
            name = "Public friend usernames (transparent)",
            description = "Color of Friend Usernames in Public Chat (transparent)",
            section = transparentSection)
    fun transparentPublicFriendUsernames(): Color?

    @ConfigItem(position = 90,
            keyName = "transparentPlayerUsername",
            name = "Your username (transparent)",
            description = "Color of your username (transparent)",
            section = transparentSection)
    fun transparentPlayerUsername(): Color?

    companion object {
        @ConfigSection(name = "Opaque",
                description = "The options that control the colours for the Opaque Chatbox",
                position = 0,
                closedByDefault = true)
        const val opaqueSection = "opaqueSection"

        @ConfigSection(name = "Transparent",
                description = "The options that control the colours for the Transparent Chatbox",
                position = 50,
                closedByDefault = true)
        const val transparentSection = "transparentSection"
    }
}