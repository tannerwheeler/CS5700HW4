package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Sub
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SubTest {
    @Test
    fun testSubBasic() {
        val cpu = CPU()
        cpu.registers[0] = 3u
        cpu.registers[1] = 2u
        assertEquals(3u, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val sub = Sub(cpu, array, display)
        sub.execute("20", "10")
        assertEquals(1u, cpu.registers[0])
    }

    @Test
    fun testSubWithNegatives() {
        val cpu = CPU()
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val sub = Sub(cpu, array, display)
        sub.execute("20", "10")
        assertEquals(1u, cpu.registers[0])
    }

    @Test
    fun testSubWithThreeRegisters() {
        val cpu = CPU()
        cpu.registers[0] = 2u
        cpu.registers[1] = 3u
        assertEquals(2u, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val sub = Sub(cpu, array, display)
        sub.execute("27", "10")
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
        val sub = Sub(cpu, array, display)
        sub.execute("27", "10")
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
        val sub = Sub(cpu, array, display)
        sub.execute("27", "10")
        assertEquals(20u, cpu.registers[0])
    }
}