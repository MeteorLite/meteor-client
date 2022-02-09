package meteor.util

import net.runelite.api.Client
import net.runelite.api.SpritePixels
import java.awt.Image
import java.awt.image.BufferedImage
import java.awt.image.DirectColorModel
import java.awt.image.PixelGrabber
import java.io.IOException
import javax.imageio.ImageIO

object ImageUtil {
    fun loadImageResource(c: Class<*>, path: String): BufferedImage {
        try {
            c.getResourceAsStream(path).use { `in` -> synchronized(ImageIO::class.java) { return ImageIO.read(`in`) } }
        } catch (e: IllegalArgumentException) {
            val filePath: String = if (path.startsWith("/")) {
                path
            } else {
                c.getPackage().name.replace('.', '/') + "/" + path
            }
            throw IllegalArgumentException(path, e)
        } catch (e: IOException) {
            throw RuntimeException(path, e)
        }
    }

    fun resizeImage(
        image: BufferedImage, newWidth: Int,
        newHeight: Int
    ): BufferedImage {
        return resizeImage(image, newWidth, newHeight, false)
    }

    fun resizeImage(
        image: BufferedImage, newWidth: Int,
        newHeight: Int, preserveAspectRatio: Boolean
    ): BufferedImage {
        val resized: Image
        resized = if (preserveAspectRatio) {
            if (image.width > image.height) {
                image.getScaledInstance(newWidth, -1, Image.SCALE_SMOOTH)
            } else {
                image.getScaledInstance(-1, newHeight, Image.SCALE_SMOOTH)
            }
        } else {
            image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH)
        }
        return bufferedImageFromImage(resized)
    }

    fun bufferedImageFromImage(image: Image): BufferedImage {
        return if (image is BufferedImage) {
            image
        } else toARGB(image)
    }

    fun toARGB(image: Image): BufferedImage {
        if (image is BufferedImage
            && image.type == BufferedImage.TYPE_INT_ARGB
        ) {
            return image
        }
        val out = BufferedImage(
            image.getWidth(null), image.getHeight(null),
            BufferedImage.TYPE_INT_ARGB
        )
        val g2d = out.createGraphics()
        g2d.drawImage(image, 0, 0, null)
        g2d.dispose()
        return out
    }

    fun resizeCanvas(
        image: BufferedImage, newWidth: Int,
        newHeight: Int
    ): BufferedImage {
        val dimg = BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB)
        val centeredX = newWidth / 2 - image.width / 2
        val centeredY = newHeight / 2 - image.height / 2
        val g2d = dimg.createGraphics()
        g2d.drawImage(image, centeredX, centeredY, null)
        g2d.dispose()
        return dimg
    }

    fun getImageSpritePixels(image: BufferedImage, client: Client): SpritePixels {
        val pixels = IntArray(image.width * image.height)
        try {
            val g = PixelGrabber(
                image, 0, 0, image.width, image.height, pixels, 0,
                image.width
            )
            g.colorModel = DirectColorModel(32, 0xff0000, 0xff00, 0xff, -0x1000000)
            g.grabPixels()

            // Make any fully transparent pixels fully black, because the sprite draw routines
            // check for == 0, not actual transparency
            for (i in pixels.indices) {
                if (pixels[i] and -0x1000000 == 0) {
                    pixels[i] = 0
                }
            }
        } catch (ignore: InterruptedException) {
        }
        return client.createSpritePixels(pixels, image.width, image.height)
    }
}