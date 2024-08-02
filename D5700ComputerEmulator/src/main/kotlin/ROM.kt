import java.nio.file.Files
import java.nio.file.Paths

class ROM : Memory() {
    override fun write(position: Int, value: UByte) {
        //TODO("Not yet implemented")
    }

    override fun loadROM() {
        println("Type in the path to the rom file:")
        val path = readln()
        var position = 0
        val path2 = Paths.get(path)
        val bytes = Files.readAllBytes(path2)
        bytes.forEach {
            data[position] = it.toUByte()
            position ++
        }
    }
}