import org.junit.jupiter.api.Test

class CPUTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)

    @Test
    fun testCPU() {
        cpu.startEmulation()
        cpu.stopEmulation()
    }
}