package meteor.plugins.bowfletcher

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import net.runelite.api.ItemID

@ConfigGroup("bowfletcher")
interface BowFletcherConfig : Config {
    @ConfigItem(
        keyName = "methodType",
        name = "Method",
        description = "Choose which method to do",
        position = 1
    )
    fun type() : FletchingType{
        return FletchingType.Cut_Logs
    }

    @ConfigItem(
        keyName = "StyleType",
        name = "Style",
        description = "Choose which style to do",
        position = 2
    )
    fun style() : BowStyle{
        return BowStyle.Shortbow
    }
    @ConfigItem(
        keyName = "bowType",
        name = "Log Type",
        description = "Choose which bow to fletch",
        position = 3
    )
    fun bows() : Bows{
        return Bows.Regular
    }

    enum class FletchingType (val message : String){
        Cut_Logs("cutting logs"), String_Bow ("stinging bows")
    }

    enum class BowStyle (val style: String){
        Shortbow("Shortbow"), Longbow ("Longbow")
    }

    enum class Bows (val longbowID : Int, val shortbowID : Int, val logID : Int, val finishedLongbowID : Int, val finishedShortbowID : Int) {
        Regular(ItemID.LONGBOW_U, ItemID.SHORTBOW_U, ItemID.LOGS, ItemID.LONGBOW, ItemID.SHORTBOW),
        Oak(ItemID.OAK_LONGBOW_U, ItemID.OAK_SHORTBOW_U, ItemID.OAK_LOGS, ItemID.OAK_LONGBOW, ItemID.OAK_SHORTBOW),
        Willow(ItemID.WILLOW_LONGBOW_U,ItemID.WILLOW_SHORTBOW_U, ItemID.WILLOW_LOGS, ItemID.WILLOW_LONGBOW, ItemID.WILLOW_SHORTBOW),
        Maple(ItemID.MAPLE_LONGBOW_U, ItemID.MAPLE_SHORTBOW_U, ItemID.MAPLE_LOGS, ItemID.MAPLE_LONGBOW, ItemID.MAPLE_SHORTBOW),
        Yew(ItemID.YEW_LONGBOW_U, ItemID.YEW_SHORTBOW_U, ItemID.YEW_LOGS, ItemID.YEW_LONGBOW, ItemID.YEW_SHORTBOW),
        Magic(ItemID.MAGIC_LONGBOW_U, ItemID.MAGIC_SHORTBOW_U, ItemID.MAGIC_LOGS, ItemID.MAGIC_LONGBOW, ItemID.MAGIC_SHORTBOW)
    }
}