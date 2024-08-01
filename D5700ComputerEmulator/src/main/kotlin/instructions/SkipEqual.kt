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
        TODO("Not yet implemented")
    }

    override fun perform() {
        var areEqual = false

        TODO("Not yet implemented")

        if (areEqual) {
            increment()
        }
    }
}