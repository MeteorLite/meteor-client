plugins{
    java
    `maven-publish`
}

group = "meteor"
version = "1.0.0"

repositories{
    mavenCentral()
    maven { url = uri("https://raw.githubusercontent.com/MeteorLite/hosting/main/repo/") }
}

dependencies{
    compileOnly(libs.lombok)
    annotationProcessor(libs.lombok)

    implementation(projects.annotations)
    implementation(projects.deobfuscator)
    implementation(projects.apiRs)
    implementation(projects.logger)
    implementation(projects.cache)
    implementation(libs.java.inject)
    implementation(libs.gson)

    implementation(libs.asm)
    implementation(libs.asm.util)
    implementation(libs.annotations)
    implementation(libs.guava)
    implementation(libs.jopt.simple)

}

tasks{


    test {
        useJUnitPlatform()
    }
    register<JavaExec>("inject"){
        classpath(sourceSets["main"].runtimeClasspath)
        mainClass.set("com.openosrs.injector.Injector")
        dependsOn(":mixins:jar")
    }
    findByName("build")!!.finalizedBy("inject")
}


