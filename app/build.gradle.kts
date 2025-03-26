plugins {
    id("java")
    id("com.github.ben-manes.versions") version "0.51.0"
    id("application")
    id("checkstyle")
}

checkstyle {
    toolVersion = "10.12.3" // Укажите актуальную версию Checkstyle
    configFile = file("${rootProject.projectDir}/config/checkstyle/checkstyle.xml")
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required.set(true)
        html.required.set(true)
    }
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
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
}

tasks.test {
    useJUnitPlatform()
}