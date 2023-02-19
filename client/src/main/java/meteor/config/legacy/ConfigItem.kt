package meteor.config.legacy

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
    val method: String = "",
    val unhide: String = "",
    val unhideKey: String = "",
    val unhideValue: String = "",
    val hide: String = "",
    val hideValue: String = "",
    val enabledBy: String = "",
    val enabledByValue: String = "",
    val disabledBy: String = "",
    val disabledByValue: String = "",
    val textArea: Boolean = false,
    val textField: Boolean = false,
    val composePanel: Boolean = false,
    )