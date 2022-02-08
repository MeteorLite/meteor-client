package meteor.config.legacy

/**
 * Hides sensitive text areas in the UI
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY)
@MustBeDocumented
annotation class Secret