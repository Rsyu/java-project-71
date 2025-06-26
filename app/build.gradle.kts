plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("application")
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

application {
    mainClass.set("hexlet.code.App")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("info.picocli:picocli:4.7.5")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5") // для автогенерации, если понадобится
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.1")
}

tasks.test {
    useJUnitPlatform()
}
