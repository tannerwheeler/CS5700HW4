abstract class Memory {
    protected val data = Array<UByte?>(4000) { null }

    fun read(position: UInt): UByte {
        return 0u //TODO("Finish implementing the read")
    }

    abstract fun write(position: UInt, value: UByte)
    abstract fun loadROM()
}