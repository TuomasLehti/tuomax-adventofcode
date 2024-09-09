package fi.tuomax.adventofcode.year2022.day14;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;

/**
 * <p>Solves Advent of Code 2022, day 14, part 2:
 * Regolith Reservoir.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2022/day/14">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class RegolithReservoir_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2022, 14, 2,
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

        long floor = cave.getBottomRight().y() + 2;

        Coordinates sand = new Coordinates(500L, 0L);
        int amount = 0;
        Boolean blocked = false;
        while (!blocked) {
            if (sand.y().equals(floor - 1)) {
                cave.addRock(sand);
                blocked = sand.equals(new Coordinates(500L, 0L));
                amount++;
                sand = new Coordinates(500L, 0L);
//                if ((amount % 100) == 0) 
//                    System.out.println(amount + "\n" + cave.print());
            }
            if (!cave.containsRock(sand.translate(DOWN))) {
                sand = sand.translate(DOWN);
            } else if (!cave.containsRock(sand.translate(DOWN_LEFT))) {
                sand = sand.translate(DOWN_LEFT);
            } else if (!cave.containsRock(sand.translate(DOWN_RIGHT))) {
                sand = sand.translate(DOWN_RIGHT);
            } else {
                cave.addRock(sand);
                blocked = sand.equals(new Coordinates(500L, 0L));
                amount++;
                sand = new Coordinates(500L, 0L);
//                if ((amount % 100) == 0) 
//                    System.out.println(amount + "\n" + cave.print());
            }
        }
//        System.out.println(cave.print());
        setAnswer(amount);
    }


}
