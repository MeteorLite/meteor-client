plugins{
    java
}
group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories{
    mavenCentral()
}
dependencies {

    with(projects) {
        implementation(api)
        implementation(apiRs)
        implementation(annotations)
        implementation(logger)
        implementation(eventbus)
    }

    with(libs) {
        implementation(files("./src/main/resources/discord-rpc.jar"))
        implementation(bouncycastle)
        implementation(json)
        testImplementation(junit.jupiter.api)
        testRuntimeOnly(junit.jupiter.api)
        implementation(gson)
    }

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
