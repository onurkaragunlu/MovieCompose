plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}
android {
    compileSdk = ConfigData.compileSdkVersion
    defaultConfig {
        applicationId = "com.onurkaragunlu.moviecompose"
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(":core-ui"))
    implementation(project(":feature-movie-impl"))
    implementation(project(":feature-movie-api"))
    implementation(project(":feature-favoriteList-impl"))
    implementation(project(":feature-favoriteList-api"))
    implementation(Deps.coreKtx)
    implementation(Deps.composeUI)
    implementation(Deps.composeMaterial)
    implementation(Deps.composeUIToolPreview)
    implementation(Deps.lifecycleRuntimeKtx)
    implementation(Deps.activityCompose)
    implementation(Deps.navigationCompose)
    testImplementation(Deps.jUnit)
    androidTestImplementation(Deps.jUnitExt)
    androidTestImplementation(Deps.espressoCore)
    androidTestImplementation(Deps.uiTestJunit4)
    debugImplementation(Deps.uiTooling)
    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)
    implementation(project(":data-movie"))
    implementation(project(":core-network"))
}
