package meteor.plugins.oneclickglassblowing

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem


@ConfigGroup("oneclickglassblowing")
interface OneClickGlassblowingConfig : Config {
    @ConfigItem(position = 0, keyName = "mode", name = "Glass Mode", description = "Choose")
    fun mode(): Types.Mode {
        return Types.Mode.GLASSBLOWING
    }

    @ConfigItem(
        position = 1,
        keyName = "glassblowingType",
        name = "Item",
        description = "Choose item to blow",
        hidden = true,
        unhide = "mode",
        unhideValue = "GLASSBLOWING"
    )
    fun product(): Types.Product {
        return Types.Product.LANTERN_LENS
    }

    @ConfigItem(
        position = 1,
        keyName = "superglassMakeMethod",
        name = "Superglass Make Method",
        description = "Choose Superglass Make Method",
        hidden = true,
        unhide = "mode",
        unhideValue = "SUPERGLASS_MAKE"
    )
    fun superglassMakeMethod(): Types.SuperGlassMakeMethod {
        return Types.SuperGlassMakeMethod.THREE_EIGHTEEN
    }

    @ConfigItem(position = 2, keyName = "bankType", name = "Bank Type", description = "Choose")
    fun bankType(): Types.Banks {
        return Types.Banks.CHEST
    }

    @ConfigItem(
        position = 3,
        keyName = "bankID",
        name = "Bank ID",
        description = "Input bank ID, supports chests/NPCs/Booths. Default is Fossil Island north Bank"
    )
    fun bankID(): Int {
        return 30796
    }
}