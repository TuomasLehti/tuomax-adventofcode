package fi.tuomax.adventofcode.year2024.day04;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Grid;
import fi.tuomax.adventofcode.commons.Direction.TurnDirection;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2024, day 4, part 1:
 * Ceres Search.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/4">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class CeresSearch_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 4, 1,
            "Ceres Search", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new CeresSearch_Parser(input);
    }

    @Override
    protected void solve()
    {
        Direction.directionMode = Direction.DirectionMode.EIGHT_DIRS;
        Grid<Character> cells = ((CeresSearch_Parser) parser).getCells();
        Long count = 0L;
        for (int row = 0; row < cells.height(); row++) {
            for (int col = 0; col < cells.width(); col++) {

                Direction dir = Direction.getInstance(Direction.NORTH);
                do {
                    Coordinates coords = Coordinates.fromInteger(col, row);
                    StringBuilder sb = new StringBuilder();
                    for (int c = 0; c < 4; c++) {
                        if (cells.exists(coords))
                            sb.append(cells.get(coords));
                        coords = coords.translate(dir.asCoordinates());
                    }
/*                     System.out.println("dir: "+ dir.get());
                    System.out.println(sb.toString()); */
                    if (sb.toString().equals("XMAS"))
                        count++;
                    dir = dir.turn(TurnDirection.RIGHT);
/*                     System.out.println("new dir: "+ dir.get());                     */
                } while (!dir.get().equals(Direction.getInstance(Direction.NORTH).get()));

            }
        }
        setAnswer(count);
    }

}
