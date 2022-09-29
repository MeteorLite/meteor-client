package meteor.plugins.xptracker.worldmapwalker;

import meteor.config.Config;
import meteor.config.ConfigGroup;
import meteor.config.ConfigItem;

@ConfigGroup("worldmap")
public interface WorldMapWalkerConfig extends Config {

    @ConfigItem(
            keyName = "shiftClickToWalk",
            name = "Shift click on map to walk",
            description = "Lets you walk to destinations with shift clicks"
    )
    default boolean shiftClickToWalk() {
        return true;
    }

    @ConfigItem(
            keyName = "showPaths",
            name = "Show walk path",
            description = "Highlights the walking path in game"
    )
    default boolean showPaths() {
        return true;
    }
}
