
class D5700Computer {
    private var memory = arrayOf(RAM(), ROM())
    private var display = Display()
    private var cpu: CPU = CPU(memory, display)

    fun start() {
        this.memory[1].loadROM()
        this.cpu.startEmulation()
    }
}