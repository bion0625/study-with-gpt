# Kotlin 실전 토이 프로젝트 지침서

> 이 문서는 Kotlin 실전 학습을 위한 토이 프로젝트 가이드입니다.  
> DSL 설계, 비동기 흐름, Gradle, Spring, Compose 등 단계별 적용을 목표로 합니다.

---

## 📌 프로젝트 개요

- **프로젝트 이름**: (예: "미니 이메일 자동화 도구")
- **핵심 기능**:
  - [ ] 기능 A: ___
  - [ ] 기능 B: ___
- **사용 기술**:
  - Kotlin (버전: ___)
  - Gradle Kotlin DSL
  - Coroutine / Flow
  - 기타: ___

---

## 🧱 프로젝트 구조 (예상)

```
/project-root
├── build.gradle.kts
├── src/
│   └── main/
│       ├── kotlin/
│       │   └── ...
│       └── resources/
└── README.md
```

---

## ✅ 목표 학습 요소

| 항목 | 목표 | 적용 여부 |
|------|------|----------|
| Kotlin 기본 문법 | idiomatic 코드로 구현 | ✅ / ⬜ |
| DSL 스타일 설계 | 수신 객체, builder 구현 | ✅ / ⬜ |
| Coroutine / Flow | 비동기 처리, 스트림 수집 | ✅ / ⬜ |
| Gradle Kotlin DSL | build 설정 | ✅ / ⬜ |
| Spring Boot 연계 | REST API 작성 | ✅ / ⬜ |
| Jetpack Compose | Android UI | ✅ / ⬜ |

---

## 🔄 개발 단계

### [1단계] 기본 Kotlin 구조 세팅
- [ ] `build.gradle.kts` 작성
- [ ] `main()` 진입점 구성

### [2단계] 기능 A - ____
- [ ] 클래스 설계
- [ ] DSL 구조 구성

### [3단계] 기능 B - ____
- [ ] Flow / Coroutine 연계
- [ ] 테스트 코드 작성

---

## 📝 메모 / 회고

- DSL 구현하면서 느낀 점:
- 코루틴 쓰며 혼란스러웠던 부분:
- Gradle에서 막힌 부분:

---

## 📚 참고 링크

- Kotlin DSL 공식 문서: https://kotlinlang.org/docs/type-safe-builders.html
- Coroutine 개요: https://kotlinlang.org/docs/coroutines-overview.html
- Gradle Kotlin DSL 가이드: https://docs.gradle.org/current/userguide/kotlin_dsl.html

---