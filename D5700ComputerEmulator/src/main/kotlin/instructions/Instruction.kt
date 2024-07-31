package instructions

abstract class Instruction {
    fun execute(byte1: UByte, byte2: UByte) {
        split()
        perform()
        if (incrementCheck()) {
            increment()
        }
    }

    protected abstract fun split()
    protected abstract fun perform()
    protected fun increment() {

    }

    open fun incrementCheck() : Boolean {
        return true
    }
}