plugins {
    java
}

group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://raw.githubusercontent.com/MeteorLite/hosting/main/repo/") }
}

dependencies {

    implementation(projects.annotations)
    implementation(projects.api)
    implementation(projects.apiRs)
    implementation(projects.logger)
    implementation(projects.cache)
    annotationProcessor(libs.lombok)
    implementation(libs.annotations)
    implementation(libs.asm)
    implementation(libs.asm.util)
    implementation(libs.fernflower)
    implementation(libs.gson)
    implementation(libs.guava)
    compileOnly(libs.lombok)
}

tasks.test {
    useJUnitPlatform()
}