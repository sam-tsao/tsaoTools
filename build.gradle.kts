import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.32"
    id("maven-publish")
}

group = "com.github.chosamuel"
version = "0.0.1"

repositories {
    mavenCentral()
}


publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            groupId = "com.github.chosamuel"
            artifactId = "tsaoTools"
            version = "0.0.1"

            from(components["java"])
        }
    }
}


dependencies {
    implementation("org.openrndr:openrndr:0.3.47")
    implementation("org.openrndr:openrndr-core:0.3.47")
    implementation("org.openrndr:openrndr-color:0.3.47")
    implementation("org.openrndr:openrndr-shape:0.3.47")
    implementation("org.openrndr:openrndr-math:0.3.47")
    implementation("org.openrndr:openrndr-gl3:0.3.47")
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
