package meteor.plugins.thieving

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor

@PluginDescriptor(name = "Thieving", enabledByDefault = true)
class ThievingPlugin : Plugin() {
    var config = configuration<ThievingConfig>()
    val overlay = overlay(ThievingOverlay(config))
}