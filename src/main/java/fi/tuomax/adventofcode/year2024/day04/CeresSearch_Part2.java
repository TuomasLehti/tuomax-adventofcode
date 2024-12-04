package fi.tuomax.adventofcode.year2024.day04;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Grid;

/**
 * <p>Solves Advent of Code 2024, day 4, part 2:
 * Ceres Search.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/4">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CeresSearch_Part2
extends CeresSearch_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 4, 2,
            "Ceres Search", ""
        );
    }

    @Override
    protected Integer numOfXmas(Grid<Character> cells, Coordinates coords)
    {
        if (
            coords.xAsInt().equals(0) || 
            coords.xAsInt().equals(cells.width() - 1) ||
            coords.yAsInt().equals(0) || 
            coords.yAsInt().equals(cells.height() - 1) ||
            !cells.get(coords).equals('A')
        ) {
            return 0;
        }

        /* Silly verbosity to reduce line length. */
        Direction dirNw = Direction.getInstance(Direction.NORTHWEST);
        Direction dirSw = Direction.getInstance(Direction.SOUTHWEST);
        Direction dirNe = Direction.getInstance(Direction.NORTHEAST);
        Direction dirSe = Direction.getInstance(Direction.SOUTHEAST);
        Coordinates neighborNw = coords.translate(dirNw.asCoordinates());
        Coordinates neighborSw = coords.translate(dirSw.asCoordinates());
        Coordinates neighborNe = coords.translate(dirNe.asCoordinates());
        Coordinates neighborSe = coords.translate(dirSe.asCoordinates());

        Integer count = 0;
        if (
            ((cells.get(neighborNw).equals('M') && 
              cells.get(neighborSe).equals('S')) ||
             (cells.get(neighborNw).equals('S') && 
              cells.get(neighborSe).equals('M'))) &&

            ((cells.get(neighborNe).equals('M') && 
              cells.get(neighborSw).equals('S')) ||
             (cells.get(neighborNe).equals('S') && 
              cells.get(neighborSw).equals('M')))
        ) {
            count++;
        }
        return count;
    }


}
