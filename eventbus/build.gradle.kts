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

    with(libs) {
    implementation(kotlin.coroutines)
    implementation(kotlin.logging)
    }

    implementation(projects.logger)

}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        apiVersion = "1.8"
        languageVersion = "1.8"
        jvmTarget = "17"
    }
}


