package fi.tuomax.adventofcode.year2017.day23;

import fi.tuomax.adventofcode.commons.cpu.Argument;
import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Multiply;

public class MultiplyCounter 
extends Multiply
{

    public static Long runCount = 0L;

    public MultiplyCounter(Cpu cpu, Argument accumulator, Argument amount) 
    {
        super(cpu, accumulator, amount);
    }
 
    @Override
    public void run() 
    {
        MultiplyCounter.runCount++;
        if (MultiplyCounter.runCount % 1_000_000 == 0)
            System.out.println(MultiplyCounter.runCount);
        super.run();
    }    

}
