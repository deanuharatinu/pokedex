package com.deanuharatinu.pokedex.platform

internal expect class PlatformLogger() {
  fun debug(tag: String, message: String)
}

object Logger {
  private val logger = PlatformLogger()

  fun d(tag: String, message: String) {
    logger.debug(tag, message)
  }
}