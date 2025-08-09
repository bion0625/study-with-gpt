import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(): Unit = runBlocking {
    val channel = Channel<String>()

    launch {
        "메시지 1,메시지 2,메시지 3,끝".split(",").forEach {
            channel.send(it)
        }
        channel.close()
    }

    launch {
        for (c in channel) {
            if (c == "끝") {
                println("수신 종료")
                break
            }

            println("this message is $c")
        }
    }
}