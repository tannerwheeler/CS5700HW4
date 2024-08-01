package instructions

import CPU
import Display
import Memory

class Jump(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)

        var secondHalf = tempHolder1.second
        secondHalf = secondHalf shl 8
        mySplit.add(secondHalf or byte2.toUInt())
    }

    override fun perform() {
        require(mySplit[0] == 5u) { "First 4 bits of the first byte must be 5" }
        cpu.program_counter = mySplit[1].toUShort()
    }

    override fun incrementCheck() : Boolean {
        return false
    }
}