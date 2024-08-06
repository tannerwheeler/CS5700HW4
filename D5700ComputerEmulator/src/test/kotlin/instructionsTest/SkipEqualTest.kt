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
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val skipEqual = SkipEqual(cpu, array, display)

    @Test
    fun testSkipEqual() {
        assertEquals(0u, cpu.programCounter)
        cpu.registers[1] = 10u
        cpu.registers[2] = 20u
        skipEqual.execute("81", "20")
        assertEquals(2u, cpu.programCounter)
        cpu.registers[1] = 20u
        skipEqual.execute("81", "20")
        assertEquals(6u, cpu.programCounter)
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