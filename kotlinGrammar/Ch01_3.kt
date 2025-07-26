

// if
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun min(a: Int, b: Int) = if (a < b) a else b


// when
fun describe(x: Any): String = when (x) {
    0 -> "정수 0"
    1, 2 -> "1 또는 2"
    in 3..10 -> "3부터 10 사이"
    is String -> "문자열: $x"
    else -> "알 수 없음"
}


// homework

fun judgeScore(score: Int): String = when(score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    in 70..79 -> "C"
    else -> "F"
}

fun myDescribe(obj: Any): String = when(obj) {
    is Int -> "숫자입니다"
    is String -> "문자열입니다"
    else -> "알 수 없는 타입입니다"
}

fun main() {
    println("98: ${judgeScore(98)}")
    println("87: ${judgeScore(87)}")
    println("70: ${judgeScore(70)}")
    println("33: ${judgeScore(33)}")

    println("Int 33: ${myDescribe(33)}")
    println("String TEXT: ${myDescribe("TEXT")}")
}