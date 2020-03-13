plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.70"
}

group = "org.jbwapi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.github.JavaBWAPI:JBWAPI:1.3")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    jar {
        manifest {
            attributes["Main-Class"] = "BotKt"
        }

        from(
            configurations.runtimeClasspath.get().map { if (it.isDirectory()) it else zipTree(it) }
        )
    }
}
