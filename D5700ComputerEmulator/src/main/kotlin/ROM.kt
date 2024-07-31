class ROM : Memory() {
    override fun write(position: UInt, value: UByte) {
        TODO("Not yet implemented")
    }

    fun loadROM() {
        println("Type in the path to the rom file:")
        val path = readLine()
        //TODO: Finish loading
    }
}