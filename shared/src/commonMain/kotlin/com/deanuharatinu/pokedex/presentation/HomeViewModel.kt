package com.deanuharatinu.pokedex.presentation

import com.deanuharatinu.pokedex.data.RepositoryCommon
import com.deanuharatinu.pokedex.platform.ioDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class HomeViewModel(
  private val repository: RepositoryCommon
) : BaseViewModel() {
  private val scope = CoroutineScope(ioDispatcher)

  fun getPokemonList(page: Int) {
    scope.launch {
      repository.fetchPokemonList(
        page,
        onSuccess = {
          it.map { detail -> println(detail.name) }
        },
        onError = {}
      )
    }
  }
}