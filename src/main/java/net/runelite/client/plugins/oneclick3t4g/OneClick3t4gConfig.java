package net.runelite.client.plugins.oneclick3t4g;


import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

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