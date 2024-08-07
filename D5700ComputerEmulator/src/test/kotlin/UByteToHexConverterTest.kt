import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class UByteToHexConverterTest {
    @Test
    fun converterTest() {
        val converter = UByteToHexConverter()
        assertEquals("0C",converter.convert(12u))
    }

    @Test
    fun converterTest2() {
        val converter = UByteToHexConverter()
        assertEquals("96",converter.convert(150u))
    }

    @Test
    fun converterTest3() {
        val converter = UByteToHexConverter()
        assertEquals("FA",converter.convert(250u))
    }

    @Test
    fun converterTest4() {
        val converter = UByteToHexConverter()
        assertEquals("17",converter.convert(23u))
    }
}