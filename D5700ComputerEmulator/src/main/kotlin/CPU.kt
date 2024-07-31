class CPU {
    val registers = Array<UByte?>(8) { null }
    var program_counter : UShort = 0u
    var timer : UByte = 0u
    var address : UShort = 0u
    var memory : UInt = 0u
}