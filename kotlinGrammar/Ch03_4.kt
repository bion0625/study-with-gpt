

// sample: DSL like HTML

class HtmlBuilder {
    private val children = mutableListOf<String>()

    fun div(content: String) {
        children.add("<div>$content</div>")
    }

    fun build(): String = children.joinToString("\n")
}

fun html(init: HtmlBuilder.() -> Unit): String {
    val builder = HtmlBuilder()
    builder.init()
    return builder.build()
}

//fun main() {
//    val result = html {
//        div("hello")
//        div("world")
//    }
//    println(result)
//}


// homework

data class Robot(val name: String, val moves: List<String>)

class RobotBuilder {
    private val actions = mutableListOf<String>()

    var name: String = "Unknown"

    fun move(action: String) {
        actions.add(action)
    }

    fun build(): Robot {
        return Robot(name, actions)
    }
}

fun robot(init: RobotBuilder.() -> Unit): Robot {
    val builder = RobotBuilder()
    builder.init()
    return builder.build()
}

fun main() {
    val result = robot {
        name = "Robot1"
        move("forward")
        move("left")
    }
    println(result)
}