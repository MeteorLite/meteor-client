package meteor.config.legacy

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