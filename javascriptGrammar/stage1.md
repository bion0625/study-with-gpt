# Stage 1 — 변수·타입·연산자 기본 문법 학습

## 개요
Stage&nbsp;1에서는 JavaScript 입문자가 가장 먼저 익혀야 할 다섯 가지 기본 문법 요소를 다룹니다. 이 문서를 README 또는 강의 노트 용도로 활용하여 커밋하세요.

### 학습 목표
1. 변수 선언 방식(`var`, `let`, `const`)과 스코프 차이를 이해한다.  
2. 자바스크립트 기본 데이터 타입 7가지를 구분한다.  
3. 산술·비교·논리·할당 연산자의 동작 원리를 파악한다.  
4. 삼항 연산자로 조건 분기를 표현한다.  
5. 템플릿 리터럴로 문자열을 동적으로 구성한다.  
6. 위 지식을 통합해 간단한 Todo 콘솔/DOM 애플리케이션을 만든다.  

---

## 1. 변수 선언과 스코프

| 키워드 | 스코프 | 재선언 | 재할당 | 호이스팅 |
| :---: | :---: | :---: | :---: | :---: |
| `var` | 함수 | O | O | O (초깃값 *undefined*) |
| `let` | 블록 | X | O | O (TDZ 존재) |
| `const` | 블록 | X | X | O (TDZ 존재) |

```js
console.log(a); // undefined
var a = 1;

{
  let b = 2;
}
console.log(b); // ReferenceError
```

> **Tip:** 새 코드에서는 `let`/`const` 사용을 기본값으로 삼아야 예측 가능한 버그 방지가 가능합니다.

---

## 2. 기본 데이터 타입

| 타입 | 예시 | `typeof` |
| :---: | :---: | :---: |
| Number | `42`, `NaN`, `Infinity` | `"number"` |
| String | `'hi'`, `` `template` `` | `"string"` |
| Boolean | `true`, `false` | `"boolean"` |
| null | `null` | `"object"` (언어적 버그) |
| undefined | `undefined` | `"undefined"` |
| Symbol | `Symbol('id')` | `"symbol"` |
| BigInt | `9007199254740993n` | `"bigint"` |

```js
typeof Symbol('id');        // "symbol"
0n == 0;                    // true
0n === 0;                   // false
```

---

## 3. 연산자 기초

### 3.1 산술
`+  -  *  /  %  **`

```js
'2' + 3; // "23"
'2' * 3; // 6
```

### 3.2 비교
`==`(느슨) vs `===`(엄격)

```js
[] == 0;   // true
[] === 0;  // false
```

### 3.3 논리
`&&`, `||`, `!`

```js
const label = input || '익명';
isReady && start();
```

### 3.4 할당
`=  +=  -=  *= ...`

---

## 4. 삼항 연산자

```js
const tag = age >= 18 ? 'adult' : 'minor';
```

- 두 갈래 결과가 짧고 단순할 때만 사용.  
- 중첩 삼항은 가독성을 망치므로 `if…else if…` 권장.

---

## 5. 템플릿 리터럴

```js
const name = 'Mira';
const msg  = `Hello, ${name}!`;
```

특징:  
1. 백틱 사용.  
2. `${}` 내 어떤 표현식도 가능.  
3. 여러 줄 문자열을 그대로 포괄.  
4. 태그드 템플릿으로 고급 확장 가능.  

---

## 6. 종합 미니 프로젝트: **Todo v0.1**

```html
<body>
  <script>
    let nextId = 1;
    const tasks = [];

    const title = prompt('새 할 일을 입력하세요:');
    const task = { id: nextId++, title, done: false };
    tasks.push(task);

    if (confirm(`"${title}"을(를) 완료로 표시할까요?`)) {
      task.done = !task.done;
    }

    const listHTML = tasks.map(t =>
      `<li>${t.done ? '✅' : '🕒'} ${t.title}</li>`
    ).join('\n');

    const remaining = tasks.filter(t => !t.done).length;
    const summary = remaining === 0
      ? '🎉 모두 완료!'
      : `🗒️ 남은 일: ${remaining}개`;

    document.body.innerHTML = `
      <h2>할 일 목록</h2>
      <ul>${listHTML}</ul>
      <p>${summary}</p>
    `;
  </script>
</body>
```

---

### 다음 학습(Stage 2) 미리보기

- 조건·반복문 심화 `if`, `for`, `while`  
- 함수 선언·화살표 함수  
- DOM API로 동적 요소 추가/삭제  
- 로컬 스토리지·모듈화  

---

> **저장 & 커밋 지시**  
> 1. 이 파일을 `stage1.md`로 저장.  
> 2. Git 프로젝트 루트에서  
>    ```bash
>    git add stage1.md  
>    git commit -m "docs(stage1): JS 기본 문법 정리"
>    ```  
> 3. 깃허브에 푸시하면 준비 완료!  
