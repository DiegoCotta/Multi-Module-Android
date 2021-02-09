package com.example.android.architectureexample.plugins

import com.android.build.gradle.BaseExtension
import com.example.android.architectureexample.Versions
import com.example.android.architectureexample.androidBase
import com.example.android.architectureexample.apiBase
import com.example.android.architectureexample.implBase
import org.gradle.api.JavaVersion

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

fun Project.configAndroid() = this.extensions.getByType<BaseExtension>().run {
    compileSdkVersion(Versions.TARGET_ANDROID_SDK)
    buildToolsVersion(Versions.ANDROID_BUILD_TOOLS)
    defaultConfig {
        minSdkVersion(Versions.MIN_ANDROID_SDK)
        targetSdkVersion(Versions.TARGET_ANDROID_SDK)

        consumerProguardFiles("consumer-rules.pro")
    }

    dataBinding.isEnabled = true

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}.apply {
    this@configAndroid.tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
    this@configAndroid.dependencies {
        androidBase()
    }
}

fun Project.configApi() = this.extensions.getByType<BaseExtension>().apply {
    this@configApi.dependencies {
        apiBase()
    }
}

fun Project.configImpl() = this.extensions.getByType<BaseExtension>().apply {
    this@configImpl.dependencies {
        implBase()
    }
}

fun Project.configFake() = this.extensions.getByType<BaseExtension>().apply {
    this@configFake.dependencies {

    }
}