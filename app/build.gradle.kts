
import com.example.android.architectureexample.implementation
import com.example.android.architectureexample.kapt
import com.example.android.architectureexample.compileOnly

plugins {
    id("android-base")
    id("kotlin-kapt")
}

android {

    defaultConfig {
        applicationId = "com.example.android.architectureexample"
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    this.compileOnly(com.example.android.architectureexample.Dependencies.DAGGER)
    this.kapt(com.example.android.architectureexample.Dependencies.DAGGER_COMPILER)
    this.implementation(com.example.android.architectureexample.Dependencies.DAGGER_ANDROID)
    this.implementation("com.android.support:multidex:1.0.3")

    this.kapt(com.example.android.architectureexample.Dependencies.DAGGER_ANDROID_PROCESSOR)
    this.implementation(project(":core-api"))
    this.implementation(project(":core-impl"))
    this.implementation(project(":login-api"))
    this.implementation(project(":login-impl"))
    this.implementation(project(":movies-api"))
    this.implementation(project(":movies-impl"))
    this.implementation( "com.google.dagger:dagger:2.26")
    this.kapt("com.google.dagger:dagger-compiler:2.26")

}
