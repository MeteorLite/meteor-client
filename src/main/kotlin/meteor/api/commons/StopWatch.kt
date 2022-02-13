package dev.botlin.api.commons

import meteor.api.commons.Time
import java.time.Duration
import java.time.Instant
import java.util.function.Supplier

class StopWatch private constructor(supplier: Supplier<*>, duration: Duration?) {
    private var start: Instant? = null
    private var end: Instant? = null

    init {
        start = supplier.get() as Instant
        if (duration != null) {
            end = start!!.plus(duration)
        }
    }

    companion object {
        fun start(start: Supplier<Instant>): StopWatch {
            return StopWatch(start, null as Duration?)
        }

        /**
         * Constructs a StopWatch object.
         */
        fun start(): StopWatch {
            return start(Supplier { Instant.now() })
        }
    }

    fun exceeds(duration: Duration): Boolean {
        return getElapsed().seconds > duration.seconds
    }

    fun setEndIn(duration: Duration) {
        end = Instant.now().plus(duration)
    }

    fun isRunning(): Boolean {
        return end == null || Instant.now().isBefore(end)
    }

    fun getElapsed(): Duration {
        return Duration.between(start, Instant.now())
    }

    fun getRemaining(): Duration {
        return if (end != null) Duration.between(end, Instant.now()) else Duration.ZERO
    }

    /**
     * Returns a HH:MM:SS String of elapsed time.
     */
    fun toElapsedString(): String {
        return Time.format(getElapsed())
    }

    /**
     * Returns a HH:MM:SS String of remaining time.
     */
    fun toRemainingString(): String {
        return Time.format(getRemaining())
    }

    /**
     * Resets the timer.
     */
    fun reset() {
        val prevStart = start
        start = Instant.now()
        if (end != null) {
            val duration = Duration.between(prevStart, end)
            setEndIn(duration)
        }
    }

    /**
     * Calculates the rate per specified time unit.
     */
    fun getRate(value: Long, rate: Duration): Double {
        return (value * rate.toMillis() / getElapsed().toMillis()).toDouble()
    }

    /**
     * Calculates the rate per hour.
     */
    fun getHourlyRate(value: Int): Double {
        return getRate(value.toLong(), Duration.ofHours(1L))
    }
}
