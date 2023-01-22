package meteor.plugins.oneclickkarambwans

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem


@ConfigGroup("oneclickkarambwans")
interface OneClickKarambwansConfig : Config {
    @ConfigItem(
        position = 1,
        keyName = "bankAtSeers",
        name = "Use Seers Village bank",
        description = "Banks at Seers village instead of Zanaris"
    )
    fun bankAtSeers(): Boolean {
        return true
    }

    @ConfigItem(
        position = 2,
        keyName = "pohFairyRing",
        name = "Use POH Fairy Ring",
        description = "Teles to poh using con cape/max cape/standard spellbook tele"
    )
    fun pohFairyRing(): Boolean {
        return true
    }

    @ConfigItem(
        position = 3,
        keyName = "debug",
        name = "Debug",
        description = "Posts debug message to chat if having problems"
    )
    fun debug(): Boolean {
        return true
    }
}