plugins {
    java
    `maven-publish`
}

group = "meteor"
version = "1.0.0"

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
    implementation(project(":api"))
    implementation(project(":logger"))

    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "_")
    compileOnly(group = "org.projectlombok", name = "lombok", version = "_")
    implementation(group = "com.google.code.gson", name = "gson", version = "_")
    implementation(group = "com.google.guava", name = "guava", version = "_")
    implementation("com.squareup.okhttp3:okhttp:_")
    implementation(group = "org.apache.commons", name = "commons-csv", version = "_")
}

tasks.test {
    useJUnitPlatform()
}

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}