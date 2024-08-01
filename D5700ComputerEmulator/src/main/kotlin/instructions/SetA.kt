package instructions

import CPU
import Display
import Memory

class SetA(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)

        val secondHalf = tempHolder1.second shl 8
        mySplit.add(secondHalf or byte2.toUInt())
    }

    override fun perform() {
        require(mySplit[0] == 10u) { "First 4 bits of the first byte must be A in Jump Instruction" }
        cpu.address = mySplit[1].toUShort()
    }
}