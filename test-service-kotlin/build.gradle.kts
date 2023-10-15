import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("java")
	id("org.springframework.boot") version "3.2.0-M3"
	id("io.spring.dependency-management") version "1.1.3"
	id("org.hibernate.orm") version "6.3.1.Final"
	id("org.graalvm.buildtools.native") version "0.9.27"
	id("org.jetbrains.kotlin.plugin.allopen") version "1.9.20-RC"
	kotlin("jvm") version "1.9.20-RC"
	kotlin("plugin.spring") version "1.9.20-RC"
	kotlin("plugin.jpa") version "1.9.20-RC"
}

group = "org.xapps.service"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

graalvmNative {
	binaries {
		named("main") {
			resources.autodetect()
			buildArgs.addAll("--enable-preview", "-H:+UnlockExperimentalVMOptions")
		}
	}
	binaries.all {
		resources.autodetect()
	}
	toolchainDetection = false
}

allOpen {
	annotation("jakarta.persistence.Entity")
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	runtimeOnly("com.mysql:mysql-connector-j")
	implementation("org.apache.commons:commons-io:1.3.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "21"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

hibernate {
	enhancement {
		enableAssociationManagement.set(true)
	}
}

