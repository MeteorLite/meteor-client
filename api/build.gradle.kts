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
        apiVersion = "1.7"
        languageVersion = "1.7"
        jvmTarget = "17"
        // We can't use K2 yet due to using some kotlin compiler plugins which aren't supported yet.
        freeCompilerArgs = listOf( //"-Xuse-k2",
            "-Xjvm-default=all",
            "-Xbackend-threads=4"
        )
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}