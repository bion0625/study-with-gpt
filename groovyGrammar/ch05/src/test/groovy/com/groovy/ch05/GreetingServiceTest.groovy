package com.groovy.ch05

import spock.lang.Specification

class GreetingServiceTest extends Specification {

    def "이름을 넣으면 인사 메시지를 반환한다"() {
        given:
        def service = new GreetingService()

        when:
        def result = service.greet("이채")

        then:
        result == "Hello 이채!"
    }
}
