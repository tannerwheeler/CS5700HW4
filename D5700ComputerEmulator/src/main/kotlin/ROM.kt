import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

class ROM : Memory() {
    override fun write(position: Int, value: UByte) {
        //TODO("Not yet implemented")
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun loadROM() {
        println("Type in the path to the rom file:")
        val path = readln()
        var position = 0
        val path2 = Paths.get(path)
        val newData = Files.readAllBytes(path2).toUByteArray()
        newData.forEach {
            println(it)
        }

//        File(path).forEachLine {
//            val bytes = it.chunked(2)
//            data[position] = bytes[0].toUByte(16)
//            data[position + 1] = bytes[1].toUByte(16)
//            position += 2
//        }
    }
}