import java.net.URI

buildscript {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
        classpath("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:0.13.3")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven {
            this.url = URI.create("https://oss.sonatype.org/content/repositories/snapshots/")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}