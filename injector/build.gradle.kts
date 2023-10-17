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
    with(projects){
        implementation(annotations)
        implementation(deobfuscator)
        implementation(apiRs)
        implementation(logger)
        implementation(cache)

    }

    with(libs){
            compileOnly(lombok)
            annotationProcessor(lombok)
            implementation(gson)
            implementation(java.inject)
            implementation(asm)
            implementation(asm.util)
            implementation(guava)
            implementation(jopt.simple)
            implementation(annotations)
    }
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

tasks.compileJava {
    sourceCompatibility = JavaVersion.VERSION_21.toString()
    targetCompatibility = JavaVersion.VERSION_21.toString()
}


