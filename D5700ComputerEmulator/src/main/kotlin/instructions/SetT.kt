package instructions

import CPU
import Display
import Memory

class SetT(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)

        val tempHolder2 = splitByte(byte2)
        require(tempHolder2.second == 0u) { "Last 4 bits of second byte must be 0 for SetT Instruction" }

        val secondHalf = tempHolder1.second shl 4
        mySplit.add(secondHalf or tempHolder2.first)
    }

    override fun perform() {
        require(mySplit[0] == 11u) { "First 4 bits of first byte must be B for SetT Instruction" }
        cpu.timer = mySplit[1].toUByte()
    }
}