package dev.botlin.api.commons

object NumericFormat {
    const val COMMAS: Byte = 0x1
    const val THOUSANDS: Byte = 0x40

    private val POSTFIXES = charArrayOf('K', 'M', 'B', 'T')
    private const val HYPHEN = '-'
    private const val COMMA = ','
    private const val ZERO = '0'
    private const val DOT = '.'

    fun precision(precision: Int): Int {
        return precision shl 2
    }

    fun apply(value: Double): String {
        return apply(value, THOUSANDS.toInt() or COMMAS.toInt() or precision(2))
    }

    fun apply(value: Long, settings: Int): String {
        val builder = StringBuilder(32)
        builder.append(value)

        val buff = builder.toString().toCharArray()
        val commas = settings and COMMAS.toInt() == COMMAS.toInt()
        var precision = 0
        var postfix = 0

        if (settings >= 0x40) {
            postfix = settings shr 6
            if (postfix > POSTFIXES.size) {
                postfix = POSTFIXES.size
            }
        }

        if (settings > COMMAS) {
            precision = settings shr 2 and 0xF
        }

        builder.setLength(0)

        var negative = 0
        if (buff[0] == HYPHEN) {
            negative = 1
        }

        val length = buff.size - negative
        if (postfix * 3 >= length) {
            postfix = (length * 0.334).toInt()
            if (postfix * 3 == length && precision == 0) {
                --postfix
            }
        }

        var end = length - postfix * 3
        var start = length % 3
        if (start == 0) {
            start = 3
        }

        start += negative

        if (end > 0 && negative == 1) {
            builder.append(HYPHEN)
        }

        var max = end + negative
        for (i in negative until max) {
            if (i == start && i + 2 < max && commas) {
                start += 3
                builder.append(COMMA)
            }
            builder.append(buff[i])
        }

        if (postfix > 0) {
            if (end == 0) {
                if (negative == 1 && precision > 0) {
                    builder.append(HYPHEN)
                }

                builder.append(ZERO)
            }

            max = precision + end + negative

            if (max > buff.size) {
                max = buff.size
            }

            end += negative

            while (max > end) {
                if (buff[max - 1] != ZERO) {
                    break
                }
                --max
            }

            if (max - end != 0) {
                builder.append(DOT)
            }

            for (i in end until max) {
                builder.append(buff[i])
            }
            builder.append(POSTFIXES[postfix - 1])
        }

        return builder.toString()
    }
}
