package com.deanuharatinu.pokedex.domain

data class HomeViewState(
  val pokemonList: List<PokemonDetail>?,
  val error: Throwable?,
) {
  val isLoading: Boolean
    get() = pokemonList == null && error == null

  companion object {
    val empty = HomeViewState(null, null)
  }
}