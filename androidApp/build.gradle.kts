plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrains.kotlinAndroid)
}

android {
    namespace = "com.determent.determent_management.android"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.determent.determent_management.android"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.version.get()
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
}

dependencies {
    implementation(projects.shared)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)

    implementation(libs.android.composeUiToolingPreview)
    debugImplementation(libs.android.composeUiTooling)
}