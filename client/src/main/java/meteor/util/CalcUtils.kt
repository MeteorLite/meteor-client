package meteor.util

import java.util.*
import kotlin.math.*

object CalcUtils {
    private val random: Random = Random()

    fun clamp(num: Double, clampMin: Int, clampMax: Int): Double {
        return max(clampMin.toDouble(), min(clampMax.toDouble(), num))
    }

    fun clamp(num: Int, clampMin: Int, clampMax: Int): Int {
        return this.clamp(num.toDouble(), clampMin, clampMax).toInt()
    }

    fun getHumanizedDelay(weightDist: Boolean, min: Int, max: Int, dev: Int, target: Int ): Double {
        if (weightDist) {
            return clamp((-ln(abs(random.nextGaussian()))) * dev + target, min, max)
        } else {
            return clamp(round(random.nextGaussian() * dev + target), min, max)
        }
    }

    fun getHumanizedTickDelay(weightDist: Boolean, min: Int, max: Int, dev: Int, target: Int ): Int {
        return this.getHumanizedDelay(weightDist, min, max, dev, target).roundToInt()
    }
}