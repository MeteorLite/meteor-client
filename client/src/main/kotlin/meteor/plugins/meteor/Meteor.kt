package meteor.plugins.meteor

import meteor.config.MeteorConfig
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor

@PluginDescriptor(name = "Meteor", enabledByDefault = true)
class Meteor : Plugin() {
    override var config = configuration<MeteorConfig>()
}