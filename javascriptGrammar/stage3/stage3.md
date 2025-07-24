# Stage 3 — 배열·객체·스코프 함수형 리팩터

## 개요
Stage 3에서는 **불변 데이터 패턴(Immutable)** 과 ES6+ 문법(전개·구조 분해·축약 객체), 그리고 스코프·호이스팅·TDZ를 활용해 Todo 앱을 **함수형 스타일**로 리팩터링했습니다.

---

## 1. 학습 핵심

| 카테고리 | 키워드 | 활용 맥락 |
|----------|--------|-----------|
| 배열 메서드 | `map`, `filter`, `reduce`, `find`, `some`, `every` | 상태 업데이트 및 집계 |
| 전개 연산자 | `...array`, `{ ...obj }` | 복사·병합·토글 |
| 구조 분해 | `[a, ...r]`, `{ id, title }` | 루프·파라미터 추출 |
| 객체 리터럴 고급 | 축약 키·계산된 키·메서드 단축 | `makeTask`, `getFiltered` |
| 선택적 체이닝·Nullish | `?.`, `??` | 안전 접근·기본값 |
| 스코프·TDZ | `let/const` 블록 스코프 | `var` 제거, 함수 표현식 |
| 함수형 업데이트 | 새 배열로 재대입 | 사이드이펙트 최소화 |

---

## 2. 스니펫

```js
// 불변 추가
tasks = [...tasks, { id: nextId++, title, done:false }];

// 토글
tasks = tasks.map(t =>
  t.id === id ? { ...t, done: !t.done } : t
);

// reduce 집계
const { todo } = tasks.reduce(
  (acc, { done }) => done
    ? { ...acc, done: acc.done + 1 }
    : { ...acc, todo: acc.todo + 1 },
  { done:0, todo:0 }
);
```

---

## 3. Todo v0.4 특징
- 모든 함수 `const`+화살표
- 전역 `tasks`는 불변 패턴으로만 변경
- localStorage 영속, 필터·삭제·토글 완비

---

## 4. 완료 체크
- [x] `var` 제거, TDZ 이해  
- [x] 배열 메서드·전개·구조 분해 적용  
- [x] 불변 패턴으로 리팩터 완료  
- [x] Todo v0.4 정상 동작

---

## 5. 커밋
```bash
git add stage3.md todo-v0.4.html
git commit -m "docs(stage3): 불변 패턴 & 함수형 리팩터 정리"
git push
```

Stage 3 완료 → **Stage 4 (this·클로저·ES Modules)** 로 이동! 🚀
