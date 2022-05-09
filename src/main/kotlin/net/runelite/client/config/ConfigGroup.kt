package net.runelite.client.config

@Retention(AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS)
    annotation class ConfigGroup(

        val value: String
    )