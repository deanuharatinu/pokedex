package com.deanuharatinu.pokedex.data

import com.deanuharatinu.pokedex.data.model.PokemonListResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import kotlin.native.concurrent.ThreadLocal

const val POKEDEX_BASE_URL = "https://pokeapi.co/api/v2/"
const val POKEMON = "pokemon/"
const val PARAM = "?"
const val SEPARATOR = "&"
const val OFFSET = "offset"
const val LIMIT = "limit"
const val PAGING_SIZE = 10

@ThreadLocal
object PokedexAPI {
  private val nonStrictJson = Json {
    isLenient = true
    ignoreUnknownKeys = true
  }

  private val client: HttpClient = HttpClient {
    install(ContentNegotiation) {
      json(nonStrictJson)
    }
    install(Logging) {
      logger = HttpClientLogger
    }
  }

  suspend fun fetchPokemonList(
    page: Int
  ): PokemonListResponse = client.get(POKEDEX_BASE_URL + POKEMON + page.toFetchPokemonUrl()).body()

  private fun Int.toFetchPokemonUrl(): String {
    val limit = PAGING_SIZE.toString()
    val offset = (PAGING_SIZE * this).toString()
    return "$PARAM$OFFSET=$offset$SEPARATOR$LIMIT=$limit"
  }
}