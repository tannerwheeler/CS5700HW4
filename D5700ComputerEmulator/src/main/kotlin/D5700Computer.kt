import instructions.*
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

class D5700Computer {
    private var cpu: CPU = CPU()
    private var memory = arrayOf(RAM(), ROM())
    private var display = Display()
    private var instructions = InstructionFactory(cpu, memory, display)

    var executor = Executors.newSingleThreadScheduledExecutor()
    lateinit var cpuFuture : ScheduledFuture<*>

    fun start() {
        this.memory[1].loadROM()
        this.startEmulation()
    }

    private fun startEmulation() {
        this.executor = Executors.newSingleThreadScheduledExecutor()
        val runnable = Runnable {
            val firstByte = memory[1].read(cpu.program_counter.toInt())
            val secondByte = memory[1].read(cpu.program_counter.toInt()+1)

//            if (firstByte == 0.toUByte() && secondByte == 0.toUByte()) {
//                this.stop()
//            } else {
                this.instructions.executeInstruction(firstByte, secondByte)
//            }
        }

        this.cpuFuture = executor.scheduleAtFixedRate(
            runnable,
            0,
            500L, // repeat frequency - every 2 ms
            TimeUnit.MILLISECONDS
        )
    }

    private fun stop() {
        //to stop and interupt a future
        this.cpuFuture?.cancel(true)

        // to wait for all futures to finish
        try {
            this.cpuFuture.get() // waits for future to finish or be cancelled - blocks current thread execution (repeating futures will still run)
        } catch (_: Exception) {
            this.executor.shutdown() // turns off the executor allowing the program to terminate when the end is reached
        }
    }
}