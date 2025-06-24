package fi.tuomax.adventofcode.commons.cpu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * Parses a list of instructions and programs a cpu.
 */
public class Cpu_Parser 
extends Parser
{

    private Cpu cpu = null;

    private InstructionFactory factory;

    /**
     * Getter for the cpu.
     * @return
     *      The cpu at its initial state with the program.
     */
    public Cpu getCpu() 
    {
        return cpu;
    }

    /**
     * Constructs a Cpu parser.
     * @param input
     *      The input from Advent of Code.
     * @param factory
     *      The factory responsible for parsing the string of text to an 
     *      instruction.
     * @param registers
     *      The names of the registers this cpu should have.
     */
    public Cpu_Parser(
        List<String> input, 
        InstructionFactory factory, 
        String[] registers
    ) {
        super(input);
        this.factory = factory;
        cpu = new Cpu(new HashSet<String>(Arrays.asList(registers)));
//        cpu = new Cpu();
    }

    /**
     * Parses the input.
     */
    @Override
    public void parse() 
    {
        for (String line : input) {
            cpu.enterProgram(factory.fromAocInput(line, cpu));
        }
    }
    
}
