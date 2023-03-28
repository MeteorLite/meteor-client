import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Deb
import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Exe
import org.jetbrains.compose.desktop.application.dsl.TargetFormat.Dmg
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose") version "1.3.0"
    kotlin("plugin.serialization") version "1.7.21"
    id("org.jetbrains.dokka") version "1.7.20"
    java
    `maven-publish`
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
            artifactId = project.name
            version = rootProject.project.version.toString()
            from(components["java"])
        }
    }
}
repositories {
    mavenLocal()
    maven {url = uri("https://androidx.dev/storage/compose-compiler/repository")}
    maven { url = uri("https://raw.githubusercontent.com/open-osrs/hosting/master/") }
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev/")}
    maven { url = uri("https://maven.pkg.jetbrains.space/kotlin/p/kotlin/dev/") }
    google()
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://raw.githubusercontent.com/MeteorLite/hosting/main/repo/") }
}

dependencies {
    @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
    // meteor-api
    implementation("com.google.inject:guice:4.0")
    implementation(project(":api-rs"))
    implementation(project(":api"))
    implementation(project(":http"))
    implementation(project(":annotations"))
    implementation(project(":logger"))
    runtimeOnly(files("./src/main/resources/injected-client.jar"))
    runtimeOnly(project(":scripts"))

    //Deob
    implementation(group = "org.bouncycastle", name = "bcprov-jdk15on", version = "1.64")

    //GPU
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    implementation(group = "net.runelite.jocl", name = "jocl", version = "_")
    runtimeOnly(group = "net.runelite.jocl", name = "jocl", version = "_", classifier = "macos-x64")
    runtimeOnly(group = "net.runelite.jocl", name = "jocl", version = "_", classifier = "macos-arm64")
    implementation(group = "net.runelite", name = "rlawt", version = "_")
    implementation(group = "org.lwjgl", name = "lwjgl", version = "_")
    implementation(group = "org.lwjgl", name = "lwjgl-opengl", version = "_")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl", version = "_", classifier = "natives-linux")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl", version = "_", classifier = "natives-windows")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl", version = "_", classifier = "natives-windows-x86")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl", version = "_", classifier = "natives-macos")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl", version = "_", classifier = "natives-macos-arm64")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl-opengl", version = "_", classifier = "natives-linux")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl-opengl", version = "_", classifier = "natives-windows")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl-opengl", version = "_", classifier = "natives-windows-x86")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl-opengl", version = "_", classifier = "natives-macos")
    runtimeOnly(group = "org.lwjgl", name = "lwjgl-opengl", version = "_", classifier = "natives-macos-arm64")

    //RuneLite Plugins
    implementation("org.slf4j:slf4j-api:_")
    implementation("org.slf4j:slf4j-simple:_")
    compileOnly(group= "org.projectlombok", name= "lombok", version= "_")
    annotationProcessor(group= "org.projectlombok", name= "lombok", version= "_")

    //Util
    implementation(group = "org.json", name = "json", version = "20220924")
    implementation(project(":eventbus"))
    implementation(group = "org.apache.commons", name = "commons-lang3", version = "_")
    implementation(group = "com.squareup.okhttp3", name = "okhttp", version = "_")
    implementation(group = "com.google.guava", name = "guava", version = "_")
    implementation(group = "org.apache.commons", name = "commons-text", version = "_")
    implementation(group = "commons-io", name = "commons-io", version = "_")
    implementation(group = "net.sf.jopt-simple", name = "jopt-simple", version = "_")
    implementation(group = "com.google.code.gson", name = "gson", version = "_")
    implementation(group = "net.runelite", name = "discord", version = "1.4")
    implementation("com.formdev:flatlaf:_")
    implementation("com.formdev:flatlaf-intellij-themes:_")
    implementation("com.miglayout:miglayout:_")
    implementation("com.kitfox.svg:svg-salamander:_")
    implementation("com.formdev:flatlaf-extras:_")
    implementation("com.godaddy.android.colorpicker:compose-color-picker-jvm:_")
    implementation("br.com.devsrsouza.compose.icons.jetbrains:octicons:_")
    implementation("br.com.devsrsouza.compose.icons.jetbrains:tabler-icons:1.0.0")
    implementation("br.com.devsrsouza.compose.icons.jetbrains:line-awesome:1.0.0")
    implementation(kotlin("stdlib-jdk8:1.8.0-RC2"))
    implementation(kotlin("reflect"))
    implementation("net.java.dev.jna:jna:_")

    implementation(compose.desktop.currentOs)

}

compose {
    kotlinCompilerPlugin.set("androidx.compose.compiler:compiler:1.4.0")

    desktop {
        application {
            mainClass = "meteor.Main"
            nativeDistributions {
                version = "1.5.10"
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
    named<ShadowJar>("shadowJar") {
        archiveBaseName.set("shadow")
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
        apiVersion = "1.8"
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
