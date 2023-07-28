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

    with(libs){
        compileOnly(guava)
        compileOnly(java.inject)
        compileOnly(commons.io)
    }

    with(projects){
        compileOnly(api)
        compileOnly(apiRs)
        compileOnly(annotations)
        compileOnly(logger)
        compileOnly(osrs)
        compileOnly(cache)
    }

}
tasks{
    test {
        useJUnitPlatform()
    }
}