

// homework

interface Animal {
    String speak()
}

class Dog implements Animal {
    @Override
    String speak() {
        "woof!"
    }
}

class Cat implements Animal {
    @Override
    String speak() {
        "Meow!"
    }
}

println new Dog().speak()
println new Cat().speak()

def animals = [new Dog(), new Cat()]
animals.each { println it.speak() }