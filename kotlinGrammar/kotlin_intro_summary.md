# 📘 Kotlin 입문 정리 (Java 개발자 기준)

---

## ✅ 1. 변수 선언: `val`, `var`, 타입 추론

| Kotlin 예시 | 의미 | Java 대응 |
|-------------|------|-----------|
| `val name = "Kotlin"` | 불변 변수 (final) | `final String name = "Kotlin";` |
| `var age = 10`         | 가변 변수         | `int age = 10;` |
| 타입 추론              | `val x = 123`     | Java는 타입 명시 필요 |

```kotlin
val name = "Kotlin"
var age = 10
age += 1
```

---

## ✅ 2. 함수 선언과 표현식 스타일

| Kotlin 스타일 | 설명 |
|---------------|------|
| `fun sum(a: Int, b: Int) = a + b` | 표현식 스타일 (간결함) |
| `fun greet(name: String): String { return "Hi, $name" }` | 일반 함수 선언 |

```kotlin
fun greet(name: String) = "Hi, $name!"
```

---

## ✅ 3. 조건문: `if`, `when` 표현식

| 문법 | 설명 | Java 비교 |
|------|------|-----------|
| `if (...) ... else ...` | 표현식 반환 가능 | 삼항 연산자 대체 |
| `when(x) { ... }` | switch 대체 + 더 강력 | 타입/범위 조건 가능 |

```kotlin
fun judge(score: Int) = when(score) {
    in 90..100 -> "A"
    in 80..89 -> "B"
    else -> "F"
}
```

---

## ✅ 4. 널 안전성: `?`, `!!`, `?:`, `let`

| 문법 | 의미 | 예시 |
|------|------|------|
| `String?` | nullable 타입 | `val name: String? = null` |
| `?.` | null-safe 호출 | `name?.length` |
| `?:` | 기본값 설정 (엘비스 연산자) | `name ?: "Unknown"` |
| `!!` | 강제 non-null (NPE 위험) | `name!!` |
| `let` | null 아닐 때만 실행 | `name?.let { println(it) }` |

```kotlin
val name: String? = null
println(name?.uppercase() ?: "Guest")
name?.let { println("길이: ${it.length}") }
```

---

## ✅ 5. 컬렉션 + 고차 함수: `map`, `filter`, `forEach`

| 함수 | 설명 | 예시 |
|------|------|------|
| `map` | 요소 변환 | `list.map { it * 2 }` |
| `filter` | 조건 필터링 | `list.filter { it > 3 }` |
| `forEach` | 반복 실행 | `list.forEach { println(it) }` |

```kotlin
val names = listOf("Kotlin", "Java", "Groovy", "Swift")

names
    .filter { it.length > 5 }
    .map { "언어: ${it.lowercase()}" }
    .forEach { println(it) }
```

---

## 🚀 입문 요약

> Kotlin은 **타입 안정성**, **표현식 기반 문법**,  
> **간결한 컬렉션 처리**로 Java보다 안전하고 선언적인 코딩을 가능하게 한다.