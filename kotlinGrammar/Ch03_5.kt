


// sample

data class RealUser(val name: String, val age: Int)

class RealUserBuilder {
    var name: String = ""
    var age: Int = 0

    fun build(): RealUser = RealUser(name, age)
}

fun user(init: RealUserBuilder.() -> Unit): RealUser {
    val builder = RealUserBuilder()
    builder.init()
    return builder.build()
}

//fun main() {
//    val u = user {
//        name = "Alice"
//        age = 30
//    }
//    println(u)
//}



// homework

data class Body(val text: String, val footer: String)

class BodyBuilder {
    var text: String = ""
    var footer: String = ""

    fun build(): Body = Body(text, footer)
}

data class EmailMessage(val from: String, val to: String, val subject: String, val body: Body)

class EmailMessageBuilder {
    var from: String = ""
    var to: String = ""
    var subject: String = ""
    private var _body: Body = Body("", "")

    fun body(init: BodyBuilder.() -> Unit) {
        this._body = BodyBuilder().apply(init).build()
    }


    fun build(): EmailMessage = EmailMessage(from, to, subject, _body)
}

fun emailMessage(init: EmailMessageBuilder.() -> Unit): EmailMessage {
    val builder = EmailMessageBuilder()
    builder.init()
    return builder.build()
}

fun main() {
    val emailMessage = emailMessage {
        from = "me@test.com"
        to = "you@test.com"
        subject = "Hi"
        body {
            text = "Nice to meet you"
            footer = "Sent by Kotlin"
        }
    }
    println(emailMessage)
}