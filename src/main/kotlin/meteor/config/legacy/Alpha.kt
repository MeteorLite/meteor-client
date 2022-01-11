package meteor.config.legacy

/**
 * Used with ConfigItem, determines if to use alpha slider on colors
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY)
@MustBeDocumented
annotation class Alpha 