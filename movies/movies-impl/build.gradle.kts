plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-impl")
}

dependencies {
    this.implementation(project(":movies-api"))
}