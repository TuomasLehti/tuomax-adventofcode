package fi.tuomax.adventofcode.year2017.day18;

import java.util.List;

import fi.tuomax.adventofcode.commons.cpu.Cpu;
import fi.tuomax.adventofcode.commons.cpu.Cpu_Parser;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class Duet_Parser
extends Parser
{

    Cpu one;

    public Cpu getOne() 
    {
        return one;
    }

    Cpu other;

    public Cpu getOther() 
    {
        return other;
    }

    public Duet_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        Cpu_Parser cpuParser = new Cpu_Parser(input, new Duet_InsturctionFactory_Part2(), new String[]{});
        cpuParser.parse();
        one = cpuParser.getCpu();
        one.setRegister("p", 0L);

        cpuParser = new Cpu_Parser(input, new Duet_InsturctionFactory_Part2(), new String[]{});
        cpuParser.parse();
        other = cpuParser.getCpu();
        other.setRegister("p", 1L);

        /* The p register gets used in the calculations, so we save the index of the cpu to another
         * place also. */
        one.setRegister("cpu", 0L);
        other.setRegister("cpu", 1L);
    }

}
