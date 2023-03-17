package com.deanuharatinu.pokedex.data

import com.deanuharatinu.pokedex.domain.PokemonDetail
import com.deanuharatinu.pokedex.util.CommonFlow

interface RepositoryCommon {
  suspend fun fetchPokemonList(page: Int): CommonFlow<Result<List<PokemonDetail>>>
}
