package com.deanuharatinu.pokedex.data.remote

import com.deanuharatinu.pokedex.data.model.PokemonListResponse

interface RemoteDataSource {
  suspend fun fetchPokemonList(page: Int): Result<PokemonListResponse>

   suspend fun fetchPokemonListFlow(page: Int): PokemonListResponse
}