package ch03

import kotlin.properties.Delegates


// interface by

interface Printer {
    fun print()
}

class PrinterImpl: Printer {
    override fun print() = println("프린터가 출력합니다")
}

class MyPrinter(printer: Printer) : Printer by printer


// property by

var name: String by Delegates.observable("<초기값>") { _, old, new ->
    println("값 변경함: $old -> $new")
}


// sample

interface MyLogger {
    fun log(msg: String)
}

class ConsoleLogger : MyLogger {
    override fun log(msg: String) = println("[LOG] $msg")
}

class Service(logger: MyLogger) : MyLogger by logger {
    fun doSomething() {
        log("서비스 실행 중")
    }
}

//fun main() {
//    val logger = ConsoleLogger()
//    val service = Service(logger)
//    service.doSomething()
//}



// homework

interface Speaker {
    fun say(message: String)
    val language: String
}

class KoreanSpeaker(val l: String): Speaker {
    override fun say(message: String) = println("안녕하세요: $message")
    override val language: String
        get() = l
}

class Announcer(private val speaker: Speaker): Speaker by speaker {
    fun doSomething() {
        say("인사해주세요 - $language")
    }
}

class EnglishSpeaker(val l: String): Speaker {
    override fun say(message: String) = println("hello: $message")
    override val language: String
        get() = l
}

fun main() {
    val speaker = KoreanSpeaker("korean")
    val announcer = Announcer(speaker)
    announcer.doSomething()

    val annoucer2 = Announcer(EnglishSpeaker("english"))
    annoucer2.doSomething()
}