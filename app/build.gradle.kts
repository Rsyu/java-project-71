plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("checkstyle")
    id("jacoco")
    id("org.sonarqube") version "6.2.0.5505"
    application
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
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.2")
    implementation("info.picocli:picocli:4.7.5")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.0")
}

tasks.test {
    useJUnitPlatform()
}

checkstyle {
    toolVersion = "10.12.2"
    configFile = rootProject.file("config/checkstyle/checkstyle.xml") // путь к вашему файлу
    isIgnoreFailures = false
}

tasks.withType<Checkstyle> {
    reports {
        xml.required.set(false)
        html.required.set(true)
    }
}

tasks.named("check") {
    dependsOn(tasks.named("checkstyleMain"))
    dependsOn(tasks.named("checkstyleTest"))
}

jacoco {
    toolVersion = "0.8.10"
}

tasks.jacocoTestReport {
    dependsOn(tasks.test)

    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}

sonar {
    properties {
        property("sonar.projectKey", "Rsyu_java-project-712")
        property("sonar.organization", "rsyu")
        property("sonar.host.url", "https://sonarcloud.io")
    }
}