package meteor.plugins.AIOCrabPlugin.constants

enum class StateController(
    val boolean: Boolean = false
) {
    ZERO(true) {
        override fun nextState(): StateController = ONE
    },
    ONE(false) {
        override fun nextState(): StateController = TWO
    },
    TWO(false) {
        override fun nextState(): StateController = THREE
    },
    THREE(false){
        override fun nextState(): StateController = FOUR
    },
    FOUR(false){
        override fun nextState(): StateController = FIVE
    },
    FIVE(false){
        override fun nextState(): StateController = SIX
    },
    SIX(false){
        override fun nextState(): StateController {
            print("can't get the next state of the last state. restart the enumerator!") /** @see restartState()*/
            return SIX
        }
    };

    abstract fun nextState(): StateController
    fun restartState(): StateController {
        return ZERO
    }
}