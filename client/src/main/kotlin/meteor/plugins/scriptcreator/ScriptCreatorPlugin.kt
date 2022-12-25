package meteor.plugins.scriptcreator

import compose.icons.Octicons
import compose.icons.octicons.Code16
import meteor.plugins.PluginDescriptor
import meteor.plugins.scriptcreator.script.eventbus.ScriptSubscriber
import meteor.plugins.scriptcreator.script.eventbus.unsubscribeScript
import meteor.ui.composables.PluginPanel
import meteor.ui.composables.preferences.codeState
import meteor.ui.composables.preferences.scriptCreator
import meteor.ui.composables.preferences.pluginPanel
import meteor.ui.composables.preferences.uiColor
import meteor.ui.composables.toolbar.ToolbarButton
import meteor.ui.composables.toolbar.addButton
import meteor.ui.composables.toolbar.removeButton
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager


@PluginDescriptor(name = "Script Creator", enabledByDefault = true)
class ScriptCreatorPlugin : ScriptSubscriber() {

    var panel: PluginPanel? = null
    val engine: ScriptEngine = ScriptEngineManager().getEngineByExtension("kts")
    var config = configuration<ScriptCreatorConfig>()

    private var consoleButton = ToolbarButton(
        "Console",
        Octicons.Code16,
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

    fun stopScript(){
        stop()
        unsubscribeScript()
    }

    fun startScript() {
        start()
        try {
            engine.eval(codeState.value)
        } catch (e: Exception) {
            println(e.cause)
            println(e.message)
            println(e.stackTrace)
        }
        subscribeScript()
    }



}