plugins {
  kotlin("multiplatform")
  id("com.android.library")
  kotlin("plugin.serialization")
  id("app.cash.sqldelight")
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
    val commonMain by getting {
      dependencies {
        with(Ktor) {
          implementation(clientCore)
          implementation(clientSerialization)
          implementation(contentNegotiation)
          implementation(ktorJson)
          implementation(clientLogging)
        }

        implementation(Koin.core)
        implementation(SqlDelight.coroutineExt)

        with(Deps) {
          implementation(multiplatformPaging)
          implementation(store5)
          implementation(atomicFu)
        }
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
        implementation(Ktor.clientAndroid)
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")
        implementation(SqlDelight.android)
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
        implementation(Ktor.clientIos)
        implementation(SqlDelight.ios)
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

sqldelight {
  databases {
    create("Database") {
      packageName.set("com.deanuharatinu.pokedex")
    }
  }
}