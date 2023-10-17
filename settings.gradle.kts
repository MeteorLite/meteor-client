pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
plugins {
    id("de.fayard.refreshVersions") version("0.60.3")
}
rootProject.name = "meteor-client"

include("annotations")
include("api")
include("api-rs")
include("cache")
include("client")
include("deobfuscator")
include("eventbus")
include("http")
include("injector")
include("logger")
include("mixins")
include("osrs")
include("scripts")

