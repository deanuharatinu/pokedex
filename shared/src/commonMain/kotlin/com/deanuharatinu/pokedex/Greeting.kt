package com.deanuharatinu.pokedex

import com.deanuharatinu.pokedex.data.PokedexAPI
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class Greeting {
  private val platform: Platform = getPlatform()

  fun greet(): String {
    MainScope().launch {
      PokedexAPI.fetchPokemonList(0)
    }
    return "Hello, ${platform.name}!"
  }
}