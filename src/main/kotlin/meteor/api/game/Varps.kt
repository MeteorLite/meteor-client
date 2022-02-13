package meteor.api.game

import Main.client
import net.runelite.api.Varbits

object Varps {

    /**
     * Gets varbit value of given varp id.
     */
    fun getBit(id: Int): Int {
        return GameThread.invokeLater { client.getVarbitValue(client.getVarps(), id) } ?: -1
    }

    /**
     * Gets varbit value of given Varbit object.
     */
    fun getBit(varbits: Varbits): Int {
        return getBit(varbits.id)
    }

    /**
     * Gets varp value of given varp id.
     */
    operator fun get(id: Int): Int {
        return client.getVarpValue(client.getVarps(), id)
    }
}