

// Expando
def user = new Expando()
user.name = 'Groovy'
user.sayHello = {"Hello, I'm $user.name"}

println user.sayHello()


// MetaClass
String.metaClass.shout = { -> delegate.toUpperCase() + '!!!' }

println 'groovy'.shout()


// methodMissing
class DynamicCaller {
    def methodMissing(String name, args) {
        return "You tried to call '$name' with args: $args"
    }
}

def dyn = new DynamicCaller()
println dyn.hello('Groovy')



// homework

def person = new Expando()
person.name = 'Alice'
person.greet = { "Hi, I'm $person.name" }

println person.greet()