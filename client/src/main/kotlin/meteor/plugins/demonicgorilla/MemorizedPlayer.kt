package meteor.plugins.demonicgorilla

import net.runelite.api.Hitsplat
import net.runelite.api.Player
import net.runelite.api.coords.WorldArea

internal class MemorizedPlayer(val player: Player) {
    var lastWorldArea: WorldArea? = null
    val recentHitsplats: MutableList<Hitsplat?>

    init {
        recentHitsplats = ArrayList()
    }
}