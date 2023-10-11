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

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_20.toString()
    targetCompatibility = JavaVersion.VERSION_20.toString()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        apiVersion = "2.0"
        languageVersion = "2.0"
        jvmTarget = "20"
    }
}


