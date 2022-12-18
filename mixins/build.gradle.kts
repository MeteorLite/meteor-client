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
    maven { url = uri("https://repo.runelite.net")}
}

dependencies {
    compileOnly(gradleApi())
    compileOnly(group = "com.google.guava", name = "guava", version = "_")
    compileOnly(group = "javax.inject", name = "javax.inject", version = "_")
    compileOnly(group = "commons-io", name = "commons-io", version = "_")
    compileOnly(project(":annotations"))
    compileOnly(project(":api-rs"))
    compileOnly(project(":osrs"))
    compileOnly(project(":api"))
    compileOnly(project(":logger"))
    compileOnly(project(":cache"))
}
tasks{
test {
    useJUnitPlatform()
}
}