package instructionsTest

import CPU
import Display
import RAM
import ROM
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import instructions.SkipEqual
import kotlin.test.assertFailsWith

class SkipEqualTest {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val skipEqual = SkipEqual(cpu, array, display)

    @Test
    fun testSkipEqual() {
        assertEquals(0u, cpu.program_counter)
        cpu.registers[1] = 10u
        cpu.registers[2] = 20u
        skipEqual.execute("81", "20")
        assertEquals(2u, cpu.program_counter)
        cpu.registers[1] = 20u
        skipEqual.execute("81", "20")
        assertEquals(6u, cpu.program_counter)
    }

    @Test
    fun testBadSkipEqualTest() {
        val block: () -> Unit = { skipEqual.execute("80", "01") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadSkipEqual2Test() {
        val block: () -> Unit = { skipEqual.execute("70", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}