plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.cheng.experimentapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.hellowebview"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.constraintlayout)

    // Jetpack compose
    val composeBom = platform(libs.androidx.compose.bom)
    implementation(composeBom)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.compose.material)
    implementation(libs.ui.tooling.preview)

    // Try to reproduce "LayoutNode should be attached to an owner" issue
    implementation(libs.google.map.compose)
    implementation(libs.google.play.service.map)

    // Invoke JS code from kotlin
    implementation(libs.rhino)
    // Logging tool
    implementation(libs.timber)

    testImplementation(libs.test.junit)
    testImplementation(composeBom)
    androidTestImplementation(composeBom)
    androidTestImplementation(libs.android.test.androidx.junit)
    androidTestImplementation(libs.android.test.androidx.espresso.core)
}
