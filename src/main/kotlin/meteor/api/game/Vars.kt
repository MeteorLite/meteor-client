package meteor.api.game

import Main.client
import net.runelite.api.VarClientInt
import net.runelite.api.VarClientStr
import net.runelite.api.Varbits

object Vars {
    fun getBit(id: Int): Int? {
        return GameThread.invokeLater { client.getVarbitValue(client.varps, id) }
    }

    fun getBit(varbits: Varbits): Int? {
        return getBit(varbits.id)
    }

    fun getVarp(id: Int): Int {
        return client.getVarpValue(client.varps, id)
    }

    fun getVarcInt(varClientInt: VarClientInt?): Int {
        return client.getVar(varClientInt)
    }

    fun getVarcStr(varClientStr: VarClientStr?): String {
        return client.getVar(varClientStr)
    }
}