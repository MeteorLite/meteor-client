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


    override fun onClientTick(): ((Event<eventbus.events.ClientTick>) -> Unit)= {
        val specbarWidget = client!!.getWidget(WidgetID.COMBAT_GROUP_ID, 35)
        if (specbarWidget != null) {
            specbarWidget.isHidden = false
        }

    }



        }
