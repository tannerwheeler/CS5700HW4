package instructions

import CPU
import Display
import Memory

class ReadKeyboard(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
        TODO("Not yet implemented")
    }

    override fun perform() {
        TODO("Not yet implemented")
    }
}