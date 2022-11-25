package meteor.plugins.meteor

import com.formdev.flatlaf.FlatLaf
import eventbus.events.ConfigChanged
import meteor.Configuration

import meteor.config.ConfigManager
import meteor.config.MeteorConfig
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.themes.MeteorliteTheme
import java.awt.Color

@PluginDescriptor(name = "Meteor", enabledByDefault = true)
class Meteor : Plugin() {
    var config = configuration<MeteorConfig>()


    override fun onConfigChanged(it: ConfigChanged) {
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