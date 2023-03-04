package com.deanuharatinu.pokedex.android

import android.app.Application
import com.deanuharatinu.pokedex.initKoin
import com.deanuharatinu.pokedex.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class PokedexApp : Application() {
  override fun onCreate() {
    super.onCreate()

    initKoin(
      viewModelsModule = module {
        viewModel {
          HomeViewModel(get())
        }
      }
    )
  }
}