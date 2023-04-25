package meteor.plugins.disablerenderer

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Client
import net.runelite.api.hooks.DrawCallbacks
import javax.inject.Inject

@PluginDescriptor(
    name = "Disable renderer",
    description = "",
    enabledByDefault = false
)
class DisableRenderingPlugin : Plugin() {


    private var originalDrawCallbacks: DrawCallbacks? = null

    override fun onStart() {
        originalDrawCallbacks = client.drawCallbacks
        client.drawCallbacks = DisableRenderCallbacks()
    }

    override fun onStop() {
        client.drawCallbacks = originalDrawCallbacks
        originalDrawCallbacks = null
    }
}