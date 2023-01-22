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
package meteor.ui.overlay

import com.google.common.base.Strings
import meteor.Main
import meteor.plugins.EventSubscriber
import meteor.ui.components.LayoutableRenderableEntity
import meteor.util.ColorUtil
import net.runelite.api.Perspective
import net.runelite.api.coords.LocalPoint
import net.runelite.api.widgets.WidgetInfo
import java.awt.*
import java.awt.image.BufferedImage
import kotlin.math.abs

abstract class Overlay(var layer: OverlayLayer = OverlayLayer.ABOVE_SCENE) : LayoutableRenderableEntity,
    EventSubscriber() {
    constructor(graphics: Graphics2D, polygon: Shape, color: Color, stroke: Stroke) : this()

    constructor(start: Color, interactClickColor: Color, t: Float) : this()

    val client = Main.client
    val drawHooks: ArrayList<Int> = ArrayList()
    open val menuEntries: ArrayList<OverlayMenuEntry> = ArrayList()

    var preferredPosition: OverlayPosition? = null

    var position = OverlayPosition.DETACHED
    var priority: OverlayPriority = OverlayPriority.NONE
    var resizable = false
    val minimumSize = 32
    val resettable = true

    private var preferredLocationp: Point? = Point()
    private var preferredSizep: Dimension? = null
    var bounds: Rectangle? = Rectangle()

    override fun getPreferredLocation(): Point? {
        return preferredLocationp
    }

    override fun getPreferredSize(): Dimension? {
        return this.preferredSizep
    }

    override fun setPreferredLocation(position: Point?) {
        preferredLocationp = position
    }

    override fun setPreferredSize(position: Dimension?) {
        this.preferredSizep = position
    }

    /**
     * Whether this overlay can be dragged onto other overlays &amp; have other overlays dragged onto
     * it.
     */
    var dragTargetable = false

    /**
     * Overlay name, used for saving the overlay, needs to be unique
     *
     * @return overlay name
     */
    open val name: String
        get() = this.javaClass.simpleName

    protected fun drawAfterInterface(interfaceId: Int) {
        drawHooks.add(interfaceId shl 16 or 0xffff)
    }

    protected fun drawAfterLayer(layer: WidgetInfo) {
        drawHooks.add(layer.packedId)
    }

    fun onMouseOver() {}
    fun onMouseEnter() {}
    fun onMouseExit() {}

    open fun onDrag(other: Overlay?): Boolean {
        return false
    }

    //Fuck it
    open var parentBounds = Rectangle(0, 0, 10000, 10000)

    open fun renderPolygon(graphics: Graphics2D, poly: Shape, color: Color) {
        renderPolygon(graphics, poly, color, BasicStroke(2F))
    }

    open fun renderPolygon(
        graphics: Graphics2D, poly: Shape, color: Color,
        borderStroke: Stroke
    ) {
        graphics.color = color
        val originalStroke = graphics.stroke
        graphics.stroke = borderStroke
        graphics.draw(poly)
        graphics.color = Color(0, 0, 0, 50)
        graphics.fill(poly)
        graphics.stroke = originalStroke
    }

    open fun renderTextLocation(
        graphics: Graphics2D, txtString: String, fontSize: Int,
        fontStyle: Int, fontColor: Color, canvasPoint: net.runelite.api.Point, shadows: Boolean, yOffset: Int
    ) {
        graphics.font = Font("Arial", fontStyle, fontSize)
        val canvasCenterPoint = net.runelite.api.Point(
            canvasPoint.x,
            canvasPoint.y + yOffset
        )
        val canvasCenterPointShadow = net.runelite.api.Point(
            canvasPoint.x + 1,
            canvasPoint.y + 1 + yOffset
        )
        if (shadows) {
            renderTextLocation(graphics, canvasCenterPointShadow, txtString, Color.BLACK)
        }
        renderTextLocation(graphics, canvasCenterPoint, txtString, fontColor)
    }

    open fun renderTextLocation(
        graphics: Graphics2D, txtLoc: net.runelite.api.Point, text: String,
        color: Color
    ) {
        if (Strings.isNullOrEmpty(text)) {
            return
        }
        val x = txtLoc.x
        val y = txtLoc.y
        graphics.color = Color.BLACK
        graphics.drawString(text, x + 1, y + 1)
        graphics.color = ColorUtil.colorWithAlpha(color, 0xFF)
        graphics.drawString(text, x, y)
    }

    open fun outlineImage(image: BufferedImage, color: Color): BufferedImage {
        return outlineImage(image, color, false)
    }

    open fun fillImage(image: BufferedImage, color: Color): BufferedImage {
        val filledImage = BufferedImage(
            image.width, image.height,
            BufferedImage.TYPE_INT_ARGB
        )
        for (x in 0 until filledImage.width) {
            for (y in 0 until filledImage.height) {
                val pixel = image.getRGB(x, y)
                val a = pixel ushr 24
                if (a == 0) {
                    continue
                }
                filledImage.setRGB(x, y, color.rgb)
            }
        }
        return filledImage
    }

    open fun renderImageLocation(graphics: Graphics2D, imgLoc: net.runelite.api.Point, image: BufferedImage) {
        val x = imgLoc.x
        val y = imgLoc.y
        graphics.drawImage(image, x, y, null)
    }

    open fun renderImageLocation(
        graphics: Graphics2D, localPoint: LocalPoint,
        image: BufferedImage, zOffset: Int
    ) {
        val imageLocation = Perspective
            .getCanvasImageLocation(client, localPoint, image, zOffset)
        if (imageLocation != null) {
            renderImageLocation(graphics, imageLocation, image)
        }
    }

    open fun outlineImage(
        image: BufferedImage, color: Color,
        outlineCorners: Boolean
    ): BufferedImage {
        val filledImage: BufferedImage = fillImage(image, color)
        val outlinedImage = BufferedImage(
            image.width, image.height,
            BufferedImage.TYPE_INT_ARGB
        )
        val g2d = outlinedImage.createGraphics()
        for (x in -1..1) {
            for (y in -1..1) {
                if (x == 0 && y == 0
                    || !outlineCorners && abs(x) + abs(y) != 1
                ) {
                    continue
                }
                g2d.drawImage(filledImage, x, y, null)
            }
        }
        g2d.drawImage(image, 0, 0, null)
        g2d.dispose()
        return outlinedImage
    }
}