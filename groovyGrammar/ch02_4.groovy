
// sample

def divide(a, b) {
    try {
        return a / b
    } catch (e) {
        println "예외 발생: ${e.message}"
        return 0
    }
}

println divide(10, 2)
println divide(10, 0)


// homework

// 1
def newDivide(a, b) {
    try {
        return a / b
    } catch (e) {
        println "0으로 나눌 수 없습니다."
        return 0
    }
}

println newDivide(10, 0)

// 2
try {
    Integer.parseInt("123abc")
} catch (e) {
    println "숫자로 변환할 수 없습니다."
} finally {
    println "처리 완료"
}