package meteor.config.descriptor

import meteor.config.ConfigAnnotations


class ConfigDescriptor(
        val group: ConfigAnnotations.ConfigGroup, val sections: Collection<ConfigSectionDescriptor>,
        val titles: Collection<ConfigTitleDescriptor>, val items: Collection<ConfigItemDescriptor>
)