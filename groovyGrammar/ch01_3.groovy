
// if
def age = 20

if (age >= 10) {
    println "Adult"
} else {
    println "Minor"
}

// switch
def lang = 'Groovy'

switch(lang) {
    case "Groovy":
        println "Dynamic!"
        break
    case "Java":
        println "Verbose!"
        break
    default:
        println "Unknown!"
}

// for
for (i in 0..4) {
    println i
}

def fruits = ['apple', 'banana', 'mango']
for(f in fruits) {
    println f
}

// while
def n = 3
while(n > 0) {
    println n
    n--
}


// sample

def score = 85

if (score >= 90) {
    println "A"
} else if (score >= 80) {
    println "B"
} else println "C"

def animals = ['dog', 'cat', 'bird']
for (a in animals) {
    println a
}


// homework

// 1
def newAge = 30

if (newAge >= 20) println "성인"
else println "미성년자"

// 2
def newLang = 'Groovy'

switch(newLang) {
    case 'Groovy':
        println "my name is groovy!"
        break
    case 'Java':
        println "my name is secret JAVA!! Good! I like my name!!!!!"
        break
    case 'Python':
        println "This is not my place! I'm python!"
        break
    default:
        println "I'm busy!"
}

// 3
def sum = 0
for (i in 1..5) {
    sum += i
}
println sum

// 4
def fruitList = ['apple', 'banana', 'kiwi']
for (item in fruitList) {
    println item.toUpperCase()
}