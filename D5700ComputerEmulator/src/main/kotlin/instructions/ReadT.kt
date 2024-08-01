package instructions

import CPU
import Display
import Memory

class ReadT(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)
        mySplit.add(tempHolder1.second)

        require(byte2 == 0.toUByte()) { "Second Byte is not 00 in ReadT Instruction" }
    }

    override fun perform() {
        require(mySplit[0] == 12u) { "First 4 bits of first byte must be C in ReadT Instruction" }
        cpu.registers[mySplit[1].toInt()] = cpu.timer.toByte()
    }
}