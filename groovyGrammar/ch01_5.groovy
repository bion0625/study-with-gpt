
// class
class Person {
    String name
    int age

    def sayHello() {
        "Hi, I'm $name and I'm $age years old."
    }
}

def p = new Person(name: "lietzsche", age: 33)
println p.sayHello()

p.name = "Nietzsche"
println p.name
println p.getName()


// sample

class Book {
    String title
    String author
}

def b = new Book(title: "Groovy in Action", author: "Paul King")
println "${b.title} by ${b.author}"


// homework

class Car {
    String brand
    String model
    int year

    def getInfo() {
        "Brand: $brand, Model: $model, Year: $year"
    }
}

def car = new Car()
car.brand = '현대'
car.model = '아반떼'
car.year = 2023

println car.getInfo()
println car.info