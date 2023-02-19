package meteor.plugins.crabfighter

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("AIOCrabPlugin")
interface CrabFighterConfig : Config {

    @ConfigItem(
        position = 0,
        keyName = "home",
        name = "Crab Home",
        description = "Select the area which you want crabs"
    )
    fun home(): CrabFighterPlugin.CrabHome {
        return CrabFighterPlugin.CrabHome.RELLEKA_NORTH
    }
//
//    @ConfigItem(
//        keyName = "loots",
//        name = "Loot Items",
//        description = "Items to loot separated by comma. ex: Unidentified,Spore\n you can have partly finished words to loot all unidentified fossils",
//        position = 1,
//        section = "Loot"
//    )
//    fun loot(): String {
//        return "unidentified, spore"
//    }
//
//    @ConfigItem(keyName = "eat", name = "Eat food", description = "Eat food to heal", position = 0, section = "Health")
//    fun eat(): Boolean {
//        return false
//    }
//
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
//
//    @ConfigItem(
//        keyName = "foods",
//        name = "Food",
//        description = "Food to eat, separated by comma. ex: lobster, swordfish, Shark, Tuna",
//        position = 0,
//        section = "Health"
//    )
//    fun foods(): String {
//        return "lobster, swordfish"
//    }
//        @ConfigSection(name = "General", description = "General settings", position = 0, closedByDefault = true)
//        val general:String

//        @ConfigSection(name = "Health", description = "General settings", position = 1, closedByDefault = true)
//        val health:String
//
//        @ConfigSection(name = "Loot", description = "Loot settings", position = 2, closedByDefault = true)
//        val Loot:String
}