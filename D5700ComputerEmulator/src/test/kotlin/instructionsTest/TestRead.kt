package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Read
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TestRead {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val read = Read(cpu, array, display)

    @Test
    fun testReadBasic() {
        cpu.address = 30u
        cpu.memory = 0u
        array[0].write(cpu.address.toInt(), 10)
        read.execute("37".toUByte(16), "00".toUByte(16))
        assertEquals(10, cpu.registers[7])
    }

    @Test
    fun testReadROM() {
        cpu.address = 30u
        cpu.memory = 1u
        array[0].write(cpu.address.toInt(), 10)
        read.execute("37".toUByte(16), "00".toUByte(16))
        assertEquals(0, cpu.registers[7])
    }
}