package meteor.api.game

import Main.client
import meteor.api.movement.pathfinder.GlobalCollisionMap
import meteor.api.movement.pathfinder.RegionManager
import meteor.api.widgets.Tab
import meteor.api.widgets.Tabs
import meteor.api.widgets.Widgets
import net.runelite.api.GameState
import net.runelite.api.packets.ClientPacket
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.io.ByteArrayInputStream
import java.net.URL
import java.util.zip.GZIPInputStream


object Game {
    private const val MEMBER_DAYS_VARP = 1780
    private const val CUTSCENE_VARBIT = 542
    private const val LOGOUT_ACTION = "Logout"

    val clientPacket: ClientPacket? = null
    val regions = URL(RegionManager.API_URL + "/regions").openStream()
    val globalCollisionMap = GlobalCollisionMap(GZIPInputStream(ByteArrayInputStream(regions.readAllBytes())).readAllBytes())

    val isLoggedIn: Boolean
        get() = state == GameState.LOGGED_IN || state == GameState.LOADING
    val isOnLoginScreen: Boolean
        get() = (state == GameState.LOGIN_SCREEN
                || state == GameState.LOGIN_SCREEN_AUTHENTICATOR)
    val state: GameState
        get() = client!!.gameState

    // Dmm
    val wildyLevel: Int
        get() {
            val wildyLevelWidget: Widget? = Widgets.get(WidgetInfo.PVP_WILDERNESS_LEVEL)
            if (wildyLevelWidget == null || GameThread.invokeLater { wildyLevelWidget.isHidden }!!) {
                return 0
            }

            // Dmm
            if (wildyLevelWidget.text.contains("Guarded")
                || wildyLevelWidget.text.contains("Protection")
            ) {
                return 0
            }
            return if (wildyLevelWidget.text.contains("Deadman")) {
                Int.MAX_VALUE
            } else wildyLevelWidget.text.replace("Level: ", "").toInt()
        }
    val membershipDays: Int
        get() = Vars.getVarp(MEMBER_DAYS_VARP)
    val isInCutscene: Boolean
        get() = Vars.getBit(CUTSCENE_VARBIT)!! > 0

    fun logout() {
        val logOutHopper: Widget? = Widgets.get(WidgetID.WORLD_SWITCHER_GROUP_ID) { x -> x!!.hasAction(LOGOUT_ACTION) }
        if (logOutHopper != null) {
            logOutHopper.interact(LOGOUT_ACTION)
            return
        }
        val logOut: Widget? = Widgets.get(WidgetID.LOGOUT_PANEL_ID) { x -> x!!.hasAction(LOGOUT_ACTION) }
        if (logOut != null) {
            logOut.interact(LOGOUT_ACTION)
            return
        }
        if (!Tabs.isOpen(Tab.LOG_OUT)) {
            Tabs.open(Tab.LOG_OUT)
        }
    }
}