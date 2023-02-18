/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
package net.runelite.api

import dev.hoot.api.events.AutomatedMenu
import eventbus.Events
import meteor.Logger
import meteor.api.loot.Interact

/**
 * Represents a non-player character in the game.
 */
@JvmDefaultWithCompatibility
interface NPC : Actor {
    companion object {
        lateinit var client: Client
        var log = Logger("NPC")
    }
    /**
     * Gets the ID of the NPC.
     *
     * @return the ID of the NPC
     * //@see NpcID
     */
    var id: Int
    override fun getName(): String?
    override fun getCombatLevel(): Int

    fun getMenu(actionIndex: Int): AutomatedMenu?

    /**
     * Gets the index position of this NPC in the clients cached
     * NPC array.
     *
     * @return the NPC index
     * @see Client.getCachedNPCs
     */
    val index: Int

    /**
     * Gets the composition of this NPC.
     *
     * @return the composition
     */
    var composition: NPCComposition?

    /**
     * Get the composition for this NPC and transform it if required
     *
     * @return the transformed NPC
     */
    var transformedComposition: NPCComposition?
    var transformedId: Int?
    var transformedName: String?
    var transformedLevel: Int?

    // Kris changes:
    fun getNameOverride(): String?

    override infix fun interact(action: String) {
        if (composition?.actions == null) {
            return
        }
        val index = arrayListOf(*rawActions).indexOf(action)
        if (index == -1) {
            log.warn("No action found for $action")
            return
        }
        invoke(index)
    }

    fun invoke(index: Int) {
        client.callbacks.post(Events.INTERACT, getMenu(index)?.let { Interact(it) })
    }
}