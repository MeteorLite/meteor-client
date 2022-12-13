package meteor.plugins.prayerpotdrinker

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem

@ConfigGroup("praypotdrinker")
interface PrayerPotDrinkerConfig : Config {
    @ConfigItem(keyName = "minPrayerLevel", name = "Minimum", description = "", position = 1, textField = true)
    fun minPrayerLevel(): Int {
        return 1
    }

    @ConfigItem(keyName = "maxPrayerLevel", name = "Maximum", description = "", position = 2, textField = true)
    fun maxPrayerLevel(): Int {
        return 30
    }
}