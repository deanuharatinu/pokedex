package com.deanuharatinu.pokedex.data.local

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.deanuharatinu.pokedex.Database
import com.deanuharatinu.pokedex.domain.PokemonDetail
import kotlin.coroutines.CoroutineContext

class LocalDataSourceImpl(
  private val database: Database,
  private val coroutineContext: CoroutineContext,
) : LocalDataSource {
  override fun insertPokemon(pokemonDetail: List<PokemonDetail>) {
    database.pokedexDbQueries.transaction {
      pokemonDetail.forEach {
        database.pokedexDbQueries
          .insertPokemon(it.name, it.imageUrl)
      }
    }
  }

  override fun getAllPokemon(): List<PokemonDetail> =
    database.pokedexDbQueries
      .selectAll(mapper = { _, name, imageUrl ->
        PokemonDetail(name, imageUrl)
      })
      .executeAsList()
}