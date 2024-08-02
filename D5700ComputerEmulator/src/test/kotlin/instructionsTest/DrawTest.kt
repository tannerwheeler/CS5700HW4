package instructionsTest

import CPU
import ROM
import RAM
import Display
import instructions.Draw
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DrawTest {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val draw = Draw(cpu, array, display)

    @Test
    fun testDrawBasic() {
        display.printToConsole()
        assertEquals(null,display.checkDisplay(2,3))
        cpu.registers[1] = 12u
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
}