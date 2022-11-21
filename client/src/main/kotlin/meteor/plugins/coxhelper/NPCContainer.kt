/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
 * Copyright (c) 2019, Ganom <https://github.com/Ganom>
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
package meteor.plugins.coxhelper

import lombok.AccessLevel
import lombok.AllArgsConstructor
import lombok.Getter
import lombok.Setter
import net.runelite.api.Actor
import net.runelite.api.NPC
import java.awt.Color


internal class NPCContainer(val npc: NPC) {
    private val npcIndex: Int = npc.index
    private val npcName: String = npc.name
    var npcSize = 0

    var ticksUntilAttack: Int = 0

    private val intermissionPeriod: Int = 0

    private val npcSpeed: Int = 0

    private val npcInteracting: Actor? = npc.interacting

    @Setter(AccessLevel.PACKAGE)
    var attackStyle: Attackstyle

    init {
        attackStyle = Attackstyle.UNKNOWN
        val composition = npc.transformedComposition
        if (composition != null) {
            npcSize = composition.size
        }
    }

    @AllArgsConstructor
    @Getter(AccessLevel.PACKAGE)
    enum class Attackstyle(private val name_: String? = null, val color: Color? = null) {
        MAGE("Mage", Color.CYAN), RANGE("Range", Color.GREEN), MELEE("Melee", Color.RED), UNKNOWN(
            "Unknown",
            Color.WHITE
        );

    }
}