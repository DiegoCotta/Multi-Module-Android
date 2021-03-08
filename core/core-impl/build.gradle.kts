import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-impl")
}

val base_url: String = gradleLocalProperties(rootDir).getProperty("base_url")
android {
    buildTypes {
        getByName("debug") {
            buildConfigField("String", "BASE_URL", base_url)
        }
        getByName("release") {
            buildConfigField("String", "BASE_URL", base_url)
        }
    }
}

dependencies {
    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
}