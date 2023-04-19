package com.deanuharatinu.pokedex.android.ui.root

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.deanuharatinu.pokedex.android.ui.home.HomeView
import com.deanuharatinu.pokedex.presentation.Screen

@Composable
fun AppNavHost(
  navController: NavHostController,
  modifier: Modifier = Modifier,
  showSnackBar: (String) -> Unit,
) {
  NavHost(
    navController = navController,
    startDestination = Screen.Home.route,
    modifier = modifier,
  ) {
    composable(Screen.Home.route) {
      HomeView(showSnackBar = showSnackBar)
    }
  }
}
