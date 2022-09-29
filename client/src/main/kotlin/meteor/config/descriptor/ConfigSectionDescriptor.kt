package meteor.config.descriptor

import meteor.config.legacy.ConfigObject
import net.runelite.client.config.ConfigSection

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