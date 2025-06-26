package fi.tuomax.adventofcode.year2017.day19;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;
import java.util.Map;

/**
 * <p>Solves Advent of Code 2017, day 19, part 1:
 * A Series of Tubes.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/19">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class ASeriesOfTubes_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 19, 1,
            "A Series of Tubes", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new ASeriesOfTubes_Parser(input);
    }

    private Map<Coordinates, Character> diagram;

    @Override
    protected void solve()
    {
        diagram = ((ASeriesOfTubes_Parser) parser).getDiagram();

        String letters = "";

        /* Find the starting position. */
        Coordinates currentPos = null;
        for (Coordinates coords : diagram.keySet()) {
            if (coords.y().equals(0L) && diagram.get(coords).equals('|')) {
                currentPos = coords;
                break;
            }
        }

        /* The packet is travelling south at the start. */
        Direction dir = Direction.getInstance(Direction.SOUTH);

        Boolean finished = false;
        while (!finished) {
            /* Travel to the next corner. */
            Coordinates nextPos = null;
            do {
                nextPos = currentPos.translate(dir.asCoordinates());
                if  (Character.isLetter(diagram.get(nextPos))) {
                    letters = letters + diagram.get(nextPos);
                }
                currentPos = nextPos;
            } while (!(isCorner(nextPos) || isDeadEnd(nextPos)));

            /* Determine the next direction. */
            if (dir.get() == Direction.SOUTH || dir.get() == Direction.NORTH) {
                if (diagram.get(currentPos.translate(Direction.getInstance(Direction.WEST).asCoordinates())) != null)
                    dir = Direction.getInstance(Direction.WEST);
                else if (diagram.get(currentPos.translate(Direction.getInstance(Direction.EAST).asCoordinates())) != null)
                    dir = Direction.getInstance(Direction.EAST);
                else 
                    finished = true;
            } else {
                if (diagram.get(currentPos.translate(Direction.getInstance(Direction.NORTH).asCoordinates())) != null)
                    dir = Direction.getInstance(Direction.NORTH);
                else if (diagram.get(currentPos.translate(Direction.getInstance(Direction.SOUTH).asCoordinates())) != null)
                    dir = Direction.getInstance(Direction.SOUTH);
                else
                    finished = true;
            }
        }

        setAnswer(letters);
    }

    private Boolean isDeadEnd(Coordinates coords)
    {
        int numOfExits = 0;
        if (hasExit(coords, Direction.NORTH))
            numOfExits++;
        if (hasExit(coords, Direction.EAST))
            numOfExits++;
        if (hasExit(coords, Direction.SOUTH))
            numOfExits++;
        if (hasExit(coords, Direction.WEST))
            numOfExits++;
        return numOfExits == 1;
    }

    private Boolean isCorner(Coordinates coords)
    {
        return 
            (
                hasExit(coords, Direction.NORTH) && 
                hasExit(coords, Direction.EAST) && 
                !hasExit(coords, Direction.SOUTH) && 
                !hasExit(coords, Direction.WEST)
            ) || (
                hasExit(coords, Direction.EAST) && 
                hasExit(coords, Direction.SOUTH) && 
                !hasExit(coords, Direction.WEST) && 
                !hasExit(coords, Direction.NORTH)
            ) || (
                hasExit(coords, Direction.SOUTH) && 
                hasExit(coords, Direction.WEST) && 
                !hasExit(coords, Direction.NORTH) && 
                !hasExit(coords, Direction.EAST)
            ) || (
                hasExit(coords, Direction.WEST) && 
                hasExit(coords, Direction.NORTH) && 
                !hasExit(coords, Direction.EAST) && 
                !hasExit(coords, Direction.SOUTH)
            );
    }

    private Boolean hasExit(Coordinates coords, int dir)
    {
        return diagram.get(coords.translate(Direction.getInstance(dir).asCoordinates())) != null;
    }
    

}
