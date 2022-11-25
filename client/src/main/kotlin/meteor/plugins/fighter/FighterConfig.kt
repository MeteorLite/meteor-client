package meteor.plugins.fighter

import meteor.config.legacy.*

@ConfigGroup("fighter")
interface FighterConfig : Config {
    @ConfigItem(
        keyName = "monster",
        name = "Monster",
        description = "Monster to kill",
        textField = true,
        position = 0,
        section = "General"
    )
    fun monster(): String {
        return "Chicken"
    }

    @Range(max = 100)
    @ConfigItem(
        keyName = "attackRange",
        name = "Attack range",
        description = "Monster attack range",
        position = 1,
        section = "General"
    )
    fun attackRange(): Int {
        return 15
    }

    @ConfigItem(keyName = "bury", name = "Bury bones", description = "Bury bones", position = 2, section = "General")
    fun buryBones(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "loots",
        name = "Loot Items",
        description = "Items to loot separated by comma. ex: Lobster,Tuna",
        position = 0,
        section = "Loot"
    )
    fun loot(): String {
        return "Any"
    }

    @Range(textInput = true)
    @ConfigItem(
        keyName = "lootValue",
        name = "Loot GP value",
        description = "Items to loot by value, -1 to check by name only",
        position = 1,
        section = "Loot"
    )
    fun lootValue(): Int {
        return -1
    }

    @ConfigItem(
        keyName = "untradables",
        name = "Loot untradables",
        description = "Loot untradables",
        position = 2,
        section = "Loot"
    )
    fun untradables(): Boolean {
        return true
    }

    @ConfigItem(keyName = "eat", name = "Eat food", description = "Eat food to heal", position = 0, section = "Health")
    fun eat(): Boolean {
        return true
    }

    @Range(max = 100)
    @ConfigItem(
        keyName = "eatHealthPercent",
        name = "Health %",
        description = "Health % to eat at",
        position = 1,
        section = "Health"
    )
    fun healthPercent(): Int {
        return 65
    }

    @ConfigItem(
        keyName = "foods",
        name = "Food",
        description = "Food to eat, separated by comma. ex: Bones,Coins",
        position = 0,
        section = "Health"
    )
    fun foods(): String {
        return "Any"
    }

    @ConfigItem(
        keyName = "quickPrayer",
        name = "Use Quick Prayers",
        description = "Use Quick Prayers",
        position = 0,
        section = "Prayers"
    )
    fun quickPrayer(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "flick",
        name = "Flick",
        description = "One ticks quick prayers",
        position = 1,
        section = "Prayers"
    )
    fun flick(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "restore",
        name = "Restore prayer",
        description = "Drinks pots to restore prayer points",
        position = 2,
        section = "Prayers"
    )
    fun restore(): Boolean {
        return false
    }

    @ConfigItem(keyName = "alch", name = "Alch items", description = "Alchs items", position = 0, section = "Alching")
    fun alching(): Boolean {
        return false
    }

    @ConfigItem(keyName = "alchSpell", name = "Alch spell", description = "Alch spell", position = 1, section = "Alching")
    fun alchSpell(): AlchSpell? {
        return AlchSpell.HIGH
    }

    @ConfigItem(
        keyName = "alchItems",
        name = "Alch items",
        description = "Items to alch, separated by comma. ex: Maple shortbow,Rune scimitar",
        position = 2,
        section = "Alching"
    )
    fun alchItems(): String {
        return "Weed"
    }

        @ConfigSection(name = "General", description = "General settings", position = 0, closedByDefault = true)
        val general:String

        @ConfigSection(name = "Health", description = "General settings", position = 1, closedByDefault = true)
        val health:String

        @ConfigSection(name = "Loot", description = "Loot settings", position = 2, closedByDefault = true)
        val Loot:String

        @ConfigSection(name = "Prayers", description = "Prayers settings", position = 3, closedByDefault = true)
        val Prayers:String

        @ConfigSection(name = "Alching", description = "Alching settings", position = 4, closedByDefault = true)
        val Alching:String
    
}