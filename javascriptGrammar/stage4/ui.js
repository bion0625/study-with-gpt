export default function initUI(store) {
    const $ = (sel) => document.querySelector(sel);
    const input = $('#input-title');
    const addBtn = $('#btn-add');
    const list = $('#todo-list');
    const summary = $('#summary');

    const render = () => {
        list.innerHTML = '';
        const {tasks, view} = store.state;
        const filtered = ({
            all: tasks,
            active: tasks.filter(t => !t.done),
            completed: tasks.filter(t => t.done)
        }[view]);

        filtered.forEach(({id, title, done}) => {
            const li = document.createElement('li');
            li.dataset.id = id;
            li.textContent = title ?? '(제목 없음)';
            if (done) li.classList.add('done');
            li.insertAdjacentHTML('beforeend', '<button class="btn-del">🗑️</button>');
            list.append(li);
        });

        const {todo} = tasks.reduce(
            (acc, {done}) => done ? {...acc, done: acc.done+1} : {...acc, todo: acc.todo+1},
            {done: 0, todo: 0}
        );
        summary.textContent = todo ? `🗒️ 남은 일: ${todo}개` : '🎉 모두 완료!';

        document.querySelectorAll('.filter').forEach(btn =>
            btn.classList.toggle('active', btn.dataset.view === view));
    };

    store.subscribe(render);
    render();

    addBtn.addEventListener('click', () => {
        const title = input.value.trim();
        if (title) {store.add(title); input.value = '';}
    });
    list.addEventListener('click', (e) => {
        const id = e.target.closest('li')?.dataset.id;
        if (!id) return;
        e.target.classList.contains('btn-del') ? store.remove(id) : store.toggle(id);
    });
    document.querySelectorAll('.filter').forEach(btn =>
        btn.addEventListener('click', () => store.setView(btn.dataset.view)));
}