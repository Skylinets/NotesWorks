plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.skyline.notes"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.skyline.notes"
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
            signingConfig = signingConfigs.getByName("debug")
        }
    }

    flavorDimensions("environment")
    productFlavors {
        create("dummy") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"http://localhost/\"")
        }
        create("uat") {
            dimension = "environment"
            buildConfigField("String", "BASE_URL", "\"https://a2f960695b744e208e8d04bb27c46a04.api.mockbin.io/\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.get()
    }
}

dependencies {

    implementation(libs.kotlin.stdlib)
    implementation(libs.androidx.espresso.core)
    implementation(libs.compose.ui)
    implementation(libs.compose.material)
    implementation(libs.compose.tooling)
    implementation(libs.compose.activity)
    implementation(libs.lifecycle.viewmodel.compose)
    implementation(libs.coroutines.android)
    implementation(libs.retrofit2)
    implementation(libs.retrofit.gson.converter)
    implementation(libs.okhttp.logging)
    //implementation(libs.dagger2)
    //implementation(libs.google.dagger)
    implementation(libs.coil.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.runtime)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.insert.koin)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    ksp(libs.dagger2.compiler)
}