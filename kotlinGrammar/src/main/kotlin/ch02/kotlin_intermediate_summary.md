# ⚙️ Kotlin 중급 문법 정리

---

## ✅ 6. 람다와 고차 함수 심화

### 핵심
- 람다: `{ x -> x * 2 }`
- 고차 함수: 함수를 인자로 받거나 반환
- 함수 타입: `(Int) -> Int`

### 예시
```kotlin
fun operate(list: List<Int>, fn: (Int) -> Int): List<Int> {
    return list.map(fn)
}
val result = operate(listOf(1,2,3)) { it * 2 }
```

---

## ✅ 7. 확장 함수 & 확장 프로퍼티

### 핵심
- `fun String.addMark() = this + "!"`
- `val String.lastChar: Char get() = this.last()`

### 예시
```kotlin
fun String.truncate(n: Int): String =
    if (length > n) substring(0, n) + "..." else this

val List<String>.joinWithComma: String
    get() = joinToString(",")
```

---

## ✅ 8. Scope 함수 (`let`, `apply`, `run`, `also`, `with`)

| 함수 | this/it | 반환값 | 목적 |
|------|---------|--------|------|
| let | it | 람다 결과 | null-safe 가공 |
| apply | this | 객체 자체 | 초기화 |
| run | this | 람다 결과 | 계산 후 반환 |
| also | it | 객체 자체 | 디버깅/로깅 |
| with | this | 람다 결과 | 외부 객체 가공 |

### 예시
```kotlin
val user = User("Alice", 22).apply {
    name = name.uppercase()
    age += 5
}.also {
    println("수정 후: $it")
}
```

---

## ✅ 9. 데이터 클래스 & 구조 분해

### 핵심
- `data class`는 equals, hashCode, toString, copy, componentN 자동 생성
- 구조 분해: `val (name, age) = user`

### 예시
```kotlin
data class Product(val name: String, val price: Int)
val (n, p) = Product("Keyboard", 35000)
val discounted = Product(n, (p * 8) / 10)
```

---

## ✅ 10. object / companion object / singleton

### 핵심
- `object`: 싱글톤
- `companion object`: 클래스 내 정적 멤버
- `object : 인터페이스`: 익명 객체 구현

### 예시
```kotlin
object Counter {
    var count = 0
    fun increment() { count++ }
}

class MyMath {
    companion object {
        fun square(n: Int) = n * n
    }
}

Counter.increment()
println(MyMath.square(3))
```