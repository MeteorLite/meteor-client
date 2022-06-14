package meteor.plugins.ctrlplayeroptions

import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem

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
        keyName = "hideFollow",
        name = "Hide Trade-with",
        description = ""
    )
    fun hideTradeWith(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "hideFollow",
        name = "Hide Report",
        description = ""
    )
    fun hideReport(): Boolean {
        return true
    }
}