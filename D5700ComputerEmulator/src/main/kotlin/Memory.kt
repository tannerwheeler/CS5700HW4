abstract class Memory {
    protected val data = Array<UByte>(4000) { 0u }

    fun read(position: Int): UByte {
        return this.data[position]
    }

    abstract fun write(position: Int, value: UByte)
    abstract fun loadROM()
}