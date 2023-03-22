plugins {
  id("com.android.application")
  kotlin("android")
}

android {
  namespace = "com.deanuharatinu.pokedex.android"
  compileSdk = 33
  defaultConfig {
    applicationId = "com.deanuharatinu.pokedex.android"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "1.0"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.0"
  }
  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
}

dependencies {
  implementation("androidx.compose.ui:ui:1.3.1")
  implementation("androidx.compose.ui:ui-tooling:1.3.1")
  implementation("androidx.compose.ui:ui-tooling-preview:1.3.1")
  implementation("androidx.compose.foundation:foundation:1.3.1")
  implementation("androidx.compose.runtime:runtime:1.3.1")
  implementation("androidx.compose.material:material:1.3.1")
  implementation("androidx.activity:activity-compose:1.6.1")

  with(Koin) {
    implementation(core)
    implementation(android)
    implementation(compose)
  }

  implementation(Deps.multiplatformPaging)

  with(Compose) {
    implementation(paging)
    implementation(coilCompose)
  }

  implementation(project(":shared"))
}