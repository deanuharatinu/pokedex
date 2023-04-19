package com.deanuharatinu.pokedex.data.remote

import LIMIT
import OFFSET
import PAGING_SIZE
import POKEDEX_BASE_URL
import POKEMON
import com.deanuharatinu.pokedex.data.model.PokemonListResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

class RemoteDataSourceImpl(
  private val apiService: ApiService,
) : RemoteDataSource {
  override suspend fun fetchPokemonList(page: Int): Result<PokemonListResponse> {
    val response = apiService.client.get(urlString = "$POKEDEX_BASE_URL$POKEMON") {
      parameter(OFFSET, page * PAGING_SIZE)
      parameter(LIMIT, PAGING_SIZE)
    }

    return if (response.status.value in 200..209) {
      // Success
      Result.success(response.body())
    } else {
      // Failed
      // TODO: need to specify failure according to response status
      Result.failure(response.body())
    }
  }

  override suspend fun fetchPokemonListFlow(page: Int): PokemonListResponse {
    return apiService.client.get(urlString = "$POKEDEX_BASE_URL$POKEMON") {
      parameter(OFFSET, page * PAGING_SIZE)
      parameter(LIMIT, PAGING_SIZE)
    }.body()
  }

}