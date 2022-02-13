package meteor.api.commons

import kotlin.random.Random

object Rand {

    var random: Random

    init {
        val gameAccount = Game.gameAccount
        random = if (gameAccount != null) {
            val seed = gameAccount.username.hashCode()
            println("Generated randomization seed: $seed")
            Random(seed)
        } else {
            Random(System.nanoTime())
        }
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