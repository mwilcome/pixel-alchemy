package com.mikewilcome.pixelalchemy

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform