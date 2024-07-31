package instructions

abstract class Instruction {
    fun execute(byte1: UByte, byte2: UByte) {
        split()
        perform()
        increment()
    }

    protected abstract fun split()
    protected abstract fun perform()
    protected abstract fun increment()
}