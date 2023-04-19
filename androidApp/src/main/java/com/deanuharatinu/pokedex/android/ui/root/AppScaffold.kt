package com.deanuharatinu.pokedex.android.ui.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.deanuharatinu.pokedex.android.R
import com.deanuharatinu.pokedex.android.ui.theme.AppTheme
import kotlinx.coroutines.launch

@Composable
fun AppScaffold() {
  val navController = rememberNavController()
  val scaffoldState = rememberScaffoldState()
  val scope = rememberCoroutineScope()

  Scaffold(
    scaffoldState = scaffoldState,
    snackbarHost = {
      SnackbarHost(hostState = it) {
        Snackbar(
          snackbarData = it,
          backgroundColor = MaterialTheme.colors.primary,
        )
      }
    },
    topBar = { AppBar(title = stringResource(id = R.string.appbar_app_title)) },
  ) {
    AppNavHost(
      navController = navController,
      modifier = Modifier
        .fillMaxSize()
        .padding(it),
      showSnackBar = {
        scope.launch {
          scaffoldState.snackbarHostState.showSnackbar(it)
        }
      }
    )
  }
}

@Composable
@Preview(device = Devices.PIXEL_4)
fun AppScaffoldPreview() {
  AppTheme {
    AppScaffold()
  }
}

@Composable
fun AppBar(
  modifier: Modifier = Modifier,
  title: String,
) {
  TopAppBar(
    title = { Text(text = title) },
    backgroundColor = MaterialTheme.colors.primary,
    modifier = modifier,
  )
}

@Composable
@Preview
fun AppBarPreview() {
  AppTheme {
    AppBar(title = stringResource(id = R.string.appbar_app_title))
  }
}