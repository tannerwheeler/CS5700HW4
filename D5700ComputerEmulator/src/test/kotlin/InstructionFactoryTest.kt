import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class InstructionFactoryTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)
    private val instructionFactory = InstructionFactory(cpu, array, display)

    @Test
    fun testInstructionFactory0() {
        instructionFactory.executeInstruction(0u, 10u)
        assertEquals(10u, cpu.registers[0])
    }

    @Test
    fun testInstructionFactory1() {
        cpu.registers[0] = 3u
        cpu.registers[1] = 10u
        instructionFactory.executeInstruction(16u, 16u)
        assertEquals(13u, cpu.registers[0])
    }

    @Test
    fun testInstructionFactory2() {
        cpu.registers[0] = 10u
        cpu.registers[1] = 3u
        instructionFactory.executeInstruction(32u, 16u)
        assertEquals(7u, cpu.registers[0])
    }

    @Test
    fun testInstructionFactory3() {
        array[0].write(0, 100u)
        assertEquals(0u, cpu.registers[0])
        instructionFactory.executeInstruction(48u, 0u)
        assertEquals(100u, cpu.registers[0])
    }

    @Test
    fun testInstructionFactory4() {
        cpu.registers[0] = 100u
        assertEquals(0u, array[0].read(0))
        instructionFactory.executeInstruction(64u, 0u)
        assertEquals(100u, array[0].read(0))
    }

    @Test
    fun testInstructionFactory5() {
        assertEquals(0u, cpu.programCounter)
        instructionFactory.executeInstruction(80u, 254u)
        assertEquals(254u, cpu.programCounter)
    }

    @Test
    fun testInstructionFactory6() {
        cpu.registers[0] = 100u
        assertEquals(100u, cpu.registers[0])
        instructionFactory.executeInstruction(96u, 0u)
        assertEquals(0u, cpu.registers[0])
    }

    @Test
    fun testInstructionFactory7() {
        assertEquals(0u, cpu.memory)
        instructionFactory.executeInstruction(112u, 0u)
        assertEquals(1u, cpu.memory)
    }

    @Test
    fun testInstructionFactory8() {
        assertEquals(0u, cpu.programCounter)
        instructionFactory.executeInstruction(128u, 16u)
        assertEquals(4u, cpu.programCounter)
    }

    @Test
    fun testInstructionFactory9() {
        assertEquals(0u, cpu.programCounter)
        cpu.registers[0] = 1u
        instructionFactory.executeInstruction(144u, 16u)
        assertEquals(4u, cpu.programCounter)
    }

    @Test
    fun testInstructionFactoryA() {
        assertEquals(0u, cpu.address)
        instructionFactory.executeInstruction(175u, 255u)
        assertEquals(4095u, cpu.address)
    }

    @Test
    fun testInstructionFactoryB() {
        assertEquals(0u, cpu.timer)
        instructionFactory.executeInstruction(176u, 160u)
        assertEquals(10u, cpu.timer)
    }

    @Test
    fun testInstructionFactoryC() {
        assertEquals(0u, cpu.registers[0])
        cpu.timer = 20u
        instructionFactory.executeInstruction(192u, 0u)
        assertEquals(20u, cpu.registers[0])
    }

    @Test
    fun testInstructionFactoryD() {
        cpu.registers[0] = 255u
        instructionFactory.executeInstruction(208u, 0u)
        assertEquals(2u, array[0].read(0))
        assertEquals(5u, array[0].read(1))
        assertEquals(5u, array[0].read(2))
    }

    @Test
    fun testInstructionFactoryE() {
        cpu.registers[0] = 2u
        assertEquals(0u, cpu.registers[1])
        instructionFactory.executeInstruction(224u, 16u)
        assertEquals(50u, cpu.registers[1])
    }

    @Test
    fun testInstructionFactoryF() {
        assertEquals(null, display.checkDisplay(2, 3))
        cpu.registers[0] = 70u
        instructionFactory.executeInstruction(240u, 35u)
        assertEquals("F", display.checkDisplay(2, 3))
    }

    @Test
    fun testInstructionFactoryX() {
        instructionFactory.executeInstruction(0u, 0u)
    }
}