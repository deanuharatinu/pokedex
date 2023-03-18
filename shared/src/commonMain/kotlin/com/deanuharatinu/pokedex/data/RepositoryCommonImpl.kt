package com.deanuharatinu.pokedex.data

import PAGING_SIZE
import com.deanuharatinu.pokedex.data.remote.RemoteDataSource
import com.deanuharatinu.pokedex.domain.PokemonDetail
import com.deanuharatinu.pokedex.domain.asDomain
import com.deanuharatinu.pokedex.util.CommonFlow
import com.deanuharatinu.pokedex.util.asCommonFlow
import com.kuuurt.paging.multiplatform.Pager
import com.kuuurt.paging.multiplatform.PagingConfig
import com.kuuurt.paging.multiplatform.PagingData
import com.kuuurt.paging.multiplatform.PagingResult
import com.kuuurt.paging.multiplatform.helpers.cachedIn
import kotlinx.coroutines.MainScope

class RepositoryCommonImpl(
  private val remoteDataSource: RemoteDataSource,
) : RepositoryCommon {
  private val scope = MainScope()
  private val pagingConfig = PagingConfig(pageSize = PAGING_SIZE, enablePlaceholders = false)

  val pokemonPager = Pager(
    clientScope = scope,
    config = pagingConfig,
    initialKey = 1,
    getItems = { currentKey, _ ->
      val pokemonResponse = remoteDataSource.fetchPokemonList(currentKey).getOrNull()
      val pokemonAsDomain = pokemonResponse?.results?.map { it.asDomain() }.orEmpty()

      PagingResult(
        items = pokemonAsDomain,
        currentKey = currentKey,
        prevKey = { null },
        nextKey = { currentKey + 1 }
      )
    }
  )

  override val fetchPokemonList: CommonFlow<PagingData<PokemonDetail>>
    get() = pokemonPager.pagingData
      .cachedIn(scope)
      .asCommonFlow()
}