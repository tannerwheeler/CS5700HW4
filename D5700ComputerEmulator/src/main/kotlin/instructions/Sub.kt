package instructions

import CPU
import Display
import Memory

class Sub(
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
    }

    override fun perform() {
        require(mySplit[0] == 2u)
        val newValue = cpu.registers[mySplit[1].toInt()] - cpu.registers[mySplit[2].toInt()]
        cpu.registers[mySplit[3].toInt()] = newValue.toByte()
        mySplit.clear()
    }
}