package meteor.api.statistics

import dev.botlin.api.commons.NumericFormat
import dev.botlin.api.commons.StopWatch
import java.util.function.Supplier

class Statistic(val isHeader: Boolean, val supplier: Supplier<String>) {

    constructor(supplier: Supplier<String>) : this(false, supplier) {}
    constructor(timer: StopWatch, rate: Supplier<Int>, format: Boolean) : this(false, Supplier<String> {
        val value = rate.get()
        val hourly = timer.getHourlyRate(value)
        val valueText = if (format) NumericFormat.apply(value.toDouble()) else value.toString()
        val hourlyText = if (format) NumericFormat.apply(hourly) else hourly.toString()
        "$valueText ($hourlyText / hr)"
    }) {
    }

    constructor(timer: StopWatch, rate: Supplier<Int>) : this(timer, rate, true) {}

    override fun toString(): String {
        return supplier.get()
    }
}