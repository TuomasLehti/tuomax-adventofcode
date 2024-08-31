package fi.tuomax.adventofcode.year2022.day03;

import java.util.List;

/**
 * <p>Parses input for Advent of Code 2022, day 3. The items in the rucksacks
 * are divided into different groups.</p>
 */
public class RucksackReorganization_Parser_Part2
extends RucksackReorganization_Parser
{

    public RucksackReorganization_Parser_Part2(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (int i = 0; i < input.size(); i += 3)
            putRucksack(
                input.get(i),
                new String[]{
                    input.get(i + 1),
                    input.get(i + 2)
                }
            );
    }
    
}
