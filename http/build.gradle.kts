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
    with(projects) {
        implementation(api)
        implementation(logger)
    }

    with(libs) {
        annotationProcessor(lombok)
        compileOnly(lombok)
        implementation(gson)
        implementation(guava)
        implementation(okhttp)
        implementation(commons.csv)
    }
}
tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}