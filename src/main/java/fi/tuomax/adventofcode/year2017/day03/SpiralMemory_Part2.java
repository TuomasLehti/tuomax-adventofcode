package fi.tuomax.adventofcode.year2017.day03;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.parsing.StringParser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <p>Solves Advent of Code 2017, day 3, part 2:
 * Spiral Memory.</p>
 * 
 * <p>After the math-oriented part 1 this felt wrong.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/3">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class SpiralMemory_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 3, 2,
            "Spiral Memory", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new StringParser(input);
    }

    @Override
    protected void solve()
    {
        int target = Integer.valueOf(((StringParser) parser).getString());

        final int NORTH = 0;
        final int WEST = 1;
        final int SOUTH = 2;
        final int EAST = 3;

        int dir = 3;
        int x = 0;
        int y = 0;
        int val = 1;

        Map<Coordinates, Integer> spiral = new HashMap<>();

        while (true) {
            if (!spiral.isEmpty()) val =
                spiral.getOrDefault(Coordinates.fromInteger(x - 1, y - 1), 0) +
                spiral.getOrDefault(Coordinates.fromInteger(x    , y - 1), 0) +
                spiral.getOrDefault(Coordinates.fromInteger(x + 1, y - 1), 0) +
                spiral.getOrDefault(Coordinates.fromInteger(x - 1, y    ), 0) +
                spiral.getOrDefault(Coordinates.fromInteger(x + 1, y    ), 0) +
                spiral.getOrDefault(Coordinates.fromInteger(x - 1, y + 1), 0) +
                spiral.getOrDefault(Coordinates.fromInteger(x    , y + 1), 0) +
                spiral.getOrDefault(Coordinates.fromInteger(x + 1, y + 1), 0);
            if (val > target) {
                setAnswer(val);
                break;
            }
            spiral.put(Coordinates.fromInteger(x, y), val);
            switch (dir) {
                case NORTH : y--; break;
                case WEST  : x--; break;
                case SOUTH : y++; break;
                case EAST  : x++; break;
            }
            if (dir == NORTH && !spiral.containsKey(Coordinates.fromInteger(x - 1, y))) {
                dir = WEST;
            } else if (dir == WEST && !spiral.containsKey(Coordinates.fromInteger(x, y + 1))) {
                dir = SOUTH;
            } else if (dir == SOUTH && !spiral.containsKey(Coordinates.fromInteger(x + 1, y))) {
                dir = EAST;
            } else if (dir == EAST && !spiral.containsKey(Coordinates.fromInteger(x, y - 1))) {
                dir = NORTH;
            }
        }

    }

}
