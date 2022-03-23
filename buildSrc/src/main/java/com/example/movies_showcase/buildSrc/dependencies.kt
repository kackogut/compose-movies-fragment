package com.example.movies_showcase.buildSrc

object Libs {

    object Kotlin {
        const val version = "1.6.10"
    }

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.7.0"

        object Activity {
            const val activityCompose = "androidx.activity:activity-compose:1.4.0"
            const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        }

        object Compose {
            const val version = "1.1.1"

            const val foundation = "androidx.compose.foundation:foundation:$version"
            const val layout = "androidx.compose.foundation:foundation-layout:$version"
            const val material = "androidx.compose.material:material:$version"
            const val materialIconsExtended =
                "androidx.compose.material:material-icons-extended:$version"
            const val runtime = "androidx.compose.runtime:runtime:$version"
            const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
            const val toolingPreview = "androidx.compose.ui:ui-tooling-preview:$version"
            const val uiTooling = "androidx.compose.ui:ui-tooling:$version"
            const val viewBinding = "androidx.compose.ui:ui-viewbinding:$version"
        }

        object Material3 {
            const val material3 = "androidx.compose.material3:material3:1.0.0-alpha06"
        }

        object Paging {
            const val compose = "androidx.paging:paging-compose:1.0.0-alpha14"
        }

        object Test {
            const val core = "androidx.arch.core:core-testing:2.1.0"
        }
    }

    object Coroutines {
        const val version = "1.6.0"

        object Ext {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }

        object Test {
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object Material {
        const val material3 = "com.google.android.material:material:1.6.0-alpha02"
    }

    object Coil {
        const val coil = "io.coil-kt:coil-compose:2.0.0-rc01"
    }

    object Lifecycle {
        private const val version = "2.4.1"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
    }

    object Navigation {
        const val version = "2.4.1"
        const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
    }

    object Hilt {
        const val version = "2.41"

        object Ext {
            const val hilt = "com.google.dagger:hilt-android:$version"
        }

        object Kapt {
            const val kapt = "com.google.dagger:hilt-compiler:$version"
        }
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val moshi = "com.squareup.retrofit2:converter-moshi:2.4.0"
    }

    object OkHttp {
        const val version = "4.9.3"
        const val okhttp = "com.squareup.okhttp3:okhttp:$version"
        const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
    }

    object Test {
        const val junit = "junit:junit:4.13"
        const val mockk = "io.mockk:mockk:1.12.3"
        const val truth = "com.google.truth:truth:1.1.3"
    }
}
