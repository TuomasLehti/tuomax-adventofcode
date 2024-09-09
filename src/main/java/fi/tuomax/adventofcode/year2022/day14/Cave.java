package fi.tuomax.adventofcode.year2022.day14;

import java.util.HashSet;
import java.util.Set;

import fi.tuomax.adventofcode.commons.Coordinates;

public class Cave {

    private Set<Coordinates> coordinates = new HashSet<>();

    public Set<Coordinates> getCoordinates() 
    {
        return coordinates;
    }

    private Coordinates topLeft = null;

    public Coordinates getTopLeft() 
    {
        return topLeft;
    }

    private Coordinates bottomRight = null;

    public Coordinates getBottomRight() 
    {
        return bottomRight;
    }

    public void addRock(Coordinates position)
    {
        coordinates.add(position);
        long left = Math.min(position.x(), topLeft != null ? topLeft.x() : Long.MAX_VALUE);
        long right = Math.max(position.x(), bottomRight != null ? bottomRight.x() : Long.MIN_VALUE);
        long top = Math.min(position.y(), topLeft != null ? topLeft.y() : Long.MAX_VALUE);
        long bottom = Math.max(position.y(), bottomRight != null ? bottomRight.y() : Long.MIN_VALUE);
        topLeft = new Coordinates(left, top);
        bottomRight = new Coordinates(right, bottom);
    }

    public Boolean containsRock(Coordinates position)
    {
        return coordinates.contains(position);
    }
    
    public String print()
    {
        StringBuilder sb = new StringBuilder();
        for (long row = getTopLeft().y(); row <= getBottomRight().y(); row++) {
            for (Long col = getTopLeft().x(); col <= getBottomRight().x(); col++) {
                sb.append(coordinates.contains(new Coordinates(col, row)) ? "#" : ".");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
