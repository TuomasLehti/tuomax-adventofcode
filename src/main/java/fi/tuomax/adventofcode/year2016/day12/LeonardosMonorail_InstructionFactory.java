package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.CpyImmToReg;
import fi.tuomax.adventofcode.commons.cpu.CpyRegToReg;
import fi.tuomax.adventofcode.commons.cpu.IncRegByImm;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;
import fi.tuomax.adventofcode.commons.cpu.RelJmpOfsFromImm;

/**
 * Provides Assembunny instructions from Aoc 2016, day 12.
 */
public class LeonardosMonorail_InstructionFactory 
extends InstructionFactory
{

    @Override
    public Instruction fromAocInput(String line, Cpu cpu) 
    throws IllegalArgumentException
    {
        String[] parts = line.split(" ");
        if (line.startsWith("cpy")) {
            if (isInteger(parts[1])) 
                return new CpyImmToReg(cpu, parts[2], Long.valueOf(parts[1]));
            else
                return new CpyRegToReg(cpu, parts[2], parts[1]);
        }
        else if (line.startsWith("inc")) return new IncRegByImm(cpu, parts[1], 1L);
        else if (line.startsWith("dec")) return new IncRegByImm(cpu, parts[1], -1L);
        else if (line.startsWith("jnz")) {
            /* There is a jnz 1 ofs instruction in the input, which is used as an unconditional jump. */
            if (isInteger(parts[1])) 
                return new RelJmpOfsFromImm(cpu, Integer.valueOf(parts[2]));
            else
                return new Jnz(cpu, Integer.valueOf(parts[2]), parts[1]);
        }

        else throw new IllegalArgumentException(
            "Unknown instruction: " + line
        );
}
    
}
