package meteor.plugins.autologhop

import meteor.config.ConfigManager.getConfig
import meteor.game.WorldService.getWorlds
import meteor.plugins.PluginDescriptor
import java.util.concurrent.ExecutorService
import meteor.ui.overlay.OverlayManager
import meteor.plugins.autologhop.AutoLogHopConfig
import meteor.game.WorldService
import meteor.config.ConfigManager
import net.runelite.api.GameState
import java.lang.Runnable
import java.util.function.BooleanSupplier
import dev.hoot.api.game.Game
import meteor.plugins.autologhop.AutoLogHop
import net.runelite.api.Player
import net.runelite.api.widgets.WidgetInfo
import net.runelite.api.ItemContainer
import net.runelite.api.InventoryID
import dev.hoot.api.packets.MousePackets
import dev.hoot.api.packets.WidgetPackets
import net.runelite.http.api.worlds.WorldResult
import java.util.Collections
import dev.hoot.api.game.Worlds
import java.util.concurrent.ThreadLocalRandom
import java.lang.InterruptedException
import net.runelite.api.MenuAction
import net.runelite.api.Varbits
import net.runelite.api.SkullIcon
import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem
import net.runelite.client.config.ConfigSection
import java.lang.RuntimeException

@ConfigGroup("autologhop")
interface AutoLogHopConfig : Config {
    @ConfigItem(
        keyName = "method",
        name = "Method",
        description = "Logout = log out (0 tick), hop = hop worlds (1 tick), log then hop = logout and hop worlds from client screen (0 tick)",
        position = 10,
        section = title
    )
    fun method(): Method {
        return Method.LOGOUT_HOP
    }

    @ConfigItem(
        keyName = "teleMethod",
        name = "Teleport Method",
        description = "Logout = log out (0 tick), hop = hop worlds (1 tick), log then hop = logout and hop worlds from client screen (0 tick)",
        position = 11,
        section = title,
        hidden = true,
        unhide = "method",
        unhideValue = "TELEPORT"
    )
    fun teleMethod(): TeleportType? {
        return TeleportType.ROYAL_SEED_POD
    }

    @ConfigItem(
        keyName = "username",
        name = "username",
        description = "Username for login",
        position = 12,
        section = title,
        textField = true
    )
    fun user(): String {
        return ""
    }

    @ConfigItem(
        keyName = "password",
        name = "password",
        description = "Password for login",
        position = 13,
        section = title,
        textField = true,
        secret = true
    )
    fun password(): String {
        return ""
    }

    @ConfigItem(
        keyName = "disableWildyChecks",
        name = "Disable Wilderness Checks",
        description = "Disable wilderness checks. Makes plugin work everywhere.",
        position = 14,
        section = title
    )
    fun disableWildyChecks(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "whitelist",
        name = "Whitelist",
        description = "Players to ignore - separate with , and don't leave leading/trailing spaces",
        position = 15,
        section = title
    )
    fun whitelist(): String {
        return ""
    }

    @ConfigItem(
        keyName = "membersWorlds",
        name = "Members Worlds",
        description = "Hop to members worlds.",
        position = 16,
        section = title
    )
    fun membersWorlds(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "combatRange",
        name = "Within combat range",
        description = "Will only consider players within combat level bracket of wilderness level",
        position = 18,
        section = title
    )
    fun combatRange(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "skulledOnly",
        name = "Skulled Players Only",
        description = "Only triggers on skulled players.",
        position = 20,
        section = title
    )
    fun skulledOnly(): Boolean {
        return false
    }

    companion object {
        @ConfigSection(keyName = "title", name = "Soxs' AutoLogHop", description = "", position = 0)
        const val title = "Soxs' AutoLogHop"
    }
}