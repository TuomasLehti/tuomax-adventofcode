package fi.tuomax.adventofcode.framework;

import java.util.List;

/**
 * Parses Advent of Code input, when the input is a single string.
 */
public class StringParser 
extends Parser
{

    public StringParser(List<String> input) 
    {
        super(input);
    }

    @Override
    protected void parse() 
    {
        /* Nothing to do. The string is already stored in the list. */
    }

    public String getString()
    {
        return input.get(0);
    }
    
}
