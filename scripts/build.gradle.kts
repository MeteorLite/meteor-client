plugins{
    id("org.jetbrains.kotlin.jvm")
    `maven-publish`
}

group = "org.meteorlite"
version = "1.0-SNAPSHOT"

repositories{
    maven {url =  uri("https://repo.runelite.net/")}
    mavenCentral()
}
dependencies {
    annotationProcessor(group = "org.eclipse.sisu", name = "org.eclipse.sisu.inject", version = "_")

    compileOnly(group = "org.apache.maven.plugin-tools", name = "maven-plugin-annotations", version = "_")
    implementation("net.runelite:cache:1.8.33")
    implementation(project(":api"))
    implementation(project(":logger"))
    runtimeOnly(group = "com.google.guava", name = "guava", version = "_")
    runtimeOnly(group = "org.apache.maven", name = "maven-plugin-api", version = "_")
    testImplementation("org.junit.jupiter:junit-jupiter-api:_")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:_")
}

tasks{
    jar {
        from("build") {
            include( "scripts/runelite/**" )
        }
    }
    processResources {
        dependsOn(":injector:inject")
    }
    test{
        useJUnitPlatform()
    }
    register<JavaExec>("assembleScripts"){
        classpath(sourceSets["main"].runtimeClasspath)
        mainClass.set("meteor.scripts.AssembleScripts")
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