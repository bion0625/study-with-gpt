import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val channel = Channel<Int>(capacity = 2)

    launch {
        (1..5).forEach{
            println("send $it at ${System.currentTimeMillis()%100000}")
            channel.send(it)
        }
        channel.close()
    }

    launch {
//        while (true) {
//            val result = channel.receiveCatching()
//            if (result.isClosed) break
//            val c = result.getOrNull()!!
//            delay(300)
//            println("recv $c at ${System.currentTimeMillis()%100000}")
//        }
        for (c in channel) {
            delay(300)
            println("recv $c at ${System.currentTimeMillis()%100000}")
        }
        println("consumer done")
    }
}