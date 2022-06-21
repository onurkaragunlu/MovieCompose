plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = ConfigData.compileSdkVersion

    defaultConfig {
        minSdk = ConfigData.minSdkVersion
        targetSdk = ConfigData.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}

dependencies {
    implementation(Deps.coreKtx)
    Deps.composeLibraries.forEach(::implementation)
    implementation(project(":feature-movie-api"))
    implementation(project(":domain-movie"))
    implementation(project(":base-ui"))
    implementation(project(":base-domain"))
    implementation(project(":core-model"))
    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation(Deps.pagingLibraryCommon)
    implementation( "androidx.paging:paging-compose:1.0.0-alpha15")
}