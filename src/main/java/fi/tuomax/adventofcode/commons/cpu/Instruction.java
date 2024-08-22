package fi.tuomax.adventofcode.commons.cpu;

import java.util.ArrayList;
import java.util.List;

public abstract class Instruction 
{

    protected Cpu cpu;

    protected List<Argument> arguments = new ArrayList<>();

    public Instruction(String input, Cpu cpu)
    {
        String[] parts = input.split(" ");
        for (int i = 1; i < parts.length; i++) {
            arguments.add(new Argument(parts[i], cpu));
        }
    }

    public abstract void run(Cpu cpu);

    public abstract Instruction toggle();
    
}
