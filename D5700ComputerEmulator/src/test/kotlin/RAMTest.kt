import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RAMTest {
    @Test
    fun testRAM() {
        val ram = RAM()
        ram.loadROM()
        assertEquals(0u, ram.read(0))
    }
}