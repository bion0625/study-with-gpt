package ch03


// sample

interface State {
    fun signal(): State
}

enum class TrafficLight: State {
    RED {
        override fun signal(): State = GREEN
    },
    GREEN {
        override fun signal(): State = YELLOW
    },
    YELLOW {
        override fun signal(): State = RED
    }
}

fun runTrafficLight(start: State, count: Int) {
    var current = start
    repeat(count) {
        println("현재상태: ${current}")
        current = current.signal()
    }
}



// homework

interface CharacterState {
    fun walk(): CharacterState
    fun attack(): CharacterState
    fun stop(): CharacterState
}

enum class GameState: CharacterState {
    IDLE {
        override fun walk() = WALKING
        override fun attack() = this
        override fun stop() = this
    },
    ATTACKING {
        override fun walk() = this
        override fun attack() = this
        override fun stop() = IDLE
    },
    WALKING {
        override fun walk() = this
        override fun attack() = ATTACKING
        override fun stop() = IDLE
    },
}



// optional homework

fun testStateMachine() {
    var state: CharacterState = GameState.IDLE

    println("Start: $state")
    state = state.walk()
    println("After walk: $state")
    state = state.attack()
    println("After attack: $state")
    state = state.stop()
    println("After stop: $state")
}