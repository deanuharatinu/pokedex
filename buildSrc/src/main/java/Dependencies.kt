object Versions {
  const val koinCore = "3.3.0"
  const val koinAndroid = "3.3.0"
  const val coilCompose = "2.2.2"
  const val pagingCompose = "1.0.0-alpha16"
  const val multiplatformPaging = "0.6.2"
}

object AndroidSdk {
  const val min = 24
  const val compile = 33
  const val target = compile
}

object Deps {
  const val multiplatformPaging =
    "io.github.kuuuurt:multiplatform-paging:${Versions.multiplatformPaging}"
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

