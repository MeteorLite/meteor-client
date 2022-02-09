package meteor.config.descriptor

import meteor.config.ConfigAnnotations
import meteor.config.legacy.ConfigObject


class ConfigTitleDescriptor(val key: String, val title: ConfigAnnotations.ConfigTitle) : ConfigObject {
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