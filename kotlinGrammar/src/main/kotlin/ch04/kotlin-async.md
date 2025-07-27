# Kotlin 비동기 흐름 제어 정리

코루틴과 Flow를 활용한 Kotlin의 비동기 처리 방식에 대한 정리입니다.  
Java의 Thread, Future, RxJava 대비 간결하고 가독성 좋은 코드 구성이 가능합니다.

---

## 🌙 1단계: 코루틴 기본 (`suspend`, `launch`, `async`)

### ✔️ 핵심
- `launch`: 결과 없는 코루틴 실행
- `async`: 결과 있는 코루틴 실행 (`Deferred`)
- `await()`: async 결과 받기
- `delay()`: non-blocking 대기
- `runBlocking`: 코루틴 진입점 (테스트, main)

### ✔️ 예제

```kotlin
fun main() = runBlocking {
    println("시작")
    launch {
        delay(1000)
        println("작업 A 완료")
    }
    launch {
        delay(500)
        println("작업 B 완료")
    }
    println("끝")
}
```

---

## ⚙️ 2단계: suspend 함수 + async 병렬 처리

### ✔️ 핵심
- `suspend` 함수: 코루틴 내에서만 호출 가능
- `async`: 병렬로 실행되며, `await()`로 결과 반환

### ✔️ 예제

```kotlin
suspend fun fetchUserName(): String {
    delay(1000)
    return "홍길동"
}

suspend fun fetchUserAge(): Int {
    delay(500)
    return 30
}

fun main() = runBlocking {
    val start = System.currentTimeMillis()

    val resultName = async { fetchUserName() }
    val resultAge = async { fetchUserAge() }

    val name = resultName.await()
    val age = resultAge.await()

    val end = System.currentTimeMillis()
    println("사용자: $name (${age}세), 시간: ${end - start}ms")
}
```

---

## 🌊 3단계: Flow 기본

### ✔️ 핵심
- `flow {}`: 지연 실행 가능한 비동기 스트림 생성
- `emit(value)`: 값을 방출
- `collect {}`: Flow 수집
- `delay()`와 함께 사용할 수 있어 non-blocking 스트림 구현 가능

### ✔️ 예제

```kotlin
fun workFlow(): Flow<String> = flow {
    for (i in 1..5) {
        delay(1000)
        emit("Tick $i")
    }
}

fun main() = runBlocking {
    println("수집 시작")
    workFlow().collect { println(it) }
}
```

---

## ✅ Java 및 RxJava 비교 요약

| 기능 | Kotlin (코루틴/Flow) | Java (Future/Stream) | RxJava |
|------|-----------------------|----------------------|--------|
| 비동기 실행 | `launch`, `async`, `flow` | `CompletableFuture`, `ExecutorService` | `Observable`, `Single` |
| 중단 가능성 | O (`suspend`, `cancel`) | X | O |
| 결과 수집 | `await()`, `collect()` | `get()`, `stream().collect()` | `subscribe()` |
| 코드 표현력 | 높음 | 중간 | 중간 ~ 높음 (복잡) |

---