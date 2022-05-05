package meteor.plugins.commands

import eventbus.events.CheatEntered
import meteor.config.ConfigManager
import meteor.dev.widgetinspector.WidgetInspector
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.PluginManager
import meteor.plugins.devtools.DevToolsPlugin

@PluginDescriptor(name = "Commands", enabledByDefault = true, description = "")
class CommandsPlugin : Plugin() {
    override fun onCheatEntered(it: CheatEntered) {
        when (it.cheat) {
            "widgets" -> {
                WidgetInspector.open()
                it.consumed = true
            }
            "npcs" -> {
                ConfigManager.getConfiguration("devtools", "npcsActive").toBoolean()
                    .let { npcsActive -> ConfigManager.setConfiguration("devtools", "npcsActive", !npcsActive) }
                it.consumed = true
            }
        }
    }
}