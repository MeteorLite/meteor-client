package meteor.plugins.prayerflicker

import dev.hoot.api.packets.WidgetPackets
import dev.hoot.api.widgets.Prayers
import dev.hoot.api.widgets.Widgets
import eventbus.events.ClientTick
import eventbus.events.GameTick
import eventbus.events.MenuOptionClicked
import meteor.api.packets.ClientPackets
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.ColorUtil.wrapWithColorTag
import net.runelite.api.GameState
import net.runelite.api.MenuAction
import net.runelite.api.Varbits
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color

@PluginDescriptor(name = "Prayer Flicker", description = "prayer flicker for quick prayers", enabledByDefault = false)
class PrayerFlickerPlugin : Plugin() {

    var toggle = false

    private val quickPrayerWidgetID = WidgetInfo.MINIMAP_QUICK_PRAYER_ORB

    private fun togglePrayer() {

                WidgetPackets.widgetAction(Widgets.get(quickPrayerWidgetID), "Activate")
                ClientPackets.queueClickPacket(0, 0)

                WidgetPackets.widgetAction(Widgets.get(quickPrayerWidgetID), "Deactivate")
                ClientPackets.queueClickPacket(0, 0)


    }

    override fun onStart() {

        toggle = true

    }

    override fun onStop() {

        toggle = false

    }

    override fun onGameTick(it: GameTick) {
        if (client.gameState != GameState.LOGGED_IN) {
            return
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
        if (client.gameState != GameState.LOGGED_IN) {
            return
        }
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