plugins {
    java
    id("org.jetbrains.kotlin.jvm")
    `maven-publish`
}

group = "meteor"
version = "1.0.4"
repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":annotations"))
    implementation(project(":logger"))
    implementation(group = "com.google.code.findbugs", name = "jsr305", version = "_")
    implementation(group = "com.google.guava", name = "guava", version = "_")
    implementation(group = "org.apache.commons", name = "commons-text", version = "_")
    implementation(group = "com.google.code.findbugs", name = "jsr305", version = "_")
    compileOnly("org.projectlombok:lombok:_")
    annotationProcessor("org.projectlombok:lombok:_")
    implementation("org.jetbrains:annotations:_")
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}