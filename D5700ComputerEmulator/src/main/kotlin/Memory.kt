abstract class Memory {
    protected val data = Array<Byte>(4000) { 0 }

    fun read(position: Int): Byte {
        return this.data[position]
    }

    abstract fun write(position: Int, value: Byte)
    abstract fun loadROM()
}