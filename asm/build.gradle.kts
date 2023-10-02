import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm")
}

group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://raw.githubusercontent.com/MeteorLite/hosting/main/repo/") }
    maven { url = uri("https://jitpack.io") }
}
tasks.withType<Jar>(){
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}
dependencies {



  //  implementation("com.github.JagexCompliant:meteor-api:1.0.4")
    with(projects){
        implementation(apiRs)
        implementation(cache)
        implementation(logger)
        implementation(annotations)
        implementation(api)
    }
    implementation(projects.logger)
    with(libs) {
    //    implementation(projects.common)
        annotationProcessor(lombok)
        implementation(group = "org.jetbrains", name = "annotations", version = "_")
        implementation(asm)
        implementation(asm.util)
        implementation(group = "com.google.code.gson", name = "gson", version = "_")
        implementation(guava)
        compileOnly(lombok)
    }
    implementation(kotlin("stdlib-jdk8"))
}


tasks.test {
    useJUnitPlatform()
}
