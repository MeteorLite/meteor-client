package meteor.plugins.autologin

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.ConfigSection

@ConfigGroup("autologin")
interface AutoLoginConfig : Config {
    companion object {
        @ConfigSection(keyName = "title", name = "Soxs' AutoRun", description = "", position = 0)
        const val title = "Autologin"
    }
    @ConfigItem(keyName = "username",
        name = "Username",
        description = "Username",
        textField = true,
        position = 10,
        section = title )
    fun username(): String {
        return "Username"
    }

    @ConfigItem(
        keyName = "password",
        name = "Password",
        description = "Password",
        secret = true,
        textField = true,
        position = 12,
        section = title
    ) fun password(): String {
        return "Password"
    }
}