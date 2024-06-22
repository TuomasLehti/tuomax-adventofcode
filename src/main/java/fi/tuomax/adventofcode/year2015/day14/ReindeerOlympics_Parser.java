package fi.tuomax.adventofcode.year2015.day14;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * Parses the input for Advent of Code 2015, day 14, part 1 into reindeer.
 */
public class ReindeerOlympics_Parser 
extends Parser
{

    private List<Reindeer> herd = new ArrayList<>();

    public List<Reindeer> getHerd() 
    {
        return herd;
    }

    public ReindeerOlympics_Parser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input) {
            herd.add(Reindeer.fromInput(line));
        }
    }

}
