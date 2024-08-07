package instructionsTest

import CPU
import Display
import RAM
import ROM
import instructions.Store
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

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

    @Test
    fun testStoreBad1() {
        assertEquals(0u, cpu.registers[0])
        val store = Store(cpu, array, display)
        val block: () -> Unit = { store.execute("10", "ff") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testStoreBad2() {
        assertEquals(0u, cpu.registers[0])
        val store = Store(cpu, array, display)
        val block: () -> Unit = { store.execute("0A", "ff") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testStoreBad3() {
        assertEquals(0u, cpu.registers[0])
        val store = Store(cpu, array, display)
        val block: () -> Unit = { store.execute("00", "Xf") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testStoreBad4() {
        assertEquals(0u, cpu.registers[0])
        val store = Store(cpu, array, display)
        val block: () -> Unit = { store.execute("00", "fT") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}