package meteor.plugins.olmswapper

import dev.hoot.api.widgets.Prayers
import eventbus.events.ChatMessage
import eventbus.events.GameTick
import eventbus.events.ProjectileMoved
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Prayer

@PluginDescriptor(name = "Olm Swapper",disabledOnStartup = true, enabledByDefault = false)
class OlmSwapperPlugin: Plugin() {
    var mage = "the great olm fires a sphere of magical power your way"
    var range = "the great olm fires a sphere of accuracy and dexterity your way"
    var melee = "the great olm fires a sphere of aggression your way"

    var swapMage = false
    var swapRange = false
    var swapMelee = false

    override fun onChatMessage(it: ChatMessage) {
        when (it.message) {
            in mage -> swapMage = true
            in range -> swapRange = true
            in melee -> swapMelee = true
        }
    }

    override fun onProjectileMoved(it: ProjectileMoved) {
       when(it.projectile.id){
           1339,1594 -> if (!client.isPrayerActive(Prayer.PROTECT_FROM_MAGIC)) swapMage = true
           1340,1593 -> if (!client.isPrayerActive(Prayer.PROTECT_FROM_MISSILES)) swapRange = true
       }
    }

    override fun onGameTick(it: GameTick){
        when {
            swapMage ->{
                Prayers.toggle(Prayer.PROTECT_FROM_MAGIC)
                swapMage = false
            }
            swapRange ->{
                Prayers.toggle(Prayer.PROTECT_FROM_MISSILES)
                swapRange = false
            }
            swapMelee ->{
                Prayers.toggle(Prayer.PROTECT_FROM_MELEE)
                swapMelee = false
            }
        }
    }
}