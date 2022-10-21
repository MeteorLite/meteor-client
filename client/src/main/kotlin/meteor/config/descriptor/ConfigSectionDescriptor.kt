package meteor.config.descriptor

import meteor.config.legacy.ConfigObject
import meteor.config.legacy.ConfigSection

class ConfigSectionDescriptor(val type: String?, val section: ConfigSection) : ConfigObject {


    override fun key(): String? {
        return section.keyName
    }

    override fun name(): String {
        return section.name
    }

    override fun position(): Int {
        return section.position
    }
}
