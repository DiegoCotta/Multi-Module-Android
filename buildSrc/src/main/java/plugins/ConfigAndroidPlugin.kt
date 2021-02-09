package com.example.android.architectureexample.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

open class ConfigAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.plugins.apply("com.android.application")
        target.plugins.apply("kotlin-android")
        target.configAndroid()
    }
}
