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
        display.print()
        assertEquals("",display.checkDisplay(2,3))
        cpu.registers[1] = 12u
        draw.execute("F1", "23")
        display.print()
        assertEquals("C",display.checkDisplay(2,3))
    }
}