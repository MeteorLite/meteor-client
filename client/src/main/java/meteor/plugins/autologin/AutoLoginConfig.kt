package meteor.plugins.autologin

import meteor.config.legacy.*

@ConfigGroup("autologin")
interface AutoLoginConfig : Config {

    @ConfigSection(keyName = "title", name = "AutoLogin", description = "", position = 0)
    val AutoRun: String


    @ConfigItem(
        keyName = "username",
        name = "Username",
        description = "Username",
        textField = true,
        position = 10,
        section = "AutoLogin"
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
        section = "AutoLogin"
    )
    fun password(): String {
        return "Password"
    }
}