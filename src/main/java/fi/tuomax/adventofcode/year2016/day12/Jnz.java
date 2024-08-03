package fi.tuomax.adventofcode.year2016.day12;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Instruction;

public class Jnz 
extends Instruction
{

    private Integer value = null;

    private String sourceRegister = null;

    private Integer offset;

    public Jnz(String input)
    {
        String[] parts = input.split(" ");
        offset = Integer.valueOf(parts[2]);
        try {
            value = Integer.valueOf(parts[1]);
        } catch (NumberFormatException e) {
            sourceRegister = parts[1];
        }
    }

    @Override
    public void run(Cpu cpu) 
    {
        Integer comparee = value != null ? value : cpu.getRegister(sourceRegister);
        if (!comparee.equals(0))
            cpu.jump(offset);
    }
    
}
