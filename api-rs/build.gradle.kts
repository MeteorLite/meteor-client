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

    with(projects) {
        implementation(api)
        implementation(annotations)
    }

}

java {
    disableAutoTargetJvm()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}