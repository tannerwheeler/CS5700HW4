import instructions.*

class InstructionFactory(
    private val cpu: CPU,
    private val memory: Array<Memory>,
    private val display: Display
) {
    private val instructions = arrayOf(
        Store(this.cpu, this.memory, this.display),
        Add(this.cpu, this.memory, this.display),
        Sub(this.cpu, this.memory, this.display),
        Read(this.cpu, this.memory, this.display),
        Write(this.cpu, this.memory, this.display),
        Jump(this.cpu, this.memory, this.display),
        ReadKeyboard(this.cpu, this.memory, this.display),
        SwitchMemory(this.cpu, this.memory, this.display),
        SkipEqual(this.cpu, this.memory, this.display),
        SetA(this.cpu, this.memory, this.display),
        SetT(this.cpu, this.memory, this.display),
        ReadT(this.cpu, this.memory, this.display),
        ConvertToBase10(this.cpu, this.memory, this.display),
        ConvertByteToASCII(this.cpu, this.memory, this.display),
        Draw(this.cpu, this.memory, this.display)
    )

    fun executeInstruction(b1: UByte, b2: UByte) {
        val n1 = UByteToHexConverter().convert(b1)
        val n2 = UByteToHexConverter().convert(b2)

        println("$n1, $n2")

        val instructionValue = n1.chunked(1)[0]

        when(instructionValue) {
            "0" -> instructions[0].execute(n1,n2)
            "1" -> instructions[1].execute(n1,n2)
            "2" -> instructions[2].execute(n1,n2)
            "3" -> instructions[3].execute(n1,n2)
            "4" -> instructions[4].execute(n1,n2)
            "5" -> instructions[5].execute(n1,n2)
            "6" -> instructions[6].execute(n1,n2)
            "7" -> instructions[7].execute(n1,n2)
            "8" -> instructions[8].execute(n1,n2)
            "9" -> instructions[9].execute(n1,n2)
            "A" -> instructions[10].execute(n1,n2)
            "B" -> instructions[11].execute(n1,n2)
            "C" -> instructions[12].execute(n1,n2)
            "D" -> instructions[13].execute(n1,n2)
            "E" -> instructions[14].execute(n1,n2)
            "F" -> instructions[15].execute(n1,n2)
        }
    }
}