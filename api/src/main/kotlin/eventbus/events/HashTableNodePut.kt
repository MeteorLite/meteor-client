package eventbus.events

import meteor.Event
import net.runelite.api.HashTable
import net.runelite.api.Node

/**
 * @author Kris | 23/10/2021
 */
data class HashTableNodePut(
    val hashTable: HashTable<out Node>? = null,
    val node: Node? = null,
    val value: Long
) : Event()