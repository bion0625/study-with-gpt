

// sample

sealed class NetworkResult

data class Success(val data: String) : NetworkResult()
data class Error(val code: Int, val message: String) : NetworkResult()
object Loading: NetworkResult()

fun handler(result: NetworkResult): String = when(result) {
    is Success -> "데이터 수신: ${result.data}"
    is Error -> "에러 발생(${result.code}): ${result.message}"
    Loading -> "로딩 중..."
}


// homework

sealed class Animal

data class Lion(val name: String): Animal()
data class Elephant(val weight: Int): Animal()
data class Penguin(val canSwim: Boolean): Animal()

fun describe(animal: Animal): String = when(animal) {
    is Lion -> "this lion's name is ${animal.name}"
    is Elephant -> "this elephant's weight is ${animal.weight}"
    is Penguin -> "this penguin can swim: ${animal.canSwim}"
}


// optional homework

fun main() {
    val animals = listOf(
        Lion("Simba"),
        Elephant(1000),
        Penguin(true)
    )

    animals.forEach { println(describe(it)) }
}