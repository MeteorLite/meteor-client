package meteor.plugins.AIOCrabPlugin

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.plugins.AIOCrabPlugin.constants.CrabHome

@ConfigGroup("AIOCrabPlugin")
interface CrabFighterConfig : Config {

    @ConfigItem(
        position = 0,
        keyName = "home",
        name = "Crab Home",
        description = "Select the area which you want crabs"
    )
    fun home(): CrabHome {
        return CrabHome.RELLEKA_NORTH
    }

//    @ConfigItem(
//        keyName = "loots",
//        name = "Loot Items",
//        description = "Items to loot separated by comma. ex: Lobster,Tuna",
//        position = 1,
//        section = "Loot"
//    )
//    fun loot(): String {
//        return "Any"
//    }

//    @ConfigItem(keyName = "eat", name = "Eat food", description = "Eat food to heal", position = 0, section = "Health")
//    fun eat(): Boolean {
//        return true
//    }

//    @Range(max = 100)
//    @ConfigItem(
//        keyName = "eatHealthPercent",
//        name = "Health %",
//        description = "Health % to eat at",
//        position = 1,
//        section = "Health"
//    )
//    fun healthPercent(): Int {
//        return 65
//    }

//    @ConfigItem(
//        keyName = "foods",
//        name = "Food",
//        description = "Food to eat, separated by comma. ex: Bones,Coins",
//        position = 0,
//        section = "Health"
//    )
//    fun foods(): String {
//        return "Any"
//    }
//        @ConfigSection(name = "General", description = "General settings", position = 0, closedByDefault = true)
//        val general:String

//        @ConfigSection(name = "Health", description = "General settings", position = 1, closedByDefault = true)
//        val health:String
//
//        @ConfigSection(name = "Loot", description = "Loot settings", position = 2, closedByDefault = true)
//        val Loot:String
}