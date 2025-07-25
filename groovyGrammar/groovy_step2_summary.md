
# Groovy 2단계 정리 (6~10주제)

---

## 6. 연산자 오버로딩

### ✅ 개념
Groovy에서는 연산자가 실제로는 메서드 호출로 처리됨  
예: `a + b` → `a.plus(b)`

| 연산자 | 메서드 |
|--------|--------|
| `+`    | `plus()` |
| `-`    | `minus()` |
| `==`   | `equals()` |
| `<<`   | `leftShift()` |
| `[]`   | `getAt()` / `putAt()` |

### ✅ 예제
```groovy
class Money {
    BigDecimal amount
    Money plus(Money other) {
        new Money(amount: this.amount + other.amount)
    }
    String toString() {
        "₩$amount"
    }
}
def m1 = new Money(amount: 1000)
def m2 = new Money(amount: 2000)
println m1 + m2  // ₩3000
```

---

## 7. Truthiness와 null-safe 연산자

### ✅ Truthiness
- `if` 조건식에 null, 빈 문자열, 빈 리스트 등은 false로 평가됨

### ✅ null-safe 연산자
| 문법 | 설명 |
|------|------|
| `?.` | null-safe navigation |
| `?:` | Elvis 연산자 (기본값) |
| `??` | ❌ Groovy 미지원 (자바스크립트 스타일) |

### ✅ 예제
```groovy
def name = ''
println name ?: 'Anonymous'  // Elvis

def user = null
println user?.name  // null-safe 접근
```

---

## 8. 문자열 템플릿과 정규표현식

### ✅ GString
- `"Hello, $name"` → 변수 삽입 가능
- 싱글쿼트('')는 안 됨

### ✅ 정규표현식
| 연산자 | 설명 |
|--------|------|
| `==~`  | 전체 일치 |
| `=~`   | 부분 매칭 (Matcher 반환) |

### ✅ 예제
```groovy
def email = "abc@xyz.com"
if (email ==~ /(\w+)@(\w+\.\w+)/) {
    println "Valid email"
}

def date = "2025-07-25"
def m = date =~ /(\d{4})-(\d{2})-(\d{2})/
if (m.matches()) {
    println m[0][1]  // 2025
}
```

---

## 9. 예외 처리와 try-catch

### ✅ 기본 구조
```groovy
try {
    riskyCode()
} catch (e) {
    println e.message
} finally {
    println "항상 실행됨"
}
```

- `throws` 선언 불필요
- `checked exception` 강제 아님

---

## 10. 스크립트와 실행 방식

### ✅ 스크립트 vs 클래스
```groovy
// 스크립트 방식
def name = "Groovy"
println "Hello, $name"

// 클래스 방식
class Hello {
    static void main(String[] args) {
        println "Hello from main!"
    }
}
```

### ✅ 실행
```bash
groovy myScript.groovy
```

### ✅ 외부 라이브러리 가져오기
```groovy
@Grab('org.jsoup:jsoup:1.13.1')
import org.jsoup.Jsoup
```

> Ivy가 필요하므로 standalone 환경에서는 동작 안 할 수 있음

---
