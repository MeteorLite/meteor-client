plugins{
    java
}
group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories{
    mavenCentral()
}
dependencies{
    implementation(project(":api"))
    implementation(project(":api-rs"))
    implementation(project(":annotations"))
    implementation(project(":logger"))
    implementation(group = "org.bouncycastle", name = "bcprov-jdk15on", version = "1.64")
    implementation(group = "org.json", name = "json", version = "20220320")

    testImplementation("org.junit.jupiter:junit-jupiter-api:_")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-api:_")
    implementation("com.google.code.gson:gson:_")
}

tasks{
    jar {
        outputs.upToDateWhen {
            false
        }
    }
    withType<JavaCompile>(){
        options.encoding = "UTF-8"
    }
    java{

        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        disableAutoTargetJvm()
    }
    withType<JavaExec>(){
       classpath = sourceSets["main"].runtimeClasspath
        mainClass.set("net.runelite.rs.UpdateRefMap")
    }
    test{
        useJUnitPlatform()
    }
}
