package fi.tuomax.adventofcode.commons.cpu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * An instruction-based cpu, which doesn't have any memory.
 */
public class Cpu 
{

    @SuppressWarnings("unused")
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    private final int CPU_RUNNING = 0;

    private final int CPU_STOPPED = 1;

    private int cpuState = CPU_STOPPED;

    /**
     * Creates a CPU with a set of registers. All registers are set to zero.
     */
    public Cpu(Set<String> registerNames)
    {
        for (String name : registerNames)
            registers.put(name, 0L);
    }

    /**
     * Creates a CPU.
     */
    public Cpu()
    {

    }

    /** 
     * The instructions which make up the program. 
     */
    private List<Instruction> program = new ArrayList<>();

    /** 
     * Which line of the program is being executed. 
     */
    private Integer programCounter = 0;

    /** 
     * Returns, which line of the program is being executed. 
     * @return 
     *      The line the program is on at the moment.
     */
    public Integer getProgramCounter() 
    {
        return programCounter;
    }

    /**
     * Sets the program counter to a certain point in the program. This may
     * be useful when the program needs to be started from any other address
     * than zero.
     * @param programCounter
     *      The new value of the program counter.
     * @throws IndexOutOfBoundsException
     *      If not 0 <= new program counter < program size.
     */
    public void setProgramCounter(Integer programCounter) 
    throws IndexOutOfBoundsException
    {
        if ((programCounter >= program.size()) || programCounter < 0)
            throw new IndexOutOfBoundsException(String.format(
                "Tried to set program counter to %d, only %d instructions available.",
                programCounter, program.size()
            ));
        this.programCounter = programCounter;
    }

    /**
     * Moves the program counter by an offset.
     * @param offset
     *      The offset.
     */
    public void jump(Integer offset)
    {
        programCounter += offset;
        // Counteract the effect of increasing program counter once every cycle.
        programCounter--;
    }

    /**
     * Returns the instruction at a given index.
     * @param idx
     *      The index.
     * @return
     *      The instruction.
     */
    public Instruction getInstruction(Integer idx)
    {
        return program.get(idx);
    }

    /**
     * Sets the instruction at a given index.
     * @param idx
     *      The index.
     * @param instruction
     *      The instruction.
     * @throws IndexOutOfBoundsException
     *      If not 0 <= index <= program size.
     */
    public void setInstruction(Integer idx, Instruction instruction)
    throws IndexOutOfBoundsException
    {
        if ((idx >= program.size()) || idx < 0)
            throw new IndexOutOfBoundsException(String.format(
                "Tried to set program counter to %d, only %d instructions available.",
                programCounter, program.size()
            ));
        program.set(idx, instruction);
    }

    /**
     * A method to program the CPU.
     * @param line
     *      A line of aprogram.
     */
    public void enterProgram(Instruction line)
    {
        program.add(line);
    }

    /** 
     * How many cycles the processor has cycled through. This value is updated
     * every time the processor goes through an instruction by querying the 
     * number of cycles an instruction takes.
     * 
     * Number of cycles has been in use only once so far, but it is still 
     * implemented for all problems. In most cases the instructions just return
     * a zero as their amount of used cycles.
     */
    private Integer cycle = 0;

    /**
     * Returns the amount of cycles the processor has gone through during the
     * execution of this program.
     * @return
     *      The amount of cycles.
     */
    public Integer getCycle() 
    {
        return cycle;
    }

    /** 
     * Registers. 
     */
    private Map<String, Long> registers = new HashMap<>();

    /**
     * Gets the value in a register. If the register doesn't exist, creates 
     * it and sets it to zero.
     * @param register
     *      The name of the register.
     * @return
     *      The value in that register.
     */
    public Long getRegister(String register)
    {
        if (!registers.containsKey(register))
            registers.put(register, 0L);
        return registers.get(register);
    }

    /**
     * Sets the value of the register. If the register doesn't exist, 
     * creates it.
     * @param register
     *      The name of the register.
     * @param value
     *      The value to be set.
     */
    public void setRegister(String register, Long value)
    {
        registers.put(register, value);
    }
    
    /**
     * Runs the program in the cpu until the end is reached.
     */
    public void run() 
    {
        cpuState = CPU_RUNNING;
        do {
            step();
        } while (cpuState == CPU_RUNNING);
    }

    /**
     * Executes the next instruction.
     */
    public void step()
    {
        program.get(programCounter).run();
        programCounter++;
        cycle++;
        determineCpuState();
//        LOGGER.debug(toString());
    }

    /**
     * Determines the next state of the processor.
     */
    private void determineCpuState() 
    {
        /* If processor state is something other than running, an instruction 
         * must have changed it and the state set by the instruction is passed 
         * forward.
         * 
         * Otherwise a method is called to determine if the cpu should stop or 
         * keep running. That method can be overriden by child classeses. */
        if ((cpuState == CPU_RUNNING) && (shouldStop()))
            cpuState = CPU_STOPPED;
            
    }

    /**
     * Should return true if the execution of the program should be halted.
     * 
     * The base implementation, which is required by most problems, is to stop
     * when the end of the program is reached or if the program counter points
     * to outside of the program after a jump instruction.
     * 
     * This method should be overridden by child classes if the execution 
     * should stop on an other condition.
     * 
     * @return
     *      True if the execution should stop.
     */
    protected boolean shouldStop()
    {
        return (programCounter < 0) || (programCounter >= program.size());
    }

    /**
     * Stops the execution. Should be called by instructions if they want to
     * stop the execution.
     */
    public void stop()
    {
        cpuState = CPU_STOPPED;
    }

    /**
     * Resets the cpu to its initial state.
     */
    public void reset()
    {
        for (String registerName : registers.keySet())
            setRegister(registerName, 0L);
        programCounter = 0;
    }

    /**
     * Returns the state of the processor as a string.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("PC : %2d", programCounter + 1));
        for (String registerName : registers.keySet())
            sb.append(String.format(", %s: %2d", registerName, getRegister(registerName)));
        return sb.toString();
    }

}
