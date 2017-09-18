import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
        maven { setUrl("https://repo.spring.io/milestone") }
        maven { setUrl("https://repo.spring.io/snapshot") }
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.M4")
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0")
    }
}

plugins {
    val kotlinVersion = "1.1.4-3"
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("io.spring.dependency-management") version "1.0.3.RELEASE"
}

apply {
    plugin("org.springframework.boot")
    plugin("org.junit.platform.gradle.plugin")
}

version = "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { setUrl("https://repo.spring.io/milestone") }
    maven { setUrl("https://repo.spring.io/snapshot") }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305-annotations=enable")
    }
}

dependencies {

    compile("org.jetbrains.kotlin:kotlin-stdlib-jre8")
    compile("org.jetbrains.kotlin:kotlin-reflect")

    compile("org.springframework.boot:spring-boot-starter-webflux") {
        exclude(module = "hibernate-validator")
    }
    compileOnly("org.springframework:spring-context-indexer")
    compile("com.google.code.findbugs:jsr305:3.0.2") // Needed for now, could be removed when KT-19419 will be fixed

    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    compile("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    compile("io.projectreactor.kafka:reactor-kafka")

    compile("io.github.microutils:kotlin-logging:1.4.6")

    testCompile("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    testCompile("org.junit.jupiter:junit-jupiter-api")
    testRuntime("org.junit.jupiter:junit-jupiter-engine")
    testCompile("io.projectreactor:reactor-test")
}