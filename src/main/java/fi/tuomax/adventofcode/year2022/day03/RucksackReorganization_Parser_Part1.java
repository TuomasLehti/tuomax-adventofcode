package fi.tuomax.adventofcode.year2022.day03;

import java.util.List;

/**
 * <p>Parses input for Advent of Code 2022, day 3. The items in the rucksacks
 * are divided into different groups.</p>
 */
public class RucksackReorganization_Parser_Part1 
extends RucksackReorganization_Parser
{

    public RucksackReorganization_Parser_Part1(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String line : input)
            putRucksack(
                line.substring(0, (line.length() / 2)),
                new String[]{line.substring(line.length() / 2)}
            );
    }
    
}
