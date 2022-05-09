package meteor.config.descriptor

import net.runelite.client.config.*
import meteor.config.legacy.ConfigObject

class ConfigSectionDescriptor(val key: String, val section: ConfigSection) : ConfigObject {

    override fun key(): String {
        return key
    }

    override fun name(): String {
        return section.name
    }

    override fun position(): Int {
        return section.position
    }
}