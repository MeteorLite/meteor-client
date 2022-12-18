/*
 * Copyright (c) 2019 Owain van Brakel <https://github.com/Owain94>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

import org.apache.tools.ant.filters.ReplaceTokens

description = "Cache"

plugins {
    java
}

repositories {
    google()
    mavenCentral()
    maven { url = uri("https://repo.runelite.net/") }
}

dependencies {
    annotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.24")

    compileOnly(project(":http"))

    compileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.24")

    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.5")
    implementation(group = "com.google.guava", name = "guava", version = "30.1.1-jre")
    implementation(group = "commons-cli", name = "commons-cli", version = "1.4")
    implementation(group = "io.netty", name = "netty-buffer", version = "4.1.54.Final")
    implementation(group = "com.squareup.okhttp3", name = "okhttp", version = "4.9.1")
    implementation(group = "org.antlr", name = "antlr4-runtime", version = "4.8-1")
    implementation(group = "org.apache.commons", name = "commons-compress", version = "1.21")
    implementation(group = "org.slf4j", name = "slf4j-api", version = "1.7.32")

    testAnnotationProcessor(group = "org.projectlombok", name = "lombok", version = "1.18.24")

    testCompileOnly(group = "org.projectlombok", name = "lombok", version = "1.18.24")

    testImplementation(group = "junit", name = "junit", version = "4.13.1")
    testImplementation(group = "net.runelite.rs", name = "cache", version = "165")
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
}

java {
    disableAutoTargetJvm()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}
