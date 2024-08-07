package instructionsTest

import CPU
import Display
import RAM
import ROM
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import instructions.Add
import kotlin.test.assertFailsWith

class AddTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)

    @Test
    fun testAddBasic() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val add = Add(cpu, array, display)
        add.execute("10", "10")
        assertEquals(5u, cpu.registers[0])
    }

    @Test
    fun testAddWithThreeRegisters() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val add = Add(cpu, array, display)
        add.execute("17", "10")
        assertEquals(3u, cpu.registers[0])
    }

    @Test
    fun testBadRegisterNumber0() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val add = Add(cpu, array, display)
        val block: () -> Unit = { add.execute("X0", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadRegisterNumber1() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val add = Add(cpu, array, display)
        val block: () -> Unit = { add.execute("XF0", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadAddition2() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val add = Add(cpu, array, display)
        val block: () -> Unit = { add.execute("20", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBRegister() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val add = Add(cpu, array, display)
        val block: () -> Unit = { add.execute("1A", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBRegister2() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val add = Add(cpu, array, display)
        val block: () -> Unit = { add.execute("10", "A0") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBRegister3() {
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val add = Add(cpu, array, display)
        val block: () -> Unit = { add.execute("10", "1A") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}