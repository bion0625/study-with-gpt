class Point {
    int x, y

    Point plus(Point other) {
        new Point(x: this.x + other.x, y: this.y + other.y)
    }

    String toString() {
        "($x, $y)"
    }
}

def p1 = new Point(x: 1, y: 2)
def p2 = new Point(x: 3, y: 4)
def p3 = p1 + p2

println p3

// homework

class Money {
    BigDecimal amount

    Money plus(Money other) {
        return new Money(amount: this.amount + other.amount)
    }

    String toString() {
        "₩$amount"
    }
}

def m1 = new Money(amount: 1000)
def m2 = new Money(amount: 2000)
def m3 = m1 + m2

println m3