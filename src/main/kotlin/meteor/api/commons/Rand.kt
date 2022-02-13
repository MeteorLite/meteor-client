package meteor.api.commons

import Main.client
import kotlin.random.Random

object Rand {

    var random: Random = if (client.localPlayer != null) {
        val seed = client.username.hashCode()
        println("Generated randomization seed: $seed")
        Random(seed)
    } else {
        Random(System.nanoTime())
    }

    @Synchronized
    fun nextInt(min: Int, max: Int): Int {
        return random.nextInt(min, max)
    }

    @Synchronized
    fun nextInt(): Int {
        return random.nextInt()
    }

    @Synchronized
    fun nextBool(): Boolean {
        return random.nextBoolean()
    }

    @Synchronized
    fun nextLong(min: Long, max: Long): Long {
        return random.nextLong(min, max)
    }
}