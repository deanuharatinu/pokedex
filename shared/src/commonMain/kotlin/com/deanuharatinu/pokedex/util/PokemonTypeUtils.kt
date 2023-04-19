package com.deanuharatinu.pokedex.util

import com.deanuharatinu.pokedex.util.CommonColor.bug
import com.deanuharatinu.pokedex.util.CommonColor.dark
import com.deanuharatinu.pokedex.util.CommonColor.dragon
import com.deanuharatinu.pokedex.util.CommonColor.electric
import com.deanuharatinu.pokedex.util.CommonColor.fairy
import com.deanuharatinu.pokedex.util.CommonColor.fighting
import com.deanuharatinu.pokedex.util.CommonColor.fire
import com.deanuharatinu.pokedex.util.CommonColor.flying
import com.deanuharatinu.pokedex.util.CommonColor.ghost
import com.deanuharatinu.pokedex.util.CommonColor.grass
import com.deanuharatinu.pokedex.util.CommonColor.gray_21
import com.deanuharatinu.pokedex.util.CommonColor.ground
import com.deanuharatinu.pokedex.util.CommonColor.ice
import com.deanuharatinu.pokedex.util.CommonColor.poison
import com.deanuharatinu.pokedex.util.CommonColor.psychic
import com.deanuharatinu.pokedex.util.CommonColor.rock
import com.deanuharatinu.pokedex.util.CommonColor.steel
import com.deanuharatinu.pokedex.util.CommonColor.water

object PokemonTypeUtils {
  fun getTypeColor(type: String): Long {
    return when(type) {
      "fighting" -> fighting
      "flying" -> flying
      "poison" -> poison
      "ground" -> ground
      "rock" -> rock
      "bug" -> bug
      "ghost" -> ghost
      "steel" -> steel
      "fire" -> fire
      "water" -> water
      "grass" -> grass
      "electric" -> electric
      "psychic" -> psychic
      "ice" -> ice
      "dragon" -> dragon
      "fairy" -> fairy
      "dark" -> dark
      else -> gray_21
    }
  }
}
