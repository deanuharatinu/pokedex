package com.deanuharatinu.pokedex.platform

import platform.Foundation.NSLog

internal actual class PlatformLogger {
  actual fun debug(tag: String, message: String) {
    NSLog("$tag | $message")
  }
}