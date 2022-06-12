package meteor.plugins.notes

import net.runelite.client.config.Config
import net.runelite.client.config.ConfigGroup
import net.runelite.client.config.ConfigItem

@ConfigGroup(value = "notes")
interface NotesConfig: Config {

    @ConfigItem(name = "notes",
                keyName = "notes",
                description = "")
    fun getNotes():String{
        return ""
    }
}