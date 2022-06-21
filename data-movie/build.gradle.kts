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
}
dependencies {
    implementation(Deps.coreKtx)
    implementation(project(":domain-movie"))
    implementation(project(":core-model"))
    implementation(project(":core-network-model"))
    implementation(project(":base-data"))
    //TODO check here why it use base domain
    implementation(project(":base-domain"))
    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)
    implementation(Deps.moshi)
    kapt(Deps.moshiCodegenKapt)
    implementation(Deps.retrofit)
    implementation(Deps.pagingLibraryCommon)
}