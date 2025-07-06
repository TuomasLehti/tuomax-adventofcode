package fi.tuomax.adventofcode.year2017.day22;

import fi.tuomax.adventofcode.framework.solving.Metadata;
import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;
import fi.tuomax.adventofcode.commons.Direction.TurnDirection;
import fi.tuomax.adventofcode.framework.parsing.Parser;
import fi.tuomax.adventofcode.framework.solving.Solver;
import fi.tuomax.adventofcode.year2017.day21.SparseGrid;

import java.util.List;

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

    protected SparseGrid<InfectionStatus> infected;

    private Integer numOfBursts;

    protected Coordinates currentPosition;

    protected Direction currentDirection;

    protected Long numOfInfected = 0L;

    private void fetchParams()
    {
        numOfBursts = getParamInt("num_of_bursts");
        infected = ((SporificaVirus_Parser) parser).getStatusMap();
        Integer mapSize = ((SporificaVirus_Parser) parser).getMapSize();
        currentPosition = Coordinates.fromInteger(mapSize / 2, -mapSize / 2);
        currentDirection = Direction.getInstance(Direction.NORTH);
    }

    protected InfectionStatus getInfectionStatus()
    {
        return 
            infected.exists(currentPosition) 
                ? infected.get(currentPosition) 
                : InfectionStatus.CLEAN;
    }

    protected void step()
    {
        if (getInfectionStatus() == InfectionStatus.INFECTED) {
            currentDirection = currentDirection.turn(TurnDirection.RIGHT);
            infected.add(currentPosition, InfectionStatus.CLEAN);
        } else {
            currentDirection = currentDirection.turn(TurnDirection.LEFT);
            infected.add(currentPosition, InfectionStatus.INFECTED);
            numOfInfected++;
        }
    }

    @Override
    protected void solve()
    {
        fetchParams();
        for (long burstIdx = 0; burstIdx < numOfBursts; burstIdx++) {
            if (burstIdx % 250_000 == 0)
                System.out.println(burstIdx);
            step();
            currentPosition = currentPosition.translate(currentDirection.asCoordinates());
        }
        System.out.println(numOfBursts);
        setAnswer(numOfInfected);
    }

}
