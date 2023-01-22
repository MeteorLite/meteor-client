package meteor.config.descriptor

import meteor.config.legacy.ConfigGroup

class ConfigDescriptor(
        val group: ConfigGroup, val sections: Collection<ConfigSectionDescriptor>,
        val titles: Collection<ConfigTitleDescriptor>, val items: Collection<ConfigItemDescriptor>
)