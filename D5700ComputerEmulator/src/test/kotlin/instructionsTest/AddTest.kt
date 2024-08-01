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
        val store = Add(cpu, array, display)
        store.execute("10".toUByte(16), "10".toUByte(16))
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
        val store = Add(cpu, array, display)
        store.execute("17".toUByte(16), "10".toUByte(16))
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
        val store = Add(cpu, array, display)
        store.execute("17".toUByte(16), "10".toUByte(16))
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
        val store = Add(cpu, array, display)
        store.execute("17".toUByte(16), "10".toUByte(16))
        assertEquals(20u, cpu.registers[0])
    }
}