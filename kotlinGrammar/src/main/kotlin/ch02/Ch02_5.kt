package ch02


// (singleton) object
object Logger {
    fun log(msg: String) = println("LOG: $msg")
}

//fun main() {
//    Logger.log("앱 시작됨")
//}


// companion object
class CustomUser(val name: String) {
    companion object {
        fun createGuest(): CustomUser = CustomUser("Guest")
    }
}

//fun main() {
//    val guest = CustomUser.createGuest()
//    println(guest.name)
//}


// object: interface
interface Clickable {
    fun onClick()
}

val handler = object: Clickable {
    override fun onClick() {
        println("클릭됨!")
    }
}



// homework

// 1
object Counter {
    var count: Int = 0
    fun increment() { count++ }
    fun print() { println("count: $count") }
}

// 2
class MyMath {
    companion object {
        fun square(n: Int) = n * n
    }
}

// 3
fun main() {
    Counter.increment()
    Counter.increment()
    Counter.increment()
    Counter.print()

    println("3의 제곱은 ${MyMath.square(3)}이다")
}