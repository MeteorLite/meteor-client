plugins {
    java
}

group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://repo.runelite.net") }
    maven { url = uri("https://raw.githubusercontent.com/open-osrs/hosting/master") }
}

dependencies {
    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.20")

    implementation(project(":annotations"))
    implementation(project(":api"))
    implementation(project(":api-rs"))
    implementation(project(":logger"))
    implementation(group = "org.jetbrains", name = "annotations", version = "20.1.0")
    implementation(group = "org.ow2.asm", name = "asm", version = "9.0")
    implementation(group = "org.ow2.asm", name = "asm-util", version = "9.0")
    implementation(group = "net.runelite", name = "fernflower", version = "07082019")
    implementation(group = "net.runelite", name = "cache", version = "1.8.4")
    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.6")
    implementation(group = "com.google.guava", name = "guava", version = "23.2-jre")
    compileOnly("org.projectlombok:lombok:_")
}

tasks.test {
    useJUnitPlatform()
}