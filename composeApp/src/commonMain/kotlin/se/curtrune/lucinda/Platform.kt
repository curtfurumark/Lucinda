package se.curtrune.lucinda

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform