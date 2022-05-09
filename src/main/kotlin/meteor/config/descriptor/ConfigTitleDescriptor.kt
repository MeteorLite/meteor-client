package meteor.config.descriptor

import net.runelite.client.config.*
import meteor.config.legacy.ConfigObject


class ConfigTitleDescriptor(val key: String, val title: ConfigTitle) : ConfigObject {
    override fun key(): String {
        return key
    }

    override fun name(): String {
        return title.name
    }

    override fun position(): Int {
        return title.position
    }
}