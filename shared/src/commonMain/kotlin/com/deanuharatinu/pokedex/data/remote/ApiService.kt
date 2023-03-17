package com.deanuharatinu.pokedex.data.remote

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
object ApiService {
  private val nonStrictJson = Json {
    isLenient = true
    ignoreUnknownKeys = true
  }

  val client: HttpClient = HttpClient {
    install(ContentNegotiation) {
      json(nonStrictJson)
    }
    install(Logging) {
      logger = HttpClientLogger
    }
  }
}