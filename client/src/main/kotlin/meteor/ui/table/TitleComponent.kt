/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package meteor.ui.table

import meteor.ui.components.ComponentConstants
import meteor.ui.components.LayoutableRenderableEntity
import java.awt.*

class TitleComponent : LayoutableRenderableEntity {
    var text: String? = null
    var color = Color.WHITE
    private var preferredLocation: Point? = Point()
    private var preferredSize: Dimension? = Dimension(ComponentConstants.STANDARD_WIDTH, 0)
    private var bounds: Rectangle? = Rectangle()
    override fun render(graphics: Graphics2D): Dimension {
        val baseX = preferredLocation!!.x
        val baseY = preferredLocation!!.y
        val metrics = graphics.fontMetrics
        val titleComponent = TextComponent()
        titleComponent.text = text
        titleComponent.color = color
        titleComponent.position = Point(
                baseX + (preferredSize!!.width - metrics.stringWidth(text)) / 2,
                baseY + metrics.height)
        val rendered = titleComponent.render(graphics)
        val dimension = Dimension(preferredSize!!.width, rendered!!.height)
        bounds!!.location = preferredLocation
        bounds!!.size = dimension
        return dimension
    }

    override fun getPreferredLocation(): Point? {
        return preferredLocation
    }

    override fun getPreferredSize(): Dimension? {
        return preferredSize
    }

    override fun setPreferredLocation(position: Point?) {
        preferredLocation = position
    }

    override fun setPreferredSize(position: Dimension?) {
        preferredSize = position
    }

    fun text(s: String) : TitleComponent {
        text = s
        return this
    }

    fun color(c: Color) : TitleComponent {
        color = c
        return this
    }

    companion object {
        fun builder() : TitleComponent {
            return TitleComponent()
        }
    }
}