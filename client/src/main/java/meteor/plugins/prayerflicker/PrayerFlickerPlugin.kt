package meteor.plugins.prayerflicker

import dev.hoot.api.game.Game
import dev.hoot.api.packets.WidgetPackets
import dev.hoot.api.widgets.Prayers
import dev.hoot.api.widgets.Widgets
import eventbus.events.ClientTick
import eventbus.events.GameTick
import eventbus.events.MenuOptionClicked
import meteor.api.queueClickPacket
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.ColorUtil.wrapWithColorTag
import meteor.util.HotkeyListener
import net.runelite.api.GameState
import net.runelite.api.MenuAction
import net.runelite.api.Varbits
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color
import java.awt.Point


@PluginDescriptor(name = "Prayer Flicker", description = "prayer flicker for quick prayers", enabledByDefault = false)
class PrayerFlickerPlugin : Plugin() {

    var toggle = false
    val config = configuration<PrayerFlickerConfig>()
    lateinit var clickPoint: Point

    private val quickPrayerWidgetID = WidgetInfo.MINIMAP_QUICK_PRAYER_ORB

    private fun togglePrayer() {
        val quickPrayerOrb = Widgets.get(quickPrayerWidgetID)
        if (!this::clickPoint.isInitialized)
            clickPoint = quickPrayerOrb.clickPoint
        queueClickPacket(clickPoint)
        WidgetPackets.widgetAction(quickPrayerOrb, "Activate")
        queueClickPacket(clickPoint)
        WidgetPackets.widgetAction(quickPrayerOrb, "Deactivate")
    }

    override fun onStart() {
        KeyManager.registerKeyListener(hotkeyListener, this.javaClass)
    }

    override fun onStop() {
        KeyManager.unregisterKeyListener(hotkeyListener)
        toggle = false
    }

    private val hotkeyListener: HotkeyListener = object : HotkeyListener({ config.toggle() }) {
        override fun hotkeyPressed() {
            toggle = !toggle

            if (!toggle){
                toggleFlicker(false)
            }
        }
    }
    override fun onGameTick(it: GameTick) {
        if(Game.getState() == GameState.LOGGED_IN && client.localPlayer != null)
        if (Prayers.getPoints() == 0){
            toggle = false
        }

        if (toggle) {
            val quickPrayer = client.getVarbitValue(Varbits.QUICK_PRAYER) == 1
            if (quickPrayer) {

                togglePrayer()
            }
            togglePrayer()
        }
    }


    fun toggleFlicker(on: Boolean) {
        toggle = on

        if (!toggle) {
            ClientThread.invoke {
                if (Prayers.isQuickPrayerEnabled()) {
                    togglePrayer()
                }
            }
        }
    }


    override fun onClientTick(it: ClientTick) {
        val menuEntries = client.menuEntries
        for (entry in menuEntries) {
            if (entry.param1 == quickPrayerWidgetID.packedId) {
                addMenuEntry()
                return
            }
        }
    }

    var target = wrapWithColorTag("Prayer Flicker", Color.GREEN)
    private fun addMenuEntry() {
        //Stop action takes priority via opcode
        val action: String
        val opcode: Int
        if (toggle) {
            action = "Stop"
            opcode = MenuAction.UNKNOWN.id
        } else {
            action = "Start"
            opcode = MenuAction.RUNELITE.id
        }
        client.insertMenuItem(
            action,
            target,
            opcode,
            1,
            -1,
            -1,
            false
        )
    }


    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if ((it.getMenuAction() == MenuAction.RUNELITE || it.getMenuAction() == MenuAction.UNKNOWN) && it.getMenuTarget() == target) {
            if (it.getMenuOption() == "Start") {
                toggleFlicker(true)
            }
            if (it.getMenuOption() == "Stop") {
                toggleFlicker(false)
            }
            it.consume()
        }
    }
}