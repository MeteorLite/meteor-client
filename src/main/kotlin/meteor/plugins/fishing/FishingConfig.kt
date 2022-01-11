package meteor.plugins.fishing

import meteor.config.legacy.*
import java.awt.Color

@ConfigGroup("fishing")
@JvmDefaultWithoutCompatibility
interface FishingConfig: Config {

    @ConfigItem(position = 0, keyName = "onlyCurrent", name = "Display only currently fished fish", description = "Configures whether only current fished fish's fishing spots are displayed")
    fun onlyCurrentSpot(): Boolean {
        return false
    }

    @ConfigItem(position = 1, keyName = "showTiles", name = "Display spot tiles", description = "Configures whether tiles for fishing spots are highlighted")
    fun showSpotTiles(): Boolean {
        return true
    }

    @ConfigItem(position = 2, keyName = "showIcons", name = "Display spot icons", description = "Configures whether icons for fishing spots are displayed")
    fun showSpotIcons(): Boolean {
        return true
    }

    @ConfigItem(position = 3, keyName = "showNames", name = "Display spot names", description = "Configures whether names for fishing spots are displayed")
    fun showSpotNames(): Boolean {
        return false
    }

    @Alpha
    @ConfigItem(keyName = "overlayColor", name = "Overlay Color", description = "Color of overlays", position = 4)
    fun getOverlayColor(): Color? {
        return Color.CYAN
    }

    @Alpha
    @ConfigItem(keyName = "minnowsOverlayColor", name = "Minnows Overlay", description = "Color of overlays for Minnows", position = 5)
    fun getMinnowsOverlayColor(): Color? {
        return Color.RED
    }

    @Alpha
    @ConfigItem(keyName = "aerialOverlayColor", name = "Aerial Overlay", description = "Color of overlays when 1-tick aerial fishing", position = 6)
    fun getAerialOverlayColor(): Color? {
        return Color.GREEN
    }

    @Alpha
    @ConfigItem(keyName = "harpoonfishOverlayColor", name = "Harpoonfish Overlay", description = "Color of overlays for bubbling Harpoonfish spots", position = 6)
    fun getHarpoonfishOverlayColor(): Color? {
        return Color.GREEN
    }

    @Range(max = 360)
    @ConfigItem(position = 7, keyName = "statTimeout", name = "Reset stats", description = "The time until fishing session data is reset in minutes.")
    @Units(Units.MINUTES)
    fun statTimeout(): Int {
        return 5
    }

    @ConfigItem(position = 8, keyName = "showFishingStats", name = "Show Fishing session stats", description = "Display the fishing session stats.")
    fun showFishingStats(): Boolean {
        return true
    }

    @ConfigItem(position = 9, keyName = "showMinnowOverlay", name = "Show Minnow Movement overlay", description = "Display the minnow progress pie overlay.")
    fun showMinnowOverlay(): Boolean {
        return true
    }

    @ConfigItem(position = 11, keyName = "trawlerTimer", name = "Trawler timer in M:SS", description = "Trawler timer will display a more accurate timer in M:SS format.")
    fun trawlerTimer(): Boolean {
        return true
    }

    @ConfigItem(position = 12, keyName = "trawlerContribution", name = "Trawler contribution", description = "Display the exact number of trawler contribution points gained.")
    fun trawlerContribution(): Boolean {
        return true
    }
}