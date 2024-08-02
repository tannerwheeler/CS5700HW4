class UByteToHexConverter {
    fun convert(byte: UByte): String {
        return String.format("%02X", byte.toByte())
    }
}