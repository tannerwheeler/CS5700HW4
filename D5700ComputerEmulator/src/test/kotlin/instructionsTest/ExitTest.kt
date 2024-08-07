package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Exit
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ExitTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val exit = Exit(cpu, array, display)

    @Test
    fun testExitIncrementCheck() {
        assertEquals(false, this.exit.incrementCheck())
    }

    @Test
    fun testExit() {
        this.exit.execute("00", "00")

        val block: () -> Unit = { exit.execute("X0", "10") }
        assertFailsWith<IllegalArgumentException> { block() }

        val block2: () -> Unit = { exit.execute("00", "10") }
        assertFailsWith<IllegalArgumentException> { block2() }

        val block3: () -> Unit = { exit.execute("01", "00") }
        assertFailsWith<IllegalArgumentException> { block3() }
    }
}