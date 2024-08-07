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
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val convertByteToASCII = ConvertByteToASCII(cpu, array, display)

    @Test
    fun testConvertByteToASCII() {
        cpu.registers[0] = 12u
        convertByteToASCII.execute("E0","10")
        assertEquals(67u,cpu.registers[1])
    }

    @Test
    fun testBadConvertByteToASCII() {
        cpu.registers[0] = 17u
        val block: () -> Unit = { convertByteToASCII.execute("E0", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadConvertByteToASCII2() {
        cpu.registers[0] = 12u
        val block: () -> Unit = { convertByteToASCII.execute("D0", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadConvertByteToASCII3() {
        cpu.registers[0] = 12u
        val block: () -> Unit = { convertByteToASCII.execute("E0", "11") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadConvertByteToASCII4() {
        cpu.registers[0] = 12u
        val block: () -> Unit = { convertByteToASCII.execute("E9", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadConvertByteToASCII5() {
        cpu.registers[0] = 12u
        val block: () -> Unit = { convertByteToASCII.execute("E0", "90") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}