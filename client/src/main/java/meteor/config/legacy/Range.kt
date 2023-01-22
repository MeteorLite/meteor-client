package meteor.config.legacy

@Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
    annotation class Range(val min: Int = 0, val max: Int = Int.MAX_VALUE, val textInput: Boolean = false)
