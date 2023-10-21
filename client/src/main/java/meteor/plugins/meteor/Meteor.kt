package meteor.plugins.meteor

import com.formdev.flatlaf.FlatLaf
import eventbus.events.ConfigChanged

import meteor.Configuration
import meteor.Logger
import meteor.Main

import meteor.config.ConfigManager

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.themes.MeteorliteTheme
import openrsc.constants.ItemID
import openrsc.constants.ObjectID
import openrsc.skills.woodcutting.WoodcuttingDefinition

import java.awt.Color
import java.awt.Point
import java.awt.Rectangle
import kotlin.system.exitProcess

@PluginDescriptor(name = "Meteor", enabledByDefault = true, disabledOnStartup = false)
class Meteor : Plugin() {
    var config = configuration<MeteorConfig>()
    val log = Logger("Meteor")

    private fun clickInsideMinimap(point: Point): Boolean {
        val minimap = minimap
        if (minimap.contains(point)) {
            log.debug("Click {} was inside minimap", point)
            return true
        }
        return false
    }

    private val minimap: Rectangle
        get() {
/*            val minimap = Widgets.get(WidgetInfo.FIXED_VIEWPORT_MINIMAP_DRAW_AREA)
            if (Widgets.isVisible(minimap)) {
                return minimap.bounds
            }
            val minimap1 = Widgets.get(WidgetInfo.RESIZABLE_MINIMAP_DRAW_AREA)
            if (Widgets.isVisible(minimap1)) {
                return minimap1.bounds
            }
            val minimap2 = Widgets.get(WidgetInfo.RESIZABLE_MINIMAP_STONES_DRAW_AREA)
            if (Widgets.isVisible(minimap2)) {
                return minimap2.bounds
            }
            val bounds = client.canvas.bounds
            return Rectangle(bounds.width - MINIMAP_WIDTH, 0, MINIMAP_WIDTH, MINIMAP_HEIGHT)*/
            return Rectangle()
        }

/*    private fun interactReady(): Boolean {
        return client.pendingAutomation == null
    }*/

    private val MINIMAP_WIDTH = 250
    private val MINIMAP_HEIGHT = 180


    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == Configuration.MASTER_GROUP) {
            when(it.key) {
                "alwaysOnTop" -> {
                    Main.window!!.window.isAlwaysOnTop = config.alwaysOnTop()
                }
                "lockWindowSize" -> {
                    Main.window!!.window.isResizable = !config.lockWindowSize()
                    if (config.lockWindowSize()) {
                        val lockedSize = Main.window!!.window.size
                        val lockedSizeString = "${lockedSize.width}:${lockedSize.height}"

                        ConfigManager.setConfiguration(Configuration.MASTER_GROUP, "lockedWindowSize", lockedSizeString)

                        Main.window!!.window.size = lockedSize
                    }
                }
            }
        }

        when {
            !config.theme() && it.key == "Light theme/Dark theme" -> {

                ConfigManager.setConfiguration(Configuration.MASTER_GROUP,"MeteorColor", Color.BLACK)
                MeteorliteTheme.installLight()
                FlatLaf.updateUI()
            }
            config.theme() && it.key == "Light theme/Dark theme" -> {

                MeteorliteTheme.installDark()
                FlatLaf.updateUI()
                ConfigManager.setConfiguration(Configuration.MASTER_GROUP,"MeteorColor", Color.CYAN)
            }
        }
    }
}