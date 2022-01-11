package meteor.events

import meteor.Event
import meteor.plugins.Plugin

class PluginChanged(plugin: Plugin, enabled: Boolean) : Event() {
    var plugin: Plugin
    var enabled: Boolean

    init {
        this.plugin = plugin
        this.enabled = enabled
    }
}