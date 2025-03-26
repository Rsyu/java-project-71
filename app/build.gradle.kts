plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("application")
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
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.3")
}

tasks.test {
    useJUnitPlatform()
}