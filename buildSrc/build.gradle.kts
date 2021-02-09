repositories {
    mavenCentral()
    google()
    jcenter()
}

plugins {
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("android-base") {
            id = "android-base"
            implementationClass = "com.example.android.architectureexample.plugins.ConfigAndroidPlugin"
        }
        register("android-api") {
            id = "android-api"
            implementationClass = "com.example.android.architectureexample.plugins.ConfigApiPlugin"
        }
        register("android-impl") {
            id = "android-impl"
            implementationClass = "com.example.android.architectureexample.plugins.ConfigImplPlugin"
        }
        register("android-fake") {
            id = "android-fake"
            implementationClass = "com.example.android.architectureexample.plugins.ConfigFakePlugin"
        }
    }
}

dependencies {
    // Depend on the android gradle plugin, since we want to access it in our plugin
    implementation("com.android.tools.build:gradle:4.1.2")

    // Depend on the kotlin plugin, since we want to access it in our plugin
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.21")

    // Depend on the default Gradle API since we want to build a custom plugin
    implementation(gradleApi())
    implementation(localGroovy())
}