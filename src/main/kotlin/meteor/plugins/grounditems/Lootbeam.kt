/*
 * Copyright (c) 2021, Trevor <https://github.com/Trevor159>
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
package meteor.plugins.grounditems

import net.runelite.api.coords.WorldPoint
import net.runelite.api.AnimationID
import net.runelite.api.Client
import net.runelite.api.JagexColor
import net.runelite.api.RuneLiteObject
import net.runelite.api.coords.LocalPoint
import java.awt.Color

internal class Lootbeam(private val client: Client, worldPoint: WorldPoint?, color: Color) {
    private val runeLiteObject: RuneLiteObject
    private var color: Color? = null
    fun setColor(color: Color) {
        if (this.color != null && this.color == color) {
            return
        }
        this.color = color
        runeLiteObject.setModel(
            client.loadModel(
                RAID_LIGHT_MODEL, shortArrayOf(RAID_LIGHT_FIND_COLOR), shortArrayOf(JagexColor.rgbToHSL(color.rgb, 1.0))
            )
        )
    }

    fun remove() {
        runeLiteObject.isActive = false
    }

    companion object {
        private const val RAID_LIGHT_MODEL = 5809
        private const val RAID_LIGHT_FIND_COLOR: Short = 6371
    }

    init {
        runeLiteObject = client.createRuneLiteObject()
        setColor(color)
        runeLiteObject.setAnimation(client.loadAnimation(AnimationID.RAID_LIGHT_ANIMATION))
        runeLiteObject.setShouldLoop(true)
        val lp = LocalPoint.fromWorld(client, worldPoint)
        runeLiteObject.setLocation(lp, client.plane)
        runeLiteObject.isActive = true
    }
}