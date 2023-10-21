package net.runelite.api

import java.awt.Color
import java.awt.Graphics2D
import java.awt.Rectangle

class TileItem(val id: Int, val x: Int, val y: Int, val width: Int, val height: Int) {
    var quantity = 1
    fun drawTextAboveBoundsShadowed(graphics: Graphics2D, text: String, offset: Int = 0) {
        val originalColor = graphics.color
        val textWidth: Int = getTextWidth(graphics, text)
        val textHeight: Int = getTextHeight(graphics, text)
        val padding: Int = width - textWidth
        val y = y - (offset * textHeight)
        graphics.color = Color.BLACK
        graphics.drawString(text, x + (padding / 2) + 1, y + 1)
        graphics.color = originalColor
        graphics.drawString(text, x + (padding / 2), y)
    }

    fun getTextWidth(graphics: Graphics2D, text: String): Int {
        return graphics.fontMetrics.getStringBounds(text, graphics).width.toInt()
    }

    fun getTextHeight(graphics: Graphics2D, text: String): Int {
        return graphics.fontMetrics.getStringBounds(text, graphics).height.toInt()
    }

    fun getBounds(): Rectangle {
        return Rectangle(x, y, width, height)
    }

    override fun equals(other: Any?): Boolean {
        if (other is TileItem) {
            if (other.id == id)
                if (other.x == x)
                    if (other.y == y)
                        if (other.width == width)
                            if (other.height == height)
                                return true
        }
        return false
    }
}