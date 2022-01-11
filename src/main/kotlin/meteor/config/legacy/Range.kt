package meteor.config.legacy

/**
 * Used with ConfigItem, describes valid int range for a config item.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class Range(val min: Int = 0, val max: Int = Int.MAX_VALUE, val textInput: Boolean = false)