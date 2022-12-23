package eventbus.events

import meteor.Event
import net.runelite.api.NPC

/**
 * @author Kris | 27/10/2021
 */
data class NPCMoved(
    val npc: NPC?,
    val x: Int,
    val y: Int,
    val type: Int
) : Event()