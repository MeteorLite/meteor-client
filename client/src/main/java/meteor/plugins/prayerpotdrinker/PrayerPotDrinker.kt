package meteor.plugins.prayerpotdrinker

import eventbus.events.ConfigChanged
import eventbus.events.GameTick
import meteor.api.Items
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import java.util.*

@PluginDescriptor(name = "Prayer Pot Drinker", description = "Automatically drinks pray pots", enabledByDefault = false)
class PrayerPotDrinker : Plugin() {
    private var config = configuration<PrayerPotDrinkerConfig>()

    private val r = Random()
    private var nextRestoreVal = 0

    private fun getRestoreVal(): Int {
        return r.nextInt(config.maxPrayerLevel() - config.minPrayerLevel()) + config.minPrayerLevel()
    }

    override fun onStart() {
        nextRestoreVal = getRestoreVal()
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group != "praypotdrinker") {
            return
        }
        nextRestoreVal = getRestoreVal()
    }

    private var ticktimer = 0
    override fun onGameTick(it: GameTick) {
        if (client.gameState != GameState.LOGGED_IN) {
            return
        }

        if (ticktimer > 0) {
            ticktimer--
            return
        }

        val currentPrayerPoints = client.getBoostedSkillLevel(Skill.PRAYER)
        if (currentPrayerPoints <= nextRestoreVal) {
            Items.getFirst(
                ItemID.PRAYER_POTION1,
                ItemID.PRAYER_POTION2,
                ItemID.PRAYER_POTION3,
                ItemID.PRAYER_POTION4,
                ItemID.SUPER_RESTORE1,
                ItemID.SUPER_RESTORE2,
                ItemID.SUPER_RESTORE3,
                ItemID.SUPER_RESTORE4,
                ItemID.BLIGHTED_SUPER_RESTORE1,
                ItemID.BLIGHTED_SUPER_RESTORE2,
                ItemID.BLIGHTED_SUPER_RESTORE3,
                ItemID.BLIGHTED_SUPER_RESTORE1,
                ItemID.BLIGHTED_SUPER_RESTORE2,
                ItemID.BLIGHTED_SUPER_RESTORE3,
                ItemID.BLIGHTED_SUPER_RESTORE4,
                ItemID.SANFEW_SERUM1,
                ItemID.SANFEW_SERUM2,
                ItemID.SANFEW_SERUM3,
                ItemID.SANFEW_SERUM4
            )?.interact("Drink")
            nextRestoreVal =
                r.nextInt(config.maxPrayerLevel() - config.minPrayerLevel()) + config.minPrayerLevel()
            ticktimer = 2
        }
    }
}