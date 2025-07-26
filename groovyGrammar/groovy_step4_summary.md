# 📕 4단계: DSL 실전

---

## 14. Gradle 빌드스크립트 구조 분석

### ✅ 핵심 개념
- Gradle은 Groovy 기반의 빌드 자동화 도구
- `build.gradle`은 Groovy DSL로 작성됨
- 메서드 호출, 속성 설정, 클로저 위임 등을 통해 유연한 설정 가능

### ✅ 주요 DSL 요소 예시
```groovy
plugins {
    id 'application'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.apache.commons:commons-lang3:3.12.0'
}

application {
    mainClass = 'com.example.Main'
}
```

---

## 15. Jenkinsfile 구조 및 파이프라인 작성

### ✅ 핵심 개념
- Jenkinsfile은 Groovy 기반 선언형 DSL로 CI/CD 파이프라인 정의
- `pipeline`, `stage`, `steps`, `post`, `environment`, `agent` 등의 블록으로 구성

### ✅ 예시
```groovy
pipeline {
    agent any

    environment {
        PROJECT_NAME = 'BionApp'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out source code...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "Building $PROJECT_NAME..."
                sh './gradlew build'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh './gradlew test'
            }
        }
    }

    post {
        always {
            echo 'Cleaning up'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed'
        }
    }
}
```

---

## 16. 사용자 정의 DSL 설계 예제

### ✅ 핵심 개념
- Groovy의 delegate, 클로저, 동적 메서드를 활용해 DSL을 직접 만들 수 있음
- Gradle, Jenkins DSL의 핵심 원리를 이해하고 직접 구현 가능

### ✅ DSL 설계 예시
```groovy
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
        println 'Building My Project'
    }
    task('test') {
        println 'Running tests My Project'
    }
}
```

---

✅ 4단계 완료!