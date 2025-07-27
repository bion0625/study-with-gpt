# Kotlin 고급 문법 정리 (1~5단계)

Java 개발자를 위한 Kotlin 고급 문법 요약입니다.  
실무에서 자주 쓰이는 DSL 구현 및 표현력 중심으로 구성되었습니다.

---

## 🔐 1단계: `sealed class` 와 `when` 표현식

- `sealed class`는 하위 클래스를 같은 파일 내에서만 정의 가능
- `when` 표현식에서 exhaustiveness 체크가 가능 (else 없이 완전 분기)

```kotlin
sealed class Animal

data class Lion(val name: String) : Animal()
data class Elephant(val weight: Int) : Animal()
data class Penguin(val canSwim: Boolean) : Animal()

fun describe(animal: Animal): String = when (animal) {
    is Lion -> "this lion's name is ${animal.name}"
    is Elephant -> "this elephant's weight is ${animal.weight}"
    is Penguin -> "this penguin can swim: ${animal.canSwim}"
}
```

---

## 🚥 2단계: `enum class` 와 인터페이스 조합

- 각 enum 인스턴스가 인터페이스를 구현하고 메서드를 오버라이딩 가능
- 상태 머신, 전략 패턴 구현에 유리

```kotlin
interface CharacterState {
    fun walk(): CharacterState
    fun attack(): CharacterState
    fun stop(): CharacterState
}

enum class GameState : CharacterState {
    IDLE {
        override fun walk() = WALKING
        override fun attack() = this
        override fun stop() = this
    },
    WALKING {
        override fun walk() = this
        override fun attack() = ATTACKING
        override fun stop() = IDLE
    },
    ATTACKING {
        override fun walk() = this
        override fun attack() = this
        override fun stop() = IDLE
    }
}
```

---

## 🔁 3단계: 위임 패턴과 `by` 키워드

- 인터페이스 구현을 다른 객체에 위임 가능 (자동 forwarding)

```kotlin
interface Speaker {
    fun say(message: String)
}

class KoreanSpeaker : Speaker {
    override fun say(message: String) = println("안녕하세요: $message")
}

class Announcer(speaker: Speaker) : Speaker by speaker {
    fun doSomething() {
        say("인사해주세요")
    }
}
```

---

## 🧩 4단계: Kotlin DSL 스타일 함수 설계법

- 람다 수신 객체 (`T.() -> Unit`)를 활용해 선언형 DSL 구현 가능

```kotlin
class RobotBuilder {
    private val actions = mutableListOf<String>()
    var name: String = "Unknown"

    fun move(action: String) {
        actions.add(action)
    }

    fun build(): String = actions.joinToString("
") + "
from $name"
}

fun robot(init: RobotBuilder.() -> Unit): String {
    val builder = RobotBuilder()
    builder.init()
    return builder.build()
}

fun main() {
    val result = robot {
        name = "Robot1"
        move("forward")
        move("left")
    }
    println(result)
}
```

---

## 🧱 5단계: Builder 패턴을 Kotlin DSL로 구현

- 전통적인 Java Builder보다 더 표현력 있게 중첩 구조 구현 가능

```kotlin
data class Body(val text: String, val footer: String)

class BodyBuilder {
    var text: String = ""
    var footer: String = ""
    fun build(): Body = Body(text, footer)
}

data class EmailMessage(val from: String, val to: String, val subject: String, val body: Body)

class EmailMessageBuilder {
    var from: String = ""
    var to: String = ""
    var subject: String = ""
    private var _body: Body = Body("", "")

    fun body(init: BodyBuilder.() -> Unit) {
        _body = BodyBuilder().apply(init).build()
    }

    fun build(): EmailMessage = EmailMessage(from, to, subject, _body)
}

fun emailMessage(init: EmailMessageBuilder.() -> Unit): EmailMessage {
    val builder = EmailMessageBuilder()
    builder.init()
    return builder.build()
}

fun main() {
    val email = emailMessage {
        from = "from@test.com"
        to = "to@test.com"
        subject = "test title"
        body {
            text = "Hello"
            footer = "Regards"
        }
    }
    println(email)
}
```

---

## ✅ 요약

| 단계 | 주제 | 핵심 키워드 |
|------|------|--------------|
| 1단계 | `sealed class` | 타입 안정성, when 분기 |
| 2단계 | `enum + interface` | 상태 머신, 전략 분기 |
| 3단계 | 위임 패턴 | `by` 키워드, 인터페이스 자동 위임 |
| 4단계 | DSL 함수 설계 | 람다 수신 객체, 가독성 높은 선언형 DSL |
| 5단계 | DSL Builder | 중첩 구조, 선언형 객체 구성 |

---