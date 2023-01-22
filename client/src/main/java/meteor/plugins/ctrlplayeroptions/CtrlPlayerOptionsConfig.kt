package meteor.plugins.ctrlplayeroptions

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("ctrlplayeroptions")
interface CtrlPlayerOptionsConfig : Config {
    @ConfigItem(
        keyName = "hideFollow",
        name = "Hide Follow",
        description = ""
    )
    fun hideFollow(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "hideTradeWith",
        name = "Hide Trade-with",
        description = ""
    )
    fun hideTradeWith(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "hideReport",
        name = "Hide Report",
        description = ""
    )
    fun hideReport(): Boolean {
        return true
    }
}