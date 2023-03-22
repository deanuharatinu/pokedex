package com.deanuharatinu.pokedex.data.local

import app.cash.sqldelight.db.SqlDriver
import com.deanuharatinu.pokedex.Database

fun createDatabase(sqlDriver: SqlDriver): Database {
  return Database(sqlDriver)
}
