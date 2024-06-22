package fi.tuomax.adventofcode.year2015.day18;

import java.util.List;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.framework.solving.Solver;

/**
 * Solves Advent of Code 2015, day 18, part 1: 
 * Like a GIF For Your Yard.
 * @see 
 *      <a href="https://adventofcode.com/2015/day/18">
 *      Puzzle on the Advent of Code website.</a>
 */

public class LikeAGifForYourYard_Part1 
extends Solver
{

    private Integer rounds = 100;

    public void setRounds(Integer rounds) 
    {
        this.rounds = rounds;
    }

    /**
     * It's basically Conway's Game of Life. A grid is passed around, because
     * it is important to separate the current and the next generation.
     */
    @Override
    protected void solve() 
    {
        Grid<Boolean> grid = getGrid();
        for (int i = 0; i < rounds; i++) {
            grid = step(grid);
        }
        setAnswer(countAliveCells(grid));
    }

    /**
     * Fetches the grid from the parser. This needs to be in a separate method,
     * because part 2 needs to overwrite this.
     */
    protected Grid<Boolean> getGrid()
    {
        return ((LikeAGifForYourYard_Parser) parser).getGrid();
    }

    /**
     * Counts the next state of the grid. A new grid is formed and returned,
     * because the calculation can't be done in-place. If the aliveness of
     * the cell in the top left corner is modified, it will have an effect on
     * the calculation of next cell's amount of alive neighbors.
     */
    private Grid<Boolean> step(Grid<Boolean> grid)
    {
        Grid<Boolean> next = new Grid<>(grid.width(), grid.height());
        for (int r = 0; r < grid.height(); r++) {
            for (int c = 0; c < grid.width(); c++) {
                Integer aliveNeighbors = countAliveNeighbors(grid, c, r);
                next.set(c, r, getNextState(grid, c, r, aliveNeighbors));
            }
        }
        return next;
    }

    private Integer countAliveNeighbors(
        Grid<Boolean> grid, 
        Integer col, 
        Integer row)
    {
        Integer aliveNeighbors = 0;
        List<Boolean> neighbors = grid.neighbors(col, row);
        for (Boolean neighbor : neighbors) {
            if (neighbor != null && neighbor)
                aliveNeighbors++;
        }
        return aliveNeighbors;
    }

    /**
     * This is going to be overridden in part 2.
     */
    protected Boolean getNextState(
        Grid<Boolean> grid, 
        Integer col, 
        Integer row, 
        Integer aliveNeighbors)
    {
        if (grid.get(col, row)) 
            return aliveNeighbors == 2 || aliveNeighbors == 3;
        else
            return aliveNeighbors == 3;
    }

    private Integer countAliveCells(Grid<Boolean> grid)
    {
        Integer result = 0;
        for (List<Boolean> row : grid) {
            for (Boolean cell : row) {
                if (cell != null && cell) 
                    result++;
            }
        }
        return result;
    }

    @Override
    protected Metadata manufactureMetadata() 
    {
        return new Metadata(
            2015, 18, 1, 
            "Like a GIF For Your Yard", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input) 
    {
        return new LikeAGifForYourYard_Parser(input);
    }

}
