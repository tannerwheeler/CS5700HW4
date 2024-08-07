package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Jump
import instructions.Add
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class JumpTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val jump = Jump(cpu, array, display)
    private val add = Add(cpu, array, display)

    @Test
    fun jumpTestBasic() {
        assertEquals(0u, cpu.programCounter)
        add.execute("10","10")
        assertEquals(2u, cpu.programCounter)
        jump.execute("51","f2")
        assertEquals(498u, cpu.programCounter)
        jump.execute("50","00")
        assertEquals(0u, cpu.programCounter)
    }

    @Test
    fun testBadJump() {
        val block: () -> Unit = { jump.execute("51", "X") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadJump2() {
        assertEquals(0u, cpu.programCounter)
        val block: () -> Unit = { jump.execute("51", "01") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadJump3() {
        assertEquals(0u, cpu.programCounter)
        val block: () -> Unit = { jump.execute("61", "01") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}