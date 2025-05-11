package fi.tuomax.adventofcode.year2017.day06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class MemoryReallocation_Parser
extends Parser
{

    private List<Integer> ints = new ArrayList<>();

    public List<Integer> getInts() 
    {
        return ints;
    }

    public MemoryReallocation_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        List<String> parts = Arrays.asList(
            input.get(0)
                .replaceAll("\\s+", " ")
                .split(" ")
        );
        for (String part : parts) {
            ints.add(Integer.valueOf(part));
        }
    }

}
