import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins{
    java
    kotlin("jvm") version "1.7.10"
    `maven-publish`
}

group = "meteor"
val release by rootProject.extra { "1.7.0" }

allprojects {
    configurations.all {
        resolutionStrategy.dependencySubstitution {
            substitute(module("org.jetbrains.compose.compiler:compiler")).apply {
                using(module("androidx.compose.compiler:compiler:1.2.0-dev-k1.7.0-53370d83bb1"))
            }
        }
    }

    tasks.withType<KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "17"
            apiVersion = "1.7"
            languageVersion = "1.7"
            // K2 unsupported until Compose plugin is K2 compatible
            //freeCompilerArgs += "-Xuse-k2"
        }
    }
}

repositories{
    maven {url = uri("https://androidx.dev/storage/compose-compiler/repository")}
    mavenCentral()
}

dependencies{
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains:annotations:23.0.0")
}

tasks {
    processResources {
        dependsOn(findByPath(":scripts:assembleScripts"))
        from("scripts/build/scripts")
    }
    test {
        useJUnitPlatform()
    }
    compileKotlin{
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}
