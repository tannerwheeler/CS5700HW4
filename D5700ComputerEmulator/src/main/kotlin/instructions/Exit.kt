package instructions

import CPU
import Display
import Memory

class Exit(
    cpu: CPU,
    memory: Array<Memory>,
    display: Display
) : Instruction(cpu, memory, display) {
    override fun split() {
    }

    override fun perform() {
        this.cpu.stopEmulation()
    }

    override fun incrementCheck(): Boolean {
        return false
    }
}