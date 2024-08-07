package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.ReadKeyboard
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ReadKeyboardTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val keyboard = ReadKeyboard(cpu, array, display)

    @Test
    fun testSplit() {
        assertEquals(true,keyboard.checkHex("af"))
        assertEquals(false,keyboard.checkHex("aq"))
        assertEquals(true,keyboard.checkHex("2D"))
        assertEquals(false,keyboard.checkHex("-9"))
        assertEquals(true,keyboard.checkHex("AF3"))
        assertEquals(true,keyboard.checkHex("23454367DDDC785DDFFF"))
    }

    @Test
    fun testKeyboardInput() {
        keyboard.execute("62", "00")
    }

    @Test
    fun testBadKeyboardInput() {
        val block: () -> Unit = { keyboard.execute("A", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadKeyboardInput2() {
        val block: () -> Unit = { keyboard.execute("61", "1") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadKeyboardInput3() {
        val block: () -> Unit = { keyboard.execute("67", "A0") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}