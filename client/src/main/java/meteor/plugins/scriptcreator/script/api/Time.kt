package meteor.plugins.scriptcreator.script.api

import kotlin.random.Random



    val r = Random(233)
    /**
    *@param block a block of code to be executed if a random number between 0 and 99 is less than the given Int value
    *This infix operator allows for a block of code to be executed based on a random probability. The given Int value
    * represents the probability as a percentage (e.g. 20 means there is a 20% chance of the code block being executed).
    *The operator generates a random number between 0 and 99, and if it is less than the given Int value, the code block
    *is executed.
     */
    inline infix operator fun Int.rem(block: () -> Unit) {
        if (r.nextInt(100) < this) block()
    }

    var delay = 0
    private var delayCondition: (() -> Boolean)? = null
    /**
     *  This function wraps a block of code and delay its execution until a certain condition is met.
     *  It uses the delayUntil function to set the condition and the delay, and checks the condition before
     *  executing the wrapped code block.
     */
    fun tickWrapper(block: () -> Unit) {
        if (delayCondition != null && delayCondition!!()) {
            delay = 0
            delayCondition = null
        }
        if (delay > 0) {
            delay--
            return
        }
        block()
    }

    /**
     * This function sets the delay and the condition for the tickWrapper function.
     * The code execution will be delayed until the passed lambda function return true.
     *
     * @param condition lambda function that represents the condition for the delay
     * @param defaultDelay optional parameter for the delay
     */

    fun delayUntil(condition: () -> Boolean, defaultDelay:Int = 20) {
        delay = defaultDelay
        delayCondition = condition
    }
    /**
     * Calculates the time that has passed since the start time in milliseconds.
     *
     * @param startTime The start time in milliseconds
     * @return The time that has passed since the start time in milliseconds
     */
    fun timeSince(startTime: Long): Long {
        return System.currentTimeMillis() - startTime
    }
    /**
     * Calculates the time left until the end time in milliseconds.
     *
     * @param endTime The end time in milliseconds
     * @return The time left until the end time in milliseconds
     */
    fun timeLeft(endTime: Long): Long {
        return endTime - System.currentTimeMillis()
    }
    /**
     * Check if the current time is within a certain time interval.
     *
     * @param start The start time in milliseconds
     * @param end The end time in milliseconds
     * @return true if the current time is within the interval, false otherwise
     */
    fun isWithinInterval(start: Long, end: Long): Boolean {
        val currentTime = System.currentTimeMillis()
        return currentTime in start..end
    }
    /**
     * Measures the execution time of a certain block of code in milliseconds.
     *
     * @param block The block of code that needs to be measured
     * @return The execution time of the block of code in milliseconds
     */
    fun <T> measureTimeMillis(block: () -> T): Long {
        val startTime = System.currentTimeMillis()
        block()
        return System.currentTimeMillis() - startTime
    }

