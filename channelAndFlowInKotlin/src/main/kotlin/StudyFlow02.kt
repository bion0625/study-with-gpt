import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*


fun main(): Unit = runBlocking {
    val base = flow {
        repeat(6) { i ->
            println("emit $i at ${System.currentTimeMillis() % 100000}")
            emit(i)
            delay(100)
        }
    }

//    base
//        .buffer(64)// 0, 1, 64
//        .onEach { delay(250) }
//        .collect { println("collect $it at ${System.currentTimeMillis() % 100000}") }

    /**
     * 0
     * emit 0 at 75243
     * emit 1 at 75388
     * collect 0 at 75541
     * emit 2 at 75647
     * collect 1 at 75799
     * emit 3 at 75905
     * collect 2 at 76058
     * emit 4 at 76164
     * collect 3 at 76317
     * emit 5 at 76424
     * collect 4 at 76576
     * collect 5 at 76833
     *
     * 1
     * emit 0 at 91654
     * emit 1 at 91794
     * emit 2 at 91899
     * collect 0 at 91946
     * emit 3 at 92051
     * collect 1 at 92202
     * emit 4 at 92310
     * collect 2 at 92460
     * emit 5 at 92567
     * collect 3 at 92718
     * collect 4 at 92976
     * collect 5 at 93231
     *
     * 64
     * emit 0 at 10064
     * emit 1 at 10209
     * emit 2 at 10315
     * collect 0 at 10360
     * emit 3 at 10420
     * emit 4 at 10526
     * collect 1 at 10617
     * emit 5 at 10632
     * collect 2 at 10876
     * collect 3 at 11134
     * collect 4 at 11391
     * collect 5 at 11649
     * */

//    base
//        .conflate()
//        .onEach { delay(250) }
//        .collect { println("collect $it at ${System.currentTimeMillis() % 100000}") }

    /**
     * emit 0 at 49143
     * emit 1 at 49285
     * emit 2 at 49390
     * collect 0 at 49437
     * emit 3 at 49496
     * emit 4 at 49602
     * collect 2 at 49692
     * emit 5 at 49707
     * collect 4 at 49949
     * collect 5 at 50206
     * */

    base
        .collectLatest { value ->
            println("start $value at ${System.currentTimeMillis() % 100000}")
            delay(250)
            println("done $value at ${System.currentTimeMillis() % 100000}")
        }

    /**
     * emit 0 at 61289
     * start 0 at 61317
     * emit 1 at 61425
     * start 1 at 61430
     * emit 2 at 61530
     * start 2 at 61532
     * emit 3 at 61638
     * start 3 at 61638
     * emit 4 at 61744
     * start 4 at 61744
     * emit 5 at 61850
     * start 5 at 61850
     * done 5 at 62108
     * */
}