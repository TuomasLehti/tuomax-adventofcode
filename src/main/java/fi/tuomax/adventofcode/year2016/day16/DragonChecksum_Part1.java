package fi.tuomax.adventofcode.year2016.day16;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * <p>Solves Advent of Code 2016, day 16, part 1: 
 * Dragon Checksum.</p>
 * 
 * @see 
 *      <p><a href="https://adventofcode.com/2016/day/16">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class DragonChecksum_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 16, 1,
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
        String disk = DiskFiller.fill(initialState, parameters.getInt("length"));
        String checksum = CheckSum.calculate(disk);
        setAnswer(checksum);
    }


    
}
