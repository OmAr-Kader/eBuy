plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.composePlugin)
    alias(libs.plugins.kotlinSerialization)
    //alias(libs.plugins.moko.multiplatform.resources)
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = libs.versions.jvmTarget.get()
            }
        }
    }

    /*listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
            //export(libs.moko.resources)
            //export(libs.moko.graphics)
        }
    }*/

    sourceSets {
        all {
            languageSettings {
                optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
                optIn("androidx.compose.material3.ExperimentalMaterial3Api")
                optIn("androidx.compose.foundation.layout.ExperimentalLayoutApi")
                optIn("androidx.compose.foundation.ExperimentalFoundationApi")
                optIn("com.arkivanov.decompose.ExperimentalDecomposeApi")
            }
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)

            implementation(libs.zvoyager.navigator)
            implementation(libs.composeImageLoader)
            implementation(libs.napier)
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.composeIcons.featherIcons)
            implementation(libs.kotlinx.datetime)
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.decompose)
            implementation(libs.decompose.jetbrains)
            implementation(libs.kotlinx.serialization.json)

            implementation(libs.supabase.gotrue)
            implementation(libs.supabase.realtime)
            implementation(libs.supabase.postgrest)
            implementation(libs.supabase.auth)
            implementation(libs.supabase.auth.ui)
            implementation(libs.supabase.storage)
            implementation(libs.settings.russhwolf)
            implementation(libs.napier)
            implementation(libs.peekaboo.ui)
            implementation(libs.peekaboo.image.picker)
            implementation(libs.compose.collection)
            api(libs.moko.mvvm.core)
            api(libs.moko.mvvm.compose)
            api(libs.moko.mvvm.flow)
            api(libs.moko.mvvm.flow.compose)
            api(libs.moko.mvvm.livedata.compose)
            implementation(libs.flexible.bottomsheet)
            implementation(libs.ktor.touch)
            // https://mvnrepository.com/artifact/com.google.mlkit/vision-common
            //implementation("com.google.mlkit:vision-common:17.3.0")

        }
        androidMain.dependencies {
            implementation(libs.koin.android)
            implementation(libs.ktor.android)
            implementation(libs.kotlinx.coroutines.android)
        }
        iosMain.dependencies {
            implementation(libs.ktor.ios)
            implementation(libs.ktor.darwin)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
    targets.withType(org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget::class.java).all {
        binaries.withType(org.jetbrains.kotlin.gradle.plugin.mpp.Framework::class.java).all {
            export(libs.moko.mvvm.core)
        }
    }
}

android {
    namespace = libs.versions.applicationId.get()
    //namespace = "com.ramo.ebuy.android"
    compileSdk = libs.versions.compileSdk.get().toInt()
    //sourceSets["main"].resources.srcDirs("src/commonMain/resources")
    defaultConfig {
        minSdk = libs.versions.minSdk.get().toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    java {
        toolchain.languageVersion.set(JavaLanguageVersion.of(libs.versions.jvmTarget.get().toInt()))
    }
}

/*
multiplatformResources {
    multiplatformResourcesPackage = "com.ramo.myapplication"
    multiplatformResourcesClassName = "SharedRes"
}*/
