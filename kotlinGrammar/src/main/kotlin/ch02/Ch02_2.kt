package ch02

// expand function
fun String.addMark(): String = this + "!"

// expand property
val String.lastChar: Char
    get() = this.last()

//fun main() {
//    val word = "Hello"
//    println(word.addMark())
//    println(word.lastChar)
//}


// homework

fun String.truncate(maxLength: Int): String = if (this.length > maxLength) this.substring(0, maxLength) + "..." else this

val List<String>.joinWithComma: String get() = this.joinToString(",")

fun main() {
    println("KotlinIsAwesome".truncate(6))
    println(listOf("A","B","C").joinWithComma)
}