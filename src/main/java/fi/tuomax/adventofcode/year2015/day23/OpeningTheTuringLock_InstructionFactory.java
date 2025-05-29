package fi.tuomax.adventofcode.year2015.day23;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.DivRegByImm;
import fi.tuomax.adventofcode.commons.cpu.IncRegByImm;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;
import fi.tuomax.adventofcode.commons.cpu.MulRegByImm;
import fi.tuomax.adventofcode.commons.cpu.RelJmp;

public class OpeningTheTuringLock_InstructionFactory 
extends InstructionFactory 
{

    @Override
    public Instruction fromAocInput(String input, Cpu cpu) 
    {
        input = input.replaceAll(",", "");
        String[] parts = input.split(" ");
        if (input.startsWith("hlf")) 
            return new DivRegByImm(cpu, parts[1], 2L);
        else if (input.startsWith("tpl")) return new MulRegByImm(cpu, parts[1], 3L);
        else if (input.startsWith("inc")) return new IncRegByImm(cpu, parts[1], 1L);
        else if (input.startsWith("jmp")) return new RelJmp(cpu, Integer.valueOf(parts[1]));
        else if (input.startsWith("jie")) return new Jie(cpu, Integer.valueOf(parts[2]), parts[1]);
        else if (input.startsWith("jio")) return new Jio(cpu, Integer.valueOf(parts[2]), parts[1]);
        else throw new IllegalArgumentException(
            "Unknown instruction: " + input
        );

    }
    
}
