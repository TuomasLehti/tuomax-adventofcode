package fi.tuomax.adventofcode.year2024.day06;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Walker;
import fi.tuomax.adventofcode.commons.Direction.TurnDirection;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2024, day 6, part 1:
 * Guard Gallivant.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/6">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class GuardGallivant_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 6, 1,
            "Guard Gallivant", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new GuardGallivant_Parser(input);
    }

    private GuardGallivant_Parser parser()
    {
        return (GuardGallivant_Parser) parser;
    }

    @Override
    protected void solve()
    {
        Walker walker = new Walker();
        walker.setCurrentCoords(parser().getStart());
        Direction dir = Direction.getInstance(Direction.NORTH);

        Boolean revisitsOrigin = false;

        while (
            walker.getCurrentCoords().x() >= 0 &&
            walker.getCurrentCoords().y() <= 0 &&
            walker.getCurrentCoords().x() < parser().getSize().x() &&
            walker.getCurrentCoords().y() > ((parser().getSize().y() * -1) + 1)
        ) {

            if (walker.getCurrentCoords().equals(Coordinates.ORIGIN))
                revisitsOrigin = true;

            Coordinates next = walker.getCurrentCoords().translate(dir.asCoordinates());
            if (parser().getObstacles().contains(next)) {
                dir = dir.turn(TurnDirection.RIGHT);
                continue;
            }

            walker.step(dir);
        }

         for (int row = 0; row <= parser().getSize().x(); row++) {
            for (int col = 0; col < (parser().getSize().x()); col++) {
                Coordinates c = Coordinates.fromInteger(col, (row * -1));
                if (parser().getStart().equals(c))
                    System.out.print("^");
                else if (walker.getVisited().contains(c))
                    System.out.print("X");
                else if (parser().getObstacles().contains(c))
                    System.out.print("#");
                else
                    System.out.print(".");
            }
            System.out.println();
        }
 
        Integer result = walker.numOfVisited();
//        result--; //for the last position outside the grid
        if (!revisitsOrigin) result--;
        setAnswer(result); // -1 for 0,0 and -1 
    }

}

// 5176 too low