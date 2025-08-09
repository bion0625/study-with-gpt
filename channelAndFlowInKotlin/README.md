# Kotlin Coroutines - Channel & Flow (2-2까지)

## 1. 코루틴 복습
### 핵심 개념
- **가벼운 스레드**: 스레드보다 훨씬 적은 비용으로 수천 개 실행 가능
- **중단 가능성**: `suspend` 함수로 지정된 지점에서 실행을 멈추고, 나중에 이어서 진행

### launch vs async
- `launch`: 결과 반환 없음
- `async`: `Deferred`로 결과 반환, `await()`로 받음

### 예시
```kotlin
fun main() = runBlocking {
    println("시작: ${Thread.currentThread().name}")

    launch {
        delay(1000L)
        println("코루틴 1 완료")
    }

    val deferred = async {
        delay(500L)
        3 + 5
    }

    launch {
        delay(1300L)
        println("코루틴 3 완료")
    }

    println("메인 진행, async value: ${deferred.await()}")
}
```

---

## 2. 채널(Channel) 기본
### 개념
- 코루틴 간 **안전하게 데이터 전달**
- `send` / `receive` 사용
- **버퍼 없는 채널**: 송신자·수신자가 만나야 데이터 전달
- **버퍼 있는 채널**: `capacity` 지정 시 버퍼에 임시 저장 가능

### 예시 (버퍼 없음)
```kotlin
val channel = Channel<String>()

launch {
    listOf("메시지 1", "메시지 2", "끝").forEach { channel.send(it) }
    channel.close()
}

launch {
    for (msg in channel) {
        if (msg == "끝") {
            println("수신 종료")
            break
        }
        println("받음: $msg")
    }
}
```

### 버퍼 있는 채널 예시
```kotlin
val channel = Channel<Int>(capacity = 2)

launch {
    (1..5).forEach {
        println("send $it at ${System.currentTimeMillis()%100000}")
        channel.send(it)
    }
    channel.close()
}

launch {
    for (c in channel) {
        delay(300)
        println("recv $c at ${System.currentTimeMillis()%100000}")
    }
}
```
- capacity=2 → `send(3)`에서 첫 suspend 발생

---

## 3. Flow 기본
### 개념
- **비동기 데이터 스트림**
- `flow { emit(...) }`로 생산, `collect { ... }`로 소비
- **Cold Stream**: collect할 때마다 처음부터 시작

### 예시
```kotlin
fun ticker(periodMs: Long): Flow<Int> = flow {
    var i = 0
    while (true) {
        emit(i++)
        delay(periodMs)
    }
}

ticker(200)
    .take(5)
    .map { it * it }
    .filter { it % 2 == 0 }
    .collect { println("got $it at ${System.currentTimeMillis()%100000}") }
```

---

## 4. Flow 백프레셔
### buffer
- 중간 버퍼를 둬서 생산자가 빠를 때 수집이 막히지 않도록 함

### conflate
- 중간 값은 버리고 **최신 값만 전달**

### collectLatest
- 새 값이 오면 **이전 값 처리 작업 취소** 후 최신 값 처리

### 비교 예시
```kotlin
val base = flow {
    repeat(6) { i ->
        println("emit $i at ${System.currentTimeMillis()%100000}")
        emit(i)
        delay(100)
    }
}

// buffer
base
    .buffer(64)
    .onEach { delay(250) }
    .collect { println("collect $it at ${System.currentTimeMillis()%100000}") }

// conflate
base
    .conflate()
    .onEach { delay(250) }
    .collect { println("collect $it at ${System.currentTimeMillis()%100000}") }

// collectLatest
base.collectLatest { value ->
    println("start $value at ${System.currentTimeMillis()%100000}")
    delay(250)
    println("done $value at ${System.currentTimeMillis()%100000}")
}
```

---

## 요약
- Channel: 동시성 데이터 전달, 버퍼 여부에 따라 동작 차이
- Flow: 비동기 스트림, cold 특성, 연산자 조합 가능
- 백프레셔 대응: `buffer`, `conflate`, `collectLatest`로 처리 전략 선택
