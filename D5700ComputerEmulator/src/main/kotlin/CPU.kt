import instructions.Exit
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class CPU (
    private val memoryArray: Array<Memory>,
    private val display: Display,
){
    val registers = Array<UByte>(8) { 0u }
    var programCounter : UShort = 0u
    var timer : UByte = 0u
    var address : UShort = 0u
    var memory : UInt = 0u

    private var instructions = InstructionFactory(this, this.memoryArray, this.display)
    private var executor = Executors.newSingleThreadScheduledExecutor()
    private var cpuRunCommand : ScheduledFuture<*>? = null
    private var cpuTimer : ScheduledFuture<*>? = null

    private fun runTimer(decreaseTimer: Runnable) {
        this.cpuTimer = executor.scheduleAtFixedRate(
            decreaseTimer,
            0,
            16L,
            TimeUnit.MILLISECONDS
        )
    }

    private fun startRunningCommands(runCommand: Runnable) {
        this.cpuRunCommand = executor.scheduleAtFixedRate(
            runCommand,
            0,
            500L, // repeat frequency - every 2 ms
            TimeUnit.MILLISECONDS
        )
    }

    fun startEmulation() {
        this.executor = Executors.newSingleThreadScheduledExecutor()
        val runCommand = Runnable {
            val firstByte = this.memoryArray[1].read(this.programCounter.toInt())
            val secondByte = this.memoryArray[1].read(this.programCounter.toInt()+1)

            if (firstByte == 0.toUByte() && secondByte == 0.toUByte()) {
                Exit(this, this.memoryArray, this.display).execute("00","00")
            } else {
                this.instructions.executeInstruction(firstByte, secondByte)
            }
        }

        val decreaseTimer = Runnable {
            if (this.timer > 0u) {
                this.timer --
            }
        }

        runTimer(decreaseTimer)
        startRunningCommands(runCommand)
    }

    fun stopEmulation() {
        //to stop and interrupt a future
        this.cpuRunCommand?.cancel(true)

        // to wait for all futures to finish
        try {
            this.cpuRunCommand!!.get() // waits for future to finish or be cancelled - blocks current thread execution (repeating futures will still run)
        } catch (_: Exception) {
            this.executor.shutdown() // turns off the executor allowing the program to terminate when the end is reached
        }
    }
}