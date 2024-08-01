package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Store
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StoreTest {
    @Test
    fun testStore() {
        val cpu = CPU()
        assertEquals(0u, cpu.registers[0])
        val array = arrayOf(RAM(), ROM())
        val display = Display()
        val store = Store(cpu, array, display)
        store.execute("00", "ff")
        assertEquals(1u, cpu.registers[0])
    }
}