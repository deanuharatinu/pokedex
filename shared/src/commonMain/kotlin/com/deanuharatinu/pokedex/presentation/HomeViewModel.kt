package com.deanuharatinu.pokedex.presentation

import com.deanuharatinu.pokedex.data.RepositoryCommon

class HomeViewModel(
  repository: RepositoryCommon
) : BaseViewModel() {
  val pokemonList = repository.getPokemonList
}
