package meteor.config.legacy

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FIELD, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
annotation class ConfigTitle(
        val name: String, val description: String, val position: Int, val title: String = "",  /*
  OpenOSRS Lazy Helpers tm
   */
        val keyName: String = "", val section: String = "", val hidden: Boolean = false, val unhide: String = ""
)