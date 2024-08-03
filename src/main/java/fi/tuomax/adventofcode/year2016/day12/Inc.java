package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Inc 
extends Instruction
{

    private String register;

    public Inc(String input)
    {
        register = input.split(" ")[1];
    }

    @Override
    public void run(Cpu cpu) 
    {
        cpu.setRegister(register, cpu.getRegister(register) + 1);
    }
    
}
