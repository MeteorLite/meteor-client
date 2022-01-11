package meteor.config.legacy

/**
 * Used with ConfigItem, defines what units are shown to the side of the box.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class Units(val value: String) {
    companion object {
        const val MILLISECONDS = "ms"
        const val MINUTES = " mins"
        const val PERCENT = "%"
        const val PIXELS = "px"
        const val POINTS = "pt"
        const val SECONDS = "s"
        const val TICKS = " ticks"
        const val LEVELS = " lvls"
        const val FPS = " fps"
        const val GP = " GP"
    }
}