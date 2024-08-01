package instructions

import CPU
import Display
import Memory
import java.util.*

class ReadKeyboard(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {

    public fun checkHex(string: String?): Boolean {
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

    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)
        mySplit.add(tempHolder1.second)

        require(byte2 == 0.toUByte()) { "Second Byte is not 00 in ReadKeyboard Instruction" }
    }

    override fun perform() {
        require(mySplit[0] == 6u) { "First 4 bits of first byte must be 6 in ReadKeyboard Instruction" }
        val input = readlnOrNull()
        if (checkHex(input)) {
            if (input == null) {
                cpu.registers[mySplit[1].toInt()] = 0
            } else {
                val chunkedInput = input.chunked(2)
                cpu.registers[mySplit[1].toInt()] = chunkedInput[0].toByte(16)
            }
        }
        return
    }
}