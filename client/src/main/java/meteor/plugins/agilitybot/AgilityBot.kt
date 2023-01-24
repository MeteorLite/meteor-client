package meteor.plugins.agilitybot

import dev.hoot.api.commons.Rand
import dev.hoot.api.movement.Movement
import dev.hoot.api.widgets.Dialog
import eventbus.events.GameTick
import meteor.Logger
import meteor.api.Loots
import meteor.api.Objects
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.GameState

@PluginDescriptor(name = "Agility Bot", enabledByDefault = false)
class AgilityBot : Plugin() {

    val config = configuration<AgilityConfig>()


    private val log = Logger("Agility Plugin")
    private var course: Course? = null

    override fun onStart() {
        getCourse()
    }

    fun getCourse() {
        if (client.gameState == GameState.LOGGED_IN) {
            course = if (course == Course.NEAREST) {
                Course.nearest
            } else {
                config.course()
            }
        }
    }

    override fun onGameTick(it: GameTick) {
        if (course == null) {
            getCourse()
        }
        if (Dialog.canContinue()) {
            Dialog.continueSpace()
            return
        }
        val local = client.localPlayer!!
        val obstacle = course?.getNext(local) ?: return
        val obs = if (obstacle.id != 0) Objects.getFirst(obstacle.id)
        else Objects.getAll(obstacle.name)?.firstOrNull { it.hasAction(obstacle.action) }

        if(Loots.exists("Mark of grace")){
            Loots.getFirst("Mark of grace")?.interact("Take")
        }

        if (client.energy > Rand.nextInt(5, 55) && !Movement.isRunEnabled()) {
            Movement.toggleRun()
            return
        }

        if (obs != null) {
            if (local.animation != -1 || local.isMoving) {
                return
            }
            obs.interact(obstacle.action)
            return
        }
        log.error("Obstacle was null")
    }

}