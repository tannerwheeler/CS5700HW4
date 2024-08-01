package instructions

import CPU
import Display
import Memory

class Write(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)
        mySplit.add(tempHolder1.second)

        require(byte2 == 0.toUByte()) { "Second Byte is not 00 in Write Instruction" }
    }

    override fun perform() {
        require(mySplit[0] == 4u) { "First 4 bits of first byte must be 4" }
        memory[cpu.memory.toInt()].write(cpu.address.toInt(), cpu.registers[mySplit[1].toInt()])
    }
}