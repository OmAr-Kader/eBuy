plugins {
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.composePlugin).apply(false)
    alias(libs.plugins.kotlinSerialization).apply(false)
    //alias(libs.plugins.moko.multiplatform.resources).apply(false)
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "17"
    }
}

val cmpVersion = "1.6.0"
configurations.configureEach {
    resolutionStrategy.eachDependency {
        if (requested.group == "androidx.collection" && requested.name.startsWith("collection")) {
            useTarget("org.jetbrains.compose.collection-internal:collection:$cmpVersion")
        } else if (requested.group == "androidx.annotation" && requested.name.startsWith("annotation")) {
            useTarget("org.jetbrains.compose.annotation-internal:annotation:1.8.0-alpha01")
        }
    }
}
