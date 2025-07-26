package com.groovy.ch05

import org.springframework.stereotype.Service

@Service
class GreetingService {

    String greet(String name) {
        "Hello $name!"
    }
}
