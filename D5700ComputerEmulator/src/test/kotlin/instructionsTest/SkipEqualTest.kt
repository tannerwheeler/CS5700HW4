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
        cpu.registers[1] = 10
        cpu.registers[2] = 20
        skipEqual.execute("81".toUByte(16), "20".toUByte(16))
        assertEquals(2u, cpu.program_counter)
        cpu.registers[1] = 20
        skipEqual.execute("81".toUByte(16), "20".toUByte(16))
        assertEquals(6u, cpu.program_counter)
    }

    @Test
    fun testBadSkipEqualTest() {
        val block: () -> Unit = { skipEqual.execute("80".toUByte(16), "01".toUByte(16)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadSkipEqual2Test() {
        val block: () -> Unit = { skipEqual.execute("70".toUByte(16), "10".toUByte(16)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}