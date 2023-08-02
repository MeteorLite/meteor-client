plugins{
    kotlin("jvm")
    `maven-publish`
}

group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories{
    mavenCentral()
}
dependencies {
    with(projects) {
        implementation(cache)
        implementation(api)
        implementation(logger)
    }

    with(libs) {
        annotationProcessor(sisu.inject)
        compileOnly(maven.plugin.annotations)
        implementation(guava)
        runtimeOnly(maven.plugin.api)
        implementation(slf4j.simple)
        testImplementation(junit.jupiter.api)
        testRuntimeOnly(junit.jupiter.engine)
    }
}
tasks{
    jar {
        from("build") {
            include( "scripts/runelite/**" )
        }
    }
    test{
        useJUnitPlatform()
    }
    register<JavaExec>("assembleScripts"){
        classpath(sourceSets["main"].runtimeClasspath)
        mainClass.set("meteor.scripts.AssembleScripts")
    }
    processResources {
        dependsOn(":injector:inject")
    }
    java{
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    compileKotlin{
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}