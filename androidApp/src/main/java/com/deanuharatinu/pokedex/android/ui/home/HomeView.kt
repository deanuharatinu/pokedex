package com.deanuharatinu.pokedex.android.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import com.deanuharatinu.pokedex.android.ui.theme.AppTheme
import com.deanuharatinu.pokedex.domain.PokemonDetail
import com.deanuharatinu.pokedex.presentation.HomeViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeView(
  viewModel: HomeViewModel = getViewModel(),
) {
  val pokemonList = viewModel.viewState.collectAsState()

  Box {
    HomeContent(pokemonList = pokemonList.value.pokemonList.orEmpty())
  }

}

@Composable
fun HomeContent(
  pokemonList: List<PokemonDetail>,
) {
  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
  ) {
    items(
      items = pokemonList,
      key = { it.name }
    ) { item ->
      PokemonItem(
        pokemonDetail = item
      )
    }
  }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomeContentPreview() {
  AppTheme {
    HomeContent(
      pokemonList = listOf(
        PokemonDetail(
          "bulbasaur",
          "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
        ),
        PokemonDetail(
          "charmender",
          "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
        ),
        PokemonDetail(
          "pokebro",
          "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png"
        )
      )
    )
  }
}