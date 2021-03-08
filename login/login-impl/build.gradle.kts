import com.example.android.architectureexample.implementation

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-impl")
}

dependencies {
    this.implementation(project(":login-api"))
    implementation(project(":core-impl"))

    implementation("androidx.appcompat:appcompat:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    this.implementation("com.firebaseui:firebase-ui-auth:5.0.0")

}