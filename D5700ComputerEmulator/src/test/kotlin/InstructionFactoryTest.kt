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

    }

    @Test
    fun testInstructionFactory8() {

    }

    @Test
    fun testInstructionFactory9() {

    }

    @Test
    fun testInstructionFactoryA() {

    }

    @Test
    fun testInstructionFactoryB() {

    }

    @Test
    fun testInstructionFactoryC() {

    }

    @Test
    fun testInstructionFactoryD() {

    }

    @Test
    fun testInstructionFactoryE() {

    }

    @Test
    fun testInstructionFactoryF() {

    }

    @Test
    fun testInstructionFactoryExit() {

    }

    @Test
    fun testInstructionFactoryBad() {

    }

}