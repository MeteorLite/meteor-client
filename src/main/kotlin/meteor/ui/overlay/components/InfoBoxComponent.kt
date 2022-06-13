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
package meteor.ui.overlay.components

import com.google.common.base.Strings
import meteor.game.FontManager
import meteor.ui.components.ComponentConstants
import meteor.ui.components.LayoutableRenderableEntity
import meteor.ui.overlay.BackgroundComponent
import meteor.ui.overlay.infobox.InfoBox
import java.awt.*
import java.awt.image.BufferedImage

class InfoBoxComponent : LayoutableRenderableEntity {
    private var bounds: Rectangle? = Rectangle()
    var tooltip: String? = null
    private var preferredLocation: Point? = Point()
    private var preferredSize: Dimension? = Dimension(DEFAULT_SIZE, DEFAULT_SIZE)
    var text: String? = null
    var color = Color.WHITE
    var outline = false
    var backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR
    var image: BufferedImage? = null
    var infoBox: InfoBox? = null


    override fun getPreferredSize(): Dimension? {
        return preferredSize
    }

    override fun setBounds(rectangle: Rectangle?) {
        bounds = rectangle
    }

    override fun getBounds(): Rectangle? {
        return bounds
    }

    override fun getPreferredLocation(): Point? {
        return preferredLocation
    }

    override fun setPreferredSize(position: Dimension?) {
        preferredSize = position
    }

    override fun setPreferredLocation(position: Point?) {
        preferredLocation = position
    }

    override fun render(graphics: Graphics2D): Dimension? {
        if (image == null) {
            return Dimension()
        }
        graphics.font = if (size < DEFAULT_SIZE) FontManager.runescapeSmallFont else FontManager.runescapeFont
        val baseX = preferredLocation!!.x
        val baseY = preferredLocation!!.y

        // Calculate dimensions
        val metrics = graphics.fontMetrics
        val size = size
        val bounds = Rectangle(baseX, baseY, size, size)

        // Render background
        val backgroundComponent = BackgroundComponent()
        backgroundComponent.backgroundColor = (backgroundColor)
        backgroundComponent.rectangle = (bounds)
        backgroundComponent.render(graphics)

        // Render image
        graphics.drawImage(
            image,
            baseX + (size - image!!.getWidth(null)) / 2,
            baseY + (size - image!!.getHeight(null)) / 2,
            null
        )

        // Render caption
        if (!Strings.isNullOrEmpty(text)) {
            val textComponent = TextComponent()
            textComponent.color = (color)
            textComponent.outline = (outline)
            textComponent.text = (text)
            textComponent.position = (
                    Point(baseX + (size - metrics.stringWidth(text)) / 2, baseY + size - SEPARATOR)
                    )
            textComponent.render(graphics)
        }
        this.bounds!!.bounds = bounds
        return bounds.size
    }

    private val size: Int
        get() = Math.max(preferredSize!!.width, preferredSize!!.height)

    companion object {
        private const val SEPARATOR = 3
        private const val DEFAULT_SIZE = 32
    }
}