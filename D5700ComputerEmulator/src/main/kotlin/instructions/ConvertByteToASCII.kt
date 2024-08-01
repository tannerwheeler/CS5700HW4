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
    }

    override fun perform() {
        require(mySplit[0] == 14u) { "First 4 bits of first byte must be E in ConvertByteToASCII Instruction" }
        val wantedValue = cpu.registers[mySplit[1].toInt()]

        if (wantedValue in 0..15) {
            cpu.registers[mySplit[2].toInt()] = wantedValue
        } else {
            error("The value stored in register ${mySplit[1].toInt()} is not base-16")
        }
    }
}