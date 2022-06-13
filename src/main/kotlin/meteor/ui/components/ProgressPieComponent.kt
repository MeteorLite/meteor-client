/*
 * Copyright (c) 2018, Kamiel
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
package meteor.ui.components

import net.runelite.api.Point
import java.awt.*
import java.awt.geom.Arc2D

class ProgressPieComponent : RenderableEntity {
    var diameter = 25
    var borderColor = Color.WHITE
    var fill = Color.WHITE
    var stroke: Stroke = BasicStroke(1F)
    var progress = 0.0
    var position: Point? = null
    override fun render(graphics: Graphics2D): Dimension {
        val position: Point = position!!
        //Construct the arc
        val arc = Arc2D.Float(Arc2D.PIE)
        arc.angleStart = 90.0
        arc.angleExtent = progress * 360
        arc.setFrame(
            (position.x - diameter / 2).toDouble(), (position.y - diameter / 2).toDouble(), diameter.toDouble(),
            diameter.toDouble()
        )

        //Draw the inside of the arc
        graphics.color = fill
        graphics.fill(arc)

        //Draw the outlines of the arc
        graphics.stroke = stroke
        graphics.color = borderColor
        graphics.drawOval(
            position.x - diameter / 2, position.y - diameter / 2, diameter,
            diameter
        )
        return Dimension(diameter, diameter)
    }

    fun setBorder(border: Color, size: Int) {
        borderColor = border
        stroke = BasicStroke(size.toFloat())
    }
}