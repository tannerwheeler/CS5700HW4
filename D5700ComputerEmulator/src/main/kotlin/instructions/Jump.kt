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
        require(mySplit[0] == 5u) { "First 4 bits of the first byte must be 5 in Jump Instruction" }

        if ((mySplit[1].toInt() % 2) == 0) {
            cpu.programCounter = mySplit[1].toUShort()
        } else {
            Exit(this.cpu, this.memory, this.display).execute("00","00")
            throw IllegalArgumentException("The is not divisible by 2.")
        }
    }

    override fun incrementCheck() : Boolean {
        return false
    }
}