import org.junit.jupiter.api.Test

class D5700ComputerTest {
    val array = arrayOf(RAM(), ROM())
    val display = Display()
    val cpu = CPU(array, display)

    @Test
    fun testD5700Computer() {
        val computer = D5700Computer()
        computer.start()
    }
}