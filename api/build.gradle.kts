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

publishing {
    publications {
        create<MavenPublication>("mavenLocal") {
            version = rootProject.extra.get("release") as String
            from(components["java"])
        }
    }
}

dependencies {
    implementation(gradleApi())
    implementation(project(":annotations"))
    implementation(project(":logger"))
    implementation(group = "com.google.code.findbugs", name = "jsr305", version = "3.0.2")
    implementation(group = "com.google.guava", name = "guava", version = "23.2-jre")
    implementation(group = "org.apache.commons", name = "commons-text", version = "1.2")
    implementation(group = "com.google.code.findbugs", name = "jsr305", version = "3.0.2")
    compileOnly("org.projectlombok:lombok:_")
    annotationProcessor("org.projectlombok:lombok:_")
    implementation("org.jetbrains:annotations:23.0.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}