package instructions

import CPU
import Display
import Memory

class Add(
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
        mySplit.add(tempHolder2.second)

        require(checkRegister(tempHolder1.second.toString())) {"Invalid register: ${tempHolder1.second}"}
        require(checkRegister(tempHolder2.first.toString())) {"Invalid register: ${tempHolder2.first}"}
        require(checkRegister(tempHolder2.second.toString())) {"Invalid register: ${tempHolder2.second}"}
    }

    override fun perform() {
        require(mySplit[0] == 1u) { "First 4 bits of first byte must be 1 for Add Instruction." }
        val newValue = cpu.registers[mySplit[1].toInt()] + cpu.registers[mySplit[2].toInt()]
        cpu.registers[mySplit[3].toInt()] = newValue.toUByte()
    }
}