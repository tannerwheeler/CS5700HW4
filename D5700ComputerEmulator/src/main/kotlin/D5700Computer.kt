import instructions.*

class D5700Computer {
    private var cpu: CPU = CPU()
    private var memories = arrayOf(RAM(), ROM())
    private var display = Display()
    private val instructions = arrayOf(
        Store(this.cpu, this.memories, this.display),
        Add(this.cpu, this.memories, this.display),
        Sub(this.cpu, this.memories, this.display),
        Read(this.cpu, this.memories, this.display),
        Write(this.cpu, this.memories, this.display),
        Jump(this.cpu, this.memories, this.display),
        ReadKeyboard(this.cpu, this.memories, this.display),
        SwitchMemory(this.cpu, this.memories, this.display),
        SkipEqual(this.cpu, this.memories, this.display),
        SetA(this.cpu, this.memories, this.display),
        SetT(this.cpu, this.memories, this.display),
        ReadT(this.cpu, this.memories, this.display),
        ConvertToBase10(this.cpu, this.memories, this.display),
        ConvertByteToASCII(this.cpu, this.memories, this.display),
        Draw(this.cpu, this.memories, this.display)
    )

    fun start() {
        memories[1].loadROM()
    }
}