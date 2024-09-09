package fi.tuomax.adventofcode.year2022.day14;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 14, part 1:
 * Regolith Reservoir.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/14">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RegolithReservoir_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 14, 1,
            "Regolith Reservoir", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new RegolithReservoir_Parser(input);
    }

    @Override
    protected void solve()
    {
        Cave cave = ((RegolithReservoir_Parser) parser).getCave();
//        System.out.println(cave.print());

        final Coordinates DOWN = Direction.getInstance(Direction.NORTH).asCoordinates();
        final Coordinates DOWN_LEFT = Direction.getInstance(Direction.NORTHWEST).asCoordinates();
        final Coordinates DOWN_RIGHT = Direction.getInstance(Direction.NORTHEAST).asCoordinates();

        Coordinates sand = new Coordinates(500L, 0L);
        int amount = 0;
        Boolean stopped = false;
        while (sand.y() <= cave.getBottomRight().y()) {
            while (!stopped && sand.y() <= cave.getBottomRight().y()) {
                if (!cave.containsRock(sand.translate(DOWN))) {
                    sand = sand.translate(DOWN);
                } else if (!cave.containsRock(sand.translate(DOWN_LEFT))) {
                    sand = sand.translate(DOWN_LEFT);
                } else if (!cave.containsRock(sand.translate(DOWN_RIGHT))) {
                    sand = sand.translate(DOWN_RIGHT);
                } else {
                    cave.addRock(sand);
                    stopped = true;
                }
            }
            if (stopped) {
                amount++;
                sand = new Coordinates(500L, 0L);
                stopped = false;
            }

//            if (amount == 1 || amount == 2 || amount == 5 || amount == 22 || amount == 24)
//                System.out.println(amount + "\n" + cave.print());
        }

        setAnswer(amount);
    }

}
