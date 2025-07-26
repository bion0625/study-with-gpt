class TaskRunner {
    void task(String name, Closure body) {
        println "== Running task: $name =="
        body()
    }
}

def taskRunner(Closure c) {
    def runner = new TaskRunner()
    c.delegate = runner
    c()
}

taskRunner {
    task('build') {
        println 'Building...'
    }
    task('test') {
        println 'Running tests...'
    }
}