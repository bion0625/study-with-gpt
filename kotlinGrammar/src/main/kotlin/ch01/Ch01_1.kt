package ch01// sample & homework

fun main() {
    val name = "Kotlin"
    var age = 10

    println("이름: $name")
    println("나이: $age")

    age += 1
    println("내년 나이: $age")

    age += 4
    println("5년 후 나이: $age, 10년 후엔 ${age + 5}세가 됩니다")
}