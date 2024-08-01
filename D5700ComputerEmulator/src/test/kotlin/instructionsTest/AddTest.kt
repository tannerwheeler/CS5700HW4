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
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val add = Add(cpu, array, display)
        add.execute("10", "10")
        assertEquals(5u, cpu.registers[0])
    }

    @Test
    fun testAddWithThreeRegisters() {
        val cpu = CPU()
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val add = Add(cpu, array, display)
        add.execute("17", "10")
        assertEquals(3u, cpu.registers[0])
    }

    @Test
    fun testBadRegisterNumber0() {
        //TODO: Finish writing errors
        val cpu = CPU()
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val add = Add(cpu, array, display)
        add.execute("17", "10")
        assertEquals(20u, cpu.registers[0])
    }

    @Test
    fun testBadRegisterNumber1() {
        //TODO: Finish writing errors
        val cpu = CPU()
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val add = Add(cpu, array, display)
        add.execute("17", "10")
        assertEquals(20u, cpu.registers[0])
    }
}