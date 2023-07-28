import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Exe
import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg


plugins {
    java
    `maven-publish`
    kotlin("jvm")
    kotlin("plugin.serialization") version "1.7.21"
    id("org.jetbrains.compose") version "1.4.3"
    id("org.jetbrains.dokka") version "1.7.20"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

val majorRelease by rootProject.extra { "1.7" }
val release by rootProject.extra { "2" }
group = "meteor"
version = "${majorRelease.split(".")[0]}.${majorRelease.split(".")[1]}.$release"

publishing {

    repositories {
        mavenLocal()
    }

    publications {
        create<MavenPublication>("maven") {
            groupId = rootProject.group.toString()
            artifactId = project.name + "-all"
            version = "0.0.0"
            afterEvaluate {
                val shadowJar = tasks.findByName("shadowJar")
                if (shadowJar == null) from(components["java"])
                else artifact(shadowJar)
            }
        }
    }
}


repositories {
    google()
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://androidx.dev/storage/compose-compiler/repository") }
    maven { url = uri("https://raw.githubusercontent.com/open-osrs/hosting/master/") }
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev/") }
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/") }
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://raw.githubusercontent.com/MeteorLite/hosting/main/repo/") }
}

dependencies {

    // meteor-api
    implementation(projects.apiRs)
    implementation(projects.api)
    implementation(projects.http)
    implementation(projects.annotations)
    implementation(projects.logger)
    implementation(libs.guice)
    implementation(libs.java.inject)
    runtimeOnly(projects.scripts)
    runtimeOnly(files("./src/main/resources/injected-client.jar"))

    //Deob
    implementation(libs.bouncycastle)
    implementation(libs.proguard)
    //GPU
    //implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation(libs.jocl)
    implementation(libs.lwjgl)
    implementation(libs.lwjgl.opengl)
    implementation(libs.rlawt)
    implementation(variantOf(libs.jocl){ classifier("macos-x64") } )
    implementation(variantOf(libs.jocl){ classifier("macos-arm64") } )
    runtimeOnly(variantOf(libs.lwjgl){ classifier("natives-windows") } )
    runtimeOnly(variantOf(libs.lwjgl){ classifier("natives-windows-x86") } )
    runtimeOnly(variantOf(libs.lwjgl){ classifier("natives-linux") } )
    runtimeOnly(variantOf(libs.lwjgl){ classifier("natives-macos") } )
    runtimeOnly(variantOf(libs.lwjgl){ classifier("natives-macos-arm64") } )
    runtimeOnly(variantOf(libs.lwjgl.opengl){ classifier("natives-windows") } )
    runtimeOnly(variantOf(libs.lwjgl.opengl){ classifier("natives-windows-x86") } )
    runtimeOnly(variantOf(libs.lwjgl.opengl){ classifier("natives-linux") } )
    runtimeOnly(variantOf(libs.lwjgl.opengl){ classifier("natives-macos") } )
    runtimeOnly(variantOf(libs.lwjgl.opengl){ classifier("natives-macos-arm64") } )


    //RuneLite Plugins
    implementation(libs.slf4j.api)
    implementation(libs.slf4j.simple)
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    //Util
    implementation(libs.json)
    implementation(projects.eventbus)
    implementation(libs.commons.lang3)
    implementation(libs.okhttp)
    implementation(libs.guava)
    implementation(libs.commons.text)
    implementation(libs.commons.io)
    implementation(libs.jopt.simple)
    implementation(libs.gson)
    implementation(libs.discord)
    implementation(libs.flatlaf)
    implementation(libs.flatlaf.intellij.themes)
    implementation(libs.miglayout)
    implementation(libs.svg.salamander)
    implementation(libs.flatlaf.extras)
    implementation(libs.godaddy.colorpicker)
    implementation(libs.octicions)
    implementation(libs.tabler.icons)
    implementation(libs.line.awesome)
    implementation(libs.jna)
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))

    implementation(compose.desktop.currentOs)

}

compose {
    kotlinCompilerPlugin.set("androidx.compose.compiler:compiler:_")

    desktop {
        application {
            mainClass = "meteor.Main"
            nativeDistributions {
                version = "1.9.0"
                targetFormats(Exe, Deb, Dmg)
                includeAllModules = true
                windows {
                    console = true
                    upgradeUuid = "9df19035-e962-4bb4-90c0-74330a07082b"
                    iconFile.set(project.file("src/main/resources/Meteor.ico"))
                }
            }
            jvmArgs(
                // This fixes a rare bug exclusive to windows when using AA in GPU or GPU HD
                // I would like to separate jvm arguments by platform, but this is a limitation of Compose packaging
                // If you have an issue with scaling, or performance on linux/macOs, remove these two lines
                //"-Dsun.java2d.dpiaware=false,",
                //"-Dsun.java2d.uiScale=1.0",

                "-ea",
                "-XX:+UseDynamicNumberOfGCThreads",
                "-XX:+UseZGC",
                "-Xmx2048m",
                "--add-exports", "java.base/java.lang=ALL-UNNAMED",
                "--add-opens", "java.base/java.net=ALL-UNNAMED",
                "--add-exports", "java.desktop/sun.awt=ALL-UNNAMED",
                "--add-exports", "java.desktop/sun.java2d=ALL-UNNAMED",
                "--add-opens", "java.desktop/java.awt=ALL-UNNAMED",
                "--add-opens", "java.desktop/java.awt.color=ALL-UNNAMED",
            )
        }
    }
}


tasks {
    shadowJar {
        archiveBaseName.set("meteor-client-all")
        archiveClassifier.set("")
        mergeServiceFiles()
        manifest {
            attributes(mapOf("Main-Class" to "meteor.Main"))
        }
    }
    processResources {
        dependsOn(":injector:inject")
        dependsOn(":scripts:assembleScripts")
    }
    jar {
        archiveFileName.set("meteor-client-$majorRelease-r$release.jar")

        manifest {
            attributes(mutableMapOf("Main-class" to "meteor.Main"))
        }
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    register<JavaExec>("createLauncherUpdate") {
        dependsOn("build", "createDistributable")
        classpath(sourceSets["main"].runtimeClasspath)
        mainClass.set("meteor.launcher.CreateLauncherUpdate")
    }
}

tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
    dokkaSourceSets {
        configureEach {
            displayName.set("Meteor Automation API")
            perPackageOption {
                matchingRegex.set(".*meteor.api.*")
                suppress.set(false)
                reportUndocumented.set(false)
                documentedVisibilities.set(
                    setOf(
                        org.jetbrains.dokka.DokkaConfiguration.Visibility.PUBLIC,
                        org.jetbrains.dokka.DokkaConfiguration.Visibility.PROTECTED,
                        org.jetbrains.dokka.DokkaConfiguration.Visibility.INTERNAL,
                        org.jetbrains.dokka.DokkaConfiguration.Visibility.PACKAGE
                    )
                )
            }
            perPackageOption {
                matchingRegex.set("^((?!.*meteor.api.*).)*\$")
                suppress.set(true)
            }
        }
    }
}

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_17.toString()
    targetCompatibility = JavaVersion.VERSION_17.toString()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        //apiVersion = ""
        languageVersion = "1.8"
        jvmTarget = "17"
        // We can't use K2 yet due to using some kotlin compiler plugins which aren't supported yet.
        freeCompilerArgs = listOf( //"-Xuse-k2",
            "-Xjvm-default=all",
            "-Xbackend-threads=4")
    }
}



tasks.withType<org.gradle.jvm.tasks.Jar> {
    exclude("META-INF/BC1024KE.RSA", "META-INF/BC1024KE.SF", "META-INF/BC1024KE.DSA")
    exclude("META-INF/BC2048KE.RSA", "META-INF/BC2048KE.SF", "META-INF/BC2048KE.DSA")
    exclude("META-INF/KITFOX.SF", "META-INF/KITFOX.DSA")
}
