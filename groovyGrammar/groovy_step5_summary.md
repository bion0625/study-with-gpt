# 🧩 5단계: Spring + Groovy 실전 연습 요약

---

## 17. Spring Boot + Groovy 프로젝트 생성

- Groovy 파일과 Java 파일을 같은 프로젝트에서 혼용 가능
- `src/main/groovy` 디렉토리 추가
- build.gradle에 다음과 같은 설정:
```groovy
plugins {
    id 'groovy'
    id 'org.springframework.boot'
}
dependencies {
    implementation 'org.codehaus.groovy:groovy'
    implementation 'org.springframework.boot:spring-boot-starter-web'
}
```
- Groovy 컨트롤러 작성 예:
```groovy
@RestController
class GreetingController {
    @GetMapping("/greet")
    String greet(@RequestParam(defaultValue = 'Groovy') String name) {
        "Hello, $name"
    }
}
```

---

## 18. 컨트롤러, 서비스 작성 실습

- `GreetingService` 클래스에서 로직 분리
- 컨트롤러에서 생성자 주입으로 서비스 호출

```groovy
// GreetingService.groovy
@Service
class GreetingService {
    String greet(String name) {
        "Hello $name!"
    }
}

// GreetingController.groovy
@RestController
class GreetingController {
    private final GreetingService greetingService

    GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService
    }

    @GetMapping("/greet")
    String greet(@RequestParam(defaultValue = 'Groovy') String name) {
        greetingService.greet(name)
    }
}
```

---

## 19. 테스트와 DSL로 구성된 설정 파일 작성

### ✅ Spock 테스트
- `GreetingServiceTest.groovy` 작성
- Spock의 `given / when / then` 구문 사용

```groovy
class GreetingServiceTest extends Specification {
    def "이름을 넣으면 인사 메시지를 반환한다"() {
        given:
        def service = new GreetingService()
        when:
        def result = service.greet("이채")
        then:
        result == "Hello 이채!"
    }
}
```

### ✅ 설정 DSL
- SpringApplicationBuilder로 Groovy 스타일 설정 구성

```groovy
new SpringApplicationBuilder(Ch05Application)
    .properties([
        'spring.application.name': 'ch05',
        'server.port': '8081'
    ])
    .run(args)
```

---

✅ 5단계 완료! Groovy 실전 DSL 및 Spring 연동까지 마스터!