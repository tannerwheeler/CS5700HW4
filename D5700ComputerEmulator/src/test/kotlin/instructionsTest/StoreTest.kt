package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Store
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class StoreTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)

    @Test
    fun testStore() {
        assertEquals(0u, cpu.registers[0])
        val store = Store(cpu, array, display)
        store.execute("00", "ff")
        assertEquals(255.toUByte(), cpu.registers[0])
    }
}