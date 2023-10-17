import org.jetbrains.compose.desktop.application.dsl.TargetFormat.*

plugins {
    java
    `maven-publish`
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.compose") version "1.5.10-rc01"
    id("org.jetbrains.dokka")
    id("com.github.johnrengelman.shadow")
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
  
    implementation(kotlin("stdlib-jdk8"))
    implementation(kotlin("reflect"))
    implementation(compose.desktop.currentOs)
    with(projects) {
        implementation(apiRs)
        implementation(api)
        implementation(http)
        implementation(annotations)
        implementation(logger)
        implementation(eventbus)
    }

    with(libs) {
        implementation(guice)
        implementation(java.inject)
        runtimeOnly(files("./src/main/resources/injected-client.jar"))

        //Deob
        implementation(bouncycastle)
        implementation(proguard)

        //GPU
        //implementation(KotlinX.serialization.json)
        implementation(jocl)
        implementation(lwjgl)
        implementation(lwjgl.opengl)
        implementation(rlawt)
        implementation(variantOf(jocl) { classifier("macos-x64") })
        implementation(variantOf(jocl) { classifier("macos-arm64") })
        runtimeOnly(variantOf(lwjgl) { classifier("natives-windows") })
        runtimeOnly(variantOf(lwjgl) { classifier("natives-windows-x86") })
        runtimeOnly(variantOf(lwjgl) { classifier("natives-linux") })
        runtimeOnly(variantOf(lwjgl) { classifier("natives-macos") })
        runtimeOnly(variantOf(lwjgl) { classifier("natives-macos-arm64") })
        runtimeOnly(variantOf(lwjgl.opengl) { classifier("natives-windows") })
        runtimeOnly(variantOf(lwjgl.opengl) { classifier("natives-windows-x86") })
        runtimeOnly(variantOf(lwjgl.opengl) { classifier("natives-linux") })
        runtimeOnly(variantOf(lwjgl.opengl) { classifier("natives-macos") })
        runtimeOnly(variantOf(lwjgl.opengl) { classifier("natives-macos-arm64") })

        //RuneLite Plugins
        implementation(slf4j.api)
        implementation(slf4j.simple)
        compileOnly(lombok)
        annotationProcessor(lombok)

        //Util
        implementation(json)
        implementation(commons.lang3)
        implementation(okhttp)
        implementation(guava)
        implementation(commons.text)
        implementation(commons.io)
        implementation(jopt.simple)
        implementation(gson)
        implementation(discord)
        implementation(flatlaf)
        implementation(flatlaf.intellij.themes)
        implementation(miglayout)
        implementation(svg.salamander)
        implementation(flatlaf.extras)
        implementation(godaddy.colorpicker)
        implementation(octicions)
        implementation(tabler.icons)
        implementation(line.awesome)
        implementation(jna)
    }
}

compose {

    desktop {
        application {
            mainClass = "meteor.Main"
            nativeDistributions {
                version = "1.0.0"
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
    sourceCompatibility = JavaVersion.VERSION_20.toString()
    targetCompatibility = JavaVersion.VERSION_20.toString()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
    kotlinOptions {
        languageVersion = "2.0"
        jvmTarget = "20"
        freeCompilerArgs = listOf(
            "-Xjvm-default=all",
            "-Xbackend-threads=4"
        )
    }
}



tasks.withType<org.gradle.jvm.tasks.Jar> {
    exclude("META-INF/BC1024KE.RSA", "META-INF/BC1024KE.SF", "META-INF/BC1024KE.DSA")
    exclude("META-INF/BC2048KE.RSA", "META-INF/BC2048KE.SF", "META-INF/BC2048KE.DSA")
    exclude("META-INF/KITFOX.SF", "META-INF/KITFOX.DSA")
}
