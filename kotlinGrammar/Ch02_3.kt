


// sample

data class User(var name: String, var age: Int)

//fun main() {
//    val user = User("Alice", 20)
//
//    val updatedUser = user.apply {
//        age += 1
//        name = name.uppercase()
//    }
//
//    val greeting = updatedUser.let {
//        "Hello, ${it.name} (${it.age})"
//    }
//
//    println(greeting)
//
//    updatedUser.also {
//        println("최종 사용자 정보: $it")
//    }
//}



// homework

data class Person(var name: String, var age: Int)

fun main() {
    val user = Person("Alice", 22)

    user.also {
        println("수정 전: $it")
    }

    val newUser = user.apply {
        name = name.uppercase()
        age += 5
    }

    newUser.also {
        println("수정 후: $it")
    }

    val say = newUser.let {
        "${it.name}님은 ${it.age}세입니다"
    }

    println(say)
}