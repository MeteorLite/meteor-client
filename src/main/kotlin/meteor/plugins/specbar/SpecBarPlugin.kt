package meteor.plugins.specbar

import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.widgets.WidgetID
import org.rationalityfrontline.kevent.Event

@PluginDescriptor(
    name = "Spec Bar",
    description = "Adds a permanent spec bar",
    tags = ["spec", "bar", "permanent"],
    enabledByDefault = false
)
class SpecBarPlugin : Plugin() {
    override fun onClientTick(): ((Event<eventbus.events.ClientTick>) -> Unit) = {
        client.getWidget(WidgetID.COMBAT_GROUP_ID, 35)?.let { it.isHidden = false }
    }
}
