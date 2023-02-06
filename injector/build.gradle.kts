plugins{
    java
    `maven-publish`
}

group = "meteor"
version = "1.0.0"

repositories{
    mavenCentral()
}

dependencies{
    compileOnly("org.projectlombok:lombok:_")
    annotationProcessor("org.projectlombok:lombok:_")

    implementation(project(":annotations"))
    implementation(project(":deobfuscator"))
    implementation(project(":api-rs"))
    implementation(project(":logger"))
    implementation(project(":cache"))
    implementation("javax.inject:javax.inject:1")
    implementation(group = "com.google.code.gson", name = "gson", version = "_")

    implementation(group = "org.ow2.asm", name = "asm", version = "_")
    implementation(group = "org.ow2.asm", name = "asm-util", version = "_")
    implementation(group = "org.jetbrains", name = "annotations", version = "_")
    implementation(group = "com.google.guava", name = "guava", version = "_")
    implementation(group = "net.sf.jopt-simple", name = "jopt-simple", version = "_")

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


