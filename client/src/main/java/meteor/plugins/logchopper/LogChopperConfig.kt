package meteor.plugins.logchopper

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import net.runelite.api.ItemID

@ConfigGroup("bowfletcher")
interface LogChopperConfig : Config{
    @ConfigItem(
        keyName = "logType",
        name = "Log Type",
        description = "type of logs to cut",
        position = 1
    )
    fun type() : LogType {
        return LogType.Regular
    }

    @ConfigItem(
        keyName = "methods",
        name = "Method",
        description = "Choose which method to do",
        position = 2
    )
    fun trees() : MethodType {
        return MethodType.Bank
    }

    enum class MethodType (val string : String){
        Bank("bank"), Drop("drop")
    }

    enum class LogType(val treeID: String, val logID : Int){
        Regular("Tree", ItemID.LOGS),
        Oak("Oak", ItemID.OAK_LOGS),
        Willow("Willow", ItemID.WILLOW_LOGS),
        Teak("Teak Tree", ItemID.TEAK_LOGS),
        Maple("Maple tree", ItemID.MAPLE_LOGS),
        Mahogany("Mahogany tree", ItemID.MAHOGANY_LOGS),
        Yew("Yew", ItemID.YEW_LOGS),
        Magic("Magic tree", ItemID.MAGIC_LOGS),
    }
}