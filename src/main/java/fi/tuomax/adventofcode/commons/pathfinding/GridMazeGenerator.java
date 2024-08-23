package fi.tuomax.adventofcode.commons.pathfinding;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Grid;

/**
 * A maze generator backed up by a grid of booleans.
 */
public class GridMazeGenerator 
extends MazeGenerator
{

    private Grid<Boolean> grid;

    public GridMazeGenerator(Grid<Boolean> grid)
    {
        this.grid = grid;
    }

    @Override
    public Boolean isWall(Coordinates coordinates) 
    {
        return grid.get(coordinates.xAsInt(), coordinates.yAsInt());
    }
    
}
