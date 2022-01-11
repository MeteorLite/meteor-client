package meteor.config.legacy

/**
 * Used with ConfigItem, defines what units are shown to the side of the box.
 */
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MustBeDocumented
annotation class Icon(
        val canToggle: Boolean = false
)