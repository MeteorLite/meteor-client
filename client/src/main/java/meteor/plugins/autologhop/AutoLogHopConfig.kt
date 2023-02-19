package meteor.plugins.autologhop

import meteor.config.legacy.*

@ConfigGroup("autologhop")
interface AutoLogHopConfig : Config {
    @ConfigItem(
        keyName = "method",
        name = "Method",
        description = "Logout = log out (0 tick), hop = hop worlds (1 tick), log then hop = logout and hop worlds from client screen (0 tick)",
        position = 10,
        section = "AutoLogHop"
    )
    fun method(): Method {
        return Method.LOGOUT_HOP
    }

    @ConfigItem(
        keyName = "teleMethod",
        name = "Teleport Method",
        description = "Logout = log out (0 tick), hop = hop worlds (1 tick), log then hop = logout and hop worlds from client screen (0 tick)",
        position = 11,
        section = "AutoLogHop",
        hidden = true,

    )
    fun teleMethod(): TeleportType? {
        return TeleportType.ROYAL_SEED_POD
    }

    @ConfigItem(
        keyName = "username",
        name = "username",
        description = "Username for login",
        position = 12,
        section = "AutoLogHop",
        textField = true
    )
    fun user(): String {
        return ""
    }

    @Secret
    @ConfigItem(
        keyName = "password",
        name = "password",
        description = "Password for login",
        position = 13,
        section = "AutoLogHop",
        textField = true
    )
    fun password(): String {
        return ""
    }

    @ConfigItem(
        keyName = "disableWildyChecks",
        name = "Disable Wilderness Checks",
        description = "Disable wilderness checks. Makes plugin work everywhere.",
        position = 14,
        section = "AutoLogHop"
    )
    fun disableWildyChecks(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "whitelist",
        name = "Whitelist",
        description = "Players to ignore - separate with , and don't leave leading/trailing spaces",
        position = 15,
        section = "AutoLogHop"
    )
    fun whitelist(): String {
        return ""
    }

    @ConfigItem(
        keyName = "membersWorlds",
        name = "Members Worlds",
        description = "Hop to members worlds.",
        position = 16,
        section = "AutoLogHop"
    )
    fun membersWorlds(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "combatRange",
        name = "Within combat range",
        description = "Will only consider players within combat level bracket of wilderness level",
        position = 18,
        section = "AutoLogHop"
    )
    fun combatRange(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "skulledOnly",
        name = "Skulled Players Only",
        description = "Only triggers on skulled players.",
        position = 20,
        section = "AutoLogHop"
    )
    fun skulledOnly(): Boolean {
        return false
    }


    @ConfigSection(keyName = "title", name = "AutoLogHop", description = "", position = 0)
    val AutoLogHop: String

}