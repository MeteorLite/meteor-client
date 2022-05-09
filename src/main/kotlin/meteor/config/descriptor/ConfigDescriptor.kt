package meteor.config.descriptor

import net.runelite.client.config.ConfigGroup
class ConfigDescriptor(
        val group: ConfigGroup, val sections: Collection<ConfigSectionDescriptor>,
        val titles: Collection<ConfigTitleDescriptor>, val items: Collection<ConfigItemDescriptor>
)