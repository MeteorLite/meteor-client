plugins {
    java
}

group = "org.meteorlite"
version = "1.0-SNAPSHOT"

java {
    disableAutoTargetJvm()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(libs.guava)
    compileOnly(libs.java.inject)
    compileOnly(libs.commons.io)
    compileOnly(projects.annotations)
    compileOnly(projects.apiRs)
    compileOnly(projects.osrs)
    compileOnly(projects.api)
    compileOnly(projects.logger)
    compileOnly(projects.cache)
}
tasks{
    test {
        useJUnitPlatform()
    }
}