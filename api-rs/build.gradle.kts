import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    `maven-publish`
}

group =  "meteor"
version = "1.0.0"

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(project(":annotations"))
    implementation(project(":api"))
}

java {
    disableAutoTargetJvm()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}