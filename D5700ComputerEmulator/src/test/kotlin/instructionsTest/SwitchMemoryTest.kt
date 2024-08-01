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
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val switchMemory = SwitchMemory(cpu, array, display)

    @Test
    fun testSwitchMemoryBasic() {
        assertEquals(0u, cpu.memory)
        switchMemory.execute("70".toUByte(16), "00".toUByte(16))
        assertEquals(1u, cpu.memory)
        switchMemory.execute("70".toUByte(16), "00".toUByte(16))
        assertEquals(0u, cpu.memory)
    }

    @Test
    fun testBadSwitchMemory1() {
        val block: () -> Unit = { switchMemory.execute("71".toUByte(16), "00".toUByte(16)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadSwitchMemory2() {
        val block: () -> Unit = { switchMemory.execute("70".toUByte(16), "10".toUByte(16)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadSwitchMemory3() {
        val block: () -> Unit = { switchMemory.execute("70".toUByte(16), "01".toUByte(16)) }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}