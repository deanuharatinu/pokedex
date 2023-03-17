package com.deanuharatinu.pokedex.util


fun String.getImageUrl(): String {
  val index = this.split("/".toRegex()).dropLast(1).last()
  return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$index.png"
}