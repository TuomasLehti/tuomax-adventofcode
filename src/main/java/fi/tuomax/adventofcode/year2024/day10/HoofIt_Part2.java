package fi.tuomax.adventofcode.year2024.day10;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2024, day 10, part 2:
 * Hoof It.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/10">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class HoofIt_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 10, 2,
            "Hoof It", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new HoofIt_Parser(input);
    }

    private HoofIt_Parser parser()
    {
        return (HoofIt_Parser) parser;
    }

    protected Grid<MapCell> cells;

    private Integer pathFinder(Coordinates current)
    {
        MapCell curr = cells.get(current);
        if (curr.getVisited()) return 0;
        if (curr.getElevation().equals(9)) {
            return 1;
        }

        Integer result = 0;
        cells.get(current).setVisited(true);
        for (MapCell reachable : cells.get(current).getReachableNeighbors()) {
            result += pathFinder(reachable.getCoordinates());
        }
        cells.get(current).setVisited(false);
        return result;
    }

    @Override
    protected void solve()
    {
        cells = parser().getCells();
        Integer result = 0;
        for (int r = 0; r < cells.height(); r++) {
            for (int c = 0; c < cells.width(); c++) {
                if (cells.get(c, r).getElevation().equals(0)) {
                    Integer res = pathFinder(Coordinates.fromInteger(c, r));
                    result += res;
                    clearVisited();
                    LoggerFactory.getLogger(getClass()).debug(String.format("(%d,%d): %d", c, r, res));
                }
            }
        }
        setAnswer(result);
    }

    private void clearVisited()
    {
        for (int r = 0; r < cells.height(); r++) 
            for (int c = 0; c < cells.width(); c++)
                cells.get(c, r).setVisited(false);
    }


}
