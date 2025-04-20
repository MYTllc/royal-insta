plugins {
    `java-library`
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.MYTllc.lavalink" // <-- Updated Group ID
version = "1.2.0" // Version remains the same unless you make functional changes

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("dev.arbjerg.lavalink:lavalink-api:4.0.8")
    compileOnly("org.slf4j:slf4j-api:2.0.7")

    implementation("org.apache.httpcomponents.client5:httpclient5:5.3")
    implementation("org.jsoup:jsoup:1.17.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.3")

    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")

    compileOnly("com.sedmelluq:lavaplayer:1.3.77")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<Jar> {
     archiveClassifier.set("unshaded")
}

tasks.shadowJar {
    archiveClassifier.set("")
}

tasks.assemble {
    dependsOn(tasks.shadowJar)
}
