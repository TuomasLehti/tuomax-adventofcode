package fi.tuomax.adventofcode.year2015.day18;

import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2015, day 18, part 2: 
 * Like a GIF For Your Yard.</p>
 * 
 * <p>This is based on the solution for part 1. Some methods have been 
 * overridden to take the additional rule for part 2 into account.</p>
 * 
 * @see 
 *      <a href="https://adventofcode.com/2015/day/18">
 *      Puzzle on the Advent of Code website.</a>
 */
public class LikeAGifForYourYard_Part2 
extends LikeAGifForYourYard_Part1
{

    @Override
    protected Boolean getNextState(
        Grid<Boolean> grid, 
        Integer col, 
        Integer row, 
        Integer aliveNeighbors) 
    {
        if (isCorner(grid, col, row)) 
            return true;
        else
            if (grid.get(col, row)) 
                return aliveNeighbors == 2 || aliveNeighbors == 3;
            else
                return aliveNeighbors == 3;
    }

    private Boolean isCorner(Grid<Boolean> grid, int col, int row)
    {
        return 
            (col == 0 && row == 0) ||
            (col == 0 && row == grid.height() - 1) ||
            (col == grid.width() - 1 && row == 0) ||
            (col == grid.width() - 1 && row == grid.height() - 1);
    }

    @Override
    protected Grid<Boolean> getGrid() 
    {
        Grid<Boolean> grid = ((LikeAGifForYourYard_Parser) parser).getGrid();
        grid.set(0, 0, true);
        grid.set(0, grid.height() - 1, true);
        grid.set(grid.width() - 1, 0, true);
        grid.set(grid.width() - 1, grid.height() - 1, true);
        return grid;
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 18, 2, 
            "Like a GIF For Your Yard", ""
        );
    }
    
}
