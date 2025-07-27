package src.main.kotlin

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


// sample

suspend fun downloadA(): Int {
    delay(1000)
    println("A 완료")
    return 1
}

suspend fun downloadB(): Int {
    delay(500)
    println("B 완료")
    return 2
}

//fun main() = runBlocking {
//    val start = System.currentTimeMillis()
//
//    val resultA = async { downloadA() }
//    val resultB = async { downloadB() }
//
//    val total = resultA.await() + resultB.await()
//
//    val end = System.currentTimeMillis()
//    println("총합: $total, 시간: ${end - start}ms")
//}


// homework

suspend fun fetchUserName(): String {
    delay(1000)
    return "홍길동"
}

suspend fun fetchUserAge(): Int {
    delay(500)
    return 30
}

fun main() = runBlocking {
    val start = System.currentTimeMillis()

    val resultName = async { fetchUserName() }
    val resultAge = async { fetchUserAge() }

    val name = resultName.await()
    val age = resultAge.await()

    val end = System.currentTimeMillis()

    println("사용자: $name (${age}세), 시간: ${end - start}ms")
}