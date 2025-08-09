import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    fun ticker(periodMs: Long): Flow<Int> = flow {
        var i = 0
        while (true) {
            emit(i++)
            delay(periodMs)
        }
    }

    ticker(200)
        .take(5)
        .map { it * it }
        .filter { it % 2 == 0 }
        .collect{ println("get $it at ${System.currentTimeMillis()%100000}") }

    delay(300)

    ticker(200)
        .take(5)
        .map { it * it }
        .filter { it % 2 == 0 }
        .collect{ println("get $it at ${System.currentTimeMillis()%100000}") }
}