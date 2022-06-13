package meteor.plugins.autorun

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.MenuAction
import net.runelite.api.widgets.WidgetInfo
import java.util.*

@PluginDescriptor(name = "AutoRun", description = "Automatically enables run.", enabledByDefault = true)

class AutoRun : Plugin() {
    override val config = configuration<AutoRunConfig>()
    private val clientThread: ClientThread = ClientThread
    private val rand = Random()
    private var nextRunThreshhold = -1


/*
    override fun onGameTick(): ((Event<eventbus.events.GameTick>) -> Unit) = {
        if (nextRunThreshhold <= 0) nextRunThreshhold = randInt(config.minRun(), config.maxRun()) else {
            if (!isRunning && client.energy > nextRunThreshhold) {
                toggleRun()
                nextRunThreshhold = -1
            }
        }
    }*/

    val isRunning: Boolean
        get() = client.getVarpValue(173) == 1

    private fun toggleRun() {
        val runOrb = client.getWidget(WidgetInfo.MINIMAP_TOGGLE_RUN_ORB)
        clientThread.invokeLater {
            client.invokeMenuAction("", "", 1, MenuAction.CC_OP.id, -1, runOrb!!.id)
        }
    }

    fun randInt(r: Random, min: Int, max: Int): Int {
        return r.nextInt(max - min + 1) + min
    }

    fun randInt(min: Int, max: Int): Int {
        var max = max
        if (max < min) max = min
        return randInt(rand, min, max)
    }
}