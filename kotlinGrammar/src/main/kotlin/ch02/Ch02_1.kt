package ch02

// sample

fun operateOnList(list: List<Int>, operation: (Int) -> Int): List<Int> {
    return list.map(operation)
}

//fun main() {
//    val nums = listOf(1, 2, 3, 4)
//
//    val doubled = operateOnList(nums) { it * 2 }
//    println("2배된 리스트: $doubled")
//
//    val square: (Int) -> Int = {n -> n* n}
//    println("제곱 리스트: ${operateOnList(nums, square)}")
//}


// homework

fun applyToEach(list: List<String>, operation: (String) -> String): List<String> {
    return list.map(operation)
}

fun main() {
    val names = listOf("Kotlin", "Java", "Groovy")
    val result = applyToEach(names) {it.uppercase()}
        .filter { it.length > 5 }
    println("반환 결과: $result")
}