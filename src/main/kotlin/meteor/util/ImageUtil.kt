package meteor.util

import java.awt.image.BufferedImage
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
}