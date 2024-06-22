package fi.tuomax.adventofcode.year2015.day14;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * Parses the input for Advent of Code 2015, day 14, part 1 into participants.
 */
public class ReindeerOlympics_Parser_Part2
extends Parser
{

    private List<Participant> herd = new ArrayList<>();

    public List<Participant> getHerd() 
    {
        return herd;
    }

    public ReindeerOlympics_Parser_Part2(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input) {
            herd.add(new Participant(Reindeer.fromInput(line)));
        }
    }

}
