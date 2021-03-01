import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("android-impl")
}


val api_key: String = gradleLocalProperties(rootDir).getProperty("api_key")
android {
    buildTypes {
        getByName("debug") {
            buildConfigField("String", "API_KEY", api_key)
        }
        getByName("release") {
            buildConfigField("String", "API_KEY", api_key)
        }
    }
}

dependencies {
    this.implementation(project(":movies-api"))
    this.implementation(project(":core-impl"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
}