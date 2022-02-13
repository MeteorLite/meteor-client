package meteor.api.commons

import Main.client
import meteor.api.widgets.Dialog
import java.time.Duration
import kotlin.math.abs

object Time {

    private const val SLEEP_UNTIL_POLL_RATE = 100

    /**
     * Format a Duration into HH:MM:SS String.
     */
    fun format(duration: Duration): String {
        val secs = abs(duration.seconds)
        return String.format("%02d:%02d:%02d", secs / 3600L, secs % 3600L / 60L, secs % 60L)
    }

    /**
     * Sleep for ms.
     */
    fun sleep(ms: Long) {
        if (!client.isClientThread()) {
            Thread.sleep(ms)
        } else {
            println("Tried to sleep on client thread!!")
        }
    }

    /**
     * Sleep for ms with specified range.
     */
    fun sleep(min: Long, max: Long) {
        sleep(Rand.nextLong(min, max))
    }

    /**
     * Sleep for ms, or until condition equals true, with polling rate (check every x ms).
     */
    fun sleepUntil(condition: () -> Boolean, pollRate: Int, timeout: Long) {
        val start = System.currentTimeMillis()

        while (!condition.invoke()) {
            if (System.currentTimeMillis() > start + timeout) {
                return
            }

            sleep(pollRate.toLong())
        }
    }

    /**
     * Sleep for ms, or until condition equals true.
     */
    fun sleepUntil(condition: () -> Boolean, timeout: Long) {
        sleepUntil(condition, SLEEP_UNTIL_POLL_RATE, timeout)
    }


    /**
     * Sleep for ms, or until condition equals true, with polling rate (check every x ms).
     * Returns boolean if sleep was successful.
     */
    fun sleepUntilWithConfirm(condition: () -> Boolean, pollRate: Int, timeout: Long): Boolean {
        return try {
            sleepUntil(condition, pollRate, timeout)
            true
        } catch (e: Exception) {
            false
        }
    }

    /**
     * Sleep for ms, or until condition equals true.
     * Returns boolean if sleep was successful.
     */
    fun sleepUntilWithConfirm(condition: () -> Boolean, timeout: Long): Boolean {
        return sleepUntilWithConfirm(condition, SLEEP_UNTIL_POLL_RATE, timeout)
    }


}