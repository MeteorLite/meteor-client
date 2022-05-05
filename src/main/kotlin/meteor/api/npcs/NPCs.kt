package meteor.api.npcs

import meteor.Main

object NPCs {
    fun getAll(): ArrayList<NPC>? {
        var npcs : ArrayList<NPC>? = null
        for (npc in Main.client.npcs) {
            npc?.let {
                val npc = NPC(it)
                if (npcs == null) {
                    npcs = ArrayList()
                    npcs!!.add(npc)
                } else
                    npcs!!.add(npc)
            }
        }
        return npcs
    }

    fun getAll(vararg ids: Int): ArrayList<NPC>? {
        return getAll()?.filter { ids.contains(it.npc.id) } as ArrayList?
    }

    fun getAll(vararg names: String): ArrayList<NPC>? {
        return getAll()?.filter { names.contains(it.npc.name) } as ArrayList?
    }

    fun getFirst(id: Int) : NPC? {
        return getAll(id)?.firstOrNull()
    }

    fun getFirst(name: String) : NPC? {
        return getAll(name)?.firstOrNull()
    }
}