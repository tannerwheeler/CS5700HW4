class CPU {
    val registers = Array<Byte>(8) { 0 }
    var program_counter : UShort = 0u
    var timer : UByte = 0u
    var address : UShort = 0u
    var memory : UInt = 0u
}