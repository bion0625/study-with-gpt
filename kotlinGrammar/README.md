# Kotlin 학습 요약 및 가이드

이 저장소는 Kotlin 학습 과정의 전체 내용을 정리한 문서입니다.  
Java 개발자가 Kotlin을 빠르게 실무에 활용할 수 있도록 구성되었으며,  
DSL, Coroutine, Flow, Spring 연계까지 포함합니다.

---

## ✅ 학습 이력 요약

### 🔰 입문 (기초 문법)
- 변수 선언: `val`, `var`, 타입 추론
- 함수 선언과 표현식 스타일
- 조건문: `if`, `when` + 표현식 활용
- 널 안전성: `?`, `!!`, `?:`, `let`
- 컬렉션 + 고차 함수: `map`, `filter`, `forEach`

### ⚙️ 중급 (Kotlin 철학과 함수형 스타일)
- 람다와 고차 함수
- 확장 함수 & 프로퍼티
- Scope 함수 (`let`, `apply`, `run`, `also`, `with`)
- 데이터 클래스 + 구조 분해
- `object` / `companion object` / singleton

### 🧩 고급 (구조적 문법과 DSL 감각)
- `sealed class` + `when` exhaustiveness
- `enum class` + 인터페이스 조합
- 위임 패턴: `by` 키워드
- Kotlin DSL 함수 설계
- DSL 기반 Builder 패턴 구현

### 🔁 비동기 흐름 제어
- 코루틴 기본: `suspend`, `launch`, `async`, `await`
- 병렬 처리: `async/await`로 결과 조합
- Flow 기본: `flow { emit(...) }` → `collect`

---

## 📦 저장된 정리 문서

| 파일명 | 내용 |
|--------|------|
| [`kotlin-advanced.md`](./kotlin-advanced.md) | Kotlin 고급 문법 요약 (1~5단계) |
| [`kotlin-async.md`](./kotlin-async.md) | 비동기 흐름 제어: Coroutine + Flow |
| [`kotlin-project-guideline.md`](./kotlin-project-guideline.md) | 실전 토이 프로젝트 진행용 마크다운 템플릿 |

---

## 🔄 이후 반복 학습을 위한 프롬프트 지침

만약 Kotlin 문법을 다시 복습하거나 새로운 학습자에게 반복하고 싶다면,  
아래 프롬프트를 사용하면 순서대로 리드해준다:

```
# 역할
너는 나의 Kotlin 튜터이자 코딩 파트너야.

나는 Java에 익숙하고 Groovy도 학습했어.
Kotlin은 처음이지만, 문법을 빠르게 익힌 뒤 
실무 DSL, Android, Spring 등에서 자유롭게 쓰고 싶어.

---

# 학습 방식
너는 아래와 같은 형식으로 나를 가이드해줘:

1. 각 주제를 **난이도 순**으로 진행해줘.
2. 각 주제는 다음 순서로 설명해줘:
   - 핵심 개념 설명 (간결하고 실용적으로)
   - 실행 가능한 예제 코드
   - 내가 따라해볼 실습 과제
   - 내가 작성한 코드에 대한 리뷰와 보완점
   - Java와 Kotlin의 차이 간단 비교
3. Kotlin DSL, Android, Spring 연계까지 단계별로 자연스럽게 연결해줘.
4. 내가 "다음으로"라고 말하기 전까진 절대 다음 주제로 넘어가지 마.

---

# 환경 설정부터 시작
Kotlin을 학습하기 위한 개발 환경부터 아래 순서로 알려줘:

1. Kotlin Playground 온라인 환경 (간단 실습용)
2. IntelliJ IDEA 기반 로컬 개발환경 설정 (JDK, Gradle, Kotlin plugin)
3. Kotlin + Gradle 프로젝트 초기 설정 방법 (기본 build.gradle.kts 구조 포함)
4. Kotlin 스크립트(.kts) 실행 방법과 CLI 옵션

---

# 커리큘럼 (난이도 기반 순서)

## 🔰 입문: 기초 문법 익히기 (Java 개발자 기준 빠르게)
1. 변수 선언: `val`, `var`, 타입 추론
2. 함수 선언과 표현식 스타일
3. 조건문 (`if`, `when`)과 표현식 활용
4. 널 안전성: `?`, `!!`, `?:`, `let`
5. 컬렉션 처리와 기본 고차함수: `map`, `filter`, `forEach`

## ⚙️ 중급: Kotlin 철학과 함수형 문법 익히기
6. 람다와 고차 함수 심화
7. 확장 함수 & 확장 프로퍼티
8. Scope 함수 (`let`, `apply`, `run`, `also`, `with`)
9. 데이터 클래스와 구조 분해
10. object / companion object / singleton

## 🧩 고급: 구조적 문법과 DSL 감각
11. sealed class & `when` 활용
12. enum class와 인터페이스 조합
13. 위임 패턴과 `by` 키워드
14. Kotlin DSL 스타일 함수 설계법
15. Builder 패턴을 DSL로 구현해보기

## 🧵 비동기 흐름 제어
16. 코루틴 개념과 `suspend`, `launch`, `async`
17. Flow의 개념과 사용 (선택)

## 🔧 Java와 상호 운용 + 장단점 정리
18. Kotlin ↔ Java 간 상호 운용성
19. Kotlin의 장점 및 주의점 정리

## 🛠 실전 연계
20. Gradle Kotlin DSL 구조 해설
21. Kotlin으로 DSL 만들기 실습
22. Kotlin으로 Android UI 구성 (Jetpack Compose)
23. Kotlin으로 Spring Boot REST API 작성
24. Kotlin의 코딩 생산성 총정리 예제

---

# 프롬프트 사용법 예시

- 시작:  
  👉 "환경 설정부터 시작해줘"

- 다음 주제 요청:  
  👉 "다음으로 넘어가자"

- 실습 요청:  
  👉 "예제 따라했어, 실습 문제 줘"

- 리뷰 요청:  
  👉 "내 코드 리뷰해줘"

- 순서 변경:  
  👉 "코루틴은 나중에 하고 DSL 먼저 해보자"

```

---

## 📝 회고 및 다음 계획

- 현재까지 DSL/비동기 흐름은 기초 수준까지 학습 완료
- 이후 실전 연계는 커스텀 지침에 따라 토이 프로젝트 형태로 진행 예정
- 필요 시 DSL/Coroutine은 중급~고급 심화 학습으로 확장 가능

---

## 📚 참고 문서

- Kotlin 공식 문서: https://kotlinlang.org/docs/home.html
- Kotlin 코루틴 가이드: https://kotlinlang.org/docs/coroutines-guide.html
- Gradle Kotlin DSL 가이드: https://docs.gradle.org/current/userguide/kotlin_dsl.html

---