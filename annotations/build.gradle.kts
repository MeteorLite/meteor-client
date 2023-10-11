plugins {
    java
    `maven-publish`
}

group = "meteor"
version = "1.0.0"

repositories {
    mavenCentral()
}
dependencies {
    implementation(libs.kotlin.stdlib)
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