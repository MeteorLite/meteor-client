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
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}