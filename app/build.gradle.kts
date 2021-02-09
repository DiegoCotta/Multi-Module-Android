plugins {
    id("android-base")
}

android {

    defaultConfig {
        applicationId = "com.example.android.architectureexample"
        versionCode = 1
        versionName = "1.0"

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
    this.implementation(project(":core-api"))
    this.implementation(project(":core-impl"))
    this.implementation(project(":login-api"))
    this.implementation(project(":login-impl"))
    this.implementation(project(":movies-api"))
    this.implementation(project(":movies-impl"))

}
