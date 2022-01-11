package meteor.config.legacy

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ConfigSection(
        val name: String, val description: String, val position: Int = Int.MAX_VALUE, val closedByDefault: Boolean = false,
        val keyName: String = "", val section: String = "", val hidden: Boolean = false, val unhide: String = ""
)