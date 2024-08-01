class RAM : Memory() {
    override fun write(position: Int, value: Byte) {
        this.data[position] = value
    }

    override fun loadROM() { return }
}