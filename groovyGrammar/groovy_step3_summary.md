# 📙 3단계: Groovy와 Java 비교

## 11. 클래스 상속과 인터페이스

### ✅ 핵심 개념
- Groovy는 Java와 동일하게 `extends`, `implements` 사용
- `return`, 세미콜론 생략 가능
- 클래스 정의 시 접근제어자 생략 가능 (`public class` → `class`)
- 다형성, 인터페이스 구현도 Java와 동일한 개념이지만 더 간결한 문법 제공

### ✅ 예제
```groovy
interface Animal {
    String speak()
}

class Dog implements Animal {
    String speak() { "woof!" }
}

class Cat implements Animal {
    String speak() { "Meow!" }
}

println new Dog().speak()
println new Cat().speak()
```

---

## 12. 메타프로그래밍 간단 소개

### ✅ 핵심 개념
- Groovy는 런타임에 클래스나 메서드를 동적으로 수정하거나 추가 가능
- 주요 기능:
  - `Expando` : 동적으로 속성과 메서드 추가
  - `MetaClass` : 기존 클래스에 메서드 추가
  - `methodMissing` / `propertyMissing` : 존재하지 않는 메서드/프로퍼티 호출 시 동작 정의

### ✅ 예제
```groovy
// Expando
def user = new Expando()
user.name = 'Groovy'
user.sayHello = { "Hello, I'm $user.name" }
println user.sayHello()

// MetaClass
String.metaClass.shout = { -> delegate.toUpperCase() + '!!!' }
println 'groovy'.shout()

// methodMissing
class DynamicCaller {
    def methodMissing(String name, args) {
        return "You tried to call '$name' with args: $args"
    }
}
def dyn = new DynamicCaller()
println dyn.hello('Groovy')
```

### ✅ 실습
```groovy
def person = new Expando()
person.name = 'Alice'
person.greet = { "Hi, I'm $person.name" }
println person.greet()
```

---

## 13. Java 코드와의 상호 운용성

### ✅ 핵심 개념
- Groovy는 Java 클래스 직접 사용 가능 (반대도 가능)
- `.groovy`와 `.java` 파일 혼용 가능
- Groovy 코드에선 Java의 클래스/메서드 바로 호출 가능
- Groovy 클래스는 Java에서 사용할 때 타입을 명시해야 함

### ✅ 예제

#### Java 클래스 (Ch03_3_KoreanHelloService.java)
```java
public class Ch03_3_KoreanHelloService {
    public String sayHi(String name) {
        return "안녕하세요 " + name + "님";
    }
}
```

#### Groovy 호출 코드
```groovy
def s = new Ch03_3_KoreanHelloService()
println s.sayHi("이채")
```

---

✅ 3단계 완료!