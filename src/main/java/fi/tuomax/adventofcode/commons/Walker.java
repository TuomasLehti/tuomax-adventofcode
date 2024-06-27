package fi.tuomax.adventofcode.commons;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A walker, but not a random one, keeps track where he has been.
 */
public class Walker 
{

    /**
     * Maps the characters which describe directions in the puzzle (^v<>) to 
     * a change in coordinates.
     */
    private Map<Character, Coordinates> translations = new HashMap<>();

    protected Set<Coordinates> visited = new HashSet<>();
    
    public Set<Coordinates> getVisited() 
    {
        return visited;
    }

    public Integer numOfVisited()
    {
        return visited.size();
    }

    /**
     * The coordinates, in which the walker currently is.
     */
    private Coordinates current = Coordinates.ORIGIN;

    public Coordinates getCurrentCoords() 
    {
        return current;
    }

    /**
     * Creates a new walker. They start from the origin, thus the coordinates
     * (0, 0) will always be visited.
     */
    public Walker()
    {
        populateTranslations();
        visited.add(current);
    }

    /**
     * Takes a step in a given direction.
     * @param direction
     *      A character from puzzle input.
     * @deprecated
     *      Please use ``step(direction)``.
     */
    @Deprecated
    public void walk(Character direction)
    {
        current = current.translate(translations.get(direction));
        visited.add(current);
    }

    private void populateTranslations() {
        translations.put('>', new Coordinates(1l, 0l));
        translations.put('^', new Coordinates(0l, -1l));
        translations.put('<', new Coordinates(-1l, 0l));
        translations.put('v', new Coordinates(0l, 1l));
    }

    /**
     * Takes a step in a given direction.
     */
    public void step(Direction direction)
    {
        current = current.translate(direction.asCoordinates());
        /* Has to be checked before adding the coordinates to the visited set.
         * Otherwise would always be in visited coordinates. */
        atVisitedCoordinates = visited.contains(current);
        visited.add(current);
    }

    /**
     * The starting state is that the walker is in the origin and has visited 
     * it.
     */
    private Boolean atVisitedCoordinates = true;

    /**
     * Returns whether the walker currently is at a location where he has
     * visited previously.
     */
    public Boolean isAtVisitedCoordinates()
    {
        return atVisitedCoordinates;
    }
    
}
