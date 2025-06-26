package fi.tuomax.adventofcode.year2017.day19;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class ASeriesOfTubes_Parser
extends Parser
{

    private Map<Coordinates, Character> diagram = new HashMap<>();

    public Map<Coordinates, Character> getDiagram() 
    {
        return diagram;
    }

    public ASeriesOfTubes_Parser(List<String> input)
    {
        super(input);
    }

    @Override
    public void parse()
    {
        int row = 0;
        int col = 0;
        for (String line : input) {
            for (char c : line.toCharArray()) {
                if (c != ' ')
                    diagram.put(Coordinates.fromInteger(col, row), c);
                col++;
            }
            row--; // the coordinates in mathematical coordinate space are getting smaller when you go down/south
            col = 0;
        }
    }

}
