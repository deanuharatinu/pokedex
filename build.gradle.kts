plugins {
  id("com.android.application").version("7.4.1").apply(false)
  id("com.android.library").version("7.4.1").apply(false)
  kotlin("plugin.serialization").version("1.8.10").apply(false)
  kotlin("android").version("1.8.0").apply(false)
  kotlin("multiplatform").version("1.8.0").apply(false)
  id("app.cash.sqldelight").version("2.0.0-alpha05").apply(false)
}

tasks.register("clean", Delete::class) {
  delete(rootProject.buildDir)
}
