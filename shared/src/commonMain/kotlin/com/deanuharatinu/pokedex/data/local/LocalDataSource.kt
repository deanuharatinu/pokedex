package com.deanuharatinu.pokedex.data.local

import com.deanuharatinu.pokedex.domain.PokemonDetail

interface LocalDataSource {
  fun insertPokemon(pokemonDetail: List<PokemonDetail>)
  fun getAllPokemon(): List<PokemonDetail>
}
