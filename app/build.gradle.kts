plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("application")
    id("org.sonarqube") version "6.0.1.5171"
    id("checkstyle")
    id ("jacoco")
}
application {
    mainClass.set("hexlet.code.App")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("info.picocli:picocli:4.7.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
    testImplementation ("org.junit.jupiter:junit-jupiter-api") // API для JUnit
    testImplementation ("org.junit.jupiter:junit-jupiter-engine") // Движок для JUnit
    testRuntimeOnly ("org.junit.platform:junit-platform-launcher") // Платформа для запуска тестов
}

tasks.test {
    useJUnitPlatform()
}
tasks.jacocoTestReport { reports { xml.required.set(true) } }

// Конфигурация плагина org.sonarqube
sonar {
    properties {
        property("sonar.projectKey", "Rsyu_java-project-71")
        property("sonar.organization", "rsyu")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}