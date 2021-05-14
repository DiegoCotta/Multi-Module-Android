import com.example.android.architectureexample.implementation

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("android-api")
    id("androidx.navigation.safeargs.kotlin")
}

dependencies {
    implementation(project(":core-impl"))
    implementation("com.firebaseui:firebase-ui-auth:5.0.0")
}

