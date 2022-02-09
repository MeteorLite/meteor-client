package meteor.config

import kotlin.reflect.KClass

class ConfigAnnotations {
    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    annotation class ConfigTitle(
        val name: String, val description: String, val position: Int, val title: String = "",
        val keyName: String = "", val section: String = "", val hidden: Boolean = false, val unhide: String = ""
    )

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    annotation class ConfigSection(
        val name: String, val description: String, val position: Int = Int.MAX_VALUE, val closedByDefault: Boolean = false,
        val keyName: String = "", val section: String = "", val hidden: Boolean = false, val unhide: String = ""
    )

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
    annotation class ConfigGroup(

        val value: String
    )

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    annotation class ConfigItem(
        val position: Int = Int.MAX_VALUE,
        val keyName: String,
        val name: String,
        val description: String,
        val hidden: Boolean = false,
        val warning: String = "",
        val section: String = "",
        val title: String = "",
        val parse: Boolean = false,
        val clazz: KClass<*> = Unit::class,
        val method: String = "",
        val unhide: String = "",
        val unhideValue: String = "",
        val hide: String = "",
        val hideValue: String = "",
        val enabledBy: String = "",
        val enabledByValue: String = "",
        val disabledBy: String = "",
        val disabledByValue: String = "",
        val textField: Boolean = false,
        /**
         * Use this to indicate the enum class that is going to be used in the multiple select config.
         * This implementation made debugging problems with multiple selects a lot easier
         *
         * @return The Enum that will be used for the multiple select
         */
        val enumClass: KClass<out Enum<*>> = Enum::class
    )

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY)
    annotation class Alpha

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    annotation class Icon(
        val canToggle: Boolean = false
    )

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    annotation class Range(val min: Int = 0, val max: Int = Int.MAX_VALUE, val textInput: Boolean = false)

    @Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY)
    annotation class Secret

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
}