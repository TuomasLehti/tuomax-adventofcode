package fi.tuomax.adventofcode.year2017.day19;

import java.util.HashMap;
import java.util.Map;

import fi.tuomax.adventofcode.commons.Coordinates;
import fi.tuomax.adventofcode.commons.Direction;

/**
 * The diagram, or the map.
 */
public class Diagram 
{

    private Map<Coordinates, Character> diagram = new HashMap<>();

    public void addPath(int col, int row, char c)
    {
        if (c != ' ')
            diagram.put(Coordinates.fromInteger(col, row), c);
    }

    public Boolean isPath(Coordinates coords)
    {
        return diagram.keySet().contains(coords);
    }

    public String getLetter(Coordinates coords)
    {
        if (Character.isLetter(diagram.get(coords)))
            return diagram.get(coords) + "";
        else
            return "";
    }

    public Boolean isDeadEnd(Coordinates coords)
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

    public Boolean isCorner(Coordinates coords)
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

    public Boolean hasExit(Coordinates coords, int dir)
    {
        return diagram.get(coords.translate(Direction.getInstance(dir).asCoordinates())) != null;
    }

    
}
