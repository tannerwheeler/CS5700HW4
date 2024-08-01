package instructions

import CPU
import Display
import Memory

class Store(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        val tempHolder = splitByte(byte1)
        mySplit.add(tempHolder.first)
        mySplit.add(tempHolder.second)
        mySplit.add(byte2.toUInt())
    }

    override fun perform() {
        require(mySplit[0] == 0u) { "First 4 bits of first byte must be 0 for Store Instruction." }
        cpu.registers[mySplit[1].toInt()] = mySplit[2].toUByte()
    }
}