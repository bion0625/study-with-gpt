# 📚 Groovy 학습 커리큘럼 요약 (README)

이 저장소는 Java 개발자를 위한 Groovy 학습 여정을 단계별로 정리한 내용입니다.  
총 5단계로 구성되어 있으며, 각 단계는 실습과 비교 중심으로 진행되었습니다.

---

## 📘 1단계: 기초 문법과 특징

### 🔹 주요 내용
- 변수 선언과 타입 추론
- 리스트, 맵, 컬렉션 처리
- 조건문과 반복문
- 함수와 클로저
- 클래스, 객체 생성 및 프로퍼티

### 🔹 예제
```groovy
def name = "Groovy"
def list = [1, 2, 3]
def map = [name: "Groovy", lang: "JVM"]
```

---

## 📗 2단계: 고급 문법

### 🔹 주요 내용
- 연산자 오버로딩
- Truthiness와 null-safe 연산자 (`?.`, `?:`, `!!`)
- 문자열 템플릿과 정규표현식
- 예외 처리
- Groovy 스크립트 실행 방식

---

## 📙 3단계: Groovy와 Java 비교

### 🔹 주요 내용
- 클래스 상속과 인터페이스
- 메타프로그래밍 (`Expando`, `MetaClass`, `methodMissing`)
- Java 코드와의 상호 운용성

### 🔹 예제
```groovy
class Dog implements Animal {
    String speak() { "woof!" }
}

String.metaClass.shout = { -> delegate.toUpperCase() + "!" }
```

---

## 📕 4단계: DSL 실전

### 🔹 주요 내용
- Gradle 빌드스크립트 DSL 분석
- Jenkinsfile 구조 및 파이프라인 작성
- 사용자 정의 DSL 설계 예제

### 🔹 DSL 예제
```groovy
taskRunner {
    task('build') {
        println 'Building...'
    }
}
```

---

## 🧩 5단계: Spring + Groovy 실전 연습

### 🔹 주요 내용
- Spring Boot 프로젝트에 Groovy 통합
- 컨트롤러 + 서비스 작성
- Spock 테스트 작성
- Spring 설정을 Groovy DSL로 구성

### 🔹 예제
```groovy
@RestController
class GreetingController {
    private final GreetingService greetingService

    GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService
    }

    @GetMapping("/greet")
    String greet(@RequestParam String name) {
        greetingService.greet(name)
    }
}
```

---

## ✅ 완료

- 모든 단계를 통해 Groovy 문법, DSL 작성, Spring 실전 활용까지 마스터!
- 다음 학습으로는 Gradle Plugin 개발, Jenkins 커스터마이징, Kotlin DSL 비교 등이 추천됩니다.