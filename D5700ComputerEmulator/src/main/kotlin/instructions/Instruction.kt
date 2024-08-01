package instructions

import CPU
import Display
import Memory

abstract class Instruction (
    protected val cpu: CPU,
    protected val memory: Array<Memory>,
    protected val display: Display
){
    protected var byte1 : UByte = 0u
    protected var byte2 : UByte = 0u
    protected var mySplit : MutableList<UInt> = mutableListOf()

    fun execute(byte1: UByte, byte2: UByte) {
        this.byte1 = byte1
        this.byte2 = byte2
        split()
        perform()
        if (incrementCheck()) {
            increment()
        }
        mySplit.clear()
    }

    protected abstract fun split()
    protected abstract fun perform()
    protected fun increment() {
        cpu.program_counter = (cpu.program_counter + 2u).toUShort()
    }

    open fun incrementCheck() : Boolean {
        return true
    }

    protected fun splitByte(byte: UByte) : Pair<UInt,UInt> {
        var first : UInt = byte.toUInt()
        var second : UInt = byte.toUInt()
        first = first shr 4
        second = second and 15u
        return Pair(first, second)
    }
}