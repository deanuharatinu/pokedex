package com.deanuharatinu.pokedex.data

import com.deanuharatinu.pokedex.data.remote.RemoteDataSource
import com.deanuharatinu.pokedex.domain.PokemonDetail
import com.deanuharatinu.pokedex.domain.asDomain
import com.deanuharatinu.pokedex.util.CommonFlow
import com.deanuharatinu.pokedex.util.asCommonFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class RepositoryCommonImpl(
  private val remoteDataSource: RemoteDataSource,
) : RepositoryCommon {
  override suspend fun fetchPokemonList(page: Int): CommonFlow<Result<List<PokemonDetail>>> {
    return flow {
      val response = remoteDataSource.fetchPokemonList(page)
      val pokemonList = response.results.map { it.asDomain() }
      val success = Result.success(pokemonList)
      emit(success)
    }.catch { e -> emit(Result.failure(e)) }.asCommonFlow()
  }
}