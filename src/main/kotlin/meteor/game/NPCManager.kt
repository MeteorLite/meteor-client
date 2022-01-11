/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.game

import com.google.common.collect.ImmutableMap
import com.google.gson.stream.JsonReader
import java.io.IOException
import net.runelite.api.NpcID
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

object NPCManager {
    private var statsMap: ImmutableMap<Int, NPCStats>? = null
    @Throws(IOException::class)
    private fun loadStats() {
        JsonReader(
            InputStreamReader(
                NPCManager::class.java.getResourceAsStream("/npc_stats.json"),
                StandardCharsets.UTF_8
            )
        ).use { reader ->
            val builder: ImmutableMap.Builder<Int, NPCStats> = ImmutableMap.builder<Int, NPCStats>()
            reader.beginObject()
            while (reader.hasNext()) {
                builder.put(
                    reader.nextName().toInt(),
                    NPCStats.NPC_STATS_TYPE_ADAPTER.read(reader)
                )
            }
            reader.endObject()
            statsMap = builder.build()
        }
    }

    /**
     * Returns the [NPCStats] for target NPC id
     *
     * @param npcId NPC id
     * @return the [NPCStats] or null if unknown
     */
    fun getStats(npcId: Int): NPCStats? {
        return statsMap!![npcId]
    }

    /**
     * Returns health for target NPC ID
     *
     * @param npcId NPC id
     * @return health or null if unknown
     */
    fun getHealth(npcId: Int): Int {
        val s: NPCStats? = statsMap!![npcId]
        return if (s == null || s.hitpoints == -1) {
            -1
        } else s.hitpoints
    }

    /**
     * Returns the attack speed for target NPC ID.
     *
     * @param npcId NPC id
     * @return attack speed in game ticks for NPC ID.
     */
    fun getAttackSpeed(npcId: Int): Int {
        val s: NPCStats? = statsMap!![npcId]
        return if (s == null || s.attackSpeed == -1) {
            -1
        } else s.attackSpeed
    }

    /**
     * Returns the exp modifier for target NPC ID based on its stats.
     *
     * @param npcId NPC id
     * @return npcs exp modifier. Assumes default xp rate if npc stats are unknown (returns 1)
     */
    fun getXpModifier(npcId: Int): Double {
        if (blacklistXpMultiplier.contains(npcId)) {
            return 1.0
        }
        val s: NPCStats = statsMap!![npcId] ?: return 1.0
        return s.calculateXpModifier()
    }

    private val blacklistXpMultiplier: Set<Int> = HashSet(
        Arrays.asList( // Vorkath
            NpcID.VORKATH,
            NpcID.VORKATH_8058,
            NpcID.VORKATH_8059,
            NpcID.VORKATH_8060,
            NpcID.VORKATH_8061,  // Grotesque Guardians
            NpcID.DAWN,
            NpcID.DAWN_7852,
            NpcID.DAWN_7853,
            NpcID.DAWN_7884,
            NpcID.DAWN_7885,
            NpcID.DUSK,
            NpcID.DUSK_7851,
            NpcID.DUSK_7854,
            NpcID.DUSK_7855,
            NpcID.DUSK_7882,
            NpcID.DUSK_7883,
            NpcID.DUSK_7886,
            NpcID.DUSK_7887,
            NpcID.DUSK_7888,
            NpcID.DUSK_7889,  // Kraken
            NpcID.KRAKEN,
            NpcID.KRAKEN_6640,
            NpcID.KRAKEN_6656,  // Zulrah
            NpcID.ZULRAH,
            NpcID.ZULRAH_2043,
            NpcID.ZULRAH_2044
        )
    )

    init {
        loadStats()
    }
}