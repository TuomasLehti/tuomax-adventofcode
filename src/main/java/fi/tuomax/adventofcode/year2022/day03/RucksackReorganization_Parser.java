package fi.tuomax.adventofcode.year2022.day03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.adventofcode.framework.parsing.Parser;

/**
 * <p>Parses input for Advent of Code 2022, day 3. The items in the rucksacks
 * are divided into different groups.</p>
 */
public abstract class RucksackReorganization_Parser
extends Parser
{

    Map<String, String[]> rucksacks = new HashMap<>();

    protected void putRucksack(String s, String[] ss)
    {
        rucksacks.put(s, ss);
    }

    public Map<String, String[]> getRucksacks() 
    {
        return rucksacks;
    }

    public RucksackReorganization_Parser(List<String> input) 
    {
        super(input);
    }
    
}
