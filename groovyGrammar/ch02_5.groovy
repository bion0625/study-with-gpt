

// script
def name = 'Groovy'
println "Hello, $name"

class Hello {
    static void main(String[] args) {
        println "Hello from main!"
    }
}

//@Grab('org.jsoup:jsoup:1.13.1')
import org.jsoup.Jsoup

def doc = Jsoup.connect("https://www.naver.com").get()
println doc.title()


// sample

def a = 10
def b = 5
println "$a + $b = ${a + b}"


// homework

// 1
def myName = 'lietzsche'
def age = 33
println "My name is $myName and I'm $age"

// 2
def sayMyName = { n -> println "Hello, $n"}
sayMyName(myName)