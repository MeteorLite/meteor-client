package meteor.plugins.autoeater

import eventbus.events.ConfigChanged
import eventbus.events.GameTick
import meteor.api.items.Items
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import java.util.*


@PluginDescriptor(name = "Auto eater", description = "Automatically eats food for you", enabledByDefault = false)
class AutoEaterPlugin() : Plugin() {
    private var config = configuration<AutoEaterConfig>()

    private val r = Random()
    private var nextEatVal = 0

    private fun getEatVal(): Int {
        return r.nextInt((config.maxHp() - config.minHp()).coerceAtLeast(1)) + config.minHp()
    }

    override fun onStart() {
        nextEatVal = getEatVal()
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group != "autoeater") {
            return
        }
        nextEatVal = getEatVal()
    }

    private var ticktimer = 0
    override fun onGameTick(it: GameTick) {
        if (client.gameState != GameState.LOGGED_IN) {
            return
        }

        if (ticktimer > 0) {
            ticktimer--
            return
        }

        val currentHp = client.getBoostedSkillLevel(Skill.HITPOINTS)
        if (currentHp <= nextEatVal) {
            val foodNames = config.foodNamesToEat().split(",").map { it.trim() }.toTypedArray()
            val foodIds = config.foodIdsToEat().split(",").map {
                val trimmedVal = it.trim()
                val numericVal = Regex("[^0-9]").replace(trimmedVal, "")
                Integer.parseInt(numericVal)
            }.toIntArray()
            val foundFood = Items.getFirst(*foodNames) ?: Items.getFirst(*foodIds)
            if (foundFood != null) {
                val interactActions = foundFood.actions
                if (interactActions?.contains("Eat") == true) {
                    foundFood.interact("Eat")
                } else if (interactActions?.contains("Drink") == true) {
                    foundFood.interact("Drink")
                }
            }
            nextEatVal = getEatVal()
            ticktimer = 2
        }
    }
}
