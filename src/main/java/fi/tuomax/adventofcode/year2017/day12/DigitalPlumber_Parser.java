package fi.tuomax.adventofcode.year2017.day12;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class DigitalPlumber_Parser
extends Parser
{

    private Map<String, List<String>> pipes = new HashMap<>();

    public Map<String, List<String>> getPipes() 
    {
        return pipes;
    }

    public DigitalPlumber_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            pipes.put(
                line.split(" <-> ")[0],
                Arrays.asList(line.split(" <-> ")[1].split(", "))
            );
        }
    }

}
