package meteor.config.legacy

import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ConfigItem(
        val position: Int = Int.MAX_VALUE,
        val keyName: String,
        val name: String,
        val description: String,
        val hidden: Boolean = false,
        val warning: String = "",
        val secret: Boolean = false,
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