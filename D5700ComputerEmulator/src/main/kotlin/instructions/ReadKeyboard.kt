package instructions

import CPU
import Display
import Memory
import java.lang.IllegalArgumentException

class ReadKeyboard(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {

    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)
        mySplit.add(tempHolder1.second)

        require(byte2 == 0.toUByte()) { "Second Byte is not 00 in ReadKeyboard Instruction" }

        require(checkRegister(tempHolder1.second.toString())) {"Invalid register: ${tempHolder1.second}"}
    }

    override fun perform() {
        require(mySplit[0] == 6u) { "First 4 bits of first byte must be 6 in ReadKeyboard Instruction" }
        println("Get input:")
        val input = readlnOrNull()
        if (checkHex(input)) {
            if (input == null) {
                cpu.registers[mySplit[1].toInt()] = 0u
            } else {
                val chunkedInput = input.chunked(2)
                cpu.registers[mySplit[1].toInt()] = chunkedInput[0].toUByte(16)
            }
        } else {
            Exit(this.cpu, this.memory, this.display).execute("00","00")
            throw IllegalArgumentException("The value in register ${cpu.registers[mySplit[1].toInt()]} is greater than 7F or 127.")
        }
        return
    }
}