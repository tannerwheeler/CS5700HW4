package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Read
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReadTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val read = Read(cpu, array, display)

    @Test
    fun testReadBasic() {
        cpu.address = 30u
        cpu.memory = 0u
        array[0].write(cpu.address.toInt(), 10u)
        read.execute("37", "00")
        assertEquals(10.toUByte(), cpu.registers[7])
    }

    @Test
    fun testReadROM() {
        cpu.address = 30u
        cpu.memory = 1u
        array[0].write(cpu.address.toInt(), 10u)
        read.execute("37", "00")
        assertEquals(0.toUByte(), cpu.registers[7])
    }
}