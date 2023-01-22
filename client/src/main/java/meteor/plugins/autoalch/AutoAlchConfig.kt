package meteor.plugins.autoalch


import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.Range

@ConfigGroup("autoalch")
interface AutoAlchConfig : Config {
    @ConfigItem(keyName = "Spell", name = "alchtype",
        description = "Spell to cast",
        position = 1,
        textField = true)
    fun alchType(): AlchType {
        return AlchType.HIGH
    }


    @ConfigItem(keyName = "itemID", name = "itemID", description = "Item id of what you want to alch", position = 1)
    fun itemID(): Int {
        return 2
    }

    enum class AlchType {
        LOW, HIGH
    }
}