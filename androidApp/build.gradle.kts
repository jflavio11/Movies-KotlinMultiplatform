plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    compileSdk = 33
    defaultConfig {
        applicationId = "com.jflavio.layeredarch.android"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        compose = true
    }

    // Set both the Java and Kotlin compilers to target Java 8.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.6"
    }
    namespace = "com.jflavio.layeredarch.android"
}

dependencies {
    implementation(project(":shared"))
    implementation(platform("androidx.compose:compose-bom:2023.05.01"))
    implementation("androidx.compose.foundation:foundation")
    // Integration with activities
    implementation("androidx.activity:activity-compose")
    // Compose Material Design
    implementation("androidx.compose.material:material")
    // Animations
    implementation("androidx.compose.animation:animation")
    // Tooling support (Previews, etc.)
    implementation("androidx.compose.ui:ui-tooling")
    // Integration with ViewModels
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose")
    implementation("com.github.skydoves:landscapist-coil:2.1.2")
    implementation("com.airbnb.android:lottie-compose:5.0.3")
}