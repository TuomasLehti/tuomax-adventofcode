package fi.tuomax.adventofcode.year2022.day12;

import java.util.List;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class HillClimbingAlgorithm_Parser
extends Parser
{

    Grid<Integer> map;

    public Grid<Integer> getMap() 
    {
        return map;
    }

    Coordinates start;

    public Coordinates getStart() 
    {
        return start;
    }

    Coordinates end;

    public Coordinates getEnd() 
    {
        return end;
    }

    public HillClimbingAlgorithm_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        String alphabet  = "abcdefghijklmnopqrstuvwxyz";
        map = new Grid<>(input.get(0).length(), input.size());
        for (int row = 0; row < map.height(); row++)
            for (int col = 0; col < map.width(); col++) {
                char c = input.get(row).charAt(col);
                if (c == 'S') {
                    start = new Coordinates((long) col, (long) row);
                    map.set(col, row, alphabet.indexOf('a'));
                } else if (c == 'E') {
                    end = new Coordinates((long) col, (long) row);
                    map.set(col, row, alphabet.indexOf('z'));
                } else {
                    map.set(col, row, alphabet.indexOf(c));
                }
            }

    }

}
