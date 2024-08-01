package instructions

import CPU
import Display
import Memory

abstract class Instruction (
    val cpu: CPU,
    val memory: Array<Memory>,
    val display: Display
){
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