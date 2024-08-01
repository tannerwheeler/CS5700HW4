package instructionsTest

import CPU
import Display
import RAM
import ROM
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import instructions.SkipNotEqual
import kotlin.test.assertFailsWith

class SkipNotEqualTest {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val skipNotEqual = SkipNotEqual(cpu, array, display)

    @Test
    fun testSkipNotEqual() {
        assertEquals(0u, cpu.program_counter)
        cpu.registers[1] = 10
        cpu.registers[2] = 20
        skipNotEqual.execute("91", "20")
        assertEquals(4u, cpu.program_counter)
        cpu.registers[1] = 20
        skipNotEqual.execute("91", "20")
        assertEquals(6u, cpu.program_counter)
    }

    @Test
    fun testBadSkipEqualTest() {
        val block: () -> Unit = { skipNotEqual.execute("90", "01") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadSkipEqual2Test() {
        val block: () -> Unit = { skipNotEqual.execute("70", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}