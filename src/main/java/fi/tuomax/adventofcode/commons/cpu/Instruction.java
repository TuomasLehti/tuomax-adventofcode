package fi.tuomax.adventofcode.commons.cpu;

public abstract class Instruction 
{

    /**
     * The processor in which this instruction resides.
     */
    protected Cpu cpu;

    /**
     * Creates the instruction.
     * @param input
     *      Advent of Code input.
     * @param cpu
     *      The processor in which this instruction should reside.
     */
    public Instruction(String input, Cpu cpu)
    {
        this.cpu = cpu;
    }

    /**
     * Runs the instruction.
     */
    public abstract void run();

    /**
     * Stops the execution of the program after this instruction.
     */
    protected void stopCpu()
    {
        cpu.stop();
    }

    /**
     * Returns the number of cycles this instruction takes to run.
     * @return
     *      The number of cycles.
     */
    public Integer getCycles()
    {
        return 0;
    }
    
}
