package fi.tuomax.adventofcode.year2016.day16;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

public class DragonChecksum_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 16, 2,
            "Dragon Checksum", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new StringParser(input);
    }

    @Override
    protected void solve() 
    {
        String initialState = ((StringParser) parser).getString();
        String disk = DiskFiller.fill(initialState, parameters.getInt("part2"));
        String checksum = CheckSum.calculate(disk);
        setAnswer(checksum);
    }


    
}
