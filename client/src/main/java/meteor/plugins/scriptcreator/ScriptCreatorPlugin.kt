package meteor.plugins.scriptcreator

import compose.icons.TablerIcons
import compose.icons.tablericons.BrandTabler
import eventbus.events.GameTick
import eventbus.events.MenuOptionClicked
import meteor.Logger
import meteor.plugins.PluginDescriptor
import meteor.plugins.scriptcreator.script.eventbus.ScriptSubscriber
import meteor.plugins.scriptcreator.script.eventbus.unsubscribeScript
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.*
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton
import net.runelite.api.Constants
import net.runelite.api.Perspective
import net.runelite.api.coords.WorldPoint
import net.runelite.api.util.Text


@PluginDescriptor(name = "Script Creator", enabledByDefault = true)
class ScriptCreatorPlugin : ScriptSubscriber() {

    var panel: PluginPanel? = null



    val log = Logger("Script Logger")

    var config = configuration<ScriptCreatorConfig>()


    private var consoleButton = ToolbarButton(
        "Console",
        TablerIcons.BrandTabler,
        iconColor = uiColor.value,
        description = "Create custom kotlin scripts",
        onClick = {
            onClick()
        },
        bottom = true
    )

    fun onClick() {
        pluginPanel.value = panel
        scriptCreator.value = scriptCreator.value == false
        pluginsOpen.value = false
        togglePluginPanel(consoleButton)
    }

    override fun onStart() {

        panel = ScriptCreatorPluginPanel()
        addButton(consoleButton)

    }

    override fun onStop() {
        stop()
        removeButton(consoleButton)
        panel = null
    }

    private fun tileLocation(): WorldPoint {
        val scene = client.scene
        val tiles = scene.tiles
        val z = client.plane
        var worldPoint = WorldPoint(0, 0, 0)
        for (x in 0 until Constants.SCENE_SIZE) {
            for (y in 0 until Constants.SCENE_SIZE) {
                val tile = tiles[z][x][y] ?: continue
                val poly = Perspective.getCanvasTilePoly(client, tile.localLocation)
                if (poly != null && poly.contains(client.mouseCanvasPosition.x, client.mouseCanvasPosition.y)) {
                    worldPoint = tile.worldLocation

                }
            }
        }
        return worldPoint
    }

    private fun checkGameTick(codeValue: String) {
        val gameTickStart = "onGameTick {"
        val gameTickEnd = "\n\n}"

        val gameTick = "$gameTickStart\n$codeValue$gameTickEnd"

        if (!codeState.value.contains(gameTickStart)) {
            codeState.value = "\n$gameTick"
        } else {
            val endIndex = codeState.value.lastIndexOf(gameTickEnd)
            val newValue = codeState.value.substring(0, endIndex) + "\n$codeValue" + codeState.value.substring(endIndex)
            codeState.value = newValue
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {

        val output = Text.removeFormattingTags(it.menuEntry.target).replace(Regex("\\s*\\(.*\\)"), "")
        val delay = "delay = $tickCounter"
        if (record.value)
            when {
                it.menuEntry.type.name.contains("NPC") -> {
                    newCode.value =
                        "\nNpc first \"$output\" interact \"${it.menuEntry.option}\"  \n $delay"
                    checkGameTick(newCode.value)
                    tickCounter = 0
                }

                it.menuEntry.type.name.contains("GAME_OBJECT") -> {
                    newCode.value =
                        "\nObject first \"$output\" interact \"${it.menuEntry.option}\"  \n $delay"
                    checkGameTick(newCode.value)
                    tickCounter = 0
                }

                it.menuEntry.type.name.contains("GROUND_ITEM") -> {
                    newCode.value =
                        "\nLoot first \"$output\" interact \"${it.menuEntry.option}\"  \n $delay"
                    checkGameTick(newCode.value)
                    tickCounter = 0
                }

                it.menuEntry.type.name.contains("WALK") -> {
                    newCode.value =
                        "\nMovement.walkTo(${tileLocation().x},${tileLocation().y},${tileLocation().plane})\n $delay"
                    checkGameTick(newCode.value)
                    tickCounter = 0
                }

                it.menuEntry.param1.toString().startsWith("976") && it.menuEntry.type.name == "CC_OP" -> {
                    newCode.value =
                        "\nItem first \"$output\" interact \"${it.menuEntry.option}\"  \n $delay"
                    checkGameTick(newCode.value)
                    tickCounter = 0
                }

                it.menuEntry.param1.toString().startsWith("983") && it.menuEntry.option.startsWith("Deposit") -> {
                    newCode.value = "\nBank.deposit(\"$output\" ,\"${
                        it.menuEntry.option.replaceFirst(
                            "Deposit-",
                            ""
                        )
                    }\")  \n $delay"
                    checkGameTick(newCode.value)
                    tickCounter = 0
                }

                it.menuEntry.param1.toString().startsWith("786") && it.menuEntry.option.startsWith("Withdraw") -> {
                    newCode.value = "\nBank.withdraw(\"$output\" ,\"${
                        it.menuEntry.option.replaceFirst(
                            "Withdraw-",
                            ""
                        )
                    }\")  \n $delay"
                    checkGameTick(newCode.value)
                    tickCounter = 0
                }

                it.menuEntry.param1.toString().startsWith("354") -> {
                    val prayer = output.uppercase().replace(" ", "_")
                    newCode.value = "\nPrayers.toggle(Prayer.$prayer) \n $delay"
                    checkGameTick(newCode.value)
                    tickCounter = 0

                }

                it.menuEntry.type.name.contains("WIDGET_TARGET_ON_WIDGET") -> {
                    val tagetOnTarget = output.split("->")
                    newCode.value =
                        "\nItem first \"${tagetOnTarget[0]}\" useOn(Item first \"${tagetOnTarget[1]}\")  \n $delay"
                    checkGameTick(newCode.value)
                    tickCounter = 0
                }

            }

    }

    override fun onGameTick(it: GameTick) {
        if (record.value)
            tickCounter++
    }

    fun stopScript() {
        stop()
        unsubscribeScript()
        playRecording.value = false
    }


    fun startScript() {
        start()
        try {
            engine.eval(
                """
                import meteor.Main.client
                import meteor.plugins.scriptcreator.script.api.*
                import meteor.plugins.scriptcreator.script.eventbus.*
                import dev.hoot.api.movement.Movement
                
            """.trimIndent()
            )
            engine.eval(codeState.value)
        } catch (e: Exception) {

            println(e.toString())
            setErrorState(e.message!!)
        }
        subscribeScript()
        playRecording.value = true
    }


}