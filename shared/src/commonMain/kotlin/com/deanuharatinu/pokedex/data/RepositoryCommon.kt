package com.deanuharatinu.pokedex.data

import com.deanuharatinu.pokedex.data.remote.PokedexAPI
import com.deanuharatinu.pokedex.domain.PokemonDetail
import com.deanuharatinu.pokedex.domain.asDomain

class RepositoryCommon(
  private val remote: PokedexAPI,
) {
  suspend fun fetchPokemonList(
    page: Int,
    onSuccess: (List<PokemonDetail>) -> Unit,
    onError: () -> Unit
  ) {
    remote.fetchPokemonList(
      page,
      onSuccess = {
        onSuccess(it.results.map { fromApi -> fromApi.asDomain() })
      },
      onError = { onError.invoke() }
    )
  }
}