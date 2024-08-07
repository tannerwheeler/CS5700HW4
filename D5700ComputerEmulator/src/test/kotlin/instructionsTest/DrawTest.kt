package instructionsTest

import CPU
import ROM
import RAM
import Display
import instructions.Draw
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class DrawTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val draw = Draw(cpu, array, display)

    @Test
    fun testDrawBasic() {
        display.printToConsole()
        assertEquals(null,display.checkDisplay(2,3))
        cpu.registers[1] = 67u
        draw.execute("F1", "23")
        display.printToConsole()
        assertEquals("C",display.checkDisplay(2,3))
    }

    @Test
    fun testDrawBasic2() {
        display.printToConsole()
        assertEquals(null,display.checkDisplay(2,3))
        cpu.registers[0] = 72u
        draw.execute("F0", "00")
        display.printToConsole()
        assertEquals("H",display.checkDisplay(0,0))
    }

    @Test
    fun testBadDrawBasic() {
        display.printToConsole()
        assertEquals(null,display.checkDisplay(2,3))
        cpu.registers[0] = 7u
        draw.execute("F0", "00")
        display.printToConsole()
        assertNotEquals("7",display.checkDisplay(0,0))
    }

    @Test
    fun testBadConvertToBase10Test3() {
        val block: () -> Unit = { draw.execute("F9", "23") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}