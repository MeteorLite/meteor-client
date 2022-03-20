package meteor.plugins.questrunner.cooksassistant

import Main.client
import eventbus.events.ChatMessage
import meteor.api.coords.RectangularArea
import meteor.api.entities.NPCs
import meteor.api.entities.Objects
import meteor.api.entities.Players
import meteor.api.items.Inventory
import meteor.api.movement.Movement
import meteor.api.quest.QuestVarP
import meteor.api.widgets.Dialog
import meteor.plugins.questrunner.QuestRunner
import meteor.plugins.questrunner.QuestRunnerPlugin.Companion.hasAllIngredients
import meteor.plugins.questrunner.QuestRunnerPlugin.Companion.lastPluginState
import meteor.plugins.questrunner.QuestRunnerPlugin.Companion.lastQuestProgress
import meteor.plugins.questrunner.QuestRunnerPlugin.Companion.questComplete
import meteor.plugins.questrunner.QuestRunnerPlugin.Companion.walkTarget
import meteor.plugins.questrunner.Util.travelWorldArea
import net.runelite.api.ItemID
import net.runelite.api.NpcID
import net.runelite.api.coords.WorldPoint

class CooksAssistantRunner : QuestRunner() {
    var hopperIsFilled = false
    var grainAlreadyLoaded = false

    val cook = NpcID.COOK_4626
    val cookArea = RectangularArea(3205, 3212,3212, 3217)
    val randomCookAreaPoint = cookArea.getRandomTile()
    val egg = ItemID.EGG
    val bucketOfMilk = ItemID.BUCKET_OF_MILK
    val bucket = ItemID.BUCKET
    val pot = ItemID.POT
    val grain = ItemID.GRAIN
    val potOfFlour = ItemID.POT_OF_FLOUR

    override fun onChatMessage(it: ChatMessage) {
        if (it.message.contains("You operate the hopper")) {
            hopperIsFilled = true
            grainAlreadyLoaded = false
        }
        else if (it.message.contains("the grain in the")) {
            hopperIsFilled = false
            grainAlreadyLoaded = true
        }
        else if (it.message.contains("is already grain"))
            grainAlreadyLoaded = true
        else if (it.message.contains("fill a pot with")) {
            hopperIsFilled = false
            grainAlreadyLoaded = false
        }
    }

    override fun handleState() {
        lastQuestProgress = client.getVarpValue(QuestVarP.COOKS_ASSISTANT.varp)

        if (walkTarget != null)
            if (walkTarget!!.distanceTo(Players.local.worldLocation) <= 10)
                walkTarget = null

        when (lastQuestProgress) {
            0 -> lastPluginState = PLUGIN_STATE.START_QUEST
            1 -> {
                if (hasAllIngredients)
                    lastPluginState = PLUGIN_STATE.FINISH_QUEST
                else if (!Inventory.contains(potOfFlour))
                    lastPluginState = PLUGIN_STATE.COLLECT_POT_OF_FLOUR
                else if (!Inventory.contains(bucketOfMilk))
                    lastPluginState = PLUGIN_STATE.COLLECT_BUCKET_OF_MILK
                else if (!Inventory.contains(egg))
                    lastPluginState = PLUGIN_STATE.COLLECT_EGG
                else {
                    hasAllIngredients = true
                }
            }
            2 -> {
                questComplete = true
                lastPluginState = PLUGIN_STATE.QUEST_COMPLETE
            }
        }

        when (lastPluginState) {
            PLUGIN_STATE.START_QUEST -> startQuest()
            PLUGIN_STATE.COLLECT_POT_OF_FLOUR -> Collect.potOfFlour()
            PLUGIN_STATE.COLLECT_BUCKET_OF_MILK -> Collect.bucketOfMilk()
            PLUGIN_STATE.COLLECT_EGG -> Collect.egg()
            PLUGIN_STATE.FINISH_QUEST -> finishQuest()
        }
    }

    override fun startQuest() {
        if (Dialog.canContinue())
            Dialog.continueSpace()
        else if (Dialog.isViewingOptions) {
            meteor.plugins.questrunner.cooksassistant.Dialog.handle()
            for (dialog in Dialog.options)
                println(dialog.text)
        }
        else if (randomCookAreaPoint.distanceTo(Players.local.worldLocation) > 10) {
            walkTarget = cookArea.getRandomTile()
            if (!Movement.isWalking)
                Movement.walkTo(walkTarget!!)
        }
        else
            NPCs.getNearest(this.cook)?.interact("Talk-to")
    }

    override fun finishQuest() {
        val closedCowGate = Objects.getAt(WorldPoint(3253, 3266, 0), Collect.closedGate)
        if (closedCowGate.isNotEmpty()) {
            if (closedCowGate.first()!!.distanceTo(Players.local) < 5) {
                closedCowGate.first()!!.interact("Open")
                return
            }
        }

        if (travelWorldArea(cookArea))
        if (randomCookAreaPoint.distanceTo(Players.local.worldLocation) > 10) {
            walkTarget = cookArea.getRandomTile()
            if (!Movement.isWalking) {
                Movement.walkTo(walkTarget!!)
                return
            }
        }
        else {
            if (Dialog.canContinue())
                Dialog.continueSpace()
            else if (Dialog.isViewingOptions) {
                meteor.plugins.questrunner.cooksassistant.Dialog.handle()
                for (dialog in Dialog.options)
                    println(dialog.text)
            }
            else {
                NPCs.getNearest(this.cook)?.interact("Talk-to")
            }
        }
    }

    enum class PLUGIN_STATE(state: Int) {
        START_QUEST(0),
        COLLECT_POT_OF_FLOUR(1),
        COLLECT_BUCKET_OF_MILK(2),
        COLLECT_EGG(3),
        FINISH_QUEST(4),
        QUEST_COMPLETE(5)
    }
}