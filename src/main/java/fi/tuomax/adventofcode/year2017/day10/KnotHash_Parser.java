package fi.tuomax.adventofcode.year2017.day10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class KnotHash_Parser
extends Parser
{

    private List<Integer> ints = new ArrayList<>();

    public List<Integer> getInts() 
    {
        return ints;
    }

    public KnotHash_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        List<String> parts = Arrays.asList(
            input.get(0)
                 .split(",")
        );
        for (String part : parts) {
            ints.add(Integer.valueOf(part));
        }
    }

}
