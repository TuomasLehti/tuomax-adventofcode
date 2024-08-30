package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;
import fi.tuomax.adventofcode.year2016.day12.Inc;

public class OpeningTheTuringLock_InstructionFactory 
extends InstructionFactory 
{

    @Override
    public Instruction fromAocInput(String input, Cpu cpu) 
    {
        input = input.replaceAll(",", "");
        if (input.startsWith("hlf")) return new Hlf(input, cpu);
        else if (input.startsWith("tpl")) return new Tpl(input, cpu);
        else if (input.startsWith("inc")) return new Inc(input, cpu); // From 2016 day 12
        else if (input.startsWith("jmp")) return new Jmp(input, cpu);
        else if (input.startsWith("jie")) return new Jie(input, cpu);
        else if (input.startsWith("jio")) return new Jio(input, cpu);
        else throw new IllegalArgumentException(
            "Unknown instruction: " + input
        );

    }
    
}
