package instructionsTest

import CPU
import ROM
import RAM
import Display
import instructions.ConvertToBase10
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ConvertToBase10Test {
    val cpu = CPU()
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val convertToBase10 = ConvertToBase10(cpu, array, display)

    @Test
    fun testConvertToBase10() {
        cpu.registers[2] = 123u
        convertToBase10.execute("D2","00")
        assertEquals(1u, array[0].read(cpu.address.toInt()))
        assertEquals(2u, array[0].read(cpu.address.toInt()+1))
        assertEquals(3u, array[0].read(cpu.address.toInt()+2))
    }

    @Test
    fun testBadConvertToBase10Test() {
        val block: () -> Unit = { convertToBase10.execute("70", "00") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadConvertToBase10Test2() {
        val block: () -> Unit = { convertToBase10.execute("D0", "10") }
        assertFailsWith<IllegalArgumentException> { block() }
    }

    @Test
    fun testBadConvertToBase10Test3() {
        val block: () -> Unit = { convertToBase10.execute("D0", "02") }
        assertFailsWith<IllegalArgumentException> { block() }
    }
}