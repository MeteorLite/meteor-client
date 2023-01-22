/*
 * Copyright (c) 2019, Lucas <https://github.com/lucwousin>
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
package meteor.plugins.alchemicalhydra

import meteor.game.SpriteManager
import meteor.util.ImageUtil.resizeImage
import net.runelite.api.*
import java.awt.image.BufferedImage

class Hydra(val npc: NPC) {
    internal enum class AttackStyle(val projectileID: Int = 0, val prayer: Prayer? = null,
                                    private val spriteID: Int = 0
    ) {
        MAGIC(1662, Prayer.PROTECT_FROM_MAGIC, SpriteID.PRAYER_PROTECT_FROM_MAGIC), RANGED(
            1663,
            Prayer.PROTECT_FROM_MISSILES,
            SpriteID.PRAYER_PROTECT_FROM_MISSILES
        );

        private var image: BufferedImage? = null
        fun getImage(spriteManager: SpriteManager): BufferedImage? {
            if (image == null) {
                val tmp = spriteManager.getSprite(spriteID, 0)
                image = if (tmp == null) null else resizeImage(
                    tmp,
                    HydraOverlay.IMGSIZE,
                    HydraOverlay.IMGSIZE
                )
            }
            return image
        }
    }

    internal var phase = HydraPhase.ONE
    var attackCount = 0
    var nextSwitch = phase.attacksPerSwitch

    var nextSpecial = 3
    internal var nextAttack = AttackStyle.MAGIC
    private var lastAttack = AttackStyle.MAGIC

    var weakened = false
    fun changePhase(newPhase: HydraPhase) {
        phase = newPhase
        nextSpecial = 3
        attackCount = 0
        weakened = false
        if (newPhase == HydraPhase.FOUR) {
            weakened = true
            switchStyles()
            nextSwitch = phase.attacksPerSwitch
        }
    }

    private fun switchStyles() {
        nextAttack = if (lastAttack == AttackStyle.MAGIC) AttackStyle.RANGED else AttackStyle.MAGIC
    }

    fun handleAttack(id: Int) {
        if (id != nextAttack.projectileID) {
            if (id == lastAttack.projectileID) {
                // If the current attack isn't what was expected and we accidentally counted 1 too much
                return
            }

            // If the current attack isn't what was expected and we should have switched prayers
            switchStyles()
            nextSwitch = phase.attacksPerSwitch - 1
        } else {
            nextSwitch--
        }
        lastAttack = nextAttack
        attackCount++
        if (nextSwitch <= 0) {
            switchStyles()
            nextSwitch = phase.attacksPerSwitch
        }
    }

    val nextSpecialRelative: Int
        get() = nextSpecial - attackCount
}