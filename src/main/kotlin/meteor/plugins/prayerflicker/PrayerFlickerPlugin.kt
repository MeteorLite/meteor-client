package meteor.plugins.prayerflicker

import dev.hoot.api.packets.MousePackets
import dev.hoot.api.widgets.Prayers
import eventbus.events.ClientTick
import eventbus.events.GameTick
import eventbus.events.MenuOptionClicked
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.ColorUtil.wrapWithColorTag
import net.runelite.api.GameState
import net.runelite.api.MenuAction
import net.runelite.api.Varbits
import net.runelite.api.mixins.Inject
import net.runelite.api.widgets.WidgetInfo
import java.awt.Color

@PluginDescriptor(name = "Prayer Flicker", description = "prayer flicker for quick prayers", enabledByDefault = false)
class PrayerFlickerPlugin : Plugin() {

    var toggle = false

    @Inject
    private val clientThread: ClientThread? = null

    @Inject
    private val keyManager: KeyManager? = null

    private val quickPrayerWidgetID = WidgetInfo.MINIMAP_QUICK_PRAYER_ORB.packedId


    private fun togglePrayer() {
        MousePackets.queueClickPacket(0, 0)
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
            val quickPrayer = client.getVar(Varbits.QUICK_PRAYER) === 1
            if (quickPrayer) {
                togglePrayer()
            }
            togglePrayer()
        }
    }


    fun toggleFlicker() {
        toggle = !toggle
        if (client.gameState != GameState.LOGGED_IN) {
            return
        }
        if (!toggle) {
            clientThread!!.invoke {
                if (Prayers.isQuickPrayerEnabled()) {
                    togglePrayer()
                }
            }
        }
    }

    fun toggleFlicker(on: Boolean) {
        toggle = on
        if (client.gameState != GameState.LOGGED_IN) {
            return
        }
        if (!toggle) {
            clientThread!!.invoke {
                if (Prayers.isQuickPrayerEnabled()) {
                    togglePrayer()
                }
            }
        }
    }


    override fun onClientTick(it: ClientTick) {
        val menuEntries = client.menuEntries
        for (entry in menuEntries) {
            if (entry.actionParam1 == quickPrayerWidgetID) {
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