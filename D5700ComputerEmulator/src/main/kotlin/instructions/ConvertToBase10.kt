package instructions

import CPU
import Display
import Memory

class ConvertToBase10(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        val tempHolder1 = splitByte(byte1)
        mySplit.add(tempHolder1.first)
        mySplit.add(tempHolder1.second)

        require(byte2 == 0.toUByte()) { "Second Byte is not 00 in ConvertToBase10 Instruction" }
    }

    override fun perform() {
        require(mySplit[0] == 13u) { "First 4 bits of first byte must be D in ConvertToBase10 Instruction" }
        var needsConversion : Int = cpu.registers[mySplit[1].toInt()].toInt()
        memory[cpu.memory.toInt()].write(cpu.address.toInt() + 2, (needsConversion % 10).toUByte())
        needsConversion /= 10
        memory[cpu.memory.toInt()].write(cpu.address.toInt() + 1, (needsConversion % 10).toUByte())
        needsConversion /= 10
        memory[cpu.memory.toInt()].write(cpu.address.toInt(), (needsConversion % 10).toUByte())
    }
}