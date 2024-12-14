package fi.tuomax.adventofcode.year2024.day14;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.framework.parsing.Parser;

public class RestroomRedoubt_Parser
extends Parser
{

    private List<Robot> robots = new ArrayList<>();

    public List<Robot> getRobots() 
    {
        return robots;
    }

    public RestroomRedoubt_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        for (String line : input)
            robots.add(new Robot(line));
    }

}
