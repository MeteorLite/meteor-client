package meteor.api.loot

import dev.hoot.api.game.GameThread
import meteor.Logger
import meteor.api.packets.ClientPackets
import net.runelite.api.TileItem

class Loot(var loot: TileItem) {
    val log = Logger("[${loot.name}]")
    var index = -1

    fun interact(action: String) {
        if (loot.actions == null) {
            return
        }
        index = arrayListOf<String>(*loot.rawActions).indexOf(action)
        if (index == -1) {
            log.warn("Action idx not found for $action")
            return
        }
        invoke(index)
    }

    fun take() {
        log.info("[Take] ${loot.id} ${loot.name} ${loot.worldLocation.x} ${loot.worldLocation.y}")
        GameThread.invoke { ClientPackets.createGroundItemActionPacket("OPOBJ3",
                loot.id,
                loot.worldLocation.x,
                loot.worldLocation.y,
                false
        ).send() }
    }

    fun invoke(index: Int) {
        GameThread.invoke { ClientPackets.createClientPacket(loot.getMenu(index))!!.send() }
    }
}