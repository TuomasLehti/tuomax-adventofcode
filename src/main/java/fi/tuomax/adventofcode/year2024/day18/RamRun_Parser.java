package fi.tuomax.adventofcode.year2024.day18;

import java.util.List;

import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.commons.pathfinding.GridMazeGenerator;

public class RamRun_Parser
extends Coordinatess_Parser
{

    public GridMazeGenerator getGenerator() 
    {
        return generator;
    }

    private GridMazeGenerator generator;
        
    private Integer height;
    
    private Integer width;

    private Integer amount;
        
    public RamRun_Parser(List<String> input, Integer width, Integer height, Integer amount)
    {
        super(input);
        this.width = width;
        this.height = height;
        this.amount = amount;
    }

    @Override
    public void parse()
    {
        super.parse();
        Grid<Boolean> grid = new Grid<>(width, height);
        for (int row = 0; row < height; row++)
            for (int col = 0; col < width; col++)
                grid.set(col, row, false);
        for (int i = 0; i < amount; i++)
            grid.set(getCoords().get(i), true);
        generator = new GridMazeGenerator(grid);
    }

}
