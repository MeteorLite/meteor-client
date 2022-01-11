/*
 * Copyright (c) 2017, Tomas Slusny <slusnucky@gmail.com>
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
package meteor.ui.overlay

import meteor.ui.components.ComponentConstants
import meteor.ui.components.LayoutableRenderableEntity
import java.awt.*
import java.util.ArrayList

class PanelComponent : LayoutableRenderableEntity {

    override val bounds = Rectangle()

    val children: ArrayList<LayoutableRenderableEntity> = ArrayList<LayoutableRenderableEntity>()
    val childDimensions = Dimension()

    override var preferredLocation: Point? = Point()

    override var preferredSize: Dimension? = Dimension(ComponentConstants.STANDARD_WIDTH, 0)

    var backgroundColor = ComponentConstants.STANDARD_BACKGROUND_COLOR

    val orientation: ComponentOrientation = ComponentOrientation.VERTICAL

    val wrap = false

    var border = Rectangle(
            ComponentConstants.STANDARD_BORDER,
            ComponentConstants.STANDARD_BORDER,
            ComponentConstants.STANDARD_BORDER,
            ComponentConstants.STANDARD_BORDER)

    var gap = Point(0, 0)

    override fun render(graphics: Graphics2D): Dimension? {
        if (children.isEmpty()) {
            return null
        }

        // Calculate panel dimension
        val dimension = Dimension(
                border.x + childDimensions.width + border.width,
                border.y + childDimensions.height + border.height)

        // Render background
        val backgroundComponent = BackgroundComponent()
        backgroundComponent.rectangle = Rectangle(preferredLocation, dimension)
        backgroundComponent.backgroundColor = backgroundColor
        backgroundComponent.render(graphics)

        // Offset children
        val baseX = preferredLocation!!.x + border.x
        val baseY = preferredLocation!!.y + border.y
        var width = 0
        var height = 0
        var x = baseX
        var y = baseY

        // Create child preferred size
        val childPreferredSize = Dimension(
                preferredSize!!.width - border.x - border.width,
                preferredSize!!.height - border.y - border.height)

        // Calculate max width/height for infoboxes
        var totalHeight = 0
        var totalWidth = 0

        // Render all children
        for (child in children) {
            // Correctly propagate child dimensions based on orientation and wrapping
            if (!wrap) {
                when (orientation) {
                    ComponentOrientation.VERTICAL -> child.preferredSize = (Dimension(childPreferredSize.width, 0))
                    ComponentOrientation.HORIZONTAL -> child.preferredSize = (Dimension(0, childPreferredSize.height))
                }
            }
            child.preferredLocation = (Point(x, y))
            val childDimension: Dimension? = child.render(graphics)
            when (orientation) {
                ComponentOrientation.VERTICAL -> {
                    height += childDimension!!.height + gap.y
                    y = baseY + height
                    width = width.coerceAtLeast(childDimension.width)
                }
                ComponentOrientation.HORIZONTAL -> {
                    width += childDimension!!.width + gap.x
                    x = baseX + width
                    height = height.coerceAtLeast(childDimension.height)
                }
            }

            // Calculate total size
            totalWidth = totalWidth.coerceAtLeast(width)
            totalHeight = totalHeight.coerceAtLeast(height)
            if (!wrap) {
                continue
            }
            when (orientation) {
                ComponentOrientation.VERTICAL -> {
                    if (childPreferredSize.height in 1..height) {
                        height = 0
                        y = baseY
                        val diff = childDimension.width + gap.x
                        x += diff
                        width += diff
                    }
                }
                ComponentOrientation.HORIZONTAL -> {
                    if (childPreferredSize.width in 1..width) {
                        width = 0
                        x = baseX
                        val diff = childDimension.height + gap.y
                        y += diff
                        height += diff
                    }
                }
            }
        }

        // Remove last child gap
        if (orientation == ComponentOrientation.HORIZONTAL) {
            totalWidth -= gap.x
        } else  // VERTICAL
        {
            totalHeight -= gap.y
        }

        // Cache children bounds
        childDimensions.setSize(totalWidth, totalHeight)

        // Cache bounds
        bounds.location = preferredLocation
        bounds.size = dimension
        return dimension
    }
}