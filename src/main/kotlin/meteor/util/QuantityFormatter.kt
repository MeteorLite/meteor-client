/*
 * Copyright (c) 2018, arlyon <https://github.com/arlyon>
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

import java.text.NumberFormat
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.ParseException
import java.util.*
import java.util.regex.Pattern

/**
 * A set of utility functions to use when formatting quantities
 */
object QuantityFormatter {
    /**
     * A list of suffixes to use when formatting stack sizes.
     */
    private val SUFFIXES = arrayOf("", "K", "M", "B")

    /**
     * A pattern to match a value suffix (K, M etc) in a string.
     */
    private val SUFFIX_PATTERN = Pattern.compile("^-?[0-9,.]+([a-zA-Z]?)$")
    private val NUMBER_FORMATTER = NumberFormat.getInstance(Locale.ENGLISH)
    private val DECIMAL_FORMATTER: NumberFormat = DecimalFormat(
        "#,###.#",
        DecimalFormatSymbols.getInstance(Locale.ENGLISH)
    )
    private val PRECISE_DECIMAL_FORMATTER: NumberFormat = DecimalFormat(
        "#,###.###",
        DecimalFormatSymbols.getInstance(Locale.ENGLISH)
    )

    /**
     * Convert a quantity to a short, comma separated, SI-prefix style string
     *
     *
     * example: `9,450`, `2.14B`, `100K`
     *
     * @param quantity The quantity to convert.
     * @return a 6 or less character string, possibly with a decimal point, commas or K/M/B suffix
     */
    @Synchronized
    @JvmStatic
    fun quantityToStackSize(quantity: Long): String {
        if (quantity < 0) {
            // Long.MIN_VALUE = -1 * Long.MIN_VALUE so we need to correct for it.
            return "-" + quantityToStackSize(if (quantity == Long.MIN_VALUE) Long.MAX_VALUE else -quantity)
        } else if (quantity < 10000) {
            return NUMBER_FORMATTER.format(quantity)
        }
        var suffix = SUFFIXES[0]
        var divideBy: Long = 1

        // determine correct suffix by iterating backward through the list
        // of suffixes until the suffix results in a value >= 1
        for (i in SUFFIXES.size - 1 downTo 0) {
            divideBy = Math.pow(10.0, (i * 3).toDouble()).toLong()
            if (quantity.toDouble() / divideBy >= 1) {
                suffix = SUFFIXES[i]
                break
            }
        }

        // get locale formatted string
        var formattedString = NUMBER_FORMATTER.format(quantity.toDouble() / divideBy)

        // strip down any digits past the 4 first
        formattedString = if (formattedString.length > 4) formattedString.substring(0, 4) else formattedString

        // make sure the last character is not a "."
        return ((if (formattedString.endsWith(".")) formattedString.substring(0, 3) else formattedString)
                + suffix)
    }

    /**
     * Convert a quantity to a short SI-prefix style string, possibly with a decimal, with K after
     * 100,000 and M after 10,000,000
     *
     *
     * example: `9,450`, `2.1B`, `100K`
     *
     * @see .quantityToRSDecimalStack
     */
    fun quantityToRSDecimalStack(quantity: Int): String {
        return quantityToRSDecimalStack(quantity, false)
    }

    /**
     * Convert a quantity to a short SI-prefix style string, possibly with decimals, with K after
     * 100,000 and M after 10,000,000
     *
     *
     * example without `precise`: `9,450`, `2.1B`, `8.4M` example with `precise`: `9,450`, `2.147B`, `8.32M`
     *
     * @param precise If true, allow thousandths precision if `quantity` is larger than 1
     * million. Otherwise have at most a single decimal
     */
    @Synchronized
    fun quantityToRSDecimalStack(quantity: Int, precise: Boolean): String {
        val quantityStr = quantity.toString()
        if (quantityStr.length <= 4) {
            return quantityStr
        }
        val power = Math.log10(quantity.toDouble()).toInt()

        // Output thousandths for values above a million
        val format = if (precise && power >= 6) PRECISE_DECIMAL_FORMATTER else DECIMAL_FORMATTER
        return format.format(quantity / Math.pow(10.0, (power / 3 * 3).toDouble())) + SUFFIXES[power / 3]
    }

    /**
     * Converts a string representation of a stack back to (close to) it's original value.
     *
     * @param string The string to convert.
     * @return A long representation of it.
     */
    @Synchronized
    @Throws(ParseException::class)
    fun parseQuantity(string: String): Long {
        val multiplier = getMultiplier(string)
        val parsedValue = NUMBER_FORMATTER.parse(string).toFloat()
        return (parsedValue * multiplier).toLong()
    }

    /**
     * Formats a number to be comma delimited. No suffixes are given
     *
     *
     * example: `10,123,351`, `5`
     */
    @Synchronized
    fun formatNumber(number: Long): String {
        return NUMBER_FORMATTER.format(number)
    }

    /**
     * Formats a number to be comma delimited. No suffixes are given. Has at most 3 decimal places
     *
     *
     * example: `10,123,351`, `5.612`
     */
    @Synchronized
    fun formatNumber(number: Double): String {
        return NUMBER_FORMATTER.format(number)
    }

    /**
     * Calculates, given a string with a value denominator (for example, 20K) the multiplier that the
     * denominator represents (in this case 1000).
     *
     * @param string The string to check.
     * @return The value of the value denominator.
     * @throws ParseException When the denominator does not match a known value.
     */
    @Throws(ParseException::class)
    private fun getMultiplier(string: String): Int {
        val suffix: String
        val matcher = SUFFIX_PATTERN.matcher(string)
        suffix = if (matcher.find()) {
            matcher.group(1)
        } else {
            throw ParseException(
                "$string does not resemble a properly formatted stack.",
                string.length - 1
            )
        }
        return if (suffix != "") {
            for (i in 1 until SUFFIXES.size) {
                if (SUFFIXES[i] == suffix.uppercase(Locale.getDefault())) {
                    return Math.pow(10.0, (i * 3).toDouble()).toInt()
                }
            }
            throw ParseException("Invalid Suffix: $suffix", string.length - 1)
        } else {
            1
        }
    }
}