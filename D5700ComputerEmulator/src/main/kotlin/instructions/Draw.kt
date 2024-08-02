package instructions

import CPU
import Display
import Memory
import UByteToHexConverter

class Draw(
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
        require(mySplit[0] == 15u) { "First 4 bits of first byte must be F for Draw Instruction." }
        require((mySplit[2].toInt() in 0..7)
                && (mySplit[3].toInt() in 0..7)) {
            "Location for Draw is not on the screen. Screen size = 8x8." }

        if (cpu.registers[mySplit[1].toInt()] > 127u) {
            error("The value in register ${cpu.registers[mySplit[1].toInt()]} is greater than 7F or 127.")
        } else {
            val value = Char(cpu.registers[mySplit[1].toInt()].toInt()).toString()
            display.changeDisplay(value,
                mySplit[2].toInt(), mySplit[3].toInt())
        }
    }
}