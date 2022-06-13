package meteor.plugins.autologin

import net.runelite.client.config.*

@ConfigGroup("autologin")
interface AutoLoginConfig : Config {
    companion object {
        @ConfigSection(keyName = "title", name = "Soxs' AutoRun", description = "", position = 0)
        const val title = "Autologin"
    }

    @ConfigItem(
        keyName = "username",
        name = "Username",
        description = "Username",
        textField = true,
        position = 10,
        section = title
    )
    fun username(): String {
        return "Username"
    }

    @Secret
    @ConfigItem(
        keyName = "password",
        name = "Password",
        description = "Password",
        textField = true,
        position = 12,
        section = title
    )
    fun password(): String {
        return "Password"
    }
}