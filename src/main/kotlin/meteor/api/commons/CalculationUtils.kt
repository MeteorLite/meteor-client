package meteor.api.commons

import meteor.api.commons.CalculationUtils
import java.util.*
import java.util.concurrent.ThreadLocalRandom

object CalculationUtils {
    internal val random = Random()
    fun getRandomIntBetweenRange(min: Int, max: Int): Int {
        //return (int) ((Math.random() * ((max - min) + 1)) + min); //This does not allow return of negative values
        return ThreadLocalRandom.current().nextInt(min, max + 1)
    }

    //Ganom's function, generates a random number allowing for curve and weight
    fun randomDelay(weightedDistribution: Boolean, min: Int, max: Int, deviation: Int, target: Int): Long {
        return if (weightedDistribution) {
            /* generate a gaussian random (average at 0.0, std dev of 1.0)
             * take the absolute value of it (if we don't, every negative value will be clamped at the minimum value)
             * get the log base e of it to make it shifted towards the right side
             * invert it to shift the distribution to the other end
             * clamp it to min max, any values outside of range are set to min or max */
            clamp(
                -Math.log(Math.abs(random.nextGaussian())) * deviation + target,
                min,
                max
            ).toLong()
        } else {
            /* generate a normal even distribution random */
            clamp(
                Math.round(random.nextGaussian() * deviation + target).toDouble(), min, max
            ).toLong()
        }
    }

    private fun clamp(`val`: Double, min: Int, max: Int): Double {
        return Math.max(min.toDouble(), Math.min(max.toDouble(), `val`))
    }

    /**
     * Returns a random double with min as the inclusive lower bound and max as
     * the exclusive upper bound.
     *
     * @param min The inclusive lower bound.
     * @param max The exclusive upper bound.
     * @return Random double min <= n < max.
     */
    fun random(min: Double, max: Double): Double {
        return Math.min(min, max) + random.nextDouble() * Math.abs(max - min)
    }

    /**
     * Returns a random integer with min as the inclusive lower bound and max as
     * the exclusive upper bound.
     *
     * @param min The inclusive lower bound.
     * @param max The exclusive upper bound.
     * @return Random integer min <= n < max.
     */
    fun random(min: Int, max: Int): Int {
        val n = Math.abs(max - min)
        return Math.min(min, max) + if (n == 0) 0 else random.nextInt(n)
    }
}