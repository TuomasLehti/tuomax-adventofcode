package fi.tuomax.adventofcode.year2015.day23;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class OpeningTheTuringLock_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 23, 1,
            "Opening the Turing Lock", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new OpeningTheTuringLock_Parser(input);
    }

    @Override
    protected void solve() 
    {
        CPU cpu = ((OpeningTheTuringLock_Parser) parser).getCpu();
        cpu.run();
        setAnswer(cpu.getRegister("b"));
    }
    
}
