package fi.tuomax.adventofcode.year2017.day23;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Copy;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;
import fi.tuomax.adventofcode.year2016.day12.JumpIfNotZero;

public class CoprosessorConflagration_InstructionFactory 
extends InstructionFactory
{

    @Override
    public Instruction fromAocInput(String input, Cpu cpu) 
    {
        String[] parts = input.split(" ");

        String opcode = parts[0];

        List<Argument> args = new ArrayList<>();
        for (int idx = 1; idx < parts.length; idx++)
            args.add(new Argument(cpu, parts[idx]));

        if (opcode.equals("set"))
            return new Copy(cpu, args.get(1), args.get(0));
        else if (opcode.equals("sub"))
            return new Decrement(cpu, args.get(0), args.get(1));
        else if (opcode.equals("mul"))
            return new MultiplyCounter(cpu, args.get(0), args.get(1));
        else if (opcode.equals("jnz"))
            return new JumpIfNotZero(cpu, args.get(0), args.get(1));
        else
            throw new IllegalArgumentException("Unknown instruction: " + input);
    }
    
}
