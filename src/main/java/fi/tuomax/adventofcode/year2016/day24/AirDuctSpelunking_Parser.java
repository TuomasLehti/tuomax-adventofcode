package fi.tuomax.adventofcode.year2016.day24;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.commons.pathfinding.GridMazeGenerator;
import fi.tuomax.adventofcode.commons.pathfinding.MazeGenerator;
import fi.tuomax.adventofcode.framework.parsing.Parser;

public class AirDuctSpelunking_Parser 
extends Parser
{

    private MazeGenerator maze;

    public MazeGenerator getMaze() 
    {
        return maze;
    }

    /* Must be class-wide because the dimensions are defined in constructor. */
    private Grid<Boolean> grid;

    private Map<Integer, Coordinates> targets = new HashMap<>();

    public Map<Integer, Coordinates> getTargets() 
    {
        return targets;
    }

    public AirDuctSpelunking_Parser(List<String> input) 
    {
        super(input);
        Integer width = input.get(0).length();
        Integer height = input.size();
        grid = new Grid<>(width, height);

    }

    @Override
    public void parse() 
    {
        for (int row = 0; row < input.size(); row++)
            for (int col = 0; col < input.get(row).length(); col++)
                switch (input.get(row).charAt(col)) {
                    case '#':
                        grid.set(col, row, true);
                        break;
                    case '.':
                        grid.set(col, row, false);
                        break;
                    default:
                        grid.set(col, row, false);
                        targets.put(
                                Integer.valueOf(Character.toString(input.get(row).charAt(col))), 
                                new Coordinates((long) col, (long) row));
                        break;
                }
        maze = new GridMazeGenerator(grid);
    }
    
}
