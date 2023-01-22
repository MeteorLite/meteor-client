package meteor.plugins.banksetups

import meteor.ui.components.ImageComponent
import meteor.ui.overlay.OverlayLayer
import meteor.ui.overlay.OverlayPanel
import meteor.ui.overlay.OverlayPosition
import meteor.util.ImageUtil
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import java.awt.*
import java.awt.image.BufferedImage

class BankSetupsOverlay : OverlayPanel() {
    var img: BufferedImage? = null

    init {
        position = OverlayPosition.DYNAMIC
        layer = OverlayLayer.ABOVE_WIDGETS
    }

    override fun render(graphics: Graphics2D): Dimension? {
        panelComponent.children.clear()
        if (img == null) {
            img = ImageUtil.loadImageResource(javaClass, "/setups.png")
        }
        val incinerator: Widget? = client.getWidget(WidgetInfo.BANK_INCINERATOR)
        if (img != null && incinerator != null) {
            if (!incinerator.isHidden) {
                img = scale(img!!, incinerator.width - 11, incinerator.height - 11)
                panelComponent.children.add(ImageComponent(img))
                val p = incinerator.canvasLocation
                val x = p.x
                val y = p.y
                panelComponent.setPreferredLocation(Point(x, y - (incinerator.height + 10)))
                bounds = (panelComponent.bounds)
                return panelComponent.render(graphics)
            }
        }
        return null
    }

    private fun resize(src: BufferedImage, targetSize: Int): BufferedImage {
        if (targetSize <= 0) {
            return src //this can't be resized
        }
        var targetWidth = targetSize
        var targetHeight = targetSize
        val ratio: Float = src.height.toFloat() / src.width.toFloat()
        if (ratio <= 1) { //square or landscape-oriented image
            targetHeight = Math.ceil((targetWidth.toFloat() * ratio).toDouble()).toInt()
        } else { //portrait image
            targetWidth = Math.round(targetHeight.toFloat() / ratio)
        }
        val bi = BufferedImage(
            targetWidth,
            targetHeight,
            if (src.transparency == Transparency.OPAQUE) BufferedImage.TYPE_INT_RGB else BufferedImage.TYPE_INT_ARGB
        )
        val g2d: Graphics2D = bi.createGraphics()
        g2d.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR
        ) //produces a balanced resizing (fast and decent quality)
        g2d.drawImage(src, 0, 0, targetWidth, targetHeight, null)
        g2d.dispose()
        return bi
    }

    companion object {
        fun scale(src: BufferedImage, w: Int, h: Int): BufferedImage {
            val img = BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB)
            var y: Int
            val ww: Int = src.width
            val hh: Int = src.height
            var x: Int = 0
            while (x < w) {
                y = 0
                while (y < h) {
                    val col: Int = src.getRGB(x * ww / w, y * hh / h)
                    img.setRGB(x, y, col)
                    y++
                }
                x++
            }
            return img
        }
    }
}