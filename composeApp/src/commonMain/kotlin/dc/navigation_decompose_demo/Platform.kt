package dc.navigation_decompose_demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform