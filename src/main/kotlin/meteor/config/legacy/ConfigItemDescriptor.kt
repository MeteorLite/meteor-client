package meteor.config.legacy


class ConfigItemDescriptor(val item: ConfigItem, val type: Class<*>? = null, val range: Range? = null, val alpha: Alpha? = null,
                           val units: Units? = null, val icon: Icon? = null) : ConfigObject {

    override fun key(): String {
        return item.keyName
    }

    override fun name(): String {
        return item.name
    }

    override fun position(): Int {
        return item.position
    }
}