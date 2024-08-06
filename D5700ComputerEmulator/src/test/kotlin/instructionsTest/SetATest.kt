package instructionsTest

import CPU
import Display
import RAM
import ROM
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import instructions.SetA
import kotlin.test.assertFailsWith

class SetATest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val setA = SetA(cpu, array, display)

    @Test
    fun testSetA() {
        assertEquals(0u, cpu.address)
        setA.execute("A2","55")
        assertEquals(597u, cpu.address)
    }

    @Test
    fun testBadSkipEqual2Test() {
        val block: () -> Unit = { setA.execute("70", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}