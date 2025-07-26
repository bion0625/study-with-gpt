class Runner {
    void task(String name, Closure body) {
        println "== Running task: $name =="
        body()
    }
}

def taskRunner(Closure c) {
    def runner = new Runner()
    c.delegate = runner
    c()
}

taskRunner {
    task('build') {
        println 'Step 1: clean'
        println 'step 2: compile'
    }
    task('test') {
        println 'Running tests My Project'
    }
    task('deploy') {
        println 'Deploying...'
    }
}