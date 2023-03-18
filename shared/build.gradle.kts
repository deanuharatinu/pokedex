plugins {
  kotlin("multiplatform")
  id("com.android.library")
  kotlin("plugin.serialization")
}

kotlin {
  android {
    compilations.all {
      kotlinOptions {
        jvmTarget = "1.8"
      }
    }
  }

  listOf(
    iosX64(),
    iosArm64(),
    iosSimulatorArm64()
  ).forEach {
    it.binaries.framework {
      baseName = "shared"
    }
  }

  sourceSets {
    val mokoMvvmVersion = "0.13.0"
    val kmmPagingVersion = "0.6.2"

    val commonMain by getting {
      dependencies {
        implementation("io.ktor:ktor-client-core:2.2.4")
        implementation("io.ktor:ktor-client-serialization:2.2.4")
        implementation("io.ktor:ktor-client-content-negotiation:2.2.4")
        implementation("io.ktor:ktor-serialization-kotlinx-json:2.2.4")
        implementation("io.ktor:ktor-client-logging:2.2.4")

        implementation(Koin.core)
        implementation(Deps.multiplatformPaging)
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test"))
        implementation(Koin.test)
      }
    }
    val androidMain by getting {
      dependencies {
        implementation("io.ktor:ktor-client-android:2.2.4")
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
      }
    }
    val androidUnitTest by getting
    val iosX64Main by getting
    val iosArm64Main by getting
    val iosSimulatorArm64Main by getting
    val iosMain by creating {
      dependsOn(commonMain)
      iosX64Main.dependsOn(this)
      iosArm64Main.dependsOn(this)
      iosSimulatorArm64Main.dependsOn(this)
      dependencies {
        implementation("io.ktor:ktor-client-ios:2.2.4")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.3-native-mt") {
          version {
            strictly("1.6.3-native-mt")
          }
        }
        implementation(Deps.multiplatformPaging)
      }
    }
    val iosX64Test by getting
    val iosArm64Test by getting
    val iosSimulatorArm64Test by getting
    val iosTest by creating {
      dependsOn(commonTest)
      iosX64Test.dependsOn(this)
      iosArm64Test.dependsOn(this)
      iosSimulatorArm64Test.dependsOn(this)
    }
  }
}

android {
  namespace = "com.deanuharatinu.pokedex"
  compileSdk = AndroidSdk.compile
  defaultConfig {
    minSdk = AndroidSdk.min
  }
}
