import org.jetbrains.compose.desktop.application.dsl.TargetFormat.*
plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.2.0-alpha01-dev620"
    java
    `maven-publish`
}

val apiRelease by rootProject.extra { "1.2.0" }
val release by rootProject.extra { "1" }
group = "meteor"

repositories {
    maven { url = uri("https://raw.githubusercontent.com/open-osrs/hosting/master/") }
    google()
    mavenLocal()
    mavenCentral()
    maven { url = uri("https://maven.gegy1000.net/") }
    maven { url = uri("https://repo.runelite.net/") }
    maven { url = uri("https://raw.githubusercontent.com/MeteorLite/hosting/main/repo/") }
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev/") }
}

dependencies {
    // meteor-api
    implementation(group = "meteor", name = "api-rs", version = apiRelease)
    implementation(group = "meteor", name = "api", version = apiRelease)
    implementation(group = "meteor", name = "http", version = apiRelease)
    implementation(group = "meteor", name = "annotations", version = apiRelease)
    implementation(group = "meteor", name = "logger", version = apiRelease)
    runtimeOnly(group = "meteor", name = "injected", version = apiRelease)
    runtimeOnly(group = "meteor", name = "scripts", version = apiRelease)

    //Deob
    runtimeOnly("org.bouncycastle:bcprov-jdk15on:1.70")

    //GPU
    implementation(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20220318")
    implementation(group = "net.runelite.jogl", name = "jogl-rl", version = "2.4.0-rc-20220318")
    implementation(group = "net.runelite.jogl", name = "jogl-gldesktop-dbg", version = "2.4.0-rc-20220318")
    implementation(group = "net.runelite.jocl", name = "jocl", version = "1.0")
    runtimeOnly(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20220318", classifier = "natives-linux-amd64")
    runtimeOnly(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20220318", classifier = "natives-windows-amd64")
    runtimeOnly(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20220318", classifier = "natives-windows-i586")
    runtimeOnly(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20220318", classifier = "natives-macosx-universal")
    runtimeOnly(group = "net.runelite.jogl", name = "jogl-rl", version = "2.4.0-rc-20220318", classifier = "natives-linux-amd64")
    runtimeOnly(group = "net.runelite.jogl", name = "jogl-rl", version = "2.4.0-rc-20220318", classifier = "natives-windows-amd64")
    runtimeOnly(group = "net.runelite.jogl", name = "jogl-rl", version = "2.4.0-rc-20220318", classifier = "natives-windows-i586")
    runtimeOnly(group = "net.runelite.jogl", name = "jogl-rl", version = "2.4.0-rc-20220318", classifier = "natives-macosx-universal")
    runtimeOnly(group = "net.runelite.jocl", name = "jocl", version = "1.0", classifier = "macos-x64")
    runtimeOnly(group = "net.runelite.jocl", name = "jocl", version = "1.0", classifier = "macos-arm64")

    //External plugins
    implementation("kext:kext:1.0.0")

    implementation(compose.desktop.currentOs)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.rationalityfrontline:kevent:2.1.2")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
    implementation(group = "org.apache.commons", name = "commons-lang3", version = "_")
    implementation(group = "com.squareup.okhttp3", name = "okhttp", version = "_")
    implementation(group = "com.google.guava", name = "guava", version = "_")
    implementation(group = "org.apache.commons", name = "commons-text", version = "_")
    implementation(group = "commons-io", name = "commons-io", version = "_")
    implementation(group = "net.sf.jopt-simple", name = "jopt-simple", version = "_")
    implementation(group = "com.google.code.gson", name = "gson", version = "_")
    implementation(group = "net.runelite", name = "discord", version = "1.4")
    implementation("com.formdev:flatlaf:2.1")
    implementation("com.formdev:flatlaf-intellij-themes:2.1")
    implementation("com.miglayout:miglayout:3.7.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.6.0")
    implementation("io.insert-koin:koin-core:3.1.5")
    implementation("com.kitfox.svg:svg-salamander:1.0")
    implementation("com.formdev:flatlaf-extras:2.1")
    compileOnly(group= "org.projectlombok", name= "lombok", version= "1.18.20")
    annotationProcessor(group= "org.projectlombok", name= "lombok", version= "1.18.20")
    implementation("org.slf4j:slf4j-api:1.7.36")
    implementation("org.slf4j:slf4j-simple:1.7.36")

}

publishing {
    publications {
        create<MavenPublication>("mavenLocal") {
            artifactId = "client"
            version = "$apiRelease-$release"
            from(components["kotlin"])
        }
    }
}

tasks {
    compose.desktop {
        application {
            mainClass = "meteor.Main"
            nativeDistributions {
                targetFormats(Dmg, Msi, Deb)
                includeAllModules = true
                windows {
                    upgradeUuid = "9df19035-e962-4bb4-90c0-74330a07082b"
                    iconFile.set(project.file("src/main/resources/Meteor.ico"))
                }
            }
            jvmArgs(
                "-XX:+UseZGC",
                "-XX:ReservedCodeCacheSize=256m",
                "-XX:InitialCodeCacheSize=256m",
                "-XX:ConcGCThreads=2",
                "-XX:ParallelGCThreads=4",
                "-Xmx1024m",
                "-ea",
                "-noverify",
                "-Dsun.java2d.opengl=true",
                "-Dsun.java2d.accthreshold=0",
                "-Dsun.java2d.uiScale=1.0",
                "-Dsun.java2d.uiScale.enabled=false",
                "--add-exports", "java.base/java.lang=ALL-UNNAMED",
                "--add-opens", "java.base/java.net=ALL-UNNAMED",
                "--add-exports", "java.desktop/sun.awt=ALL-UNNAMED",
                "--add-exports", "java.desktop/sun.java2d=ALL-UNNAMED"
            )
        }
    }
    jar {
        archiveFileName.set("meteor-client-$apiRelease-r$release.jar")

        manifest {
            attributes(mutableMapOf("Main-class" to "meteor.Main"))
        }
    }

    compileJava {
        options.encoding = "UTF-8"
    }

    compileKotlin {
        kotlinOptions.freeCompilerArgs = listOf("-Xjvm-default=all")
    }

    register<JavaExec>("bootstrap") {
        classpath(sourceSets["main"].runtimeClasspath)
        mainClass.set("meteor.util.bootstrap.Bootstrapper")
    }

    compileKotlin {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()

        kotlinOptions {
            jvmTarget = "11"
            apiVersion = "1.6"
            languageVersion = "1.6"
        }
    }
}
