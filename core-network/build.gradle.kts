

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
            buildConfigField("String","API_URL","\"https://api.themoviedb.org/3/\"")
        }
        debug {
            buildConfigField("String","API_URL","\"https://api.themoviedb.org/3/\"")
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
    implementation(Deps.retrofit)
    implementation(Deps.moshi)
    kapt(Deps.moshiCodegenKapt)
    implementation(Deps.hilt)
    kapt(Deps.hiltKapt)
    implementation(Deps.moshiConvertor)
    implementation(Deps.coroutinesCore)
    implementation(project(":core-network-model"))
    implementation(project(":core-model"))
    implementation(Deps.loggingInterceptor)

}