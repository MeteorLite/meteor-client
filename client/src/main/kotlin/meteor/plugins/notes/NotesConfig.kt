package meteor.plugins.notes

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup(value = "notes")
interface NotesConfig : Config {

    @ConfigItem(
        name = "notes",
        keyName = "notes",
        description = ""
    )
    fun getNotes(): String {
        return ""
    }
}