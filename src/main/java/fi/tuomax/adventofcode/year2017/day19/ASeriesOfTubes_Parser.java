package fi.tuomax.adventofcode.year2017.day19;

import java.util.List;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class ASeriesOfTubes_Parser
extends Parser
{

    private Diagram diagram = new Diagram();

    public Diagram getDiagram() 
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
                diagram.addPath(col, row, c);
                col++;
            }
            row--; // the coordinates in mathematical coordinate space are getting smaller when you go down/south
            col = 0;
        }
    }

}
