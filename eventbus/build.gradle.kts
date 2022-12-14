plugins {
    kotlin("jvm")
    java
}

group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val coroutinesVersion = "1.6.4"
    /** Kotlin --------------------------------------------------------- */
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$coroutinesVersion")
    /** Logging -------------------------------------------------------- */
    implementation("io.github.microutils:kotlin-logging:3.0.4")
    implementation(project(":logger"))
}


