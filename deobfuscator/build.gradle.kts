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
    with(projects) {
        implementation(annotations)
        implementation(api)
        implementation(apiRs)
        implementation(logger)
        implementation(cache)
    }

    with(libs) {
        annotationProcessor(lombok)
        implementation(annotations)
        implementation(asm)
        implementation(asm.util)
        implementation(fernflower)
        implementation(gson)
        implementation(guava)
        compileOnly(lombok)
    }
}


tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_21.toString()
    targetCompatibility = JavaVersion.VERSION_21.toString()
}