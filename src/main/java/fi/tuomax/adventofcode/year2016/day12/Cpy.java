package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Cpy 
extends Instruction
{

    Integer value = null;

    String sourceRegister = null;

    String targetRegister = null;

    public Cpy(String input)
    {
        String[] parts = input.split(" ");
        targetRegister = parts[2];
        try {
            value = Integer.parseInt(parts[1]);
        } catch (NumberFormatException e) {
            sourceRegister = parts[1];
        }
    }

    @Override
    public void run(Cpu cpu) 
    {
        cpu.setRegister(
            targetRegister, 
            value != null ? value : cpu.getRegister(sourceRegister)
        );
    }
    
}
