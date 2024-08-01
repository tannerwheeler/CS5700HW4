package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Jump
import instructions.Add
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class JumpTest {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val jump = Jump(cpu, array, display)
    val add = Add(cpu, array, display)

    @Test
    fun jumpTestBasic() {
        assertEquals(0u, cpu.program_counter)
        add.execute("10","10")
        assertEquals(2u, cpu.program_counter)
        jump.execute("51","f2")
        assertEquals(498u, cpu.program_counter)
    }
}