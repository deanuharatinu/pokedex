package com.deanuharatinu.pokedex.android

import android.app.Application
import android.content.Context
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.memory.MemoryCache
import coil.request.CachePolicy
import com.deanuharatinu.pokedex.initKoin
import com.deanuharatinu.pokedex.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

class PokedexApp : Application(), ImageLoaderFactory {
  override fun onCreate() {
    super.onCreate()

    initKoin(
      appModule = module {
        single<Context> { this@PokedexApp }
      },
      viewModelsModule = module {
        viewModel {
          HomeViewModel(get())
        }
      }
    )
  }

  override fun newImageLoader(): ImageLoader {
    return ImageLoader.Builder(this)
      .memoryCache {
        MemoryCache.Builder(this)
          .maxSizePercent(0.25)
          .build()
      }
      .memoryCachePolicy(CachePolicy.ENABLED)
      .build()
  }
}