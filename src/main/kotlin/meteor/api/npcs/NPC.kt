package meteor.api.npcs

import dev.hoot.api.InteractionException
import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.game.GameThread
import dev.hoot.api.packets.NPCPackets
import meteor.Logger
import meteor.Main
import meteor.api.packets.ClientPackets.createClientPacket
import net.runelite.api.MenuAction
import net.runelite.api.packets.PacketBufferNode

class NPC(var npc: net.runelite.api.NPC) {
    val log = Logger("[${npc.name}]")
    val client = Main.client

    fun interact(action: String) {
        if (npc.actions == null) {
            return
        }
        val index = arrayListOf<String>(*npc.rawActions).indexOf(action)
        if (index == -1) {
            log.warn("No action found for $action")
            return
        }
        invoke(index)
    }

    fun invoke(index: Int) {
        GameThread.invoke { createClientPacket(npc.getMenu(index))!!.send() }
    }
}