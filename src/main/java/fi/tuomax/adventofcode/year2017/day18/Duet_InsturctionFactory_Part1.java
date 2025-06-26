package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Copy;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Increment;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;
import fi.tuomax.adventofcode.commons.cpu.Multiply;

public class Duet_InsturctionFactory_Part1 
extends InstructionFactory
{

    @Override
    public Instruction fromAocInput(String input, Cpu cpu) 
    {
        String[] parts = input.split(" ");

        if (input.startsWith("snd")) 
            return new Duet_Sound(cpu, new Argument(cpu, parts[1]));

        else if (input.startsWith("set")) 
            return new Copy(cpu, new Argument(cpu, parts[2]), new Argument(cpu, parts[1]));

        else if (input.startsWith("add")) 
            return new Increment(cpu, new Argument(cpu, parts[1]), new Argument(cpu, parts[2]));

        else if (input.startsWith("mul")) 
            return new Multiply(cpu, new Argument(cpu, parts[1]), new Argument(cpu, parts[2]));

        else if (input.startsWith("mod")) 
            return new Modulo(cpu, new Argument(cpu, parts[1]), new Argument(cpu, parts[2]));

        else if (input.startsWith("jgz")) 
            return new JumpIfGreaterThanZero(cpu, new Argument(cpu, parts[1]), new Argument(cpu, parts[2]));

        else if (input.startsWith("rcv")) 
            return new Duet_Recover(cpu, new Argument(cpu, parts[1]));

        else 
            throw new IllegalArgumentException("Unknown instruction: " + input);
        
    }
    
}
