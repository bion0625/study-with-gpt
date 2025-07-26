package com.groovy.ch05

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController {

    private final GreetingService greetingService

    GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService
    }

    @GetMapping("/greet")
    String greet(@RequestParam(defaultValue = 'Groovy', name = 'name') String name) {
        greetingService.greet(name)
    }
}
