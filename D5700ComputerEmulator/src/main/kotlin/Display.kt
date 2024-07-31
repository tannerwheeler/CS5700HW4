class Display {
    private val displayArray = Array(8) { Array<UByte?>(8) { null } }

    fun changeDisplay() {

    }

    fun print() {
        //TODO: Possible problem here
        println("--------")
        displayArray.forEach {
            it.forEach {
                if (it != null) {
                    print(it)
                } else {
                    print(0)
                }
            }
            println("")
        }
        println("--------")
    }
}