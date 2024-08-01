import java.io.File

class ROM : Memory() {
    override fun write(position: Int, value: Byte) {
        //TODO("Not yet implemented")
    }

    override fun loadROM() {
        println("Type in the path to the rom file:")
        val path = readln()
        var position = 0
        File(path).forEachLine {
            val bytes = it.chunked(2)
            data[position] = bytes[0].toByte(16)
            data[position + 1] = bytes[1].toByte(16)
            position += 2
        }
    }
}