package instructionsTest

import CPU
import ROM
import RAM
import Display
import instructions.ConvertByteToASCII
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ConvertByteToASCIITest {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val convertByteToASCII = ConvertByteToASCII(cpu, array, display)

    @Test
    fun testConvertByteToASCII() {
        cpu.registers[0] = 12
        convertByteToASCII.execute("E0","10")
        assertEquals(12,cpu.registers[1])
    }

    @Test
    fun testBadConvertByteToASCII() {
        cpu.registers[0] = 17
        val block: () -> Unit = { convertByteToASCII.execute("E0", "10") }
        assertFailsWith<IllegalStateException> { block() }
    }

    @Test
    fun testBadConvertByteToASCII2() {
        cpu.registers[0] = 12
        val block: () -> Unit = { convertByteToASCII.execute("D0", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadConvertByteToASCII3() {
        cpu.registers[0] = 12
        val block: () -> Unit = { convertByteToASCII.execute("E0", "11") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}