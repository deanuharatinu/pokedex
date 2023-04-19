package com.deanuharatinu.pokedex

import com.deanuharatinu.pokedex.data.RepositoryCommon
import com.deanuharatinu.pokedex.data.RepositoryCommonImpl
import com.deanuharatinu.pokedex.data.local.LocalDataSource
import com.deanuharatinu.pokedex.data.local.LocalDataSourceImpl
import com.deanuharatinu.pokedex.data.local.createDatabase
import com.deanuharatinu.pokedex.data.remote.ApiService
import com.deanuharatinu.pokedex.data.remote.RemoteDataSource
import com.deanuharatinu.pokedex.data.remote.RemoteDataSourceImpl
import com.deanuharatinu.pokedex.platform.ioDispatcher
import com.deanuharatinu.pokedex.platform.platformModule
import com.deanuharatinu.pokedex.presentation.HomeViewModel
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

object Modules {
  val core = module {
    single { ApiService }
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<LocalDataSource> { LocalDataSourceImpl(get(), get()) }
    single { createDatabase(get()) }
    factory { ioDispatcher }
  }
  val repositories = module {
    single<RepositoryCommon> { RepositoryCommonImpl(get(), get(), get()) }
  }
  val viewModels = module {
    factory { HomeViewModel(get()) }
  }
}

fun initKoinCommon(
  appModule: Module = module { },
  coreModule: Module = Modules.core,
  repositoriesModule: Module = Modules.repositories,
  viewModelsModule: Module = Modules.viewModels,
): KoinApplication = startKoin {
  modules(
    appModule,
    coreModule,
    repositoriesModule,
    viewModelsModule,
    platformModule,
  )
}