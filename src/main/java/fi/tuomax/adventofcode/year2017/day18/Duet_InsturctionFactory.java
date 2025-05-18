package fi.tuomax.adventofcode.year2017.day18;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;
import fi.tuomax.adventofcode.commons.cpu.InstructionFactory;

public class Duet_InsturctionFactory 
extends InstructionFactory
{

    @Override
    public Instruction fromAocInput(String input, Cpu cpu) 
    {
        if (input.startsWith("snd")) {
            return new Duet_Snd(input, cpu);
        } else if (input.startsWith("set")) {
            return new Duet_Set(input, cpu);
        } else if (input.startsWith("add")) {
            return new Duet_Add(input, cpu);
        } else if (input.startsWith("mul")) {
            return new Duet_Mul(input, cpu);
        } else if (input.startsWith("mod")) {
            return new Duet_Mod(input, cpu);
        } else if (input.startsWith("rcv")) {
            return new Duet_Rcv(input, cpu);
        } else if (input.startsWith("jgz")) {
            return new Duet_Jgz(input, cpu);
        } else {
            throw new IllegalArgumentException("Unknown instruction: " + input);
        }
    }
    
}
