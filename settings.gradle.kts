pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
plugins {
    id("de.fayard.refreshVersions") version("0.51.0")
}
rootProject.name = "meteor-client"

include("annotations")
include("api")
include("api-rs")
include("cache")
include("client")
include("asm")
include("eventbus")
include("http")
include("injector")
include("logger")
include("mixins")
include("osrs")
include("scripts")

