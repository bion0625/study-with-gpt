import java.util.regex.Matcher

// GString
def name = "lietzsche"
def age = 33
println "My name is $name and i am $age years old"


// Regex
def text = 'groovy123'
def pattern = /groovy\d+/

println text ==~ pattern
println text =~ pattern


// Get Pattern
def s = 'user123@example.com'
def matcher = s =~ /(\w+)@(\w+\.\w+)/
if (matcher.matches()) {
    println matcher[0][1]
    println matcher[0][2]
}


// sample
def language = 'Groovy'
println "I love $language"

def phone = "010-1234-5678"
if (phone ==~ /\d{3}-\d{4}-\d{4}/) {
    println "Valid phone number"
}


// homework

// 1
def myName = 'lietzsche'
def job = 'developer'
println "Hello, I am [$myName] and I work as [$job]"

// 2
def email = "id@domain.com"
if (email ==~ /(\w+)@(\w+\.\w+)/) {
    println "Valid email"
}

// 3
def d = '2025-07-25'
def m = d =~ /(\d{4})-(\d{2})-(\d{2})/
println "${m[0][1]}, ${m[0][2]}, ${m[0][3]}"