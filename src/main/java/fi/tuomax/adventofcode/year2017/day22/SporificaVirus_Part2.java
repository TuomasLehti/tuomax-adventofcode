package fi.tuomax.adventofcode.year2017.day22;

import fi.tuomax.adventofcode.commons.Direction.TurnDirection;
import fi.tuomax.adventofcode.framework.solving.Metadata;

/**
 * <p>Solves Advent of Code 2017, day 22, part 2:
 * Sporifica Virus.</p>
 *
 * @see
 *      <a href="https://adventofcode.com/2017/day/22">
 *      Puzzle on the Advent of Code website.</a></p>
 */
public class SporificaVirus_Part2
extends SporificaVirus_Part1
{

    @Override
    protected Metadata manufactureMetadata()
    {
        return new Metadata(
            2017, 22, 2,
            "Sporifica Virus", ""
        );
    }

    protected void step()
    {
        switch (getInfectionStatus()) {
            
            case CLEAN:
                infected.add(currentPosition, InfectionStatus.WEAKENED);
                currentDirection = currentDirection.turn(TurnDirection.LEFT);
                break;
            
            case WEAKENED:
                infected.add(currentPosition, InfectionStatus.INFECTED);
                numOfInfected++;
                break;

            case INFECTED:
                currentDirection = currentDirection.turn(TurnDirection.RIGHT);
                infected.add(currentPosition, InfectionStatus.FLAGGED);
                break;

            case FLAGGED:
                currentDirection = currentDirection.turn(TurnDirection.RIGHT);
                currentDirection = currentDirection.turn(TurnDirection.RIGHT);
                infected.add(currentPosition, InfectionStatus.CLEAN);
                break;
        }
    }


}
