package com.stock

import kotlinx.coroutines.*

fun main() = runBlocking {
    println(" 시작: ${Thread.currentThread().name}")

    launch {
        delay(1000L)
        println("코루틴 1 완료: ${Thread.currentThread().name}")
    }

    val x = 3
    val y = 5

    val deferred = async {
        delay(500L)
        println("코루틴 2 완료: ${Thread.currentThread().name}")
        x + y
    }

    launch(Dispatchers.Default) {
        delay(130L)
        println("코루틴 3 완료: ${Thread.currentThread().name}")
    }

    println("메인 코루틴 진행 중, async value: ${deferred.await()}")
}