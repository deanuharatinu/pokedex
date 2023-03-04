package com.deanuharatinu.pokedex.data.remote

import com.deanuharatinu.pokedex.platform.Logger

private const val TAG = "HttpClientLogger"

object HttpClientLogger : io.ktor.client.plugins.logging.Logger {
  override fun log(message: String) {
    Logger.d(TAG, message)
  }
}