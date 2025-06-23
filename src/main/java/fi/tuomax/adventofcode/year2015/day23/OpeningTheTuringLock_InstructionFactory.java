package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Divide;
import fi.tuomax.adventofcode.commons.cpu.Increment;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;
import fi.tuomax.adventofcode.commons.cpu.Multiply;
import fi.tuomax.adventofcode.commons.cpu.UnconditionalJump;

public class OpeningTheTuringLock_InstructionFactory 
extends InstructionFactory 
{

    @Override
    public Instruction fromAocInput(String input, Cpu cpu) 
    {
        input = input.replaceAll(",", "");
        String[] parts = input.split(" ");

        if (input.startsWith("hlf")) 
            return new Divide(cpu, new Argument(cpu, parts[1]), new Argument(cpu, "2"));

        else if (input.startsWith("tpl")) 
            return new Multiply(cpu, new Argument(cpu, parts[1]), new Argument(cpu, "3"));

        else if (input.startsWith("inc")) 
            return new Increment(cpu, new Argument(cpu, parts[1]), new Argument(cpu, "1"));

        else if (input.startsWith("jmp")) 
            return new UnconditionalJump(cpu, new Argument(cpu, parts[1]));
            
        else if (input.startsWith("jie")) 
            return new JumpIfEven(cpu, new Argument(cpu, parts[1]), new Argument(cpu, parts[2]));

        else if (input.startsWith("jio")) 
            return new JumpIfOne(cpu, new Argument(cpu, parts[1]), new Argument(cpu, parts[2]));

        else throw new IllegalArgumentException(
            "Unknown instruction: " + input
        );

    }
    
}
