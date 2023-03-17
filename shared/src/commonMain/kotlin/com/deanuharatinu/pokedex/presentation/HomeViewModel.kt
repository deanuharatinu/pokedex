package com.deanuharatinu.pokedex.presentation

import com.deanuharatinu.pokedex.data.RepositoryCommon
import com.deanuharatinu.pokedex.domain.HomeViewState
import com.deanuharatinu.pokedex.platform.ioDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.launch

class HomeViewModel(
  private val repository: RepositoryCommon
) : BaseViewModel() {
  private val scope = CoroutineScope(ioDispatcher)

  var viewState = MutableStateFlow(HomeViewState.empty)

  init {
    getPokemonList(0)
  }

  private fun getPokemonList(page: Int) {
    scope.launch {
      val result = repository.fetchPokemonList(page).last()
      val resultState = HomeViewState(
        pokemonList = result.getOrNull(),
        error = result.exceptionOrNull()
      )
      viewState.value = resultState
    }
  }
}
