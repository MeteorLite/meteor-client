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
package net.runelite.client.plugins.grounditems

import lombok.RequiredArgsConstructor
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import java.awt.Color
import java.util.function.Function

class Lootbeam(
    private val client: Client,
    private val clientThread: ClientThread,
    worldPoint: WorldPoint?,
    color: Color?,
    style: Style
) {
    private val runeLiteObject: RuneLiteObject
    private var color: Color?
    private var style: Style

    @RequiredArgsConstructor
    enum class Style(val modelSupplier: Function<Lootbeam, Model?>?, val animationSupplier: Function<Lootbeam, Animation>?) {
        LIGHT(Function { l: Lootbeam ->
            l.client.loadModel(
                5809, shortArrayOf(6371), shortArrayOf(JagexColor.rgbToHSL(l.color!!.rgb, 1.0))
            )!!
        }, anim(AnimationID.RAID_LIGHT_ANIMATION)),
        MODERN(
            Function { l: Lootbeam ->
                val md = l.client.loadModelData(43330) ?: return@Function null
                val hsl = JagexColor.rgbToHSL(l.color!!.rgb, 1.0)
                val hue = JagexColor.unpackHue(hsl)
                val sat = JagexColor.unpackSaturation(hsl)
                val lum = JagexColor.unpackLuminance(hsl)
                val satDelta = if (sat > 2) 1 else 0
                md.cloneColors()
                    .recolor(26432.toShort(), JagexColor.packHSL(hue, sat - satDelta, lum))
                    .recolor(
                        26584.toShort(),
                        JagexColor.packHSL(hue, sat, Math.min(lum + 24, JagexColor.LUMINANCE_MAX))
                    )
                    .light(
                        75 + ModelData.DEFAULT_AMBIENT, 1875 + ModelData.DEFAULT_CONTRAST,
                        ModelData.DEFAULT_X, ModelData.DEFAULT_Y, ModelData.DEFAULT_Z
                    )
            }, anim(AnimationID.LOOTBEAM_ANIMATION)
        );
    }

    init {
        runeLiteObject = client.createRuneLiteObject()
        this.color = color
        this.style = style
        update()
        runeLiteObject.setShouldLoop(true)
        val lp = LocalPoint.fromWorld(client, worldPoint)
        runeLiteObject.setLocation(lp, client.plane)
        runeLiteObject.isActive = true
    }

    fun setColor(color: Color) {
        if ((this.color != null) && this.color == color) {
            return
        }
        this.color = color
        update()
    }

    fun setStyle(style: Style) {
        if (this.style == style) {
            return
        }
        this.style = style
        update()
    }

    private fun update() {
        clientThread.invoke {
            val model = style.modelSupplier!!.apply(this)
            val anim = style.animationSupplier!!.apply(this)
            runeLiteObject.setAnimation(anim)
            runeLiteObject.model = model
            true
        }
    }

    fun remove() {
        runeLiteObject.isActive = false
    }

    companion object {
        private fun anim(id: Int): Function<Lootbeam, Animation> {
            return Function { b: Lootbeam ->
                b.client.loadAnimation(
                    id
                )
            }
        }
    }
}