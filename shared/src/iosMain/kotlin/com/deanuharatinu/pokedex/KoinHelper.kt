package com.deanuharatinu.pokedex

import com.deanuharatinu.pokedex.presentation.HomeViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

class KoinHelper : KoinComponent {
  val homeViewModel: HomeViewModel by inject()
//  fun getHomeViewModel(): HomeViewModel = homeViewModel
}

fun initKoin() {
  initKoinCommon()
}