package meteor.api

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor

@PluginDescriptor(
    name = "Api Test",
    enabledByDefault = false
)
class ApiTestPlugin : Plugin() {
    val overlay = overlay(ApiTestOverlay(this))
    val itemOverlay = overlay(ApiTestOverlay.ItemTestOverlay())
}