package com.deanuharatinu.pokedex

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform