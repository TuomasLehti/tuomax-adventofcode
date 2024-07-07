package fi.tuomax.adventofcode.year2016.day09;

import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2016, day 9, part 1: 
 * Explosives in Cyberspace
 * @see 
 *      <a href="https://adventofcode.com/2016/day/9">
 *      Puzzle on the Advent of Code website.</a>
 */
public class ExplosivesInCyberspace_Part1 
extends Solver
{

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2016, 9, 1,
            "Explosives in Cyberspace", ""
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
        Decompressor decompressor = new Decompressor();
        setAnswer(decompressor.decompress(((StringParser) parser).getString()));
    }


    
}

//112831 too high
