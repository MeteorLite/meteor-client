/*
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package meteor.util

import com.google.common.primitives.Ints
import java.awt.Color
import java.lang.NumberFormatException
import java.util.regex.Pattern
import javax.annotation.Nonnull
import kotlin.math.roundToInt

object ColorUtil {
    const val MAX_RGB_VALUE = 255
    const val MIN_RGB_VALUE = 0
    const val CLOSING_COLOR_TAG = "</col>"
    private const val OPENING_COLOR_TAG_START = "<col="
    private const val OPENING_COLOR_TAG_END = ">"
    private val ALPHA_HEX_PATTERN = Pattern.compile("^(#|0x)?[0-9a-fA-F]{7,8}")
    private val HEX_PATTERN = Pattern.compile("^(#|0x)?[0-9a-fA-F]{1,8}")

    /**
     * Creates a color tag from the given color.
     *
     * @param color The Color to create a tag from.
     * @return A string of the color tag for the given color.
     */
    fun colorTag(color: Color): String {
        return OPENING_COLOR_TAG_START + colorToHexCode(color) + OPENING_COLOR_TAG_END
    }

    /**
     * Prepends the given str with an opening color tag of the given color.
     *
     * @param str   The string to be colorized.
     * @param color The color to be used in the color tag.
     * @return The passed str with a prepended color tag.
     */
    @JvmStatic
    fun prependColorTag(str: String, color: Color): String {
        return colorTag(color) + str
    }

    /**
     * Wraps the given str with a color tag of the given color.
     *
     * @param str   The string to be colorized.
     * @param color The color to be used in the color tag.
     * @return The passed str wrapped with opening and closing color tags.
     */
    @JvmStatic
    fun wrapWithColorTag(str: String, color: Color): String {
        return prependColorTag(str, color) + CLOSING_COLOR_TAG
    }

    /**
     * Converts a given color to it's hexadecimal equivalent.
     *
     * @param color Color to get hexadecimal string from.
     * @return Hexadecimal string representing the given color, in the form "#abcdef".
     */
    fun toHexColor(color: Color): String {
        return "#" + colorToHexCode(color)
    }

    /**
     * Linearly interpolates between colors a and b by t.
     *
     * @param a first color
     * @param b second color
     * @param t factor
     * @return interpolated color
     */
    fun colorLerp(a: Color, b: Color, t: Double): Color {
        val r1 = a.red.toDouble()
        val r2 = b.red.toDouble()
        val g1 = a.green.toDouble()
        val g2 = b.green.toDouble()
        val b1 = a.blue.toDouble()
        val b2 = b.blue.toDouble()
        return Color((r1 + t * (r2 - r1)).roundToInt(),
            (g1 + t * (g2 - g1)).roundToInt(), (b1 + t * (b2 - b1)).roundToInt()
        )
    }

    /**
     * Gets the RGB hex color code of the passed color.
     *
     * @param color The color to get a hex code from.
     * @return A lower-cased string of the RGB hex code of color.
     */
    fun colorToHexCode(color: Color): String {
        return String.format("%06x", color.rgb and 0xFFFFFF)
    }

    /**
     * Gets the ARGB hex color code of the passed color.
     *
     * @param color The color to get a hex code from.
     * @return A lower-cased string of the ARGB hex code of color.
     */
    fun colorToAlphaHexCode(color: Color): String {
        return String.format("%08x", color.rgb)
    }

    /**
     * Gets the same RGB color with the specified alpha value.
     *
     * @param color The RGB color to use.
     * @param alpha The alpha value to use (0-255).
     * @return A Color with the given RGB and alpha.
     */
    @JvmStatic
    fun colorWithAlpha(color: Color, alpha: Int): Color {
        var alpha = alpha
        if (color.alpha == alpha) {
            return color
        }
        alpha = constrainValue(alpha)
        return Color(color.rgb and 0x00ffffff or (alpha shl 24), true)
    }

    /**
     * Determines if the passed hex string is an alpha hex color.
     *
     * @param hex The hex to test.
     * @return boolean
     */
    fun isAlphaHex(hex: String?): Boolean {
        return ALPHA_HEX_PATTERN.matcher(hex).matches()
    }

    /**
     * Determines if the passed hex string is a hex color.
     *
     * @param hex The hex to test.
     * @return boolean
     */
    fun isHex(hex: String?): Boolean {
        return HEX_PATTERN.matcher(hex).matches()
    }

    /**
     * Limits an int to the rgba value range (0-255)
     *
     * @param value The value for the r, g, b, or a.
     * @return An int between 0 - 255.
     */
    fun constrainValue(value: Int): Int {
        return Ints.constrainToRange(value, MIN_RGB_VALUE, MAX_RGB_VALUE)
    }

    /**
     * Gets the Color from the passed int string.
     *
     * @param string The int to get a Color object from.
     * @return A Color of the int of color.
     */
    fun fromString(string: String?): Color? {
        return try {
            val i = Integer.decode(string)
            Color(i, true)
        } catch (e: NumberFormatException) {
            null
        }
    }

    /**
     * Gets the Color from the passed hex string.
     *
     * @param hex The hex to get a Color object from.
     * @return A Color of the hex code of color.
     */
    fun fromHex(hex: String): Color? {
        var hex = hex
        if (!hex.startsWith("#") && !hex.startsWith("0x")) {
            hex = "#$hex"
        }
        return if (hex.length <= 7 && hex.startsWith("#") || hex.length <= 8 && hex.startsWith("0x")) {
            try {
                Color.decode(hex)
            } catch (e: NumberFormatException) {
                null
            }
        } else try {
            Color(java.lang.Long.decode(hex).toInt(), true)
        } catch (e: NumberFormatException) {
            null
        }
    }

    /**
     * Creates color from passed object hash code
     *
     * @param object object with hashCode
     * @return color
     */
    fun fromObject(@Nonnull `object`: Any): Color {
        val i = `object`.hashCode()
        val h = i % 360 / 360f
        return Color.getHSBColor(h, 1f, 1f)
    }
}