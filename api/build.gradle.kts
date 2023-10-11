plugins {
    java
    kotlin("jvm")
}

group = "meteor"
version = "1.0.4"
repositories {
    mavenCentral()
}

dependencies {
    with(projects) {
        implementation(annotations)
        implementation(logger)
    }

    with(libs) {
        implementation(jsr305)
        implementation(guava)
        implementation(commons.text)
        implementation(jsr305)
        compileOnly(lombok)
        annotationProcessor(lombok)
        implementation(annotations)
    }

}
tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        languageVersion = "2.0"
        jvmTarget = "20"
        freeCompilerArgs = listOf(
            "-Xjvm-default=all",
            "-Xbackend-threads=4"
        )
    }
}

tasks.test {
    useJUnitPlatform()
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