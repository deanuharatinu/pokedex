package com.deanuharatinu.pokedex

import com.deanuharatinu.pokedex.data.RepositoryCommon
import com.deanuharatinu.pokedex.data.remote.PokedexAPI
import com.deanuharatinu.pokedex.presentation.HomeViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
  val core = module {
    factory { PokedexAPI }
  }
  val repositories = module {
    factory { RepositoryCommon(get()) }
  }
  val viewModels = module {
    factory { HomeViewModel(get()) }
  }
}

fun initKoin(
  coreModule: Module = Modules.core,
  repositoriesModule: Module = Modules.repositories,
  viewModelsModule: Module = Modules.viewModels,
): KoinApplication = startKoin {
  modules(
    coreModule,
    repositoriesModule,
    viewModelsModule,
  )
}