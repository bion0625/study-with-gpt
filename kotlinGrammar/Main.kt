
// kotlinc .\Main.kt -include-runtime -d main.jar

fun main() {
    println("Compiled Kotlin file")
    val now = java.time.LocalDateTime.now()
    println("지금 시간은: $now")
}