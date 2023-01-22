/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/Kyleeld>
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
package meteor.plugins.gauntletextended.overlay

import meteor.game.SpriteManager
import meteor.ui.components.ComponentConstants.STANDARD_BACKGROUND_COLOR
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import meteor.ui.overlay.PanelComponent
import meteor.ui.overlay.components.InfoBoxComponent
import net.runelite.api.Prayer
import net.runelite.api.SpriteID
import meteor.plugins.gauntletextended.GauntletExtendedConfig
import meteor.plugins.gauntletextended.GauntletExtendedConfig.PrayerHighlightMode
import meteor.plugins.gauntletextended.GauntletExtendedPlugin
import java.awt.*
import java.awt.image.BufferedImage

class OverlayPrayerBox(private val plugin: GauntletExtendedPlugin, private val config: GauntletExtendedConfig) :
    Overlay(
        plugin
    ) {
    private val spriteManager = SpriteManager
    private val panelComponent: PanelComponent
    private val infoBoxComponent: InfoBoxComponent
    private var spriteProtectFromMagic: BufferedImage? = null
    private var spriteProtectFromRange: BufferedImage? = null

    init {
        panelComponent = PanelComponent()
        infoBoxComponent = InfoBoxComponent()
        infoBoxComponent.color = Color.WHITE
        infoBoxComponent.setPreferredSize(Dimension(40, 40))
        panelComponent.children.add(infoBoxComponent)
        panelComponent.setPreferredSize(Dimension(40, 40))
        panelComponent.border = Rectangle(0, 0, 0, 0)
        position = OverlayPosition.BOTTOM_RIGHT
        priority = OverlayPriority.HIGH
        determineLayer()
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val prayerHighlightMode = config.prayerOverlay()
        if (prayerHighlightMode == PrayerHighlightMode.NONE || prayerHighlightMode == PrayerHighlightMode.WIDGET) {
            return null
        }
        val hunllef = plugin.hunllef ?: return null
        val npc = hunllef.npc
        if (npc == null || npc.isDead) {
            return null
        }
        val prayer = hunllef.attackPhase.prayer
        infoBoxComponent.image = getPrayerSprite(prayer!!)
        infoBoxComponent.backgroundColor =
            if (client.isPrayerActive(prayer)) STANDARD_BACKGROUND_COLOR else NOT_ACTIVATED_BACKGROUND_COLOR
        return panelComponent.render(graphics)
    }

    override fun determineLayer() {
        layer = OverlayLayer.UNDER_WIDGETS
    }

    private fun getPrayerSprite(prayer: Prayer): BufferedImage? {
        return when (prayer) {
            Prayer.PROTECT_FROM_MAGIC -> {
                if (spriteProtectFromMagic == null) {
                    spriteProtectFromMagic = scaleSprite(
                        spriteManager.getSprite(
                            SpriteID.PRAYER_PROTECT_FROM_MAGIC,
                            0
                        )
                    )
                }
                spriteProtectFromMagic
            }
            Prayer.PROTECT_FROM_MISSILES -> {
                if (spriteProtectFromRange == null) {
                    spriteProtectFromRange = scaleSprite(
                        spriteManager.getSprite(
                            SpriteID.PRAYER_PROTECT_FROM_MISSILES,
                            0
                        )
                    )
                }
                spriteProtectFromRange
            }
            else -> throw IllegalStateException("Unexpected boss attack phase prayer: $prayer")
        }
    }

    companion object {
        private val NOT_ACTIVATED_BACKGROUND_COLOR = Color(150, 0, 0, 150)
        private fun scaleSprite(bufferedImage: BufferedImage?): BufferedImage? {
            if (bufferedImage == null) {
                return null
            }
            val width = bufferedImage.getWidth(null).toDouble()
            val height = bufferedImage.getHeight(null).toDouble()
            val size = 36.0 // Limit size to 2 as that is minimum size not causing breakage
            val scalex = size / width
            val scaley = size / height
            val scale = Math.min(scalex, scaley)
            val newWidth = (width * scale).toInt()
            val newHeight = (height * scale).toInt()
            val scaledImage = BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB)
            val g: Graphics = scaledImage.createGraphics()
            g.drawImage(bufferedImage, 0, 0, newWidth, newHeight, null)
            g.dispose()
            return scaledImage
        }
    }
}