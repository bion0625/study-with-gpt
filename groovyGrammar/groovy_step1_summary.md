
# Groovy 1단계 정리 (1~5주제)

## 1. 변수 선언과 타입 추론

### ✅ 핵심 요약
- `def` 키워드로 타입 생략 가능 (동적 타입)
- 타입 명시도 가능 (`String`, `int`, `boolean` 등)
- 세미콜론(`;`) 생략 가능
- 타입은 대입값으로 자동 추론됨

### ✅ 예시
```groovy
def name = "Groovy"   // String 추론
int age = 30
boolean isCool = true
println "name: $name, age: $age, isCool: $isCool"
```

---

## 2. 리스트와 맵, 컬렉션 처리

### ✅ 리스트
```groovy
def list = [1, 2, 3]
list << 4      // 요소 추가
list += 5      // 요소 병합
println list   // [1, 2, 3, 4, 5]
```

### ✅ 맵
```groovy
def map = [name: "Groovy", version: 4]
map.language = "dynamic"
println map.name         // Groovy
println map["language"]  // dynamic
```

---

## 3. 조건문과 반복문

### ✅ 조건문 (if, switch)
```groovy
def age = 20
if (age >= 18) println "성인" else println "미성년자"

switch("Groovy") {
    case "Groovy": println "Dynamic!"; break
    case "Java": println "Verbose!"; break
    default: println "Unknown!"
}
```

### ✅ 반복문
```groovy
for (i in 0..4) {
    println i
}

def fruits = ["apple", "banana"]
for (f in fruits) {
    println f.toUpperCase()
}
```

---

## 4. 함수와 클로저

### ✅ 함수 정의
```groovy
def greet(name) {
    "Hello, $name"
}
println greet("Groovy")
```

### ✅ 클로저 정의 및 호출
```groovy
def shout = { word -> println word.toUpperCase() }
shout("groovy")

def square = { n -> n * n }
println square(3)
```

### ✅ 컬렉션 고차함수 예제
```groovy
def list = [1, 2, 3, 4, 5]
def doubled = list.collect { it * 2 }     // [2, 4, 6, 8, 10]
def evens = list.findAll { it % 2 == 0 }  // [2, 4]
```

---

## 5. 클래스, 객체 생성 및 프로퍼티

### ✅ 클래스 정의 및 메서드
```groovy
class Person {
    String name
    int age

    def sayHello() {
        "Hi, I'm $name and I'm $age years old."
    }
}
```

### ✅ 객체 생성 및 프로퍼티 접근
```groovy
def p = new Person(name: "lietzsche", age: 33)
println p.sayHello()

p.name = "Nietzsche"
println p.name
println p.getName()
```

### ✅ 예제: Car 클래스
```groovy
class Car {
    String brand
    String model
    int year

    def getInfo() {
        "Brand: $brand, Model: $model, Year: $year"
    }
}

def car = new Car()
car.brand = '현대'
car.model = '아반떼'
car.year = 2023

println car.getInfo()
```

---

## 🔁 Java와 Groovy 비교 요약

| 항목 | Java | Groovy |
|------|------|--------|
| 타입 선언 | 필수 | 선택적 (`def`) |
| 세미콜론 | 필수 | 생략 가능 |
| 리스트 생성 | `new ArrayList<>()` | `[1, 2, 3]` |
| 반복문 | `for (int i = 0; i < n; i++)` | `for (i in 1..n)` |
| 람다식 | `x -> x * x` (Java 8+) | `{ x -> x * x }` |
| 클로저 | 미지원 (Function 인터페이스 필요) | 기본 제공 |
| 클래스 생성자 | 명시적 작성 필요 | 명명 인자로 생성 가능 |
| getter/setter | 수동 작성 | 자동 생성됨 |
