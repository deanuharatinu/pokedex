package com.deanuharatinu.pokedex.data.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonListResponse(
  val count: Int,
  val results: List<PokemonNameResponse>,
)

@Serializable
data class PokemonNameResponse(
  val name: String,
  val url: String,
)
