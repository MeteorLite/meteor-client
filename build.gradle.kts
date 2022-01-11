import org.jetbrains.compose.desktop.application.dsl.TargetFormat.*
plugins {
    kotlin("jvm") version "1.6.10"
    id("org.jetbrains.compose") version "1.1.0-alpha1-dev536"
    java
}

val release by rootProject.extra { "1.0.0" }

group = "meteor.client"
version = "1.0.0"

repositories {
    mavenLocal()
    maven { url = uri("https://raw.githubusercontent.com/open-osrs/hosting/master/") }
    mavenCentral()
    jcenter()
    maven { url = uri("https://maven.gegy1000.net/") }
    maven { url = uri("https://repo.runelite.net/") }
    maven { url = uri("https://raw.githubusercontent.com/MeteorLite/hosting/main/repo/") }
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev/") }
}

dependencies {
    // meteor-api
    implementation(group = "meteor", name = "runescape-api", version = release)
    implementation(group = "meteor", name = "runelite-api", version = release)
    implementation(group = "meteor", name = "http-api", version = release)
    implementation(group = "meteor", name = "annotations", version = release)
    implementation(group = "meteor", name = "logger", version = release)
    runtimeOnly(group = "meteor", name = "injected-client", version = release)


    runtimeOnly(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20200429", classifier = "natives-linux-amd64")
    runtimeOnly(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20200429", classifier = "natives-windows-amd64")
    runtimeOnly(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20200429", classifier = "natives-windows-i586")
    runtimeOnly(group = "net.runelite.gluegen", name = "gluegen-rt-natives-macosx", version = "2.4.0-rc-20210117")
    runtimeOnly(group = "net.runelite.jogl", name = "jogl-all", version = "2.4.0-rc-20200429", classifier = "natives-linux-amd64")
    runtimeOnly(group = "net.runelite.jogl", name = "jogl-all", version = "2.4.0-rc-20200429", classifier = "natives-windows-amd64")
    runtimeOnly(group = "net.runelite.jogl", name = "jogl-all", version = "2.4.0-rc-20200429", classifier = "natives-windows-i586")
    runtimeOnly(group = "net.runelite.jogl", name = "jogl-all-natives-macosx", version = "2.4.0-rc-20210117")
    runtimeOnly(group = "net.runelite.jocl", name = "jocl", version = "1.0", classifier = "macos-x64")
    runtimeOnly(group = "net.runelite.jocl", name = "jocl", version = "1.0", classifier = "macos-arm64")
    runtimeOnly(group = "net.runelite.pushingpixels", name = "trident", version = "1.5.00")
    runtimeOnly(group = "net.runelite.jocl", name = "jocl", version = "1.0", classifier = "macos-x64")
    runtimeOnly(group = "net.runelite.jocl", name = "jocl", version = "1.0", classifier = "macos-arm64")
    implementation(group = "com.google.inject", name = "guice", version = "4.1.0", classifier = "no_aop")
    implementation("org.rationalityfrontline:kevent:2.1.0")
    implementation(group = "org.jetbrains", name = "annotations", version = "21.0.1")
    implementation(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20200429")
    implementation(group = "net.runelite.jogl", name = "jogl-all", version = "2.4.0-rc-20200429")
    implementation(group = "net.runelite.jocl", name = "jocl", version = "1.0")
    implementation(group = "io.reactivex.rxjava3", name = "rxjava", version = "_")
    implementation(group = "org.apache.commons", name = "commons-lang3", version = "_")
    implementation(group = "io.reactivex.rxjava3", name = "rxjava", version = "3.1.2")
    implementation(group = "com.squareup.okhttp3", name = "okhttp", version = "_")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
    implementation(group = "net.runelite.gluegen", name = "gluegen-rt", version = "2.4.0-rc-20200429")
    implementation(group = "net.runelite.jogl", name = "jogl-all", version = "2.4.0-rc-20200429")
    implementation(group = "com.google.guava", name = "guava", version = "_")
    implementation(group = "org.apache.commons", name = "commons-text", version = "_")
    implementation(group = "commons-io", name = "commons-io", version = "_")
    implementation(group = "net.sf.jopt-simple", name = "jopt-simple", version = "_")
    implementation(group = "io.reactivex.rxjava3", name = "rxjava", version = "_")
    implementation(group = "com.google.code.findbugs", name = "jsr305", version = "_")
    implementation(group = "com.google.code.gson", name = "gson", version = "_")
    implementation(group = "net.lingala.zip4j", name = "zip4j", version = "2.9.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation(group = "net.runelite", name = "discord", version = "1.4")
    implementation("org.bouncycastle:bcprov-jdk15on:1.52")
    implementation("xerces:xercesImpl:2.12.1")
    implementation("com.formdev:flatlaf:_")
    implementation("com.formdev:flatlaf-intellij-themes:_")
    implementation("com.miglayout:miglayout:3.7.4")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-javafx:1.5.2")
    implementation("io.insert-koin:koin-core:3.1.4")
    implementation(compose.desktop.currentOs)
    implementation("com.kitfox.svg:svg-salamander:1.0")
    implementation("com.formdev:flatlaf-extras:1.4")
}

tasks {
    compose.desktop {
        application {
            mainClass = "Main"
            nativeDistributions {
                targetFormats(Dmg, Msi, Deb)
                includeAllModules = true
            }
            //println(sourceSets["main"].compileClasspath.joinToString("\n"){ it.path} )
            //args("disableGPU")
            jvmArgs(
                "-noverify",
                "-ea",
                "-Xmx2048m",
                "--add-exports", "java.base/java.lang=ALL-UNNAMED",
                "--add-exports", "java.desktop/sun.awt=ALL-UNNAMED",
                "--add-exports", "java.desktop/sun.java2d=ALL-UNNAMED"
            )
        }
    }

    jar {
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
        sourceCompatibility = JavaVersion.VERSION_16.name
        targetCompatibility = JavaVersion.VERSION_16.name

        kotlinOptions {
            jvmTarget = "16"
            apiVersion = "1.6"
            languageVersion = "1.6"
        }
    }
}