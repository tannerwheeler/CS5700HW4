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
        require(this.byte1 == 0.toUByte() && this.byte2 == 0.toUByte()) {
            "Exit instruction execute method can only be called with '00' and '00'."
        }
        this.cpu.stopEmulation()
    }

    override fun incrementCheck(): Boolean {
        return false
    }
}