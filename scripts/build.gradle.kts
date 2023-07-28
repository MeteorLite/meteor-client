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
    annotationProcessor(libs.sisu.inject)
    compileOnly(libs.maven.plugin.annotations)
    implementation(projects.cache)
    implementation(projects.api)
    implementation(projects.logger)
    implementation(libs.guava)
    runtimeOnly(libs.maven.plugin.api)
    implementation(libs.slf4j.simple)
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
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