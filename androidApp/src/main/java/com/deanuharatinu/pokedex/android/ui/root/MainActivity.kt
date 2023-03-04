package com.deanuharatinu.pokedex.android.ui.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.deanuharatinu.pokedex.android.ui.theme.AppTheme
import com.deanuharatinu.pokedex.presentation.HomeViewModel
import org.koin.androidx.compose.getViewModel

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AppTheme {
        Surface(
          modifier = Modifier.fillMaxSize(),
          color = MaterialTheme.colors.background
        ) {
          GreetingView(text = "halo")
        }
      }
    }
  }
}

@Composable
fun GreetingView(
  viewModel: HomeViewModel = getViewModel(),
  text: String,
) {
  viewModel.getPokemonList(0)
  Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
  AppTheme {
    GreetingView(text = "halo")
  }
}
