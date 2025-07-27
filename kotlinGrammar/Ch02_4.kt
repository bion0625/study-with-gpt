

// sample

data class MyUser(val name: String, val age: Int)

//fun main() {
//    val user = MyUser("Alice", 25)
//
//    val (userName, userAge) = user
//    println("이름: $userName, 나이: $userAge")
//
//    val updated = user.copy(age = 30)
//    println("수정된 사용자: $updated")
//}


// homework

data class Product(val name: String, val price: Int)

fun main() {
    val product = Product("Keyboard", 35000)

    val (pName, pPrice) = product

    val disProduct = product.copy(price = (pPrice * 8) / 10)

    println("상품명: $pName, 가격: $pPrice")
    println("할인 상품: $disProduct")
}