package instructionsTest

import CPU
import Display
import RAM
import ROM
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import instructions.Add

class AddTest {
    @Test
    fun testAddBasic() {
        val cpu = CPU()
        cpu.registers[0] = 2
        cpu.registers[1] = 3
        assertEquals(2, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val add = Add(cpu, array, display)
        add.execute("10", "10")
        assertEquals(5, cpu.registers[0])
    }

    @Test
    fun testAddWithNegatives() {
        val cpu = CPU()
        cpu.registers[0] = -2
        cpu.registers[1] = 3
        assertEquals(-2, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val add = Add(cpu, array, display)
        add.execute("10", "10")
        assertEquals(1, cpu.registers[0])
    }

    @Test
    fun testAddWithThreeRegisters() {
        val cpu = CPU()
        cpu.registers[0] = 2
        cpu.registers[1] = 3
        assertEquals(2, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val add = Add(cpu, array, display)
        add.execute("17", "10")
        assertEquals(3, cpu.registers[0])
    }

    @Test
    fun testBadRegisterNumber0() {
        //TODO: Finish writing errors
        val cpu = CPU()
        cpu.registers[0] = 2
        cpu.registers[1] = 3
        assertEquals(2, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val add = Add(cpu, array, display)
        add.execute("17", "10")
        assertEquals(20, cpu.registers[0])
    }

    @Test
    fun testBadRegisterNumber1() {
        //TODO: Finish writing errors
        val cpu = CPU()
        cpu.registers[0] = 2
        cpu.registers[1] = 3
        assertEquals(2, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val add = Add(cpu, array, display)
        add.execute("17", "10")
        assertEquals(20, cpu.registers[0])
    }
}