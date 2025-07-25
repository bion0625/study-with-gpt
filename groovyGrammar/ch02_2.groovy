
// Truthiness
if ("hello") println "not empty"
if ("") println "empty"
if ([]) println "not empty"


// Null-safe
def user = null
println user?.name

def name = ''
def result = name ?: 'Anonymous'
println result


// sample

def s = ''
if (!s) println '빈 문자열로 간주됨'

def list = []
println list ? "내용 있음" : "빈 리스트"

//null-safe navigation
def person = null
println person?.name

// Elvis
def nickname = ''
println nickname ?: 'Default'


// homework

// 1
if ('') println 'test1.1'
if ([]) println 'test1.2'
if (null) println 'test1.3'

// 2
def k = null
println k?.name ? k?.name : 'test2'

// 3
println k?.nickname ?: 'Anonymous'
