package com.deanuharatinu.pokedex.android.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.deanuharatinu.pokedex.android.ui.theme.AppTheme
import com.deanuharatinu.pokedex.android.ui.theme.Shapes
import com.deanuharatinu.pokedex.android.utils.ImageUtils.getDominantColor
import com.deanuharatinu.pokedex.domain.PokemonDetail
import com.deanuharatinu.pokedex.util.CommonColor
import java.util.Locale

@Composable
fun PokemonItem(
  pokemonDetail: PokemonDetail,
  modifier: Modifier = Modifier,
  showSnackBar: (String) -> Unit,
) {
  var cardColor by remember { mutableStateOf(Color(CommonColor.background800)) }
  pokemonDetail.color?.let {
    cardColor = Color(it.toULong())
  }

  Box(
    modifier = modifier
      .fillMaxWidth()
      .clickable { showSnackBar("click") },
  ) {
    Card(
      modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),
      backgroundColor = cardColor,
      shape = Shapes.medium
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
      ) {
        Text(
          text = pokemonDetail.name.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
          },
          textAlign = TextAlign.Center,
          style = MaterialTheme.typography.h5,
          color = Color.White,
          modifier = Modifier
            .wrapContentSize()
            .padding(16.dp, 6.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        AsyncImage(
          model = ImageRequest.Builder(LocalContext.current)
            .data(pokemonDetail.imageUrl)
            .crossfade(true)
            .memoryCacheKey(pokemonDetail.imageUrl)
            .build(),
          contentDescription = pokemonDetail.name,
          contentScale = ContentScale.Crop,
          onSuccess = {
            if (pokemonDetail.color.isNullOrBlank()) {
              getDominantColor(it.result.drawable) { color ->
                pokemonDetail.color = color.value.toString()
                cardColor = color
              }
            }
          },
          modifier = Modifier
            .height(90.dp)
            .width(150.dp),
        )
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun PokemonItemPreview() {
  AppTheme {
    PokemonItem(
      PokemonDetail(
        "bulbasaur",
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
        color = null,
      ),
      showSnackBar = {},
    )
  }
}