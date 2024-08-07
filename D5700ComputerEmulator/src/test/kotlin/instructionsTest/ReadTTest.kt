package instructionsTest

import CPU
import Display
import ROM
import RAM
import instructions.ReadT
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

class ReadTTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val readT = ReadT(cpu, array, display)

    @Test
    fun testReadT() {
        cpu.timer = 40u
        assertEquals(0.toUByte(), cpu.registers[0])
        readT.execute("C0","00")
        assertEquals(40.toUByte(), cpu.registers[0])
    }

    @Test
    fun testBadReadTTest() {
        val block: () -> Unit = { readT.execute("70", "00") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadReadT2Test() {
        val block: () -> Unit = { readT.execute("C0", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadReadT3Test() {
        val block: () -> Unit = { readT.execute("CB", "00") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}