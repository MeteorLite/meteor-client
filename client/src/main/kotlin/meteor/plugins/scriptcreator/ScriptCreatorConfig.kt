
package meteor.plugins.scriptcreator


import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import java.awt.Color

@ConfigGroup(value = "Script Creator")
interface ScriptCreatorConfig : Config {

    @ConfigItem(
        keyName = "Font Size",
        name = "Font Size",
        description = "The font size displayed in the Scripting Console",
        position = 2,
    )
    fun fontSize(): Int {
        return 12
    }
    @ConfigItem(
        keyName = "Type Color",
        name = "Type Color",
        description = "The color for types in the Scripting Console",
        position = 2,
    )
    fun type(): Color {
        return Color.BLACK
    }

    @ConfigItem(
        keyName = "Keyword Color",
        name = "Keyword Color",
        description = "The color for keywords in the Scripting Console",
        position = 3,
    )
    fun keyword(): Color {
        return Color.BLUE
    }

    @ConfigItem(
        keyName = "Literal Color",
        name = "Literal Color",
        description = "The color for literals in the Scripting Console",
        position = 4,
    )
    fun literal(): Color {
        return Color.GREEN
    }

    @ConfigItem(
        keyName = "Comment Color",
        name = "Comment Color",
        description = "The color for comments in the Scripting Console",
        position = 5,
    )
    fun comment(): Color {
        return Color.GRAY
    }

    @ConfigItem(
        keyName = "String Color",
        name = "String Color",
        description = "The color for strings in the Scripting Console",
        position = 6,
    )
    fun string(): Color {
        return Color.YELLOW
    }

    @ConfigItem(
        keyName = "Punctuation Color",
        name = "Punctuation Color",
        description = "The color for punctuation in the Scripting Console",
        position = 7,
    )
    fun punctuation(): Color {
        return Color.GREEN
    }

    @ConfigItem(
        keyName = "Plain Text Color",
        name = "Plain Text Color",
        description = "The color for plain text in the Scripting Console",
        position = 8,
    )
    fun plain(): Color {
        return Color.GREEN
    }

    @ConfigItem(
        keyName = "Tag Color",
        name = "Tag Color",
        description = "The color for tags in the Scripting Console",
        position = 9,
    )
    fun tag(): Color {
        return Color.GREEN
    }

    @ConfigItem(
        keyName = "Declaration Color",
        name = "Declaration Color",
        description = "The color for declarations in the Scripting Console",
        position = 10,
    )
    fun declaration(): Color {
        return Color.MAGENTA
    }

    @ConfigItem(
        keyName = "Source Color",
        name = "Source Color",
        description = "The color for source in the Scripting Console",
        position = 11,
    )
    fun source(): Color {
        return Color.MAGENTA
    }

    @ConfigItem(
        keyName = "Attribute Name Color",
        name = "Attribute Name Color",
        description = "The color for attribute names in the Scripting Console",
        position = 12,
    )
    fun attrName(): Color {
        return Color.GREEN
    }

    @ConfigItem(
        keyName = "Attribute Value Color",
        name = "Attribute Value Color",
        description = "The color for attribute values in the Scripting Console",
        position = 13,
    )
    fun attrValue(): Color {
        return Color.GREEN
    }

    @ConfigItem(
        keyName = "No Code Color",
        name = "No Code Color",
        description = "The color for no code in the Scripting Console",
        position = 14,
    )
    fun nocode(): Color {
        return Color.DARK_GRAY
    }

}