package fi.tuomax.adventofcode.year2015.day23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** The CPU of Jane Marie's computer. */
public class CPU 
{

    /** The instruction which make up the program. */
    private List<String> program = new ArrayList<>();

    /** Program counter. */
    private Integer programCounter = 0;

    /** Registers. */
    private Map<String, Integer> registers = new HashMap<>();

    /**
     * Creates a CPU with two registers, named a and b.
     */
    public CPU()
    {
        registers.put("a", 0);
        registers.put("b", 0);
    }

    /**
     * A method to program the CPU.
     * @param line
     *      A line of program.
     */
    public void enterProgram(String line)
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
    public void run() {
        while (programCounter < program.size()) {
            String[] instruction = program.get(programCounter).split(" |, ");
            if (instruction[0].equals("hlf")) hlf(instruction);
            else if (instruction[0].equals("tpl")) tpl(instruction);
            else if (instruction[0].equals("inc")) inc(instruction);
            else if (instruction[0].equals("jmp")) jmp(instruction);
            else if (instruction[0].equals("jie")) jie(instruction);
            else if (instruction[0].equals("jio")) jio(instruction);
        }
    }

    /**
     * Halfs the value of a register.
     * @param instruction
     *      The parts of the instruction.
     */
    private void hlf(String[] instruction)
    {
        registers.put(instruction[1], registers.get(instruction[1]) / 2);
        programCounter++;
    }

    /**
     * Triples the value of a register.
     * @param instruction
     *      The parts of the instruction.
     */
    private void tpl(String[] instruction)
    {
        registers.put(instruction[1], registers.get(instruction[1]) * 3);
        programCounter++;
    }

    /**
     * Increments the value of a register.
     * @param instruction
     *      The parts of the instruction.
     */
    private void inc(String[] instruction)
    {
        registers.put(instruction[1], registers.get(instruction[1]) + 1);
        programCounter++;
    }

    /**
     * Makes a relative jump to a different instruction.
     * @param instruction
     *      The parts of the instruction.
     */
    private void jmp(String[] instruction)
    {
        programCounter += Integer.valueOf(instruction[1]);
    }

    /**
     * Makes a relative jump to a different instruction if a register has en 
     * even value.
     * @param instruction
     *      The parts of the instruction.
     */
    private void jie(String[] instruction)
    {
        if ((registers.get(instruction[1]) % 2) == 0)
            programCounter += Integer.valueOf(instruction[2]);
        else
            programCounter++;
    }

    /**
     * Makes a relative jump to a different instruction if a register has a
     * value of one.
     * @param instruction
     *      The parts of the instruction.
     */
    private void jio(String[] instruction)
    {
        if (registers.get(instruction[1]).equals(1)) 
            programCounter += Integer.valueOf(instruction[2]);
        else
            programCounter++;
    }
    
}
