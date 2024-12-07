package fi.tuomax.adventofcode.year2024.day06;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Direction.TurnDirection;
import fi.tuomax.adventofcode.commons.Walker;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.LoggerFactory;

/**
 * <p>Solves Advent of Code 2024, day 6, part 2:
 * Guard Gallivant.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2024/day/6">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class GuardGallivant_Part2
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2024, 6, 2,
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

    protected record PartOfRoute( 
        Coordinates pos,
        Direction dir
    ) {}

    /* A cheaky side effect. */
    protected Set<Coordinates> latestVisitedCells;

    /* Return -1 if enters loop, otherwise num of visited locations. */
    protected Integer numOfVisitedDuringRound(List<Coordinates> obstacles)
    {
        
        Walker walker = new Walker();
        walker.setCurrentCoords(parser().getStart());
        Direction dir = Direction.getInstance(Direction.NORTH);

        Set<PartOfRoute> partsOfRoute = new HashSet<>();
        partsOfRoute.add(new PartOfRoute(parser().getStart(), dir));

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
            if (obstacles.contains(next)) {
                dir = dir.turn(TurnDirection.RIGHT);
                continue;
            }

            walker.step(dir);

            PartOfRoute current = new PartOfRoute(walker.getCurrentCoords(), dir);
            if (partsOfRoute.contains(current)) return -1;
            partsOfRoute.add(current);
        }

        latestVisitedCells = walker.getVisited();
        Integer result = walker.numOfVisited();
        if (!revisitsOrigin) result--;
        return result;
    }

    @Override
    protected void solve()
    {
        List<Coordinates> originalObstacles = parser().getObstacles();
        
        numOfVisitedDuringRound(originalObstacles);
        Set<Coordinates> originalROute = latestVisitedCells;

        Integer idx = 0;
        Integer result = 0;
        for (Coordinates coordinates : originalROute) {
            if (idx % 100 == 0) LoggerFactory.getLogger(getClass()).debug(idx + "/" + originalROute.size());
            idx++;
            if (coordinates.equals(parser().getStart())) continue;
            List<Coordinates> obstacles = new ArrayList<>(originalObstacles);
            obstacles.add(coordinates);
            if (numOfVisitedDuringRound(obstacles).equals(-1)) result++;
        }

        setAnswer(result);

    }

}
