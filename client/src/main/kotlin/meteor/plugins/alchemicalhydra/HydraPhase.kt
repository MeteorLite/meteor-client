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
import net.runelite.api.coords.WorldPoint
import java.awt.image.BufferedImage

enum class HydraPhase(val attacksPerSwitch: Int = 0, val deathAnim1: Int = 0, val deathAnim2: Int = 0,
                      val specProjectileId: Int = 0, val specAnimationId: Int = 0, private val specImageID: Int = 0,
                      val fountain: WorldPoint? = null
) {
    ONE(3, 8237, 8238, 1644, 0, 1774, WorldPoint(1371, 10263, 0)), TWO(
        3,
        8244,
        8245,
        0,
        8241,
        1959,
        WorldPoint(1371, 10272, 0)
    ),
    THREE(3, 8251, 8252, 0, 8248, 1800, WorldPoint(1362, 10272, 0)), FOUR(1, 8257, 8258, 1644, 0, 1774, null);

    private var specImage: BufferedImage? = null
    fun getSpecImage(spriteManager: SpriteManager): BufferedImage? {
        if (specImage == null) {
            val tmp = spriteManager.getSprite(specImageID, 0)
            specImage = if (tmp == null) null else resizeImage(
                tmp,
                HydraOverlay.IMGSIZE,
                HydraOverlay.IMGSIZE
            )
        }
        return specImage
    }
}