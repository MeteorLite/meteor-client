package meteor.plugins.highalchemy


import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem
import net.runelite.client.config.Range

@ConfigGroup("HighAlchPlugin")
interface HighAlchConfig : Config {
    @Range(textInput = true)
    @ConfigItem(keyName = "itemID", name = "itemID", description = "Item id of what you want to alch", position = 1)
    fun itemID(): Int {
        return 2
    }
}