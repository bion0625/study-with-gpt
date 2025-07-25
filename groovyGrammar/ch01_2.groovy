
// list
def list = [1, 2, 3, 4]
println list[0]
println list.size()
list << 5
list += 6
println list


// map
def map = [name: "Groovy", version: 4]
println map["name"]
println map.version
map.language = "dynamic"
println map


// sample

def numbers = [1, 2, 3]
numbers << 4
numbers += [5, 6]

def user = [id: 1, name: "lietzsche"]
user.age = 33

println numbers
println user


// homework

def fruits = ["apple", "banana", "kiwi"]
println fruits

fruits << "mango"
fruits.remove("kiwi")
println fruits

def person = [name: "lietzsche", age: 33, job: "developer"]
println person

person.age += 1
println person