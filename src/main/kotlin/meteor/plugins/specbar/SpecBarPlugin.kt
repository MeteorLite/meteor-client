package meteor.plugins.specbar

import eventbus.events.ClientTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.widgets.WidgetID

@PluginDescriptor(
    name = "Spec Bar",
    description = "Adds a permanent spec bar",
    tags = ["spec", "bar", "permanent"],
    enabledByDefault = false
)
class SpecBarPlugin : Plugin() {
    override fun onClientTick(it: ClientTick) {
        client.getWidget(WidgetID.COMBAT_GROUP_ID, 35)?.let { it.isHidden = false }
    }
}
