package com.deanuharatinu.pokedex.android.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.deanuharatinu.pokedex.domain.PokemonDetail
import com.deanuharatinu.pokedex.presentation.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeView(
  viewModel: HomeViewModel = getViewModel(),
) {
  val lazyPokemonDetail = viewModel.pokemonList.collectAsLazyPagingItems()

  Box {
    HomeContent(pokemonList = lazyPokemonDetail)
  }

}

@Composable
fun HomeContent(
  pokemonList: LazyPagingItems<PokemonDetail>,
) {
  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
  ) {
    items(pokemonList) { pokemonDetail ->
      pokemonDetail?.let {
        PokemonItem(
          pokemonDetail = it
        )
      }
    }
  }
}