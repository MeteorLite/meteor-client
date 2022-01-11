/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package rs117.hd

import com.jogamp.opengl.GL4
import com.jogamp.opengl.GL2ES3
import com.jogamp.opengl.GL
import meteor.Logger
import net.runelite.api.Texture
import net.runelite.api.TextureProvider
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.awt.image.DataBufferByte
import java.nio.ByteOrder
import java.io.IOException
import java.nio.ByteBuffer

object TextureManager {
    var log = Logger(TextureManager.toString())
    fun initTextureArray(textureProvider: TextureProvider, gl: GL4): Int {
        if (!allTexturesLoaded(textureProvider)) {
            return -1
        }
        val textures = textureProvider.textures
        val textureArrayId = GLUtil.glGenTexture(gl)
        gl.glBindTexture(GL2ES3.GL_TEXTURE_2D_ARRAY, textureArrayId)
        gl.glTexStorage3D(GL2ES3.GL_TEXTURE_2D_ARRAY, 8, GL.GL_SRGB8_ALPHA8, TEXTURE_SIZE, TEXTURE_SIZE, textures.size)
        gl.glTexParameteri(GL2ES3.GL_TEXTURE_2D_ARRAY, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST)
        gl.glTexParameteri(GL2ES3.GL_TEXTURE_2D_ARRAY, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST)
        gl.glTexParameteri(GL2ES3.GL_TEXTURE_2D_ARRAY, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP_TO_EDGE)

        // Set brightness to 1.0d to upload unmodified textures to GPU
        val save = textureProvider.brightness
        textureProvider.`setBrightness$api`(1.0)
        updateTextures(textureProvider, gl, textureArrayId)
        textureProvider.`setBrightness$api`(save)
        gl.glActiveTexture(GL.GL_TEXTURE1)
        gl.glBindTexture(GL2ES3.GL_TEXTURE_2D_ARRAY, textureArrayId)
        gl.glGenerateMipmap(GL2ES3.GL_TEXTURE_2D_ARRAY)
        gl.glActiveTexture(GL.GL_TEXTURE0)
        return textureArrayId
    }

    fun initTextureHDArray(textureProvider: TextureProvider, gl: GL4): Int {
        if (!allTexturesLoaded(textureProvider)) {
            return -1
        }
        val textures = textureProvider.textures
        val textureCount = 300 // Based on image ids from filenames
        val textureArrayId = GLUtil.glGenTexture(gl)
        gl.glBindTexture(GL2ES3.GL_TEXTURE_2D_ARRAY, textureArrayId)
        gl.glTexStorage3D(GL2ES3.GL_TEXTURE_2D_ARRAY, 8, GL.GL_SRGB8_ALPHA8, TEXTURE_SIZE, TEXTURE_SIZE, textureCount)
        gl.glTexParameteri(GL2ES3.GL_TEXTURE_2D_ARRAY, GL.GL_TEXTURE_WRAP_S, GL.GL_REPEAT)
        gl.glTexParameteri(GL2ES3.GL_TEXTURE_2D_ARRAY, GL.GL_TEXTURE_WRAP_T, GL.GL_REPEAT)
        val save = textureProvider.brightness
        textureProvider.`setBrightness$api`(1.0)
        var cnt = 0
        for (textureId in 0 until textureCount) {
            if (loadHDTexture(textureId, textureProvider, gl, textures)) {
                cnt++
            }
        }
        textureProvider.`setBrightness$api`(save)
        gl.glActiveTexture(GL.GL_TEXTURE2)
        gl.glBindTexture(GL2ES3.GL_TEXTURE_2D_ARRAY, textureArrayId)
        gl.glGenerateMipmap(GL2ES3.GL_TEXTURE_2D_ARRAY)
        gl.glActiveTexture(GL.GL_TEXTURE0)
        return textureArrayId
    }

    fun loadHDTexture(textureId: Int, textureProvider: TextureProvider, gl: GL4, textures: Array<Texture?>): Boolean {
        var width = 0
        var height = 0
        //Create the PNGDecoder object and decode the texture to a buffer
        try {
            javaClass.getResourceAsStream("textures/$textureId.png").use { `in` ->
                if (`in` != null) {
                    var image: BufferedImage
                    synchronized(ImageIO::class.java) { image = ImageIO.read(`in`) }
                    width = image.width
                    height = image.height
                    val hasAlphaChannel = image.alphaRaster != null
                    val bytesPerPixel = if (hasAlphaChannel) 4 else 3
                    val pixels = (image.raster.dataBuffer as DataBufferByte).data
                    assert(width * height * bytesPerPixel == pixels.size)

//				ByteBuffer pixelData = BufferUtils.createByteBuffer(width * height * bytesPerPixel);
                    val pixelData =
                        ByteBuffer.allocateDirect(width * height * bytesPerPixel).order(ByteOrder.nativeOrder())
                    if (hasAlphaChannel) {
                        // argb -> bgra
                        var i = 0
                        while (i < pixels.size) {
                            val a = pixels[i]
                            val r = pixels[i + 1]
                            val g = pixels[i + 2]
                            val b = pixels[i + 3]
                            pixelData.put(b).put(g).put(r).put(a)
                            i += 4
                        }
                    } else {
                        var i = 0
                        while (i < pixels.size) {
                            val r = pixels[i]
                            val g = pixels[i + 1]
                            val b = pixels[i + 2]
                            pixelData.put(b).put(g).put(r)
                            i += 3
                        }
                    }
                    pixelData.flip()
                    val rgbMode = if (hasAlphaChannel) GL.GL_RGBA else GL.GL_RGB
                    gl.glTexSubImage3D(
                        GL2ES3.GL_TEXTURE_2D_ARRAY, 0, 0, 0, textureId, width, height,
                        1, rgbMode, GL.GL_UNSIGNED_BYTE, pixelData
                    )
                    return true
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return false
        }
        if (textureId < textures.size) {
            val texture = textures[textureId]
            if (texture != null) {
                val srcPixels = textureProvider.load(textureId)
                if (srcPixels == null) {
                    TextureManager.log.warn("No pixels for texture {}!", textureId)
                    return false
                }
                if (srcPixels.size != TEXTURE_SIZE * TEXTURE_SIZE) {
                    // The texture storage is 128x128 bytes, and will only work correctly with the
                    // 128x128 textures from high detail mode
                    TextureManager.log.warn("Texture size for {} is {}!", textureId, srcPixels.size)
                }
                val pixels = convertPixels(srcPixels, TEXTURE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE)
                val pixelBuffer = ByteBuffer.wrap(pixels)
                gl.glTexSubImage3D(
                    GL2ES3.GL_TEXTURE_2D_ARRAY, 0, 0, 0, textureId, TEXTURE_SIZE, TEXTURE_SIZE,
                    1, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, pixelBuffer
                )
                return true
            }
        }
        return false
    }

    fun setAnisotropicFilteringLevel(textureArrayId: Int, level: Int, gl: GL4, trilinearFiltering: Boolean) {
        gl.glBindTexture(GL2ES3.GL_TEXTURE_2D_ARRAY, textureArrayId)

        //level = 0 means no mipmaps and no anisotropic filtering
        if (level == 0) {
            gl.glTexParameteri(GL2ES3.GL_TEXTURE_2D_ARRAY, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST)
        } else {
            if (trilinearFiltering) {
                // Trilinear filtering is used for HD textures as linear filtering produces noisy textures
                // that are very noticeable on terrain
                gl.glTexParameteri(GL2ES3.GL_TEXTURE_2D_ARRAY, GL.GL_TEXTURE_MIN_FILTER, GL.GL_LINEAR_MIPMAP_LINEAR)
            } else {
                // Set on GL_NEAREST_MIPMAP_LINEAR (bilinear filtering with mipmaps) since the pixel nature of the game means that nearest filtering
                // looks best for objects up close but allows linear filtering to resolve possible aliasing and noise with mipmaps from far away objects.
                gl.glTexParameteri(GL2ES3.GL_TEXTURE_2D_ARRAY, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST_MIPMAP_LINEAR)
            }
        }
        if (gl.isExtensionAvailable("GL_EXT_texture_filter_anisotropic")) {
            val maxSamples = GLUtil.glGetFloat(gl, GL.GL_MAX_TEXTURE_MAX_ANISOTROPY_EXT)
            //Clamp from 1 to max GL says it supports.
            val anisoLevel = Math.max(1f, Math.min(maxSamples, level.toFloat()))
            gl.glTexParameterf(GL2ES3.GL_TEXTURE_2D_ARRAY, GL.GL_TEXTURE_MAX_ANISOTROPY_EXT, anisoLevel)
        }
    }

    fun freeTextureArray(gl: GL4, textureArrayId: Int) {
        GLUtil.glDeleteTexture(gl, textureArrayId)
    }

    /**
     * Check if all textures have been loaded and cached yet.
     *
     * @param textureProvider
     * @return
     */
    private fun allTexturesLoaded(textureProvider: TextureProvider): Boolean {
        val textures = textureProvider.textures
        if (textures == null || textures.size == 0) {
            return false
        }
        for (textureId in textures.indices) {
            val texture = textures[textureId]
            if (texture != null) {
                val pixels = textureProvider.load(textureId) ?: return false
            }
        }
        return true
    }

    private fun updateTextures(textureProvider: TextureProvider, gl: GL4, textureArrayId: Int) {
        val textures = textureProvider.textures
        gl.glBindTexture(GL2ES3.GL_TEXTURE_2D_ARRAY, textureArrayId)
        var cnt = 0
        for (textureId in textures.indices) {
            val texture = textures[textureId]
            if (texture != null) {
                val srcPixels = textureProvider.load(textureId)
                if (srcPixels == null) {
                    TextureManager.log.warn("No pixels for texture {}!", textureId)
                    continue  // this can't happen
                }
                ++cnt
                if (srcPixels.size != TEXTURE_SIZE * TEXTURE_SIZE) {
                    // The texture storage is 128x128 bytes, and will only work correctly with the
                    // 128x128 textures from high detail mode
                    TextureManager.log.warn("Texture size for {} is {}!", textureId, srcPixels.size)
                    continue
                }
                val pixels = convertPixels(srcPixels, TEXTURE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE, TEXTURE_SIZE)
                val pixelBuffer = ByteBuffer.wrap(pixels)
                gl.glTexSubImage3D(
                    GL2ES3.GL_TEXTURE_2D_ARRAY, 0, 0, 0, textureId, TEXTURE_SIZE, TEXTURE_SIZE,
                    1, GL.GL_RGBA, GL.GL_UNSIGNED_BYTE, pixelBuffer
                )
            }
        }
    }

    /**
     * Animate the given texture
     *
     * @param texture
     * @param diff    Number of elapsed client ticks since last animation
     */
    fun animate(texture: Texture, diff: Int) {
        val pixels = texture.pixels ?: return
        val animationSpeed = texture.animationSpeed
        val uvdiff = if (pixels.size == 4096) PERC_64 else PERC_128
        var u = texture.u
        var v = texture.v
        val offset = animationSpeed * diff
        val d = offset.toFloat() * uvdiff
        when (texture.animationDirection) {
            1 -> {
                v -= d
                if (v < 0f) {
                    v += 1f
                }
            }
            3 -> {
                v += d
                if (v > 1f) {
                    v -= 1f
                }
            }
            2 -> {
                u -= d
                if (u < 0f) {
                    u += 1f
                }
            }
            4 -> {
                u += d
                if (u > 1f) {
                    u -= 1f
                }
            }
            else -> return
        }
        texture.u = u
        texture.v = v
    }

    private const val PERC_64 = 1f / 64f
    private const val PERC_128 = 1f / 128f
    private const val TEXTURE_SIZE = 128
    private fun convertPixels(
        srcPixels: IntArray,
        width: Int,
        height: Int,
        textureWidth: Int,
        textureHeight: Int
    ): ByteArray {
        val pixels = ByteArray(textureWidth * textureHeight * 4)
        var pixelIdx = 0
        var srcPixelIdx = 0
        val offset = (textureWidth - width) * 4
        for (y in 0 until height) {
            for (x in 0 until width) {
                val rgb = srcPixels[srcPixelIdx++]
                if (rgb != 0) {
                    pixels[pixelIdx++] = (rgb shr 16).toByte()
                    pixels[pixelIdx++] = (rgb shr 8).toByte()
                    pixels[pixelIdx++] = rgb.toByte()
                    pixels[pixelIdx++] = (-1.toByte()).toByte()
                } else {
                    pixelIdx += 4
                }
            }
            pixelIdx += offset
        }
        return pixels
    }
}