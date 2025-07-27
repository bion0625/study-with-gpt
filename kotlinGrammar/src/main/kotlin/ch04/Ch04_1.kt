package src.main.kotlin



// sample

import kotlinx.coroutines.*

//fun main() = runBlocking {
//    launch {
//        delay(1000)
//        println("코루틴 완료")
//    }
//
//    val result: Deferred<Int> = async {
//        delay(500)
//        println("Async 코루틴 완료")
//        42
//    }
//
//    println("결과: ${result.await()}")
//}


// homework

fun main() = runBlocking {
    println("시작")
    launch {
        delay(1000)
        println("작업 A 완료")
    }
    launch {
        delay(500)
        println("작업 B 완료")
    }
    println("끝")
}