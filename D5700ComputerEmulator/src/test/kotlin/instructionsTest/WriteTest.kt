package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Write
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WriteTest {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val write = Write(cpu, array, display)

    @Test
    fun testWriteRAM() {
        cpu.address = 30u
        cpu.memory = 0u
        cpu.registers[7] = 10u
        write.execute("47", "00")
        assertEquals(10u, array[0].read(cpu.address.toInt()))
    }

    @Test
    fun testWriteROM() {
        cpu.address = 30u
        cpu.memory = 1u
        cpu.registers[7] = 10u
        write.execute("47", "00")
        assertEquals(0, array[0].read(cpu.address.toInt()))
    }
}