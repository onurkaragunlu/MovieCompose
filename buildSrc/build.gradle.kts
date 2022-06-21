import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}
buildscript{

}
dependencies {
   // implementation("com.android.tools.build:gradle-api:7.2.1")
    gradleApi()
    //implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
}

