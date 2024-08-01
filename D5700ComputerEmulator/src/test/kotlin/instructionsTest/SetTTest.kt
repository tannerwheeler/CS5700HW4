package instructionsTest

import CPU
import Display
import RAM
import ROM
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import instructions.SetT
import kotlin.test.assertFailsWith

class SetTTest {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val setT = SetT(cpu, array, display)

    @Test
    fun testSetT() {
        assertEquals(0u, cpu.timer)
        setT.execute("B0","A0")
        assertEquals(10u, cpu.timer)
    }

    @Test
    fun testBadSkipEqual2Test() {
        val block: () -> Unit = { setT.execute("70", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}