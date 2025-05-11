package fi.tuomax.adventofcode.year2017.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class IntegerArrayParser 
extends Parser
{

    private List<List<Integer>> ints = new ArrayList<>();

    public List<List<Integer>> getInts() 
    {
        return ints;
    }

    public IntegerArrayParser(List<String> input) 
    {
        super(input);
    }

    @Override
    public void parse() 
    {
        for (String row : input) {
            List<String> cols = Arrays.asList(
                row.replaceAll("\\s+", " ")
                   .split(" ")
            );
            List<Integer> nums = new ArrayList<>();
            for (String col : cols) {
                nums.add(Integer.valueOf(col));
            }
            ints.add(nums);
        }
    }
    
}
