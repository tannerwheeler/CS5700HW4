package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Sub
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SubTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)

    @Test
    fun testSubBasic() {
        cpu.registers[0] = 3u
        cpu.registers[1] = 2u
        assertEquals(3u, cpu.registers[0])
        val sub = Sub(cpu, array, display)
        sub.execute("20", "10")
        assertEquals(1u, cpu.registers[0])
    }

    @Test
    fun testSubWithNegatives() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val sub = Sub(cpu, array, display)
        sub.execute("20", "10")
        assertEquals(255.toUByte(), cpu.registers[0])
    }

    @Test
    fun testSubWithThreeRegisters() {
        cpu.registers[0] = 10u
        cpu.registers[1] = 3u
        assertEquals(10u, cpu.registers[0])
        val sub = Sub(cpu, array, display)
        sub.execute("20", "17")
        assertEquals(7u, cpu.registers[7])
    }

    @Test
    fun testBadRegisterNumber0() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val sub = Sub(cpu, array, display)
        val block: () -> Unit = { sub.execute("29", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadRegisterNumber1() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val sub = Sub(cpu, array, display)
        val block: () -> Unit = { sub.execute("20", "90") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadRegisterNumber2() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val sub = Sub(cpu, array, display)
        val block: () -> Unit = { sub.execute("20", "19") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}