package com.deanuharatinu.pokedex.platform

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.deanuharatinu.pokedex.Database
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
  single<SqlDriver> {
    NativeSqliteDriver(Database.Schema, "PokedexDb")
  }
}