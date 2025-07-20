# Stage 2 — 조건문·반복문·함수·DOM 기본

## 개요
Stage 2에서는 **화면 조작**과 **제어 흐름**을 결합해, 브라우저 상에서 실시간으로 동작하는 Todo 애플리케이션을 완성했습니다. 이 문서는 기록·커밋용 요약입니다.

---

## 1. 학습한 핵심 개념

| 범주 | 키워드 | 사용 맥락 |
|-----|--------|-----------|
| **조건문** | `if / else`, `switch` | 입력 검증, 필터 분기 |
| **반복문** | `for`, `for…of`, `while` | `tasks` 순회하여 `<li>` DYNAMIC 생성 |
| **함수** | 선언/표현식, 매개변수 기본값 | `render`, `addTask`, `save` 등 역할 분리 |
| **화살표 함수** | `() => {}` | 짧은 콜백, `forEach(btn => …)` |
| **DOM API** | `querySelector`, `createElement`, `append`, `addEventListener` | HTML 트리 조작, 이벤트 대응 |

---

## 2. 핵심 스니펫

### 조건 & 검증
```js
if (!title.trim()) return alert('내용을 입력하세요!');
switch (viewMode) {
  case 'active':    return tasks.filter(t => !t.done);
  case 'completed': return tasks.filter(t =>  t.done);
  default:          return tasks;
}
```

### 반복 & 렌더
```js
for (const t of getFiltered()) {
  const li = document.createElement('li');
  li.textContent = t.title;
  if (t.done) li.classList.add('done');
  ul.append(li);
}
```

### 함수 분리
```js
function save()  { localStorage.setItem('tasks', JSON.stringify(tasks)); }
function load()  { return JSON.parse(localStorage.getItem('tasks')) ?? []; }
function render() { /* … */ }
```

### 화살표 & 이벤트 위임
```js
document.querySelector('#todo-list')
  .addEventListener('click', e => {
    const li = e.target.closest('li');
    if (!li) return;
    /* 토글 or 삭제 */
  });
```

---

## 3. Mini Project — Todo v0.3 (완전 코드)

> **기능**: 추가 · 토글 · 삭제 · 필터 · localStorage 영속화  
> 코드 전체를 한 파일에 넣어두어 바로 실행 가능하게 했습니다.

```html
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>Todo v0.3 — Stage2</title>
<style>
  .done { text-decoration: line-through; color: gray; }
  .filter.active { font-weight: bold; }
</style>
</head>
<body>
<h2>할 일 목록</h2>
<input id="input-title" placeholder="할 일을 입력하세요" />
<button id="btn-add">추가</button>
<button class="filter active" data-view="all">전체</button>
<button class="filter" data-view="active">미완료</button>
<button class="filter" data-view="completed">완료</button>
<ul id="todo-list"></ul>
<p id="summary"></p>

<script>
let nextId = 1;
let tasks  = load();
let viewMode = 'all';

function save() { localStorage.setItem('tasks', JSON.stringify(tasks)); }
function load() { try { return JSON.parse(localStorage.getItem('tasks')) ?? []; } catch { return []; } }

function getFiltered() {
  switch (viewMode) {
    case 'active':    return tasks.filter(t => !t.done);
    case 'completed': return tasks.filter(t =>  t.done);
    default:          return tasks;
  }
}

function render() {
  const ul = document.querySelector('#todo-list');
  ul.innerHTML = '';
  for (const t of getFiltered()) {
    const li = document.createElement('li');
    li.textContent = t.title;
    li.dataset.id  = t.id;
    if (t.done) li.classList.add('done');

    const del = document.createElement('button');
    del.textContent = '🗑️';
    del.className   = 'btn-del';
    li.append(del);
    ul.append(li);
  }

  const remain = tasks.filter(t => !t.done).length;
  document.querySelector('#summary').textContent =
    remain ? `🗒️ 남은 일: ${remain}개` : '🎉 모두 완료!';

  document.querySelectorAll('.filter')
    .forEach(btn => btn.classList.toggle('active', btn.dataset.view === viewMode));
}

document.querySelector('#btn-add').addEventListener('click', () => {
  const input = document.querySelector('#input-title');
  const title = input.value.trim();
  if (!title) return alert('내용을 입력하세요!');
  tasks.push({ id: nextId++, title, done: false });
  input.value = '';
  save(); render();
});

document.querySelector('#todo-list').addEventListener('click', e => {
  const li = e.target.closest('li');
  if (!li) return;
  const id = Number(li.dataset.id);
  if (e.target.classList.contains('btn-del')) {
    tasks = tasks.filter(t => t.id !== id);
  } else {
    const t = tasks.find(t => t.id === id);
    t.done = !t.done;
  }
  save(); render();
});

document.querySelectorAll('.filter').forEach(btn =>
  btn.addEventListener('click', () => {
    viewMode = btn.dataset.view;
    render();
  })
);

render();
</script>
</body>
</html>
```

---

## 4. Stage 2 완료 체크리스트

- [x] **조건문**으로 입력·분기 제어  
- [x] **반복문**으로 리스트 렌더링  
- [x] **함수**로 코드 구조화  
- [x] **화살표 함수** 콜백 활용  
- [x] **DOM API**로 UI 업데이트  
- [x] **localStorage**로 데이터 영속화  

Stage 2 학습이 끝났습니다. 이제 **Stage 3 (배열 메서드·객체·스코프)** 리팩터로 이동하세요!

---

## 커밋 가이드

```bash
git add stage2.md
git commit -m "docs(stage2): 조건·반복·함수·DOM 정리"
git push
```

> 필요하다면 `todo-v0.3.html`도 함께 커밋해 두세요.
