package ch01

// sample
//fun main() {
//    val numbers = listOf(1, 2, 3, 4, 5)
//
//    numbers.forEach { println("숫자: $it") }
//
//    val doubled = numbers.map { it * 2 }
//    println("2배 된 숫자들: $doubled")
//
//    val filtered = numbers.filter { it > 3 }
//    println("3보다 큰 수: $filtered")
//}

// homework
fun main() {
    val names = listOf("Kotlin", "Java", "Groovy", "Swift")
    val formatted = names
        .filter { it.length > 5 }
        .map { "언어: ${it.lowercase()}" }

    println("필터링 결과: $formatted")
}