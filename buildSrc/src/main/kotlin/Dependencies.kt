@file:Suppress("unused")

import org.gradle.api.JavaVersion

object Config {
    val compatibleJavaVersion = JavaVersion.VERSION_11
    const val jvmTarget = "11"
    const val kotlinVersion = "1.8.10"
    const val gradleAndroidVersion = "7.4.0"
    const val daggerVersion = "2.44"
}

object Android {
    const val applicationId = "com.infoabout.contactlist"
    const val compileSdk = 33
    const val minSdk = 24
    const val targetSdk = 33

    const val versionCode = 1
    //todo
    const val versionName = "1.0"

    const val testInstrumentalRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Obfuscation {
    const val releaseMinifyEnabled = true
    const val debugMinifyEnabled = false
    const val releaseDebuggable = false
    const val debugDebuggable = true
}

object Plugins {
    const val application = "com.android.application"
    const val kotlin = "org.jetbrains.kotlin.android"
    const val parcelable = "kotlin-parcelize"
    const val daggerHilt = "dagger.hilt.android.plugin"
    const val safe_args = "androidx.navigation.safeargs.kotlin"
    const val kapt = "kotlin-kapt"
    const val androidLibrary = "com.android.library"
}

object Project {
    object Dagger {
        const val daggerHilt =
            "com.google.dagger:hilt-android-gradle-plugin:${Config.daggerVersion}"
    }

    object Android {
        const val androidGradle = "com.android.tools.build:gradle:7.4.0"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Config.kotlinVersion}"
    }
}

object Libs {
    object View {
        const val appCompat = "androidx.appcompat:appcompat:1.5.1"
        const val coreKtx = "androidx.core:core-ktx:1.9.0"
        const val material = "com.google.android.material:material:1.7.0"
        const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:1.5.5"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"

        object Test {
            const val jUnit = "junit:junit:4.13.2"
            const val mockito = "org.mockito:mockito-core:4.1.0"
            const val unit_coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
        }

        object AndroidTest {
            const val jUnit = "androidx.test.ext:junit:1.1.5"
            const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
        }
    }

    object Application {
        object DependencyInjection {
            private const val koinVersion = "3.3.3"
            private const val koinCompose = "3.4.2"

            const val hilt = "com.google.dagger:hilt-android:${Config.daggerVersion}"
            const val kaptDagger = "com.google.dagger:hilt-compiler:${Config.daggerVersion}"
            const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"

            const val koinAndroid = "io.insert-koin:koin-android:$koinVersion"
            const val koinAndroidCompose = "io.insert-koin:koin-androidx-compose:$koinCompose"

            const val hilt_compiler =
                "com.google.dagger:hilt-android-compiler:${Config.daggerVersion}"
        }

        object Database {
            private const val roomVersion = "2.4.3"

            const val roomRuntime = "androidx.room:room-runtime:$roomVersion"
            const val kaptRoom = "androidx.room:room-compiler:$roomVersion"
            const val roomKtx = "androidx.room:room-ktx:$roomVersion"
            const val roomPaging = "androidx.room:room-paging:$roomVersion"
        }

        object Coroutines {
            private const val version = "1.6.3"

            const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
        }

        object Navigation {
            private const val nav_version = "2.5.3"
            const val navigation_fragment =
                "androidx.navigation:navigation-fragment-ktx:$nav_version"
            const val navigation_ui = "androidx.navigation:navigation-ui-ktx:$nav_version"
            const val nav_safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"
        }

        object Network {
            object Retrofit {
                private const val version = "2.9.0"
                const val retrofit = "com.squareup.retrofit2:retrofit:$version"
                const val retrofit_gson = "com.squareup.retrofit2:converter-gson:$version"
            }

            object OkHttp {
                private const val version = "4.10.0"
                const val okhttp_logging = "com.squareup.okhttp3:logging-interceptor:$version"
                const val okhttp = "com.squareup.okhttp3:okhttp:$version"
            }
        }
    }
}