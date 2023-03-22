package com.deanuharatinu.pokedex.data

import com.deanuharatinu.pokedex.domain.PokemonDetail
import com.deanuharatinu.pokedex.util.CommonFlow
import com.kuuurt.paging.multiplatform.PagingData

interface RepositoryCommon {
  val getPokemonList: CommonFlow<PagingData<PokemonDetail>>
}
