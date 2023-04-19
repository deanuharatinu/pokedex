package com.deanuharatinu.pokedex.data

import PAGING_SIZE
import com.deanuharatinu.pokedex.data.local.LocalDataSource
import com.deanuharatinu.pokedex.data.model.PokemonNameResponse
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
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.MainScope
import org.mobilenativefoundation.store.store5.Fetcher
import org.mobilenativefoundation.store.store5.StoreBuilder
import org.mobilenativefoundation.store.store5.impl.extensions.get
import kotlin.coroutines.CoroutineContext

@OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
class RepositoryCommonImpl(
  private val remoteDataSource: RemoteDataSource,
  private val localDataSource: LocalDataSource,
  private val scope: CoroutineContext,
) : RepositoryCommon {
  val newScope = MainScope()
  private val pagingConfig = PagingConfig(pageSize = PAGING_SIZE, enablePlaceholders = false)

  private val store = StoreBuilder
    .from<Int, List<PokemonNameResponse>, List<PokemonNameResponse>>(
      fetcher = Fetcher.of { page: Int ->
        remoteDataSource.fetchPokemonListFlow(page).results
      }
    )
    .build()

  val pokemonPager = Pager(
    clientScope = newScope,
    config = pagingConfig,
    initialKey = 0,
    getItems = { currentKey, _ ->
      val pokemonDetail = store.get(currentKey).map { it.asDomain() }

      PagingResult(
        items = pokemonDetail,
        currentKey = currentKey,
        prevKey = { null },
        nextKey = { currentKey + 1 }
      )
    }
  )

  override val getPokemonList: CommonFlow<PagingData<PokemonDetail>>
    get() = pokemonPager.pagingData
      .cachedIn(newScope)
      .asCommonFlow()
}
