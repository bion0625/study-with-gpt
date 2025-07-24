# Stage 4 — `this` · 클로저 · ES Modules · Vite

## 개요
Stage 4에서는 **언어 심화 기능**(this 바인딩 규칙, 클로저)과 **모듈 시스템**(ES Modules) 및 **프론트 개발 환경(Vite)** 을 도입해 Todo 앱을 **모듈화·캡슐화·실시간 HMR** 구조로 발전시켰습니다.

---

## 1. 학습 핵심

| 범주 | 키워드 | 활용 맥락 |
|------|--------|-----------|
| `this` 바인딩 | 일반 호출 · 메서드 · `new` · `bind` / `call` / `apply` | 이벤트 핸들러·메서드 분리 시 버그 예방 |
| 클로저&nbsp;&amp;&nbsp;캡슐화 | `createStore()`로 비공개 상태 은닉 | 전역 오염 방지, 공개 API로만 상태 변경 |
| ES Modules | `export` / `import`, 모듈 스코프 | `store.js`, `ui.js`, `main.js` 분리 |
| Vite 개발 서버 | HMR, Rollup 빌드 | 빠른 피드백, `npm run dev` 동시 실행 |

---

## 2. 주요 코드 구조

```text
src/
├── store.js      # createStore(): 상태·메서드 (export)
├── ui.js         # DOM 렌더·이벤트 (default export)
└── main.js       # 엔트리 → 모듈 조립
index.html        # <script type="module" src="main.js">
