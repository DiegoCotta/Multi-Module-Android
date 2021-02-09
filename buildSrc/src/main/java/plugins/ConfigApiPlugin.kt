package com.example.android.architectureexample.plugins

import org.gradle.api.Plugin
import org.gradle.api.Project

open class ConfigApiPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configAndroid()
        target.configApi()
    }
}