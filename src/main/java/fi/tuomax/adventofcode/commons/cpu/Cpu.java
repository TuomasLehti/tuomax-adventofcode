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

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /** The instruction which make up the program. */
    private List<Instruction> program = new ArrayList<>();

    /** Which line of the program is being executed. */
    private Integer programCounter = 0;

    private Integer cycle = 0;

    public Integer getProgramCounter() 
    {
        return programCounter;
    }

    public void setProgramCounter(Integer programCounter) 
    {
        this.programCounter = programCounter;
    }

    public Instruction getInstruction(Integer idx)
    {
        return program.get(idx);
    }

    public void setInstruction(Integer idx, Instruction instruction)
    {
        if (idx < program.size())
            program.set(idx, instruction);
    }

    public void jump(Integer offset)
    {
        programCounter += offset;
        // Counteract the effect of increasing program counter once every cycle.
        programCounter--;
    }

    /** Registers. */
    private Map<String, Integer> registers = new HashMap<>();

    /**
     * Creates a CPU. All registers are set to zero.
     */
    public Cpu(Set<String> registerNames)
    {
        for (String name : registerNames)
            registers.put(name, 0);
    }

    /**
     * A method to program the CPU.
     * @param line
     *      A line of program.
     */
    public void enterProgram(Instruction line)
    {
        program.add(line);
    }

    /**
     * Gets the value of a register.
     * @param register
     *      The name of the register.
     * @return
     *      The value in that register.
     */
    public Integer getRegister(String register)
    {
        return registers.get(register);
    }

    /**
     * Sets the value of the register.
     * @param register
     *      The name of the register.
     * @param value
     *      The value to be set.
     */
    public void setRegister(String register, Integer value)
    {
        registers.put(register, value);
    }
    
    /**
     * Runs the program in the cpu.
     */
    public void run() 
    {
        while (programCounter < program.size()) {
            if (programCounter.equals(9))
                System.out.println(toString());

            program.get(programCounter).run(this);
            programCounter++;
            cycle++;
        }
    }

    /**
     * Resets the cpu to its initial state.
     */
    public void reset()
    {
        for (String registerName : registers.keySet())
            setRegister(registerName, 0);
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
