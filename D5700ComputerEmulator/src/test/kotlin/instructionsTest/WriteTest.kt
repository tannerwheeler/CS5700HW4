package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Write
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class WriteTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val write = Write(cpu, array, display)

    @Test
    fun testWriteRAM() {
        cpu.address = 30u
        cpu.memory = 0u
        cpu.registers[7] = 10u
        write.execute("47", "00")
        assertEquals(10.toUByte(), array[cpu.memory.toInt()].read(cpu.address.toInt()))
    }

    @Test
    fun testWriteROM() {
        cpu.address = 30u
        cpu.memory = 1u
        cpu.registers[7] = 10u
        val block: () -> Unit = { write.execute("47", "00") }
        assertFailsWith<UnsupportedOperationException> { block() }
    }

    @Test
    fun testWriteBadCall() {
        cpu.address = 30u
        cpu.memory = 0u
        cpu.registers[7] = 10u
        val block: () -> Unit = { write.execute("4A", "00") }
        assertFailsWith<IllegalArgumentException> { block() }
    }


}