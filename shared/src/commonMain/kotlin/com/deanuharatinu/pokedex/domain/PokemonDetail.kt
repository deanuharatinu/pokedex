package com.deanuharatinu.pokedex.domain

import com.deanuharatinu.pokedex.data.model.PokemonNameResponse

data class PokemonDetail(
  val name: String,
)

fun PokemonNameResponse.asDomain(): PokemonDetail {
  return PokemonDetail(
    name = this.name,
  )
}