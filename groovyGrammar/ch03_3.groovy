import groovy.transform.CompileStatic

def service = new Ch03_3_MyJavaService()
println service.hello('Groovy')

@CompileStatic
class Test {
    static void main(String[] args) {
        def myJavaService = new Ch03_3_MyJavaService()
        println myJavaService.hello('이채')
    }
}

// homework
def s = new Ch03_3_KoreanHelloService()
println s.sayHi("이채")