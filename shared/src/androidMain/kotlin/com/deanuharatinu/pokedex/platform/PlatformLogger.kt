package com.deanuharatinu.pokedex.platform

import android.util.Log

internal actual class PlatformLogger {
  actual fun debug(tag: String, message: String) {
    Log.d(tag, message)
  }
}