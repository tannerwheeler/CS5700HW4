package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.SwitchMemory
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class SwitchMemoryTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    val switchMemory = SwitchMemory(cpu, array, display)

    @Test
    fun testSwitchMemoryBasic() {
        assertEquals(0u, cpu.memory)
        switchMemory.execute("70", "00")
        assertEquals(1u, cpu.memory)
        switchMemory.execute("70", "00")
        assertEquals(0u, cpu.memory)
    }

    @Test
    fun testBadSwitchMemory1() {
        val block: () -> Unit = { switchMemory.execute("71", "00") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadSwitchMemory2() {
        val block: () -> Unit = { switchMemory.execute("70", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadSwitchMemory3() {
        val block: () -> Unit = { switchMemory.execute("70", "01") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}