package ch01


// sample
//fun main() {
//    val name: String? = "Kotlin"
//
//    println(name?.length)
//    println(name ?: "Unknown")
//    println(name?.uppercase())
//    println(name!!.length)
//
//    name?.let {
//        println("이름 길이: ${it.length}")
//    }
//}


// homework
fun main() {
    val nickname: String? = null
    println("대문자 닉네임: ${nickname?.uppercase() ?: "Guest"}")
    nickname?.let {
        println(it)
    }
    nickname!!
}
