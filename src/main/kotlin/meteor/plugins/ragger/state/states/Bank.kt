package meteor.plugins.ragger.state.states

import meteor.plugins.ragger.RaggerPlugin
import meteor.plugins.ragger.state.State

class CheckInventoryEquipment(val raggerPlugin: RaggerPlugin) : State() {

    override fun isValid(): Boolean {
        if (raggerPlugin.regionID != -1)
            if ()
    }
}