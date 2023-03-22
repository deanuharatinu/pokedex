object Versions {
  const val koinCore = "3.3.0"
  const val koinAndroid = "3.3.0"
  const val coilCompose = "2.2.2"
  const val pagingCompose = "1.0.0-alpha16"
  const val multiplatformPaging = "0.6.2"
  const val atomicFu = "0.18.5"
  const val store5 = "5.0.0-alpha05"
  const val ktor = "2.2.4"
  const val sqlDelight = "2.0.0-alpha05"
}

object AndroidSdk {
  const val min = 24
  const val compile = 33
  const val target = compile
}

object Deps {
  const val multiplatformPaging =
    "io.github.kuuuurt:multiplatform-paging:${Versions.multiplatformPaging}"
  const val store5 = "org.mobilenativefoundation.store:store5:${Versions.store5}"
  const val atomicFu = "org.jetbrains.kotlinx:atomicfu:${Versions.atomicFu}"
}

object Compose {
  const val coilCompose = "io.coil-kt:coil-compose:${Versions.coilCompose}"
  const val paging = "androidx.paging:paging-compose:${Versions.pagingCompose}"
}

object Koin {
  val core = "io.insert-koin:koin-core:${Versions.koinCore}"
  val test = "io.insert-koin:koin-test:${Versions.koinCore}"
  val android = "io.insert-koin:koin-android:${Versions.koinAndroid}"
  val compose = "io.insert-koin:koin-androidx-compose:${Versions.koinCore}"
}

object Ktor {
  val clientCore = "io.ktor:ktor-client-core:${Versions.ktor}"
  val clientSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
  val clientLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
  val clientIos = "io.ktor:ktor-client-ios:${Versions.ktor}"
  val clientAndroid = "io.ktor:ktor-client-android:${Versions.ktor}"
  val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
  val ktorJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
}

object SqlDelight {
  const val android = "app.cash.sqldelight:android-driver:${Versions.sqlDelight}"
  const val ios = "app.cash.sqldelight:native-driver:${Versions.sqlDelight}"
  const val coroutineExt = "app.cash.sqldelight:coroutines-extensions:${Versions.sqlDelight}"
}
