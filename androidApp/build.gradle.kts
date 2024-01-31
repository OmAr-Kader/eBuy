plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
}

android {
    namespace = "com.ramo.ebuy.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.ramo.ebuy.android"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    buildToolsVersion = "34.0.0"
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }
    kotlin {
        sourceSets {
            all {
                languageSettings {
                    //optIn("kotlin.RequiresOptIn")
                    optIn("com.arkivanov.decompose.ExperimentalDecomposeApi")
                    optIn("androidx.compose.foundation.layout.ExperimentalLayoutApi")
                }
            }
        }
    }
}

dependencies {
    implementation(projects.shared)
    implementation(libs.androidx.core)
    implementation(libs.androidx.activity.compose)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.decompose)
}
