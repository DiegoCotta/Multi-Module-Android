import com.example.android.architectureexample.implementation
import com.example.android.architectureexample.kapt
import com.example.android.architectureexample.compileOnly

plugins {
    id("android-base")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-impl")
    id("androidx.navigation.safeargs.kotlin")
}

apply(plugin = "com.google.gms.google-services")


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
    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    this.compileOnly(com.example.android.architectureexample.Dependencies.DAGGER)
    this.kapt(com.example.android.architectureexample.Dependencies.DAGGER_COMPILER)
    this.implementation(com.example.android.architectureexample.Dependencies.DAGGER_ANDROID)
    this.implementation("com.android.support:multidex:1.0.3")

    this.kapt(com.example.android.architectureexample.Dependencies.DAGGER_ANDROID_PROCESSOR)
    this.implementation(project(":core-impl"))
    this.implementation(project(":login-api"))
    this.implementation(project(":login-impl"))
    this.implementation(project(":movies-api"))
    this.implementation(project(":movies-impl"))
    this.implementation(com.example.android.architectureexample.Dependencies.COROUTINES_CORE)
    this.implementation( "com.google.dagger:dagger:2.26")
    this.kapt("com.google.dagger:dagger-compiler:2.26")
    this.implementation("com.google.firebase:firebase-bom:26.6.0")
    this.implementation("com.firebaseui:firebase-ui-auth:5.0.0")
    this.implementation(com.example.android.architectureexample.Dependencies.ANDROID_LIVEDATA)
    this.implementation(com.example.android.architectureexample.Dependencies.ANDROID_LIFECYCLE_RUNTIME)
    this.implementation(com.example.android.architectureexample.Dependencies.ANDROID_LIFECYCLE_EX)
    this.implementation(com.example.android.architectureexample.Dependencies.ANDROID_CORE_KTX)
}
