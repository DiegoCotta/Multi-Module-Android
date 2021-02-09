package com.example.android.architectureexample

import org.gradle.api.artifacts.dsl.DependencyHandler

object Dependencies {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE}"
    const val ANDROID_APP_COMPAT = "androidx.appcompat:appcompat:${Versions.Androidx.APP_COMPAT}"
    const val ANDROID_CORE_KTX = "androidx.core:core-ktx:${Versions.Androidx.CORE_KTX}"
    const val ANDROID_WORK_MANAGER = "androidx.work:work-runtime-ktx:${Versions.Androidx.WORK_MANAGER}"
    const val ANDROID_BROWSER = "androidx.browser:browser:${Versions.Androidx.BROWSER}"
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.MATERIAL_ANDROID}"
    const val ANDROID_CONSTRAINT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val ANDROID_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIVEDATA_VERSION}"


    const val GMS_MAP = "com.google.android.gms:play-services-maps:${Versions.GMS_MAP}"
    const val CRASHLYTICS = "com.crashlytics.sdk.android:crashlytics:${Versions.CRASHLYTICS}"

    const val ANDROID_ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.Androidx.ROOM}"
    const val ANDROID_ROOM_KTX = "androidx.room:room-ktx:${Versions.Androidx.ROOM}"
    const val ANDROID_ROOM_COMPILER = "androidx.room:room-compiler:${Versions.Androidx.ROOM}"

    const val ANDROID_LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime:${Versions.Androidx.LIFECYCLE}"
    const val ANDROID_LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Androidx.LIFECYCLE}"
    const val ANDROID_LIFECYCLE_EX = "androidx.lifecycle:lifecycle-extensions:${Versions.Androidx.LIFECYCLE}"
    const val ANDROID_LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Androidx.LIFECYCLE}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTER_MOSHI = "com.squareup.retrofit2:converter-moshi:${Versions.RETROFIT}"

    const val MOSHI = "com.squareup.moshi:moshi-kotlin:${Versions.MOSHI}"
    const val MOSHI_CODEGEN = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.MOSHI}"

    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP3}"

    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER2}"
    const val DAGGER_COMPILER = "com.google.dagger:dagger-compiler:${Versions.DAGGER2}"
    const val DAGGER_ANDROID = "com.google.dagger:dagger-android-support:${Versions.DAGGER2}"
    const val DAGGER_ANDROID_PROCESSOR = "com.google.dagger:dagger-android-processor:${Versions.DAGGER2}"

    const val FIREBASE_CORE = "com.google.firebase:firebase-core:${Versions.Firebase.CORE}"
    const val FIREBASE_ADS = "com.google.firebase:firebase-ads:${Versions.Firebase.ADS}"
    const val FIREBASE_APP_INDEXING = "com.google.firebase:firebase-appindexing:${Versions.Firebase.APP_INDEX}"

    const val TEST_J_UNIT = "junit:junit:${Versions.J_UNIT}"
    const val TEST_ANDROID_J_UNIT = "junit:junit:${Versions.Androidx.TEST_J_UNIT}"
    const val TEST_ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.Androidx.ESPRESSO}"


    object Kotlin {
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN_VERION}"
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN_VERION}"
    }
}

fun DependencyHandler.androidBase(){
    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.ANDROID_CORE_KTX)
    testImplementation(Dependencies.TEST_J_UNIT)
    androidTestImplementation(Dependencies.TEST_ANDROID_J_UNIT)
    androidTestImplementation(Dependencies.TEST_ESPRESSO)
    implementation(Dependencies.ANDROID_APP_COMPAT)
    implementation(Dependencies.ANDROID_MATERIAL)
    implementation(Dependencies.ANDROID_CONSTRAINT)
}

fun DependencyHandler.apiBase(){
    implementation(Dependencies.ANDROID_LIVEDATA)
    implementation(Dependencies.COROUTINES_CORE)
    implementation(Dependencies.COROUTINES_ANDROID)
}

fun DependencyHandler.implBase(){
    dagger()
    implementation(Dependencies.ANDROID_LIVEDATA)
    implementation(Dependencies.COROUTINES_CORE)
    implementation(Dependencies.COROUTINES_ANDROID)
}

fun DependencyHandler.firebase() {
    implementation(Dependencies.FIREBASE_CORE)
    implementation(Dependencies.FIREBASE_ADS)
    implementation(Dependencies.FIREBASE_APP_INDEXING)
}

fun DependencyHandler.dagger() {
    compileOnly(Dependencies.DAGGER)
    kapt(Dependencies.DAGGER_COMPILER)
    implementation(Dependencies.DAGGER_ANDROID)
    kapt(Dependencies.DAGGER_ANDROID_PROCESSOR)
}

fun DependencyHandler.appCompat() {
    implementation(Dependencies.ANDROID_APP_COMPAT)
    implementation(Dependencies.ANDROID_CORE_KTX)
}

fun DependencyHandler.lifecycle() {
    implementation(Dependencies.ANDROID_LIFECYCLE_RUNTIME)
    implementation(Dependencies.ANDROID_LIFECYCLE_EX)
    implementation(Dependencies.ANDROID_LIFECYCLE_VIEWMODEL)
    implementation(Dependencies.ANDROID_LIFECYCLE_LIVEDATA)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTER_MOSHI)
    implementation(Dependencies.OKHTTP_LOGGER)
}

fun DependencyHandler.moshi() {
    implementation(Dependencies.MOSHI)
    kapt(Dependencies.MOSHI_CODEGEN)
}

fun DependencyHandler.room() {
    api(Dependencies.ANDROID_ROOM_RUNTIME)
    implementation(Dependencies.ANDROID_ROOM_KTX)
    kapt(Dependencies.ANDROID_ROOM_COMPILER)
}

fun DependencyHandler.implementation(depName: String) {
    add("implementation", depName)
}
fun DependencyHandler.testImplementation(depName: String) {
    add("testImplementation", depName)
}
fun DependencyHandler.androidTestImplementation(depName: String) {
    add("androidTestImplementation", depName)
}

private fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

private fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

private fun DependencyHandler.api(depName: String) {
    add("api", depName)
}