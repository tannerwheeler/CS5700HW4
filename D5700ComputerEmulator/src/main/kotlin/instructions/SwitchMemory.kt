package instructions

import CPU
import Display
import Memory

class SwitchMemory(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)
        require(tempHolder1.second == 0u) { "Last 12 bits must be 0 in Switch Memory Instruction" }

        val tempHolder2 = splitByte(byte2)
        require(tempHolder2.first == 0u) { "Last 12 bits must be 0 in Switch Memory Instruction" }
        require(tempHolder2.second == 0u) { "Last 12 bits must be 0 in Switch Memory Instruction" }
    }

    override fun perform() {
        require(mySplit[0] == 7u) { "First 4 bits of the first byte must be 7" }
        if (cpu.memory == 1u)
            cpu.memory = 0u
        else
            cpu.memory = 1u
    }
}