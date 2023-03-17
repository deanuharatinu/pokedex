package com.deanuharatinu.pokedex.android.ui.root

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.deanuharatinu.pokedex.android.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      AppTheme {
        AppScaffold()
      }
    }
  }
}

@Preview
@Composable
fun DefaultPreview() {
  AppTheme {
    AppScaffold()
  }
}
