package fi.tuomax.adventofcode.year2017.day22;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Direction.TurnDirection;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import java.util.List;
import java.util.Set;

/**
 * <p>Solves Advent of Code 2017, day 22, part 1:
 * Sporifica Virus.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/22">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class SporificaVirus_Part1
extends Solver
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 22, 1,
            "Sporifica Virus", ""
        );
    }

    @Override
    protected Parser manufactureParser(List<String> input)
    {
        return new SporificaVirus_Parser(input);
    }

    @Override
    protected void solve()
    {
        Long numOfBursts = getParamLong("num_of_bursts");
        Integer mapSize = ((SporificaVirus_Parser) parser).getMapSize();
        Set<Coordinates> infected = ((SporificaVirus_Parser) parser).getStatusMap();
        Coordinates currentPosition = Coordinates.fromInteger(mapSize / 2, -mapSize / 2);
        Direction currentDirection = Direction.getInstance(Direction.NORTH);
        Long numOfInfected = 0L;
        for (long burstIdx = 0; burstIdx < numOfBursts; burstIdx++) {
            if (burstIdx % 1000 == 0)
                System.out.println(burstIdx);
            if (infected.contains(currentPosition)) {
                currentDirection = currentDirection.turn(TurnDirection.RIGHT);
                infected.remove(currentPosition);
                currentPosition = currentPosition.translate(currentDirection.asCoordinates());
            } else {
                currentDirection = currentDirection.turn(TurnDirection.LEFT);
                infected.add(currentPosition);
                numOfInfected++;
                currentPosition = currentPosition.translate(currentDirection.asCoordinates());
            }
        }
        setAnswer(numOfInfected);
    }

}
