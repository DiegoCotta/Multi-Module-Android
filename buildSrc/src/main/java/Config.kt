import com.android.build.gradle.BaseExtension
import com.example.android.architectureexample.Versions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

open class ConfigPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configAndroid()
    }
}



fun Project.configAndroid() = this.extensions.getByType<BaseExtension>().run {
    compileSdkVersion(Versions.TARGET_ANDROID_SDK)
    buildToolsVersion(Versions.ANDROID_BUILD_TOOLS)
    defaultConfig {
        minSdkVersion(Versions.MIN_ANDROID_SDK)
        targetSdkVersion(Versions.TARGET_ANDROID_SDK)

        consumerProguardFiles("consumer-rules.pro")
    }

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

}