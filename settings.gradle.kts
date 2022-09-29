pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
plugins {
    id("de.fayard.refreshVersions") version("0.50.2")
}
rootProject.name = "meteor-client"

include("annotations")
include("api")
include("api-rs")
include("client")
include("deobfuscator")
include("http")
include("injector")
include("logger")
include("mixins")
include("osrs")
include("scripts")

