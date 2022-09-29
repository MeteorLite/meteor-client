package net.runelite.client.plugins.oneclick3t4g;


import meteor.config.legacy.Config;
import meteor.config.legacy.ConfigGroup;
import meteor.config.legacy.ConfigItem;

@ConfigGroup("OneClick3t4g")
public interface OneClick3t4gConfig extends Config {
    @ConfigItem(
            keyName = "humidify",
            name = "use Humidify?",
            description = "Uses humidify when u have 1 filled waterskin left"
    )
    default boolean humidify()
    {
        return false;
    }
}