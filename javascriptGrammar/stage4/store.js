export const createStore = () => {
    let tasks = [];
    let view = 'all';
    const subs = [];

    const notify = () => subs.forEach(fn => fn());

    return {
        get state() {return {tasks: [...tasks], view}},
        subscribe:  (fn) => subs.push(fn),
        add:        (title) => {tasks = [...tasks, {id: crypto.randomUUID(), title, done: false}];  notify(); },
        toggle:     (id) => {tasks = tasks.map(t => t.id === id ? {...t, done: !t.done} : t);       notify(); },
        remove:     (id) => {tasks = tasks.filter(t => t.id !== id);                                notify(); },
        setView:    (v) => {view = v;                                                               notify();}
    }
}