package fi.tuomax.adventofcode.year2024.day06;

import java.util.ArrayList;
import java.util.List;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class GuardGallivant_Parser
extends Parser
{

    private List<Coordinates> obstacles = new ArrayList<>();

    public List<Coordinates> getObstacles() 
    {
        return obstacles;
    }

    private Coordinates start;

    public Coordinates getStart() 
    {
        return start;
    }

    private Coordinates size;

    public Coordinates getSize() 
    {
        return size;
    }

    public GuardGallivant_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        size = Coordinates.fromInteger(input.get(0).length(), input.size());
        Long row = 0L;
        Long col = 0L;
        for (String line : input) {
            for (Character c : line.toCharArray()) {
                if (c.equals('#'))
                    obstacles.add(new Coordinates(col, row));
                else if (c.equals('^'))
                    start = new Coordinates(col, row);
                col++;
            }
            row--;
            col = 0L;
        }
    }

}
