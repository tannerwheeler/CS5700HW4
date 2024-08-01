package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.ReadKeyboard
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ReadKeyboardTest {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val keyboard = ReadKeyboard(cpu, array, display)

    @Test
    fun testSplit() {
        assertEquals(true,keyboard.checkHex("af"))
        assertEquals(false,keyboard.checkHex("aq"))
        assertEquals(true,keyboard.checkHex("2D"))
        assertEquals(false,keyboard.checkHex("-9"))
        assertEquals(true,keyboard.checkHex("AF3"))
        assertEquals(true,keyboard.checkHex("23454367DDDC785DDFFF"))
    }
}