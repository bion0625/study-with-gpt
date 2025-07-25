
// function
def greet(String name) {
    return "Hello, $name"
}

println greet('Groovy')

def square(n) {
    n * n
}

// closer
def shout = { word ->
    println word.toUpperCase()
}
shout('groovy')

def printer = { println it }
printer('Hello!')


// high function
def list = [1, 2, 3, 4, 5]
def doubled = list.collect {it * 2}
println doubled


// sample

// function
def add(a, b) {
    a + b
}

def greeter = { name ->
    "Hello, $name!"
}

println add(2, 3)
println greeter('Groovy')


// homework

// 1
def greetCustom = { name ->
    "Hi! $name"
}
println greetCustom('lietzsche')

// 2
def fq = {n -> n*n}
println fq(3)

// 3
def myList = [1, 2, 3, 4, 5]
println myList.collect{ it * 10 }
println myList.findAll {it % 2 == 0}