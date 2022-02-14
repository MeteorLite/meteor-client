package meteor.plugins.agilitybot

import meteor.Logger
import meteor.api.entities.Loot
import meteor.api.entities.Objects
import meteor.api.entities.Players
import meteor.api.widgets.Dialog
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Player
import net.runelite.api.TileItem
import net.runelite.api.TileObject
import org.rationalityfrontline.kevent.Event

@PluginDescriptor(name = "AgilityBot", enabledByDefault = false)
class AgilityBotPlugin : Plugin() {

    override val config= configuration<AgilityBotConfig>()
    val log: Logger = Logger.getLogger(this.javaClass)
    private var course: Course? = null
    override fun onStart() {
        course = if (course == Course.NEAREST) {
            Course.nearest
        } else {
            config.course()
        }
    }

    override fun onGameTick(): ((Event<eventbus.events.GameTick>) -> Unit) = {
        GameTick()
    }
    private fun GameTick() {
        if (Dialog.canContinue()) {
            Dialog.continueSpace()
            return
        }
        val local: Player = Players.local
        val obstacle = course?.getNext(local)
        if (obstacle == null) {
            log.error("No obstacle detected")
            return
        }
        val obs: TileObject? =
            if (obstacle.id != 0) Objects.getNearest(obstacle.id) else Objects.getNearest { x ->
                x!!.hasAction(obstacle.action) && x.name.equals(obstacle.name)
            }

        val mark: TileItem? = Loot.getNearest("Mark of grace")
        if (mark != null && obstacle.area.contains(mark.tile)) {
            mark.pickup()
            return
        }
        if (obs != null) {
            if (local.animation != -1 || local.isMoving) {
                return
            }
            obs.interact(obstacle.action)
            log.info("interacting with obj ${obstacle.action}")
            return
        }
        log.error("Obstacle was null")
    }

}