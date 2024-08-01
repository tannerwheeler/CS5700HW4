class RAM : Memory() {
    override fun write(position: Int, value: UByte) {
        this.data[position] = value
    }

    override fun loadROM() { return }
}