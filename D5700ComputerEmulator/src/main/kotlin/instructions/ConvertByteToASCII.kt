package instructions

import CPU
import Display
import Memory
import java.util.IllegalFormatException

class ConvertByteToASCII(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)
        mySplit.add(tempHolder1.second)

        val tempHolder2 = splitByte(byte2)
        mySplit.add(tempHolder2.first)
        require(tempHolder2.second == 0u) { "The last 4 bits must be 0 in ConvertByteToASCII Instruction." }

        require(checkRegister(tempHolder1.second.toString())) {"Invalid register: ${tempHolder1.second}"}
        require(checkRegister(tempHolder2.first.toString())) {"Invalid register: ${tempHolder2.first}"}
    }

    override fun perform() {
        require(mySplit[0] == 14u) { "First 4 bits of first byte must be E in ConvertByteToASCII Instruction" }
        val wantedValue = cpu.registers[mySplit[1].toInt()].toInt().digitToChar().code.toByte().toUByte()

        if (wantedValue in 0u..127u) {
            cpu.registers[mySplit[2].toInt()] = wantedValue
        } else {
            Exit(this.cpu, this.memory, this.display).execute("00","00")
            throw IllegalArgumentException("The value stored in register ${mySplit[1].toInt()} is not base-16")
        }
    }
}