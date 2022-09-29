package meteor.plugins.autoalch


import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem
import net.runelite.client.config.Range

@ConfigGroup("autoalch")
interface AutoAlchConfig : Config {
    @ConfigItem(keyName = "Spell", name = "alchtype", description = "Spell to cast", position = 1)
    fun alchType(): AlchType {
        return AlchType.HIGH
    }

    @Range(textInput = true)
    @ConfigItem(keyName = "itemID", name = "itemID", description = "Item id of what you want to alch", position = 1)
    fun itemID(): Int {
        return 2
    }

    enum class AlchType {
        LOW, HIGH
    }
}