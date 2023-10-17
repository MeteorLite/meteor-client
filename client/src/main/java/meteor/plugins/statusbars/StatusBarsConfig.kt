package meteor.plugins.statusbars


import meteor.Configuration
import meteor.config.legacy.*

@ConfigGroup(Configuration.MASTER_GROUP)
interface StatusBarsConfig : Config {

    @ConfigItem(
            keyName = "enableCounter",
            name = "Show counters",
            description = "Shows current value of the status on the bar",
            position = 0
    )
    fun enableCounter(): Boolean {
        return true
    }

    @ConfigItem(
            name = "Show icons",
            keyName = "enableSkillIcons",
            description = "Adds skill icons at the top of the bars.",
            position = 1,
    )
    fun enableSkillIcon(): Boolean {
        return true
    }
}
