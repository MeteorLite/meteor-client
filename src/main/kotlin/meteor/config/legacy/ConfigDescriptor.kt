package meteor.config.legacy


class ConfigDescriptor(
        val group: ConfigGroup, val sections: Collection<ConfigSectionDescriptor>,
        val titles: Collection<ConfigTitleDescriptor>, val items: Collection<ConfigItemDescriptor>
)