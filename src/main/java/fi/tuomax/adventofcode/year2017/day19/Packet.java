package fi.tuomax.adventofcode.year2017.day19;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;

/**
 * The sorry little packet who got lost.
 */
public class Packet 
{

    private Coordinates currentPos = Coordinates.ORIGIN;

    private Direction dir = Direction.getInstance(Direction.SOUTH);
    
    private Diagram diagram;

    private String letters = ""; // answer for part 1

    public String getLetters() 
    {
        return letters;
    }

    public Packet(Diagram diagram)
    {
        this.diagram = diagram;
    }

    public void findTheWay()
    {
        findStartinfPosition();

        do {
            travelToNextCorner();
            determineNextDirection();
        } while (!diagram.isDeadEnd(currentPos));

    }

    private void findStartinfPosition()
    {
        while (!diagram.isPath(currentPos)) {
            currentPos = currentPos.translate(Direction.getInstance(Direction.EAST).asCoordinates());
        }
    }

    private void travelToNextCorner()
    {
        Coordinates nextPos = null;
        do {
            nextPos = currentPos.translate(dir.asCoordinates());
            letters += diagram.getLetter(nextPos);
            currentPos = nextPos;
        } while (!(diagram.isCorner(nextPos) || diagram.isDeadEnd(nextPos)));
    }

    private void determineNextDirection()
    {
            if (dir.get() == Direction.SOUTH || dir.get() == Direction.NORTH) {
                if (diagram.hasExit(currentPos, Direction.WEST))
                    dir = Direction.getInstance(Direction.WEST);
                else if (diagram.hasExit(currentPos, Direction.EAST))
                    dir = Direction.getInstance(Direction.EAST);
            } else {
                if (diagram.hasExit(currentPos, Direction.NORTH))
                    dir = Direction.getInstance(Direction.NORTH);
                else if (diagram.hasExit(currentPos, Direction.SOUTH))
                    dir = Direction.getInstance(Direction.SOUTH);
            }

    }
    
}
