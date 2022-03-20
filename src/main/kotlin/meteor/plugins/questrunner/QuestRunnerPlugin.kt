package meteor.plugins.questrunner

import eventbus.events.GameStateChanged
import eventbus.events.GameTick
import meteor.api.movement.Movement
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.questrunner.cooksassistant.CooksAssistantRunner
import meteor.plugins.questrunner.overlay.PathOverlay
import meteor.plugins.questrunner.overlay.StatusOverlay
import net.runelite.api.GameState
import net.runelite.api.coords.WorldPoint

@PluginDescriptor(name = "Quest Runner", description = "", enabledByDefault = false)
class QuestRunnerPlugin: Plugin() {

    companion object {
        var lastGameState: GameState? = null
        var lastPluginState: Any? = null
        var lastQuestProgress: Int = -1
        var walkTarget: WorldPoint? = null


        var hasAllIngredients = false;
        var questComplete = false;

        var info: String? = null
        var waitTicks: Int = 0

        val quests = ArrayList<QuestRunner>()
    }

    init {
        quests.add(CooksAssistantRunner())
    }

    val pathOverlay = overlay(PathOverlay(this))
    val statusOverlay = overlay(StatusOverlay(this))

    var currentQuest: QuestRunner? = quests.first()


    inline fun <reified T : QuestRunner> get(): T {
        return quests.filterIsInstance<T>().first()
    }

    override fun onGameTick(it: GameTick) {
        if (currentQuest == null)
            return

        if (waitTicks > 0)
            waitTicks--

        if (Movement.isWalking)
            return

        lastGameState = client.gameState
        when (lastGameState) {
            GameState.LOGGED_IN -> currentQuest!!.handleState()
            else -> reset()
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        lastGameState = it.new
    }

    fun reset() {
        lastGameState = null
        lastPluginState = null
        lastQuestProgress = -1
        walkTarget = null
    }
}