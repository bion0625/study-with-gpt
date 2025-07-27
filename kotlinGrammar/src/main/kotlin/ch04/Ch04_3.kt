package src.main.kotlin

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking


// sample

fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

//fun main() = runBlocking {
//    println("수집 시작")
//    simpleFlow().collect { value ->
//        println("값 수신: $value")
//    }
//}


// homework

fun workFlow(): Flow<String> = flow {
    for (i in 1..5) {
        delay(1000)
        emit("Tick $i")
    }
}

fun main() = runBlocking {
    println("수집 시작")
    workFlow().collect { println(it) }
}