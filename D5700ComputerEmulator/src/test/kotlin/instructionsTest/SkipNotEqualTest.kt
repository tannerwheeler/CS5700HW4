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
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val skipNotEqual = SkipNotEqual(cpu, array, display)

    @Test
    fun testSkipNotEqual() {
        assertEquals(0u, cpu.programCounter)
        cpu.registers[1] = 10u
        cpu.registers[2] = 20u
        skipNotEqual.execute("91", "20")
        assertEquals(4u, cpu.programCounter)
        cpu.registers[1] = 20u
        skipNotEqual.execute("91", "20")
        assertEquals(6u, cpu.programCounter)
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

    @Test
    fun testBadSkipEqual3Test() {
        val block: () -> Unit = { skipNotEqual.execute("9F", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadSkipEqual4Test() {
        val block: () -> Unit = { skipNotEqual.execute("91", "D0") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}