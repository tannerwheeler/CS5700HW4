package instructions

import CPU
import Display
import Memory

class SkipEqual(
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
        require(tempHolder2.second == 0u) { "The last 4 bits must be 0 in SkipEqual Instruction." }

        require(checkRegister(tempHolder1.second.toString())) {"Invalid register: ${tempHolder1.second}"}
        require(checkRegister(tempHolder2.first.toString())) {"Invalid register: ${tempHolder2.first}"}
    }

    override fun perform() {
        var areEqual = false

        require(mySplit[0] == 8u) { "First 4 bits of first byte must be 8 in SkipEqual Instruction" }
        areEqual = cpu.registers[mySplit[1].toInt()] == cpu.registers[mySplit[2].toInt()]
        if (areEqual) {
            increment()
        }
    }
}