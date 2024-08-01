package instructions

import CPU
import Display
import Memory
import java.util.*

abstract class Instruction (
    protected val cpu: CPU,
    protected val memory: Array<Memory>,
    protected val display: Display
){
    protected var byte1 : UByte = 0u
    protected var byte2 : UByte = 0u
    protected var mySplit : MutableList<UInt> = mutableListOf()

    fun checkHex(string: String?): Boolean {
        if (string == null) {
            return true
        }

        val uppercaseString = string.uppercase(Locale.getDefault())
        uppercaseString.forEach {
            if ((it < '0' || it > '9')
                && (it < 'A' || it > 'F')) {
                return false
            }
        }
        return true
    }

    fun execute(byte1: String, byte2: String) {
        require(checkHex(byte1)) { "Error in Execute: Byte 1 must be a hex string." }
        require(checkHex(byte2)) { "Error in Execute: Byte 1 must be a hex string." }
        require(byte1.length == 2) { "Error in Execute: This must be only a hex Byte" }
        require(byte2.length == 2) { "Error in Execute: This must be only a hex Byte" }

        this.byte1 = byte1.toUByte(16)
        this.byte2 = byte2.toUByte(16)
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

    protected fun splitByte(byte: UByte) : Pair<UInt,UInt> {
        var first : UInt = byte.toUInt()
        var second : UInt = byte.toUInt()
        first = first shr 4
        second = second and 15u
        return Pair(first, second)
    }

    open fun incrementCheck() : Boolean {
        return true
    }
}