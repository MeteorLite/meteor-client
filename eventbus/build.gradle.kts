


plugins {
    kotlin("jvm")
    java
    `maven-publish`

}

group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
publishing {
    repositories {
        mavenLocal()
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = rootProject.group.toString()
            artifactId = project.name
            version = rootProject.project.version.toString()
            from(components["java"])
        }
    }
}
dependencies {
    val coroutinesVersion = "1.6.4"
    /** Kotlin --------------------------------------------------------- */
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:$coroutinesVersion")
    /** Logging -------------------------------------------------------- */
    implementation("io.github.microutils:kotlin-logging:3.0.4")
    implementation(project(":logger"))
}


