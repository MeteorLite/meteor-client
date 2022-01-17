package meteor.plugins.devtools

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.agility.AgilityOverlay
import meteor.ui.OverlayManager

@PluginDescriptor(name = "Dev Tools", enabledByDefault = false, description = "")
class DevToolsPlugin : Plugin() {
    override var config = configuration<DevToolsConfig>()
    var overlay = overlay<DevToolsOverlay>(DevToolsOverlay(this))

    var overlayManager = OverlayManager

   override fun onStart() {
        overlayManager.add(overlay)

    }

    override fun onStop() {
        overlayManager.remove(overlay)
    }
}