package openrsc.formulae

import kotlin.math.floor
import kotlin.math.max
import kotlin.math.min

object FormulaeUtil {
    /**
     * Calculates the chance of succeeding at a skilling event
     * @param low
     * @param high
     * @param level
     * @return percent chance of success
     */
    fun interp(low: Double, high: Double, level: Int): Double {
        // 99 & 98 numbers should *not* be adjusted for level cap > 99
        val value = (floor(low * (99 - level) / 98) + floor(high * (level - 1) / 98) + 1).toInt()
        return min(max(value / 256.0, 0.0), 1.0)
    }
}