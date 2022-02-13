package meteor.api

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor

@PluginDescriptor(
    name = "Api Test",
    enabledByDefault = true
)
class ApiTestPlugin : Plugin() {
    val overlay = overlay(ApiTestOverlay(this))
}