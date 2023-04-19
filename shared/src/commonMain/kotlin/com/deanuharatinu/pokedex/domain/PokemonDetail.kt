package com.deanuharatinu.pokedex.domain

import com.deanuharatinu.pokedex.data.model.PokemonNameResponse
import com.deanuharatinu.pokedex.util.CommonColor
import com.deanuharatinu.pokedex.util.getImageUrl

data class PokemonDetail(
  val name: String,
  val imageUrl: String,
  var color: String? = null,
)

fun PokemonNameResponse.asDomain(): PokemonDetail {
  return PokemonDetail(
    name = this.name,
    imageUrl = this.url.getImageUrl(),
  )
}