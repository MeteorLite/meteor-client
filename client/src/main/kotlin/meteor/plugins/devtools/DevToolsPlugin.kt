package meteor.plugins.devtools

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor

@PluginDescriptor(name = "Dev Tools", enabledByDefault = false, description = "")
class DevToolsPlugin : Plugin() {
    // Gets config from ConfigManager, and returns the proper type for accessing
    var config = configuration<DevToolsConfig>()

    // Adds passed overlay to list, which is added/removed on plugin start/stop. Can be called repetitively
    var overlay = overlay(DevToolsOverlay(this))
}