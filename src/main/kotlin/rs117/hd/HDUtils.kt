/*
 * Copyright (c) 2021, 117 <https://twitter.com/117scape>
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

import java.lang.StringBuilder
import com.jogamp.opengl.math.VectorUtil

object HDUtils {
    @JvmStatic
    fun vectorAdd(vec1: FloatArray, vec2: FloatArray): FloatArray {
        val out = FloatArray(vec1.size)
        for (i in vec1.indices) {
            out[i] = vec1[i] + vec2[i]
        }
        return out
    }

    @JvmStatic
    fun vectorAdd(vec1: FloatArray, vec2: IntArray): FloatArray {
        val out = FloatArray(vec1.size)
        for (i in vec1.indices) {
            out[i] = vec1[i] + vec2[i]
        }
        return out
    }

    @JvmStatic
    fun vectorAdd(vec1: IntArray, vec2: IntArray): IntArray {
        val out = IntArray(vec1.size)
        for (i in vec1.indices) {
            out[i] = vec1[i] + vec2[i]
        }
        return out
    }

    @JvmStatic
    fun vectorAdd(vec1: DoubleArray, vec2: DoubleArray): DoubleArray {
        val out = DoubleArray(vec1.size)
        for (i in vec1.indices) {
            out[i] = vec1[i] + vec2[i]
        }
        return out
    }

    @JvmStatic
    fun vectorAdd(vec1: Array<Double>, vec2: Array<Double>): Array<Double?> {
        val out = arrayOfNulls<Double>(vec1.size)
        for (i in vec1.indices) {
            out[i] = vec1[i] + vec2[i]
        }
        return out
    }

    @JvmStatic
    fun vectorDivide(vec1: FloatArray, divide: Float): FloatArray {
        val out = FloatArray(vec1.size)
        for (i in vec1.indices) {
            if (divide == 0f) {
                out[i] = 0F
            } else {
                out[i] = vec1[i] / divide
            }
        }
        return out
    }

    @JvmStatic
    fun lerp(a: Float, b: Float, t: Float): Float {
        return a + (b - a) * t
    }

    @JvmStatic
    fun lerpVectors(vecA: FloatArray, vecB: FloatArray, t: Float): FloatArray {
        val out = FloatArray(Math.min(vecA.size, vecB.size))
        for (i in out.indices) {
            out[i] = lerp(vecA[i], vecB[i], t)
        }
        return out
    }

    @JvmStatic
    fun lerpVectors(vecA: IntArray, vecB: IntArray, t: Float): IntArray {
        val out = IntArray(Math.min(vecA.size, vecB.size))
        for (i in out.indices) {
            out[i] = lerp(vecA[i].toFloat(), vecB[i].toFloat(), t).toInt()
        }
        return out
    }

    @JvmStatic
    fun vertexHash(vPos: IntArray): Int {
        // simple custom hashing function for vertex position data
        val s = StringBuilder()
        for (i in vPos.indices) {
            s.append(vPos[i]).append(",")
        }
        return s.toString().hashCode()
    }

    @JvmStatic
    fun calculateSurfaceNormals(vertexX: IntArray, vertexY: IntArray, vertexZ: IntArray): FloatArray {
        val vPosition = Array(3) { FloatArray(3) }
        for (i in 0..2) {
            vPosition[i][0] = vertexX[i].toFloat()
            vPosition[i][1] = vertexY[i].toFloat()
            vPosition[i][2] = vertexZ[i].toFloat()
        }

        // calculate normals
        val a = VectorUtil.subVec3(FloatArray(3), vPosition[0], vPosition[1])
        val b = VectorUtil.subVec3(FloatArray(3), vPosition[0], vPosition[2])
        // cross
        return VectorUtil.crossVec3(FloatArray(3), a, b)
    }

    @JvmStatic
    fun colorIntToHSL(colorInt: Int): IntArray {
        val outHSL = IntArray(3)
        outHSL[0] = colorInt shr 10 and 0x3F
        outHSL[1] = colorInt shr 7 and 0x7
        outHSL[2] = colorInt and 0x7F
        return outHSL
    }

    @JvmStatic
    fun colorHSLToInt(colorHSL: IntArray): Int {
        return colorHSL[0] shl 3 or colorHSL[1] shl 7 or colorHSL[2]
    }

    @JvmStatic
    fun colorIntToRGB(colorInt: Int): IntArray {
        val outHSL = IntArray(3)
        outHSL[0] = colorInt shr 10 and 0x3F
        outHSL[1] = colorInt shr 7 and 0x7
        outHSL[2] = colorInt and 0x7F
        return colorHSLToRGB(
            outHSL[0].toFloat(), outHSL[1].toFloat(), outHSL[2].toFloat()
        )
    }

    @JvmStatic
    fun colorRGBToInt(colorRGB: FloatArray): Int {
        val colorRGBInt = IntArray(3)
        for (i in colorRGB.indices) {
            colorRGBInt[i] = (colorRGB[i] * 255).toInt()
        }
        return colorRGBInt[0] shl 8 or colorRGBInt[1] shl 8 or colorRGBInt[2] or 134217728
    }

    @JvmStatic
    fun colorHSLToRGB(h: Float, s: Float, l: Float): IntArray {
        var h = h
        var s = s
        var l = l
        h /= 64f
        s /= 8f
        l /= 128f
        var q = 0f
        q = if (l < 0.5) l * (1 + s) else l + s - s * l
        val p = 2 * l - q
        var r = Math.max(0f, HueToRGB(p, q, h + 1.0f / 3.0f))
        var g = Math.max(0f, HueToRGB(p, q, h))
        var b = Math.max(0f, HueToRGB(p, q, h - 1.0f / 3.0f))
        r = Math.min(r, 1.0f)
        g = Math.min(g, 1.0f)
        b = Math.min(b, 1.0f)
        return intArrayOf((r * 255f).toInt(), (g * 255f).toInt(), (b * 255f).toInt())
    }

    @JvmStatic
    fun HueToRGB(p: Float, q: Float, h: Float): Float {
        var h = h
        if (h < 0) h += 1f
        if (h > 1) h -= 1f
        if (6 * h < 1) {
            return p + (q - p) * 6 * h
        }
        if (2 * h < 1) {
            return q
        }
        return if (3 * h < 2) {
            p + (q - p) * 6 * (2.0f / 3.0f - h)
        } else p
    }

    @JvmStatic
    fun linearToGamma(c: Float): Float {
        val gamma = 2.2f
        return Math.pow(c.toDouble(), (1.0f / gamma).toDouble()).toFloat()
    }

    @JvmStatic
    fun gammaToLinear(c: Float): Float {
        val gamma = 2.2f
        return Math.pow(c.toDouble(), gamma.toDouble()).toFloat()
    }
}