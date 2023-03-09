package meteor.plugins.privateserver

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("privateServer")
interface PrivateServerConfig : Config {
    @ConfigItem(keyName = "host", name = "Host", description = "", position = 0)
    fun host(): String {
        return ""
    }

    @ConfigItem(keyName = "modulus", name = "Modulus", description = "", position = 1)
    fun modulus(): String {
        return ""
    }
}