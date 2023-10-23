package meteor.plugins.devtools

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.devtools.overlays.CameraOverlay
import meteor.plugins.devtools.overlays.LocationOverlay
import meteor.plugins.devtools.overlays.ModelsOverlay

@PluginDescriptor(name = "Dev Tools")
class DevToolsPlugin : Plugin() {
    var config = configuration<DevToolsConfig>()
    val locationOverlay = overlay(LocationOverlay(config))
    val cameraOverlay = overlay(CameraOverlay(config))
    val modelsOverlay = overlay(ModelsOverlay(config))
}