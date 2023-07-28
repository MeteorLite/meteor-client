plugins{
    java
}
group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories{
    mavenCentral()
}
dependencies{
    implementation(projects.api)
    implementation(projects.apiRs)
    implementation(projects.annotations)
    implementation(projects.logger)
    implementation(libs.bouncycastle)
    implementation(libs.json)
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.api)
    implementation(libs.gson)
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
