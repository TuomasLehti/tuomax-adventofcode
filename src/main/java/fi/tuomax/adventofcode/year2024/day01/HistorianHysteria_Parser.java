package fi.tuomax.adventofcode.year2024.day01;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class HistorianHysteria_Parser
extends Parser
{

    private List<Integer> left = new ArrayList<>();

    public List<Integer> getLeft() 
    {
        return left;
    }

    private List<Integer> right = new ArrayList<>();

    public List<Integer> getRight() 
    {
        return right;
    }

    public HistorianHysteria_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input) {
            String[] parts = line.split(" +");
            left.add(Integer.valueOf(parts[0]));
            right.add(Integer.valueOf(parts[1]));
        }

    }

}
