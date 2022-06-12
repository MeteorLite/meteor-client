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
import java.lang.RuntimeException

enum class Method( val logout: String) {
    LOGOUT("Logout"), HOP("Hop"), LOGOUT_HOP("Logout, Hop"), TELEPORT("Teleport");

}