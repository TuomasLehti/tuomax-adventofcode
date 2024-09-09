package fi.tuomax.adventofcode.year2022.day14;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.Coordinates;

public class SetOfCoordinates 
{

    public Set<Coordinates> coordinates = new HashSet<>();

    private Long left = Long.MAX_VALUE;
    private Long top = Long.MAX_VALUE;
    private Long right = Long.MIN_VALUE;
    private Long bottom = Long.MIN_VALUE;

    private Coordinates topLeft = null;
    private Coordinates bottomRight = null;

    public Coordinates getTopLeft()
    {
        searchMinAndMax();
        return topLeft;
    }

    public Coordinates getBottomRight()
    {
        searchMinAndMax();
        return bottomRight;
    }

    private void searchMinAndMax()
    {
        for (Coordinates c : coordinates) {
            left = Math.min(left, c.x());
            top = Math.min(top, c.y());
            right = Math.max(right, c.x());
            bottom = Math.max(bottom, c.y());
        }
        topLeft = new Coordinates(left, top);
        bottomRight = new Coordinates(right, bottom);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        searchMinAndMax();
        for (long row = top; row <= bottom; row++) {
            for (Long col = left; row <= right; col++) {
                sb.append(coordinates.contains(new Coordinates(col, row)) ? "#" : ".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    
}
